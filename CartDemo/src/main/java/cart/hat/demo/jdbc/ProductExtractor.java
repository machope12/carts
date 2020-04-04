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
import com.mysql.cj.jdbc.Blob;

public class ProductExtractor implements ResultSetExtractor<Product> {
	public ProductExtractor() {
	}

	public Product extractData(ResultSet resultSet) throws SQLException, DataAccessException {
		Product product = new Product();
		product.setProductId(resultSet.getInt(1));
		product.setProductName(resultSet.getString(2));
		product.setProductAge(resultSet.getInt(3));
		Blob blob = (Blob) resultSet.getBlob(4);
		InputStream inputStream = blob.getBinaryStream();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[4096];
		int bytesRead = -1;
		try {
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] imageBytes = outputStream.toByteArray();
		String base64Image = Base64.getEncoder().encodeToString(imageBytes);
		product.setProductBase64Image(base64Image);
		System.out.println("image created");
		return product;
	}

}
