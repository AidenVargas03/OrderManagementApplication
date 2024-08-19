package com.gcu.ordermanagement.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.gcu.ordermanagement.data.entity.ProductEntity;
import com.gcu.ordermanagement.data.repository.ProductsRepository;

@Service
public class ProductDataService implements DataAccessInterface<ProductEntity> {

	@Autowired
	private ProductsRepository productsRepository;
	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	
	public ProductDataService(ProductsRepository inProductsRepository, DataSource inDataSource) {
		productsRepository = inProductsRepository;
		dataSource = inDataSource;
		jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	
	public List<ProductEntity> findAll() {
		
		List<ProductEntity> products = new ArrayList<ProductEntity>();
		try
		{
			Iterable<ProductEntity> productsIterable = productsRepository.findAll();
			products = new ArrayList<ProductEntity>();
			productsIterable.forEach(products::add);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public ProductEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(ProductEntity product) {
		String sql = "INSERT INTO PRODUCTS(PRODUCT_ID, PRODUCT_NAME, DESCRIPTION, PRICE, QUANTITY) VALUES(?, ?, ?, ?, ?)";
		try {
			jdbcTemplateObject.update(sql,
										product.getProductId(),
										product.getProductName(),
										product.getProductDescription(),
										product.getProductPrice(),
										product.getProductQuantity()
										);
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean update(ProductEntity product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(ProductEntity product) {
		// TODO Auto-generated method stub
		return false;
	}


}
