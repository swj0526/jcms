<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="/layui/css/public.css" media="all">
    <script src="/layui/layui.js" charset="utf-8"></script>
    <script src="/recruit/js/follow.js"></script>
</head>
<body>
<#--新增信息弹出框-->
<div style="display: none" id="recruit">
    <form class="layui-form" action="" lay-filter="dataForm" id="dataFor">
        <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">时间</label>
            <div class="layui-input-inline">
                <input type="text" name="time" autocomplete="off" class="layui-input" id="date">
            </div>
        </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">内容</label>
            <div class="layui-input-inline">
                <input type="text" name="content" required  lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">渠道</label>
            <div class="layui-input-inline">
                <input type="text" name="title" required  lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item" style="margin-left: 30%">
            <div class="layui-input-inline">
                <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>

</div>

<div class="layuimini-container">
    <div class="layuimini-main">
        <fieldset class="layui-elem-field layuimini-search">
            <legend>搜索信息</legend>
            <div style="margin: 10px 10px 10px 10px">
                <form class="layui-form layui-form-pane" action="">
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">关键字</label>
                            <div class="layui-input-inline">
                                <input type="text" name="username" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">时间</label>
                            <div class="layui-input-inline">
                                <input type="text" name="city" autocomplete="off" class="layui-input" id="a">
                            </div>
                        </div>


                        <div class="layui-inline">
                            <select name="city" lay-verify="">
                                <option value="">来源渠道</option>
                                <option value="010">学校网站</option>
                                <option value="021">自己找上门</option>
                                <option value="0571">qq</option>
                                <option value="0571">微信</option>
                                <option value="0571">介绍</option>
                            </select>
                        </div>
                        <div class="layui-inline">
                            <a class="layui-btn" lay-submit="" lay-filter="data-search-btn">搜索</a>
                        </div>
                    </div>
                </form>
            </div>
        </fieldset>
        <div class="layui-btn-group">
            <button class="layui-btn data-add-btn">添加渠道信息</button>

        </div>
        <!-- 表格 -->
        <table class="layui-hide" id="followTableId" lay-filter="currentTableFilter"></table>
        <script type="text/html" id="currentTableBar">

            <a class="layui-btn layui-btn-xs data-count-edit" lay-event="edit">修改</a>
            <a class="layui-btn layui-btn-xs layui-btn-danger data-count-delete" lay-event="delete">删除</a>
        </script>
    </div>
</div>

</body>
</html>
