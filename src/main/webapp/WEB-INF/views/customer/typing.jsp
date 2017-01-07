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
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/source/assets/css/typing.css" />
</head>
<body>
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
	<DIV style="display: none;">
		<TEXTAREA rows="" cols="" id="oldcontent">${question.content}</TEXTAREA>
		<INPUT type="hidden" id="useTime" value="${recode.useTime}" /> 
		<INPUT type="hidden" id="_accuracy" value="${recode.accuracy}" /> 
		<INPUT type="hidden" id="score" value="${recode.score}" />
	</DIV>
	<!-- 内容开始 -->
	<div class="center">
		<!---用户输入的文字 文本域-->
		<div>
			<form action="${pageContext.request.contextPath}/customer/examsubmit" method="post" onsubmit="return finish();" id="form">
				<INPUT type="hidden" id="typetext" name="typetext"/>
				<input type="hidden" id="time" name="time" /> 
				<input type="hidden" id="er" name="er" /> 
				<INPUT type="hidden" id="oid" value="${oid}" name="oid" /> 
				<INPUT type="hidden" id="oldContent" value="${recode.content}" /> 
				<INPUT type="hidden" id="examid" value="${exam.id}" name="examid" /> 
				<INPUT type="hidden" id="userid" value="${sessionScope.activeUser.id}" name="userid" />
				<INPUT type="hidden" id="_score" name="score" />
				<INPUT type="hidden" id="_accuracy_" name="accuracy" />
			</form>
		</div>
		<!--显示要打的文字 源文件-->
		<div id="ss" style="width: 100%"></div>
	</div>
	<div class="right">
		<SPAN class="am-badge am-badge-primary am-radius">经过时间:</SPAN> <span id="ttime" class="am-badge am-badge-primary am-radius"></span><br/>
		<SPAN class="am-badge am-badge-secondary am-radius">错误数量:</SPAN> <span id="error" class="am-badge am-badge-secondary am-radius"></span><br/>
		<SPAN class="am-badge am-badge-success am-radius">正确率:</SPAN> <span id="accuracy" class="am-badge am-badge-success am-radius"></span><br>
		<SPAN class="am-badge am-badge-warning am-radius">得分:</SPAN> <span id="_score_" class="am-badge am-badge-warning am-radius"></span><br>
		<input type="button" value="开始/暂停" onclick="begin();" class="am-btn am-btn-primary"/>&nbsp;
		<input type="button" value="提交" onclick="submit();" class="am-btn am-btn-warning"/> 
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

	<!--[if (gte IE 9)|!(IE)]><!-->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/source/assets/js/jquery.min.js"></script>
	<!--<![endif]-->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/source/assets/js/amazeui.min.js"></script>

	<script type="text/javascript" src="${pageContext.request.contextPath}/source/js/typing.min.js"></script>
	<SCRIPT type="text/javascript">
		$(function() {
			//获取要定位元素距离浏览器顶部的距离
			var navH = $(".right").offset().top;
			//滚动条事件
			$(window).scroll(function() {
				//获取滚动条的滑动距离
				var scroH = $(this).scrollTop();
				//滚动条的滑动距离大于等于定位元素距离浏览器顶部的距离，就固定，反之就不固定
				if (scroH >= navH) {
					$(".right").css({
						"position" : "fixed",
						"top" : "10px",
						"left" : "86%",
						"right":"1%"
					});
				} else if (scroH < navH) {
					$(".right").css({
						"position" : "static"
					});
				}
			})
		})
	</SCRIPT>
</body>
</html>
