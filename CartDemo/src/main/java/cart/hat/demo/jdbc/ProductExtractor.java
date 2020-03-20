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
    fund.setDaf_Id(resultSet.getInt(1));
    fund.setContact(resultSet.getInt(2));
    fund.setNameOfFund(resultSet.getString(3));
    fund.setDescription(resultSet.getString(4));
    fund.setNotes(resultSet.getString(5));
    fund.setActive(resultSet.getInt(6));    
    return product;
  }
  

  
}
  
 