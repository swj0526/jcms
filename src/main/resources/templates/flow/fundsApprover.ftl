<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="../layui/css/layui.css">
    <script type="text/javascript" src="../jquery/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="../layui/layui.js"></script>
    <script type="text/javascript" src="../flow/js/fundsApprover.js"></script>
</head>
<body>
<#--条件查询-->
<div class="layui-form-item"  >
    <form class="layui-form" action="" >

        <div class="layui-inline">
            <label class="layui-form-label">申请人</label>
            <div class="layui-input-inline">
                <input name="email" class="layui-input" type="text" autocomplete="off" lay-verify="email">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">状态</label>
            <div class="layui-input-inline">
                <select name="modules" lay-search="" lay-verify="required">
                    <option value="">所有状态</option>
                    <option value="1">同意</option>
                    <option value="2">拒绝</option>
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
    </form>
</div>

<#--数据表格-->
<table class="layui-hide" id="test" lay-filter="test"></table>
<div class="layui-btn-container">
    <table class="layui-hide" id="test" lay-filter="test"></table>
</div>
<br><br>
<#--经费申请详情-->
<div style="display: none" id="updateOrDelete">
    <form class="layui-form" lay-filter="dataForm" id="dataFor">
        <div class="layui-form-item" style="display: none">
            <label class="layui-form-label">n</label>
            <div class="layui-input-block">
                <input type="text" name="id" required lay-verify="required" placeholder="id" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <table border="1" width="300" height="500" align="center" cellspacing="0">
            <caption>学生档案</caption>
            <tr align="center">
                <td bgcolor="#ededed">姓名</td>
                <td colspan="7">张三</td>
            </tr>
            <tr align="center">
                <td bgcolor="#ededed">年级</td>
                <td colspan="7">影视一班</td>
            </tr>
            <tr align="center">
                <td bgcolor="#ededed">申请事由</td>
                <td colspan="7">团建</td>
            </tr>
            <tr align="center">
                <td bgcolor="#ededed">申请金额</td>
                <td colspan="7">3000</td>
            </tr>
            <tr align="center">
                <td bgcolor="#ededed">申请日期</td>
                <td colspan="7">2016-10-15</td>
            </tr>
            <tr align="center">
                <td bgcolor="#ededed">开始日期</td>
                <td colspan="7">2016-10-18</td>
            </tr>
            <tr align="center">
                <td bgcolor="#ededed">状态</td>
                <td colspan="7">拒绝</td>
            </tr>
            <tr align="center">
                <td bgcolor="#ededed">拒绝理由</td>
                <td colspan="7">拒绝</td>
            </tr>
        </table>
    </form>
</div>

<script>
    //JavaScript代码区域
    layui.use('element', function () {
        var element = layui.element;
    });
</script>
<script id="barDemo" type="text/html">
    <a class="layui-btn layui-btn-xs" lay-event="edit">查看详细</a>
</script>

</body>
</html>
