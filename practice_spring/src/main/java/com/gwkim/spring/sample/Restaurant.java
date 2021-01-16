package com.gwkim.spring.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
public class Restaurant {
	
	@Setter(onMethod = @Autowired)
	private Chef chef;
}
