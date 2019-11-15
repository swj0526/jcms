<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>锦程职校学生管理系统</title>
    <link rel="stylesheet" type="text/css" href="/layui/css/layui.css"/>
    <link rel="stylesheet" type="text/css" href="/home/css/style.css"/>
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
            <div class="txt-scroll txt-scroll-default">
                <div class="scrollbox">
                    <div class="txt">
                        深圳市移联天下电子商务有限公司成立于2014年， 是集移动互联网新消费模式、品质消费体验、社交分享于一体的会员权益服务平台。基于移动互联网消费升级新需求，连接线上线下消费新场景，通过大数据、人工智能及云计算等技术手段，致力于为用户连接优质服务、快乐分享、成就美好生活。
                    </div>
                </div>
            </div>


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