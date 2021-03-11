const ERRORIMG="<img src='../Img/X.png' width=20px>";
const CORRECTIMG="<img src='../Img/O.png' width=20px>";
$("input").focus();
$("#idLtdName").blur(function(){
    let value=$(this).val();
    let txt="";
    if(value==""){
        txt=ERRORIMG;
        txt+="<span class='erro'>企業名稱不可為空白</span>";
        $("#ltdNamesp").html(txt);
    }
    else{
        txt=CORRECTIMG;
    }
    $("#ltdNamesp").html(txt);
});
$("#idMail").blur(function(){
    let value=$(this).val();
    let txt="";
    let specification=/^\w+((-\w+)|(\.\w+)|(\+\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z]{2,4}$/;
    if(value==""){
        txt=ERRORIMG;
        txt+="<span class='erro'>mail不可為空白</span>";
    }
    else if(specification.test(value)){
        txt=CORRECTIMG;
    }
    else{
        txt=ERRORIMG;
        txt+="<span class='erro'>請輸入正確mail</span>";
    }
    $("#mailsp").html(txt);
});
$("#idPwd").blur(function(){
    pwdValue=$(this).val();
    let txt="";
    let flag1 = false, flag2 = false;
    if(pwdValue==""){
        txt=ERRORIMG;
        txt+="<span class='erro'>密碼不可為空白</span>";
    }
    else if(pwdValue.length >= 6 && pwdValue.length <= 15){
        for (let i = 0; i < pwdValue.length; i++) {
            let ch = pwdValue.charAt(i).toUpperCase();
            if (ch >= "A" && ch <= "Z"){
                flag1 = true;
            }
            else if (ch >= "0" && ch <= "9"){
                 flag2 = true;
            }
            if (flag1 && flag2){
                break;
            }
        }
        if (flag1 && flag2){
            txt=CORRECTIMG;
        }
        else{
            txt=ERRORIMG;
            txt+="<span class='erro'>密碼需含數字及英文</span>"; 
        }
    }
    else{
        txt=ERRORIMG;
        txt+="<span class='erro'>密碼長度必須為6~15字</span>";
    }
    $("#pwdsp").html(txt); 
});
$("#idPwdCheck").blur(function(){
    Value=$(this).val();
    let txt="";
    if(Value==""){
        txt=ERRORIMG;
        txt+="<span class='erro'>請輸入確認密碼</span>";
    }
    else if(Value==pwdValue){
    	txt=CORRECTIMG;
        txt="";
    }
    else{
        txt=ERRORIMG;
        txt+="<span class='erro'>確認密碼需與密碼相同</span>";
    }
    $("#PwdChecksp").html(txt);
});
$("#idName").blur(function(){
    Value=$(this).val();
    let txt="";
    if(Value==""){
        txt=ERRORIMG;
        txt+="<span class='erro'>請輸入聯絡人姓名</span>";
    }
    else{
        for(let i=0;i<Value.length;i++){
            let ch = Value.charCodeAt(i);
            if ((ch >= 0X4E00 && ch <= 0X9FFF) || (ch >= 0X0041 && ch <= 0X005A) || (ch >= 0X0061 && ch <= 0X007A)) {
                txt=CORRECTIMG;
            }
            else {
                txt=ERRORIMG;
                txt+="<span class='erro'>聯絡人姓名不可為特殊字元及數字</span>";
            }
        }
    }
    $("#namesp").html(txt);
});
$("#idPhone").blur(function(){
    Value=$(this).val();
    let txt="";
    if(Value==""){
        txt=ERRORIMG;
        txt+="<span class='erro'>請輸入連絡電話</span>";
    }
    else {
        for (let i = 0; i < Value.length; i++) {
            let ch = Value.charAt(i);
            if(ch>=0&&ch<=9){
                txt=CORRECTIMG;
            }
            else{
                txt=ERRORIMG;
                txt+="<span class='erro'>請輸入數字</span>";
            }
        }
    }
    $("#phonesp").html(txt);
});

