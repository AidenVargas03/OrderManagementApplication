package com.gcu.ordermanagement.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.ordermanagement.model.Product;

@RestController
@RequestMapping("/service")
public class ProductsRestService {
	@Autowired
	productsBusinessServiceInterface service;

	public ProductsRestService() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping(path="/getproduct/{id}")
	public ResponseEntity<?> getProduct(@PathVariable("id") String id){
		try
		{
			Product product = service.getOrderById(id);
			if (product == null)
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			else
				return new ResponseEntity<>(product, HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(value = "/insertProduct/{product}")
	public ResponseEntity<?> insertProduct(@PathVariable("product") Product product){
		service.insert(product);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping(value = "/deleteProduct/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable("id") String id){
		service.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
