<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>发文查询</title>
    <link rel="stylesheet" type="text/css" href="../layui/css/layui.css">
    <script type="text/javascript" src="../jquery/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="../layui/layui.js"></script>
    <script type="text/javascript" src="../article/js/list.js"></script>
</head>
<body>
<#--查询-->
<div class="layui-form-item">
    <fieldset class="layui-elem-field layuimini-search">
        <legend>查询发布文章</legend>
        <div style="margin: 10px 10px 10px 10px">
            <form class="layui-form layui-form-pane" action="">
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label" style="width:80px">关键词</label>
                        <div class="layui-input-inline">
                            <input name="phone" class="layui-input" type="tel" autocomplete="off"
                                   lay-verify="required|phone">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label" style="width:80px">发布人</label>
                        <div class="layui-input-inline">
                            <input name="email" class="layui-input" type="text" autocomplete="off" lay-verify="email">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label" style="width:60px">类型</label>
                        <div class="layui-input-inline" style="width:120px">
                            <select name="modules" lay-search="" lay-verify="required">
                                <option value="">请选择类型</option>
                                <option value="1">公告</option>
                                <option value="2">通知</option>
                            </select>
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">日期范围</label>
                        <div class="layui-input-inline">
                            <input class="layui-input" id="test6" type="text" placeholder=" - ">
                        </div>
                    </div>
                    <button class="layui-btn" data-type="reload">查询</button>
                    <button class="layui-btn" lay-submit lay-filter="formDemo" id="excel">导出</button>
                </div>
            </form>
        </div>
    </fieldset>
</div>
<#--数据表格-->
<table class="layui-hide" id="test" lay-filter="test"></table>
<#--文章详情-->
<div style="display: none" id="updateOrDelete">
    <form class="layui-form layui-form-pane" lay-filter="dataForm" id="dataFor">
        <div class="layui-form-item" style="display: none">
            <label class="layui-form-label">n</label>
            <div class="layui-input-block">
                <input type="text" name="id" required lay-verify="required" placeholder="id" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <table border="1" width="310" height="400" align="center" cellspacing="0">
            <tr align="center">
                <td bgcolor="#ededed">标题</td>
                <td colspan="7">hi</td>
            </tr>
            <tr align="center">
                <td bgcolor="#ededed">发布人</td>
                <td colspan="7">老师</td>
            </tr>
            <tr align="center">
                <td bgcolor="#ededed">类型</td>
                <td colspan="7">通知</td>
            </tr>
            <tr align="center">
                <td bgcolor="#ededed">内容</td>
                <td colspan="7" width="200" height="100">有事</td>
            </tr>
        </table>
    </form>
</div>
<div id="aaa" style="display: none">
    <div>
        <h1>已读</h1>
    <table >
        <tbody>
        <tr>
            <td bgcolor="#ededed">张三</td>
            <td bgcolor="#ededed">李四</td>
            <td bgcolor="#ededed">王五</td>
        </tr>
        </tbody>
    </table>
    </div>
    <div>
        <h1>未读</h1>
        <table >
            <tbody>
            <tr>
                <td bgcolor="#ededed">张三</td>
                <td bgcolor="#ededed">李四</td>
                <td bgcolor="#ededed">王五</td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
<script id="barDemo" type="text/html">
    <a class="layui-btn layui-btn-xs" lay-event="edit">查看详细</a>
</script>
</body>
</html>
