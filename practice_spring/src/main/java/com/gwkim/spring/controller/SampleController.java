package com.gwkim.spring.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gwkim.spring.domain.SampleDTO;
import com.gwkim.spring.domain.SampleDTOList;
import com.gwkim.spring.domain.TodoDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {

	static public Logger log = Logger.getLogger(SampleController.class.getName());
	
	@RequestMapping("")
	public void basic() {
		
		log.info("basic................");
	}
	
	@RequestMapping(value = "/basic",method = {RequestMethod.GET,RequestMethod.POST})
	public void basicGet() {
		log.info("basic get...............");
	}
	
	@GetMapping("/basicOnlyGet")
	public void basicGet2() {
		log.info("basic get only get....................");
	}
	
	@GetMapping("/gwkim")
	public String ex01(SampleDTO dto) {
		log.info("" + dto);
		
		return "ex01";
	}
	
	//파라미터의 수집과 변환
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name")String name , @RequestParam("age")int age) {
		log.info("name : "+name);
		log.info("age:" + age);
		return "ex02";
		
	}
	
	//리스트  처리
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids")ArrayList<String> ids) {
		log.info("ids:"+ids);
		
		return "ex02List";
	}
	
	//배열 처리
	@GetMapping("/ex02Array")
	public String ex02Array(@RequestParam("ids")String[] ids) {
		log.info("array ids:"+Arrays.toString(ids));
		return "ex02Array";
	}
	
	//객체 리스트
	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDTOList list) {
		log.info("list dtos:" +list);
		return "ex02Bean";
	}
	
	//날짜 변환
	@GetMapping("/ex03")
	public String ex03 (TodoDTO todo) {
		log.info("todo:"+todo);
		return "ex03";
	}
	
	//@ModelArrtibute 를 활용해 전달되지 않을 정보도 다시 전달
	@GetMapping("/ex04")
	public String ex04 (SampleDTO dto , @ModelAttribute("page")int page) {
		log.info("dto:"+dto);
		log.info("page:"+page);
		
		return "/sample/ex04";
	}
	
	//-------Controller의 여러 가지 return 타입-----------------------//
	
	//void : 호출하는 url 과 동일한 이름의 jsp를 의미
	@GetMapping ("/ex05")
	public void ex05() {
		log.info("/ex05.........");
	}
	
	//String : jsp를 이용하는 경우 jsp파일의 경로와 파일이름을 나타내기 위해 사용
	
	//객체 타입(DTO,VO) : 주로 json 타입의 데이터를 만들어서 봔환하는 용도
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {
		log.info("/ex06.............");
		
		SampleDTO dto = new SampleDTO();
		dto.setAge(10);;
		dto.setName("gwkim");
		
		return dto;
	}
	
	//ResponseEntity : 응답할때 http헤더 정보와 내용을 가공하는 용도
	@GetMapping("/ex07")
	public ResponseEntity<String> ex07(){
		log.info("/ex07..........");
		
		//{"name" : "gwkim"}
		String msg = "{\"name\": \"gwkim\"}";
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");
		
		return new ResponseEntity<>(msg,header,HttpStatus.OK);
	}
}
