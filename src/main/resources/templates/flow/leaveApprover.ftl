<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../layui/css/layui.css">
    <link rel="stylesheet" href="../flow/css/ystep.css">
    <script type="text/javascript" src="../jquery/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="../layui/layui.js"></script>
    <script type="text/javascript" src="../flow/js/leaveApprover.js"></script>
    <script type="text/javascript" src="../flow/js/leave.js"></script>
    <script type="text/javascript" src=../flow/js/setStep.js></script>
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
                    <option value="1">已审批</option>
                    <option value="2">未审批</option>
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
        <th rowspan="3" lay-data="{field:'name',align:'center'}">姓名</th>
        <th rowspan="3" lay-data="{field:'grade',align:'center'}">年级</th>
        <th rowspan="3" lay-data="{field:'days',align:'center'}">请假时长</th>
        <th rowspan="3" lay-data="{field:'apply',align:'center'}">申请日期</th>
        <th rowspan="3" lay-data="{field:'leaveTime',align:'center'}">请假日期</th>
        <th rowspan="3" lay-data="{field:'leaveTime',align:'center'}">结束日期</th>
        <th rowspan="3" lay-data="{field:'cause',align:'center'}">请假事由</th>
        <th rowspan="3" lay-data="{field:'state',align:'center'}">状态</th>
        <th colspan="3" lay-data="{align:'center'}">一审</th>
        <th colspan="3" lay-data="{align:'center'}">二审</th>
        <th rowspan="3" lay-data="{fixed: 'right', toolbar: '#barDemo',align: 'center',width: 140}">操作</th>
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
        <td>张三111</td>
        <td>影视一班</td>
        <td>3天</td>
        <td>2016-10-14</td>
        <td>2016-10-15</td>
        <td>2016-10-18</td>
        <td>有事</td>
        <td>1</td>
        <td>丛老师</td>
        <td>丛老师</td>
        <td>同意</td>
        <td>通过</td>
        <td>胡老师</td>
        <td>拒绝</td>
        <td>不同意</td>
    </tr>
    <tr>
        <td>张三</td>
        <td>影视一班</td>
        <td>3天</td>
        <td>2016-10-14</td>
        <td>2016-10-15</td>
        <td>2016-10-18</td>
        <td>有事</td>
        <td>2</td>
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
    <div >
        <div class="stepCont stepCont1" style="width: 1650px">
            <!-- 菜单导航显示-->
            <div class='ystep-container ystep-lg ystep-blue' ></div>
            <!-- 分页容器-->
            <div class="pageCont">
                <div id="page1" class="stepPage">
                    <table class="layui-table" lay-data="{width:100%, limit: 10, limits:[10]}">
                        <thead>
                        <tr>
                            <th lay-data="{field:'name',align:'center'}">姓名</th>
                            <th lay-data="{field:'grade',align:'center'}">年级</th>
                            <th lay-data="{field:'days',align:'center'}">请假时长</th>
                            <th lay-data="{field:'apply',align:'center'}">申请日期</th>
                            <th lay-data="{field:'leaveTime',align:'center'}">请假日期</th>
                            <th lay-data="{field:'leaveTime',align:'center'}">结束日期</th>
                            <th lay-data="{field:'cause',align:'center'}">请假事由</th>
                        </tr>

                        </thead>
                        <tbody>
                        <tr>
                            <td>张三111</td>
                            <td>影视一班</td>
                            <td>3天</td>
                            <td>2016-10-14</td>
                            <td>2016-10-15</td>
                            <td>2016-10-18</td>
                            <td >有事</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div id="page2" class="stepPage">
                    <table class="layui-table" lay-data="{width:100%,   limit: 10, limits:[10]}">
                        <thead>
                        <tr>
                            <th lay-data="{field:'name',align:'center'}">审批老师</th>
                            <th lay-data="{field:'grade',align:'center'}">是否同意</th>
                            <th lay-data="{field:'cause',align:'center'}">审批意见</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>丛老师</td>
                            <td>同意</td>
                            <td >通过</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div id="page3" class="stepPage">
                    <table class="layui-table" lay-data="{width:100%,   limit: 10, limits:[10]}">
                        <thead>
                        <tr>
                            <th lay-data="{field:'name',align:'center'}">审批老师</th>
                            <th lay-data="{field:'grade',align:'center'}">是否同意</th>
                            <th lay-data="{field:'cause',align:'center'}">审批意见</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>胡老师</td>
                            <td>拒绝</td>
                            <td>不同意</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<#--请假审批-->
<div id="aaa" style="display: none">
    <fieldset class="layui-elem-field layuimini-search">
        <legend>添加请假审批</legend>
        <div style="margin: 10px 10px 10px 10px">
            <form class="layui-form layui-form-pane" action="">
                <table class="layui-table" lay-data="{width:1650,limit: 10, limits:[10]}">
                    <thead>
                    <tr>
                        <th lay-data="{field:'name',align:'center'}">姓名</th>
                        <th lay-data="{field:'grade',align:'center'}">年级</th>
                        <th lay-data="{field:'days',align:'center'}">请假时长</th>
                        <th lay-data="{field:'apply',align:'center'}">申请日期</th>
                        <th lay-data="{field:'leaveTime',align:'center'}">请假日期</th>
                        <th lay-data="{field:'leaveTime',align:'center'}">结束日期</th>
                        <th lay-data="{field:'cause',align:'center'}">请假事由</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>张三111</td>
                        <td>影视一班</td>
                        <td>3天</td>
                        <td>2016-10-14</td>
                        <td>2016-10-15</td>
                        <td>2016-10-18</td>
                        <td >有事</td>
                    </tr>
                    </tbody>
                </table>
                <div class="layui-inline">
                    <label class="layui-form-label" style="width:120px">是否同意</label>
                    <div class="layui-input-inline" style="width:150px">
                        <select name="modules" lay-search="" lay-verify="required" >
                            <option value="">请选择</option>
                            <option value="1">同意</option>
                            <option value="2">不同意</option>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-form-item layui-form-text">
                        <label class="layui-form-label">审批意见</label>
                        <div class="layui-input-block">
                            <textarea class="layui-textarea" name="title" placeholder="请输入请假事由"></textarea>
                        </div>
                    </div>

                </div>
            </form>
        </div>
    </fieldset>
</div>
<script id="barDemo" type="text/html">
    {{# if(d.state=="1"){ }}
    <a class="layui-btn layui-btn-xs" lay-event="edit">审批</a>
    {{# } }}
    {{# if(d.state=="2"){ }}
    <a class="layui-btn layui-btn-xs" lay-event="see">查看详情</a>
    {{# } }}
</script>

<script>
    var step1=new SetStep({
        content:'.stepCont1',
        showBtn:false,
    });
    var step2=new SetStep({
        content:'.stepCont2',
        clickAble:false
    });
    var step3=new SetStep({
        content:'.stepCont3'
    })
</script>
</body>
</html>