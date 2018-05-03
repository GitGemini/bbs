<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>${post.title}--河大论坛</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/post.css">
</head>
<body>
	<%@ include file="header.jsp"%>
	<script src="${pageContext.request.contextPath}/js/post.js"></script>

	<div id="reply_content">
		<c:if test="${page.flag}">
			<ul class="pagination">
				<c:if test="${page.currentPage > 1}">
					<li style="float: left;"><a
						href="${pageContext.request.contextPath}/post/?pid=${post.pid}&index=1">
							首页</a></li>
					<li style="float: left;" class="previous"><a
						href="${pageContext.request.contextPath}/post/?pid=${post.pid}&index=${requestScope.page.currentPage - 1}">
							上一页</a></li>
				</c:if>
				<li style="float: left; margin-left: 20px; margin-right: 20px;"
					class="disabled"><span>当前第${page.currentPage}页/共${page.totalPage}页</span></li>
				<li style="float: left; margin-right: 20px;"><form
						class="form-inline"
						action="${pageContext.request.contextPath}/post/?pid=${post.pid}">
						<span style="line-height: 35px; margin-left: 20px;">跳转到</span><input
							style="width:50px;" type="text" name="index" />页
						<button class="btn btn-default" type="submit">确定</button>
					</form></li>
				<c:if
					test="${requestScope.page.currentPage < requestScope.page.totalPage}">
					<li style="float: left;" class="next"><a
						href="${pageContext.request.contextPath}/post/?pid=${post.pid}&index=${requestScope.page.currentPage + 1}">下一页
					</a></li>
					<li style="float: left;"><a
						href="${pageContext.request.contextPath}/post/?pid=${post.pid}&index=${requestScope.page.totalPage}">
							尾页</a></li>
				</c:if>
			</ul>
		</c:if>
		<div id="post_div">
			<div class="post_title">${post.title}
				<a style="float: right; margin-top: -7px;" class="btn btn-default"
					href="#text_reply">回复</a>				
			</div>

			<div style="margin: 0;" class="reply_div row">
				<div class="col-md-2  div_right">
					<img style="display: block; height: 100px; margin: 20px auto;"
						src="${pageContext.request.contextPath}/headicon/${post.user.usericon}" />
					<div class="text-center">
						<a href="${pageContext.request.contextPath}/me/${post.user.username}">${post.user.username}</a>
					</div>
				</div>
				<div style="padding: 0;" class="col-md-10">
					<div class="div_content"><p>${post.content}</p></div>
					<div class="div_time">
						发表于： ${post.createTime} <span style="float: right;">楼主</span>
					</div>
				</div>
			</div>
			<c:forEach items="${replies}" var="reply" varStatus="i">
				<div style="margin: 10px 0;" class="reply_div row">
					<div class="col-md-2  div_right">
						<img style="display: block; height: 100px; margin: 20px auto;"
							src="${pageContext.request.contextPath}/headicon/${reply.user.usericon}" />
						<div class="text-center">
							<a
								href="${pageContext.request.contextPath}/me/${reply.user.username}">${reply.user.username}</a>
						</div>
					</div>
					<div style="padding: 0;" class="col-md-10">
						<div class="div_content">
							${reply.content}
						</div>
						<div class="div_time">
							回复于：${reply.replyTime} <span style="float: right;">#
								${i.count}</span>
						</div>
					</div>
				</div>
			</c:forEach>
			<div class="reply_div">
				<form
					action="${pageContext.request.contextPath}/reply/add?pid=${post.pid}"
					method="post">
					<textarea onkeydown="checkText()" onkeyup="checkText()" name="content" id="text_reply" rows="20" cols="40"
						style="width: 980px; height: 150px; margin: 10px;"></textarea>
					<button disabled="disabled" id="btn_reply" class="btn btn-primary" style="margin-left: 20px;">提交回复</button>
					<span>你还可以输入<span id="left_count">255</span>个字符
					</span>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
