<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>Typing- 练习</title>
<link rel="alternate icon" type="image/png"
	href="${pageContext.request.contextPath}/source/assets/i/favicon.png">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/source/assets/css/amazeui.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/source/assets/css/index.css" />
</head>
<body style="text-align: center;">
	<header class="am-topbar">
		<h1 class="am-topbar-brand">
			<a href="">Typing-</a>
		</h1>
		<shiro:hasRole name="flag"></shiro:hasRole>
		<button
			class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only"
			data-am-collapse="{target: '#doc-topbar-collapse'}">
			<span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span>
		</button>

		<div class="am-collapse am-topbar-collapse" id="doc-topbar-collapse">
			<ul class="am-nav am-nav-pills am-topbar-nav">
				<li class="am-active"><a href="#">练习中心</a></li>
				<li><a href="${pageContext.request.contextPath}/">返回</a></li>
			</ul>
			<shiro:authenticated>
				<form
					class="am-topbar-form am-topbar-left am-form-inline am-topbar-right">
					<ul class="am-nav am-nav-pills am-topbar-nav">
						<li class="am-dropdown" data-am-dropdown><a
							class="am-dropdown-toggle" data-am-dropdown-toggle
							href="javascript:;">${sessionScope.activeUser.realname}&nbsp;<span
								class="am-icon-caret-down"></span>
						</a>
							<ul class="am-dropdown-content">
								<li><a
									href="${pageContext.request.contextPath}/customer/info">个人资料</a></li>
								<li><a
									href="${pageContext.request.contextPath}/customer/recorde">打字记录</a></li>
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
	<DIV style="margin-top: 10%">
		<!-- 文章选择 -->

		<div id="article">
			<form  action="${pageContext.request.contextPath}/customer/typing"
				class="am-form" data-am-validator method="post" >
				<SELECT name="id" data-am-selected>
					<s:forEach items="${eList}" var="v">
						<OPTION value="${v.id }">${v.name}</OPTION>
					</s:forEach>
				</SELECT> <br>
				<br />
				<button class="am-btn am-btn-secondary" type="submit">确定</button>
			</form>
			<br>
			<br>
			<br>
		</div>
	</DIV>
	<!-- 这里是内容部分结束 -->
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