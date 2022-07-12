<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Layui</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="static/layui/css/layui.css"  media="all">
  <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
  <style type="text/css">
    .layui-table{
      width: 50%;
      margin-left: 25%;
    }
  </style>
</head>
<body>
<br> 
<table class="layui-table" lay-data="{width: 1200, height:500, url:'mohuname', page:false, id:'idTest'}" lay-filter="demo">
  <thead>
    <tr>
      <th lay-data="{field:'id', width:100, sort: true}">ID</th>
      <th lay-data="{field:'stuno', width:180, sort: true}">学号</th>
      <th lay-data="{field:'stuname', width:140}">名字</th>
      <th lay-data="{field:'stuclass', width:100}">班级</th>
      <th lay-data="{field:'username', width:100}">用户名</th>
      <th lay-data="{field:'password', width:130}">密码</th>
      <th lay-data="{fixed: 'right', width:300, align:'center', toolbar: '#barDemo'}"></th>
    </tr>
  </thead>
</table>
 
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
  <a class="layui-btn layui-btn-warm  layui-btn-xs" lay-event="edit">修改</a>
</script>
               
          
<script src="static/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
layui.use(['table','layer'], function(){
  var table = layui.table
  ,layer = layui.layer
  ,$ = layui.$;
  //监听工具条
  table.on('tool(demo)', function(obj){
    var data = obj.data;
    if(obj.event === 'del'){
    	window.location.href="delstu?id="+data.id+"";
    } else if(obj.event === 'edit'){
    	window.location.href="hrefxiustu?id="+data.id+"";
    }
  });
  $('.demoTable .layui-btn').on('click', function(){
    var type = $(this).data('type');
    active[type] ? active[type].call(this) : '';
  });
});
</script>

</body>
</html>