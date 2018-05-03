<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传头像</title>
<script src="${pageContext.request.contextPath}/js/upload.js"></script>
</head>
<body>
	<%@ include file="header.jsp"%>
	<span>${tip}</span>
	<form action="${pageContext.request.contextPath}/user/uploadHead"
		method="POST" class="form-horizontal" role="form"
		enctype="multipart/form-data">

		<div class="content">
			<h3>上传头像</h3>
			<label>仅支持JPG,JPEG,GIF,PNG格式;文件小于5M</label>
			<div class="form-group">
				<div class="col-sm-8">
					<input type="file" name="file" onchange="fileChange(this)" />
				</div>
			</div>
			<img id="show_img"
				style="width: 100px; height: 100px;"
				src="${pageContext.request.contextPath}/headicon/${user.usericon}">

			<div class="form-group text-center">
				<div class="col-md-6">
					<button class="btn btn-md btn-primary" type="submit">保存</button>
					<button style="margin-left: 50px;" class="btn btn-md btn-danger"
						type="reset">重置</button>
				</div>
			</div>
		</div>
	</form>
</body>
</html>