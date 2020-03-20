package cart.hat.demo.jdbc;

import java.sql.ResultSet;
import cart.hat.demo.bean.Product;

public class ProductMapper implements org.springframework.jdbc.core.RowMapper<Product>
{
  public ProductMapper() {}
  
  public Product mapRow(ResultSet resultSet, int line) throws java.sql.SQLException
  {
    ProductExtractor productExtractor = new ProductExtractor();
    return productExtractor.extractData(resultSet);
  }
}