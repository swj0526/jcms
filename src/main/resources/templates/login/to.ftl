<!DOCTYPE html>
<html>
<head>
    <#include "../common/common.ftl"/>
    <title>锦程后台管理</title>
    <link rel="stylesheet" type="text/css" href="../../login/css/login.css"/>


</head>
<body>
<div class="layui-container">
    <div class="admin-login-background">
        <div class="layui-form login-form">
            <form class="layui-form" action="">
                <div class="layui-form-item logo-title">
                    <h1>锦程后台管理登录</h1>
                </div>
                <div class="layui-form-item">
                    <label class="layui-icon layui-icon-username" for="username"></label>
                    <input type="text" name="username" lay-verify="required|account" placeholder="手机号码"
                           autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-item">
                    <label class="layui-icon layui-icon-password" for="password"></label>
                    <input type="password" name="password" lay-verify="required|password" placeholder="密码"
                           autocomplete="off" class="layui-input" >
                </div>
                <div class="layui-form-item">
                    <label class="layui-icon layui-icon-vercode" for="captcha"></label>
                    <input type="text" name="captcha" lay-verify="required|captcha" placeholder="图形验证码"
                           autocomplete="off" class="layui-input verification captcha" value="xszg">
                    <div class="captcha-img">
                        <img id="captchaPic" src="../login/images/captcha.jpg">
                    </div>
                </div>
                <div class="layui-form-item">
                    <input type="checkbox" name="rememberMe" value="true" lay-skin="primary" title="记住密码">
                </div>
                <div class="layui-form-item">
                    <button class="layui-btn layui-btn-fluid" lay-submit="" lay-filter="login">登 录</button>
                </div>
            </form>

        </div>
    </div>
</div>
<script src="/login/js/jquery.particleground.min.js" charset="utf-8"></script>
<script src="/login/js/login.js"></script>
</body>
</html>