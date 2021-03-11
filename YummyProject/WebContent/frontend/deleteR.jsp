<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>刪除餐廳</title>
</head>
<body style="background-color: #fdf5e6">
<div align="center">
<h2>刪除成功!</h2>
<table><tr><td>已刪除<%=request.getAttribute("updatecount")%>筆資料
<tr><td><form method="post" action="${pageContext.request.contextPath}/RestaurantController">
<input type="submit" value="All" name=readRAll />
</form>
</table>
</div>
</body>
</html>