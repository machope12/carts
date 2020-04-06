package cart.hat.demo.dao;

import java.io.File;
import java.io.IOException;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import cart.hat.demo.bean.Product;


public abstract interface ProductDao {		
	public abstract List<Product> getProductList();	
	public abstract List<Product> getProduct(int i);
	public abstract int insertRecords(String name, Integer age, CommonsMultipartFile photo) throws IOException;
	public abstract Blob getPhotoById(int id);
	public abstract Blob getPhotoByIds(int id);		
	
}