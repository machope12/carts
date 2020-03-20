package cart.hat.demo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;



import cart.hat.demo.bean.Product;
import cart.hat.demo.dao.ProductDao;

public class ProductDaoImpl implements ProductDao{
	
	@Autowired
	  DataSource dataSource;
	
		public List<Product> getProductList() {
		List<Product> fundList = new ArrayList();
	    String sql = "select * from daf_main order by name_Of_Fund";
	    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	    fundList = jdbcTemplate.query(sql, new FundRowMapper());
	    return fundList;
	}

	
	public void insertProduct(Product product) {
		 String sql = "insert into daf_main (contact,name_of_fund,Description,notes,Active) values(?,?,?,?,?)";
		    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		    jdbcTemplate.update(sql, 
		      new Object[] { Integer.valueOf(fund.getContact()), fund.getNameOfFund(), fund.getDescription(), fund.getNotes(), Integer.valueOf(fund.getActive()) });
		  }
		
	}


