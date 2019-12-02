<!DOCTYPE html>
<html lang="en">
<head>
    <base href="${basePath}">
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/layui/css/layui.css"/>
    <script type="text/javascript" src="/layui/layui.js"></script>
    <script type="text/javascript" src="/all.js"></script>
    <script type="text/javascript" src="/work/js/list.js"></script>
</head>
<body>
<div >
    <div class="demoTable">
        <fieldset class="layui-elem-field layuimini-search">
            <div style="margin: 10px 10px 10px 10px">
                <form class="layui-form layui-form-pane" action="">
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">关键词</label>
                            <div class="layui-input-inline">
                                <input type="text" name="keywords" autocomplete="off" class="layui-input" placeholder="作业名称/作业内容">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">专业-班级</label>
                            <div class="layui-input-inline">
                                <div class="layui-inline">
                                    <select name="majorId" lay-verify="" id="gradeSelect" required
                                            lay-verify="required"
                                            url="/major/list/select" >
                                        <option value="">请选择</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">发布时间</label>
                            <div class="layui-input-inline">
                                <input class="layui-input" id="test6" type="text" placeholder="请选择时间范围" name="scopeTime">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <a class="layui-btn" lay-submit=""  lay-filter="data-search-btn"  data-type="reload">查询</a>
                            <button class="layui-btn layui-btn-normal" lay-submit="" lay-filter="data-search-btn" lay-event="add" id="add">
                                发布作业
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </fieldset>

    </div>
    <table class="layui-hide" id="test" lay-filter="test"></table>
    <script id="barDemo" type="text/html">
        <a class="layui-btn  layui-btn-xs" lay-event="modify">修改</a>
        <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="details">详情</a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="downloadWork">下载学生作业</a>
    </script>
</div>
</body>
<script>
   sel_garade();
</script>
</html>