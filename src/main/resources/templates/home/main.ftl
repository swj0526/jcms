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
        .layui-body {
            overflow-y: hidden;
            padding-bottom: 100px;
        }


    </style>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <#include "header.ftl"/>
    <#include "left.ftl"/>
    <div class="layui-body">
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
</html>