<!DOCTYPE html>
<html lang="en">
<head>
    <title>作业详情页面</title>
    <#include "../common/common.ftl"/>

</head>
<body>

<form class="layui-form  layui-form-pane" id="dataFor">
    <input style="display: none" name="id" value="${homework.id}"/>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">作业名称</label>
            <div class="layui-input-inline">
                <input type="text" name="name" lay-verify="required" autocomplete="off" class="layui-input"
                       placeholder="请输入作业名称" value="${homework.name!''}" disabled="disabled">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">专业班级</label>

            <div class="layui-input-inline">
                <div class="layui-inline">
                    <select name="majorId" lay-verify="required" id="gradeSelect"
                            url="/major/list/select" selectedId="${homework.majorId!''}" disabled="disabled">
                        <option value="">请选择</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">截止时间</label>
            <div class="layui-input-inline">
                <input class="layui-input" lay-verify="required" name="endTime" id="endTime" type="text"
                       placeholder="请选择截止时间" value="${(homework.endTime?string)!''}" disabled="disabled">
            </div>
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">作业内容</label>
        <div class="layui-input-block">
            <textarea name="content" class="layui-textarea" lay-verify="required" disabled="disabled"
            >${homework.content!''}</textarea>
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">备注</label>
        <div class="layui-input-block">
            <textarea name="remark" class="layui-textarea" disabled="disabled">${homework.remark!''}</textarea>
        </div>
    </div>
    <div class="layui-upload" id="up" style="text-align: center">
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
</form>
</body>
<script type="text/javascript" src="/work/js/detailsWork.js"></script>
<script>
    layui.use('layer', function () {
        sel_garade();
        <#if attachment??>
        $('#demoList').append("<tr id='old'><td>${attachment.name!""}</td><td>已上传</td><td><button class='layui-btn layui-btn-xs layui-btn-danger demo-delete' ><a hf='${attachment.url!""}'>下载</a></button></td></tr>");
        <#else >

        </#if>


    });

</script>
</html>