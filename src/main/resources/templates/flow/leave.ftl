<!DOCTYPE html>
<html>
<head>
    <base href="${basePath}">
    <meta charset="utf-8">
    <title>请假申请</title>
    <link rel="stylesheet" type="text/css" href="../layui/css/layui.css">
    <link rel="stylesheet" href="../flow/css/ystep.css">
    <script type="text/javascript" src="../jquery/jquery.min.js"></script>
    <script type="text/javascript" src="../layui/layui.js"></script>
    <script type="text/javascript" src="../flow/js/leave.js"></script>
    <script type="text/javascript" src=../flow/js/setStep.js></script>
</head>
<body>
<#--条件查询-->
<div class="layui-form-item">
    <fieldset class="layui-elem-field layuimini-search">
        <legend>查询请假申请</legend>
        <div style="margin: 10px 10px 10px 10px">
            <form class="layui-form layui-form-pane" action="">
                <div class="layui-inline">
                    <label class="layui-form-label" style="width:80px">关键字</label>
                    <div class="layui-input-inline">
                        <input name="email" class="layui-input" type="text" autocomplete="off" lay-verify="email">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label" style="width:80px">状态</label>
                    <div class="layui-input-inline" style="width:130px">
                        <select name="modules" lay-search="" lay-verify="required">
                            <option value="">所有状态</option>
                            <option value="1">待审核</option>
                            <option value="1">已撤销</option>
                            <option value="1">一审通过</option>
                            <option value="1">一审拒绝</option>
                            <option value="1">二审拒绝</option>
                            <option value="1">同意</option>
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
                <button id="add" class="layui-btn layui-btn-normal" data-type="reload"  type="button">请假申请</button>
            </form>
        </div>
    </fieldset>
</div>
<#--数据表格-->
<table class="layui-hide" id="test" lay-filter="test"></table>
<br><br>
<#--请假审批详情-->
<div style="display: none" id="updateOrDelete">
        <div >
            <div class="stepCont stepCont1" style="width: 1650px">
                <!-- 菜单导航显示-->
                <div class='ystep-container ystep-lg ystep-blue' ></div>
                <!-- 分页容器-->
                <div class="pageCont">
                    <div id="page1" class="stepPage">
                        <table class="layui-table" lay-data="{width:100%,   limit: 10, limits:[10]}">
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

<#--添加请假审批-->
<div id="aaa" style="display: none">
    <fieldset class="layui-elem-field layuimini-search">
        <legend>添加请假审批</legend>
        <div style="margin: 10px 10px 10px 10px">
            <form class="layui-form layui-form-pane" action="">
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">姓名</label>
                        <div class="layui-input-inline">
                            <input type="text" name="title" required lay-verify="required" placeholder="请输入学生姓名"
                                   autocomplete="off"
                                   class="layui-input" id="xname">
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
                    <div class="layui-form-item layui-form-text" style="width: 945px">
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
    function showpage(page){
        rendersteps(page-1);
        $("#step"+page).removeClass("layui-hide").siblings(".layui-step-content").addClass("layui-hide");
    }
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
<script id="barDemo" type="text/html">
    {{# if(d.state=="1"){ }}
    <a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="revoke">撤销</a>
    {{# } }}
    {{# if(d.state=="2"){ }}
    <a class="layui-btn layui-btn-xs  layui-btn-warm" lay-event="again">重新提交</a>
    <a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="del">删除</a>
    {{# } }}
    {{# if(d.state=="3"){ }}
    <a class="layui-btn layui-btn-xs layui-btn-normal" lay-event="edit">查看详细</a>
    {{# } }}

</script>
</body>
</html>
