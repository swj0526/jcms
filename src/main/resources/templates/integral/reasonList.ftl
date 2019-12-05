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
    <fieldset class="layui-elem-field layuimini-search" style="border: 0">
        <div style="margin: 10px 10px 10px 10px">
            <form class="layui-form" lay-filter="dataForm" id="addForm">
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label" style="width: 60px">事由:</label>
                        <div class="layui-input-inline">
                            <input type="text" name="reason" id="addReason" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label" style="width: 60px">类型:</label>
                    <div class="layui-input-inline">
                        <select id="addType">
                            <option value="0">加分项</option>
                            <option value="1">减分项</option>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label" style="width: 60px">分数:</label>
                        <div class="layui-input-inline">
                            <input type="text" name="score" id="addScore" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label" style="width: 60px">备注:</label>
                        <div class="layui-input-inline">
                            <input type="text" name="addremark" id="addRemark" autocomplete="off" class="layui-input">
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
            <form class="layui-form" lay-filter="modifyForm" id="modifyForm">
                <input id="id" name="id" style="display: none">
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label" style="width: 60px">事由:</label>
                        <div class="layui-input-inline">
                            <input type="text" name="reason" id="modifyReason" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label" style="width: 60px">类型:</label>
                    <div class="layui-input-inline">
                        <select id="modifyType">
                            <option value="0">加分项</option>
                            <option value="1">减分项</option>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label" style="width: 60px">分数:</label>
                        <div class="layui-input-inline">
                            <input type="text" name="score" id="modifyScore" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label" style="width: 60px">备注:</label>
                        <div class="layui-input-inline">
                            <input type="text" name="remark" id="modifyRemark" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </fieldset>
</div>
</body>
<script type="text/javascript" src="/integral/js/reasonList.js"></script>
</html>