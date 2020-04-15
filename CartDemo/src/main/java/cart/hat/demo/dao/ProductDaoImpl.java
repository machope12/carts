package cart.hat.demo.dao;

import java.io.File;
import java.sql.Blob;
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
import org.springframework.web.multipart.commons.CommonsMultipartFile;

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
		String sql = "select * from student where Id =" + i;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		productList = jdbcTemplate.query(sql, new ProductMapper());
		return productList;
	}

	@Override
	public int insertRecords(String name, CommonsMultipartFile photo, Integer age) throws IOException {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		byte[] photoBytes = photo.getBytes();
		String sql = "INSERT INTO STUDENT(NAME,PHOTO,AGE) VALUES (?,?,?)";
		return jdbcTemplate.update(sql, new Object[] { name, photoBytes, age });
	}

	@Override
	public Blob getPhotoById(int id) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String query = "select photo from student where id=?";		
		Blob photo = jdbcTemplate.queryForObject(query, new Object[] { id }, Blob.class);
		return photo;
	}

	@Override
	public Blob getPhotoByIds(int id) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String query = "select photo from student where id=?";
		Blob photo = jdbcTemplate.queryForObject(query, new Object[] { id }, Blob.class);
		return photo;
	}

	@Override
	public int getOrderId() {
		// TODO Auto-generated method stub
		// define the range
		int rand = 0;		
		int max = 10;
		int min = 1;
		int range = max - min + 1;

		// generate random numbers within 1 to 10
		for (int i = 0; i < 10; i++) {
			rand = (int) (Math.random() * range) + min;
		}

		return rand;
	}

}
