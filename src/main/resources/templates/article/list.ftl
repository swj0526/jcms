<!DOCTYPE html>
<html>
<head>
    <base href="${basePath}">
    <meta charset="utf-8">
    <title>文章查询</title>
    <link rel="stylesheet" type="text/css" href="../layui/css/layui.css">
    <script type="text/javascript" src="../jquery/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="../layui/layui.js"></script>
    <script type="text/javascript" src="../article/js/list.js"></script>
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
                            <input name="phone" class="layui-input" type="tel" autocomplete="off"
                                   lay-verify="required|phone">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label" style="width:60px">类型</label>
                        <div class="layui-inline">
                            <select name="hasQuit" lay-verify="" id="queryHasQuit">
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
                            <select name="hasQuit" lay-verify="" id="queryHasQuit">
                                <option value="">所有类型</option>
                                <option value="文章">草稿</option>
                                <option value="已撤销">已撤销</option>
                                <option value="已提交">已提交</option>
                            </select>
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">日期范围</label>
                        <div class="layui-input-inline">
                            <input class="layui-input" id="test6" type="text" placeholder=" - ">
                        </div>
                    </div>
                    <button class="layui-btn" data-type="reload">查询</button>
                    <button class="layui-btn layui-btn-normal" lay-submit lay-filter="formDemo" id="excel">导出</button>
                </div>
            </form>
        </div>
    </fieldset>
</div>
<#--数据表格-->
<table class="layui-hide" id="test" lay-filter="test"></table>
<#--文章详情-->
<div style="display: none" id="updateOrDelete">
    <h1 align="center">标题</h1>
    <hr />
    <div align="center"><span>作者：</span><span>长路漫漫</span>&nbsp;&nbsp;<span>发布时间:</span><span>2019-11-20</span>&nbsp;<span>12:00</span></div>
    <div align="center" style="margin: 10px;">
        <p>我这个人走得很慢，但是我从不后退。</p>
        <p>等待的方法有两种：一种是什么事也不做的空等；一种是一边等一边把事业向前推动。</p>
        <p>当幻想和现实面对面时，总是很痛苦的。要么你被痛苦击倒，要么你把痛苦踩在脚下。</p>
        <p>如果你希望成功，当以恒心为良友，以经验为参谋，以当心为兄弟，以希望为哨兵。</p>
        <p>当我以为我无法继续走下去时，我强迫自己要继续前进。我的成功是基于我的坚持，并非运气。</p>
        <p>若是自己没有尽力，就没有资格批评别人不用心。开口抱怨很容易，但是闭嘴努力的人更加值得尊敬。</p>
        <br />
    </div>
</div>
<script id="barDemo" type="text/html">
    <a class="layui-btn layui-btn-xs layui-btn-normal" lay-event="edit">查看详细</a>
</script>
</body>
</html>
