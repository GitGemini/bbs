<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/register.css">
<script src="${pageContext.request.contextPath}/js/register.js"></script>
</head>
<body>
	<%@ include file="header.jsp"%>

	<div class="content">
		<div class="error_div">${errors.token}${errors.user}${errors.unknown}</div>
		<form onsubmit="return checkAll()" action="${pageContext.request.contextPath}/user/register"			
			method="POST" class="form-horizontal" role="form">
			<div class="form-group">
				<label class="col-sm-2 control-label">用户名：</label>
				<div class="col-sm-5">
					<input onblur="checkUserName()" placeholder="请输入2-8位用户名"
						name="username" value="${form.username }" class="form-control" type="text" />
				</div>
				<label id="tips_username" style="text-align: left;" class="col-md-5 control-label"></label>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">密码：</label>
				<div class="col-sm-5">
					<input onblur="checkPassword()" placeholder="请输入6-16位密码"
						name="password" value="${form.password }" class="form-control" type="password" />
				</div>
				<label style="text-align: left;"  id="tips_password" class="col-md-3 control-label"></label>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">确认密码：</label>
				<div class="col-sm-5">
					<input onblur="checkPwdRepeat()" placeholder="请再次输入密码"
						name="pwdrepeat" class="form-control" type="password" />
				</div>
				<label style="text-align: left;"  id="tips_pwdrepeat" class="col-md-3 control-label"></label>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">性别：</label>
				<div class="col-sm-5" style="padding:5px;">
					<input style="margin-left: 10px;" name="gender" value="男" checked type="radio" />男 
					<input style="margin-left: 10px;" name="gender" value="女" type="radio" /> 女
				</div>				
			</div>	
			<div class="form-group">
				<label class="col-sm-2 control-label">用户类型：</label>
				<div class="col-sm-5" style="padding:5px;">
					<select style="margin-left: 15px;" name="type">
							<option value="1">普通用户</option>
							<option value="2">管理员</option>
					</select>
				</div>				
			</div>	
			<div class="form-group">
				<label class="col-sm-2 control-label">联系电话：</label>
				<div class="col-sm-5">
					<input onblur="checkPhone()" placeholder="请输入正确的11位手机号"
						name="phone" value="${form.phone}" class="form-control" type="text" />
				</div>
				<label style="text-align: left;"  id="tips_phone" class="col-md-3 control-label"></label>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">电子邮件：</label>
				<div class="col-sm-5">
					<input onblur="checkEmail()" placeholder="请输入邮箱地址"
						name="email" value="${form.email}" class="form-control" type="email" />
				</div>
				<label style="text-align: left;"  id="tips_email" class="col-md-3 control-label"></label>
			</div>
			<input name="token" type="hidden" value="${token}"></input>
			<div class="form-group text-center">				
				<div class="col-md-6">
					<button class="btn btn-md btn-primary" type="submit">注册</button>
					<button style="margin-left:50px;" class="btn btn-md btn-danger" type="reset">重置</button>
				</div>
			</div>					
		</form>
	</div>
</body>
</html>