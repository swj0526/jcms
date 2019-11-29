<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="/all.css" media="all">
    <script src="/layui/layui.js"></script>
    <script src="/integral/js/subtractPage.js"></script>
</head>
<body>
<div id="aa">
    <fieldset class="layui-elem-field layuimini-search">
        <div style="margin: 10px 10px 10px 10px">
            <form class="layui-form layui-form-pane" lay-filter="dataForm">
                <div class="layui-form-item">
                    <div class="layui-inline" style="width: 359px">
                        <label class="layui-form-label">事由<span class="star">*</span></label>
                        <div class="layui-inline " style="width: 115px;margin-right: 0px;margin-bottom: 0px;">
                            <select name="semesterId" lay-verify="required" class="decSelect"
                                    url="/dictionary/list/payTerm/options" selectedId="">
                                <option value="">请选择</option>

                            </select>
                        </div>
                        <button type="button" class="layui-btn" id="type3"
                                style="padding-left: 10px;padding-right: 10px;width: 70px;">设置
                        </button>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">学生姓名<span class="star">*</span></label>
                        <div class="layui-input-inline">
                            <input type="text" name="username" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-inline" style="width: 359px">
                        <label class="layui-form-label">分数<span class="star">*</span></label>
                        <div class="layui-input-inline">
                            <input type="text" name="username" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">学号<span class="star">*</span></label>
                        <div class="layui-input-inline">
                            <input type="text" name="username" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </fieldset>
</div>
</body>
</html>