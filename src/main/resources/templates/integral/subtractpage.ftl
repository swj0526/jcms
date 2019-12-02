<!DOCTYPE html>
<html lang="en">
<head>
    <base href="${basePath}">
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="/all.css" media="all">
    <script src="/layui/layui.js"></script>
    <script src="/all.js"></script>
    <script src="/integral/js/subtractPage.js"></script>
</head>
<body>
<div id="aa" >
    <fieldset class="layui-elem-field layuimini-search">
        <div style="margin: 10px 10px 10px 10px">
            <form class="layui-form layui-form-pane" style="margin-left: 15%;margin-top: 8%" lay-filter="dataForm">
                <div class="layui-form-item">
                    <div class="layui-inline" style="width: 359px">
                        <label class="layui-form-label">事由<span class="star">*</span></label>
                        <div class="layui-inline " style="width: 115px;margin-right: 0px;margin-bottom: 0px;">
                            <select name="semesterId" lay-verify="required" class="decSelect"
                                    url="/integral/item/list" selectedId="">
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
                            <input type="text" name="score" id="score" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">事发时间<span class="star">*</span></label>
                        <div class="layui-input-inline">
                            <input type="text" name="username" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                </div>
                <div class="layui-form-item" style="width: 670px">
                    <div class="layui-form-item layui-form-text">
                        <label class="layui-form-label">备注</label>
                        <div class="layui-input-block">
                            <textarea name="remark" placeholder="请输入内容" class="layui-textarea"></textarea>
                        </div>
                    </div>
                </div>
                <div style="text-align: center;width: 650px">
                    <button type="button" class="layui-btn" lay-submit id="submit"
                            style="padding-left: 10px;padding-right: 10px;width: 70px;">提交
                    </button>
                    <button type="button" class="layui-btn layui-btn-primary"id="revocation"
                            style="padding-left: 10px;padding-right: 10px;width: 70px;">取消
                    </button>
                </div>
            </form>
        </div>
    </fieldset>
</div>
</body>
</html>