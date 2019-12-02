<!DOCTYPE html>
<html lang="en">
<head>
    <base href="${basePath}">
    <meta charset="UTF-8">
    <title>设置首页播报</title>
</head>
<body>
<div class="layuimini-container">
    <div class="layuimini-main">
        <fieldset class="layui-elem-field layuimini-search">
            <legend>搜索信息</legend>
            <div style="margin: 10px 10px 10px 10px">
                <form class="layui-form layui-form-pane" action="">
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">关键词</label>
                            <div class="layui-input-inline">
                                <input type="text" name="keys" autocomplete="off" class="layui-input" placeholder="张三/201932094/5000">
                            </div>
                            <label class="layui-form-label">时间</label>
                        </div>
                        <div class="layui-inline">
                            <a class="layui-btn" lay-submit="" lay-filter="data-search-btn">查询</a>
                        </div>
                        <div class="layui-inline">
                            <button class="layui-btn layui-btn-danger data-delete-btn">导出所有播报信息</button>
                        </div>
                    </div>
                </form>
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