<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.* ,com.pj.bean.MenuBean"%>
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
<h1 align="center">菜單</h1>

<%--建立陣列用來取ShowAll包裝好的資料，用迴圈方式取值，再用表格方式顯示 --%>
<div align="center">

<a href="${pageContext.request.contextPath}/frontend/AddMenu.jsp?companyId=<%=session.getAttribute("id")%>">新增菜單</a>
<table class="tb">
	<thead class=hd2>
		<tr>	
			<th>菜名<th>圖片<th>價格<th>類型<th>是否為熱銷<th>菜色說明<th>修改<th>刪除
	</thead>
	<tbody>
		<%List<MenuBean> Menus = (List<MenuBean>) request.getAttribute("allMenu");
		for(MenuBean allMenu :Menus){
		%>
		<tr>
			<td width=200><%= allMenu.getName() %>
			<td width=200>
			<img src="${pageContext.request.contextPath}/MenuImage?filename=<%=allMenu.getMenu_seq() %>" height="125px">
			<%// allMenu.getImg() %>
			
			
			<td width=200><%= allMenu.getPrice() %>
			<td width=200><%= allMenu.getMenu_type() %>
			<td width=200><%= allMenu.getBest_selling() %>
			<td width=200><%= allMenu.getRemark() %>
			<td width=60>
				<a href="GetUpdateMenu?menu_seq=<%=allMenu.getMenu_seq() %>" >修改</a>
			<td width=60>
				<a href="DeleteMenu?menu_seq=<%=allMenu.getMenu_seq() %>" >刪除</a>
		<%}%>
	</tbody>
	</table>
</div>
<div align="center">
	<h3>
		共<%=Menus.size()%>道菜
	</h3>
</div>
</body>
</html>