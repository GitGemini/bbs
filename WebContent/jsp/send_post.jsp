<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发帖页面</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/send_post.css" />
</head>
<body>
	<%@ include file="header.jsp"%>
	<div id="send_post_div">

		<form method="post" action="${pageContext.request.contextPath}/post/manage/Add">
			<div class="div_bar">发贴</div>
			<table style="width: 100%">
				<tr>
					<td class="col-md-2  div_left"><span>帖子标题</span></td>
					<td class="col-md-10 div_right"><input type="text"
						class="title_text" name="title"></input> <span class="title-tip"
						style="color: red;">你还可以输入<span id="title_left">80</span>个字符
					</span></td>
				</tr>
				<tr>
					<td class="col-md-2  div_left"><span>选择版块</span></td>
					<td class="col-md-10 div_right"><select name="tid">
							<c:forEach items="${topics}" var="topic">
								<option value="${topic.tid}">${topic.tname}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td class="col-md-2  div_left"><span>帖子内容</span></td>
					<td class="col-md-10 div_right">
						<div class="div_content">
							<textarea class="content_text" rows="5" cols="40" name="content"></textarea>
						</div> <span>你还可以输入<span id="content_left">255</span>个字符
					</span>
					</td>
				</tr>
				<tr>
				<td></td>
					<td>
						<button type="submit" class="btn btn-primary">发表帖子</button>
					</td>
				</tr>
			</table>
		</form>
	</div>	
<script src="${pageContext.request.contextPath}/js/send_post.js"></script>
</body>
</html>