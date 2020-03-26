package cart.hat.demo.dao;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import cart.hat.demo.bean.Product;
import cart.hat.demo.dao.ProductDao;
import cart.hat.demo.jdbc.ProductMapper;

public class ProductDaoImpl implements ProductDao {

	@Autowired
	DataSource dataSource;

	public List<Product> getProductList() {
		List<Product> productList = new ArrayList();
		String sql = "select * from product";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		productList = jdbcTemplate.query(sql, new ProductMapper());
		return productList;
	}

	public void insertProduct(Product product) {
		String sql = "insert into product (productName,productCategory) values(?,?)";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql, new Object[] { product.getProductName(), product.getProductCategory() });
	}

	public List<Product> getProduct(int i) {
		// TODO Auto-generated method stu
		List<Product> productList = new ArrayList();
		String sql = "select * from product where productId =" + i;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		productList = jdbcTemplate.query(sql, new ProductMapper());
		return productList;
	}

}
