package com.spring.mvc.chapter02_mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.mvc.dto.ProductDTO;

@Repository //dao선언 
public class M2D {
	
	@Autowired//sql선언
	private SqlSession sqlSession;
	
	
	
	
	// DTO List 반환 예시1
	public void ex01() {
		
		System.out.println("\n - ex01 - \n");
		List<ProductDTO> productList = sqlSession.selectList("m2d.ex01");
		//ArrayList이지만 스프링에선 List(인터페이스)로 한다.
		for (ProductDTO productDTO : productList) {
			System.out.println(productDTO);
		}
	}
	
	// DTO List 반환 예시2
	public void ex02() {
		
		System.out.println("\n - ex02 - \n");
		
	}
	
	
	// DTO 반환 예시1
	public void ex03() {
		
		System.out.println("\n - ex03 - \n");
		
	}
	
	
	// DTO 반환 예시2
	public void ex04() {
		
		System.out.println("\n - ex04 - \n");
		
	}
	
	
	// 단일 데이터 반환 예시1
	public void ex05() {
		
		System.out.println("\n - ex05 - \n");
		
	}
	
	
	
	// 단일 데이터 반환 예시2
	public void ex06() {
		
		System.out.println("\n - ex06 - \n");
		
	}
	
	
	// 단일 데이터 반환 예시3
	public void ex07() {
		
		System.out.println("\n - ex07 - \n");
		
		
	}
}
