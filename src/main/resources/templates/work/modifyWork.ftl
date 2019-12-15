<!DOCTYPE html>
<html lang="en">
<head>
    <title>老师修改作业页面</title>
    <#include "../common/common.ftl"/>

</head>
<body>

<form class="layui-form layui-form-pane" id="dataFor">
    <input style="display: none" name="id" value="${homework.id}"/>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">作业名称<span class="star">*</span></label>
            <div class="layui-input-inline">
                <input type="text" name="name" lay-verify="required" autocomplete="off" class="layui-input"
                       placeholder="请输入作业名称" value="${homework.name!''}">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">专业班级<span class="star">*</span></label>

            <div class="layui-input-inline">
                <div class="layui-inline">
                    <select name="majorId" lay-verify="required" id="gradeSelect"
                            url="/major/list/select" selectedId="${homework.majorId!''}">
                        <option value="">请选择</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">截止时间<span class="star">*</span></label>
            <div class="layui-input-inline">
                <input class="layui-input" lay-verify="required" name="endTime" id="endTime" type="text"
                       placeholder="请选择截止时间" value="${(homework.endTime?string)!''}">
            </div>
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">作业内容<span class="star">*</span></label>
        <div class="layui-input-block">
            <textarea name="content" class="layui-textarea" lay-verify="required"
            >${homework.content!''}</textarea>
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">备注</label>
        <div class="layui-input-block">
            <textarea name="remark" class="layui-textarea">${homework.remark!''}</textarea>
        </div>
    </div>
    <div class="layui-upload" id="up" style="text-align: center">
        <div style="text-align: left">
            <button class="layui-btn layui-btn-normal" id="testList" type="button">选择多文件</button>
            <button class="layui-btn layui-btn-warm" id="testListAction" type="button">开始上传</button>
        </div>
        <div class="layui-upload-list">
            <table class="layui-table">
                <thead>
                <tr>
                    <th>文件名</th>
                    <th>状态</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody id="demoList"></tbody>
            </table>
        </div>
    </div>
    <div style="margin-top: 10px;">
        <button lay-submit="" type="button" class="layui-btn" id="submit">提交
        </button>
    </div>
</form>
</body>
<script type="text/javascript" src="/work/js/modifyWork.js"></script>
<script>
    layui.use('layer', function(){
        var layer = layui.layer;
        $('#demoList').append("<tr id='old'><td>${attachment.name!""}</td><td>已上传</td><td><button class='layui-btn layui-btn-xs layui-btn-danger demo-delete' id='oldDeleteBtn'>删除</button></td></tr>");
        sel_garade();
        $('#oldDeleteBtn').click(function () {
            $.post("/attachment/delete",{
                linkId:'${attachment.id}'
            },function (result) {
                if(result.success==true){
                    $('#old').remove();
                }else{
                    layer.msg('系统异常,删除失败!');
                }
            });

        });

    });

</script>
</html>