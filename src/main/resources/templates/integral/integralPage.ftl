<!DOCTYPE html>
<html>
<head>
    <base href="${basePath}">
    <meta charset="utf-8">
    <title>layui</title>
    <#include "../common/common.ftl"/>

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
                                <input type="text" name="keyword" autocomplete="off" id="keyword" class="layui-input"
                                       placeholder="姓名">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">时间</label>
                            <div class="layui-input-inline">
                                <input type="text" name="time" autocomplete="off" class="layui-input"
                                       placeholder="-" id="time">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">专业班级</label>
                            <div class="layui-inline">
                            <select name="major" lay-verify="" id="majorSelect" required
                                    lay-verify="required"
                                    url="/major/list/select">
                                <option value="">请选择</option>
                            </select>
                            </div>
                        </div>
                        <div class="layui-inline">
                            <button class="layui-btn" type="button" lay-filter="data-search-btn" id="listBtn">查询
                            </button>

                            <button class="layui-btn" type="button" lay-filter="data-search-btn" id="addBtn">加减分
                            </button>
                            <#--<button class="layui-btn" type="button" lay-filter="data-search-btn" id="points">减分
                            </button>-->
                            <button class="layui-btn layui-btn-warm" type="button" lay-filter="data-search-btn"
                                    id="excelBtn">导出
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
<script src="/integral/js/integral.js"></script>
<script>
    sel_garade();
</script>
</html>
