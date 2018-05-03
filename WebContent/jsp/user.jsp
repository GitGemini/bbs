<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/user.css">
<title>${me.username}--主页</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="container" style="padding: 10px;">
		<div class="div-content row">
			<div class="col-md-3 pannel pannel-default div-left">
				<div>
					<img
						style="display: block; height: 100px; margin: 20px auto; background: #EFF4FB;"
						src="${pageContext.request.contextPath}/headicon/${me.usericon}" />
					<c:if test="${isLogin}">
						<a style="margin-left: 80px;"
							href="${pageContext.request.contextPath}/user/to_head"><span
							class="glyphicon glyphicon-edit"></span> 上传头像</a>
					</c:if>
				</div>
				<div style="margin: 0 auto;">
					<ul class="list-group">
						<li class="list-group-item">用户名:${me.username}</li>
						<li class="list-group-item">性别: ${me.gender}</li>
						<li class="list-group-item">手机号: ${me.phone}</li>
						<li class="list-group-item">邮箱: ${me.email}</li>
						<li class="list-group-item">个人简介: ${me.synopsis}</li>
					</ul>
					<c:if test="${isLogin}">
						<a style="margin-left: 80px;"
							href="${pageContext.request.contextPath}/user/to_edit"><span
							class="glyphicon glyphicon-edit"></span> 修改个人信息</a>
					</c:if>

				</div>
			</div>
			<div class="col-md-9 div-right">
				<c:choose>
					<%-- 选择发帖 --%>
					<c:when test="${part ==1}">
						<ul class="nav nav-tabs" id="myTab">
							<li class="active"><a
								href="${pageContext.request.contextPath}/me/${me.username}?part=1">我发表的帖子</a></li>
							<li><a
								href="${pageContext.request.contextPath}/me/${me.username}?part=2">我发表的回复</a></li>
						</ul>
						<div id="myPost" class="tab-content" style="padding: 10px;">

							<table class="table table-striped table-responsive">
								<thead>
									<tr>
										<th>标题</th>
										<th>回复数</th>
										<th>发表时间</th>
										<c:if test="${isLogin}">
											<th>管理</th>
										</c:if>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${posts}" var="post">
										<tr>
											<td><a
												href="${pageContext.request.contextPath}/post/${topic.tname}?pid=${post.pid}">${post.title}</a></td>
											<td>${post.size}</td>
											<td>${post.createTime}</td>
											<c:if test="${isLogin}">
												<td><a
													href="${pageContext.request.contextPath}/post/manage/delete?pid=${post.pid}">删除</a></td>
											</c:if>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<c:if test="${requestScope.page.flag}">
								<ul class="pagination">
									<c:if test="${requestScope.page.currentPage > 1}">
										<li style="float: left;"><a
											href="${pageContext.request.contextPath}/me/${me.username}?part=1&index=1">&laquo;
										</a></li>
										<li style="float: left;" class="previous"><a
											href="${pageContext.request.contextPath}/me/${me.username}?part=1&index=${requestScope.page.currentPage - 1}">&larr;
										</a></li>
									</c:if>
									<c:if
										test="${requestScope.page.currentPage < requestScope.page.totalPage}">
										<li style="float: left;" class="next"><a
											href="${pageContext.request.contextPath}/me/${me.username}?part=1&index=${requestScope.page.currentPage + 1}">
												&rarr;</a></li>
										<li style="float: left;"><a
											href="${pageContext.request.contextPath}/me/${me.username}?part=1&index=${requestScope.page.totalPage}">&raquo;
										</a></li>
									</c:if>
								</ul>
							</c:if>
						</div>
					</c:when>

					<%-- 选择回复 --%>
					<c:when test="${part ==2}">
						<ul class="nav nav-tabs" id="myTab">
							<li><a
								href="${pageContext.request.contextPath}/me/${me.username}?part=1">我发过的帖子</a></li>
							<li class="active"><a
								href="${pageContext.request.contextPath}/me/${me.username}?part=2">我回复的帖子</a></li>
						</ul>

						<div id="myPost" class="tab-content" style="padding: 10px;">

							<table class="table table-striped table-responsive">
								<tbody>
									<c:forEach items="${replies}" var="reply">
										<tr>
											<td>${reply.replyTime}&nbsp;回复了帖子：&nbsp;<a
												href="${pageContext.request.contextPath}/post/${topic.tname}?pid=${post.pid}"><span
													class="text_pre">${reply.post.title}</span></a><br />
												${reply.content}
											</td>
										</tr>
									</c:forEach>

								</tbody>
							</table>
							<c:if test="${requestScope.page.flag}">
								<ul class="pagination">
									<c:if test="${requestScope.page.currentPage > 1}">
										<li style="float: left;"><a
											href="${pageContext.request.contextPath}/me/${me.username}?part=2&index=1">&laquo;
										</a></li>
										<li style="float: left;" class="previous"><a
											href="${pageContext.request.contextPath}/me/${me.username}?part=2&index=${requestScope.page.currentPage - 1}">&larr;
										</a></li>
									</c:if>
									<c:if
										test="${requestScope.page.currentPage < requestScope.page.totalPage}">
										<li style="float: left;" class="next"><a
											href="${pageContext.request.contextPath}/me/${me.username}?part=2&index=${requestScope.page.currentPage + 1}">
												&rarr;</a></li>
										<li style="float: left;"><a
											href="${pageContext.request.contextPath}/me/${me.username}?part=2&index=${requestScope.page.totalPage}">&raquo;
										</a></li>
									</c:if>
								</ul>
							</c:if>
						</div>
					</c:when>
				</c:choose>

			</div>
		</div>
	</div>
</body>
</html>