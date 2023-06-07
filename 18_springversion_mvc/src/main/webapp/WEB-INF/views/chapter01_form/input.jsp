<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록 폼</title>
</head>
<body>

    <h1>1) @ModelAttribute</h1>
	<form action="${contextPath }/v2c/modelAttribute" method="post"> 
		<input type="hidden" name="isPC" value="true">
		<input type="hidden" name="locationCd" value="1">
		<input type="hidden" name="lang" value="kor">
		<fieldset>
			<legend>상품등록</legend>
			<p>상품코드 : <input type="text" name="productCd" /></p>
			<p>상품명   : <input type="text" name="productNm" /></p>
			<p>가격     : <input type="text" name="price" /></p>
			<p>배송비   : <input type="text" name="deliveryPrice" /></p>
			<p>등록날짜 : <input type="date" name="enrollDt" /></p>
			<p>브랜드 :  
				<select name="brandCd">
					<option value="b1">SAMSUNG</option>
					<option value="b2">LG</option>
					<option value="b3">APPLE</option>
					<option value="b4">LENOVO</option>
					<option value="b5">GIGABYTE</option>
					<option value="b6">HP</option>
				</select>
			</p>
		    <p><input type="submit" value="상품등록" ></p>
		</fieldset>	
    </form>
     
    <br><hr><br>
     
    <h1>2) @RequestParam Map</h1>
	<form action="${contextPath }/v2c/map" method="post"> 
		<input type="hidden" name="isPC" value="true">
		<input type="hidden" name="locationCd" value="1">
		<input type="hidden" name="lang" value="kor">
		<fieldset>
			<legend>상품등록</legend>
			<p>상품코드 : <input type="text" name="productCd" /></p>
			<p>상품명   : <input type="text" name="productNm" /></p>
			<p>가격     : <input type="text" name="price" /></p>
			<p>배송비   : <input type="text" name="deliveryPrice" /></p>
			<p>등록날짜 : <input type="date" name="enrollDt" /></p>
			<p>브랜드 :  
				<select name="brandCd">
					<option value="b1">SAMSUNG</option>
					<option value="b2">LG</option>
					<option value="b3">APPLE</option>
					<option value="b4">LENOVO</option>
					<option value="b5">GIGABYTE</option>
					<option value="b6">HP</option>
				</select>
			</p>
		    <p><input type="submit" value="상품등록" ></p>
		</fieldset>	
    </form>
     
	<br><hr><br>
	
	 
    <h1>3) @RequestParam</h1>
	<p><a href="${contextPath }/v2c/requestParam?productCd=1&orderQty=3">구매하기(@RequestParam)</a></p>
     
	<br><hr><br>
     
    <h1>4) HttpServletRequest</h1>
	<p><a href="${contextPath }/v2c/httpServletRequest?productCd=1&orderQty=3">구매하기(HttpServletRequest)</a></p>
     
	<br><hr><br>
	
    <h1>5) @PathVariable</h1>
	<p><a href="${contextPath }/v2c/pathVariable/1/3">구매하기(@PathVariable)</a></p>
	
	<br><hr><br>
    
    <h1>참조) DTO List 전송</h1>
	<form action="${contextPath }/v2c/DTOList" method="post"> 
		<table border="1">
			<tr align="center">
				<th>productCd</th>
				<th>productNm</th>
				<th>price</th>
				<th>deliveryPrice</th>
				<th>enrollDt</th>
				<th>brandCd</th>
			</tr>
			<c:forEach var="i" begin="0" end="9">
				<tr>
					<td><input type="text" name="productList[${i }].productCd" value="${i}"/></td>
					<td><input type="text" name="productList[${i}].productNm" value="${i} 상품이름"/></td>
					<td><input type="text" name="productList[${i}].price" value="${i * 10000}"/></td>
					<td><input type="text" name="productList[${i}].deliveryPrice" value="3000"/></td>
					<td><input type="date" name="productList[${i }].enrollDt" value="2021-01-07"/></td>
					<td><select name="productList[${i }].brandCd">
							<option value="b1">SAMSUNG</option>
							<option value="b2">LG</option>
							<option value="b3">APPLE</option>
							<option value="b4">LENOVO</option>
							<option value="b5">GIGABYTE</option>
							<option value="b6">HP</option>
						</select>
					</td>
				</tr>
			</c:forEach>
			<tr><td colspan="6"><input type="submit"></td></tr>
		</table>
	</form>
     
</body>
</html>