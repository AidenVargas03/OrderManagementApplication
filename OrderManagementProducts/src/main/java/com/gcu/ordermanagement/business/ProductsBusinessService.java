package com.gcu.ordermanagement.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.ordermanagement.data.entity.ProductEntity;
import com.gcu.ordermanagement.data.repository.ProductsRepository;
import com.gcu.ordermanagement.model.Product;

@Service
public class ProductsBusinessService {
	
	@Autowired
	public ProductsRepository productsRepository;
	public ProductsBusinessService() {
		// TODO Auto-generated constructor stub
	}

	public List<Product> getAllProducts() {
		List<ProductEntity> productsEntity = productsRepository.findAll();
		List<Product> productsDomain = new ArrayList<Product>();
		for(ProductEntity entity : productsEntity) {
			productsDomain.add(new Product(entity.getId(), entity.getProductId(), entity.getProductName(), entity.getProductDescription(), entity.getProductPrice(), entity.getProductQuantity()));
		}
		return productsDomain;
	}

	public void init() {
		// TODO Auto-generated method stub

	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void test() {
		// TODO Auto-generated method stub
		
	}

	public Product getOrderById(String id) {
		ProductEntity entity = productsRepository.getProductById(id);
		Product productDomain = new Product();
		productDomain = (new Product(entity.getId(), entity.getProductId(), entity.getProductName(), entity.getProductDescription(), entity.getProductPrice(), entity.getProductQuantity()));
		return productDomain;
	}

	public void insert(Product product) {
		// TODO Auto-generated method stub
		productsRepository.insert(product);
	}
	
	public void deleteById(String id) {
		productsRepository.deleteById(id);
	}
	

}
