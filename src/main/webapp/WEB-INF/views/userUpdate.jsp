<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/source/css/reset.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/source/css/public.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/source/css/content.css" />
</head>
<body marginwidth="0" marginheight="0">
	<div class="container">
		<div class="public-content">
			<div class="public-content-header">
				<h3>用户修改</h3>
			</div>
			<div class="public-content-cont">
			<form action="${pageContext.request.contextPath}/user/${user.id}" method="post">
				<input type="hidden" name="_method" value="PUT"/>
				<div class="form-group">
					<label for="">登录名：</label>
					<input class="form-input-txt" type="text" name="username" value="${user.username}" readonly="readonly"/>
					<H6  style="font-size: 1;color: red;margin-left: 95px;margin-top: 7px">${username}</H6>
				</div>
				<div class="form-group">
					<label for="">登录密码：</label>
					<input class="form-input-txt" type="text" name="password" value="" />
					<H6  style="font-size: 1;color: red;margin-left: 95px;margin-top: 7px">${password}</H6>
				</div>
				<div class="form-group">
					<label for="">学生姓名：</label>
					<input class="form-input-txt" type="text" name="realname" value="${user.realname}" />
					<H6  style="font-size: 1;color: red;margin-left: 95px;margin-top: 7px">${realname}</H6>
				</div>
				<div class="form-group">
					<label for="">手机号码：</label>
					<input class="form-input-txt" type="text" name="phoneNum" value="${user.phoneNum }" />
					<H6  style="font-size: 1;color: red;margin-left: 95px;margin-top: 7px">${phoneNum}</H6>
				</div>
				<div class="form-group">
					<label for="">学生学号：</label>
					<input class="form-input-txt" type="text" name="stuNum" value="${user.stuNum}" />
					<H6  style="font-size: 1;color: red;margin-left: 95px;margin-top: 7px">${stuNum}</H6>
				</div>
				<div class="form-group">
					<label for="">学生邮箱：</label>
					<input class="form-input-txt" type="text" name="email" value="${user.email}" />
					<H6  style="font-size: 1;color: red;margin-left: 95px;margin-top: 7px">${email}</H6>
				</div>
				<div class="form-group">
					<label for="">状态：</label>
					<select class="form-select" name="state">
						<option value="1">正常</option>
						<option value="2">锁定</option>
					</select>
					<H6  style="font-size: 1;color: red;margin-left: 95px;margin-top: 7px">${state}</H6>
				</div>
				<div class="form-group">
					<label for="">备注：</label>
					<input class="form-input-txt" type="text" name="remarks" value="${user.remarks}" />
				</div>
				<div class="form-group" style="margin-left:200px;margin-top: 30px">
					<input type="submit" class="sub-btn" value="提  交" />
				</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>