package com.gcu.ordermanagement.data.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("PRODUCTS")
public class ProductEntity {
	
	@Id
	Long Id;
	
	@Column("PRODUCT_ID")
	Long productId;
	
	@Column("PRODUCT_NAME")
	String productName;
	
	@Column("DESCRIPTION")
	String productDescription;
	
	@Column("PRICE")
	float productPrice;
	
	@Column("QUANTITY")
	int quantity;
	
	public ProductEntity(long inId, Long inputId, String inputName, String inputDescription, float inputPrice, int inputQuantity) {
		setId(inId);
		setProductId(inputId);
		setProductName(inputName);
		setProductDescription(inputDescription);
		setProductPrice(inputPrice);
		setProductQuantity(inputQuantity);
	}
	
	public ProductEntity() {
		
	}

	//Setters

	public void setId(Long input) {
		Id = input;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
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
	public Long getId() {
		return Id;
	}
	
	public Long getProductId() {
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
