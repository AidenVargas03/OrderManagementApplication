package com.gcu.ordermanagement;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import com.gcu.ordermanagement.business.ProductsBusinessService;
import com.gcu.ordermanagement.business.productsBusinessServiceInterface;



@Configuration
public class OMSpringConfig {

    @Bean(name = "productsBusinessService", initMethod = "init", destroyMethod = "destroy")
    @SessionScope
    public productsBusinessServiceInterface getProductsBusiness() 
	{
		return new ProductsBusinessService();
	}
}
