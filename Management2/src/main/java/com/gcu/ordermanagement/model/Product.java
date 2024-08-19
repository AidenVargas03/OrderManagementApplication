package com.gcu.ordermanagement.model;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Product {
	//Create our properties, with validation checks
	@NotNull(message="Product ID is a required field")
    private Long productId;
	
	@NotNull(message="Product name is a required field")
	@Size(min=1, message="Product Name must not be empty")
    private String productName;
	
	@NotNull(message="Product Description is a required field")
	@Size(min=1, message="Product Name must not be empty")
    private String productDescription;
	
    //BigDecimal has better precision.
	@NotNull(message="Product Price is a required field")
    private float productPrice;
	
	@NotNull(message="Product Quantity is a required field")
    private int productQuantity;
	
    //Constructor that utilizes the setters
	public Product(Long inputId, String inputName, String inputDescription, float inputPrice, int inputQuantity) {
		setProductId(inputId);
		setProductName(inputName);
		setProductDescription(inputDescription);
		setProductPrice(inputPrice);
		setProductQuantity(inputQuantity);
	}
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	//Setters
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	//Getters
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
		return productQuantity;
	}




    

}
