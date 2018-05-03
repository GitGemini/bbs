<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>论坛帮助</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/help.css">
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="content">
		
		<div class="help_left">
			<ul>
				<li><h4>
						<a href="#register_login">注册及登录</a>
					</h4>
				<li>
				<li><a href="#register_id">如何注册论坛账号</a></li>
				<li><a href="#login">如何登录论坛</a></li>
				<li><a href="#amend">修改密码</a></li>
				<li><h4>
						<a href="#manage">发帖及回帖</a>
					</h4></li>
				<li><a href="#post">关于发帖</a></li>
				<li><a href="#post_operate">帖子的相关操作</a></li>
			</ul>
		</div>
		<div class="help_right">
		<h2 style="text-align:center">论坛帮助</h2>
		<hr/>
			<h3 id="register_login">注册及登录
			</h3>
			<h4 id="register_id">如何注册论坛账号
			</h4>
			<p>
				点击论坛右上角的"注册"或者点击<a
					href="${pageContext.request.contextPath}/user/to_register"
					target="_blank">这里</a>进行注册。
			</p>
			<h4 id="login">如何登录论坛
			</h4>
			<p>如果您已经注册成功，您可以点击页面右上角的登录，进入登录界面填写正确的用户名、密码，点击"登录"即可完成登录。</p>
			<p>
				如果您还未注册请点<a
					href="${pageContext.request.contextPath}/user/to_register"
					target="_blank">这里</a>进行注册
			</p>
			<h4 id="amend">修改密码
			</h4>
			<p>论坛右上角"设置"—"修改密码" 可以修改登录密码。</p>
			<p>"设置"—"修改信息"可以修改注册手机号与个人信息。</p>
			<h3 id="manage">发帖及回帖
			</h3>
			<h4 id="post">关于发帖
			</h4>
			<h4>1、如何发帖？</h4>
			<p>点击页面右上方的"我要发帖"</p>

			<h4>2、帖子长度有何限制？</h4>
			<p>发帖内容长度不允许超过10000个字。不能少于10个字</p>
			<h4>3、帖子回复有何限制？</h4>
			<p>回复长度不允许超过10000个字。每个用户在同一帖内最多可以连续回复3次。回复不能少于6个字。</p>

			<h4 id="post_operate">帖子的相关操作
			</h4>
			<h4>如何删帖，删帖有何限制？</h4>
			<p>已登录用户登录自己的账户，进入自己的主页可以看到自己发出的贴子，并进行删除</p>
			<p>只有帖主可以删帖。</p>
		</div>
	</div>
</body>
</html>