var transtime = document.getElementById("useTime").value;// transtime为打字一共用了多少时间
// errorcount 打字一共错了多少个字
var start = -1;// 进行开始和暂停
var SourceString = document.getElementById("oldcontent").value;
var sp = SourceString.length;// sp 源数据的总字数
var curentWord = 0;// 当前打了多少字
// 正确率
var accuracy = document.getElementById("_accuracy").value;
// 分数
var sorce = document.getElementById("score").value;
// 表示现在这个div有多宽
var len = $("#ss").width();
// 原始文字对应行数
var linenum = (sp * 20) / len;
// 一行显示多少个
var linconnum = parseInt(len / 20) - 1;
// 错误的总个数
var errorcount = 0;
// 获取打过的字
var oldContent = document.getElementById("oldContent").value;
// 用户点击开始按钮进行测试
function begin() {
	start *= -1;
	// 一开始点击 开始执行 代码
	if (start == 1) {
		tt = setInterval("showtime()", 1000); // 点击开始就开始计时 //没过一秒钟 执行一次该函数
		// 如果原文的长度整除div的宽度就不给行数加1
		if ((sp * 20) % len != 0) {
			linenum = parseInt(linenum) + 1;
		} else {
			linenum = parseInt(linenum);
		}
		// 多少行
		var oldlinenum = (oldContent.length * 20) / len;
		if ((oldContent.length * 20) * len != 0) {
			oldlinenum = parseInt(oldlinenum) + 1;
		} else {
			oldlinenum = parseInt(oldlinenum);
		}
		// 获取主显示div
		var cont = document.getElementById("ss");
		// 删除div下的所有子节点
		while (cont.hasChildNodes()) {
			cont.removeChild(cont.firstChild);
		}
		for (var i = 0; i < linenum; i++) {
			var div60 = document.createElement("div");
			div60.style.height = "60px";
			var div30 = document.createElement("div");
			// div30.style.backgroundColor = "#CCCCFF";
			div30.id = "d" + i;
			div30.style.height = "30px";
			div30.style.fontSize = "20px";
			div30.style.marginTop = "10px"
			div30.innerText = SourceString.substring(i * linconnum, i
					* linconnum + linconnum);
			div60.appendChild(div30);
			var input = document.createElement("input");
			input.id = "in" + i;
			input.type = "text";
			input.maxlength = linconnum;
			input.disabled = false;
			input.onkeyup = function() {
				Test(this)
			};
			input.style.fontSize = "20px";
			input.style.width = "100%";
			// 将用户打过的字或者刚打的字 在开始的时候赋值
			input.value = oldContent.substring(i * linconnum, i * linconnum
					+ linconnum);
			div60.appendChild(input);
			cont.appendChild(div60);
		}
	} else {// 暂停时
		oldContent = "";
		for (var i = 0; i < linenum; i++) {
			oldContent += document.getElementById("in" + i).value;
		}
		for (var i = 0; i < linenum; i++) {
			document.getElementById("in" + i).disabled = true;
		}
		linenum--;
		window.clearInterval(tt);// 将时间暂停
	}
	// 每过5秒向服务器发送数据 异步更新
	ajaxJson();
}

function showtime() {
	transtime++;// transtime从0开始
	document.getElementById("ttime").innerText = transtime + " 秒";// 将数据返回给浏览器的时间后面
	if (transtime > 10000) { // 考试时间已经结束
		alert('时间到，考试结束！');
		document.getElementById('form').submit();// js 执行表单提交
	}
}

// 用户开始打字 Test函数由用户编辑文本域 onKeyUp按下按键 放开的时候执行 js的不同事件的执行 相当于一个单开线程
// 记录每行的错误数
var errorlineCount = new Array();
function Test(obj) {
	// 为了判断再次获取用户已经输入的值
	oldContent = "";
	for (var i = 0; i < linenum; i++) {
		oldContent += document.getElementById("in" + i).value;
	}
	// 将打过的字重写赋值 用于回显
	var str = obj.value;
	var TargetObj = "";
	var flag = (obj.id).substring(2);
	var temp = "";// 显示的数据 带有颜色的
	var tempcount = 0;// 目前错的个数
	// 现在比对的一行
	var dvlue = $("#d" + flag).text();
	for (var i = 0; i < dvlue.length; i++) {
		if (i < str.length) {
			if (str.substring(i, i + 1) == dvlue.substring(i, i + 1)) {
				temp = temp + "<span class='right1'>"
						+ dvlue.substring(i, i + 1) + "</span>";
			} else {
				temp = temp + "<span class='error1'>"
						+ dvlue.substring(i, i + 1) + "</span>";
				tempcount++;
			}
			curentWord = i + 1;
		} else {
			// 将没有改变颜色的数据继续显示
			temp = temp + dvlue.substring(i, i + 1);
		}
	}
	errorlineCount[flag] = tempcount;
	errorcount = 0;
	for (var i = 0; i < errorlineCount.length; i++) {
		errorcount += errorlineCount[i];
	}

	// errorcount = tempcount; 将错的个数赋值给最后错的个数
	document.getElementById('d' + flag).innerHTML = temp;// 显示用户输入数据的 对错变化
	document.getElementById('error').innerText = errorcount + " 个"; // 显示错误数据
	// 显示正确率
	accuracy = document.getElementById("accuracy").innerText = (sp - errorcount)
			/ sp;
	sorce = (100 / sp) * (oldContent.length - errorcount);
	document.getElementById("_score_").innerText = sorce;
	// document.getElementById('currentScorce').innerHTML=sorce;
}
// 提交
function submit() {
	document.getElementById("typetext").value = oldContent;
	document.getElementById("time").value = transtime;
	document.getElementById("er").value = errorcount;
	document.getElementById("_score").value = sorce;
	document.getElementById("_accuracy_").value = accuracy;
	document.getElementById("form").submit();
}
// ajax的调用
var xmlHttp;
function create() {
	if (window.XMLHttpRequest) { // Mozilla浏览器
		xmlHttp = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		try {
			xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try {
			} catch (e) {
				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
		}
	}
}
function callback() {
	if (xmlHttp.readyState == 4) {
		if (xmlHttp.status == 200) {

		} else {
			// alert("ajax 返回错误");
		}
	}
}
function run() {
	create();
	// "realRecode?id="+Math.random() 请求的url 后面是随机数
	var url = "http://" + document.location.hostname + ":8080/ctyping/ajaxput";// 先本地测一下http://cynara.tunnel.qydev.com/ctyping/ajaxput
	url = url + "?id=" + document.getElementById("oid").value;
	url = url + "&accuracy=" + accuracy;// 向服务传输的数据
	url = url + "&content=" + oldContent;
	url = url + "&exam.id=" + document.getElementById("examid").value;
	url = url + "&score=" + sorce;
	url = url + "&user.id=" + document.getElementById("userid").value;
	url = url + "&useTime=" + transtime;
	url = url + "&math=" + Math.random();
	xmlHttp.open("POST", url, true)
	xmlHttp.onreadystatechange = callback;
	xmlHttp.send(null);
	setTimeout("run()", 5000);// 定时执行 2秒
}
// 入口
function ajaxJson() {
	run();
}
// 禁用右键
$(document).ready(function() {
	$(document).bind("contextmenu", function(e) {
		return false;
	});
});
//禁用复制粘贴
$(document).keydown(function(event) {
    if (event.ctrlKey==true && (event.which == '118' || event.which == '86')) {
        event.preventDefault();
     }
});
