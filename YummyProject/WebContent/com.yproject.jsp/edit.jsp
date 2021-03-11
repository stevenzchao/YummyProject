<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*,com.yummyproject.Bean.YummyBean"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Personal Page</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script defer src="https://use.fontawesome.com/releases/v5.0.10/js/all.js" ></script>
	<script src="${pageContext.request.contextPath}/com.yproject.js/messagebox.js"></script>
	<link href="${pageContext.request.contextPath}/com.yproject.css/PersonalPage.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/com.yproject.css/editpage.css" rel="stylesheet">
	<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script src="${pageContext.request.contextPath}/com.yproject.js/edit_nav.js"></script>
</head>
<body>
		<ul>
	        <li><img src="${pageContext.request.contextPath}/logojpg/logo.jpg" width="55px"></li>
	        <li><a href="${pageContext.request.contextPath}/HomePage.html/HomePage.html">首頁</a></li>
	        <li><a href="#home">點數商城</a></li>
	        <li><a href="#news">論壇</a></li>
	        <li><a href="#news">排行榜</a></li>
	        <li><a href="#news">發表文章</a></li>
	        <li><a href="#news">客服中心</a></li>
	        <li class="dropdown">
	          <a href="" class="dropbtn"><i class="fas fa-bell "></i></a>
	          <div class="dropdown-content">
	            <a href="#">Steve要求追蹤你</a>
	            <a href="#">您附近有新餐廳開張</a>
	            <a href="#">瓦城推出買十送一禮券 要搶要快!</a>
	          </div>
	        </li>
<%-- 	        <% YummyBean ybean = (YummyBean) request.getAttribute("queryResult");%> --%>

	        <li class="p_img">
		        <img src="${pageContext.request.contextPath}/ShowImage?imgaccount=${queryResult.getAccount()}" width="50px">		        
	        </li>
	        <li class="info_box">	        	
				<p class="info">您好，${queryResult.getNickName()}</p>
				<p class="info">剩餘點數:${queryResult.getYummyPoint()}</p>				
	        </li>
    	</ul>
    	
    	
    	<div class="container">
    		<div class="left_col">
			        <div class=sidediv></div>
				        <div class=sidediv>
				        <a href="" class="nav" id="a1">更改大頭貼及背景</a>
				        <a href="" class="nav" id="a2">更改基本資料</a>
				        <a href="" class="nav" id="a3">更改興趣標籤</a>
				        <a href="" class="nav" id="a4">點數查詢</a>
				        </div>
	        		<div class=sidediv></div>

    		</div>
    		
    		<div class="right_col">
    			
    			<div class="user_photo_change" id="side1">
	    			<form action="../UplaodJPG" method="post" enctype="multipart/form-data">
	    				<div class="title"><h1>個人圖示</h1></div>
		    				<div class="protrait_img" >
		    					<img id="blah" src="#" width="200px" alt="your image">
		    				</div>
	    				<span>選擇要上傳的圖片</span>
	    				<input id="imgInp" type="file" name="file"><br>   				
	    				<input type="hidden" name="account" value="${queryResult.getAccount()}"> 
	    				<input type="submit" value="送出" name="photo">
	    			</form>
    			</div>
                
                
    			<div class="user_info_change" id="side2">
	    			<form method="get" action="../UpdateInfo">
	    				<h1>基本資料修改</h1>
	    				<hr><br>
	    				<label class="t1" for="account1">RealName:</label>
	                    <input type="text" id="account1" name="rname" autocomplete="off" value="${queryResult.getRealName()}">
	                    <span id="idsp1"></span>
	                    <p>(1.不可空白，2.至少6個字以上，3.必須全部為英文字)</p>
	                    
	                   	<label class="t1" for="account2">NickName:</label>
	                    <input type="text" id="account2" name="nname" autocomplete="off" value="${queryResult.getNickName()}">
	                    <span id="idsp2"></span>
	                    <p>(1.不可空白，2.至少6個字以上，3.必須全部為英文字)</p>
	                    
	                    <label class="t1" for="phone">Phone Number:</label>
	  					<input type="text" id="phone" name="phone" value="${queryResult.getPhoneNumber()}" >
	  					<span id="idsp3" ></span>
	  					<p>(格式:1234-123-123)</p>
	  					
	  					<label class="t1" for="account1">BirthDay:</label>
	                    <input type="text" id="date1" name="birthdat"autocomplete="off" value="${queryResult.getBirthDay()}">
	                    <span id="idsp4" ></span>
	                    <p>格式:西元年/月/日 yyyy/MM/dd</p>
	                    
	                    <label class="t1" for="district1">District:</label>
	                    <input type="text" id="district1" name="dist" autocomplete="off" value="${queryResult.getDistrict()}">
	                    <span id="idsp5"></span>
	                    <p>(例如:台北市XX區XX路XX段XX號)</p>
	    			<input type="hidden" name="account" value="${queryResult.getAccount()}"> 
	    			<input class="subbtn" type="submit" value="儲存變更" name="account">
	    			<input class="subbtn" type="reset" value="Reset">
	    			</form>
    			</div>
    			
    			
    			<div class="user_interest_change" id="side3"></div>
    			
    			<div class="user_point_change" id="side4"></div>
    		</div>
    	
    	
    	</div>
    	
    	
    	<script>
		$(function(){
			$("#imgInp").change(function(){
					if (this.files && this.files[0]) {
						var reader = new FileReader();
						
						reader.onload = function (e) {
							$('#blah').attr('src', e.target.result);
						}
						
						reader.readAsDataURL(this.files[0]);
					}
				});
			}) ;
		</script>
</body>
</html>