<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<link rel="stylesheet" href="../CSS/enterprise.css">
<title>註冊企業會員</title>
</head>
<body>
<jsp:useBean id="AddCompany" scope="request" class="com.pj.bean.CompanyBean" />
<form method="post" action="../AddCompany">
        <fieldset>
            <legend>企業註冊</legend>
            <div class=st1>
                <label for="idLtdName">企業名稱:</label>
                    <input type="text" id="idLtdName" name="ltdname" size="20" placeholder="請輸入企業名稱">
                    <span id="ltdNamesp"></span>
            </div>
            <div class=st1>
                <label for="idMail">E-mail:</label>
                    <input type="email" id="idMail" name="mail" size="20" placeholder="E-mail (帳號)">
                    <span id="mailsp"></span>
            </div>
            <div class=st1>
                <label for="idPwd">密碼:</label>
                    <input type="password" id="idPwd" name="pwd" size="20" placeholder="6~15位字元，需含英、數字">
                    <span id="pwdsp"></span>
            </div>
            <div class=st1>
                <label for="idPwdCheck">確認密碼:</label>
                    <input type="password" id="idPwdCheck" name="pwdCheck" size="20" placeholder="6~15位字元，需含英、數字">
                    <span id="PwdChecksp"></span>
            </div>
            <div class=st1>
                <label for="idName">聯絡人姓名:</label>
                    <input type="text" id="idName" name="name" size="20" placeholder="聯絡人姓名">
                    <span id="namesp"></span>
            </div>
            <div class=st1>
                <label for="idPhone">聯絡電話:</label>
                    <input type="text" id="idPhone" name="phone" size="20" placeholder="09XXXXXXXX">
                    <span id="phonesp"></span>
            </div>
            
            <div class=sub>
                <input class=a type="submit" value="送出">
                <input class=a type="reset" value="清除">
            </div>
        </fieldset>
    </form>
    <script src="../JavaScrpit/enterprise.js"></script>
</body>
</html>