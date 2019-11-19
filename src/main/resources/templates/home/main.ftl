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
    <script type="text/javascript" src="/home/js/txtscroll.js"></script>
    <script type="text/javascript" src="/home/js/main.js"></script>
    <style>

        #first-tab i.layui-tab-close{
            display:none!important;
        }
    </style>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <#include "header.ftl"/>
    <#include "left.ftl"/>
    <div class="layui-body">
        <div style="padding: 15px;">


            <div class="layui-tab" lay-filter="demo" lay-allowclose="true">
                <ul class="layui-tab-title">
                </ul>
                <div class="layui-tab-content">
                </div>
            </div>
        </div>
    </div>
    <#include "footer.ftl"/>
</div>
</body>
</html>