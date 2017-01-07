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
<script type="text/javascript">
	$(function() {
		$(".delete").click(function() {
			var href = $(this).attr("href");
			$("form").attr("action", href).submit();
			return false;
		});
	})
</script>
</head>
<form action="" method="post">
	<input type="hidden" name="_method" value="DELETE" />
</form>
<body marginwidth="0" marginheight="0">
	<div class="container">
		<div class="public-content">
			<div class="public-content-header">
				<h3>全部测试</h3>
			</div>
			<div class="public-content-cont">
				<table class="public-cont-table">
					<tr>
						<th style="width: 4%">编号</th>
						<th style="width: 11%">名称</th>
						<th style="width: 14%">开始时间</th>
						<th style="width: 14%">结束时间</th>
						<th style="width: 18%">试题名</th>
						<th style="width: 14%">创建时间</th>
						<th style="width: 5%">状态</th>
						<th style="width: 11%">备注</th>
						<th style="width: 8%">操作</th>
					</tr>
					<s:forEach items="${eList}" var="v" varStatus="st">
						<tr>
							<td>${st.index+1}</td>
							<td>${v.name}</td>
							<td>${v.beginTime}</td>
							<td>${v.endTime}</td>
							<td>${v.question.title}</td>
							<td>${v.createTime}</td>
							<td>${v.state=='1'?'练习':'考试'}</td>
							<td>${v.remarks}</td>
							<td>
								<div class="table-fun">
									<shiro:hasPermission name="exam:update">
										<a href="${pageContext.request.contextPath}/exam/${v.id}">修改</a>
									</shiro:hasPermission>
									<shiro:hasPermission name="exam:delete">
										<a class="delete"
											href="${pageContext.request.contextPath}/exam/${v.id}">删除</a>
									</shiro:hasPermission>
								</div>
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