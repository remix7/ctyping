<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/source/css/reset.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/source/css/content.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/source/js/jquery.min.js"></script>

</head>

<body marginwidth="0" marginheight="0">
	<div class="container">
		<div class="public-content">
			<div class="public-content-header">
				<h3>全部记录</h3>
			</div>
			<div class="public-content-cont">
				<table class="public-cont-table">
					<tr>
						<th style="width: 3%">编号</th>
						<th style="width: 20%">SessionId</th>
						<th style="width: 10%">有效时间</th>
						<th style="width: 20%">登录时间</th>
						<th style="width: 19%">最后活动</th>
						<th style="width: 10%">IP</th>
						<th style="width: 11%">真实姓名</th>
						<th style="width: 7%">操作</th>
					</tr>
					<s:forEach items="${sessions}" var="v" varStatus="st">
						<tr>
							<td>${st.index+1}</td>
							<td>${v.id}</td>
							<td>${v.timeout}ms</td>
							<td>${v.startTimestamp.month+1}-${v.startTimestamp.date} ${v.startTimestamp.hours}:${v.startTimestamp.minutes}:${v.startTimestamp.seconds}</td>
							<td>${v.lastAccessTime.month+1}-${v.lastAccessTime.date} ${v.lastAccessTime.hours}:${v.lastAccessTime.minutes}:${v.lastAccessTime.seconds}</td>
							<td>${v.host}</td>
							<td>${v.attributes.activeUser.realname}</td>
							<td>
								<a href="${pageContext.request.contextPath}/reject/${v.id}">剔除登录</a>
							</td>
						</tr>
					</s:forEach>
				</table>
				<!-- 
				<div class="page">
					<form action="" method="get">
					共<span>42</span>个站点
						<a href="">首页</a>
						<a href="">上一页</a>
						<a href="">下一页</a>
						第<span style="color:red;font-weight:600">12</span>页
						共<span style="color:red;font-weight:600">120</span>页
						<input type="text" class="page-input">
						<input type="submit" class="page-btn" value="跳转">
					</form>
				</div>
				 -->
			</div>
		</div>
	</div>
</body>
</html>