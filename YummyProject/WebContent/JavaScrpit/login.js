const ERRORIMG="<img src='../Img/X.png' width=20px>";
const CORRECTIMG="<img src='../Img/O.png' width=20px>";
$("#companyMail").blur(function(){
    let value=$(this).val();
    let txt="";
    if(value==""){
        txt=ERRORIMG;
        txt+="<span class='erro'>帳號不可為空白</span>";
    }
    else{
        txt=CORRECTIMG;
    }
    $("#companyMailsp").html(txt);
});
$("#companyPwd").blur(function(){
    let value=$(this).val();
    let txt="";
    if(value==""){
        txt=ERRORIMG;
        txt+="<span class='erro'>密碼不可為空白</span>";
    }
    else{
        txt=CORRECTIMG;
    }
    $("#companyPwdsp").html(txt);
});