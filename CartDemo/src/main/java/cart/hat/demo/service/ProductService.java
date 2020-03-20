package cart.hat.demo.service;

import java.util.List;
import cart.hat.demo.bean.Product;

public abstract interface ProductService {	
	
	public abstract List<Product> getProductList();
	public abstract void insertProduct(Product product);
}
