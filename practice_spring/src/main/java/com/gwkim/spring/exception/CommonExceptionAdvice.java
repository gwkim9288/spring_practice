package com.gwkim.spring.exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.log4j.Log4j;

@ControllerAdvice
@Log4j
public class CommonExceptionAdvice {
	
	static public Logger log = LoggerFactory.getLogger(CommonExceptionAdvice.class.getName());
	
	@ExceptionHandler(Exception.class)
	public String except(Exception ex, Model model) {
		log.error("Exception..........."+ex.getMessage());
		model.addAttribute("ex ception",ex);
		return "error_page";
	}
}
