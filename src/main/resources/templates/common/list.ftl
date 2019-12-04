<!DOCTYPE html>
<html lang="en">
<head>
    <base href="${basePath}">
    <meta charset="UTF-8">
    <title>列表页</title>
    <#include "../common/common.ftl"/>
</head>
<body>
<!--查询开始-->
<div style="padding: 5px;">
    <fieldset class="layui-elem-field " style="padding: 5px;">
        <form class="layui-form layui-form-pane" action="">
            <div class="layui-form-item">
                <label class="layui-form-label">关键词</label>
                <div class="layui-input-inline">
                    <input type="text" name="keywords" lay-verify="keywords" autocomplete="off"
                           placeholder="根据实际情况提示" class="layui-input">
                </div>
                <label class="layui-form-label">爱好</label>
                <div class="layui-input-inline">
                    <select name="interest" lay-filter="aihao">
                        <option value="">请选择爱好</option>
                        <option value="0">写作</option>
                        <option value="1" selected="">阅读</option>
                        <option value="2">游戏</option>
                        <option value="3">音乐</option>
                        <option value="4">旅行</option>
                    </select>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">日期选择</label>
                    <div class="layui-input-block">
                        <input type="text" name="date" id="date1" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">日期范围</label>
                    <div class="layui-input-inline">
                        <input type="text" class="layui-input" id="scopeDate">
                    </div>
                </div>
                <button type="button" class="layui-btn" id="listBtn">查询</button>
            </div>

        </form>
    </fieldset>
</div>
<!--查询结束-->
<!--表格开始-->
<table class="layui-hide" id="infoTable" lay-filter="infoTable"></table>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<!--表格结束-->
</body>
<script type="text/javascript" src="/common/js/list.js"></script>
</html>