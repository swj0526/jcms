<!DOCTYPE html>
<html lang="en">
<head>
    <base href="${basePath}">
    <meta charset="UTF-8">
    <title>Title</title>
    <#include "../common/common.ftl"/>

</head>
<body>

<div style="padding: 20px; background-color: #F2F2F2;">
    <div class="layui-row layui-col-space15">
        <#list studentWork as st>
            <div class="layui-col-md5">
                <div class="layui-card">
                    <div class="layui-card-header">姓名:${st.name!""}</div>
                    <div class="layui-card-body" style="padding-left: 0px;padding-bottom: 5px">
                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <label class="layui-form-label" style="padding-left: 0px">提交时间</label>
                                <div class="layui-input-inline">
                                    <input style="border: 0" class="layui-input" name="date" id="test1" type="text"
                                           disabled
                                           value="${st.createTime!""}">
                                </div>
                            </div>
                            <div class="layui-inline">
                                <label class="layui-form-label" style="padding-left: 0px">分数</label>
                                <div class="layui-input-inline">
                                    <input style="border: 0" class="layui-input" name="date" id="test1" type="text"
                                           disabled
                                           value="${st.score!""}">
                                </div>
                            </div>
                        </div>
                        <div class="layui-form-item" style="margin-bottom: 0px">
                            <div class="layui-inline">
                                <label class="layui-form-label" style="padding-left: 0px">学生班级</label>
                                <div class="layui-input-inline">
                                    <input style="border: 0" class="layui-input" name="date" id="test1" type="text"
                                           disabled
                                           value="${st.major!""}">
                                </div>
                            </div>
                            <div class="layui-inline">
                                <label class="layui-form-label" style="padding-left: 0px">操作</label>
                                <div class="layui-input-inline">
                                    <button type="button" class="layui-btn score" name="${st.studentId!""}" id="${st.id!""}">评分</button>
                                    <button type="button" class="layui-btn estimateContent" name="${st.studentId!""}" id="${st.id!""}" style="margin-left: 55px">评价
                                    </button>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
                <div class="layui-card">
                    <div class="layui-card-header">评价内容</div>
                    <div class="layui-card-body">
                        <textarea name="desc" id="Content${st.studentId!""}" placeholder="请输入内容" class="layui-textarea">${st.estimateContent!""}</textarea>
                    </div>
                </div>
            </div>
            <div class="layui-col-md7">
                <div class="layui-card">
                    <div class="layui-card-header">备注</div>
                    <div class="layui-card-body">
                        ${st.content!""}
                    </div>
                </div>
            </div>
            <div class="layui-col-md12">
                <div class="layui-card">
                    <div class="layui-card-header">作业文件</div>
                    <div class="layui-card-body">
                        <div class="layui-form-item">

                            <#list st.list as work>
                                <div class="layui-inline" style="width: 100px;height: 120px;text-align: center">
                                    <img src="/work/img/1.png" style="width: 100px;height: 100px">
                                    <button style="margin-top: 5px" type="button" class="layui-btn" id="${work.id!""}">下载</button>
                                </div>
                            </#list>
                        </div>
                    </div>
                </div>
            </div>
        </#list>
    </div>
</div>
</body>
<div style="display:none" id="score">
    <div class="layui-form-item" style="margin-top: 20px">
        <div class="layui-inline">
            <label class="layui-form-label" style="text-align: center;width: 60px;padding-right: 0px">分数:</label>
            <div class="layui-input-inline">
                <input type="text" id="studentScore"  autocomplete="off" class="layui-input"
                       placeholder="分数">
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="/work/js/workDown.js"></script>
</html>