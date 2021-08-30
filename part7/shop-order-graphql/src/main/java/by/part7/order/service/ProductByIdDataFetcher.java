package by.part7.order.service;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class ProductByIdDataFetcher implements DataFetcher<CompletableFuture<Map<String, Object>>> {

  private final ProductService productService;

  public ProductByIdDataFetcher(ProductService productService) {
    this.productService = productService;
  }

  @Override
  public CompletableFuture<Map<String, Object>> get(DataFetchingEnvironment env) {
    final int productId = env.getArgument("product_id");
    return productService.findProduct(productId).toFuture();
  }
}
