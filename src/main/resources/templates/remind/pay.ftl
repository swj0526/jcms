<!DOCTYPE html>
<html lang="en">
<head>
    <base href="${basePath}">
    <meta charset="UTF-8">
    <title>缴费提醒</title>
    <link rel="stylesheet" type="text/css" href="/layui/css/layui.css"/>
    <script type="text/javascript" src="/layui/layui.js">
    </script>
    <script type="text/javascript" src="/remind/js/pay.js">
    </script>
</head>
<body>
<div class="layuimini-container">
    <div class="layuimini-main">
        <fieldset class="layui-elem-field layuimini-search">
            <legend>缴费提醒搜索</legend>
            <div style="margin: 10px 10px 10px 10px">
                <div class="demoTable">
                <form class="layui-form layui-form-pane" action="">
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">关键字</label>
                            <div class="layui-input-inline">
                                <input type="text" name="keywords" autocomplete="off" class="layui-input" placeholder="张三/201932094/5000" id="keywords">
                            </div>
                           <#-- <label class="layui-form-label">专业-班级</label>
                            <div class="layui-input-inline" lay-search="">
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
                            </div>-->
                            <div class="layui-inline">
                                <label class="layui-form-label">时间范围</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="time" autocomplete="off" class="layui-input" id="searchTime">
                                </div>
                            </div>
                        </div>
                        <div class="layui-inline">
                            <a class="layui-btn" lay-submit="" lay-filter="data-search-btn" data-type="reload">查询</a>
                        </div>
                        <div class="layui-inline">
                            <button class="layui-btn layui-btn-danger data-delete-btn">导出学生信息</button>
                        </div>
                    </div>
                </form>
                    </div>
            </div>
        </fieldset>

        <table class="layui-hide" id="test" lay-filter="test"></table>

        <script type="text/html" id="barDemo">
            <button type="button" class="layui-btn layui-btn-xs" id="see" data-method="notice">查看详细信息</button>
        </script>
    </div>
</div>
</body>

</html>