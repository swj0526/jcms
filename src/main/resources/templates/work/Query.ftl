<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../layui/css/layui.css"/>
    <script type="text/javascript" src="../layui/layui.js"></script>
    <script type="text/javascript" src="../work/js/query.js"></script>
</head>
<body>
<div style="padding: 15px;">
    <div class="demoTable">
        <#--查询条件-->
        <form class="layui-form  layui-form-pane" id="formStudent" method="post">
            <div class="layui-form-item" >
                <label class="layui-form-label">学生姓名</label>
                <div class="layui-input-block">
                    <input type="text" name="name" placeholder="学生姓名"
                           autocomplete="off" class="layui-input" id="name">
                </div>

            </div>
            <div class="layui-form-item" >
                <label class="layui-form-label">学生班级</label>
                <div class="layui-input-block">
                    <select name="gradeId" id="gradeId">
                        <option value="0">全部</option>
                        <option value="1">一年级</option>
                        <option value="2">二年级</option>
                        <option value="3">三年级</option>
                    </select>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit lay-filter="formD" data-type="reload" id="subStudent">
                        查询
                    </button>
                    <button class="layui-btn" id="excel">
                        导出表格
                    </button>
                </div>
            </div>
        </form>
    </div>
    <table class="layui-hide" id="test" lay-filter="test"></table>
    <script id="barDemo" type="text/html">
        <a class="layui-btn layui-btn-xs" lay-event="download">下载</a>
        <a class="layui-btn layui-btn-xs" lay-event="download">修改</a>
    </script>
</div>
</body>
</html>