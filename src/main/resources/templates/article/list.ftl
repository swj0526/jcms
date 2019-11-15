<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>发文查询</title>
    <link rel="stylesheet" type="text/css" href="../layui/css/layui.css">
    <script type="text/javascript" src="../jquery/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="../layui/layui.js"></script>
    <script type="text/javascript" src="../article/js/list.js"></script>
</head>
<body>
<form class="layui-form" action="">
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">标题</label>
            <div class="layui-input-inline">
                <input name="phone" class="layui-input" type="tel" autocomplete="off" lay-verify="required|phone">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">发布人</label>
            <div class="layui-input-inline">
                <input name="email" class="layui-input" type="text" autocomplete="off" lay-verify="email">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">类型</label>
            <div class="layui-input-inline">
                <select name="modules" lay-search="" lay-verify="required">
                    <option value="">请选择类型</option>
                    <option value="1">公告</option>
                    <option value="2">通知</option>
                    <option value="3">layim</option>
                </select>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">状态</label>
            <div class="layui-input-inline">
                <select name="modules" lay-search="" lay-verify="required">
                    <option value="">所有状态</option>
                    <option value="1">已读</option>
                    <option value="2">未读</option>
                </select>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">日期范围</label>
            <div class="layui-input-inline">
                <input class="layui-input" id="test6" type="text" placeholder=" - ">
            </div>
        </div>
        <button class="layui-btn" data-type="reload">查询</button>
        <button class="layui-btn" lay-submit lay-filter="formDemo" id="excel">导出</button>
    </div>
</form>
<table class="layui-hide" id="test" lay-filter="test"></table>
<div class="layui-btn-container">
    <table class="layui-hide" id="test" lay-filter="test"></table>
</div>
<script id="barDemo" type="text/html">
    <a class="layui-btn layui-btn-xs" lay-event="edit">查看详细</a>
</script>
</body>
</html>
