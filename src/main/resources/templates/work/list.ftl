<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../layui/css/layui.css"/>
    <script type="text/javascript" src="../layui/layui.js"></script>
    <script type="text/javascript" src="../work/js/query.js"></script>
</head>
<body>
<div style="padding: 15px;">
    <div class="demoTable">
        <fieldset class="layui-elem-field layuimini-search">
            <legend>搜索信息</legend>
            <div style="margin: 10px 10px 10px 10px">
                <form class="layui-form layui-form-pane" action="">
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">关键字</label>
                            <div class="layui-input-inline">
                                <input type="text" name="username" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <select name="city" lay-verify="">
                                <option value="01">一年级</option>
                                <option value="02">二年级</option>
                                <option value="03">三年级</option>
                            </select>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">日期范围</label>
                            <div class="layui-input-inline">
                                <input class="layui-input" id="test6" type="text" placeholder=" - ">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <a class="layui-btn" lay-submit="" lay-filter="data-search-btn">搜索</a>
                        </div>
                    </div>
                </form>
            </div>
        </fieldset>

    </div>
    <table class="layui-hide" id="test" lay-filter="test"></table>
    <script id="barDemo" type="text/html">
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="edit">下载作业</a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="updata">修改评分</a>
    </script>
    <script id="toolbarDemo" type="text/html">
        <div class="layui-btn-container">
            <button class="layui-btn layui-btn-sm" lay-event="add">发布作业</button>
            <button class="layui-btn layui-btn-sm" lay-event="add">导出</button>
        </div>
    </script>
</div>
<div id="aa" style="display: none">
    <fieldset class="layui-elem-field layuimini-search">
        <legend>发布作业</legend>
        <div style="margin: 10px 10px 10px 10px">
            <form class="layui-form layui-form-pane" lay-filter="dataForm">
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">作业名称</label>
                        <div class="layui-input-inline">
                            <input type="text" name="workname" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">发布年级</label>
                        <div class="layui-inline"  style="width: 190px">
                            <select  lay-verify="" name="grade" id="grade">
                                <option value="一年级">一年级</option>
                                <option value="二年级">二年级</option>
                                <option value="三年级">三年级</option>
                            </select>
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">作业内容</label>
                        <div class="layui-input-inline">
                            <textarea name="content" required lay-verify="required" class="layui-textarea"></textarea>
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">发布日期</label>
                        <div class="layui-input-inline">
                            <input class="layui-input" name="date" id="test1" type="text" placeholder="yyyy-MM-dd">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">作业期限</label>
                        <div class="layui-input-inline">
                            <input class="layui-input" name="Validity" id="test2" type="text" placeholder="yyyy-MM-dd">
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </fieldset>
</div>
</body>
</html>