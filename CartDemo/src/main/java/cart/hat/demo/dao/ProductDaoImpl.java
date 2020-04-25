package cart.hat.demo.dao;

import java.io.File;
import java.sql.Blob;
import java.sql.SQLException;
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
	public String insertRecords(String name, CommonsMultipartFile photo, Integer age) throws IOException {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		byte[] photoBytes = photo.getBytes();
		String sql = "INSERT INTO STUDENT(NAME,PHOTO,AGE) VALUES (?,?,?)";
		jdbcTemplate.update(sql, new Object[] { name, photoBytes, age });
		return "admin";
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
	public int delete(int i) {
		String sql = "DELETE FROM student WHERE id=" + i;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate.update(sql);
	}

	@Override
	public String updateRecords(String name, CommonsMultipartFile photo, Integer age, int id) {
		// Creates an instance of JdbcTemplate and set the DataSource.
		// We can use the template update() method to update records
		// in the database. Below we use an update() method that accepts
		// three parameters: the sql query, the parameter values and
		// the parameter data types.

		byte[] photobytes = null;
		List<Product> productList = getProduct(id);
		if (photo.isEmpty()) {
			try {
				for (int i = 0; i < productList.size(); i++) {
					photobytes = productList.get(0).getBlob().getBytes(1, (int) productList.get(0).getBlob().length());
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			photobytes = photo.getBytes();
		}

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "UPDATE student SET name = ?, photo = ?, age = ? WHERE id = ?";
		jdbcTemplate.update(sql, new Object[] { name, photobytes, age, id });
		return "admin";
	}

}