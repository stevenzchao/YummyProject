<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.* ,com.pj.bean.CompanyBean"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增菜單</title>
</head>
<body>
 <jsp:useBean id="company" scope="request" class="com.pj.bean.CompanyBean" />
<h1>
	<a href="${pageContext.request.contextPath}/frontend/CreatCompany.jsp">新增企業會員</a>
</h1>

<h1>
	<a href="${pageContext.request.contextPath}/frontend/CompanyLogIn.jsp">登錄會員</a>
</h1>

<h1>
	<a href="${pageContext.request.contextPath}/ShowAllCompany">查詢全部企業會員</a>
</h1>

<hr>

<h1>
	<a href="${pageContext.request.contextPath}/ShowAllMenu?companyId="+<%company.getCompanyID(); %>>查詢菜單(查完可刪除修改)</a>
</h1>

<h1>
	<a href="${pageContext.request.contextPath}/frontend/AddMenu.jsp?companyId=3">新增菜單</a>
</h1>

</body>
</html>