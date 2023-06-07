<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>controllerToAjax</title>
<script src="${contextPath}/resources/jquery/jquery-3.6.1.min.js"></script>
<script>

	$().ready(function(){
		
		
		// 1. 단일데이터 return
		$("#btn1").click(function(){
			
			$.ajax({
				
				url : "${contextPath}/ajax/c2aEx01",
				type : "get",
				success : function(data) {
					/*
						
						[형식]
					
						파라메타
						
					*/
					
					console.log(data);
					console.log("=======");
				}
			});
			
		});
		
		
		// 2. DTO return
		$("#btn2").click(function(){
			
			$.ajax({
				
				url : "${contextPath}/ajax/c2aEx02",
				type : "get",
				success : function(data) {
					/*
					
						[형식]

						파라메타.속성명
						
					*/
					
					console.log(data.productCd);
					console.log(data.productNm);
					console.log(data.price);
					console.log(data.deliveryPrice);
					console.log(data.enrollDt);
					console.log(data.brandCd);
					console.log("===============");
					
				}
				
			});
			
		});
		
		
		// 3. Map return
		$("#btn3").click(function(){
			
			$.ajax({
				
				url : "${contextPath}/ajax/c2aEx03",
				type : "get",
				success : function(data) {
					
					/*
					
						[형식]
	
						파라메타.키
						
					*/
					
					
					console.log(data.orderCd);
					console.log(data.orderQty);
					console.log(data.cartCd);
					console.log(data.cartQty);
					console.log("=========");
					
				}
				
			});
			
		});
		
		
		// 4. List<DTO> return
		$("#btn4").click(function(){
					
			$.ajax({
				
				url : "${contextPath}/ajax/c2aEx04",
				type : "get",
				success : function(data) {
					
					/*
					
						[형식]	
					
						$(파라메타).each(function{
							this.속성명
						});
						
					*/
					
					$(data).each(function(){
						
						console.log(this.productCd);
						console.log(this.productNm);
						console.log(this.price);
						console.log(this.deliveryPrice);
						console.log(this.enrollDt);
						console.log(this.brandCd);
						console.log("===============");
						
						
					});
				}
				
			});
					
		});
	
		
		// 5. List<Map> return
		$("#btn5").click(function(){
			
			$.ajax({
				
				url : "${contextPath}/ajax/c2aEx05",
				type : "get",
				success : function(data) {
					
					/*
					
						[형식]
					
						$(파라메타).each(function{
							this.키
						});
					
					*/
					

					$(data).each(function(){
						console.log(this.orderCd);
						console.log(this.orderQty);
						console.log(this.cartCd);
						console.log(this.cartQty);
						console.log("======");
					});
				}
			});
			
			
		});
		
	});
</script>
</head>
<body>
	<fieldset>
		<legend>ControllerToAjax</legend>
	    <input type="button" id="btn1" value="1) 단일데이터" >
	    <input type="button" id="btn2" value="2) DTO" >
	    <input type="button" id="btn3" value="3) map" >
	    <input type="button" id="btn4" value="4) List(DTO)" >
	    <input type="button" id="btn5" value="5) List(map)" >
	</fieldset>
</body>
</html>