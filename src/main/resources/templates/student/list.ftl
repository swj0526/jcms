<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <script src="/layui/layui.js"></script>
    <script type="text/javascript" src="/all.js"></script>
    <script src="/student/js/list.js"></script>

</head>
<body>


<div style="display: none" id="importForm">
    <blockquote class="layui-elem-quote layui-quote-nm">请下载excel文件按照文件格式填写内容后上传</blockquote>
    <div class="layui-upload">
        <button type="button" class="layui-btn layui-btn-normal" id="testList">选择多文件</button>
        <button type="button" class="layui-btn" id="testListAction">开始上传</button>
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

    </div>
</div>
<#--<div class="layuimini-container">
    <div class="layuimini-main">-->

<fieldset class="layui-elem-field layuimini-search">
    <div style="margin: 10px 10px 10px 10px">
        <div class="demoTable">
        <form class="layui-form layui-form-pane" action="">
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">关键词</label>
                    <div class="layui-input-inline">
                        <input type="text" name="username" autocomplete="off" class="layui-input"
                               placeholder="例：1990/张三">
                    </div>
                </div>

                <div class="layui-inline">
                    <label class="layui-form-label">入学时间</label>
                    <div class="layui-input-inline">
                        <input type="text" name="city" autocomplete="off" class="layui-input" id="time">
                    </div>
                </div>
                <div class="layui-inline">

                    <select name="state" lay-verify="">
                        <option value="">选择状态</option>
                        <option value="010">在校</option>
                        <option value="021">毕业</option>
                    </select>
                </div>
                <div class="layui-inline">
                    <button class="layui-btn" data-type="reload">搜索</button>
                    <button type="button" class="layui-btn layui-btn-warm"  id="import">导入</button>
                    <button type="button" class="layui-btn layui-btn-warm">导出</button>
                </div>

            </div>
        </form>
    </div>
        </div>
</fieldset>


<table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter"></table>
<script type="text/html" id="currentTableBar">
    <a class="layui-btn layui-btn-normal layui-btn-xs data-count-edit" lay-event="edit">修改</a>
   <#-- <a class="layui-btn  layui-btn-xs layui-btn-danger data-count-delete" lay-event="delete">删除</a>-->
    <a class="layui-btn layui-btn-primary layui-btn-xs data-count-delete" lay-event="list">详情</a>
</script>
<#--    </div>
</div>-->


</body>
</html>
