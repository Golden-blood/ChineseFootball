<%@page import="com.hhtc.po.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>学生信息页面</title>
	<style type="text/css">
		.stuinfo{
			width: 50%;
			margin-left: 10%;
			border: 1px solid;
			height: 380px;
			background-color: #1E9FFF;
		}
		div{
			margin-left: 38%;
			background-color:white;
			width: 200px;
		}
		.info{
			margin-top: 8%;
		}
		.info p{
			font-size: 18px;
		}
	</style>
</head>
<body>
	<p style="font-size: 20px;margin-left: 30%">成绩查看</p>
	<div class="stuinfo">
		<div class="info">
			<p>姓名:${student.stuname}</p>
		</div>
		<div class="info">
			<p>班级:${student.stuclass}</p>
		</div>
		<div class="info">
			<p>学号:${student.stuno}</p>
		</div>
		<div class="info">
			<p>分数:
			<%
			Student student=(Student)request.getSession().getAttribute("student");
				if(student.getScore()!=null){
					student.getScore();
				}else{
			%>
				教师暂未评分
			<% 
			}
			%>
			${student.score}</p>
		</div>
	</div>
</body>
</html>