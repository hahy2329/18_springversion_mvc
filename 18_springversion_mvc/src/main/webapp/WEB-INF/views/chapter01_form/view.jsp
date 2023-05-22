<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>1)단일 데이터</h1>
	<p>${enrolledProductCnt }</p>
	<hr>
	
	<h1>2) DTO</h1>
	<p>productCd : ${productDTO.productCd }</p>
	<p>productNm : ${productDTO.productNm }</p>
	<p>price : <fmt:formatNumber value="${productDTO.price }"/></p>
	<p>deliveryPrice : <fmt:formatNumber value="${productDTO.deliveryPrice }"/></p>
	<p>enrollDt : <fmt:formatDate value="${productDTO.enrollDt }" pattern="yyyy-MM-dd"/></p>
	<p>brandCd : ${productDTO.brandCd }</p>
	<hr>
	
	<h1>3) DTO List</h1>
	<table border="1">
		<tr align="center">
			<th>productCd</th>
			<th>productNm</th>
			<th>price</th>
			<th>deliveryPrice</th>
			<th>enrollDt</th>
			<th>brandCd</th>
		</tr>
		<c:forEach var="productDTO" items="${productList}">
			<tr align="center">
				<td>${productDTO.productCd }</td>
				<td>${productDTO.productNm }</td>
				<td><fmt:formatNumber value="${productDTO.price }"/></td>
				<td><fmt:formatNumber value="${productDTO.deliveryPrice }"/></td>
				<td><fmt:formatDate value="${productDTO.enrollDt }" pattern="yyyy-MM-dd"/></td>
				<td>${productDTO.brandCd }</td>
			</tr>
		</c:forEach>
	</table>
	
	<hr>
	
	<h1>4) Map</h1>
	<p>productCd 	 : ${productMap.productCd }</p>
	<p>productNm 	 : ${productMap.productNm }</p>
	<p>brandCd 	  	 : ${productMap.brandCd }</p>
	<p>price 		 : <fmt:formatNumber value="${productMap.price }"/></p>
	<p>deliveryPrice : <fmt:formatNumber value="${productMap.deliveryPrice }"/></p>
	<p>enrollDt 	 : <fmt:formatDate value="${productMap.enrollDt }" pattern="yyyy-MM-dd"/></p>
	<p>addTax 		 : ${productMap.addTax }</p>
	<p>totalPrice 	 : ${productMap.totalPrice }</p>
	<p>brandNm 		 : ${productMap.brandNm }</p>
	<p>enteredDt 	 : <fmt:formatDate value="${productMap.enteredDt }" pattern="yyyy-MM-dd"/></p>
	<p>activeYn 	 : ${productMap.activeYn }</p>
	
	<hr>
	
	<h1>5) Map List</h1>
	<table border="1">
		<tr align="center">
			<th>productCd</th>
			<th>productNm</th>
			<th>brandCd</th>
			<th>price</th>
			<th>deliveryPrice</th>
			<th>enrollDt</th>
			<th>addTax</th>
			<th>totalPrice</th>
			<th>brandNm</th>
			<th>enteredDt</th>
			<th>deliveryState</th>
		</tr>
		<c:forEach var="productMap" items="${productMapList}">
			<tr align="center">
				<td>${productMap.productCd }</td>
				<td>${productMap.productNm }</td>
				<td>${productMap.brandCd }</td>
				<td><fmt:formatNumber value="${productMap.price }"/></td>
				<td><fmt:formatNumber value="${productMap.deliveryPrice }"/></td>
				<td><fmt:formatDate value="${productMap.enrollDt }" pattern="yyyy-MM-dd"/></td>
				<td><fmt:formatNumber value="${productMap.addTax }"/></td>
				<td><fmt:formatNumber value="${productMap.totalPrice }"/></td>
				<td>${productMap.brandNm }</td>
				<td><fmt:formatDate value="${productMap.enteredDt }" pattern="yyyy-MM-dd"/></td>
				<td>${productMap.activeYn }</td>
			</tr>
		</c:forEach>
	</table>
	
	
	
	
	
	
	


</body>
</html>

