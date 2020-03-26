package cart.hat.demo.service;

import java.util.List;
import cart.hat.demo.bean.Product;

public interface ProductService {		
	
	public abstract void insertProduct(Product product);
	public abstract List<Product> getProductList();
	public abstract List<Product> getProduct(int i);	
}
