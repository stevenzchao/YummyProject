<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,com.pj.bean.RestaurantBean"%>
<%!@SuppressWarnings("unchecked")%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>餐廳資料</title>
</head>

<body style="background-color: #fdf5e6">
	<div align="center">
		<h2>所有餐廳</h2>

		<form method="post" action="${pageContext.request.contextPath}/RestaurantController">
			餐廳搜尋 : <input type="text" name="Rkeyword" placeholder="代號或名稱關鍵字" />
			<input type="submit" value="go" />
		</form>

		<table border="1">
			<tr style="background-color: #a8fefa">
				<th>餐廳編號
				<th>餐廳名稱
				<th>地址
				<th>標籤
				<th>聯絡方式
				<th>網站
				<th>照片
				<th>會員編號
				<th><form method="post" action="frontend/newR.jsp">
						<input type="submit" value="新增" name="newRName" />
					</form> <%
 List<RestaurantBean> restaurants = (ArrayList<RestaurantBean>) request.getAttribute("RAll");
 %> <%
 for (RestaurantBean restaurant : restaurants) {
 %>
			<tr>
				<td><%=restaurant.getRestaurantID()%>
				<td><%=restaurant.getRestaurantName()%>
				<td><%=restaurant.getRestaurantAddress()%>
				<td><%=restaurant.getRestaurantHashtag()%>
				<td><%=restaurant.getRestaurantContact()%>
				<td><%=restaurant.getRestaurantWebsite()%> <!--用get的QueryString將request的name和value丟給servlet 透過dao撈取圖檔後再reponse write回需求端-->
				<td><img
					src="${pageContext.request.contextPath}/RestaurantController?RIDforimg=<%=restaurant.getRestaurantID()%>"
					height="125px">
				<td><%=restaurant.getCompanyID()%>
				<td>
					<form method="post" action="${pageContext.request.contextPath}/RestaurantController">
						<input type="hidden" value="<%=restaurant.getRestaurantID()%>"
							name="readupdateRID"> <input type="submit" value="修改">
					</form>
					<form method="post" action="${pageContext.request.contextPath}/RestaurantController">
						<input type="hidden" value="<%=restaurant.getRestaurantID()%>"
							name="deleteRID"> <input type="submit" value="刪除">
					</form> <%
 }
 %>
				
		</table>
		<h2>
			<a href="${pageContext.request.contextPath}/frontend/Rmain.jsp">Home</a>
		</h2>
	</div>
</body>

</html>