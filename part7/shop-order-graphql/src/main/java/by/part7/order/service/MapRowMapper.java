package by.part7.order.service;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.jdbc.core.RowMapper;

public class MapRowMapper implements RowMapper<Map<String, Object>> {

  @Override
  public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
    ResultSetMetaData md = rs.getMetaData();
    int columns = md.getColumnCount();
    Map<String, Object> row = new HashMap<>();
    while (rs.next()) {
      for (int i = 1; i <= columns; i++) {
        row.put(md.getColumnName(i), rs.getObject(i));
      }
    }
    return row;
  }
}
