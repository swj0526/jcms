<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <script src="/layui/layui.js" type="text/javascript"></script>
    <script src="/major/js/list.js" type="text/javascript"></script>
</head>
<body class="layui-layout-body" style="height: 100%;">
<div class="layuimini-container" style="height: 100%;">
    <div class="layuimini-main" style="height: 100%;">
        <div>
            <a class="layui-btn">刷新</a>
            <a class="layui-btn layui-btn-normal">新增</a>
            <a class="layui-btn layui-btn-warm">打印</a>
        </div>
        <div>
            <table class="layui-hide" id="treeTable" lay-filter="treeTable"></table>
        </div>
    </div>
</div>


</body>
</html>
