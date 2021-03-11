<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>我的餐廳</h1>
<form method="post" action="${pageContext.request.contextPath}/RestaurantController">
<input type="text" value="<%=session.getAttribute("id")%>" name=companyID />
<input type="submit" value="會員ID身分=<%=session.getAttribute("id")%>"  />
</form>

<form method="post" action="${pageContext.request.contextPath}/RestaurantController">
<input type="submit" value="後台端列出所有餐廳" name=readRAll />
</form>




</body>
</html>