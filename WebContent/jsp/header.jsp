<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.henu.entity.User"%>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/header.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<!-- 头部导航-->
<nav class="navbar navbar-inverse" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<img id="henu_img"
				src="${pageContext.request.contextPath}/img/henu.png"
				class="img-circle " /> <a class="navbar-brand" href="#">河大论坛</a>
		</div>
		<div>
			<ul class="nav navbar-nav">
				<li class="active"><a
					href="${pageContext.request.contextPath}/home">论坛首页</a></li>
				<li><a href="${pageContext.request.contextPath}/summary">论坛简介</a></li>
				<li><a href="${pageContext.request.contextPath}/help">论坛帮助</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"> 精选版块 <b class="caret"></b>
				</a>
					<ul class="dropdown-menu">
						<li><a href="${pageContext.request.contextPath}/topic/Jsp">Jsp</a></li>
						<li><a href="${pageContext.request.contextPath}/topic/ASP">ASP</a></li>
						<li><a href="${pageContext.request.contextPath}/topic/JavaScript">JavaScript</a></li>
						<li class="divider"></li>
						<li><a href="${pageContext.request.contextPath}/topic/Eclipse">Eclipse</a></li>
						<li><a href="${pageContext.request.contextPath}/topic/Java SE">Java SE</a></li>
					</ul></li>
				<li><a href="${pageContext.request.contextPath}/post/manage/add">我要发帖</a></li>

			</ul>
		</div>
		<%
			User user = (User) session.getAttribute("user");
			if (user == null) {
		%>
		<div style="padding-right: 30px;">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="${pageContext.request.contextPath}/user/to_register"><span
						class="glyphicon glyphicon-user"></span> 注册</a></li>
				<li><a href="${pageContext.request.contextPath}/user/to_login"><span
						class="glyphicon glyphicon-log-in"></span> 登录</a></li>
			</ul>
		</div>
		<%
			} else {
		%>

		<div class="dropdown navbar-right">
			<a class="dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown">
				<span
				style="font-size: 20px; line-height: 44px; margin-right: 20px;"
				class="glyphicon glyphicon-cog span_text"> </span>
			</a>
			<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				<li role="presentation" class="dropdown-header">管理用户信息</li>
				<li role="presentation"><a role="menuitem" href="${pageContext.request.contextPath}/user/to_edit"><span
						class="glyphicon glyphicon-edit"></span> 修改信息</a></li>
				<li role="presentation"><a role="menuitem" href="${pageContext.request.contextPath}/user/to_pwd"><span
						class="glyphicon glyphicon-edit"></span> 修改密码</a></li>
				<li role="presentation"><a role="menuitem" href="${pageContext.request.contextPath}/user/exit"><span
						class="glyphicon glyphicon-log-out"></span> 注销登录</a></li>	
			</ul>
		</div>
		<div class="navbar-right">
			<img style="height: 40px; float: left; margin: 4px 10px;"
				src="${pageContext.request.contextPath}/headicon/<%= user.getUsericon() %>" />
			<a class="span_text" href="${pageContext.request.contextPath}/me/${user.username}"><%=user.getUsername()%></a>
		</div>
		<%
			}
		%>
	</div>
</nav>
<!-- 头部结束 -->