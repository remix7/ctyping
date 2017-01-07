<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>Typing- 注册</title>
<link rel="alternate icon" type="image/png"
	href="${pageContext.request.contextPath}/source/assets/i/favicon.png">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/source/assets/css/amazeui.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/source/assets/css/register.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/source/assets/js/jquery.min.js"></script>

</head>
<body>
	<div class="header">
		<div class="am-g">
			<h1>START</h1>
			<p>
				<em>A man's best friends are his ten fingers.</em><br />人最好的朋友是自己的十个手指。
				<H6 style="font-size: 1; color: red; margin-top: 7px">${error}</H6>
			</p>
		</div>
	</div>
	<div class="am-g" style="width: 70%; margin-left: 20%;">
		<div class="am-u-lg-6 am-u-md-8 am-u-sm-centered">
			<form action="${pageContext.request.contextPath}/customer/register" method="post">
				<DIV class="am-form-group">
					<label for="text">真实姓名:</label> <br />
					<input type="text" name="realname" value="${user.realname}" style="width: 70%; height: 35px" class="am-form-field" required />
					<label for="text">登录名:</label> <br />
					<input type="text" name="username"  value="${user.username}" style="width: 70%;height: 35px" class="am-form-field" required>
					<label for="password">密码:</label> <br />
					<input type="password" name="password"  value="" style="width: 70%;height: 35px" class="am-form-field" required>
					<label for="text">学号:</label> <br />
					<input type="text" name="stuNum"  value="${user.stuNum}" style="width: 70%;height: 35px" class="am-form-field" required>
					<label for="text">手机号:</label> <br />
					<input type="text" name="phoneNum"  value="${user.phoneNum}" style="width: 70%;height: 35px" class="am-form-field" required>
					<label for="text">邮箱:</label> <br />
					<input type="text" name="email"  value="${user.email}" style="width: 70%;height: 35px" class="am-form-field" required>
					<label for="text">验证码:</label> <br />
					<input type="text" name="randomcode" style="width: 50%;height: 35px;" >&nbsp;
					<img id="image1" src="${pageContext.request.contextPath}/ValidateCode" style="width: 120px; height: 32px;" onClick="getcode()">
					<H6 style="font-size: 1; color: red; margin-top: 7px">${randomcode}</H6>
				</DIV>
				<DIV align="center">
					<input type="submit" value="注册" class="am-btn am-btn-primary am-btn-sm am-fl" >
				</DIV>
			</form>
			<!-- 这里是内容部分结束 -->
			<footer class="blog-footer">
				<p>
					在线打字<br /> <small>© 2016 网络工程学院1005互联网+实验室</small>
				</p>
			</footer>
		</div>
	</div>
	<script type="text/javascript">
	function getcode() {
	    var randomnum = Math.random();
	    var img = document.getElementById("image1");
	    img.src = "${pageContext.request.contextPath}/ValidateCode?d=" + randomnum;
} 
</script>
</body>
</html>
