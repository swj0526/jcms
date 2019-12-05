<!DOCTYPE html>
<html lang="en">
<head>
    <base href="${basePath}">
    <meta charset="UTF-8">
    <title>Title</title>
    <#include "../common/common.ftl"/>
    <style>
        body .layer-ext-myskin . layui-layer-content {
            overflow: visible;
        }
    </style>
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
                                       placeholder="姓名/学号/备注">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">缴费类型</label>
                            <div class="layui-inline">
                                <select name="list" lay-verify="required" class="decSelect"
                                        url="/dictionary/list/payType/options" id="typeId">
                                    <option value="">请选择</option>
                                </select>
                            </div>
                            <div class="layui-inline">
                                <label class="layui-form-label">日期范围</label>
                                <div class="layui-input-inline">
                                    <input class="layui-input" name="date" id="date" type="text" placeholder=" - ">
                                </div>
                            </div>
                            <div class="layui-inline">
                                <button class="layui-btn" type="button" lay-filter="data-search-btn" id="listBtn">查询
                                </button>
                                <button class="layui-btn" type="button" lay-filter="data-search-btn" id="addPayBillBtn">添加
                                </button>
                                <button class="layui-btn layui-btn-warm" type="button" lay-filter="data-search-btn" id="excelBtn">导出
                                </button>
                            </div>
                        </div>
                    </div>
                </form>

            </div>
        </fieldset>

    </div>
    <table class="layui-hide" id="test" lay-filter="test"></table>
    <script id="barDemo" type="text/html">
        <a class="layui-btn  layui-btn-normal layui-btn-xs" lay-event="modifyBtn">修改</a>
        <a class="layui-btn  layui-btn-xs" lay-event="UploadBtn">上传发票</a>
    </script>
    <script id="invoice" type="text/html">
        <a class="layui-btn  layui-btn-normal layui-btn-xs" lay-event="invoiceBtn">查看收据</a>

    </script>
    <script id="toolbarDemo" type="text/html">
        <div class="layui-btn-container">

        </div>
    </script>
</div>
</body>
<script type="text/javascript" src="/money/js/money.js"></script>
</html>