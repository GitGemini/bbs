function checkUserName() {
	var txtUser = document.getElementsByName("username").item(0);
	var tip = document.getElementById("tips_username");
	var tv = txtUser.value.trim();
	if ((tv.length < 2) || (tv.length > 8)) {
		tip.innerText = "用户名由2-8个字符组成";
		tip.style.color = "red";
		return false;
	} else {
		tip.innerText = "OK!"
		tip.style.color = "green";
		return true;
	}
}

function checkPassword() {
	var txtPwd = document.getElementsByName("password").item(0);
	var tip = document.getElementById("tips_password");
	var tv = txtPwd.value.trim();
	if ((tv.length < 6) || tv.length > 16) {
		tip.innerText = "请输入6-16位密码";
		tip.style.color = "red";
		return false;
	} else {
		tip.style.color = "green";
	}
	var reg = /[^A-Za-z0-9_]+/;
	var regs = /^[A-Za-z0-9_\u4e00-\u9fa5]+$/;

	if (!regs.test(tv)) {
		tip.innerText = "请输入6-16位密码";
		tip.style.color = "red";
		return false;
	} else {
		tip.innerText = "OK!";
		tip.style.color = "green";
	}
}

function checkPwdRepeat() {
	var txtPwd = document.getElementsByName("password").item(0);
	var txtRpt = document.getElementsByName("pwdrepeat").item(0);
	var tip = document.getElementById("tips_pwdrepeat");
	var tv1 = txtPwd.value.trim();
	var tv2 = txtRpt.value.trim();
	if ((!checkPassword()) && (tv2 === tv1)) {
		tip.innerText = "OK!";
		tip.style.color = "green";
	} else {
		tip.innerText = "两次密码不一致";
		tip.style.color = "red";
		return false;
	}
}

function checkEmail() {
	var txtEmail = document.getElementsByName("email").item(0);
	var tip = document.getElementById("tips_email");

	var regix = /^[A-Za-z\d]+([-_.][A-Za-z\d]+)*@([A-Za-z\d]+[-.])+[A-Za-z\d]{2,4}$/;
	var tv = txtEmail.value.trim();
	if (tv.length == 0 || (!regix.test(tv))) {
		tip.innerText = "请输入正确格式的邮箱地址！";
		tip.style.color = "red";
		return false;
	} else {
		tip.innerText = "OK！";
		tip.style.color = "green";
	}
}

function checkPhone() {
	var txtPhone = document.getElementsByName("phone").item(0);
	var tip = document.getElementById("tips_phone");

	var pattern = /^1[3|4|5|8][0-9]\d{4,8}$/;
	var tv = txtPhone.value.trim();
	if ((tv.length != 11) || (!pattern.test(tv))) {
		tip.innerText = "请输入正确的11位手机号码！";
		tip.style.color = "red";
		return false;
	} else {
		tip.innerText = "OK！";
		tip.style.color = "green";
	}
}

function checkAll() {
	if (false === checkUserName()) {
		return false;
	}
	if (false === checkPassword()) {
		return false;
	}
	if (false === checkPwdRepeat()) {
		return false;
	}
	if (false === checkEmail()) {
		return false;
	}
	if (false === checkPhone()) {
		return false;
	}
	return true;
}

function changeCode(img) {
	img.src = img.src + "?" + new Date().getTime();
}

// 多行文本输入框剩余字数计算  
function checkMaxInput(obj) {
	var maxLen = 255;
	var txtSummary = document.getElementsByName("synopsis").item(0);
	var tip = document.getElementById("tips_summary");
	tip.innerText = "您还可以输入255字";

	if (obj == null || obj == undefined || obj == "") {
		return;
	}
	var strResult;
	if (txtSummary.value.trim().length > maxLen) { // 如果输入的字数超过了限制  
		txtSummary.value = txtSummary.value.trim().substring(0, maxLen); // 就去掉多余的字  
		strResult = '您还可以输入' + (maxLen - txtSummary.value.trim().length) + '字'; // 计算并显示剩余字数  
	} else {
		strResult = '您还可以输入' + (maxLen - txtSummary.value.trim().length) + '字'; // 计算并显示剩余字数  
	}

	tip.innerText = strResult;
}
