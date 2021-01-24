package com.gwkim.spring.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class TodoDTO {

	private String title;
	
	@DateTimeFormat(pattern = "yyyy/mm/dd")  // @initBinder �� ��¥ ��ȯ�� �ϴ� �ͺ��� �� ����� �����
	private Date dueDate;
}
