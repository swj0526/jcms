<!DOCTYPE html>
<html lang="en">
<head>
    <base href="${basePath}">
    <meta charset="UTF-8">
    <title>试学管理信息</title>
    <link rel="stylesheet" href="/layui/css/layui.css"media="all">
    <script src="/layui/layui.js" charset="utf-8"></script>
    <script src="/recruit/js/internship.js"></script>
</head>
<body>
<div class="layuimini-container">
    <div class="layuimini-main">
        <fieldset class="layui-elem-field layuimini-search">

            <div style="margin: 10px 10px 10px 10px">
                <div class="demoTable">
                    <form class="layui-form layui-form-pane" action="">
                        <div class="layui-inline" style="width: 210px">
                            <label class="layui-form-label" style="width:100px">关键词</label>
                            <div class="layui-input-inline" style="width:100px ">
                                <input type="text" id="demoReload" autocomplete="off"  placeholder="姓名"class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">范围时间</label>
                            <div class="layui-input-inline">
                                <input type="text" name="city" autocomplete="off" class="layui-input" id="a">
                            </div>
                        </div>
                        <div class="layui-inline" style="width: 210px">
                            <label class="layui-form-label" style="width: 100px">性别</label>
                            <div class="layui-inline" style="width: 100px">
                                <select name="sex" lay-verify="" id="sex">
                                    <option value="">请选择</option>
                                    <option value="男">男</option>
                                    <option value="女">女</option>
                                </select>
                            </div>
                        </div>
                        <div class="layui-inline"style="width: 150px">
                            <select name="channelId" lay-verify="">
                                <option value="">来源渠道</option>
                                <option value="1">学校网站</option>
                                <option value="2">自己找上门</option>
                                <option value="3">qq</option>
                                <option value="4">微信</option>
                                <option value="5">介绍</option>
                            </select>
                        </div>
                        <div class="layui-inline">
                            <a class="layui-btn  layui-btn-primary" data-type="reload">查询</a>
                        </div>
                        <div class="layui-btn-group" >
                            <button class="layui-btn data-add-btn"type="button">添加</button>
                        </div>
                    </form>

                </div>
            </div>

        </fieldset>



    </div>



</div>
<table class="layui-hide" id="test" lay-filter="test"></table>
<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="getCheckData">获取选中行数据</button>
        <button class="layui-btn layui-btn-sm" lay-event="getCheckLength">获取选中数目</button>
        <button class="layui-btn layui-btn-sm" lay-event="isAll">验证是否全选</button>
    </div>
</script>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>






</body>
</html>