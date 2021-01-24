package com.gwkim.spring.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class TodoDTO {

	private String title;
	
	@DateTimeFormat(pattern = "yyyy/mm/dd")  // @initBinder 로 날짜 변환을 하는 것보다 이 방식이 권장됨
	private Date dueDate;
}
