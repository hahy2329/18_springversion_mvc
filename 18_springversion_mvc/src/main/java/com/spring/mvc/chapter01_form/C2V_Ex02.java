package com.spring.mvc.chapter01_form;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/c2v") //중복되는 경로는 Controller위에 선언하여 코드의 중복을 줄일 수 있다.
public class C2V_Ex02 {

	/*
	 * 
	 *	# 예시 1) @ResponseBody  
	 *	
	 *	- ResponseEntity와 기능이 같으며 헤더와 상태 코드를 제외한 HTML 본문만 전송한다.
	 * 	- 한글 데이터가 전송이 되지 않아서 한글 데이터 전송시 ReponseEntity에 헤더를 추가하여 사용한다.
     *
	 */
	
	@GetMapping("/responseBodyEx")
	@ResponseBody 
	public String responseBodyEx(HttpServletRequest request) {
		
		String jsScript = "<script>";
			   jsScript += "alert('send message');";
			   //jsScript += "location.href='requestEx';";
			   // request.getContextPath(); 메서드를 사용하여 프로젝트(3level 패키지)경로를 가져온다.
			   jsScript += "location.href='" + request.getContextPath() + "/c2v/requestEx';";
			   jsScript += "</script>";
		
		return jsScript;
		
	}
	
	
	
	/*
	 * 
	 *	 # 2) ResponseEntity
	 *	 
	 *	 - HTTP에서 Request와 Response 동작시 전송되는 정보는 크게 body(몸체) , headers(헤더), status code(상태 코드)가 있다.
	 *	 - @ResponseBody에 없는 헤더와 상태코드를 함께 반환한다.
	 *		
	 *	 - body (옵션)
	 *		- HTTP의 request 또는 response가 전송하는 데이터(본문)
	 *		
	 *	 - headers (옵션)
	 *		- HTTP의 request 또는 response에 대한 부가적인 정보
	 *		
	 *		(한글 헤더 참고)
	 *		HttpHeaders responseHeaders = new HttpHeaders();
	 *		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
	 *
	 *	 - status code (필수)
	 *		- 클라이언트의 요청이 성공적으로 처리되었는지 상태를 알려주는 것
	 * 
	 */
	@GetMapping("/responseEntityEx")
	public ResponseEntity<Object> responseEntityEx(HttpServletRequest request) {
		
		//1)
		//return new ResponseEntity<Object>(HttpStatus.OK);
		
		String jsScript = "<script>";
			   jsScript += "alert('확인되었습니다.');";
			   //jsScript += "location.href='requestEx';";
			   jsScript += "location.href='" + request.getContextPath() + "/c2v/requestEx';";
			   jsScript += "</script>";
		//2)
		//return new ResponseEntity<Object>(jsScript , HttpStatus.OK);
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		//3)
	    return new ResponseEntity<Object>(jsScript , responseHeaders , HttpStatus.OK);
		
	
	}
	
}


/*
 *
 *	# 3) @RestController 이용 
 *
 *  - @ResponseController 어노테이션이 추가된 컨트롤러는 기본 반환 타입(String)이 뷰 경로로 구현되지 않고 @ResponseBody로 구현된다.	
 *	- ResponseBody와 기능이 같으며 헤더와 상태 코드를 제외한 HTML 본문만 전송한다.
 *	- 메서드가 아닌 '클래스'에 @RestController어노테이션을 작성하여 구현한다.  
 *
 */

@RestController
class RestControllerEx {
	
	@GetMapping("/restControllerEx")
	public String restControllerEx(HttpServletRequest request) {
		
		String jsScript = "<script>";
			   jsScript += "alert('send message');";
			   jsScript += "location.href='"+request.getContextPath()+"/c2v/requestEx';";
			   jsScript += "</script>";
		
		return jsScript;
		
	}
}












