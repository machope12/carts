package cart.hat.demo.jdbc;

import cart.hat.demo.bean.Product;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;

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
	    InputStream is = blob.getBinaryStream();

	      // Changing the order of the following two lines gives a difference in behavior:
	      System.out.format("BLOB length: %d bytes\n", blob.length());
	      try {
			System.out.format("First byte of BLOB: %c\n", is.read());
			 		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      BufferedImage bImage;
		try {
			BufferedImage bImage;
			bImage = ImageIO.read(new File("sample.jpg"));
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ImageIO.write(bImage, "jpg", bos );
			byte [] data = bos.toByteArray();
			ByteArrayInputStream bis = new ByteArrayInputStream(data);
		    BufferedImage bImage2 = ImageIO.read(bis);
		    ImageIO.write(bImage2, "jpg", new File("output.jpg") );
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	     
	      
	      
	      System.out.println("image created");	
		return product;
	}

}
