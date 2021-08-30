package by.part7.order.service;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;

public class FindOrderByIdDataFetcher implements DataFetcher<Map<String, Object>> {

  private final JdbcTemplate jdbcTemplate;

  public FindOrderByIdDataFetcher(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public Map<String, Object> get(DataFetchingEnvironment env) throws Exception {
    final int id = env.getArgument("payment_info_id");
    return jdbcTemplate.queryForMap("select * from payment_order where id = ?", id);
  }
}
