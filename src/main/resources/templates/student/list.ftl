<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="/layui/css/public.css" media="all">
    <script src="/layui/layui.js"></script>
    <script src="/student/js/list.js"></script>
</head>
<body>

<div id="aaa" style="display: none">
    <fieldset class="layui-elem-field layuimini-search">
        <legend>添加信息</legend>
        <div style="margin: 10px 10px 10px 10px">
            <form class="layui-form layui-form-pane" lay-filter="dataForm">
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">学生学号</label>
                        <div class="layui-input-inline">
                            <input type="text" name="id" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">学生姓名</label>
                        <div class="layui-input-inline">
                            <input type="text" name="name" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">性别</label>
                        <div class="layui-input-inline">
                            <input type="text" name="gender" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">出生年月</label>
                        <div class="layui-input-inline">
                            <input type="text" name="birthday" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">年龄</label>
                        <div class="layui-input-inline">
                            <input type="text" name="age" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">家庭住址</label>
                        <div class="layui-input-inline">
                            <input type="text" name="address" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">籍贯</label>
                        <div class="layui-input-inline">
                            <input type="text" name="nativePlace" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">联系方式</label>
                        <div class="layui-input-inline">
                            <input type="text" name="contact" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">在校状态</label>
                        <div class="layui-input-inline">
                            <input type="text" name="state" autocomplete="off" class="layui-input">
                        </div>
                    </div>

                </div>
            </form>
        </div>
    </fieldset>
</div>

<div class="layuimini-container">
    <div class="layuimini-main">

        <fieldset class="layui-elem-field layuimini-search">
            <legend>搜索信息</legend>
            <div style="margin: 10px 10px 10px 10px">
                <form class="layui-form layui-form-pane" action="">
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">关键词</label>
                            <div class="layui-input-inline">
                                <input type="text" name="username" autocomplete="off" class="layui-input"
                                       placeholder="例：1990/张三">
                            </div>
                        </div>

                        <div class="layui-inline">
                            <label class="layui-form-label">入学时间</label>
                            <div class="layui-input-inline">
                                <input type="text" name="city" autocomplete="off" class="layui-input" id="time">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <a class="layui-btn" lay-submit="" lay-filter="data-search-btn">查询</a>
                        </div>
                        <div class="layui-btn-group">
                            <button type="button" class="layui-btn">添加</button>
                            <button type="button" class="layui-btn ">导入</button>
                            <button type="button" class="layui-btn">导出</button>
                        </div>
                    </div>
                </form>
            </div>
        </fieldset>


        <table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter"></table>
        <script type="text/html" id="currentTableBar">
            <a class="layui-btn layui-btn-xs data-count-edit" lay-event="edit">修改</a>
            <a class="layui-btn layui-btn-xs layui-btn-danger data-count-delete" lay-event="delete">删除</a>
        </script>
    </div>
</div>


</body>
</html>
