package com.shoppingApp.app.beans;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AllBeans {
	
	@Bean
	public ModelMapper beanModelMapper() {
		
		return new ModelMapper();
	}

}
