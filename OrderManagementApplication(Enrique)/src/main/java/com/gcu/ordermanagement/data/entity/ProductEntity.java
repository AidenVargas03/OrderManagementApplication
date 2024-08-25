package com.gcu.ordermanagement.data.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="products")
public class ProductEntity {
	
	@Id
	String id;
	
	@Indexed(unique=true)
	String productId;
	
	@Indexed(unique=true)
	String productName;
	
	String productDescription;
	float productPrice;
	int quantity;
	
	public ProductEntity(String inId, String inProductId, String inputName, String inputDescription, float inputPrice, int inputQuantity) {
		setId(inId);
		setProductId(productId);
		setProductName(inputName);
		setProductDescription(inputDescription);
		setProductPrice(inputPrice);
		setProductQuantity(inputQuantity);
	}
	
	public ProductEntity() {
		
	}

	//Setters

	public void setId(String input) {
		id = input;
	}
	public void setProductId(String inProductId) {
		productId = inProductId;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setProductQuantity(int productQuantity) {
		this.quantity = productQuantity;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	//Getters
	public String getId() {
		return id;
	}
	
	public String getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public float getProductPrice() {
		return productPrice;
	}

	public int getProductQuantity() {
		return quantity;
	}


}
