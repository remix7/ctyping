<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>Typing- 测试</title>
<link rel="alternate icon" type="image/png"
	href="${pageContext.request.contextPath}/source/assets/i/favicon.png">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/source/assets/css/amazeui.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/source/assets/css/info.css" />

</head>
<body style="text-align: center;">
	<header class="am-topbar">
		<h1 class="am-topbar-brand">
			<a href="">Typing-</a>
		</h1>

		<button
			class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only"
			data-am-collapse="{target: '#doc-topbar-collapse'}">
			<span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span>
		</button>

		<div class="am-collapse am-topbar-collapse" id="doc-topbar-collapse">
			<ul class="am-nav am-nav-pills am-topbar-nav">
				<li class="am-active"><a href="#">测试中心</a></li>
				<li><a href="${pageContext.request.contextPath}/">返回</a></li>
			</ul>
			<shiro:authenticated>
				<form
					class="am-topbar-form am-topbar-left am-form-inline am-topbar-right">
					<ul class="am-nav am-nav-pills am-topbar-nav">
						<li class="am-dropdown" data-am-dropdown><a
							class="am-dropdown-toggle" data-am-dropdown-toggle
							href="javascript:;">${sessionScope.activeUser.realname}&nbsp;<span class="am-icon-caret-down"></span>
						</a>
							<ul class="am-dropdown-content">
								<li><a href="${pageContext.request.contextPath}/customer/info">个人资料</a></li>
								<li><a href="${pageContext.request.contextPath}/customer/recorde">打字记录</a></li>
								<li><a href="${pageContext.request.contextPath}/logout">退出系统</a></li>
							</ul></li>
					</ul>
				</form>
			</shiro:authenticated>
			<shiro:notAuthenticated>
				<form
					class="am-topbar-form am-topbar-left am-form-inline am-topbar-right">
					<ul class="am-nav am-nav-pills am-topbar-nav">
						<li class="am-dropdown"><a
							href="${pageContext.request.contextPath}/login">登录</a></li>
						<li class="am-dropdown"><a
							href="${pageContext.request.contextPath}/customer/register">注册</a></li>
					</ul>
				</form>
			</shiro:notAuthenticated>
		</div>
	</header>
	<!-- 内容开始 -->
	<div class="info">
		<table border="1px solid #ccc" width="100%">
			<tr>
				<td><h2>昵称：</h2></td>
				<td><h3>${user.realname}</h3></td>
			</tr>
			<tr>
				<td><h2>用户名：</h2></td>
				<td><h3>${user.username}</h3></td>
			</tr>
			<tr>
				<td><h2>学号：</h2></td>
				<td><h3>${user.stuNum}</h3></td>

			</tr>
			<tr>
				<td><h2>手机号：</h2></td>
				<td><h3>${user.phoneNum}</h3></td>
			</tr>
			<tr>
				<td><h2>邮箱：</h2></td>
				<td><h3>${user.email}</h3></td>
			</tr>
			<tr>
				<td><h2>注册时间：</h2></td>
				<td><h3>${user.createTime}</h3></td>
			</tr>
		</table>
	</div>
	<!-- 内容结束 -->
	<footer class="blog-footer">
		<p>
			在线打字<br /> <small>© 2016 网络工程学院1005互联网+实验室</small>
		</p>
	</footer>

	<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="${pageContext.request.contextPath}/source/assets/js/amazeui.ie8polyfill.min.js"></script>
<![endif]-->

	<!--[if (gte IE 9)|!(IE)]><!-->
	<script
		src="${pageContext.request.contextPath}/source/assets/js/jquery.min.js"></script>
	<!--<![endif]-->
	<script
		src="${pageContext.request.contextPath}/source/assets/js/amazeui.min.js"></script>
</body>
</html>
