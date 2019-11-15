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
    <button id="add" class="layui-btn layui-btn-sm">经费申请</button>
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
        <div class="layui-form-item">
            <label class="layui-form-label">申请人</label>
            <div class="layui-input-inline">
                <input type="text" name="name" required lay-verify="required" placeholder="请输入申请人姓名" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">年级</label>
            <div class="layui-input-inline">
                <input type="text" name="grade" required lay-verify="required" placeholder="请输入年龄" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">申请事由</label>
            <div class="layui-input-block">
                <textarea class="layui-textarea" name="cause" placeholder="请输入申请事由"></textarea>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">申请金额</label>
            <div class="layui-input-inline">
                <input type="text" name="money" required lay-verify="required" placeholder="请输入申请金额" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">申请时间</label>
            <div class="layui-input-inline">
                <input type="text" name="apply" required lay-verify="required" placeholder="请输入申请日期" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">开始日期</label>
            <div class="layui-input-inline">
                <input class="layui-input" name="start" type="text" placeholder="yyyy-MM-dd">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">状态</label>
            <div class="layui-input-inline">
                <input type="text" name="state" required lay-verify="required"  autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="formDemo" id="but">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>

<#--添加经费审批-->
<div style="display: none" id="aaa">
    <form class="layui-form" action="">

        <div class="layui-form-item">
            <label class="layui-form-label">申请人</label>
            <div class="layui-input-inline">
                <input type="text" name="title" required lay-verify="required" placeholder="请输入申请人姓名" autocomplete="off"
                       class="layui-input" id="xname">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">年级</label>
            <div class="layui-input-inline">
                <input type="text" name="title" required lay-verify="required" placeholder="请输入学生年级" autocomplete="off"
                       class="layui-input" id="xname">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">申请事由</label>
            <div class="layui-input-block">
                <textarea class="layui-textarea" name="cause" placeholder="请输入申请事由"></textarea>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">申请金额</label>
            <div class="layui-input-inline">
                <input type="text" name="title" required lay-verify="required" placeholder="请输入申请金额" autocomplete="off"
                       class="layui-input" id="age">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">申请日期</label>
            <div class="layui-input-inline">
                <input class="layui-input" id="test1" type="text" placeholder="yyyy-MM-dd">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">开始日期</label>
            <div class="layui-input-inline">
                <input class="layui-input" id="test2" type="text" placeholder="yyyy-MM-dd">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="formDemo" id="student">立即提交</button>
            </div>
        </div>
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
