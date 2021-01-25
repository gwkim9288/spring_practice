package com.gwkim.spring.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.gwkim.spring.domain.SampleDTO;
import com.gwkim.spring.domain.SampleDTOList;
import com.gwkim.spring.domain.TodoDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {

	static public Logger log = LoggerFactory.getLogger(SampleController.class.getName());
	
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
	
	//�Ķ������ ������ ��ȯ
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name")String name , @RequestParam("age")int age) {
		log.info("name : "+name);
		log.info("age:" + age);
		return "ex02";
		
	}
	
	//����Ʈ  ó��
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids")ArrayList<String> ids) {
		log.info("ids:"+ids);
		
		return "ex02List";
	}
	
	//�迭 ó��
	@GetMapping("/ex02Array")
	public String ex02Array(@RequestParam("ids")String[] ids) {
		log.info("array ids:"+Arrays.toString(ids));
		return "ex02Array";
	}
	
	//��ü ����Ʈ
	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDTOList list) {
		log.info("list dtos:" +list);
		return "ex02Bean";
	}
	
	//��¥ ��ȯ
	@GetMapping("/ex03")
	public String ex03 (TodoDTO todo) {
		log.info("todo:"+todo);
		return "ex03";
	}
	
	//@ModelArrtibute �� Ȱ���� ���޵��� ���� ������ �ٽ� ����
	@GetMapping("/ex04")
	public String ex04 (SampleDTO dto , @ModelAttribute("page")int page) {
		log.info("dto:"+dto);
		log.info("page:"+page);
		
		return "/sample/ex04";
	}
	
	//-------Controller�� ���� ���� return Ÿ��-----------------------//
	
	//void : ȣ���ϴ� url �� ������ �̸��� jsp�� �ǹ�
	@GetMapping ("/ex05")
	public void ex05() {
		log.info("/ex05.........");
	}
	
	//String : jsp�� �̿��ϴ� ��� jsp������ ��ο� �����̸��� ��Ÿ���� ���� ���
	
	//��ü Ÿ��(DTO,VO) : �ַ� json Ÿ���� �����͸� ���� ��ȯ�ϴ� �뵵
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {
		log.info("/ex06.............");
		
		SampleDTO dto = new SampleDTO();
		dto.setAge(10);;
		dto.setName("gwkim");
		
		return dto;
	}
	
	//ResponseEntity : �����Ҷ� http��� ������ ������ �����ϴ� �뵵
	@GetMapping("/ex07")
	public ResponseEntity<String> ex07(){
		log.info("/ex07..........");
		
		//{"name" : "gwkim"}
		String msg = "{\"name\": \"gwkim\"}";
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");
		
		return new ResponseEntity<>(msg,header,HttpStatus.OK);
	}
	
	//���� ���ε� ó��
	@GetMapping("/exUpload")
	public void exUpload() {
		log.info("/exUpload...........");
	}
	
	@PostMapping("/exUpload")
	public void exUploadPost(ArrayList<MultipartFile> files) {
		
		files.forEach(file -> {
			log.info("-------------------------------");
			log.info("name:" + file.getOriginalFilename());
			log.info("size:" + file.getSize());
		});
	}
}
