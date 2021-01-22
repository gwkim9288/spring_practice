package com.gwkim.spring.sample;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Component
@Data
@Getter
@ToString
public class Restaurant {
	
	private Chef chef;
	
	public Restaurant(Chef chef) {
		this.chef = chef;
	}
}
