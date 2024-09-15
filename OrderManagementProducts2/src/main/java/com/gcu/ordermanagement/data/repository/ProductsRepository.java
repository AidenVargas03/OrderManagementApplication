package com.gcu.ordermanagement.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gcu.ordermanagement.data.entity.ProductEntity;
import com.gcu.ordermanagement.model.Product;

public interface ProductsRepository extends MongoRepository<ProductEntity, String> {

ProductEntity getProductById(String id);


void deleteById(String id);

void insert(Product product);


}


