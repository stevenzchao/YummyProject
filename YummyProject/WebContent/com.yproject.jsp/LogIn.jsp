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
   <title>Log In</title>
   <style>
   button{
   padding:5px;
   margin:5px
   }
   </style>
 </head>
<body>
 <div  id="allpage">
        <header>
            <h1>登入</h1>
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
                    <form name="login" class="Data-Content" method="post" action="../logInServlet" >
					  <fieldset>
					  <legend>登入</legend>
					    <div class="Data-Title">
					    <div class="text-align">
						      <label for="account">會員帳號</label><br>
						      <label for="password">會員密碼</label><br>
						      <label for="code">驗證碼</label><br /><br>
						      <label for="code">兩週內免登陸</label><br>
					      </div>
					    </div>    
					    <div class="Data-Item">
					      <input  id="account" name="account" >
					      <input type="password" id="password" name="password" >
					      <input type="text" id="code" name="code" ><button type="reset" onclick="refresh()">重新產出驗證碼</button>
					      <img name="imgValidate" src = "index.jsp"  ><br>
					      <input type="checkbox" name="keep" ><button id="button" disabled="disabled">送出</button><button type="reset" >重填</button>
					      <br>
					      <a href="CreateAccount.html">沒有帳號，申請加入！</a><br>
					      <a id="iforgot" href="ForgotPassword.jsp">忘記密碼</a>
					     </div>
					    <div class="Data-Span">	
					    <span id="namenote"></span><br />
					    </div>
					  </fieldset>
					</form>
					
                </section>                
            </article>
        </div>  <!--end content-->
        <footer>
                <p>2014 All Rights Reserved Quality Art Technology CO. </p>
        </footer>
    </div>  <!--end allpage-->
    <script type="text/javascript">
    //確認使用者是否有輸入欄位資訊的功能
    document.addEventListener("DOMContentLoaded", function() {
    	document.getElementById("account").addEventListener("change", EAccount);
    	document.getElementById("password").addEventListener("change", EPwd);
    	document.getElementById("code").addEventListener("change", ECode);


    });
    
    var wAccount=false; 
    var WPwd=false;
    var WCode=false;

    
    function EAccount(){
    	wAccount= false;
    	let write = document.getElementById("account");
    	let writeVal = write.value;
    	if(writeVal!=""){
    		wAccount= true;
    		console.log("1true")
    	}
		Esubmit();

    }
    
    function EPwd(){
    	wPwd= false;
    	let writeP = document.getElementById("password");
    	let writePVal = writeP.value;
    	if(writePVal!=""){
    		wPwd= true;
    		console.log("2true")
			
    	}
    	Esubmit();
    }
    
    function ECode(){
    	wCode= false;
    	let writeC = document.getElementById("code");
    	let writeCVal = writeC.value;
    	if(writeCVal!=""){
    		wCode= true;
    		console.log("3true")
			
    	}
    	Esubmit();
    }
    
    function Esubmit(){
    	if(wAccount==true&& wPwd==true && wCode==true){
    		$('#button').prop("disabled",false);
    		console.log("function worked!!")
    		}else{
    		$('#button').prop("disabled",true);
    	}
    }
    
    function refresh() {
        login.imgValidate.src="index.jsp?id="+Math.random();
    }
    </script>
</body>
</html>