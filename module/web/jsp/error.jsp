<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>错误</title>
</head>
<body>
<h1 style="margin-left:40%;margin-top: 10%;">错误的登录</h1>
<div id="ShowDiv" style="margin-left:40%;"></div>
<script language="javascript">
	var secs = 3; //倒计时的秒数 
	var URL="index";
	window.onload = function(){
		for(var i=secs;i>=0;i--) 
		{ 
		   window.setTimeout('doUpdate(' + i + ')', (secs-i) * 1000); 
		}
	}
	function doUpdate(num) 
	{ 
		document.getElementById('ShowDiv').innerHTML = '将在'+num+'秒后自动跳转到主页' ;
		if(num == 0) { window.location = URL;}
	}
</script>
</body>

</html>