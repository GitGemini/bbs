<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>${topic.tname}--河大论坛</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/topic.css">
</head>
<body>
	<%@ include file="header.jsp"%>

	<div id="topic_content">
		<h3>${topic.tname}论坛
			&nbsp;<small>${topic.info}</small>
		</h3>
		<c:if test="${requestScope.page.flag}">
			<ul class="pagination">
				<c:if test="${requestScope.page.currentPage > 1}">
					<li style="float: left;"><a
						href="${pageContext.request.contextPath}/topic/${topic.tname}?index=1">
							首页</a></li>
					<li style="float: left;" class="previous"><a
						href="${pageContext.request.contextPath}/topic/${topic.tname}?index=${requestScope.page.currentPage - 1}">
							上一页</a></li>
				</c:if>
				<li style="float: left; margin-left: 20px; margin-right: 20px;"
					class="disabled"><span>当前第${page.currentPage}页/共${page.totalPage}页</span></li>
				<li style="float: left; margin-right: 20px;"><form
						class="form-inline"
						action="${pageContext.request.contextPath}/topic/${topic.tname}">
						<span style="line-height: 35px; margin-left: 20px;">跳转到</span><input
						style="width:50px;"	type="text" width="40px" name="index" />页
						<button class="btn btn-default" type="submit">确定</button>
					</form></li>
				<c:if
					test="${requestScope.page.currentPage < requestScope.page.totalPage}">
					<li style="float: left;" class="next"><a
						href="${pageContext.request.contextPath}/topic/${topic.tname}?index=${requestScope.page.currentPage + 1}">下一页
					</a></li>
					<li style="float: left;"><a
						href="${pageContext.request.contextPath}/topic/${topic.tname}?index=${requestScope.page.totalPage}">
							尾页</a></li>
				</c:if>
			</ul>
		</c:if>


		<table class="table table-striped table-responsive">
			<thead>
				<tr>
					<th>标题</th>
					<th>提问人</th>
					<th>回复数</th>
					<th>发表时间</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${posts}" var="post">
					<tr>
						<td><a
							href="${pageContext.request.contextPath}/post/${post.title}?pid=${post.pid}">${post.title}</a></td>
						<td><a
							href="${pageContext.request.contextPath}/me/${post.user.username}">${post.user.username}</a></td>
						<td>${post.size}</td>
						<td>${post.createTime}</td>
					</tr>
				</c:forEach>				
			</tbody>
		</table>
	</div>
</body>
</html>
