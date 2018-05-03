//验证用户名
$("#username").blur(function() {
	if (this.value.length < 2 || this.value.length > 8) {
		$("#user-tip").css("color", "red").show();
	} else {
		$("#user-tip").hide();
	}
});
// 验证密码
$("#password").blur(function() {
	if (this.value.length < 6 || this.value.length > 12) {
		$("#psw-tip").css("color", "red").show();
	} else {
		$("#psw-tip").hide();
	}
});
// 验证确认密码
$("#password-again").blur(function() {
	var password = $("#password").val();
	if (this.value != password) {
		$("#pswa-tip").css("color", "red").show();
	} else {
		$("#pswa-tip").hide();
	}
});
// 验证电话号码
$("#phone").blur(function() {
	var reg = /^1[3,5,7,8][0-9]{9}$/;
	if (!this.value.match(reg)) {
		$("#phone-tip").css("color", "red").show();
	} else {
		$("#phone-tip").hide();
	}
});
// 在提交表单前判断是否有空值
$("form").submit(function() {
	var sign = true;
	if ($("#username").val() == "") {
		alert("用户名不能为空");
		sign = false;
	}
	if ($("#password").val() == "") {
		alert("密码不能为空");
		sign = false;
	}
	if ($("#password-again").val() == "") {
		alert("确认密码不能为空");
		sign = false;
	}
	if ($("#phone").val() == "") {
		alert("电话不能为空");
		sign = false;
	}
	// 如果有空值，则应阻止表单提交
	if (!sign) {
		return false;
	}
});