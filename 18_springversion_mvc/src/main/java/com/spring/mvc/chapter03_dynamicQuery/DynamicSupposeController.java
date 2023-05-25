package com.spring.mvc.chapter03_dynamicQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dynamicQuery")
public class DynamicSupposeController {

	@Autowired
	private DynamicQueryDAO dynamicQueryDAO;
	
	@GetMapping("/ifEx")
	public String ifEx() {
		dynamicQueryDAO.ifEx();
		return "home";
	}
	
	@GetMapping("/whenEx")
	public String whenEx() {
		dynamicQueryDAO.whenEx();
		return "home";
	}
	
	@GetMapping("/otherwiseEx")
	public String otherwiseEx() {
		dynamicQueryDAO.otherwiseEx();
		return "home";
	}
	
	@GetMapping("/foreachEx01")
	public String foreachEx01() {
		dynamicQueryDAO.foreachEx01();
		return "home";
	}
	
	@GetMapping("/foreachEx02")
	public String foreachEx02() {
		dynamicQueryDAO.foreachEx02();
		return "home";
	}
	
	@GetMapping("/foreachEx03")
	public String foreachEx03() {
		dynamicQueryDAO.foreachEx03();
		return "home";
	}
	
	@GetMapping("/foreachEx04")
	public String foreachEx04() {
		dynamicQueryDAO.foreachEx04();
		return "home";
	}
	
	@GetMapping("/whereEx")
	public String whereEx() {
		dynamicQueryDAO.whereEx();
		return "home";
	}
	
	@GetMapping("/setEx")
	public String setEx() {
		dynamicQueryDAO.setEx();
		return "home";
	}
	
}
