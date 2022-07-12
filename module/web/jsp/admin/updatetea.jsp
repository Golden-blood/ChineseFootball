<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>修改老师信息</title>
	<link rel="stylesheet" type="text/css" href="static/layui/css/layui.css">
	<style type="text/css">
		.layui-form{
			width: 50%;
			margin-left: 10%;
			margin-top: 5%;
		}
		.layui-input-block{
			margin-top: 50px;
		}
		.blank{
			margin-left: 50%;
		}
	</style>
</head>
<body>
<h1 style="margin-left: 200px;color: #009688;margin-top: 40px;">修改老师信息</h1>
	<form class="layui-form" action="updatetea" method="post">
	  <div class="layui-form-item">
	   	<div style="display:none"><input type="text" name="id" value="${teacher.id}"></div>
	    <label class="layui-form-label">用户名</label>
	    <div class="layui-input-block">
	      <input type="text" name="username" value="${teacher.username}" required  lay-verify="required" placeholder="请输入用户名"  class="layui-input">
	    </div>
	  </div>
	  <br>
	  <div class="layui-form-item">
	    <label class="layui-form-label">密码</label>
	    <div class="layui-input-inline">
	      <input type="password" name="password" value="${teacher.password}" required lay-verify="required" placeholder="请输入密码" class="layui-input">
	   	</div>
	  </div>
	 <div class="layui-form-item">
	    <label class="layui-form-label">姓名</label>
	    <div class="layui-input-block">
	      <input type="text" name="teaname" value="${teacher.teaname}" required  lay-verify="required" placeholder="请输入姓名" class="layui-input">
	    </div>
	  </div>
	  <div class="layui-form-item">
	    <div class="layui-input-block">
	      <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
	      <span class="blank"></span>
	      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
	    </div>
	  </div>
	</form>
 <script type="text/javascript" src="static/layui/layui.js"></script>
<script>
//Demo
layui.use('form', function(){
  var form = layui.form;
});
</script>
</body>
</html>