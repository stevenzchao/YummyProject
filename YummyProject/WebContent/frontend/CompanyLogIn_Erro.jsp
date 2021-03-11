<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<link rel="stylesheet" href="../CSS/logInError.css">
<style>
input:focus {
            background-color: #e7e5e5;
        }
table {
	margin: auto;
	font-family: 微軟正黑體;
}

thead {
	text-align: center;
}

div {
	margin-top: 120px;
}

.inputGrid {
	height: 30px;
	width: 200px;
}
.errotext{
	color: red;
}
</style>
<title>企業會員登入</title>
</head>
<body>
	    <div>
        <form method="post" action="${pageContext.request.contextPath}/CompanyLogIn">
            <table>
                <thead>
                    <tr>
                        <th colspan="2" align='center'>
                            <h1>企業會員登錄</h1>
                        </th>
                    </tr>
                </thead>
                <tr>
                    <td><label for="companyMail">輸入帳號:</label></td>
                    <td><input class="inputGrid" type="text" id="companyMail" name="companyMail" placeholder="帳號:E-mail">
                        <span id="companyMailsp"></span>
                    </td>
                </tr>
                <tr>
                    <td><label for="companyPwd">輸入密碼:</label></td>
                    <td><input class="inputGrid" type="password" id="companyPwd" name="companyPwd"><span id="companyPwdsp"></span></td>
                </tr>
                <tr>
                	<td colspan="2" align='center' class="errotext">
                		帳號或密碼輸入錯誤，請重新輸入。
                	</td>
                <tr>
                    <td colspan="2" align='center'>
                    	<input type="submit" value="送出">
                        <input type="reset" value="清除">
                    </td>
            </table>
        </form>
    </div>

    <script src="../JavaScrpit/login.js"></script>
</body>
</html>