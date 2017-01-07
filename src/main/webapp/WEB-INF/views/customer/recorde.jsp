<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>Typing- 记录</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="format-detection" content="telephone=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="alternate icon" type="image/png"
	href="${pageContext.request.contextPath}/source/assets/i/favicon.png">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/source/assets/css/amazeui.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/source/assets/css/info.css" />
</head>
<body>
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
				<li class="am-active"><a href="#">记录中心</a></li>
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
		<div  class="info" style="margin-top: 3%;width: 70%" >
			<table border="1px solid #ccc" width="100%" >
				<tr align="center">
						<th style="width: 4%" >编号</th>
						<th style="width: 13%">测试名称</th>
						<th style="width: 10%">使用时间</th>
						<th style="width: 13%">分数</th>
						<th style="width: 11%">正确率</th>
						<th style="width: 20%">更新时间</th>
						<th style="width: 8%">状态</th>
						<th style="width: 8%">备注</th>
						<th style="width: 13%">操作</th>
					</tr>
				<s:forEach items="${erList}" var="v" varStatus="st">
					<tr align="center" bgcolor="#CFCFCF">
						<td>${st.index+1}</td>
						<td>${v.exam.name}</td>
						<td>${v.useTime}</td>
						<td>${v.score}</td>
						<td>${v.accuracy}</td>
						<td>${v.updateTime}</td>
						<td>${v.state=='1'?'正常':'锁定'}</td>
						<td>${v.remarks}</td>
						<td>
							<FORM action="${pageContext.request.contextPath}/customer/contyping" method="post" id="form">
								<INPUT type="hidden" name="uid" value="${sessionScope.activeUser.id}"/>
								<INPUT  type="hidden" name="udt" value="${v.updateTime}"/>
								<INPUT type="submit" value="继续上次"/>
							</FORM>
						</td>
					</tr>
				</s:forEach>
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
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/source/assets/js/jquery.min.js"></script>
		<!--<![endif]-->
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/source/assets/js/amazeui.min.js"></script>
</body>
</html>
