<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>修改密码</title>
  <link rel="stylesheet" href="static/layui/css/layui.css">
</head>
<body>
  <form action="updatepws" method="POST">
    <div class="layui-form-item" style="margin-top: 200px;margin-left:200px;width: 800px;">
        <label class="layui-form-label">修改密码</label>
        <div style="display:none;">
        <input type="text" name="id" value="${student.id}">
        </div>
        <div class="layui-input-block">
          <input type="password" name="password" lay-verify="title" required="required" autocomplete="off" placeholder="修改密码" class="layui-input" autofocus>
        </div>
        <input type="submit" value="提交" class="layui-btn" style="margin-left: 400px;margin-top: 40px;">
      </div>
    </form>
</body>
</html>