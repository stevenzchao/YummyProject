<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>store</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/com.yproject.css/rwdgilong.css">
<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
</head>

<body>
    <div id="allpage">
        <header>
          
            <nav>
                <ul class="menu">
                    <li><a href="${pageContext.request.contextPath}/HomePage.html/HomePage.html">首頁</a></li>
                    <li><a href="../com.yproject.jsp/LogIn.jsp">會員登入</a></li>
                    <li><a href="http://localhost:8080/YummyProject/Mapstart">查詢</a></li>
                    <li><a href="">個人頁面</a></li>
                    <li><a href="../frontend/CompanyLogIn.jsp">店家專區</a></li>
                </ul>
            </nav>            
        </header>
        <div id="content">
            <article class="article">
                <section class="section">
                     <h2 id="Rname">thisIsName</h2>
				     <img id="restpic" alt="" src="" width="300" style="border-radius: 5px ">
				    
				     <iframe id="iframe" style="margin-left:300px" src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d225.9451436854066!2d121.55814167712391!3d25.0299233390171!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3442ab30df9c5285%3A0x8886b4a8e0a59080!2sButcher%20by%20LanPengYou!5e0!3m2!1szh-TW!2sus!4v1614735999243!5m2!1szh-TW!2sus" width="300"  style="border:0;" allowfullscreen="" loading="lazy"></iframe>
				     
				

                     <div>
                         <fieldset>
	                          今日營業: <select>
	                             <option value="">星期一休息</option>
	                             <option value="">星期二 11:00-14:30, 17:30-22:00</option>
	                             <option value="">星期三 11:00-14:30, 17:30-22:00</option>
	                             <option value="">星期四 11:00-14:30, 17:30-22:00</option>
	                             <option value="">星期五 11:00-14:30, 17:30-22:00</option>
	                             <option value="">星期六 11:00-14:30, 17:30-22:00</option>
	                             <option value="">星期日 11:00-14:30, 17:30-22:00</option>
	                         
	                          </select> 
	                          <p id="address">店家地址| 臺北市信義區基隆路二段87號</p>
	                          <p>均消價位| $280</p>
	                          <p>臉書頁面| <a href="">
                                  <!-- <img alt="" src="../images/facebook.jpg">FaceBook -->
                                </a></p>
	                          <p id="phone">聯絡電話| 0227320070</p>
                         </fieldset>
                                         
                     </div>
                     <h2>照片</h2>
                    
                
                </section>                
            </article>
           
        </div>  <!--end content-->
        <footer>
                <p>2014 All Rights Reserved Quality Art Technology CO. </p>
        </footer>
    </div> 
    <%String json = (String)request.getAttribute("json"); %>
    
    <script>
    let jsonData=<%=json%>
    console.log("ok");
    console.log(jsonData[0].RestaurantName);
    document.getElementById("Rname").innerHTML=jsonData[0].RestaurantName;    
    document.getElementById("address").innerHTML="店家地址|"+jsonData[0].RestaurantAddress;
    document.getElementById("phone").innerHTML="聯絡電話|"+jsonData[0].RestaurantContact;
    document.getElementById("iframe").src="https:\/\/www.google.com\/maps\/embed\/v1\/place?key=AIzaSyBTUCen4YixtEKjNBAL4CX5xkW1QQAembQ&q="+jsonData[0].RestaurantAddress;

    document.getElementById("restpic").src="${pageContext.request.contextPath}/ImageRetriveServer?filename=1";
	</script>
</body>



</html>