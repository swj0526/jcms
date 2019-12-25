<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>设置角色</title>
    <#include "../common/common.ftl"/>
</head>
<body>
<div id="roleDemo" style=" padding: 20px;">
    <form class="layui-form" action="" style="border: 1px solid #d5d5d5;height: 200px;">
        <div class="layui-form-item" style=" padding: 20px;">
            <span id="userId" style="display: none;">${id}</span>
            <#assign a=1 >
            <#list list as list>
                <#assign a=1 >
                <#list listRoleId as listRoleId>
                    <#if listRoleId==list.id>
                        <input type="checkbox" lay-filter="checkbox" value="${list.id}" name="role["
                               ${list.id}]" title="${list.name}" checked>
                        <#assign a=0 >
                        <#break>
                    </#if>
                </#list>
                <#if a==1>
                    <input type="checkbox" lay-filter="checkbox" id="lll" value="${list.id}" name="role["
                           ${list.id}]" title="${list.name}">
                </#if>

            </#list>

        </div>

    </form>

    <script>
        //Demo
        layui.use(['layer', 'form'], function () {
            var form = layui.form;
            var layer = layui.layer;


            //监听提交
            form.on('submit(formDemo)', function (data) {
                layer.msg(JSON.stringify(data.field));
                return false;
            });
            form.on('checkbox(checkbox)', function (data) {
                var roleId = data.value;
                var id = $('#userId').text();
                var check = data.elem.checked;
                if (check) {
                    $.post("/account/modifyroleid", {roleId: roleId, id: id}, function (result) {
                        if (result.success) {
                            layer.msg("设置角色成功!");
                        }
                    });
                } else {
                    $.post("/account/cancelroleid", {roleId: roleId, id: id}, function (result) {
                        if (result.success) {
                            layer.msg("取消角色成功!");
                        }
                    });
                }


            });
        });

    </script>
    </form>
</div>
</body>
</html>