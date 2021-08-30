package by.part7.order.service;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;

public class FindOrderDataFetcher implements DataFetcher<List<Map<String, Object>>> {

  private final JdbcTemplate jdbcTemplate;

  public FindOrderDataFetcher(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public List<Map<String, Object>> get(DataFetchingEnvironment env) throws Exception {
    return jdbcTemplate.query("select * from payment_order", new MapRowMapper());
  }
}
