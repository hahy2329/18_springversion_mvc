package com.spring.mvc.chapter02_mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.mvc.dto.BrandDTO;
import com.spring.mvc.dto.ProductDTO;

@Repository //dao선언
public class D2M {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	/*
	 * 
	 * # DAO To Mapper
	 * 
	 *  - 2개 이상의 파라미터를 Mapper로 전달할 수 없고 오직 1개의 파라미터만 전송이 가능하다.
	 *  - 2개 이상의 데이터는 DTO , Map형식으로 전송한다.
	 *  - 전송되는 복수의 데이터가 DTO의 멤버로 포함되어 있으면 일반적으로 DTO 전송 방식을 사용하고
	 *    전송되는 복수의 데이터가 DTO의 멤버에 포함되어 있지 않은 경우 Map 전송 방식을 사용한다.
	 * 
	 * */
	
	// 단일 데이터 전송 예시1
	public void sample01() {
		
		System.out.println("\n - sample01 - \n");
		
		int productCd = 1;
		sqlSession.update("d2m.sample01", productCd);
		
	}
	
	// 단일 데이터 전송 예시2
	public void sample02() {
		
		System.out.println("\n - sample02 - \n");
		
		String brandCd = "b6";
		sqlSession.update("d2m.sample02", brandCd);
	}
	
	// 단일 데이터 전송 예시3
	public void sample03() {
		
		System.out.println("\n - sample03 - \n");
		
		String brandNm = "apple";
		
		BrandDTO brandDTO = sqlSession.selectOne("d2m.sample03", brandNm);
		System.out.println(brandDTO);
	}
	
	
	// DTO 전송 예시1
	public void sample04() {
		
		System.out.println("\n - sample04 - \n");
		
		BrandDTO brandDTO = new BrandDTO();
		brandDTO.setBrandCd("add1"); // Duplicate entry '~~~' for key 'PRIMARY' : primary key 중복 에러
									 // Data too long for column				: 데이터 길이 오버플로우 에러
		brandDTO.setBrandNm("추가된브랜드");
		brandDTO.setActiveYn("N");
		
		sqlSession.insert("d2m.sample04", brandDTO);
		
	}
	
	// DTO 전송 예시2
	public void sample05() {
		
		System.out.println("\n - sample05 - \n");
		
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductNm("추가된 상품1");
		productDTO.setPrice(1);
		productDTO.setDeliveryPrice(1);
		productDTO.setBrandCd("add");
		sqlSession.insert("d2m.sample05", productDTO);
		
	}
	
	// DTO 전송 예시3
	public void sample06() {
		
		System.out.println("\n - sample06 - \n");
		
		ProductDTO productDTO = new ProductDTO();
		productDTO.setPrice(1000000);
		productDTO.setDeliveryPrice(3000);
		
		List<ProductDTO> productList = sqlSession.selectList("d2m.sample06", productDTO);
		for(ProductDTO productDTO2 : productList) {
			System.out.println(productDTO2);
		}
		
	}
	
	// Map 전송 예시1
	public void sample07() {
		
		System.out.println("\n - sample07 - \n");
		
		Map<String, Integer> priceMap = new HashMap<String, Integer>();
		priceMap.put("min", 500000);
		priceMap.put("max", 1000000);
		List<ProductDTO> productList = sqlSession.selectList("d2m.sample07", priceMap);
		for(ProductDTO productDTO : productList) {
			System.out.println(productDTO);
		}
	}
	
	
	// Map 전송 예시2
	public void sample08() {
		
		System.out.println("\n - sample08 - \n");
		
		Map<String, String> dateMap = new HashMap<String, String>();
		dateMap.put("startDate","2021-01-01");
		dateMap.put("endDate", "2021-03-31");
		List<BrandDTO> brandList =sqlSession.selectList("d2m.sample08", dateMap);
		for(BrandDTO brandDTO : brandList) {
			System.out.println(brandDTO);
		}
	}
	
	// Map 전송 예시3
	public void sample09() {
		
		System.out.println("\n - sample09 - \n");
		
		Map<String, Object> searchMap = new HashMap<String, Object>();
		searchMap.put("activeYn","N");
		searchMap.put("price", 1000000);
		
		List<Map<String, Object>> searchMapList =  sqlSession.selectList("d2m.sample09", searchMap);
		for(Map<String, Object> map : searchMapList) {
			System.out.println(map);
		}
	}
	
	
	
	
}
