<!DOCTYPE html>
<html lang="en">
<head>

    <title>权限管理</title>
    <#include "../common/common.ftl"/>
</head>
<body>

<div style="display: none;padding: 15px;" id="addPop">
    <form class="layui-form" action="" lay-filter="dataForm" id="dataFor">
        <div class="layui-form-item">
            <label class="layui-form-label">角色姓名<span class="star">*</span></label>
            <div class="layui-input-inline">
                <input type="text" name="addName" required lay-verify="required" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">角色备注<span class="star"></span></label>
            <div class="layui-input-inline">
                <input type="text" name="addRemark" lay-verify="required" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item" style="margin-left: 30%">
            <div class="layui-input-inline">
                <button class="layui-btn" type="button" lay-submit="" lay-filter="addRoleBtn" id="addBtn">立即提交</button>
            </div>
        </div>
    </form>

</div>
<!--弹出框修改-->
<div style="display: none" id="updatePop">
    <form class="layui-form" action="" lay-filter="dataForm1" id="dataFor">
        <div class="layui-form-item">
            <label class="layui-form-label">角色姓名</label>
            <div class="layui-input-inline">
                <input type="text" name="name" lay-verify="required" required autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">角色备注</label>
            <div class="layui-input-inline">
                <input type="text" name="remark" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item" style="margin-left: 30%">
            <div class="layui-input-inline">
                <button class="layui-btn" lay-submit="" lay-filter="formDemo" id="modifyBtn">确定修改</button>
            </div>
        </div>
    </form>

</div>
<div class="layui-tab " lay-filter="roleTable" id="roleTable">
    <div class="layui-tab-content">
        <div class="layui-tab-item layui-show">
            <div class="layuimini-container">
                <div class="layuimini-main">
                    <div class="layui-inline">
                        <a class="layui-btn" lay-submit="" lay-filter="data-search-btn" id="roleAdd">添加</a>
                    </div>
                    <table class="layui-hide" id="test" lay-filter="test"></table>

                    <script type="text/html" id="currentTableBar">
                        <#--<button type="button" class="layui-btn  layui-btn-xs" lay-event="fun"
                                data-method="confirmTrans">
                            设置权限
                        </button>-->
                        {{# if(d.id!=1){ }}
                        <button type="button" class="layui-btn  layui-btn-xs" lay-event="fun"
                                data-method="confirmTrans">
                            设置权限
                        </button>

                        {{# } }}

                        {{# if(d.state!=true){ }}
                        <button type="button" class="layui-btn  layui-btn-danger  layui-btn-xs" lay-event="delete"
                                data-method="confirmTrans">
                            删除
                        </button>
                        <button type="button" class="layui-btn layui-btn-normal layui-btn-xs" lay-event="edit"
                                data-method="confirmTrans">
                            修改
                        </button>

                        {{# } }}

                    </script>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="/account/js/role.js"></script>
</html>