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
                    <h2 class="layui-colla-title">第一次跟进</h2>
                    <div class="layui-colla-content">
                        <div style="padding: 20px; background-color: #F2F2F2;">
                            <div class="layui-row layui-col-space15">
                                <div class="layui-col-md12">
                                    <div class="layui-card">
                                        <div class="layui-card-header">

                                            <div class="layui-form-item">
                                                <div class="layui-inline">
                                                    <label class="layui-form-label"
                                                           style="padding-left: 0px">跟进时间</label>
                                                    <div class="layui-input-inline" style="width: 90px">
                                                        <input style="border: 0;" class="layui-input" name="date"
                                                               id="test1" type="text" disabled
                                                               value="2019-11-19">
                                                    </div>
                                                    <label class="layui-form-label" style="padding-left: 0px">意向</label>
                                                    <div class="layui-input-inline" style="width: 90px">
                                                        <input style="border: 0;%" class="layui-input" name="date"
                                                               id="test1" type="text" disabled
                                                               value="摇摆不定">
                                                    </div>
                                                    <label class="layui-form-label" style="padding-left: 0px">渠道</label>
                                                    <div class="layui-input-inline" style="width: 150px">
                                                        <input style="border: 0;" class="layui-input" name="date"
                                                               id="test1" type="text" disabled
                                                               value="网络xxxx">
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
                <div class="layui-colla-item">
                    <h2 class="layui-colla-title">第二次跟进</h2>
                    <div class="layui-colla-content">
                    </div>
                </div>
                <div class="layui-colla-item">
                    <h2 class="layui-colla-title">第三次跟进</h2>
                    <div class="layui-colla-content">
                        <p>在前端技术快速变革的今天，layui 仍然坚持语义化的组织模式，甚至于模块理念都是采用类AMD组织形式，并非是有意与时代背道而驰。layui
                            认为以jQuery为核心的开发方式还没有到完全消亡的时候，而早期市面上基于jQuery的UI都普通做得差强人意，所以需要有一个新的UI去重新为这一领域注入活力，并采用一些更科学的架构方式。
                            <br><br>
                            因此准确地说，layui 更多是面向那些追求开发简单的前端工程师们，以及所有层次的服务端程序员。</p>
                    </div>
                </div>
                <div class="layui-colla-item">
                    <h2 class="layui-colla-title">第四次跟进</h2>
                    <div class="layui-colla-content">
                        <p>man！ 所以这个问题不要再出现了。。。</p>
                    </div>
                </div>
            </div>
            <script>
                layui.use(['element', 'layer'], function () {
                    var element = layui.element;
                    var layer = layui.layer;

                    //监听折叠
                    element.on('collapse(test)', function (data) {

                    });
                });
            </script>


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
                               autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">跟进状态</label>
                    <div class="layui-input-inline">
                        <input type="password" name="password" required lay-verify="required" placeholder="请输入"
                               autocomplete="off"
                               class="layui-input">
                    </div>

                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">来源渠道</label>
                    <div class="layui-input-inline">
                        <select name="city" lay-verify="required">
                            <option value=""></option>
                            <option value="0">北京</option>
                            <option value="1">上海</option>
                            <option value="2">广州</option>
                            <option value="3">深圳</option>
                            <option value="4">杭州</option>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">普通文本域</label>
                    <div class="layui-input-block">
                        <textarea placeholder="请输入内容" class="layui-textarea"></textarea>
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

        <script>
            //Demo
            layui.use('form', function () {
                var form = layui.form;

                //监听提交
                form.on('submit(formDemo)', function (data) {
                    layer.msg(JSON.stringify(data.field));
                    return false;
                });

            });
        </script>
    </div>
</div>
</body>
</html>
