<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/source/css/reset.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/source/css/public.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/source/css/content.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/source/js/laydate.js"></script>
</head>
<body marginwidth="0" marginheight="0">
	<div class="container">
		<div class="public-content">
			<div class="public-content-header">
				<s:if test="${exam.id!=null}">
					<h3>测试修改</h3>
				</s:if>
				<s:if test="${exam.id==null}">
					<h3>测试添加</h3>
				</s:if>
			</div>
			<div class="public-content-cont">
				<form action="${pageContext.request.contextPath}/exam/${exam.id}"
					method="post">
					<s:if test="${exam.id!=null}">
						<input type="hidden" name="_method" value="PUT" />
					</s:if>
					<div class="form-group">
						<label for="">名称：</label> <input class="form-input-txt"
							type="text" name="name" value="${exam.name}" />
						<H6
							style="font-size: 1; color: red; margin-left: 95px; margin-top: 7px">${name}</H6>
					</div>
					<div class="form-group">
						<label for="">开始时间：</label> <input
							class="form-input-txt" id="start" type="text"
							name="beginTime" value="${exam.beginTime}" 
							>
						<H6
							style="font-size: 1; color: red; margin-left: 95px; margin-top: 7px">${beginTime}</H6>
					</div>
					<div class="form-group">
						<label for="">结束时间：</label> <input
							class="form-input-txt" id="end" type="text"
							name="endTime" value="${exam.endTime }" 
							>
						<H6
							style="font-size: 1; color: red; margin-left: 95px; margin-top: 7px">${endTime}</H6>
					</div>
					<div class="form-group">
						<label for="">试题：</label> <select name="question.id"
							class="form-select">
							<s:forEach items="${qList}" var="v">
								<option value="${v.id}">${v.title}</option>
							</s:forEach>
						</select>
					</div>
					<div class="form-group">
						<label for="">状态：</label> <select class="form-select" name="state">
							<option value="1">练习</option>
							<option value="2">测试</option>
						</select>
						<H6
							style="font-size: 1; color: red; margin-left: 95px; margin-top: 7px">${state}</H6>
					</div>
					<div class="form-group">
						<label for="">备注：</label> <input class="form-input-txt"
							type="text" name="remarks" value="${exam.remarks}" />
					</div>
					<div class="form-group"
						style="margin-left: 200px; margin-top: 30px">
						<input type="submit" class="sub-btn" value="提  交" />
					</div>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		!function() {
			laydate.skin('molv');//切换皮肤，请查看skins下面皮肤库
			laydate({
				elem : '#demo'
			});//绑定元素
		}();

		//日期范围限制
		var start = {
			elem : '#start',
			format : 'YYYY-MM-DD hh:mm:ss',
			min : laydate.now(), //设定最小日期为当前日期
			max : '2099-06-16 23:59:59', //最大日期
			istime : true,
			istoday : false,
			choose : function(datas) {
				end.min = datas; //开始日选好后，重置结束日的最小日期
				end.start = datas //将结束日的初始值设定为开始日
			}
		};

		var end = {
			elem : '#end',
			format : 'YYYY-MM-DD hh:mm:ss',
			min : laydate.now(),
			max : '2099-06-16 23:59:59',
			istime : true,
			istoday : false,
			choose : function(datas) {
				start.max = datas; //结束日选好后，充值开始日的最大日期
			}
		};
		laydate(start);
		laydate(end);
	</script>
</body>
</html>