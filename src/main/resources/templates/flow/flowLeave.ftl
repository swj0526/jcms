<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>请假申请</title>
    <link rel="stylesheet" type="text/css" href="../layui/css/layui.css">
    <script type="text/javascript" src="../jquery/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="../layui/layui.js"></script>
    <script type="text/javascript" src="../flow/js/flowLeave.js"></script>

</head>
<body>

//请假申请查询
<table class="layui-hide" id="test" lay-filter="test"></table>
<div class="layui-btn-container">
    <table class="layui-hide" id="test" lay-filter="test"></table>
</div>
<br><br>

//请假申请弹窗
<div style="display: none" id="aaa">
    <form class="layui-form" action="">
        <div class="layui-form-item">
            <label class="layui-form-label">学号</label>
            <div class="layui-input-inline">
                <input type="text" name="title" required lay-verify="required" placeholder="请输入学生学号" autocomplete="off"
                       class="layui-input" id="xname">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-inline">
                <input type="text" name="title" required lay-verify="required" placeholder="请输入学生姓名" autocomplete="off"
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
            <label class="layui-form-label">请假时长</label>
            <div class="layui-input-inline">
                <input type="text" name="title" required lay-verify="required" placeholder="请输入请假时长" autocomplete="off"
                       class="layui-input" id="xname">
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
            <label class="layui-form-label">请假事由</label>
            <div class="layui-input-inline">
                <input type="text" name="title" required lay-verify="required" placeholder="请输入请假事由" autocomplete="off"
                       class="layui-textarea" id="age">
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
<script id="toolbarDemo" type="text/html">
    <div class="layui-btn-container">
        <button id="add" class="layui-btn layui-btn-sm">请假申请</button>
    </div>
</script>

</body>
</html>
