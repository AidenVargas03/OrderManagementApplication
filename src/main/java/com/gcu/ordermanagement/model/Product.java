package com.gcu.ordermanagement.model;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Product {
	//Create our properties, with validation checks
	private String id;
	@NotNull(message="Product ID is a required field")
    private String productId;
	
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
    private int quantity;
	
    //Constructor that utilizes the setters
	public Product(String inId, String inProductId, String inputName, String inputDescription, float inputPrice, int inputQuantity) {
		setId(inId);
		setProductId(inProductId);
		setProductName(inputName);
		setProductDescription(inputDescription);
		setProductPrice(inputPrice);
		setProductQuantity(inputQuantity);
	}
	public Product() {
		// TODO Auto-generated constructor stub
	}

	//Setters
	public void setId(String input) {
		id = input;
	}
	public void setProductId(String productId) {
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
