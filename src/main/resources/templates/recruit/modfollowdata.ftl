<!DOCTYPE html>
<html lang="en">
<head>

    <base href="${basePath}">
    <meta charset="UTF-8">
    <#include "../common/common.ftl"/>
    <title>修改详情</title>
</head>
<body onload="mayfun()" >
<div>
    <form class="layui-form" action="" id="modifyForm"lay-filter="modifyForm" ;>
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
                <div id="modDetail" class="xm-select-demo" style=" width:350px";></div>
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">备注:</label>
            <div class="layui-input-block"style=" width:350px";>
                <textarea name="remark" placeholder="请输入内容"required lay-verify="required" class="layui-textarea">${detail.remark!''}</textarea>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" type="button" lay-submit lay-filter="modifySubmit" id="modifySubmit"
                        value=${detail.id!''}>立即提交
                </button>

            </div>
        </div>
    </form>
</div>

<script src="/recruit/js/label.js"></script>
<script src="/recruit/js/xm.js" type="text/javascript"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>

<script>
    var modDetail = xmSelect.render({
        el: '#modDetail',
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
        modDetail.update({
            data: res,
        })
    });
    //赋值
    function mayfun(){
        modDetail.setValue([${detail.labelIds}])
    };
</script>
<script src="/recruit/js/detailfollow.js"></script>
</body>
</html>