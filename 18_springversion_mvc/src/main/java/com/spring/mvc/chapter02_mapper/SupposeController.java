package com.spring.mvc.chapter02_mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //servlet역할
public class SupposeController {
	
	
	@Autowired
	private M2D m2d;
	
	
/*  Mapper to DAO */
	
	@GetMapping("/ex01")
	public String ex01() {
		m2d.ex01();
		return "home";
	}
	
	@GetMapping("/ex02")
	public String ex02() {
		m2d.ex02();
		return "home";
	}
	
	@GetMapping("/ex03")
	public String ex03() {
		m2d.ex03();
		return "home";
	}
	
	@GetMapping("/ex04")
	public String ex04() {
		m2d.ex04();
		return "home";
	}
	
	@GetMapping("/ex05")
	public String ex05() {
		m2d.ex05();
		return "home";
	}
	
	@GetMapping("/ex06")
	public String ex06() {
		m2d.ex06();
		return "home";
	}
	
	@GetMapping("/ex07")
	public String ex07() {
		m2d.ex07();
		return "home";
	}
	
	
}
