<!DOCTYPE html>
<html>
<head>
    <base href="${basePath}">
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="/all.css" media="all">
    <script src="/layui/layui.js"></script>
    <script src="/teacher/js/list.js"></script>
</head>
<body>
<#--添加-->
<div id="add" style="display: none">
    <div style="margin: 10px 10px 10px 10px">
        <form class="layui-form " lay-filter="dataForm" id="dataFrm" action="">
            <div class="layui-form-item">
                <div class="layui-form-item">
                    <label class="layui-form-label">姓名<span class="star">*</span></label>
                    <div class="layui-input-inline">
                        <input type="text" name="name" required lay-verify="required" placeholder="" autocomplete="off"
                               class="layui-input" id="name">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">手机号<span class="star">*</span></label>
                    <div class="layui-input-inline">
                        <input name="phone" class="layui-input" type="tel" autocomplete="off"
                               lay-verify="required|phone" id="phone">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">性别<span class="star">*</span></label>
                    <div class="layui-input-inline">
                        <select name="gender" lay-verify="" id="gender">
                            <option value="">选择性别</option>
                            <option value="男">男</option>
                            <option value="女">女</option>
                        </select>
                    </div>
                </div>
            </div>
            <div style="text-align: center;">
                <button class="layui-btn" lay-submit lay-filter="formDemo" id="addTeacher">提交</button>
                <button type="reset" class="layui-btn layui-btn-primary" id="cancelAdd">取消</button>
            </div>
        </form>
    </div>
</div>
<#--修改-->
<div id="modify1" style="display: none">
    <div style="margin: 10px 10px 10px 10px">
        <form class="layui-form" lay-filter="dataForm1" id="dataFrm">
            <div class="layui-form-item">
                <div class="layui-form-item" style="display: none">
                    <label class="layui-form-label">n</label>
                    <div class="layui-input-block">
                        <input type="text" name="id" required lay-verify="required" placeholder="id" autocomplete="off"
                               class="layui-input" id="id1">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">姓名<span class="star">*</span></label>
                    <div class="layui-input-inline">
                        <input type="text" name="name" required lay-verify="required" placeholder="" autocomplete="off"
                               class="layui-input" id="name1">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">手机号<span class="star">*</span></label>
                    <div class="layui-input-inline">
                        <input name="phone" class="layui-input" type="tel" autocomplete="off"
                               lay-verify="required|phone" id="phone1">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">状态<span class="star">*</span></label>
                    <div class="layui-input-inline">
                        <select name="hasQuit" lay-search="" lay-verify="required" id="hasQuit1">
                            <option value=true>在职</option>
                            <option value=false>离职</option>
                        </select>
                    </div>
                </div>
            </div>
            <div style="text-align: center;">
                <button type="button" class="layui-btn" id="modifyTeacher">提交</button>
                <button type="reset" class="layui-btn layui-btn-primary" id="cancelModify">取消</button>

            </div>
        </form>
    </div>
</div>
<#--导入-->
<div style="display: none" id="importForm">
    <blockquote class="layui-elem-quote layui-quote-nm">请下载excel文件按照文件格式填写内容后上传
        <button type="button" class="layui-btn layui-btn-normal" id="template">下载模板</button>
    </blockquote>

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
<#--模糊查询-->
<div class="demoTable">
    <form class="layui-form layui-form-pane" action="">
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">关键词</label>
                <div class="layui-input-inline">
                    <input type="text" name="name" autocomplete="off" class="layui-input"
                           placeholder="张三/手机号" id="queryName">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">状态</label>
                <div class="layui-inline">
                    <select name="hasQuit" lay-verify="" id="queryHasQuit">
                        <option value="">所有状态</option>
                        <option value="true">在职</option>
                        <option value="false">离职</option>
                    </select>
                </div>
            </div>
            <button class="layui-btn data-add-btn" type="button" id="query">查询</button>
            <button type="button" class="layui-btn " id="add1">添加</button>
            <button type="button" class="layui-btn layui-btn-warm" id="import">导入</button>
            <button type="button" class="layui-btn layui-btn-warm" id="excel">导出</button>
        </div>
    </form>
</div>
<#--数据表格-->
<table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter"></table>

<script type="text/html" id="currentTableBar">
    <a class="layui-btn layui-btn-normal layui-btn-xs data-count-edit" lay-event="edit">修改</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
</body>
</html>
