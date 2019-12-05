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
                            <label class="layui-form-label">成绩范围</label>
                            <div class="layui-input-inline" style="width: 100px;">
                                <input type="text" name="start" id="start" autocomplete="off" class="layui-input">
                            </div>
                            <div class="layui-form-mid">-</div>
                            <div class="layui-input-inline" style="width: 100px;">
                                <input type="text" name="end" id="end" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <button class="layui-btn" type="button" lay-filter="data-search-btn" id="listBtn">查询
                            </button>
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
<script src="/integral/js/list.js"></script>
</html>
