package com.gcu.ordermanagement.business;

import java.util.List;

import com.gcu.ordermanagement.model.Product;


public interface productsBusinessServiceInterface {

	public void test();
	public List<Product> getProducts();
	public Product getOrderById(String id);
	public void insert(Product product);
	public boolean deleteById(String id);
	public void init();
	public void destroy();
	
}
