package com.gcu.ordermanagement.business;

import java.util.List;

import com.gcu.ordermanagement.model.Product;


public interface productsBusinessServiceInterface {

	public List<Product> getProducts();
	
	public void init();
	
	public void destroy();
}
