package cart.hat.demo.jdbc;

import cart.hat.demo.bean.Product;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class ProductExtractor implements ResultSetExtractor<Product>
{
  public ProductExtractor() {}
  
  public Product extractData(ResultSet resultSet) throws SQLException, DataAccessException
  {
    Product product = new Product();
    product.setProductName(resultSet.getString(1));
    product.setProductCategory(resultSet.getString(2));
    return product;
  }  
}
  
 