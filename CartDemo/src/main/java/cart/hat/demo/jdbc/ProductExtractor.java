package cart.hat.demo.jdbc;

import cart.hat.demo.bean.Product;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import java.sql.Blob;

public class ProductExtractor implements ResultSetExtractor<Product> {
	public ProductExtractor() {
	}

	public Product extractData(ResultSet resultSet) throws SQLException, DataAccessException {
		Product product = new Product();
		product.setProductId(resultSet.getInt(1));
		product.setProductName(resultSet.getString(2));		
		product.setBlob((Blob) resultSet.getBlob(3));		
		product.setProductAge(resultSet.getInt(4));
		return product;
	}

}
