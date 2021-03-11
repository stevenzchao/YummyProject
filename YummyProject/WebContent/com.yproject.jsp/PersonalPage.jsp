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
	        <li class="p_img"><img src="${pageContext.request.contextPath}/ShowImage?imgaccount=${customer.getAccount()}" width="50px"></li>
	        <li class="info_box">	        	
				<p class="info">您好，${customer.getNickName()}</p>
				<p class="info">剩餘點數:${customer.getYummyPoint()}</p>
	        </li>
    	</ul>
	
	
	<div class="container">
	     <div class="protrait">
				<div class="protrait_photo">
					<img src="${pageContext.request.contextPath}/ShowImage?imgaccount=${customer.getAccount()}" width="50px">
				</div>
				
				<div class="protrait_name">
					<span><h2>${customer.getNickName()}</h2></span></p>
					<span>${customer.getRealName()}</span>
					<div class="txtarea">
					<p>Do it yourself</p>
					</div>
				</div>	     	
	     </div>
	     
	     <div class="level_container"> 
		 	<div class="level">
		 		<div><span style="font-size:36px;font-weight:bold">等級尚未串接</span></div>
		 	</div>
		 	<div class="medal_showone"></div>
		 	<div class="editfile"><a href="${pageContext.request.contextPath}/PersonEdit?account=${customer.getAccount()}&password=${customer.getPassword()}">編輯個人檔案</a></div>
		 </div>
		 
		 
	     
		 <div class="stories">
				<div class="story1"><br>
		        <img src="logojpg/protrait.jpg" width="100px" alt="Avatar" class="st1img" >
		        <br><hr class=""><br>
		        <p> Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
		        </p>
		        <p> Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
		        </p>
		        <p> Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
		        </p>
		        <p> Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
		        </p>
		        <p> Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
		        </p>  
		          <div class="">
		            <div class="">
		              <img src="" style="width:100px" alt="" class="">
		              <img src="" style="width:100px" alt="" class="">
		          </div>
		        </div>
		        
		        <button type="button" class="like_btn"><i class="fa fa-thumbs-up"></i>  Like</button> 
		        <button type="button" class="comment_btn"><i class="fa fa-comment"></i>  Comment</button> 
		      </div>
		 </div>
		 
		 <div class="status_container">
		 	<div class="status_box"><span id="showstatus"></span></div>
		 	<div class="medal_all">
			 	<h1>徽章</h1><br>
			 	<img src="${pageContext.request.contextPath}/logojpg/protrait.jpg" width="100px">
			 	<img src="${pageContext.request.contextPath}/logojpg/protrait.jpg" width="100px">
			 	<img src="${pageContext.request.contextPath}/logojpg/protrait.jpg" width="100px">
		 	</div>
		 	<div>
		 		<div style="margin-top:30px;font-size:24px"><a href="#">
		 		<span >照片</span></a>
		 		</div>
		 		
		 		<div style="margin-top:30px;font-size:24px"><a href="#">
		 		<span>評論</span></a>
		 		</div>
		 		
		 	</div>
		 	<div class="friend_zone">
		 		<h2>好友</h2>
			 		<div class="friend">
			 			<img src="logojpg/memedog.jpg" width="80px">
			 			<span class="friend_name">steve</span>
			 			<img  src="#">100 
			 		</div>
		 	</div>
		 </div>
		 
		 
		 
		 <div class="stories">
				<div class="story1"><br>
		        <img src="logojpg/protrait.jpg" width="100px" alt="Avatar" class="st1img" >
		        <br><hr class=""><br>
		        <p> Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
		        </p>
		        <p> Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
		        </p>
		        <p> Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
		        </p>
		        <p> Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
		        </p>
		        <p> Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
		        </p>  
		          <div class="">
		            <div class="">
		              <img src="" style="width:100px" alt="" class="">
		              <img src="" style="width:100px" alt="" class="">
		          </div>
		        </div>
		        
		        <button type="button" class="like_btn"><i class="fa fa-thumbs-up"></i>  Like</button> 
		        <button type="button" class="comment_btn"><i class="fa fa-comment"></i>  Comment</button> 
		      </div>
		 </div>
		 
		 
		 
		 <div class="message_block">
		 	留言區域：<textarea class="txtarea" id="content" rows="2" cols="50" name="s1"></textarea><span id="alert1"></span>
    		<input value="提交" type="button" id="btn" /><br>
    		顯示留言區域：<div id="display_area"></div>
		 </div>
		 
		 
	<footer>
		 	<img  src="logojpg/logo.jpg" width="55px" >
		 	<p class="footlogo">U copy u die</p>
	</footer>	 
		 
		 
	</div>
	
	
</body>
</html>