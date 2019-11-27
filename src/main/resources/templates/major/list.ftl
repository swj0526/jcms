<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>班级-专业管理</title>
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <script type="text/javascript" src="/layui/layui.js"></script>
    <script type="text/javascript" src="/major/js/list.js"></script>

</head>
<body>
<div>
    <#--新增信息弹出框-->
    <div style="display: none" id="recruit">
        <form class="layui-form" action="" id="dataFor">
            <div class="layui-form-item">
                <span style="color: red;display: inline-block;height: 38px;line-height: 38px;">*</span>
                <label class="layui-form-label">渠道名称</label>
                <div class="layui-input-inline">
                    <input type="text" name="nameA" required lay-verify="required" placeholder="" autocomplete="off"
                           class="layui-input">

                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">渠道备注</label>
                <div class="layui-input-inline">
                    <input type="text" name="remarkA" placeholder="" autocomplete="off"
                           class="layui-input">
                </div>
            </div>

            <div class="layui-form-item" style="margin-left: 30%">
                <div class="layui-input-inline">
                    <button class="layui-btn" lay-submit lay-filter="formDemo" id="add1">立即提交</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>
        </form>

    </div>
    <div class="layui-btn-group">
        <button class="layui-btn data-add-btn" type="button" id="add">添加渠道信息</button>
    </div>
    <table class="layui-table">
        <tr style="background-color: #F2F2F2;">
            <th>班级-专业</th>
            <th>备注</th>
            <th>操作</th>
        </tr>
        <tr>
            <td><a class="icon"><i class="layui-icon layui-icon-right"></i></a>&nbsp;&nbsp;影视专业</td>
            <td>无</td>
            <td><a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a> <a
                        class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a></td>
        </tr>
        <tr>
            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;∟影视一班</td>
            <td>无</td>
            <td><a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a> <a
                        class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a></td>
        </tr>
        <tr>
            <td><a class="icon"><i class="layui-icon layui-icon-right"></i></a>&nbsp;&nbsp;美术专业</td>
            <td>无</td>
            <td><a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a> <a
                        class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a></td>
        </tr>
        <tr>
            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;∟美术一班</td>
            <td>无</td>
            <td><a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a> <a
                        class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a></td>
        </tr>
    </table>
</div>
</body>
</html>