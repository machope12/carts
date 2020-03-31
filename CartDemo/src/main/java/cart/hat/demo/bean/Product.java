package cart.hat.demo.bean;

import org.springframework.web.multipart.MultipartFile;

import com.mysql.cj.jdbc.Blob;

public class Product {

	private String productName;
	private String productCategory;
	private String productDescription;
	private double productPrice;
	private String productCondition;
	private String productStatus;
	private int unitsInStock;
	private String productManufactor;
	private int productId;
	private MultipartFile photo;
	private String name;
	private Integer age;
	private Blob picture;

	public Blob getPicture() {
		return picture;
	}

	public void setPicture(Blob picture) {
		this.picture = picture;
	}

	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public MultipartFile getPhoto() {
		return photo;
	}

	public void setFile(MultipartFile photo) {
		this.photo = photo;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int i) {
		this.productId = i;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductCondition() {
		return productCondition;
	}

	public void setProductCondition(String productCondition) {
		this.productCondition = productCondition;
	}

	public String getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}

	public int getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(int unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	public String getProductManufactor() {
		return productManufactor;
	}

	public void setProductManufactor(String productManufactor) {
		this.productManufactor = productManufactor;
	}

}
