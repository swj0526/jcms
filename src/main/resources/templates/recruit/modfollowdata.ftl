<!DOCTYPE html>
<html lang="en">
<head>

    <base href="${basePath}">
    <meta charset="UTF-8">
    <#include "../common/common.ftl"/>
    <title>修改详情</title>
</head>
<body>
<div id="modfollow">
    <form class="layui-form" action="" id="formdata"lay-filter="dataForm">
        <div class="layui-form-item">
            <label class="layui-form-label">跟进时间</label>
            <div class="layui-input-inline">
                <input type="text" name="followTime" required lay-verify="required" placeholder="请输入"
                       autocomplete="off" class="layui-input" id="date" value="${(detail.followTime?string('yyyy-MM-dd'))!''}">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">意向</label>
            <div class="layui-inline" style="width: 190px">
                <div id="modifydiv" class="xm-select-demo" style=" width:500px";></div>
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">备注:</label>
            <div class="layui-input-block">
                <textarea name="remark" placeholder="请输入内容"required lay-verify="required" class="layui-textarea"style=" width:500px";>${detail.remark!''}</textarea>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" type="button" lay-submit lay-filter="formDemo" id="submitbtn"
                        value=${detail.id!''}>立即提交
                </button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>

<script src="/recruit/js/label.js"></script>
<script src="/recruit/js/xm.js" type="text/javascript"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script>

    var modifydiv = xmSelect.render({
        el: '#modifydiv',
        language: 'zn',
        filterable: true,
        searchTips: '搜索标签',
        tips: '选择意向',
        height: '500px',
        autoRow: true,
        code:0,
        prop: {
            name: 'name',
            value: 'id',
        },

    })
    axios({
        method: 'get',
        url: '/dictionary/list/label',
    }).then(response => {
        var res = response.data;
        modifydiv.update({
            data: res,
        })
    });
    //赋值

</script>
</body>
</html>