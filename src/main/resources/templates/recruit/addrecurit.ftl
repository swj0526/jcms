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

        input[type="number"] {
            -moz-appearance: textfield;
        }
    </style>
</head>
<body>
<div style="text-align: center; line-height: 20px; padding-top: 10px; display: none" id="error">
    <span>姓名,意向,电话必须填写</span></div>

<div id="recruit">
    <form class="layui-form" lay-filter="addDataForm" id="dataFor" method="post">
        <div class="layui-form-item" style="width: 1000px;">
            <div style="display: inline-block"><span
                        style="color: red;display: inline-block;height: 38px;line-height: 38px;">*</span>
                <label class="layui-form-label"> 姓名</label>
                <div class="layui-input-inline">
                    <input type="text" name="name" lay-verify="required" placeholder="" autocomplete="off"
                           class="layui-input">
                </div>
            </div>

            <div style="display: inline-block">
                <label class="layui-form-label">性别</label>
                <div class="layui-inline" style="width: 190px;">
                    <select name="sex" lay-verify="">
                        <option value=""></option>
                        <option value="男">男</option>
                        <option value="女">女</option>
                    </select>
                </div>
                <span style="color: red;display: inline-block;height: 38px;line-height: 38px;">*</span>
            </div>

        </div>
        <div class="layui-form-item" style="width: 1000px;">
            <div style="display: inline-block"><span
                        style="color: red;display: inline-block;height: 38px;line-height: 38px;">*</span>
                <label class="layui-form-label"> 出生年月</label>
                <div class="layui-input-inline">
                    <input type="text" name="birthDate" lay-verify="required" placeholder="" autocomplete="off"
                           class="layui-input">
                </div>
            </div>

            <div style="display: inline-block"><span
                        style="color: red;display: inline-block;height: 38px;line-height: 38px;">*</span>
                <label class="layui-form-label"> 毕业院校</label>
                <div class="layui-input-inline">
                    <input type="text" name="school" lay-verify="required" placeholder="" autocomplete="off"
                           class="layui-input">
                </div>
            </div>

        </div>
        <div class="layui-form-item" style="width: 1000px;">
            <div style="display: inline-block"><span
                        style="color: red;display: inline-block;height: 38px;line-height: 38px;">*</span>
                <label class="layui-form-label"> 手机号码</label>
                <div class="layui-input-inline">
                    <input type="text" name="studentPhone" lay-verify="required" placeholder="" autocomplete="off"
                           class="layui-input">
                </div>
            </div>

            <div style="display: inline-block"><span
                        style="color: red;display: inline-block;height: 38px;line-height: 38px;">*</span>
                <label class="layui-form-label">QQ</label>
                <div class="layui-input-inline">
                    <input type="text" name="qq" lay-verify="required" placeholder="" autocomplete="off"
                           class="layui-input">
                </div>
            </div>

        </div>
        <div class="layui-form-item" style="width: 1000px;">
            <div style="display: inline-block"><span
                        style="color: red;display: inline-block;height: 38px;line-height: 38px;">*</span>
                <label class="layui-form-label"> 微信</label>
                <div class="layui-input-inline">
                    <input type="text" name="weChat" lay-verify="required" placeholder="" autocomplete="off"
                           class="layui-input">
                </div>
            </div>
            <div style="display: inline-block">
                <span
                        style="color: red;display: inline-block;height: 38px;line-height: 38px;">*</span>
                <label class="layui-form-label">来源渠道</label>

                <div class="layui-input-inline">
                    <div class="layui-inline" style="width: 190px">
                        <select name="channelId" lay-verify="" id="decSelect" required lay-verify="required"
                                url="/dictionary/list/channel/options">
                            <option value="">来源渠道</option>
                        </select>
                    </div>
                </div>
            </div>


        </div>
        <div class="layui-form-item" style="width: 1000px;">
            <div style="display: inline-block"><span
                        style="color: red;display: inline-block;height: 38px;line-height: 38px;">*</span>
                <label class="layui-form-label"> 母亲姓名</label>
                <div class="layui-input-inline">
                    <input type="text" name="motherName" lay-verify="required" placeholder="" autocomplete="off"
                           class="layui-input">
                </div>
            </div>

            <div style="display: inline-block"><span
                        style="color: red;display: inline-block;height: 38px;line-height: 38px;">*</span>
                <label class="layui-form-label"> 联系方式</label>
                <div class="layui-input-inline">
                    <input type="text" name="motherPhone" lay-verify="required" placeholder="" autocomplete="off"
                           class="layui-input">
                </div>
            </div>

        </div>
        <div class="layui-form-item" style="width: 1000px;">
            <div style="display: inline-block"><span
                        style="color: red;display: inline-block;height: 38px;line-height: 38px;">*</span>
                <label class="layui-form-label"> 父亲姓名</label>
                <div class="layui-input-inline">
                    <input type="text" name="fatherName" lay-verify="required" placeholder="" autocomplete="off"
                           class="layui-input">
                </div>
            </div>

            <div style="display: inline-block"><span
                        style="color: red;display: inline-block;height: 38px;line-height: 38px;">*</span>
                <label class="layui-form-label"> 联系方式</label>
                <div class="layui-input-inline">
                    <input type="text" name="fatherPhone" lay-verify="required" placeholder="" autocomplete="off"
                           class="layui-input">
                </div>
            </div>

        </div>
        <div class="layui-form-item" style="width: 1000px;">
            <div style="display: inline-block"><span
                        style="color: red;display: inline-block;height: 38px;line-height: 38px;">*</span>
                <label class="layui-form-label"> 其他联系人</label>
                <div class="layui-input-inline">
                    <input type="text" name="otherRelativesName" lay-verify="required" placeholder="" autocomplete="off"
                           class="layui-input">
                </div>
            </div>

            <div style="display: inline-block"><span
                        style="color: red;display: inline-block;height: 38px;line-height: 38px;">*</span>
                <label class="layui-form-label"> 联系方式</label>
                <div class="layui-input-inline">
                    <input type="text" name="emergencyPhone" lay-verify="required" placeholder="" autocomplete="off"
                           class="layui-input">
                </div>
            </div>

        </div>

        <div class="layui-form-item" style="width: 1000px;position: relative;left: -3px">
            <div style="display: inline-block;float: left" style="height: 99px">

                <label class="layui-form-label">意向</label>
                <div class="layui-inline">
                    <div id="demo1" class="xm-select-demo" required lay-verify="required" style=" width:190px"
                         ;></div>
                </div>
                <span
                        style="color: red;display: inline-block;height: 38px;line-height: 38px;">*</span>
            </div>
            <div style="display: inline-block">
                <label class="layui-form-label">备注</label>
                <div class="layui-input-block" style="width: 190px">
                    <textarea name="remark" placeholder="请输入内容" class="layui-textarea"></textarea>
                </div>
            </div>


        </div>
        <div class="layui-form-item" style="margin-left:5%;margin-top: 3%;">
            <div class="layui-input-inline">
                <button class="layui-btn" type="button" lay-submit id="addSubmit">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>

</div>
<script src="/recruit/js/recruit.js"></script>

<script>
    sel();
    var demo1 = xmSelect.render({
        el: '#demo1',
        language: 'zn',
        filterable: true,
        searchTips: '搜索标签',
        tips: '请选择意向',
        height: '500px',
        autoRow: true,

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