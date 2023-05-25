package com.spring.mvc.chapter03_dynamicQuery;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.mvc.dto.ProductDTO;

@Repository
public class DynamicQueryDAO {

	@Autowired
	private SqlSession sqlSession;
	
	
	// if 사용 예시
	public void ifEx() {
		
		System.out.println("\n --- ifEx --- \n");
		
		Map<String, Object> searchMap = new HashMap<String, Object>();
		//searchMap.put("searchKeyword", "enrollDt");
		//searchMap.put("searchWord", "2022");
		searchMap.put("searchKeyword", "productNm");
		searchMap.put("searchWord", "삼성전자");
		
		List<ProductDTO> productList = sqlSession.selectList("dynamicQuery.ifEx" , searchMap);
		for (ProductDTO productDTO : productList) {
			System.out.println(productDTO);
		}
		
	}
	
	
	// when 사용 예시
	public void whenEx() {
		
		System.out.println("\n --- whenEx --- \n");
		
		Map<String, Object> searchMap = new HashMap<String, Object>();
		//searchMap.put("searchKeyword", "enrollDt");
		//searchMap.put("searchWord", "2022");
		searchMap.put("searchKeyword", "productNm");
		searchMap.put("searchWord", "삼성전자");
		
		List<ProductDTO> productList = sqlSession.selectList("dynamicQuery.whenEx" , searchMap);
		for (ProductDTO productDTO : productList) {
			System.out.println(productDTO);
		}
		
	}
	
	
	// otherwise 사용 예시
	public void otherwiseEx() {
		
		System.out.println("\n --- otherwiseEx --- \n");
		
		
	}
	
	// foreach 사용 예시1
	public void foreachEx01() {
		
		System.out.println("\n --- foreachEx01 --- \n");
		
	}
	
	
	// foreach 사용 예시2
	public void foreachEx02() {
		
		System.out.println("\n --- foreachEx02 --- \n");
	
	}
	
	
	// foreach 사용 예시3
	public void foreachEx03() {
		
		System.out.println("\n --- foreachEx03 --- \n");
		
	}
	
	
	// foreach 사용 예시4
	public void foreachEx04() {
		
		System.out.println("\n --- foreachEx04 --- \n");
		
	}
	
	
	// where 사용 예시
	public void whereEx() {
		
		System.out.println("\n --- whereEx --- \n");
		
	}
	
	
	// set 사용예시
	public void setEx() {
		
		System.out.println("\n --- setEx --- \n");
		
	}
	
	
}
