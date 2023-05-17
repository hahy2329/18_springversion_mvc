package com.spring.mvc.chapter01_form;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.spring.mvc.dto.ProductDTO;

@Repository
public class SupposeDAO {

	// 1) 단일 데이터 전송
	public int getEnrolledProductCnt() {
		return 10;
	}
	
	
	// 2) DTO 전송
	public ProductDTO getProductDetail() {
		
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductCd(1);
		productDTO.setProductNm("노트북1");
		productDTO.setBrandCd("b1");
		productDTO.setPrice(1000000);
		productDTO.setDeliveryPrice(2500);
		productDTO.setEnrollDt(new Date());
		
		return productDTO;

	}
	
	
	// 3) DTO List 전송
	public List<ProductDTO> getProductList() {
		
		List<ProductDTO> productList = new ArrayList<ProductDTO>();
		
		for (int i = 1; i < 11; i++) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setProductCd(i);
			productDTO.setProductNm("노트북 " + i);
			productDTO.setBrandCd("b" + i);
			productDTO.setPrice(100000 * i);
			productDTO.setDeliveryPrice(2500);
			productDTO.setEnrollDt(new Date());
			productList.add(productDTO);
		}

		return productList;

	}
	
	
	// 4) Map 전송
	public Map<String,Object> getProductMap() {
		
		Map<String,Object> productMap = new HashMap<String, Object>();
		
		//ProductDTO property
		productMap.put("productCd", 1);
		productMap.put("productNm", "노트북1");
		productMap.put("brandCd", "b1");
		productMap.put("price", 10000);
		productMap.put("deliveryPrice", 2500);
		productMap.put("enrollDt",  new Date());
		
		// ProductDTO property에 포함되지 않는 데이터
		productMap.put("addTax", 10000 * 0.1);
		productMap.put("totalPrice", 10000 + 10000 * 0.1);
		
		//BrandDTO property
		productMap.put("brandNm", "브랜드1");
		productMap.put("enteredDt", new Date());
		productMap.put("activeYn", "Y");

		return productMap;

	}

	
	// 5) Map List 전송
	public List<Map<String,Object>> getProductMapList() {
		
		List<Map<String,Object>> productMapList = new ArrayList<Map<String,Object>>();
		
		for (int i = 1; i < 11; i++) {
			
			Map<String,Object> productMap = new HashMap<String, Object>();
			productMap.put("productCd", i);
			productMap.put("productNm", "노트북 " + i);
			productMap.put("brandCd", "b" + i);
			productMap.put("price", 10000 * i);
			productMap.put("deliveryPrice", 2500);
			productMap.put("enrollDt",  new Date());
			
			// ProductDTO property에 포함되지 않는 데이터
			productMap.put("addTax", (10000 * i) * 0.1);
			productMap.put("totalPrice", (10000 * i) + (10000 * i) * 0.1);
			
			//BrandDTO property
			productMap.put("brandNm", "브랜드명 " + i);
			productMap.put("enteredDt", new Date());
			productMap.put("activeYn", "Y");
			productMapList.add(productMap);
			
		}
		
		return productMapList;
		
	}
	
	
}
