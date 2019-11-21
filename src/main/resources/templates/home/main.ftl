<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>锦程职校学生管理系统</title>
    <link rel="stylesheet" type="text/css" href="/layui/css/layui.css"/>
    <script type="text/javascript" src="/jquery/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="/layui/layui.js">
    </script>
    <script type="text/javascript" src="/all.js"></script>
    <script type="text/javascript" src="/home/js/main.js"></script>
    <style>
    .layui-body{
        overflow-y: hidden;
        padding-bottom: 100px;
    }

    </style>
</head>
<body class="layui-layout-body" >
<div class="layui-layout layui-layout-admin">
    <#include "header.ftl"/>
    <#include "left.ftl"/>
    <div class="layui-body" >
        <div style="padding: 15px;height: 100%;">

            <div class="layui-tab" lay-filter="demo" lay-allowclose="true" style="height: 100%;">
                <ul class="layui-tab-title">
                </ul>
                <div class="layui-tab-content" style="height: 100%;">
                </div>
            </div>
        </div>
    </div>
    <#include "footer.ftl"/>
</div>
</body>
<script type="text/javascript">
    /* layui.use(['element', 'jquery', 'layer'], function () {
         var $ = layui.jquery, element = layui.element, layer = layui.layer;
         //id:点击左边的导航栏,获取导航中的a标签的id
         //title:选项卡的名字
         //src:controller里的映射地址
         function dynamicTab(id,title,src) {
             if($("[lay-id=" + id + "]").length==0){//选判断是否存在该选项卡
                 element.tabAdd('demo', {
                     title: title, //提醒-缴费提醒
                     content: '<iframe src='+src+' frameborder="0"   height="800px" width="100%"></iframe>',
                     id:id//实际使用一般是规定好的id，这里以时间戳模拟下
                 });
             }
             element.tabChange('demo', id); //切换到tab选项卡
         }
         var id = "first-tab";
         var title = "首页";
         var src = "/home/context";
         dynamicTab(id, title, src);
     });*/
</script>
</html>