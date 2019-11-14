<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../layui/css/layui.css"/>
    <script type="text/javascript" src="../layui/layui.js">
    </script>
</head>
<body>
<#--<body class="layui-layout-body" style="overflow-x:hidden;">-->
<#--<div class="layui-layout layui-layout-admin">-->





            <table class="layui-hide" id="test" lay-filter="test"></table>

<script type="text/html" id="barDemo">
    <button type="button" class="layui-btn layui-btn-xs">查看</button>
</script>

<#--
</div>-->

<script>
    //JavaScript代码区域
    layui.use(['table', 'layer', 'jquery', 'form'], function () {

        var table = layui.table;
        var layer = layui.layer;
        var $ = layui.jquery;
        var form = layui.form;

        //渲染数据表格
        var tableIns = table.render({
            elem: '#test'//渲染目标
           /* , url: '/json/table.json'//数据接口*/
            , id: 'userTableReload'
            , cols: [[
                {field: 'title', title: '标题'},
                {field: 'explain', title: '内容说明'},
                {field:'issuer',title:'发布人'}
                , {fixed: 'right', title: '操作', toolbar: '#barDemo'}
            ]]
            ,data:[{
                title:"作息时间表",
                explain:'最新的作息时间表',
                issuer:'管理老师'

            }]
        });



        //修改弹窗
        function modify(data) {
            mainIndex = layer.open({
                type: 1,
                title: "修改用户",
                skin: 'layui-layer-rim', //加上边框
                area: ['500px', '500px'], //设置宽高
                content: $("#updateOrDelete"),
                success: function (index) {
                    form.val("dataForm", data);
                    url = "/student/modify"
                }
            });
        }



    });
</script>
</body>
<#--</body>-->
</html>