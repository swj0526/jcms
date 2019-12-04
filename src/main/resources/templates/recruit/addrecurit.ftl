<!DOCTYPE html>
<html lang="en">
<head>
    <base href="${basePath}">
    <meta charset="utf-8">
    <title></title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="/recruit/css/label.css">
    <link rel="stylesheet" href="/static/common/css/all.css">
    <#--上传-->

    <script src="/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="/static/common/js/all.js"></script>
    <script src="/jquery/jquery-3.3.1.min.js"></script>
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
    <script src="/recruit/js/label.js"></script>
    <script src="/recruit/js/xm.js"></script>

    <#--<script src="/all.js"></script>-->

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
<#--添加标签-->
<div style="display: none" id="addlabel">
    <form class="layui-form layui-form-pane" action="" lay-filter="dataForm" id="data">
        <div class="layui-form-item">

            <label class="layui-form-label">标签名称<span  class="star">*</span> </label>
            <div class="layui-input-inline">
                <input type="text" name="name" required lay-verify="required" placeholder="" autocomplete="off"
                       class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">标签备注</label>
            <div class="layui-input-inline">
                <input type="text" name="remark" placeholder="" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item" style="margin-left: 30%">
            <div class="layui-input-inline">
                <button class="layui-btn" type="button"  lay-submit lay-filter="formDemo" id="addM">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>


</div>
<div id="recruit" style="margin-left: 25%">
    <div >
    <form class="layui-form layui-form-pane" lay-filter="addDataForm" id="dataFor" method="post">
        <div class="layui-form-item">
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label"> 姓名<span  class="star">*</span></label>
                    <div class="layui-input-inline">
                        <input type="text" name="name" lay-verify="required" placeholder="" autocomplete="off"
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">性别<span  class="star">*</span></label>
                    <div class="layui-inline" style="width: 190px;">
                        <select name="sex" lay-verify=""lay-verify="required">
                            <option value=""></option>
                            <option value="男">男</option>
                            <option value="女">女</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline" style="margin-bottom: 0px">
                    <label class="layui-form-label"> 出生年月</label>
                    <div class="layui-input-inline">
                        <input type="text" name="birthDate" lay-verify="required" placeholder="" autocomplete="off"
                               class="layui-input" id="dat">
                    </div>
                </div>
                <div class="layui-inline" style="margin-bottom: 0px;">
                    <label class="layui-form-label"> 毕业院校</label>
                    <div class="layui-input-inline">
                        <input type="text" name="school"  placeholder="" autocomplete="off"
                               class="layui-input">
                    </div>

                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label"> 手机号码<span  class="star">*</span></label>
                    <div class="layui-input-inline">
                        <input type="text" name="studentPhone" lay-verify="required" placeholder="" autocomplete="off"
                               class="layui-input">
                    </div>
                </div>

                <div class="layui-inline" style="margin-right: 0px;margin-bottom: 0px;">
                    <label class="layui-form-label">QQ</label>
                    <div class="layui-input-inline">
                        <input type="text" name="qq"  placeholder="" autocomplete="off"
                               class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">微信</label>
                    <div class="layui-input-inline">
                        <input type="text" name="weChat" lay-verify="required" placeholder="" autocomplete="off"
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">来源渠道<span  class="star">*</span></label>

                    <div class="layui-input-inline">
                        <div class="layui-inline" style="width: 190px">
                            <select name="channelId" lay-verify="" class="decSelect" required lay-verify="required"
                                    url="/dictionary/list/channel/options">
                                <option value="">来源渠道</option>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label"> 母亲姓名</label>
                    <div class="layui-input-inline">
                        <input type="text" name="motherName" lay-verify="required" placeholder="" autocomplete="off"
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label"> 母亲电话</label>
                    <div class="layui-input-inline">
                        <input type="text" name="motherPhone" lay-verify="required" placeholder="" autocomplete="off"
                               class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label"> 父亲姓名</label>
                    <div class="layui-input-inline">
                        <input type="text" name="fatherName" placeholder="" autocomplete="off"
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <div class="layui-inline">
                        <label class="layui-form-label"> 父亲电话</label>
                        <div class="layui-input-inline">
                            <input type="text" name="fatherPhone"  placeholder="" autocomplete="off"
                                   class="layui-input">
                        </div>
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label"> 应急联系人</label>
                    <div class="layui-input-inline">
                        <input type="text" name="otherRelativesName" lay-verify="required" placeholder="" autocomplete="off"
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <div class="layui-inline">
                        <label class="layui-form-label"> 应急电话</label>
                        <div class="layui-input-inline">
                            <input type="text" name="emergencyPhone" lay-verify="required" placeholder="" autocomplete="off"
                                   class="layui-input">
                        </div>
                    </div>
                </div>
            </div>
            <div class="layui-form-item" style="width: 1000px;position: relative;left: -3px">
                <div style="display: inline-block;float: left" style="height: 99px">
                    <label class="layui-form-label">意向<span  class="star">*</span></label>
                    <div class="layui-inline">
                        <div id="demo1" class="xm-select-demo" required lay-verify="required" style=" width:510px"
                             ;></div>
                    </div>
                    <div class="layui-inline">
                        <div class="layui-inline" >
                            <button class="layui-btn layui-btn-xs  layui-btn-normal" type="button" id="label">添加意向</button>
                        </div>
                    </div>
                </div>
            </div>
            <div style="display: inline-block">
                <label class="layui-form-label">备注</label>
                <div class="layui-input-block" style=" width:510px">
                    <textarea name="remark" placeholder="请输入内容" class="layui-textarea"></textarea>
                </div>
            </div>
            <div class="layui-form-item" style="margin-left:5%;margin-top: 3%;">
                <div class="layui-input-inline">
                    <button  type="button" class="layui-btn"  lay-submit="" id="addSubmit"lay-filter="demo1">立即提交</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>

        </div>

    </form>
    </div>

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
        demo1.update({
            data: res,

        })
    });

</script>

<script src="/recruit/js/updata.js"></script>
</body>
</html>