<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>发文查询</title>
    <link rel="stylesheet" type="text/css" href="../layui/css/layui.css">
    <script type="text/javascript" src="../jquery/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="../layui/layui.js"></script>
    <script type="text/javascript" src="../article/js/articleQuery.js"></script>
</head>
<body>
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
        <label class="layui-form-label">日期范围</label>
        <div class="layui-input-inline">
            <input class="layui-input" id="test6" type="text" placeholder=" - ">
        </div>
    </div>
</div>

<table class="layui-hide" id="test" lay-filter="test"></table>
<div class="layui-btn-container">
    <table class="layui-hide" id="test" lay-filter="test"></table>
</div>
<br><br>

</body>
</html>