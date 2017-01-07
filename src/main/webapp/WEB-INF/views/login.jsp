<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Typing- 登录</title>
<link rel="alternate icon" type="image/png"
	href="${pageContext.request.contextPath}/source/assets/i/favicon.png">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/source/css/reset.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/source/css/login-student.css" />
</head>
<body>
	<div class="page">
		<div class="loginwarrp">
			<div class="logo">
				登录 <label style="margin-top: 10px; color: #F00">${errorMessage}</label>
			</div>

			<div class="login_form">
				<form method="post"
					action="${pageContext.request.contextPath}/login">
					<li class="login-item"><span>用户名：</span> <input type="text"
						name="username" class="login_input"></li>
					<li class="login-item"><span>密 码：</span> <input
						type="password" name="password" class="login_input"></li>
					<li class="login-item verify"><span>验证码：</span> <input
						type="text" name="randomcode" class="login_input verify_input">
					</li> <img id="image1"
						src="${pageContext.request.contextPath}/ValidateCode" border="1"
						class="verifyimg" height="40px" width="140 px" onClick="getcode()" />
					<div style="margin-top: 15px">
						<input id="ck1" type="checkbox" name="rememberMe" /><label
							onclick="checked()">记住我</label>
					</div>
					<li class="login-sub"><input type="submit" value="登录" /></li>
				</form>
			</div>
		</div>
		<footer class="blog-footer">
			<p>
				在线打字<br />
				<br /> <small>© 2016 网络工程学院1005互联网+实验室</small>
			</p>
		</footer>
	</div>

	<script type="text/javascript">
		function getcode() {
			var randomnum = Math.random();
			var img = document.getElementById("image1");
			img.src = "ValidateCode?d=" + randomnum;
		}
		function checked() {
			var ck = document.getElementById("ck1");
			if (ck.checked) {
				ck.checked = false;
			} else {
				ck.checked = true;
			}
		}
	</script>
</body>
</html>