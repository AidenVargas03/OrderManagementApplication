package com.gcu.ordermanagement.data;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.gcu.ordermanagement.data.entity.ProductEntity;
import com.gcu.ordermanagement.data.repository.ProductsRepository;
import com.gcu.ordermanagement.model.Product;

@Service
public class ProductDataService implements DataAccessInterface<ProductEntity> {

	@Autowired
	private ProductsRepository productsRepository;

	public ProductDataService(ProductsRepository inProductsRepository) {
		productsRepository = inProductsRepository;
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
	public boolean create(ProductEntity product) {
		try
		{
			this.productsRepository.save(product);
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



	public ProductEntity findById(String id) {
		// TODO Auto-generated method stub
		return productsRepository.getProductById(id);
	}
	
	public void insert(Product product) {
		// TODO Auto-generated method stub
		productsRepository.insert(product);
	}
	
	  public boolean deleteById(String id) {
	        try {
	            productsRepository.deleteById(id);
	            return true;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	  }


	@Override
	public boolean delete(ProductEntity t) {
		// TODO Auto-generated method stub
		return false;
	}


}
