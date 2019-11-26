<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <script src="/layui/layui.js" charset="utf-8"></script>
</head>
<body>
<div class="layui-row layui-col-space10" style="margin: 0">
    <div class="layui-col-md6">
        <div>
            <div class="layui-collapse" lay-filter="test">
                <div class="layui-colla-item">
                    <h2 class="layui-colla-title">跟进--${birth}</h2>
                    <div class="layui-colla-content">
                        <div style="padding: 20px; background-color: #F2F2F2;">
                            <div class="layui-row layui-col-space15">
                                <div class="layui-col-md12">
                                    <div class="layui-card">
                                        <div class="layui-card-header">

                                            <div class="layui-form-item">
                                                <div class="layui-inline">

                                                    <label class="layui-form-label" style="padding-left: 0px">意向</label>
                                                    <div class="layui-input-inline" style="width: 90px">
                                                        <input style="border: 0;%" class="layui-input" name="date"
                                                               id="test1" type="text" disabled
                                                               value=${student.labelIds}>
                                                    </div>
                                                    <label class="layui-form-label" style="padding-left: 0px">渠道</label>
                                                    <div class="layui-input-inline" style="width: 150px">
                                                        <input style="border: 0;" class="layui-input" name="channelId"
                                                               id="test1" type="text" disabled
                                                               value=${student.channelId}>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="layui-card-body">
                                            <label class="layui-form-label" >备注</label>
                                            <div class="layui-input-inline">
                                                <p>因为不适合。如果希 望开发长期的项目或者制作产品类网站，那么就需要实现特定的设计，为了在维护项目中可以方便地按设计师要求快速修改样式，
                                                    肯定会逐步编写出各种业务组件、工具类，相当于为项目自行开发一套框架。——来自知乎@Kayo</p>
                                                <div>
                                                    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
                                                    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>

            </div>


        </div>
    </div>
    <div class="layui-col-md6">
        <div style="width:50%;padding:3.125rem; background: rgb(242,242,242);">
            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
                <legend>添加跟进记录</legend>
            </fieldset>

            <form class="layui-form" action="">
                <div class="layui-form-item">
                    <label class="layui-form-label">跟进时间</label>
                    <div class="layui-input-inline">
                        <input type="text" name="title" required lay-verify="required" placeholder="请输入"
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
                        <textarea name="remark" placeholder="请输入内容" class="layui-textarea">1</textarea>
                    </div>
                </div>


                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>
        </div>
        <script src="/recruit/js/xm.js" type="text/javascript"></script>
        <script>
            layui.use(['element', 'layer','form','jquery','laydate'], function () {
                var element = layui.element;
                var layer = layui.layer;
                var form = layui.form;
                var $ = layui.jquery;
                var laydate = layui.laydate;
                laydate.render({
                    elem: '#date' //指定元素

                });

                //监听提交
                form.on('submit(formDemo)', function (data) {
                    layer.msg(JSON.stringify(data.field));
                    return false;
                });
                //监听折叠
                element.on('collapse(test)', function (data) {

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
</div>
</body>
</html>
