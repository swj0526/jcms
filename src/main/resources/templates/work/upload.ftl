<!DOCTYPE html>
<html lang="en">
<head>
    <base href="${basePath}">
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/layui/css/layui.css"/>
    <script type="text/javascript" src="/layui/layui.js"></script>
    <script type="text/javascript" src="/work/js/upload.js"></script>
</head>
<body>
<fieldset class="layui-elem-field layuimini-search">
    <div style="margin: 10px 10px 10px 10px">
        <form class="layui-form layui-form-pane" action="">
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">关键词</label>
                    <div class="layui-input-inline">
                        <input type="text" name="keywords" autocomplete="off" class="layui-input" placeholder="作业名称/发布人/内容">
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
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="edit">作业管理</a>
</script>
<div class="layui-upload" id="up" style="display: none;text-align: center" >
    <button class="layui-btn layui-btn-normal" id="testList" type="button">选择多文件</button>
    <div class="layui-upload-list">
        <table class="layui-table">
            <thead>
            <tr>
                <th>文件名</th>
                <th>大小</th>
                <th>状态</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody id="demoList"></tbody>
        </table>
    </div>
    <textarea name="" required lay-verify="required" placeholder="备注" class="layui-textarea"></textarea>
    <button class="layui-btn" id="testListAction" type="button">开始上传</button>
    <div class="layui-progress layui-progress-big" lay-filter="demo" lay-showPercent="yes" style="margin-top: 20px">
        <div class="layui-progress-bar layui-bg-red" lay-percent="0%"></div>
    </div>
</div>
</body>
</html>