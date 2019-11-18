<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../layui/css/layui.css">
    <script type="text/javascript" src="../jquery/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="../layui/layui.js"></script>
    <script type="text/javascript" src="../flow/js/leaveApprover.js"></script>
</head>
<body>
<#--条件查询-->
<div class="layui-form-item">
    <fieldset class="layui-elem-field layuimini-search">
        <legend>查询请假审批</legend>
        <div style="margin: 10px 10px 10px 10px">
    <form class="layui-form layui-form-pane" action="">
        <div class="layui-inline">
            <label class="layui-form-label">关键词</label>
            <div class="layui-input-inline">
                <input name="email" class="layui-input" type="text" autocomplete="off" lay-verify="email">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">类型</label>
            <div class="layui-input-inline">
                <select name="modules" lay-search="" lay-verify="required">
                    <option value="">请选择类型</option>
                    <option value="1">事假</option>
                    <option value="2">病假</option>
                </select>
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
    </fieldset>
</div>
<#--数据表格-->
<table class="layui-table layui-hide" lay-data="{ cellMinWidth: 80, page: true}" lay-filter="test">
    <thead>
    <tr>
        <th rowspan="3" lay-data="{checkbox:true, fixed:'left'}"></th>
        <th rowspan="3" lay-data="{field:'name',align:'center'}">姓名</th>
        <th rowspan="3" lay-data="{field:'grade',align:'center'}">年级</th>
        <th rowspan="3" lay-data="{field:'days',align:'center'}">请假时长</th>
        <th rowspan="3" lay-data="{field:'apply',align:'center'}">申请日期</th>
        <th rowspan="3" lay-data="{field:'leaveTime',align:'center'}">请假日期</th>
        <th rowspan="3" lay-data="{field:'leaveTime',align:'center'}">结束日期</th>
        <th rowspan="3" lay-data="{field:'cause',align:'center'}">请假事由</th>
        <th colspan="3" lay-data="{align:'center'}">一审</th>
        <th colspan="3" lay-data="{align:'center'}">二审</th>
        <th rowspan="3" lay-data="{fixed: 'right', toolbar: '#barDemo',align: 'center'}">操作</th>
    </tr>
    <tr>
        <th rowspan="2" lay-data="{field:'oneTrial',align:'center'}">一审老师</th>
        <th rowspan="2" lay-data="{field:'oneAdopt',align:'center'}">是否同意</th>
        <th rowspan="2" lay-data="{field:'oneReason',align:'center'}">审批意见</th>
        <th rowspan="2" lay-data="{field:'twoTrial',align:'center'}">二审老师</th>
        <th rowspan="2" lay-data="{field:'twoAdopt',align:'center'}">是否同意</th>
        <th rowspan="2" lay-data="{field:'twoReason',align:'center'}">审批意见</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td lay-data="{checkbox:true}"></td>
        <td>张三111</td>
        <td>影视一班</td>
        <td>3天</td>
        <td>2016-10-14</td>
        <td>2016-10-15</td>
        <td>2016-10-18</td>
        <td>有事</td>
        <td>丛老师</td>
        <td>丛老师</td>
        <td>同意</td>
        <td>通过</td>
        <td>胡老师</td>
        <td>拒绝</td>
        <td>不同意</td>
    </tr>
    <tr>
        <td lay-data="{checkbox:true}"></td>
        <td>张三</td>
        <td>影视一班</td>
        <td>3天</td>
        <td>2016-10-14</td>
        <td>2016-10-15</td>
        <td>2016-10-18</td>
        <td>有事</td>
        <td>丛老师</td>
        <td>丛老师</td>
        <td>同意</td>
        <td>通过</td>
        <td>胡老师</td>
        <td>拒绝</td>
        <td>不同意</td>
    </tr>
    </tbody>
</table>

<#--请假审批详情-->
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
                <td bgcolor="#ededed">姓名</td>
                <td colspan="7">张三</td>
            </tr>
            <tr align="center">
                <td bgcolor="#ededed">年级</td>
                <td colspan="7">影视一班</td>
            </tr>
            <tr align="center">
                <td bgcolor="#ededed">请假时长</td>
                <td colspan="7">3天</td>
            </tr>
            <tr align="center">
                <td bgcolor="#ededed">申请日期</td>
                <td colspan="7">2016-10-14</td>
            </tr>
            <tr align="center">
                <td bgcolor="#ededed">请假日期</td>
                <td colspan="7">2016-10-15</td>
            </tr>
            <tr align="center">
                <td bgcolor="#ededed">结束日期</td>
                <td colspan="7">2016-10-18</td>
            </tr>
            <tr align="center">
                <td bgcolor="#ededed">请假事由</td>
                <td colspan="7" width="200" height="100">有事</td>
            </tr>
            <tr align="center">
                <td bgcolor="#ededed">一审老师</td>
                <td colspan="7">丛老师</td>
            </tr>
            <tr align="center">
                <td bgcolor="#ededed">一审是否通过</td>
                <td colspan="7">通过</td>
            </tr>
            <tr align="center">
                <td bgcolor="#ededed">一审原因</td>
                <td colspan="7">同意</td>
            </tr>
        </table>
        <div class="layui-inline">
            <label class="layui-form-label">是否同意</label>
            <div class="layui-input-inline">
                <select name="modules" lay-search="" lay-verify="required">
                    <option value="">请选择类型</option>
                    <option value="1">同意</option>
                    <option value="2">不同意</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">审批意见</label>
            <div class="layui-input-block">
                <textarea class="layui-textarea" name="title" ></textarea>
            </div>
        </div>
        <button class="layui-btn" data-type="reload">查询</button>
    </form>
</div>

<script id="barDemo" type="text/html">
    <a class="layui-btn layui-btn-xs" lay-event="edit">审批</a>
</script>

</body>
</html>