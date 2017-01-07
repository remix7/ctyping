<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="s"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<!DOCTYPE html>
<html>
<head>
<title>c-Typing</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="alternate icon" type="image/png"
	href="${pageContext.request.contextPath}/source/assets/i/favicon.png">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/source/css/reset.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/source/css/public.css">
</head>
<body>
	<shiro:lacksRole name="admin">
		<div align="center">
			<a href="${pageContext.request.contextPath}/"> <img alt=""
				src="${pageContext.request.contextPath}/source/images/ty.jpg">
			</a>
		</div>
	</shiro:lacksRole>
	<shiro:hasRole name="admin">
		<div class="public-header-warrp">
			<div class="public-header">
				<div class="content">
					<div class="public-header-logo">
						<a href=""><i>c-T</i>
							<h3>c-Typing</h3></a>
					</div>
					<%-- <p class="logo-des">创建于 ${sessionScope.adminUser.createTime}</p> --%>
					<div class="public-header-admin fr">
						<p class="admin-name">${sessionScope.activeUser.realname}管理员，您好！</p>
						<div class="public-header-fun fr">
							<a href="" class="public-header-man">管理</a> <a
								href="${pageContext.request.contextPath}/logout"
								class="public-header-loginout">安全退出</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- <div class="clearfix"></div> -->
		<!-- 内容展示 -->
		<div class="public-ifame mt20">
			<div class="content">
				<!-- 左侧导航栏 -->
				<div class="public-ifame-leftnav">
					<div class="public-title-warrp">
						<div class="public-ifame-title ">
							<a href="${pageContext.request.contextPath}/index.jsp">首页</a>
						</div>
					</div>
					<ul class="left-nav-list">

						<li class="public-ifame-item"><a href="javascript:;">用户管理</a>
							<div class="ifame-item-sub">
								<ul>
									<shiro:hasPermission name="user:list">
										<li><a href="${pageContext.request.contextPath}/userList"
											target="content">全部用户</a></li>
									</shiro:hasPermission>
									<shiro:hasPermission name="user:list">
										<li><a href="${pageContext.request.contextPath}/sessions"
											target="content">在线用户</a></li>
									</shiro:hasPermission>
								</ul>
							</div></li>
						<li class="public-ifame-item"><a href="javascript:;">题库管理</a>
							<div class="ifame-item-sub">
								<ul>
									<shiro:hasPermission name="question:list">
										<li><a
											href="${pageContext.request.contextPath}/questionList"
											target="content">全部试题</a>
									</shiro:hasPermission>
									<shiro:hasPermission name="question:insert">
										<li><a href="${pageContext.request.contextPath}/question"
											target="content">添加试题</a>
									</shiro:hasPermission>
								</ul>
							</div></li>
						<li class="public-ifame-item"><a href="javascript:;">测试管理</a>
							<div class="ifame-item-sub">
								<ul>
									<shiro:hasPermission name="exam:list">
										<li><a href="${pageContext.request.contextPath}/examList"
											target="content">测试列表</a></li>
									</shiro:hasPermission>
								</ul>
								<ul>
									<shiro:hasPermission name="exam:insert">
										<li><a href="${pageContext.request.contextPath}/exam"
											target="content">添加测试</a></li>
									</shiro:hasPermission>
								</ul>
							</div></li>
						<li class="public-ifame-item"><a href="javascript:;">测试记录</a>
							<div class="ifame-item-sub">
								<ul>
									<shiro:hasPermission name="recode:list">
										<li><a
											href="${pageContext.request.contextPath}/recodeList"
											target="content">全部记录</a></li>
									</shiro:hasPermission>
									<shiro:hasPermission name="recode:real">
										<li><a href="${pageContext.request.contextPath}/recode"
											target="content">实时记录</a></li>
									</shiro:hasPermission>
								</ul>
							</div></li>
						<li class="public-ifame-item"><a href="javascript:;">成绩管理</a>
							<div class="ifame-item-sub">
								<ul>
									<shiro:hasPermission name="score:list">
										<li><a href="${pageContext.request.contextPath}/score"
											target="content">全部成绩</a></li>
									</shiro:hasPermission>
								</ul>
							</div></li>
					</ul>
				</div>
				<!-- 右侧内容展示部分 -->
				<div class="public-ifame-content">
					<iframe name="content" src="" frameborder="0" id="mainframe"
						scrolling="yes" marginheight="0" marginwidth="0" width="100%"
						style="height: 700px;"></iframe>
				</div>
			</div>
		</div>
		<script
			src="${pageContext.request.contextPath}/source/js/jquery.min.js"></script>
		<script>
			$()
					.ready(
							function() {
								var item = $(".public-ifame-item");
								for (var i = 0; i < item.length; i++) {
									$(item[i])
											.on(
													'click',
													function() {
														$(".ifame-item-sub")
																.hide();
														if ($(
																this.lastElementChild)
																.css('display') == 'block') {
															$(
																	this.lastElementChild)
																	.hide()
															$(
																	".ifame-item-sub li")
																	.removeClass(
																			"active");
														} else {
															$(
																	this.lastElementChild)
																	.show();
															$(
																	".ifame-item-sub li")
																	.on(
																			'click',
																			function() {
																				$(
																						".ifame-item-sub li")
																						.removeClass(
																								"active");
																				$(
																						this)
																						.addClass(
																								"active");
																			});
														}
													});
								}
							});
		</script>
	</shiro:hasRole>
</body>
</html>