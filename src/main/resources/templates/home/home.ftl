<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>锦程职校学生管理系统</title>
    <link rel="stylesheet" type="text/css" href="../layui/css/layui.css"/>
    <link rel="stylesheet" type="text/css" href="../home/css/style.css"/>
    <script type="text/javascript" src="../jquery/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="../layui/layui.js">
    </script>
    <script type="text/javascript" src="../home/js/txtscroll.js"></script>
    <style>
        #first-tab i.layui-tab-close{
            display:none!important;
        }
    </style>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <#include "../header.ftl"/>
    <#include "../left.ftl"/>
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

    <#include "../footer.ftl"/>
</div>
<script>
    layui.use(['element', 'jquery', 'layer'], function () {
        var $ = layui.jquery, element = layui.element, layer = layui.layer;
        //Tab的切换功能，切换事件监听等，需要依赖element模块
        //默认生成首页的页面
        element.tabAdd('demo', {
            title: "首页", //新增学生信息
            content: '<iframe src="/homeContext" frameborder="0" height="550px" width="100%"></iframe>',
            id: 'first-tab' //实际使用一般是规定好的id，这里以时间戳模拟下
        });
        //点击左边的按钮,然后判断是否新增tab还是需要定位一个tab
        $(".add").click(function () {
            //获取被点击的元素id,来取得准确的元素
            var id = $(this).attr('id');
            //判断是否需要新增还是定位
            if ($("[lay-id=" + id + "]").length > 0) { //存在
                //存在的话,要给这个元素动态的追加属性data-type="tabChange"
                // $(this).attr('data-type', 'tabChange');
                //切换到指定Tab项
                element.tabChange('demo', id); //切换到：用户管理
            } else { //新增
                //$(this).attr('data-type', 'tabAdd');
                //根据id判断嵌入什么页面
                if (id == "1") {
                    element.tabAdd('demo', {
                        title: $(this).text(), //新增学生信息
                        content: '<iframe src="/student/toAdd" frameborder="0" height="550px" width="100%"></iframe>',
                        id: id //实际使用一般是规定好的id，这里以时间戳模拟下
                    });
                    //$(this).attr('data-type', 'tabChange');
                    element.tabChange('demo', id);
                } else if (id == "3") {
                    element.tabAdd('demo', {
                        title: $(this).text(), //学生信息查询
                        content: '<iframe src="/student/toList" frameborder="0" height="700px" width="100%"></iframe>',
                        id: id //实际使用一般是规定好的id，这里以时间戳模拟下
                    });
                    //$(this).attr('data-type', 'tabChange');
                    //切换到指定Tab项
                    element.tabChange('demo', id);
                } else if (id == "4") {
                    element.tabAdd('demo', {
                        title: $(this).text(), //学生信息查询
                        content: '<iframe src="/notSee" frameborder="0" height="700px" width="100%"></iframe>',
                        id: id //实际使用一般是规定好的id，这里以时间戳模拟下
                    });
                    //$(this).attr('data-type', 'tabChange');
                    //切换到指定Tab项
                    element.tabChange('demo', id);
                }
            }
        });
        $('.site-demo-active').on('click', function () {
            var othis = $(this),
                type = othis.data('type');
            //active[type] ? active[type].call(this, othis) : '';
        });
        //Hash地址的定位
        var layid = location.hash.replace(/^#test=/, '');
        element.tabChange('test', layid);
        element.on('tab(test)', function (elem) {
            location.hash = 'test=' + $(this).attr('lay-id');
        });

        $('#remind').click(function () {
            //配置一个透明的询问框
            layer.msg('您有9条为阅读的消息', {
                time: 20000, //20s后自动关闭
                btn: ['查看消息', '忽略']
            });
        });

    });
    $(function () {
        $('.txt-scroll').txtscroll({
            'speed': 50
        });
    });
</script>
</body>
</html>