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
<div class="layuimini-container">
    <div class="layuimini-container">
        <div class="layuimini-main">

            <fieldset class="layui-elem-field layuimini-search">
                <div style="margin: 10px 10px 10px 10px">
                    <form class="layui-form layui-form-pane" action="">
                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <label class="layui-form-label">关键词</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="username" autocomplete="off" class="layui-input"
                                           placeholder="例：1990/张三">
                                </div>
                            </div>

                                <div class="layui-inline">
                                    <label class="layui-form-label">成绩范围</label>
                                    <div class="layui-input-inline" style="width: 100px;">
                                        <input type="text" name="price_min"  autocomplete="off" class="layui-input">
                                    </div>
                                    <div class="layui-form-mid">-</div>
                                    <div class="layui-input-inline" style="width: 100px;">
                                        <input type="text" name="price_max"  autocomplete="off" class="layui-input">
                                    </div>
                                </div>

                            <div class="layui-inline">
                                <select name="city" lay-verify="">
                                    <option value="">事由</option>
                                    <option value="010">打架斗殴</option>
                                    <option value="021">好人好事</option>
                                    <option value="0571">品学兼优</option>
                                </select>
                            </div>

                            <div class="layui-inline">
                                <a class="layui-btn" lay-submit="" lay-filter="data-search-btn">查询</a>
                            </div>
<#--                            <div class="layui-btn-group">-->
<#--                                <button class="layui-btn data-add-btn">添加</button>-->
<#--                                <button class="layui-btn layui-btn-danger data-delete-btn">导出</button>-->
<#--                            </div>-->
                        </div>
                    </form>
                </div>
            </fieldset>
<div id="table" style="display: none">
    <form class="layui-form layui-form-pane" action="">
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">时间</label>
                <div class="layui-input-inline">
                    <input type="text" name="username" autocomplete="off" class="layui-input"
                           placeholder="-" id="time">
                </div>
            </div>
            <div class="layui-inline">
                <a class="layui-btn" lay-submit="" lay-filter="data-search-btn">查询</a>
            </div>
        </div>
    </form>
    <table class="layui-hide" id="test"></table>
</div>

            <table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter"></table>
            <script type="text/html" id="currentTableBar">
                <a class="layui-btn layui-btn-primary layui-btn-xs data-count-edit" lay-event="edit" id="edit">详情</a>
            </script>
        </div>
    </div>
</div>

</body>
</html>
