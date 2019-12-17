<!DOCTYPE html>
<html lang="en">
<head>
    <base href="${basePath}">
    <meta charset="UTF-8">
    <title>Title</title>
    <#include "../common/common.ftl"/>
</head>
<body>
<div>
    <fieldset class="layui-elem-field layuimini-search">
        <div style="margin: 10px 10px 10px 10px">
            <form class="layui-form layui-form-pane" style="margin-left: 15%;margin-top: 8%" id="addForm"
                  lay-filter="dataForm">
                <div class="layui-form-item">
                    <div class="layui-inline" style="width: 359px">
                        <label class="layui-form-label">事由<span class="star">*</span></label>
                        <div class="layui-inline " style="width: 115px;margin-right: 0px;margin-bottom: 0px;">
                            <select lay-filter="reason" name="reasonId" lay-verify="required" class="decSelect"
                                    url="/integralitem/list" selectedId="" id="reasonSelect">
                                <option value="">请选择</option>

                            </select>
                        </div>
                        <button type="button" class="layui-btn" id="reasonSetting"
                                style="padding-left: 10px;padding-right: 10px;width: 70px;">设置
                        </button>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">学生姓名<span class="star">*</span></label>
                        <div class="layui-inline">
                            <select  name="studentId" lay-verify="" class="decSelect" lay-search url="/student/liststudentinteger">
                                <option value="">请输入</option>
                            </select>
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
                            <input type="text" name="recordTime" id="recordTime" autocomplete="off" class="layui-input">
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
                    <button type="button" class="layui-btn" lay-submit id="submitBtn"
                            style="padding-left: 10px;padding-right: 10px;width: 70px;">提交
                    </button>
                    <button type="button" class="layui-btn layui-btn-primary" id="revocationBtn"
                            style="padding-left: 10px;padding-right: 10px;width: 70px;">取消
                    </button>
                </div>
            </form>
        </div>
    </fieldset>
</div>
</body>
<script src="/integral/js/addPage.js"></script>
<script>
    sel();
    $('.wx-input').attr('data-value');
</script>
</html>