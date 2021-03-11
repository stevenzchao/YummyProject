
//input listener  
document.addEventListener("DOMContentLoaded", function() {
	document.getElementById("name").addEventListener("change", checkName);
		document.getElementById("nickname").addEventListener("change", checkNickName);
	document.getElementById("account").addEventListener("change", checkAccount);
	document.getElementById("password").addEventListener("change", checkPwd);
	document.getElementById("passwordCheck").addEventListener("change", checkPwdcheck);
	document.getElementById("birth").addEventListener("blur", checkDate);
	document.getElementById("cell").addEventListener("change", checkCell);

});
nameflag = false;accountflag=false;passwordflag=false;passwordCheckflag=false;cellflag=false; nickcameflag = false;
function checkName() {
	let name = document.getElementById("name");
	let nameVal = name.value;
	let namenote = document.getElementById("namenote");
	if (nameVal.length == "") {
		namenote.innerHTML = "<i style='color:red' class='fas fa-times-circle'></i><span>請輸入文字</span>";
		nameflag = false;

	} else if (nameVal.length >= 2) {
		for (let i = 0; i < nameVal.length; i++) {
			let ch = nameVal.charCodeAt(i);
			console.log(ch);

			if (ch >= 0x4e00 && ch <= 0x9fff) {
				namenote.innerHTML = "<i style='color:green' class='fas fa-check-square'></i><span>輸入正確</span>";
				nameflag = true;
			} else {
				namenote.innerHTML = " <i style='color:red' class='fas fa-times-circle'></i><span>請輸入中文</span>";
				nameflag = false;

			}
		}
	} else {
		namenote.innerHTML = "<i style='color:red' class='fas fa-times-circle'></i><span>請輸入至少2個字</span>";
		nameflag = false;
	}
	
	checksubmit();

}

function checkNickName(){
		let nickname = document.getElementById("nickname");
	let nicknameVal = nickname.value;
	let nicknamenote = document.getElementById("nicknamenote");
	if (nicknameVal.length == "") {
		nicknamenote.innerHTML = "<i style='color:red' class='fas fa-times-circle'></i><span>請輸入文字</span>";
		nickcameflag = false;
	} else{
				nicknamenote.innerHTML = "<i style='color:green' class='fas fa-check-square'></i><span>輸入正確</span>";
				nickcameflag = true;
		}
	checksubmit();
	}


function checkAccount(){
	let re = new RegExp("^.+@.+\\..{2,3}$");
	let account = document.getElementById("account");
	let accountVal = account.value;
	let accountnote = document.getElementById("accountnote");
	
	if(accountVal==0){
		accountnote.innerHTML= "<i style='color:red' class='fas fa-times-circle'></i><span>請輸入 e-mail</span>";
		accountflag = false;
	}else if (re.test(accountVal)){
		accountnote.innerHTML= "<i style='color:green' class='fas fa-check-square'></i><span> e-mail 輸入正確</span>"
		accountflag = true;
	}else{
		accountnote.innerHTML= "<i style='color:red' class='fas fa-times-circle'></i><span>e-mail 格式錯誤</span>";
		accountflag = false;
		}
		checksubmit();
}


function checkPwd() {
	//取得輸入值並將物件轉換成值：
	let pwd = document.getElementById("password");
	console.log(typeof pwd);
	let pwdVal = pwd.value;
	console.log(typeof pwdVal);
	console.log(pwdVal);
	let flag1 = false,
		flag2 = false,
		flag3 = false;
	let namenote = document.getElementById("pwdnote");
	if (pwdVal == "") {
		namenote.innerHTML = "<i style='color:red' class='fas fa-times-circle'></i><span>請輸入文字</span>";
		passwordflag=false;
	} else if (pwdVal.length >= 4) {
		for (let i = 0; i < pwdVal.length; i++) {
			let ch = pwdVal.charAt(i).toUpperCase();
			console.log(ch);

			if (ch >= "A" && ch <= "Z") {
				flag1 = true;

			} else if (ch >= 0 && ch <= 9) {
				flag2 = true;

			} else if (ch == "!" || ch == "@" || ch == "#" || ch == "$" || ch == "%" || ch == "^" || ch == "&" || ch == "*") {
				flag3 = true;

			}

			if (flag1 && flag2 && flag3) {
				break;
			}
		}
		if (flag1 && flag2 && flag3) {
			namenote.innerHTML = "<i style='color:green' class='fas fa-check-square'></i><span>輸入正確</span>";
			passwordflag=true;
		} else {
			namenote.innerHTML = "<i style='color:red' class='fas fa-times-circle'></i><span>輸入格式錯誤</span>";
			passwordflag=false;

		}

	} else {
		namenote.innerHTML = "<i style='color:red' class='fas fa-times-circle'></i><span>輸入必須至少4碼</span>";
		passwordflag=false;

	}
	checksubmit()
}

function checkPwdcheck(){
	let pwdc = document.getElementById("passwordCheck");
	let pwdcVal = pwdc.value;
	let pwdcnote = document.getElementById("pwdchecknote")

	if(pwdcVal==(document.getElementById("password").value)){
		pwdcnote.innerHTML="<i style='color:green' class='fas fa-check-square'></i><span>輸入相同</span>";
		passwordCheckflag=true;
	}else{
		pwdcnote.innerHTML="<i style='color:red' class='fas fa-times-circle'></i><span>輸入與密碼不同</span>";
		passwordCheckflag=false;
	}
	checksubmit()
}

function checkDate() {
	let dateStr = document.getElementById("birth")
	dateStrVal = dateStr.value;
	let datenote = document.getElementById("birthnote");
	if(dateStrVal !==""){
		datenote.innerHTML = "<i style='color:green' class='fas fa-check-square'></i><span>日期確認</span>"
	}
}

//Date JQuery UI   
$(function() {
	$("#birth").datepicker({
 		yearRange: "1940:2020",
		changeMonth: true,
		changeYear: true
	});
});

function checkCell(){
	let cellnum = document.getElementById("cell");
	let cellnumVal = cellnum.value;
	let cellnumnote = document.getElementById("cellnote");

	if(cellnumVal.length<10){
		cellnumnote.innerHTML = "<i style='color:red' class='fas fa-times-circle'></i><span>輸入號碼少於10碼 </span>"
		cellflag = false;
	}else if(cellnumVal.length==10){
		let flag1 = false;
		let flag2 = false;

		if(cellnumVal.charAt(0)==0 &&cellnumVal.charAt(1)==9){
			 flag1 = true;
		}
		
		for(let i = 0; i < cellnumVal.length; i++){
			let ch = cellnumVal.charCodeAt(i);
			flag2 = false;
			if(ch >= 48 && ch <= 57){
				flag2 = true;

			}
		}
		
		if(flag1==true && flag2==true){
			cellnumnote.innerHTML = "<i style='color:green' class='fas fa-check-square'></i><span>輸入號碼正確</span>"
			cellflag = true;
		}else if(flag1==false && flag2==true){
			cellnumnote.innerHTML ="<i style='color:red' class='fas fa-times-circle'></i><span>前2碼不是(09...)]</span>"
			cellflag = false;
		}else{
			cellnumnote.innerHTML ="<i style='color:red' class='fas fa-times-circle'></i><span>輸入的不是號碼</span>"
			cellflag = false;
		}
		
	}else{
		cellnumnote.innerHTML = "<i style='color:red' class='fas fa-times-circle'></i><span>輸入超過10碼</span>"
		cellflag = false;
	}
	checksubmit()
	}
	
	function checksubmit(){
		if(nameflag == true && accountflag== true && passwordflag== true && passwordCheckflag== true && cellflag== true && nickcameflag == true){
		$('#button').prop("disabled",false);
		console.log("function worked!!")
		}else{
		$('#button').prop("disabled",true);
		}
		}
