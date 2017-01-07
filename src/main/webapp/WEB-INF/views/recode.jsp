<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core"%>
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
	var xmlHttp;
	function create(){
		if(window.XMLHttpRequest){ //Mozilla浏览器
			 xmlHttp=new XMLHttpRequest();
		}else if(window.ActiveXObject){
			try{
				xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");  
			}catch(e){
				try{
					
				}catch(e){
					 xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
				}
			}
			
		}
	}
	function callback(){
		if(xmlHttp.readyState==4){
			if(xmlHttp.status==200){
				var xmlDoc = xmlHttp.responseText;
				var date = eval("("+xmlDoc+")");
				var number = $("#table tr").length;
				 //讲原理的table清空
				var tb = document.getElementById("table");
				for (i=1;i<number;i++){
			        tb.deleteRow(i);
			        number=number-1;
			        i=i-1;
				} 
				//将返回的结果重新绑定
				for(var i=0;i<date.length;i++){
					var number = $("#table tr").length;
					var addRow = "<tr><td>"+number+"</td><td>"+date[i].exam.name+"</td><td>"+date[i].user.realname+"</td><td>"+date[i].useTime+"</td><td>"+date[i].score+"</td><td>"+date[i].accuracy+"</td><td>"+date[i].updateTime+"</td><td>"+date[i].state+"</td><td>"+date[i].remarks+"</td></tr>"
					$("#table").append(addRow);
				} 
				
				//这里是你要解析的事情
			}else{
				alert("ajax 返回错误");
			}
		}
	}
	function run(){
		create();
		//"realRecode?id="+Math.random()  请求的url 后面是随机数
		xmlHttp.open("GET", "realRecode?id="+Math.random(), true)
		xmlHttp.onreadystatechange = callback;
		xmlHttp.send(null);
		setTimeout("run()",2000);//定时执行  2秒
	}
	//入口
	function ajaxJson(){
		run();
	}
</script>
</head>
<body marginwidth="0" marginheight="0">
	<div class="container">
		<div class="public-content">
			<div class="public-content-header">
				<h3  onclick="ajaxJson()">点击开始监听</h3>
				<h4 class="hh4"></h4>
			</div>
			<div class="public-content-cont">
				<table class="public-cont-table" id="table">
					<tr class="onetr">
						<th style="width: 4%">编号</th>
						<th style="width: 13%">测试名称</th>
						<th style="width: 13%">用户名称</th>
						<th style="width: 10%">使用时间</th>
						<th style="width: 13%">分数</th>
						<th style="width: 13%">正确率</th>
						<th style="width: 18%">更新时间</th>
						<th style="width: 8%">状态</th>
						<th style="width: 8%">备注</th>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>