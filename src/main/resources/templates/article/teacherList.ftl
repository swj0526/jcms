<!DOCTYPE html>
<html lang="en">
<head>
    <base href="${basePath}">
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../layui/css/layui.css">
    <script type="text/javascript" src="../jquery/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="../layui/layui.js"></script>
    <script type="text/javascript" src="/article/js/teacherList.js"></script>
</head>
<body>
<#--查询-->
<div class="layui-form-item">
    <fieldset class="layui-elem-field layuimini-search">
        <legend>查询发布文章</legend>
        <div style="margin: 10px 10px 10px 10px">
            <form class="layui-form layui-form-pane" action="">
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label" style="width:80px">关键词</label>
                        <div class="layui-input-inline">
                            <input name="keyword" class="layui-input" type="tel" autocomplete="off"
                                   placeholder="标题/角色" id="keyword">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label" style="width:60px">类型</label>
                        <div class="layui-inline">
                            <select name="typeId" lay-verify="" id="typeId">
                                <option value="">所有类型</option>
                                <option value="文章">文章</option>
                                <option value="通知">通知</option>
                                <option value="公告">公告</option>
                                <option value="活动">活动</option>
                            </select>
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label" style="width:60px">状态</label>
                        <div class="layui-inline">
                            <select name="state" lay-verify="" id="state">
                                <option value="">所有类型</option>
                                <option value="1">草稿</option>
                                <option value="2">已撤销</option>
                                <option value="3">已提交</option>
                            </select>
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">日期范围</label>
                        <div class="layui-input-inline">
                            <input class="layui-input" id="time" type="text" placeholder=" - ">
                        </div>
                    </div>
                    <button class="layui-btn data-add-btn" type="button" id="query">查询</button>
                    <button class="layui-btn layui-btn-normal" lay-submit lay-filter="formDemo" id="excel">导出</button>
                </div>
            </form>
        </div>
    </fieldset>
</div>
<#--数据表格-->
<table class="layui-hide" id="test" lay-filter="test"></table>

<div id="aaa" style="display: none">
    <div class="layui-inline">
        <fieldset class="layui-elem-field layuimini-search" style="width: 450px; height: 430px;">
            <legend>已读</legend>
            <div style="margin: 10px 10px 10px 10px">
                <p>张三，王五，李四</p>
            </div>
        </fieldset>
    </div>
    <div class="layui-inline" style="float:right">
        <fieldset class="layui-elem-field layuimini-search" style="width: 450px; height: 430px;">
            <legend>未读</legend>
            <div style="margin: 10px 10px 10px 10px">
                <p>张三，王五，李四</p>

            </div>
        </fieldset>
    </div>
</div>
<script id="barDemo" type="text/html">
    {{# if(d.state=="1"){ }}
    <a class="layui-btn layui-btn-xs layui-btn-warm" lay-event="edit">重新提交</a>
    <a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="del">删除</a>
    {{# } }}
    {{# if(d.state=="2"){ }}
    <a class="layui-btn layui-btn-xs layui-btn-warm" lay-event="edit">重新提交</a>
    <a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="del">删除</a>
    {{# } }}
    {{# if(d.state=="3"){ }}
    <a class="layui-btn layui-btn-xs layui-btn-normal" lay-event="again">查看详细</a>
    <a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="revoke">撤销</a>
    {{# } }}
</script>
<script type="text/html" id="sexTpl">
    <span style="color: #F581B1;">{{ d.readCount }}</span>
</script>
</body>
</html>