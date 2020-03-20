package cart.hat.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import cart.hat.demo.bean.Product;
import cart.hat.demo.dao.ProductDao;
import cart.hat.demo.service.ProductService;

public class ProductServiceImpl implements ProductService {
	@Autowired
	  ProductDao productDao;
	
	public List<Product> getProductList() {
				return productDao.getProductList();
		
	}
	
	public void insertProduct(Product product) {
		
		    productDao.insertProduct(product);
		  }
		
	}	

