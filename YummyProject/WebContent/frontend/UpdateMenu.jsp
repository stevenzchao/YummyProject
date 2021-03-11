<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.* ,com.pj.bean.CompanyBean"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增菜單</title>
</head>
<body>
<jsp:useBean id="updateMenuSeq" scope="request" class="com.pj.bean.MenuBean" />
<form method="post" action="UpdateMenu" enctype="multipart/form-data">
	<fieldset>
    	<legend>新增菜單</legend>
    		
            <div class=st1>
                <label for="menu_name">菜名:</label>
                <input type="hidden" id=menu_seq name="menu_seq" size="20" value="${param.menu_seq}">
                <input type="text" id="menu_name" name="menu_name" size="20" value="<%= updateMenuSeq.getName() %>">
                
                <span id="menu_namesp"></span>
            </div>

            <div class="st1">
                <label>類型:</label>
                <select name="type">
                    <option value="1">前菜</option>
                    <option value="2" selected>主餐</option>
                    <option value="3">湯品</option>
                    <option value="4">甜點</option>
                    <option value="5">飲料</option>
                    <option value="6">其他</option>
                </select>
            </div>

            <div class="st1">
                <label>圖片:</label>
                <input type="file" name="img">
            </div>

            <div class=st1>
                <label for="price">價格:</label>
                    <input type="text" id="price" name="price" size="20" value="<%= updateMenuSeq.getPrice() %>">
                    <span id="pricesp"></span>
            </div>
            <div class="st1">
                <label for="top">是否為主打熱銷品:</label>
                    <input type="radio" name="top" value="是" id="top" required><label for="top">是</label>
                <label>
                    <input type="radio" name="top" value="否">否
                </label>
            </div>
             <div class=st1>
                <label for="remark">說明:</label>
                <textarea id="remark" name="remark" rows="5" cols="40" ><%= updateMenuSeq.getRemark() %></textarea>
                <span id="remarksp"></span>
            </div>
            
            <div class=sub>
                <input class=a type="submit" value="送出" ;>
                <input class=a type="reset" value="清除">
            </div>
        </fieldset>
    </form>

</body>
</html>