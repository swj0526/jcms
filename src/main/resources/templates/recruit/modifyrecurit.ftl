<!DOCTYPE html>
<html lang="en">
<head>
    <base href="${basePath}">
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <#--上传-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <#include "../common/common.ftl"/>
    <link rel="stylesheet" href="/layui/css/public.css" media="all">
    <link rel="stylesheet" href="/recruit/css/label.css">
    <style type="text/css">
        input::-webkit-outer-spin-button,
        input::-webkit-inner-spin-button {
            -webkit-appearance: none;
        }
        input[type="number"]{
            -moz-appearance: textfield;
        }

    </style>

</head>
<body onload="mayfun()">

<#--修改信息弹出框-->
<div style="margin-left: 20%;margin-top: 5%;" id="recruit">
    <form class="layui-form"  lay-filter="dataForm" id="modifyFor" method="post">
        <div class="layui-input-inline"style="display: none">
            <input type="text" name="id"  lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-inline">
                <input type="text" name="name"  lay-verify="required" placeholder="" autocomplete="off" class="layui-input" value=${student.name}>
            </div>
<#--存放性别-->
            <input type="text" style="display: none" id="Instalment" value=${student.sex}>
            <label class="layui-form-label">性别</label>
            <div class="layui-inline">
                <div class="layui-inline" style="width: 190px">
                    <select name="sex" lay-verify="" id="select1">
                        <option value="男">男</option>
                        <option value="女">女</option>
                    </select>
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">出生年月</label>
                <div class="layui-input-inline">
                    <input type="text" name="birthDate" id="date" lay-verify="date"  autocomplete="off" class="layui-input" value=${(student.birthDate?string("yyyy-MM-dd"))!'无数据'}>
                </div>
            </div>

            <label class="layui-form-label">毕业院校</label>
            <div class="layui-input-inline">
                <input type="text" name="school" required  lay-verify="required" placeholder="" autocomplete="off" class="layui-input" value=${student.school}>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">手机号</label>
            <div class="layui-input-inline">
                <input type="number" name="studentPhone" required  lay-verify="required" placeholder="" autocomplete="off" class="layui-input"value=${student.studentPhone}>
            </div>
            <label class="layui-form-label">QQ号</label>
            <div class="layui-input-inline">
                <input type="number" name="qq" required  lay-verify="required" placeholder="" autocomplete="off" class="layui-input" value=${student.qq}>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">微信号</label>
            <div class="layui-input-inline">
                <input type="number" name="weChat" value=${student.weChat} required  lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
            </div>
            <label class="layui-form-label">母亲电话</label>
            <div class="layui-input-inline">
                <input type="number" name="motherPhone" value=${student.motherPhone} required  lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
            </div>

        </div>
        <div class="layui-form-item">

            <label class="layui-form-label">父亲电话</label>
            <div class="layui-input-inline">
                <input type="number" name="fatherPhone" value=${student.fatherPhone} required  lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
            </div>
            <label class="layui-form-label">来源渠道</label>
            <div class="layui-input-inline">
                <div class="layui-inline" style="width: 190px">
                    <select name="channelId" lay-verify="" class="decSelect" required lay-verify="required"
                            url="/dictionary/list/channel/options" selectedId="${student.channelId}">

                    </select>

                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <input type="text" style="display: none" id="entranceName" value=${student.etranceState!""}>
            <label class="layui-form-label">是否试学</label>
            <div class="layui-inline">
                <div class="layui-inline" style="width: 190px">
                    <select name="entranceState" lay-verify="" id="entranceState">
                        <#if student.entranceState==4>
                            <option value="4">是</option>
                            <option value="0">否</option>
                            <#else >
                                <option value="0">否</option>
                                <option value="4">是</option>
                        </#if>

                    </select>
                </div>
            </div>

        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">意向</label>
                <div class="layui-inline">
                    <div id="modifydiv" class="xm-select-demo"; style=" width:510px"></div>
                </div>
            </div>


        </div>

    </form>
    <div class="layui-form-item"style="margin-left: 20%">
        <div class="layui-input-inline">
            <button class="layui-btn" type="button" lay-submit id="modifySubmit" value="${student.id}">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</div>


<script src="/recruit/js/label.js"></script>
<script src="/recruit/js/xm.js"></script>
<script src="/recruit/js/axios.js"></script>

<script src="/recruit/js/recruit.js"></script>
<script src="/recruit/js/detailfollow.js"></script>

<script>
    sel();
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
    function mayfun(){
        modifydiv.setValue([${student.labelIds}])
    };

</script>
</body>
</html>