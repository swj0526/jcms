<!DOCTYPE html>
<html lang="en">
<head>
    <#include "../common/common.ftl"/>

</head>
<body>
<div>
    <div class="demoTable">
        <fieldset class="layui-elem-field" style="padding: 5px;">

            <form class="layui-form layui-form-pane">
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">关键词</label>
                        <div class="layui-input-inline">
                            <input type="text" name="keywords" autocomplete="off" class="layui-input"
                                   placeholder="作业名称/作业内容">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">专业-班级</label>
                        <div class="layui-input-inline">
                            <div class="layui-inline">
                                <select name="majorId" id="gradeSelect"
                                        url="/major/list/select">
                                    <option value="">请选择</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">发布时间</label>
                        <div class="layui-input-inline">
                            <input class="layui-input" id="scopeTime" type="text" placeholder="请选择时间范围"
                                   name="scopeTime">
                        </div>
                    </div>
                    <button class="layui-btn" type="button"data-type="reload" id="search">查询</button>

                </div>
            </form>
        </fieldset>

    </div>
    <table class="layui-hide" id="workTable" lay-filter="workTable"  lay-size="sm"></table>
    <script id="barDemo" type="text/html">
        <a class="layui-btn  layui-btn-xs" lay-event="modify">修改</a>
        <a class="layui-btn  layui-btn-xs layui-btn-warm" lay-event="delete">删除</a>
        <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="details">详情</a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="downloadWork">下载学生作业</a>
    </script>
</div>
</body>
<script type="text/javascript" src="/work/js/list.js"></script>
<script>
    sel_garade();
</script>
</html>