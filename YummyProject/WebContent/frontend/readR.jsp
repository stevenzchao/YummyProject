<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查詢餐廳</title>
</head>
<body style="background-color: #fdf5e6">
<div align="center">
<h2>查詢餐廳</h2>
<jsp:useBean id="readRBean" scope="request" class="com.pj.bean.RestaurantBean"></jsp:useBean>
<table><tr><td>餐廳ID
<td><input type="text" disabled value="${readRBean.restaurantID }">
<tr><td>餐廳名稱
<td><input type="text" disabled value="${readRBean.restaurantName }">
<tr><td>餐廳地址
<td><input type="text" disabled value="${readRBean.restaurantAddress }">
<tr><td>經度
<td><input type="text" disabled value="${readRBean.restaurantLong }">
<tr><td>緯度
<td><input type="text" disabled value="${readRBean.restaurantLati }">
<tr><td>餐廳標籤
<td><input type="text" disabled value="${readRBean.restaurantHashtag }">
<tr><td>餐廳聯絡方式
<td><input type="text" disabled value="${readRBean.restaurantContact }">
<tr><td>餐廳網站
<td><input type="text" disabled value="${readRBean.restaurantWebsiteC}">
<tr><td>會員ID
<td><input type="text" disabled value="${readRBean.companyID }">
</table>
		<h2>
			<a href="html/main.html">Home</a>
		</h2>
</div>
</body>
</html>