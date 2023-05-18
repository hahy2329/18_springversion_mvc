package com.spring.mvc.chapter02_mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.mvc.dto.BrandDTO;
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
		List<BrandDTO> brandList = sqlSession.selectList("m2d.ex02");
		for(BrandDTO brandDTO : brandList) {
			System.out.println(brandDTO);
			
		}
		
		
		
	}
	
	
	// DTO 반환 예시1
	public void ex03() {
		
		System.out.println("\n - ex03 - \n");
		ProductDTO productDTO = sqlSession.selectOne("m2d.ex03");
		System.out.println(productDTO);
	}
	
	
	// DTO 반환 예시2
	public void ex04() {
		
		System.out.println("\n - ex04 - \n");
		BrandDTO brandDTO = sqlSession.selectOne("m2d.ex04");
		System.out.println(brandDTO);
		
	}
	
	
	// 단일 데이터 반환 예시1
	public void ex05() {
		
		System.out.println("\n - ex05 - \n");
		int productCount = sqlSession.selectOne("m2d.ex05");
		System.out.println(productCount);
		
	}
	
	
	
	// 단일 데이터 반환 예시2
	public void ex06() {
		
		System.out.println("\n - ex06 - \n");
		double productPriceAvg = sqlSession.selectOne("m2d.ex06");
		System.out.println(productPriceAvg);
	}
	
	
	// 단일 데이터 반환 예시3
	public void ex07() {
		
		System.out.println("\n - ex07 - \n");
		String productName = sqlSession.selectOne("m2d.ex07");
		System.out.println(productName);
	}
	
	// <![CDATA[]]> 사용예시
		public void ex08() {
			
		
			System.out.println("\n - ex01 - \n");
			List<ProductDTO> productList = sqlSession.selectList("m2d.ex08");
			//ArrayList이지만 스프링에선 List(인터페이스)로 한다.
			for (ProductDTO productDTO : productList) {
				System.out.println(productDTO);
			}
			
			
			
			
		}
		
		
		// 테이블 컬럼과 자바 프로퍼티 바인딩 예시1
		public void ex09() {
			
			System.out.println("\n - ex09 - \n");
			List<Map<String,Object>> productMapList =  sqlSession.selectList("m2d.ex09");
			
			for(Map<String,Object> productMap : productMapList) {
				System.out.println(productMap);
			}
			
		}

		
		// 테이블 컬럼과 자바 프로퍼티 바인딩 예시2
		public void ex10() {
			
			System.out.println("\n - ex10 - \n");
			List<Map<String,Object>> productMapList = sqlSession.selectList("m2d.ex10");
			
			for(Map<String,Object> productMap : productMapList) {
				System.out.println(productMap);
			}
		}
		
		
		// 테이블 컬럼과 자바 프로퍼티 바인딩 예시3
		public void ex11() {
			
			System.out.println("\n - ex11 - \n");
			List<Map<String,Object>> joinMap = sqlSession.selectList("m2d.ex11");
			
			for(Map<String,Object> map : joinMap) {
				System.out.println(map);
			}
			
		}
		
	
	
	
}
