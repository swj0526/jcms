<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <script src="/layui/layui.js"></script>
    <script src="/integral/js/list.js"></script>
</head>
<body>
<div style="padding: 15px;">
    <div class="demoTable">
        <fieldset class="layui-elem-field layuimini-search">
            <legend>缴费查询信息</legend>
            <div style="margin: 10px 10px 10px 10px">
                <form class="layui-form layui-form-pane">
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">关键词</label>
                            <div class="layui-input-inline">
                                <input type="text" name="username" autocomplete="off" id="keyword" class="layui-input"
                                       placeholder="姓名">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">成绩范围</label>
                            <div class="layui-input-inline" style="width: 100px;">
                                <input type="text" name="price_min" autocomplete="off" class="layui-input">
                            </div>
                            <div class="layui-form-mid">-</div>
                            <div class="layui-input-inline" style="width: 100px;">
                                <input type="text" name="price_max" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <button class="layui-btn" type="button" lay-filter="data-search-btn" id="query">查询
                            </button>
                            <button class="layui-btn layui-btn-warm" type="button" lay-filter="data-search-btn"
                                    id="export">导出
                            </button>
                        </div>
                    </div>
                </form>

            </div>
        </fieldset>

    </div>
    <table class="layui-hide" id="currentTableId" lay-filter="test"></table>
    <script id="barDemo" type="text/html">
        <a class="layui-btn  layui-btn-normal layui-btn-xs" lay-event="edit">查看详情</a>
    </script>
</div>
</body>
</html>
