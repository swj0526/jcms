<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../layui/css/layui.css"/>
    <script type="text/javascript" src="../layui/layui.js"></script>
    <script type="text/javascript" src="../work/js/uploading.js"></script>
</head>
<body>
<fieldset class="layui-elem-field layuimini-search">
    <legend>搜索信息</legend>
    <div style="margin: 10px 10px 10px 10px">
        <form class="layui-form layui-form-pane" action="">
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">关键字</label>
                    <div class="layui-input-inline">
                        <input type="text" name="username" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">发布人</label>
                    <div class="layui-input-inline">
                        <input type="text" name="username" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">日期范围</label>
                    <div class="layui-input-inline">
                        <input class="layui-input" id="test6" type="text" placeholder=" - ">
                    </div>
                </div>
                <div class="layui-inline">
                    <a class="layui-btn" lay-submit="" lay-filter="data-search-btn">查询</a>
                </div>
            </div>
        </form>
    </div>
</fieldset>
<table class="layui-hide" id="test" lay-filter="test"></table>
<script id="barDemo" type="text/html">
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="edit">上传作业</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除作业</a>
</script>

<div id="up" class="layui-upload" style="text-align: center;display: none ">
    <p style="color: red">只能长传一个文件切是文件类型必须是压缩文件</p><br>
    <div id="test" class="layui-upload">
        <button class="layui-btn layui-btn-normal" id="test8" type="button">选择文件</button>
        <button class="layui-btn" id="test9" type="button">开始上传</button>

        <div class="layui-progress layui-progress-big" lay-filter="demo"  lay-showPercent="yes" style="margin-top: 20px">
            <div class="layui-progress-bar layui-bg-red" lay-percent="0%"></div>
        </div>
    </div>
</div>
</body>
</html>