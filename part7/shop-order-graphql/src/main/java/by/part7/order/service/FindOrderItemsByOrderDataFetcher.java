package by.part7.order.service;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;

public class FindOrderItemsByOrderDataFetcher implements DataFetcher<List<Map<String, Object>>> {

  private final JdbcTemplate jdbcTemplate;

  public FindOrderItemsByOrderDataFetcher(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public List<Map<String, Object>> get(DataFetchingEnvironment env) throws Exception {
    final int id = env.getArgument("id");
    return jdbcTemplate.query("select * from payment_order_item where order_id = ?", new MapRowMapper(), id);
  }
}
