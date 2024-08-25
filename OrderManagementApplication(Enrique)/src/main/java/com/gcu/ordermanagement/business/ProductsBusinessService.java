package com.gcu.ordermanagement.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.ordermanagement.data.ProductDataService;
import com.gcu.ordermanagement.data.entity.ProductEntity;
import com.gcu.ordermanagement.model.Product;

public class ProductsBusinessService implements productsBusinessServiceInterface {

	@Autowired
	public ProductDataService service;
	public ProductsBusinessService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Product> getProducts() {
		List<ProductEntity> productsEntity = service.findAll();
		List<Product> productsDomain = new ArrayList<Product>();
		for(ProductEntity entity : productsEntity) {
			productsDomain.add(new Product(entity.getId(), entity.getProductId(), entity.getProductName(), entity.getProductDescription(), entity.getProductPrice(), entity.getProductQuantity()));
		}
		return productsDomain;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void test() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Product getOrderById(String id) {
		ProductEntity productsEntity = service.findById(id);
		return new Product(productsEntity.getId(), productsEntity.getProductId(), productsEntity.getProductName(), productsEntity.getProductDescription(), productsEntity.getProductPrice(), productsEntity.getProductQuantity());
	}

	public void insert(Product product) {
		// TODO Auto-generated method stub
		service.insert(product);
	}
	
	public void deleteById(String id) {
		service.deleteById(id);
	}
	

}
