package com.spring.mvc.chapter01_form;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/c2v") //중복되는 경로는 Controller위에 선언하여 코드의 중복을 줄일 수 있다.
public class C2V_Ex01 {

	
	@Autowired
	private SupposeDAO supposeDAO;
	
	/*
	 * 
	 * 1) HttpServeletRequest
	 * 
	 * - 컨트롤러 클래스 메서드의 파라메타로 HttpServletRequest를 추가하여 사용한다.
	 * - setAttribute("속성명", 데이터) 메서드를 사용하여 데이터를 뷰로 전송 한다.
	 * 
	 * */
	//@GetMapping - > servlet의 doGet을 의미 
	@GetMapping("/requestEx")
	public String requestEx(HttpServletRequest request) {
		
		request.setAttribute("enrolledProductCnt", supposeDAO.getEnrolledProductCnt());
		request.setAttribute("productDTO", supposeDAO.getProductDetail());
		request.setAttribute("productList", supposeDAO.getProductList());
		request.setAttribute("productMap", supposeDAO.getProductMap());
		request.setAttribute("productMapList", supposeDAO.getProductMapList());
		
		
		
		
		
		return "chapter01_form/view";//servlet-context생각하기
		//ctrl + shift + r을 눌러서 'servlet-context'를 입력하면 프로젝트 안에서의 경로가 나오게 된다.
	}
	
	
	/*
	 * 
	 *  2) Model
	 *  
	 *  - 컨트롤러 클래스 메서드의 파라메타로 Model을 추가하여 사용한다. 
	 *  - addAddtribute("속성명", 데이터) 메서드를 사용하여 데이터를 뷰로 전송 한다.
	 * 
	 * */
	
	@GetMapping("/modelEx")
	public String modelEx(Model model) {
		
		model.addAttribute("enrolledProductCnt" , supposeDAO.getEnrolledProductCnt());
		model.addAttribute("productDTO" 		  , supposeDAO.getProductDetail());
		model.addAttribute("productList" 		  , supposeDAO.getProductList());
		model.addAttribute("productvMap" 		  , supposeDAO.getProductMap());
		model.addAttribute("productMapList"     , supposeDAO.getProductMapList());
		
		return "chapter01_form/view";
		
	}
	
	
	
	/*
	 * 
	 * 3) ModelAndView
	 * 
	 * - ModelAndView객체를 메서드 안(파라메타x)에서 생성한다.
	 * - setViewName("뷰 경로") 메서드를 사용하여 뷰 경로를 지정한다. 
	 * - setViewName() 메서드 대신 생성자의 인수로 뷰 경로를 지정할 수 있다.
	 * - addObject("속성명", 데이터) 메서드를 사용하여 데이터를 뷰로 전송 한다.
	 * - ModelAndView 객체를 return한다.
	 * - 관용적으로 객체명은 mv 혹은 mav로 사용한다.
	 * 
	 * */
	
	@GetMapping("/modelAndViewEx")
	public ModelAndView modelAndViewEx() { // return 타입은 String이 아닌 ModelAndView 클래스를 작성한다.
		
		//ModelAndView mv = new ModelAndView(); 	 // ModelAndView 객체를 생성한다.
		//mv.setViewName("chapter01_form/view");	 // 포워딩할 jsp 파일경로를 작성한다.
		
		ModelAndView mv = new ModelAndView("chapter01_form/view");
	
		mv.addObject("enrolledProductCnt" , supposeDAO.getEnrolledProductCnt()); // addObject("속성명", 데이터) 메서드를 사용하여 데이터를 뷰로 전송 한다.
		mv.addObject("productDTO" 		  , supposeDAO.getProductDetail());
		mv.addObject("productList" 		  , supposeDAO.getProductList());
		mv.addObject("productMap" 		  , supposeDAO.getProductMap());
		mv.addObject("productMapList"     , supposeDAO.getProductMapList());

		return mv;								 // ModelAndView 객체를 반환한다.
		
	}
	
	
	
	
	
	
}
