<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
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
			<s:if test="${question.id!=null}">
				<h3>试题修改</h3>
			</s:if>
			<s:if test="${question.id==null}">
				<h3>增加试题</h3>
			</s:if>
			</div>
			<div class="public-content-cont">
			<form action="${pageContext.request.contextPath}/question/${question.id}" method="post">
				<s:if test="${question.id!=null}">
					<input type="hidden" name="_method" value="PUT"/>
				</s:if>
				<div class="form-group">
					<label for="">标题：</label>
					<input class="form-input-txt" type="text" name="title" value="${question.title}" />
					<H6  style="font-size: 1;color: red;margin-left: 95px;margin-top: 7px">${title}</H6>
				</div>
				<div class="form-group">
					<label for="">内容：</label>
					<textarea rows="10" cols="50" name="content">${question.content}</textarea>
					<H6  style="font-size: 1;color: red;margin-left: 95px;margin-top: 7px">${content}</H6>
				</div>
				<div class="form-group">
					<label for="">难易程度：</label>
					<select class="form-select" name="degree">
						<option value="1">简单</option>
						<option value="2">困难</option>
					</select>
				</div>
				<div class="form-group">
					<label for="">状态：</label>
					<select class="form-select" name="state" >
						<option value="1">正常</option>
						<option value="2">锁定</option>
					</select>
					<H6  style="font-size: 1;color: red;margin-left: 95px;margin-top: 7px">${state}</H6>
				</div>
				<div class="form-group">
					<label for="">备注：</label>
					<input class="form-input-txt" type="text" name="remarks" value="${question.remarks}" />
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