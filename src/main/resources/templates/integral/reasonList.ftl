<!DOCTYPE html>
<html lang="en">
<head>
    <base href="${basePath}">
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/layui/css/layui.css"/>
    <script type="text/javascript" src="/layui/layui.js"></script>
    <script type="text/javascript" src="/integral/js/reasonList.js"></script>
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
<div id="ll" style="display: none">
    <fieldset class="layui-elem-field layuimini-search" style="border: 0">
        <div style="margin: 10px 10px 10px 10px">
            <form class="layui-form" lay-filter="dataForm" id="addform">
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label" style="width: 60px">事由:</label>
                        <div class="layui-input-inline">
                            <input type="text" name="reason" id="addreason" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label" style="width: 60px">类型:</label>
                    <div class="layui-input-inline">
                        <select id="addtype">
                            <option value="0">加分项</option>
                            <option value="1">减分项</option>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label" style="width: 60px">分数:</label>
                        <div class="layui-input-inline">
                            <input type="text" name="score" id="addscore" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label" style="width: 60px">备注:</label>
                        <div class="layui-input-inline">
                            <input type="text" name="addremark" id="addremark" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </fieldset>
</div>
<div id="up" style="display: none">
    <fieldset class="layui-elem-field layuimini-search" style="border: 0">
        <div style="margin: 10px 10px 10px 10px">
            <form class="layui-form" lay-filter="dataForm1" id="upform">
                <input id="id" name="id" style="display: none">
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label" style="width: 60px">事由:</label>
                        <div class="layui-input-inline">
                            <input type="text" name="reason" id="upreason" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label" style="width: 60px">类型:</label>
                    <div class="layui-input-inline">
                        <select id="uptype">
                            <option value="0">加分项</option>
                            <option value="1">减分项</option>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label" style="width: 60px">分数:</label>
                        <div class="layui-input-inline">
                            <input type="text" name="score" id="upscore" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label" style="width: 60px">备注:</label>
                        <div class="layui-input-inline">
                            <input type="text" name="remark" id="upremark" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </fieldset>
</div>
</body>
</html>