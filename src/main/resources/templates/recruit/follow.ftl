<!DOCTYPE html>
<html>
<head>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <#include "../common/common.ftl"/>
    <script src="/recruit/js/follow.js"></script>
    <style>
        .layui-form-label {
            margin-left: 25px;
        }
    </style>
</head>
<body>
<#--新增信息弹出框-->
<div style="display: none" id="addPopups">
    <form class="layui-form" action="" id="dataFor">
        <div class="layui-form-item">

            <label class="layui-form-label">渠道名称 <span class="star">*</span></label>

            <div class="layui-input-inline">
                <input type="text" name="addName" required lay-verify="required" placeholder="" autocomplete="off"
                       class="layui-input">

            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">渠道备注 <span class="star"></span></label>
            <div class="layui-input-inline">
                <input type="text" name="addRemark" placeholder="" autocomplete="off"
                       class="layui-input">
            </div>
        </div>

        <div class="layui-form-item" style="margin-left: 30%">
            <div class="layui-input-inline">
                <button class="layui-btn" lay-submit lay-filter="formDemo" id="addFollowBtn">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>

</div>
<#--新增信息弹出框-->
<div style="display: none" id="modifyPopups">
    <form class="layui-form" action="" lay-filter="dataForm" id="dataFor">
        <div class="layui-form-item">

            <label class="layui-form-label">渠道名称<span class="star">*</span></label>
            <div class="layui-input-inline">
                <input type="text" name="modifyName" required lay-verify="required" placeholder="" autocomplete="off"
                       class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">渠道备注 <span class="star"></span></label>
            <div class="layui-input-inline">
                <input type="text" name="modifyRemark" placeholder="" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item" style="margin-left: 30%">
            <div class="layui-input-inline">
                <button class="layui-btn" lay-submit lay-filter="formDemo" id="modifyFollowBtn">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>


</div>

<div class="layuimini-container">
    <div class="layuimini-main">
        <fieldset class="layui-elem-field layuimini-search">

            <div style="margin: 10px 10px 10px 10px">
                <form class="layui-form layui-form-pane" action="">

                    <div class="layui-inline">
                        <label class="layui-form-label">关键词</label>
                        <div class="layui-input-inline">
                            <input type="text" name="keywords" autocomplete="off" class="layui-input"
                                   placeholder="渠道名称/备注">
                        </div>
                    </div>

                    <div class="layui-inline">
                        <a class="layui-btn  layui-btn-primary" lay-submit="" lay-filter="data-search-btn">查询</a>
                    </div>
                   <#-- <div class="layui-btn-group">
                        <button class="layui-btn data-add-btn" type="button">添加渠道信息</button>
                    </div>-->

                </form>
            </div>
        </fieldset>

        <!-- 表格 -->
        <table class="layui-hide" id="followTable" lay-filter="followTable"></table>
        <script type="text/html" id="currentTableBar">
            <a class="layui-btn layui-btn-xs data-count-edit  layui-btn-normal" lay-event="edit">修改</a>
            <a class="layui-btn layui-btn-xs layui-btn-danger data-count-delete" lay-event="delete">删除</a>
        </script>
    </div>
</div>

</body>
</html>
