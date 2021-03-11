<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.yummyproject.Bean.YummyBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
   <link rel="stylesheet" href="${pageContext.request.contextPath}/com.yproject.css/rwd.css">
   <!--  <link rel="stylesheet" media="screen and  (max-width: 780px)" href="rwd780.css" />-->
   <script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
   <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
   <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
   <script defer src="https://use.fontawesome.com/releases/v5.0.10/js/all.js" integrity="sha384-slN8GvtUJGnv6ca26v8EzVaR9DC58QEwsIk9q1QXdCU8Yu8ck/tL/5szYlBbqmS+" crossorigin="anonymous"></script>
   <script src="../com.yproject.js/CreatAccount.js"></script>
<title>Success Congrats Page</title>
</head>
<body>
<%YummyBean cus = (YummyBean) session.getAttribute("authcode"); 
String code = request.getParameter("authcode");
			
if(code.equals(cus.getCode())) {%>
<h1>恭喜您!已經成為「愛食」的一員囉!!</h1>
    <div  id="allpage">
        <header>
            <nav>
                <ul class="menu">
                    <li><a href="">01</a></li>
                    <li><a href="">02</a></li>
                    <li><a href="">03</a></li>
                    <li><a href="">04</a></li>
                </ul>
            </nav>            
        </header>
        <div id="content">
            <article class="articleall">
                <section class="section">
                   <a href="LogIn.jsp">馬上登入並前往首頁探索</a>
                </section>                
            </article>
        </div>  <!--end content-->
        <footer>
                <p>2014 All Rights Reserved Quality Art Technology CO. </p>
        </footer>
    </div>  <!--end allpage-->
<%}else{%>
<h1>有些資訊錯誤囉</h1>
    <div  id="allpage">
        <header>
            <nav>
                <ul class="menu">
                    <li><a href="">01</a></li>
                    <li><a href="">02</a></li>
                    <li><a href="">03</a></li>
                    <li><a href="">04</a></li>
                </ul>
            </nav>            
        </header>
        <div id="content">
            <article class="articleall">
                <section class="section">
                   <a href="${pageContext.request.contextPath}/com.yproject.jsp/Verify.jsp">重新發送驗證碼</a>
                </section>                
            </article>
        </div>  <!--end content-->
        <footer>
                <p>2014 All Rights Reserved Quality Art Technology CO. </p>
        </footer>
    </div>  <!--end allpage-->
<%}%>

</body>
</html>