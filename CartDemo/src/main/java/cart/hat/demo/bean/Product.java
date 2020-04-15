package cart.hat.demo.bean;

import java.awt.Image;
import java.sql.Blob;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class Product {

	private String productName;
	private String productCategory;
	private String productDescription;
	private float productPrice;
	private String productCondition;
	private String productStatus;
	private int unitsInStock;
	private String productManufactor;
	private int productId;
	private CommonsMultipartFile productPhoto;
	private Integer productAge;

	private Image productImage;
	private String productBase64Image;

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

	public Integer getProductAge() {
		return productAge;
	}

	public void setProductAge(Integer productAge) {
		this.productAge = productAge;
	}

	public Image getProductImage() {
		return productImage;
	}

	public void setProductImage(Image productImage) {
		this.productImage = productImage;
	}

	public String getProductBase64Image() {
		return productBase64Image;
	}

	public CommonsMultipartFile getProductPhoto() {
		return productPhoto;
	}

	public void setProductPhoto(CommonsMultipartFile productPhoto) {
		this.productPhoto = productPhoto;
	}

	public float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}

}
