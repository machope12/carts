package cart.hat.demo.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import cart.hat.demo.bean.Product;


public abstract interface ProductDao {	
	public abstract List<Product> getProductList();
	public abstract void insertProduct(Product product);
	
}