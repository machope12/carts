package cart.hat.demo.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.web.multipart.MultipartFile;

import com.mysql.cj.jdbc.Blob;

import cart.hat.demo.bean.Product;
import cart.hat.demo.dao.ProductDao;
import cart.hat.demo.jdbc.ProductMapper;

public class ProductDaoImpl implements ProductDao {

	@Autowired
	DataSource dataSource;

	@Override
	public List<Product> getProductList() {
		List<Product> productList = new ArrayList();
		String sql = "select * from student";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		productList = jdbcTemplate.query(sql, new ProductMapper());
		return productList;
	}

	@Override
	public List<Product> getProduct(int i) {
		// TODO Auto-generated method stu
		List<Product> productList = new ArrayList();
		String sql = "select * from student where productId =" + i;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		productList = jdbcTemplate.query(sql, new ProductMapper());
		return productList;
	}

	public int insertRecords(String name, Integer age, MultipartFile photo) throws IOException {
		// TODO Auto-generated method stub
		System.out.println(photo.getSize());

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		byte[] photoBytes = photo.getBytes();
		String sql = "INSERT INTO STUDENT(NAME,AGE,PHOTO) VALUES (?,?,?)";
		return jdbcTemplate.update(sql, new Object[] { name, age, photoBytes });
	}
	
	@Override
	public Blob getPhotoById(int id) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String query = "select photo from student where id=?";

		Blob photo = jdbcTemplate.queryForObject(query, new Object[] { id }, Blob.class);

		return photo;
	}

	
}
