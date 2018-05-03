<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>首页</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
</head>
<body>
	<%@ include file="jsp/header.jsp"%>
	<!--图片轮播区 -->
	<div id="myCarousel" class="carousel slide" data-ride="carousel"
		data-interval="3000">
		<!-- 轮播（Carousel）指标 -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>
		<!-- 轮播（Carousel）项目 -->
		<div class="carousel-inner">
			<div class="item active">
				<img src="${pageContext.request.contextPath}/img/img1.png">
			</div>
			<div class="item">
				<img src="${pageContext.request.contextPath}/img/img2.png">
			</div>
			<div class="item">
				<img src="${pageContext.request.contextPath}/img/img3.png">
			</div>
		</div>
	</div>
	<!--图片轮播区结束 -->
	<div id="forum" class="container">
		<c:forEach items="${forums}" var="forum">
			<div class="forum_header">
				<img class="forum_img" src="${pageContext.request.contextPath}/img/forum_icon.png" /> 
				<span class="forum_title">${forum.fname}</span> 
					<span class="forum_title">${forum.info}</span>
			</div>
			<c:forEach items="${forum.topicSet}" var="topic">
				<div class="div_forum">
					<h4>
						<a href="${pageContext.request.contextPath}/topic/${topic.tname}">${topic.tname} </a>
					</h4>
					版块介绍：${topic.info} <br /> 帖子数：${topic.size}
				</div>
			</c:forEach>
		</c:forEach>
	</div>
</body>
</html>