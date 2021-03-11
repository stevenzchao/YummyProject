<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>Verify</title>
</head>
<body>
<div  id="allpage">
        <header>
            <h1>請輸入傳送至Email的驗證碼</h1>
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
                    <form name="login" class="Data-Content" method="post" action="SuccessCongratPage.jsp" >
					  <fieldset>
					  <legend>輸入驗證碼</legend>
					    <div class="Data-Title">
					    <div class="text-align">
						      <label for="code">此處輸入</label><br />
					      </div>
					    </div>    
					    <div class="Data-Item">

						<input type="text" name="authcode"><br>
						<input type="submit" value="verify">
					     </div>

					  </fieldset>
					</form>
					     <form method="post" action="../ResetEmailVarification">
					     <input type="submit" value="重新發送驗證">
					     </form>
                </section>                
            </article>
        </div>  <!--end content-->
        <footer>
                <p>2014 All Rights Reserved Quality Art Technology CO. </p>
        </footer>
    </div>  <!--end allpage-->


</body>
</html>