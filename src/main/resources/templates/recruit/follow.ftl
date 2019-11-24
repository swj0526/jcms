<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <script src="/layui/layui.js" charset="utf-8"></script>
    <script src="/recruit/js/follow.js"></script>
</head>
<body>
<#--新增信息弹出框-->
<div style="display: none" id="recruit">
    <form class="layui-form" action="" lay-filter="dataForm" id="dataFor">
        <div class="layui-form-item">
            <label class="layui-form-label">渠道名称</label>
            <div class="layui-input-inline">
                <input type="text" name="name" required  lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">渠道备注</label>
            <div class="layui-input-inline">
                <input type="text" name="remark" required  lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item" style="margin-left: 30%">
            <div class="layui-input-inline">
                <button class="layui-btn" lay-submit lay-filter="formDemo" id="add1">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>

</div>

<div class="layuimini-container">
    <div class="layuimini-main">
        <fieldset class="layui-elem-field layuimini-search">
            <legend>搜索渠道</legend>
            <div style="margin: 10px 10px 10px 10px">
                <form class="layui-form layui-form-pane" action="">

                        <div class="layui-inline">
                            <label class="layui-form-label">关键词</label>
                            <div class="layui-input-inline">
                                <input type="text" name="keywords" autocomplete="off" class="layui-input" placeholder="渠道名称/备注">
                            </div>
                        </div>

                        <div class="layui-inline">
                            <a class="layui-btn  layui-btn-primary" lay-submit="" lay-filter="data-search-btn">查询</a>
                        </div>
                        <div class="layui-btn-group">
                            <button class="layui-btn data-add-btn"type="button">添加渠道信息</button>
                        </div>

                </form>
            </div>
        </fieldset>

        <!-- 表格 -->
        <table class="layui-hide" id="followTableId" lay-filter="currentTableFilter"></table>
        <script type="text/html" id="currentTableBar">

            <a class="layui-btn layui-btn-xs data-count-edit  layui-btn-normal" lay-event="edit" >修改</a>
            <a class="layui-btn layui-btn-xs layui-btn-danger data-count-delete" lay-event="delete">删除</a>
        </script>
    </div>
</div>

</body>
</html>
