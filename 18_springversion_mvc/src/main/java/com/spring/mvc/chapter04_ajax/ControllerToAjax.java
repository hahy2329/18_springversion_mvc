package com.spring.mvc.chapter04_ajax;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.mvc.dto.ProductDTO;

@Controller
@RequestMapping("/ajax")
public class ControllerToAjax {

	@GetMapping("/controllerToAjax")
	public String recv() {
		return "chapter04_ajax/controllerToAjax";
	}

	
	// 1. 단일데이터 return
	@GetMapping("/c2aEx01")
	@ResponseBody
	
	public String c2aEx01() {
		return "pass";
	}

	
	// 2. DTO return
	@GetMapping("/c2aEx02")
	@ResponseBody
	public ProductDTO c2aEx02() {
		
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductCd(1);
		productDTO.setProductNm("키보드" + 1);
		productDTO.setPrice(10000);
		productDTO.setDeliveryPrice(2500);
		productDTO.setEnrollDt(new Date());
		productDTO.setBrandCd("b1");
		
		return productDTO;
		
	}
	
	
	// 3. Map return 
	@GetMapping("/c2aEx03")
	@ResponseBody
	public Map<String,Object> c2aEx03() {
		
		Map<String, Object> orderMap = new HashMap<String, Object>();
		orderMap.put("orderCd", "order1");
		orderMap.put("orderQty", 1);
		orderMap.put("cartCd", "cart1");
		orderMap.put("cartQty", 1);
		
		return orderMap;
		
	}
	
	
	// 4. List<DTO> return
	@GetMapping("/c2aEx04")
	@ResponseBody
	public List<ProductDTO> c2aEx04() {
		
		List<ProductDTO> productList = new ArrayList<ProductDTO>();
		
		for (int i = 1; i < 11; i++) {
			ProductDTO ProductDTO = new ProductDTO();
			ProductDTO.setProductCd(i);
			ProductDTO.setProductNm("키보드" +i);
			ProductDTO.setPrice(10000 * i);
			ProductDTO.setDeliveryPrice(2500);
			ProductDTO.setEnrollDt(new Date());
			ProductDTO.setBrandCd("b" + i);
			productList.add(ProductDTO);
		}
		
		return productList;
		
	}
	
	
	// 5. List<Map> return
	@GetMapping("/c2aEx05")
	@ResponseBody
	public List<Map<String, Object>> c2aEx05() {
		
		List<Map<String, Object>> orderMapList = new ArrayList<Map<String,Object>>();
		
		for (int i = 1; i < 11; i++) {
			Map<String, Object> orderMap = new HashMap<String, Object>();
			orderMap.put("orderCd", "order" + i);
			orderMap.put("orderQty", i);
			orderMap.put("cartCd", "cart" + i);
			orderMap.put("cartQty", i);
			orderMapList.add(orderMap);
		}
		
		return orderMapList;
		
	}
	
	
}
