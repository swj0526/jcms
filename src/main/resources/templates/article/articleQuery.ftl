<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="../static/layui/css/layui.css">
    <script type="text/javascript" src="jquery.js"></script>
    <script type="text/javascript" src="../static/layui/layui.js"></script>
    <script type="text/javascript" src="../static/article/js/articleQuery.js"></script>
</head>
<body>
<table class="layui-hide" id="test" lay-filter="test"></table>
<div class="layui-btn-container">
    <table class="layui-hide" id="test" lay-filter="test"></table>
</div>
<br><br>


<script id="toolbarDemo" type="text/html">
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
</script>
</body>
</html>
