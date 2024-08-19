package com.gcu.ordermanagement.data.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.gcu.ordermanagement.data.entity.ProductEntity;

public interface ProductsRepository extends CrudRepository<ProductEntity, Long> {

	@Override
	@Query(value = "SELECT * FROM PRODUCTS")
	public List<ProductEntity> findAll();
}
