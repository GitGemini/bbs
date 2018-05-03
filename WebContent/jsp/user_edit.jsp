<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改用户信息</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/register.css">
<script src="${pageContext.request.contextPath}/js/register.js"></script>
</head>
<body>
	<%@ include file="header.jsp"%>

	<div class="content">
		<form onsubmit="return checkAll()" action="${pageContext.request.contextPath}/user/editUser"			
			method="POST" class="form-horizontal" role="form">
			<div class="form-group">
				<label class="col-sm-2 control-label">用户名：</label>			
				<div class="col-sm-5 ">
					<label class="col-sm-5 form-control">${user.username}</label>		
				</div> 
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label">性别：</label>
				<div class="col-sm-5" style="padding:5px;">
					<input style="margin-left: 10px;" name="gender" value="男" checked type="radio" />男 
					<input style="margin-left: 10px;" name="gender" value="女" type="radio" /> 女
				</div>				
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">联系电话：</label>
				<div class="col-sm-5">
					<input onblur="checkPhone()" placeholder="请输入正确的11位手机号"
						name="phone" value="${user.phone}" class="form-control" type="text" />
				</div>
				<label style="text-align: left;" id="tips_phone" class="col-md-3 control-label"></label>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">电子邮件：</label>
				<div class="col-sm-5">
					<input onblur="checkEmail()" placeholder="请输入邮箱地址"
						name="email" value="${user.email}" class="form-control" type="email" />
				</div>
				<label style="text-align: left;"  id="tips_email" class="col-md-3 control-label"></label>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label">个人简介：</label>
				<div class="col-sm-5">
					<textarea name="synopsis" class="form-control" rows="5" cols="60"
  						onkeydown="checkMaxInput(this)" onkeyup="checkMaxInput(this)" onfocus="checkMaxInput(this)"></textarea>
				</div>
				<label style="text-align: left;" id="tips_summary" class="col-md-3 control-label"></label>
			</div>
			
			<div class="form-group text-center">				
				<div class="col-md-6">
					<button class="btn btn-md btn-primary" type="submit">保存</button>
					<button style="margin-left:50px;" class="btn btn-md btn-danger" type="reset">重置</button>
				</div>
			</div>					
		</form>
	</div> 
</body>
</html>