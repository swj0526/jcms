<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>后台管理-注册</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta http-equiv="Access-Control-Allow-Origin" content="*">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="layui/css/layui.css" media="all">
    <link rel="stylesheet" type="text/css" href="login/css/login.css"/>

</head>
<body>
<div class="layui-container">
    <div class="admin-login-background">
        <div class="layui-form login-form">
            <form class="layui-form" action="">
                <div class="layui-form-item logo-title">
                    <h1>注册</h1>
                </div>
                <div class="layui-form-item">
                    <label class="layui-icon layui-icon-username" for="username"></label>
                    <input type="text" name="username" lay-verify="required|account" placeholder="用户名或者邮箱" autocomplete="off" class="layui-input" value="admin">
                </div>
                <div class="layui-form-item">
                    <label class="layui-icon layui-icon-password" for="password"></label>
                    <input type="password" name="password" lay-verify="required|password" placeholder="密码" autocomplete="off" class="layui-input" value="123456">
                </div>


                <div class="layui-form-item">
                    <button class="layui-btn layui-btn-fluid" lay-submit="" lay-filter="">确认</button>
                </div>
            </form>
            <div class="layui-form-item">
              <a href="login">  <button class="layui-btn layui-btn-fluid" lay-filter="register">返回登录页面</button></a>
            </div>
        </div>
    </div>
</div>
<script src="login/js/jquery.js" charset="utf-8"></script>
<script src="layui/layui.js" charset="utf-8"></script>
<script src="login/js/jquery.particleground.min.js" charset="utf-8"></script>
<script src="login/js/login.js"></script>
</body>
</html>