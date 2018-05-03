<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="content">
		<div class="error_div">${tip}</div>
		<form onsubmit="return checkAll()" action="${pageContext.request.contextPath}/user/login"
			method="POST" class="form-horizontal" role="form">
			<div class="form-group">
				<label class="col-sm-2 control-label">用户名：</label>
				<div class="col-sm-5">
					<input placeholder="请输入用户名或手机号" name="username" class="form-control"
						type="text" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">密码：</label>
				<div class="col-sm-5">
					<input placeholder="请输入密码" name="password" class="form-control"
						type="password" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label">验证码：</label>
				<div class="col-sm-2">
					<input name="code" class="form-control" type="text" />
				</div>
				<div class="col-md-3">
					<img src="${pageContext.request.contextPath}/user/to_code"
						onclick="changeCode(this)" />
				</div>
			</div>
			<div class="form-group text-center" >
				<a href="${pageContext.request.contextPath}/user/to_pwd"><span
						class="glyphicon glyphicon-edit"></span> 忘记密码</a>
			</div>
			

			<div class="form-group text-center">
				<div class="col-md-6">
					<button class="btn btn-md btn-primary" type="submit">登录</button>
					<button style="margin-left: 50px;" class="btn btn-md btn-danger"
						type="reset">重置</button>
				</div>
			</div>
		</form>
	</div>
	<script type="text/javascript">
		function changeCode(img) {
			img.src = img.src + "?" + new Date().getTime();
		}
	</script>
</body>
</html>