<!DOCTYPE html>
<html lang="en">
<head>
    <base href="${basePath}">
    <meta charset="UTF-8">
    <title>Title</title>
    <#include "../common/common.ftl"/>
</head>
<body style="margin:10px">
<table class="layui-hide" id="test" lay-filter="test"></table>
<script id="barDemo" type="text/html">
    <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="edit"><i class="layui-icon layui-icon-edit"></i></a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del"><i class="layui-icon layui-icon-delete"></i></a>
</script>
<script id="toolbarDemo" type="text/html">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="add"><i class="layui-icon layui-icon-add-1"></i></button>
    </div>
</script>
<div id="add" style="display: none">
    <fieldset class="layui-elem-field layuimini-search"style="border: 0">
        <div style="margin: 10px 10px 10px 10px">
            <form class="layui-form" lay-filter="dataForm" id="addFrom">
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label" style="width: 60px">缴费类型:</label>
                        <div class="layui-input-inline">
                            <input type="text" name="name" id="addName" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label" style="width: 60px">备注:</label>
                        <div class="layui-input-inline">
                            <input type="text" name="remark" id="addRemark" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </fieldset>
</div>
<div id="modify" style="display: none">
    <fieldset class="layui-elem-field layuimini-search" style="border: 0">
        <div style="margin: 10px 10px 10px 10px">
            <form class="layui-form " lay-filter="modifyForm">
                <div class="layui-form-item">
                    <label class="layui-form-label" style="width: 60px">缴费类型:</label>
                    <div class="layui-input-inline">
                        <input type="text" name="name" id="modifyName" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label" style="width: 60px">备注:</label>
                    <div class="layui-input-inline">
                        <input type="text" name="remark" id="modifyRemark" autocomplete="off" class="layui-input">
                    </div>
                </div>
            </form>
        </div>
    </fieldset>
</div>
</body>
<script type="text/javascript" src="/money/js/typelist.js"></script>
</html>