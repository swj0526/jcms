<!DOCTYPE html>
<html lang="en">
<head>
    <title>权限管理</title>
    <#include "../common/common.ftl"/>
</head>
<body style="position:relative;">
<div id="tree2" class="demo-tree demo-tree-box" style="padding-bottom: 50px;"></div>
<div style="text-align: left; position: fixed;bottom: 0px;background-color: #ffffff;width: 100%;">
    <button id="yes" type="button" class="layui-btn layui-btn-normal  " data-method="confirmTrans">
        确定
    </button>
    <button type="button" class="layui-btn layui-btn-primary  " data-method="confirmTrans">
        取消
    </button>
</div>
</body>
<script>
    layui.use(['layer', 'util', 'jquery', 'tree'], function () {
        var layer = layui.layer;
        var tree = layui.tree;
        var $ = layui.jquery;
        var roleId =${roleId};
        alert(roleId);
        var data2 = [
            <#list list as listp>
            <#if listp.pid==0>
            {
                title: '${listp.name}'
                , id: '${listp.funCode}'
                , field: 'name'
                , checked: false
                , spread: true
                , children: [
                    <#list list  as fun>
                    <#if fun.pid==listp.id>
                    {
                        title: '${fun.name}'
                        , id: '${fun.funCode}'
                        , field: 'name'
                    },
                    </#if>
                    </#list>
                ]
            },
            </#if>
            </#list>
        ]
        //开启复选框
        var oo = tree.render({
            elem: '#tree2'
            , data: data2
            , showCheckbox: true
        });
        $("#yes").click(function () {
            var data = ",";
            var checkedData = oo.getChecked('tree2'); //获取选中节点的数据
            $.each(checkedData, function (key, val) {
                $.each(val.children, function (key, val) {
                    data = data + val.id + ","
                })
            });
            $.post("/account/rolepermission", {functionIds: data, roleId: roleId}, function () {

            });
            alert(data);
        })
    });
</script>
</html>