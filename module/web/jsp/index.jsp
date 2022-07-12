<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../static/layui/css/layui.css">
    <title>学生成绩管理系统</title>
    <style>
        body{
            background-color: #009688;
        }
        .formitem{
            background-color: white;
            margin-top: 180px;
            margin-left: 500px;
            width: 480px;
            height: 350px;
        }
        .formitem div h1{
            margin-left: 120px;
        }
        .layui-input-block{
            margin-top: 15px;
            margin-left: 100px;
            width: 260px; 
        }
        .blank2{
            margin-left: 60px;
        }
    </style>
</head>
<body>
    <div class="formitem">
        <br><br>
        <div><h1>学生成绩管理系统</h1></div>
        <form class="layui-form" action="login" method="post">
            <div class="layui-input-block">
                用户名:<input type="text" name="username" lay-verify="required" lay-reqtext="必填项，岂能为空？" placeholder="请输入用户名" class="layui-input">
            </div>
            <div class="layui-input-block">
                密码:<input type="password" name="password" lay-verify="required" lay-reqtext="必填项，岂能为空？" placeholder="请输入密码" autocomplete="off" class="layui-input">
            </div>
             
            <div class="layui-input-block">
              <input type="radio" name="people" value="student" title="学生" checked="">
              <input type="radio" name="people" value="teacher" title="老师">
              <input type="radio" name="people" value="manage" title="管理员">
            </div>
            <div class="layui-input-block">
                <button type="submit" class="layui-btn">立即提交</button>
                <span class="blank2"></span>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </form>
        </div>
        </form>
    </div>
    <script type="text/javascript" src="../static/layui/layui.js"></script>
    <script type="text/javascript">
        //Demo
        layui.use('form', function(){
          var form = layui.form;
          
          //监听提交
          form.on('submit(formDemo)', function(data){
            layer.msg(JSON.stringify(data.field));
            return false;
          });
        });
    </script>
</body>
</html>