package cart.hat.demo.service;

import java.util.List;
import cart.hat.demo.bean.Product;

public abstract interface ProductService {		
	
	public abstract void insertProduct(Product product);
	public abstract List<Product> getProductList(Product product);
	public abstract List<Product> getProduct(Product product);	
}
