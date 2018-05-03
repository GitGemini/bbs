<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>重置密码</title>
<script src="${pageContext.request.contextPath}/js/user_pwd.js"></script>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="content">
		<div class="error_div">${tip}</div>
		<form method="POST"
			action="${pageContext.request.contextPath}/user/resetPwd"
			class="form-horizontal" role="form">
			<div class="form-group">
				<label class="col-sm-2 control-label">用户名：</label>
				<div class="col-sm-5">
					<input placeholder="请输入用户名" name="username" class="form-control"
						type="text" id="username" /> <span id="user-tip"
						style="display: none;">用户名由2-8个字符组成 </span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">手机号码：</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" name="phone"
						placeholder="请输入手机号"> <span id="phone-tip"
						style="display: none;">号码错误</span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">新密码：</label>
				<div class="col-sm-5">
					<input placeholder="请输入新的密码" name="password" class="form-control"
						type="password" id="password" /> <span id="psw-tip"
						style="display: none;"> 请输入6-12位密码</span>
				</div>
			</div>
			<div class="form-group">
				<label for="inputReptpwd" class="col-md-2 control-label">确认密码：</label>
				<div class="col-sm-5">
					<input type="password" class="form-control" id="password-again"
						placeholder="请再次输入密码"> <span id="pswa-tip"
						style="display: none;">两次密码不一致</span>
				</div>
			</div>
			<div class="form-group text-center">
				<div class="col-md-8">
					<button class="btn btn-md btn-primary" type="submit">确认</button>
					<button style="margin-left: 50px;" class="btn btn-md btn-danger"
						type="reset">取消</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>
