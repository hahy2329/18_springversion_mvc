package com.spring.mvc.chapter03_dynamicQuery;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.mvc.dto.BrandDTO;
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
		
		int deliveryPrice = 0;
		//int deliveryPrice = 3000;
		
		List<ProductDTO> productList = sqlSession.selectList("dynamicQuery.otherwiseEx", deliveryPrice);
		for (ProductDTO productDTO : productList) {
			System.out.println(productDTO);
		}
	}
	
	// foreach 사용 예시1
	public void foreachEx01() {
		
		System.out.println("\n --- foreachEx01 --- \n");
		System.out.println("\n --- foreachEx01 --- \n");
		
		List<BrandDTO> brandList = new ArrayList<BrandDTO>();
		
		for (int i = 105; i < 110; i++) {
			
			BrandDTO brandDTO = new BrandDTO();
			brandDTO.setBrandCd("b" + i);
			brandDTO.setBrandNm("추가된브랜드" + i);
			brandDTO.setEnteredDt(new Date());
			brandDTO.setActiveYn("Y");
			
			brandList.add(brandDTO);
		}
		
		sqlSession.insert("dynamicQuery.foreachEx01" , brandList);
	}
	
	
	// foreach 사용 예시2
	public void foreachEx02() {
		
		System.out.println("\n --- foreachEx02 --- \n");
		
		
		String[] brandCdList = {"b1" , "b2" , "b3"};
		List<BrandDTO> brandList = sqlSession.selectList("dynamicQuery.foreachEx02" ,  brandCdList);
		for (BrandDTO brandDTO : brandList) {
			System.out.println(brandDTO);
		}
	}
	
	
	// foreach 사용 예시3
	public void foreachEx03() {
		
		System.out.println("\n --- foreachEx03 --- \n");
		String[] brandCdList = {"b100" , "b101" , "b102" , "b103" , "b104" };
		sqlSession.delete("dynamicQuery.foreachEx03" ,  brandCdList);
	}
	
	
	// foreach 사용 예시4
	public void foreachEx04() {
		
		System.out.println("\n --- foreachEx04 --- \n");
		int[] productCdList = {1,2,3,4,5,6};
		sqlSession.update("dynamicQuery.foreachEx04" ,  productCdList);
	}
	
	
	// where 사용 예시
	public void whereEx() {
		
		System.out.println("\n --- whereEx --- \n");
		ProductDTO productDTO = new ProductDTO();
		// 1) productNm과 brandCd가 모두 있을 경우 > 정상
		// 2) productNm만 있을 경우 > 정상
		// 3) brandCd만 있을 경우 > 오류
		productDTO.setProductNm("삼성");
		productDTO.setBrandCd("b1");
		
		List<ProductDTO> productList = sqlSession.selectList("dynamicQuery.whereEx" ,  productDTO);
		for (ProductDTO dto : productList) {
			System.out.println(dto);
		}
		
	}
	
	
	// set 사용예시
	public void setEx() {
		
		System.out.println("\n --- setEx --- \n");
		ProductDTO productDTO = new ProductDTO();
		// 1) price와 deliveryPrice가 모두 있을 경우 > 정상
		// 2) price만 있을 경우 > 오류
		// 3) deliveryPrice만 있을 경우 > 정상
		productDTO.setPrice(1);
		
		//productDTO.setDeliveryPrice(1);
		
		sqlSession.update("dynamicQuery.setEx" ,  productDTO);
	}
	
	
}
