<!DOCTYPE html>
<html lang="en">
<head>
    <base href="${basePath}">
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../layui/css/layui.css"/>
    <script type="text/javascript" src="../layui/layui.js"></script>
    <script type="text/javascript" src="../work/js/studentwork.js"></script>
</head>
<body>
<div id="aa">
    <fieldset class="layui-elem-field layuimini-search">
        <div style="margin: 10px 10px 10px 10px;">
            <form class="layui-form layui-form-pane" lay-filter="dataForm" id="dataFor">
                <fieldset class="layui-elem-field layuimini-search">
                    <legend>作业内容</legend>
                    <div style="margin: 10px 10px 10px 10px;">
                        <div>
                            <p>作业内容</p>
                        </div>
                    </div>
                </fieldset>
                <fieldset class="layui-elem-field layuimini-search">
                    <legend>作业样式展示</legend>
                    <div style="margin: 10px 10px 10px 10px;">
                        <img src="../work/img/1.png" style="width: 100px;height: 100px">
                    </div>
                </fieldset>
                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">内容</label>
                    <div class="layui-input-block">
                        <textarea class="layui-textarea layui-hide" name="content" lay-verify="content"
                                  id="LAY_demo_editor"></textarea>
                    </div>
                </div>
            </form>
            <div class="layui-upload" id="up" style="text-align: center">

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
                <button class="layui-btn layui-btn-normal" id="testList" type="button">选择多文件</button>
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