<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <#--上传-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="/layui/css/public.css" media="all">
    <link rel="stylesheet" href="/recruit/css/label.css">
    <#--上传-->

    <script src="/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="/all.js"></script>
    <script src="/jquery/jquery-3.3.1.min.js"></script>
    <script src="/recruit/js/label.js"></script>
    <script src="/recruit/js/xm.js"></script>

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
<body>
<div style="text-align: center; line-height: 20px; padding-top: 10px; display: none" id="error"><span >姓名,意向,电话必须填写</span></div>
<#--新增信息弹出框-->
<div style="margin-left: 20%;margin-top: 5%;" id="recruit">
    <form class="layui-form"  lay-filter="addDataForm" id="dataFor" method="post">
        <div class="layui-input-inline"style="display: none">
            <input type="text" name="id"  lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-inline">
                <input type="text" name="name"  lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
            </div>

            <label class="layui-form-label">性别</label>
            <div class="layui-inline">
                <div class="layui-inline" style="width: 190px">
                    <select name="sex" lay-verify="">
                        <option value=""></option>
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
                    <input type="text" name="birthDate" id="date" lay-verify="date"  autocomplete="off" class="layui-input">
                </div>
            </div>

            <label class="layui-form-label">学校</label>
            <div class="layui-input-inline">
                <input type="text" name="school" required  lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">手机号</label>
            <div class="layui-input-inline">
                <input type="number" name="studentPhone" required  lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
            </div>
            <label class="layui-form-label">QQ号</label>
            <div class="layui-input-inline">
                <input type="number" name="qq" required  lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">微信号</label>
            <div class="layui-input-inline">
                <input type="number" name="weChat" required  lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
            </div>
            <label class="layui-form-label">母亲电话</label>
            <div class="layui-input-inline">
                <input type="number" name="motherPhone" required  lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
            </div>

        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">父亲电话</label>
            <div class="layui-input-inline">
                <input type="number" name="fatherPhone" required  lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
            </div>
            <label class="layui-form-label">来源渠道</label>
            <div class="layui-input-inline" >
                <div class="layui-inline"style="width: 190px">
                    <select name="channelId" lay-verify=""id="decSelect" type=2 url="/dictionary/list/channel">
                        <option value="">来源渠道</option>
                        <#--<option value="010">学校网站</option>
                        <option value="011">自己找上门</option>
                        <option value="012">qq</option>
                        <option value="013">微信</option>
                        <option value="014">介绍</option>-->
                    </select>
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">意向</label>
                <div class="layui-inline">
                    <div id="demo1" class="xm-select-demo" style=" width:190px";></div>
                </div>
            </div>
            <div class="layui-inline">
                <div class="layui-inline" style="width:50px">
                    <button class="layui-btn layui-btn-xs layui-btn-normal" id="">添加意向</button>
                </div>
            </div>
        </div>

    </form>
    <div class="layui-form-item"style="margin-left: 20%">
        <div class="layui-input-inline">
            <button class="layui-btn" type="button" lay-submit id="addSubmit">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</div>

<script src="/recruit/js/recruit.js"></script>

<script>
   /* sel();*/
    var demo1 = xmSelect.render({
        el: '#demo1',
        language: 'zn',
        filterable: true,
        searchTips: '搜索标签',
        tips: '选择意向',

        data: [
            {name: '有意向', value: 1},
            {name: '还在考虑', value: 2},
            {name: '完全不考虑', value: 3},
            {name: '不太明确', value: 4},
            {name: '完全没有', value: 5},
        ]
    })
    /*document.getElementById('demo1-getValue').onclick = function(){
       //获取当前多选选中的值
       var selectArr = demo1.getValue();
       document.getElementById('demo1-value').innerHTML = JSON.stringify(selectArr, null, 2);
   }*/
</script>
<script src="/recruit/js/updata.js"></script>
</body>
</html>