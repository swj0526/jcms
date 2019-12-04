<!DOCTYPE html>
<html>
<head>
    <base href="${basePath}">
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
        <div>
            <div class="layui-btn-group" style="position: relative;left: 90% ">
                <button class="layui-btn data-add-btn" type="button" id="butfollow">添加跟进信息</button>
            </div>
            <div style="padding: 20px; background-color: #F2F2F2;">
                <div class="layui-row layui-col-space15">
                    <div class="layui-col-md6">

                        <div class="layui-card">
                            <div class="layui-card-header"><span>父亲姓名:${student.fatherName!"无数据"}</span></div>
                            <div class="layui-card-header"><span>父亲电话:${student.fatherPhone!"无数据"}</div>
                            <div class="layui-card-header">母亲姓名:${student.motherName!"无数据"}</div>
                            <div class="layui-card-header">母亲电话:${student.motherPhone!"无数据"}</div>
                            <div class="layui-card-body">

                            </div>
                        </div>
                    </div>
                    <div class="layui-col-md6">
                        <div class="layui-card">
                            <div class="layui-card-header">出生年月:${(student.birthDate?string("yyyy-MM-dd"))!'无数据'}</div>
                            <div class="layui-card-header">QQ:${student.qq!'无数据'}</div>
                            <div class="layui-card-header">微信:${student.weChat!'无数据'}</div>
                            <div class="layui-card-body">

                            </div>
                        </div>
                    </div>
                    <div class="layui-col-md12">
                        <div class="layui-card">
                            <form>


                                <div class="layui-card-header">跟进</div>
                                <div class="layui-card-body">
                                    <ul id="u">
                                        <#list detail as st>
                                            <li>
                                                <div class="sd">
                                                    <span>跟进时间:${(st.followTime?string("yyyy-MM-dd"))!'无数据'}</span></div>
                                            </li>
                                            <li>
                                                <div class="sd"><span>意向:${st.labelNames!'0'}</span></div>
                                            </li>
                                            <li>
                                                <div class="sd"><span>备注:${st.remark!'0'}</span></div>
                                            </li>
                                            <li>
                                                <div>
                                                    <button class="layui-btn data-add-btn upd" type="button"
                                                            value=${st.id}>修改</button>
                                                    <button class="layui-btn data-add-btn del" type="button"
                                                            value=${st.id}>删除</button>
                                                    <hr>
                                                </div>
                                            </li>
                                        </#list>

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

        <form class="layui-form" action="" id="formdata"lay-filter="dataForm">
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
                    <div id="demo2" class="xm-select-demo" style=" width:190px";></div>
                </div>
            </div>
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">备注:</label>
                <div class="layui-input-block">
                    <textarea name="remark" placeholder="请输入内容"required lay-verify="required" class="layui-textarea"></textarea>
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

    <#--修改-->
    <div style="display: none" id="upfollow">

        <form class="layui-form" action="" id="formdata"lay-filter="dataForm">
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
                    <div id="demo1" class="xm-select-demo" style=" width:190px";></div>
                </div>
            </div>
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">备注:</label>
                <div class="layui-input-block">
                    <textarea name="remark" placeholder="请输入内容"required lay-verify="required" class="layui-textarea"></textarea>
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
            laydate.render({//时间
                elem: '#date', //指定元素
                value: new Date()

            });
            var index;
            var url;
            //添加弹出框
            $("#butfollow").click(function () {
                index = layer.open({
                    type: 1,
                    title: "添加跟进信息",
                    skin: 'layui-layer-rim', //加上边框
                    area: ['720px', '350'], //设置宽高
                    content: $("#tabfollow"),
                    success: function () {
                       url = '/details/add'
                    }
                });
            });
//删除
            $(".del").click(function () {
                var id = $(this).val();
                $.post('/details/deleteFollow',{id:id},function (result) {
                    location.reload();
                })


            });
            //修改
            $(".upd").click(function () {
                addselect();

                var id = $(this).val();
                index = layer.open({
                    type: 1,
                    title: "修改跟进信息",
                    skin: 'layui-layer-rim', //加上边框
                    area: ['720px', '350'], //设置宽高
                    content: $("#upfollow"),
                    success: function () {

                    }
                });
                $.post();
            });


            //监听提交
            $("#butA").click(function () {

                var seList = new Array();
                var selectArr = demo2.getValue().valueOf();//获取复选框的值
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
                $.post(url, recruitDetail + "&studentId=" + studentId + "&labelIds=" + labe, function (result) {
                        layer.close(index);
                        location.reload();
                })
            });

        });

        var demo2 = xmSelect.render({
            el: '#demo2',
            language: 'zn',
            data: [
                {name: '有意向', value: 7},
                {name: '还在考虑', value: 8},
                {name: '完全不考虑', value: 9},

            ]
        })

        var demo1 = xmSelect.render({
            el: '#demo1',
            language: 'zn',
            data: [
                {name: '有意向', value: 7},
                {name: '还在考虑', value: 8},
                {name: '完全不考虑', value: 9},

            ]
        })
        function addselect(){
            demo1.setValue([${student.labelIds}])
        };

    </script>

</div>
</body>
</html>
