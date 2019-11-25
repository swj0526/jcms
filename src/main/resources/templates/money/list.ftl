<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/layui/css/layui.css"/>
    <script type="text/javascript" src="/layui/layui.js"></script>
    <script type="text/javascript" src="/money/js/money.js"></script>
    <style>
        body .layer-ext-myskin .layui-layer-content {
            overflow: visible;
        }
    </style>
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
                            <label class="layui-form-label">关键字</label>
                            <div class="layui-input-inline">
                                <input type="text" name="username" autocomplete="off" class="layui-input" placeholder="例：1990/张三/学号">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">专业-班级</label>
                            <div class="layui-input-inline" lay-verify="required" lay-search="">
                                <select name="major">
                                    <option value="">请选择专业-班级</option>
                                    <optgroup label="影视专业">
                                        <option value="">所有影视专业</option>
                                        <option value="">影视一班</option>
                                    </optgroup>
                                    <optgroup label="美术专业">
                                        <option value="">所有美术专业</option>
                                        <option value="">美术一班</option>
                                    </optgroup>
                                </select>
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">缴费类型</label>
                            <div class="layui-inline">
                                <select name="city" lay-verify="">
                                    <option value="">全部</option>
                                    <option value="01">学费</option>
                                    <option value="02">住宿费</option>
                                    <option value="03">学杂费</option>
                                </select>
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">日期范围</label>
                            <div class="layui-input-inline">
                                <input class="layui-input" name="date" id="test6" type="text" placeholder=" - ">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <a class="layui-btn" lay-filter="data-search-btn">查询</a>
                            <button class="layui-btn" type="button" lay-filter="data-search-btn" id="add">添加</button>
                            <button class="layui-btn" type="button" lay-filter="data-search-btn" id="export">导出</button>
                        </div>
                    </div>

                </form>

            </div>
        </fieldset>

    </div>
    <table class="layui-hide" id="test" lay-filter="test"></table>
    <script id="barDemo" type="text/html">
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="edit">修改</a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="up">上传发票</a>
    </script>
    <script id="toolbarDemo" type="text/html">
        <div class="layui-btn-container">

        </div>
    </script>
</div>
</body>
</html>