<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <script src="/layui/layui.js" charset="utf-8"></script>
    <script src="/jquery/jquery-3.3.1.min.js"></script>
    <script src="/recruit/js/xm.js" type="text/javascript"></script>
    <style type="text/css">
        #u {
            width: 100%;

        }

        #u li {
            border: white solid 0.5px;
            height: 50px;
            display: block;
            vertical-align: middle
        }

        .sd {
            display: table-cell;
            vertical-align: middle;
            height: 50px;

        }
    </style>
</head>
<body>
<div class="layui-row layui-col-space10" style="margin: 0">
    <div class="layui-col-md12">
        <div >
            <div class="layui-btn-group" style="position: relative;left: 90% ">
                <button class="layui-btn data-add-btn" type="button" id="butfollow">添加跟进信息${id}</button>
            </div>
            <div style="padding: 20px; background-color: #F2F2F2;">
                <div class="layui-row layui-col-space15">
                    <div class="layui-col-md6">

                        <div class="layui-card" >
                            <div class="layui-card-header"><span>父亲姓名:${student.fatherName!"无数据"}</span></div>
                            <div class="layui-card-header"><span>父亲电话:${student.fatherPhone!"无数据"}</div>
                            <div class="layui-card-header">卡片面板</div>
                            <div class="layui-card-header">卡片面板</div>
                            <div class="layui-card-body">
                                卡片式面板面板通常用于非白色背景色的主体内<br>
                                从而映衬出边框投影
                            </div>
                        </div>
                    </div>
                    <div class="layui-col-md6">
                        <div class="layui-card">
                            <div class="layui-card-header">卡片面板</div>
                            <div class="layui-card-body">
                                结合 layui 的栅格系统<br>
                                轻松实现响应式布局
                            </div>
                        </div>
                    </div>
                    <div class="layui-col-md12">
                        <div class="layui-card" >
                            <form>
                            <div class="layui-card-header">跟进</div>
                            <div class="layui-card-body">
                                <ul id="u">
                                    <#list detail as st>
                                        <li><div class="sd"><span>跟进时间:${st.followTime?string("yyyy-MM-dd")!""}</span></div>
                                        </li>
                                        <li><div class="sd"><span>意向:${st.labelIds!"无数据"}</span></div></li>
                                        <li><div class="sd"><span>备注:${st.remark}</span></div></li>
                                    </#list>
                                    <li> <div class="sd"><button class="layui-btn data-add-btn" type="button"value=${id}>修改</button></div>
                                        <div class="sd"><button class="layui-btn data-add-btn" type="button"value=${id}>删除</button></div></li>
                                </ul>
                            </div>

                            </form>
                        </div>
                    </div>
                </div>
            </div>

            <div>

            </div>

        </div>
    </div>

    <div style="display: none" id="tabfollow">
        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
            <legend>添加跟进记录</legend>
        </fieldset>

        <form class="layui-form" action="" id="formdata">
            <div class="layui-form-item">
                <label class="layui-form-label">跟进时间</label>
                <div class="layui-input-inline">
                    <input type="text" name="followTime" required lay-verify="required" placeholder="请输入"
                           autocomplete="off" class="layui-input" id="date">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">意向</label>
                <div class="layui-inline" style="width: 190px">
                    <div id="demo1" class="xm-select-demo" style=" width:190px" ;></div>
                </div>

            </div>

            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">备注:</label>
                <div class="layui-input-block">
                    <textarea name="remark" placeholder="请输入内容" class="layui-textarea">1</textarea>
                </div>
            </div>


            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" type="button" lay-submit lay-filter="formDemo" id="butA"
                            value=${id}>立即提交
                    </button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>
        </form>
    </div>

    <script>
        layui.use(['element', 'layer', 'form', 'jquery', 'laydate'], function () {
            var element = layui.element;
            var layer = layui.layer;
            var form = layui.form;
            var $ = layui.jquery;
            var laydate = layui.laydate;
            laydate.render({
                elem: '#date' //指定元素

            });
            var a =$("#app")

            var index;

            $("#butfollow").click(function () {
                index = layer.open({
                    type: 1,
                    title: "添加跟进信息",
                    skin: 'layui-layer-rim', //加上边框
                    area: ['720px', '350'], //设置宽高
                    content: $("#tabfollow"),
                    success: function () {

                    }
                });
            });

            //监听提交
            $("#butA").click(function () {
                var seList = new Array();
                var selectArr = demo1.getValue().valueOf();//获取复选框的值
                $.each(selectArr, function (k, v) {
                    $.each(v, function (k1, v1) {
                        if (k1 == "value") {
                            seList.push(v1);
                        }
                    });
                });
                let label = seList.join(",");
                var labe = ("," + label + ",");
                var recruitDetail = $("#formdata").serialize();
                var studentId = $("#butA").val();
                $.post('/details/add', recruitDetail + "&studentId=" + studentId + "&labelIds=" + labe, function (result) {
                    if (result) {
                        layer.close(index);
                        $.each(result, function (index, value) {
                            $("#u").append('<li><div class="sd"><span>跟进时间:' + value.followTime +'</span></div></li>');
                            $("#u").append('<li><div class="sd"><span>跟进意向:' + value.labelIds +'</span></div></li>');
                            $("#u").append('<li><div class="sd"><span>备注:' + value.remark +'</span></div></li>');
                            $("#u").append('<li><div class="sd"><button class="layui-btn data-add-btn" type="button"value=${id}>修改</button></div></li>');
                            $("#u").append('<li><div class="sd"><button class="layui-btn data-add-btn" type="button"value=${id}>修改</button></div></li>');



                          //  $("#u").append($(".layui-card"));



                        })


                    }

                })
            });

        });

        var demo1 = xmSelect.render({
            el: '#demo1',
            language: 'zn',
            data: [
                {name: '有意向', value: 1},
                {name: '还在考虑', value: 2},
                {name: '完全不考虑', value: 3},
                {name: '不太明确', value: 4},
                {name: '完全没有', value: 5},
            ]
        })

    </script>

</div>
</body>
</html>
