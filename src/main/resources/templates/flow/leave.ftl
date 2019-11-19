<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>请假申请</title>
    <link rel="stylesheet" type="text/css" href="../layui/css/layui.css">
    <script type="text/javascript" src="../jquery/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="../layui/layui.js"></script>
    <script type="text/javascript" src="../flow/js/leave.js"></script>
    <script type="text/javascript" src="../layui/config.js"></script>
    <link rel="stylesheet" href="../layui/extend/steps/style.css">
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
                    <label class="layui-form-label" style="width:80px">类型</label>
                    <div class="layui-input-inline" style="width:150px">
                        <select name="modules" lay-search="" lay-verify="required" >
                            <option value="">请选择类型</option>
                            <option value="1">事假</option>
                            <option value="2">病假</option>
                        </select>
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
                <button id="add" class="layui-btn" data-type="reload" class="layui-btn" type="button">请假申请</button>
            </form>
        </div>
    </fieldset>
</div>
<#--数据表格-->
<table class="layui-hide" id="test" lay-filter="test"></table>
<br><br>
<div id="step_demo" class="step-body">
    <div class="step-header" style="width:80%;overflow: hidden;">
        <ul>
            <li>
                <span class="step-name">填写申请表</span>
            </li>
            <li>
                <span class="step-name">上传资料</span>
            </li>
            <li>
                <span class="step-name">待确认</span>
            </li>
            <li>
                <span class="step-name">已确认</span>
            </li>
            <li>
                <span class="step-name">待受理</span>
            </li>
            <li>
                <span class="step-name">已受理</span>
            </li>
            <li>
                <span class="step-name">预约完成</span>
            </li>
            <li>
                <span class="step-name">签证单已发放</span>
            </li>
        </ul>
    </div>
    <div class="step-content">
        <div class="step-list">填写申请表</div>
        <div class="step-list">上传资料</div>
        <div class="step-list">待确认</div>
        <div class="step-list">已确认</div>
        <div class="step-list">待受理</div>
        <div class="step-list">已受理</div>
        <div class="step-list">预约完成</div>
        <div class="step-list">签证单已发放</div>
        <div class="step-list">完成</div>
    </div>

</div>

<button id="preBtn">上一步</button>
<button id="nextBtn">下一步</button>
<button id="goBtn">跳转的指定的步骤</button>

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
        <div>
            <button class="layui-btn layui-btn-radius" type="button" id="id1">1</button>
            <button class="layui-btn layui-btn-radius" type="button" id="id2">2</button>
            <button class="layui-btn layui-btn-radius" type="button" id="id3">3</button>

            <button class="layui-btn layui-btn-disabled layui-btn-radius" type="button">禁用按钮</button>
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
    function showpage(page){
        rendersteps(page-1);
        $("#step"+page).removeClass("layui-hide").siblings(".layui-step-content").addClass("layui-hide");
    }
</script>
<script id="barDemo" type="text/html">
    <a class="layui-btn layui-btn-xs" lay-event="edit">查看详细</a>
    <a class="layui-btn layui-btn-xs" lay-event="revoke">撤销</a>
    <a class="layui-btn layui-btn-xs" lay-event="again">重新提交</a>
    <a class="layui-btn layui-btn-xs" lay-event="del">删除</a>
</script>

</body>
</html>
