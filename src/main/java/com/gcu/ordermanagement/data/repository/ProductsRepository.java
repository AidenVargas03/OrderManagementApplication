package com.gcu.ordermanagement.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gcu.ordermanagement.data.entity.ProductEntity;
import com.gcu.ordermanagement.model.Product;

public interface ProductsRepository extends MongoRepository<ProductEntity, String> {

ProductEntity getProductById(String productId);



void insert(Product product);

void deleteById(String id);

}
