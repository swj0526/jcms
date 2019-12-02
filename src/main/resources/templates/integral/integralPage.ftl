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
    <script src="/integral/js/integral.js"></script>
</head>
<body>
<div style="padding: 15px;">
    <div class="demoTable">
        <fieldset class="layui-elem-field layuimini-search">
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
                            <label class="layui-form-label">时间</label>
                            <div class="layui-input-inline">
                                <input type="text" name="username" autocomplete="off" class="layui-input"
                                       placeholder="-" id="time">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <select name="city" lay-verify="" id="major">
                                <option value="010">选择班级</option>
                                <option value="021" >影视一班</option>
                                <option value="0571" >Java一班</option>
                            </select>
                        </div>
                        <div class="layui-inline">
                            <button class="layui-btn" type="button" lay-filter="data-search-btn" id="query">查询
                            </button>

                            <button class="layui-btn" type="button" lay-filter="data-search-btn" id="add">加减分
                            </button>
                            <#--<button class="layui-btn" type="button" lay-filter="data-search-btn" id="points">减分
                            </button>-->
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
