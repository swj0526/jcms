<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>请假申请</title>
    <link rel="stylesheet" type="text/css" href="../layui/css/layui.css">
    <script type="text/javascript" src="../jquery/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="../layui/layui.js"></script>
    <script type="text/javascript" src="../flow/js/leave.js"></script>

</head>
<body>
<#--条件查询-->
<div class="layui-form-item">
    <fieldset class="layui-elem-field layuimini-search">
        <legend>查询请假申请</legend>
        <div style="margin: 10px 10px 10px 10px">
            <form class="layui-form layui-form-pane" action="">
                <div class="layui-inline">
                    <label class="layui-form-label">关键字</label>
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
                <button id="add" class="layui-btn" data-type="reload">请假申请</button>
            </form>
        </div>
    </fieldset>
</div>
<#--数据表格-->
<table class="layui-hide" id="test" lay-filter="test"></table>
<div class="layui-btn-container">
    <table class="layui-hide" id="test" lay-filter="test"></table>
</div>
<br><br>

<#--请假审批详情-->
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
                <td colspan="7">有事</td>
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

<#--添加请假审批-->
<div id="aaa" style="display: none">
    <fieldset class="layui-elem-field layuimini-search">
        <legend>添加请假审批</legend>
        <div style="margin: 10px 10px 10px 10px">
            <form class="layui-form layui-form-pane" action="">
                <div class="layui-form-item">

                    <div class="layui-form-item">
                        <label class="layui-form-label">姓名</label>
                        <div class="layui-input-inline">
                            <input type="text" name="title" required lay-verify="required" placeholder="请输入学生姓名"
                                   autocomplete="off"
                                   class="layui-input" id="xname">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">专业-班级</label>
                        <div class="layui-input-inline" lay-verify="required" lay-search="">
                            <select name="major">
                                <option value="">请选择专业-班级</option>
                                <optgroup label="影视专业">
                                    <option value="">所有影视专业</option>
                                    <option value="">影视一班</option>
                                </optgroup>
                                <optgroup label="美术专业">
                                    <option value="">所有美术专业</option>
                                    <option value="">美术一班</option>
                                </optgroup>
                            </select>
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">类型</label>
                        <div class="layui-input-inline">
                            <select name="modules" lay-search="" lay-verify="required">
                                <option value="">所有状态</option>
                                <option value="1">事假</option>
                                <option value="2">病假</option>
                            </select>
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">开始日期</label>
                        <div class="layui-input-inline">
                            <input class="layui-input" id="test5" type="text" placeholder="yyyy-MM-dd HH:mm:ss">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">结束日期</label>
                        <div class="layui-input-inline">
                            <input class="layui-input" id="test7" type="text" placeholder="yyyy-MM-dd HH:mm:ss">
                        </div>
                    </div>
                    <div class="layui-form-item layui-form-text">
                        <label class="layui-form-label">请假事由</label>
                        <div class="layui-input-block">
                            <textarea class="layui-textarea" name="title" placeholder="请输入请假事由"></textarea>
                        </div>
                    </div>

                </div>
            </form>
        </div>
    </fieldset>
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
