<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.* ,com.pj.bean.CompanyBean"%>
<!DOCTYPE html>
<html> 
<head>
<meta charset="UTF-8">
<style>
body{font-family:"微軟正黑體";border-collapse:#F0F0F0}
table {border-collapse: collapse;background-color:#FFFFDF;border: 2px solid gray;}
tbody {background-color:#FFF7FB;text-align:center;}
td {border: 2px solid gray;}
</style>
<title>企業會員</title>
</head>
<body>
<h1 align="center">企業會員</h1>

<%--建立陣列用來取ShowAll包裝好的資料，用迴圈方式取值，再用表格方式顯示 --%>
<div align="center">
<table class="tb">
	<thead class=hd2>
		<tr>
			<th>ID<th>企業名稱<th>mail<th>密碼<th>聯絡人<th>電話<th>會員等級<th>停權<th>復原
	</thead>
	<tbody>
		<%
		List<CompanyBean> Companys = (List<CompanyBean>) request.getAttribute("allCompany");
		for(CompanyBean allCompany :Companys){
		%>
		<tr>
			<td width=40><%= allCompany.getCompanyID() %>
			<td width=200><%= allCompany.getCompanyName() %>
			<td width=200><%= allCompany.getCompanyMail() %>
			<td width=200><%= allCompany.getCompanyPwd() %>
			<td width=200><%= allCompany.getCompanyContactPperson() %>
			<td width=200><%= allCompany.getCompanyPhone() %>
			<td width=80><%= allCompany.getCompanyLevel() %>
			<td width=60>
				<a href="?id=<%=allCompany.getCompanyID() %>" >停權</a>
			<td width=60>
				<a href="?id=<%=allCompany.getCompanyID() %>" >復原</a>
		<%}%>
	</tbody>
	</table>
</div>
<div align="center">
	<h3>
		共<%=Companys.size()%>筆企業會員
	</h3>
</div>
</body>
</html>