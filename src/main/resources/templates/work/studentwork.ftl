<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../layui/css/layui.css"/>
    <script type="text/javascript" src="../layui/layui.js"></script>
    <script type="text/javascript" src="../work/js/studentwork.js"></script>
</head>
<body>
<div id="aa">
    <fieldset class="layui-elem-field layuimini-search">
        <legend>作业管理</legend>
        <div style="margin: 10px 10px 10px 10px;">
            <form class="layui-form layui-form-pane" lay-filter="dataForm" id="dataFor">
                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">作业内容</label>
                    <div class="layui-input-block">
                        <textarea name="desc" placeholder="请输入内容" class="layui-textarea"></textarea>
                    </div>
                </div>
                <fieldset class="layui-elem-field layuimini-search">
                    <legend>作业样式展示</legend>
                    <div style="margin: 10px 10px 10px 10px;">
                        <img src="../work/img/1.png" style="width: 100px;height: 100px">
                    </div>
                </fieldset>
            </form>
            <div class="layui-upload" id="up" style="text-align: center">
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
                <textarea name="" required lay-verify="required" placeholder="备注" class="layui-textarea" style="height: 100px"></textarea>
                <button class="layui-btn" id="testListAction" type="button">开始上传</button>
                <div class="layui-progress layui-progress-big" lay-filter="demo" lay-showPercent="yes"
                     style="margin-top: 20px">
                    <div class="layui-progress-bar layui-bg-red" lay-percent="0%"></div>
                </div>
            </div>
            <div style="text-align: center">
                <button type="button" class="layui-btn" id="ss"
                        style="padding-left: 10px;padding-right: 10px;width: 70px;">提交
                </button>
            </div>
        </div>
    </fieldset>
</div>
</body>
</html>