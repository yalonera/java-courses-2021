package by.part7.order.config;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

import by.part7.order.service.CustomerByIdDataFetcher;
import by.part7.order.service.CustomerService;
import by.part7.order.service.FindOrderByIdDataFetcher;
import by.part7.order.service.FindOrderDataFetcher;
import by.part7.order.service.FindOrderItemsByOrderDataFetcher;
import by.part7.order.service.ProductByIdDataFetcher;
import by.part7.order.service.ProductService;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import javax.annotation.PostConstruct;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import reactivefeign.webclient.WebReactiveFeign;

@Configuration
public class OrderGraphqlConfig {

  private GraphQL graphQL;

  private final JdbcTemplate jdbcTemplate;

  public OrderGraphqlConfig(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Bean
  public GraphQL graphQL() {
    return graphQL;
  }

  @PostConstruct
  public void init() throws IOException {
    URL url = OrderGraphqlConfig.class.getClassLoader().getResource("./schema.graphqls");
    Scanner sc = new Scanner(url.openStream());
    //Instantiating the StringBuffer class to hold the result
    StringBuilder sb = new StringBuilder();
    while (sc.hasNext()) {
      sb.append(sc.next());
    }
    String sdl = sb.toString();
    GraphQLSchema graphQLSchema = buildSchema(sdl);
    this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
  }

  private GraphQLSchema buildSchema(String sdl) {
    TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(sdl);
    RuntimeWiring runtimeWiring = buildWiring();
    SchemaGenerator schemaGenerator = new SchemaGenerator();
    return schemaGenerator.makeExecutableSchema(typeRegistry, runtimeWiring);
  }

  private RuntimeWiring buildWiring() {
    return RuntimeWiring.newRuntimeWiring()
        .type(newTypeWiring("Query")
            .dataFetcher("orderById", new FindOrderByIdDataFetcher(jdbcTemplate)))
        .type(newTypeWiring("Query")
            .dataFetcher("orders", new FindOrderDataFetcher(jdbcTemplate)))
        .type(newTypeWiring("Order")
            .dataFetcher("orderItems", new FindOrderItemsByOrderDataFetcher(jdbcTemplate))
            .dataFetcher("customer", new CustomerByIdDataFetcher(customerService())))
        .type(newTypeWiring("OrderItem")
            .dataFetcher("product", new ProductByIdDataFetcher(productService())))
        .build();
  }

  @Bean
  public CustomerService customerService() {
    return WebReactiveFeign
        .<CustomerService>builder()
        .target(CustomerService.class, "http://localhost:8088");
  }

  @Bean
  public ProductService productService() {
    return WebReactiveFeign
        .<ProductService>builder()
        .target(ProductService.class, "http://localhost:8001");
  }
}
