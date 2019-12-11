<!DOCTYPE html>
<html lang="en">
<head>
    <base href="${basePath}">
    <#include "common.ftl">
</head>
<body style="margin-left: 20px;">
<h1>1.autoComplete组件</h1>
<div>
    <form class="layui-form" action="">
        <div class="layui-form-item">
            <div class="layui-input-inline">
                <select name="autoComplete" lay-verify="" lay-search url="/dictionary/list/channel/options" class="decSelect">
                    <option value="">请输入</option>
                </select>
            </div>
            <button id="show" class="layui-btn">show</button>
        </div>
    </form>

    <div style="background-color: #FCDEE0">使用场景:录入学生姓名,点击show的时候弹出学生的id</div>
    <div style="background-color: #E8F5F7">
        <h2>html代码</h2>

        <xmp>
            <div>
                <form class="layui-form" action="">
                    <div class="layui-form-item">
                        <div class="layui-input-inline">
                            <select name="autoComplete" lay-verify="" lay-search url="/dictionary/list/channel/options" class="decSelect">
                                <option value="">请输入</option>
                            </select>
                        </div>
                        <button id="show" class="layui-btn">show</button>
                    </div>
                </form>
            </div>
        </xmp>
        <hr>
        <h2>js代码</h2>
        <xmp>
            $('.wx-input').attr('data-value')); //取id可用
        </xmp>
    </div>
</div>
<h1 style="margin-top: 20px;">2.专供列表页---专业/班级查询使用</h1>
<div>
    <form class="layui-form layui-form-pane" action="">
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">专业-班级</label>
                <div class="layui-input-inline">
                    <div class="layui-inline">
                        <select name="major" lay-verify="" id="gradeSelect" required
                                lay-verify="required"
                                url="/major/list/select">
                            <option value="">请选择</option>
                        </select>
                    </div>
                </div>
                <button id="show2" class="layui-btn">show</button>
            </div>
        </div>
    </form>
    <div>
        <img src="../common/img/gradeSelect.jpg">
    </div>
    <div style="background-color: #E8F5F7">
        <h2>html代码</h2>
        <xmp>
            <div class="layui-inline">
                <label class="layui-form-label">专业-班级</label>
                <div class="layui-input-inline">
                    <div class="layui-inline">
                        <select name="major" lay-verify="" id="gradeSelect" required
                                lay-verify="required"
                                url="/major/list/select">
                            <option value="">请选择</option>
                        </select>
                    </div>
                </div>
            </div>
        </xmp>
        <hr>
        <h2>js代码</h2>
        <xmp>
            sel_garade();//调用函数上述生效
            $('#gradeSelect').val();//获取majorId
        </xmp>
    </div>
</div>
<h1 style="margin-top: 20px;">3.动态生成的下拉框(字典表里所有的数据都可以使用)</h1>
<div>
    <form class="layui-form layui-form-pane" action="">
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">用户学年</label>
                <div class="layui-inline" style="width: 115px;margin-right: 0px;margin-bottom: 0px;">
                    <select name="semesterId" lay-verify="required" class="decSelect"
                            url="/dictionary/list/payTerm/options">
                        <option value="">请选择</option>
                    </select>
                </div>
            </div>
            <button id="show3" class="layui-btn">show</button>
        </div>
    </form>
    <div style="background-color: #E8F5F7">
        <h2>html代码</h2>
        <xmp>
            <div class="layui-inline">
                <label class="layui-form-label">用户学年</label>
                <div class="layui-inline" style="width: 115px;margin-right: 0px;margin-bottom: 0px;">
                    <select name="semesterId" lay-verify="required" class="decSelect"
                            url="/dictionary/list/payTerm/options">
                        <option value="">请选择</option>
                    </select>
                </div>
            </div>
        </xmp>
        <hr>
        <h2>js代码</h2>
        <xmp>
            sel();//调用该函数上述生效
            $('[name="semesterId"]').val();//获取majorId
        </xmp>
    </div>
</div>
<h1 style="margin-top: 20px;">4.在子页面开父页面的tab</h1>
<div>
    <div style="background-color: #E8F5F7">
        <h2>js代码</h2>
        <xmp>
            parent_tab(id,title,src);//使用该函数,传入的三个参数分别为tab的id,标题,controller访问页面的地址
        </xmp>
    </div>
</div>
<h1 style="margin-top: 20px;">5.关闭指定的tab,并定位到指定的tab</h1>
<div>
    <div style="background-color: #E8F5F7">
        <h2>js代码</h2>
        <xmp>
            close_tab(oldId,newId,title,src);//传入的三个参数分别为要关闭的旧的tab的id(oldId),定位新的tab的id(newId),标题,controller访问页面的地址
        </xmp>
    </div>
</div>
</body>
<script type="text/javascript">
    $(function () { //demo1的弹窗
        $('#show1').click(function () {
            alert($('.wx-input').attr('data-value'));
        });
    });
    sel_garade();//demo2的函数调用
    $(function () { //demo1的弹窗
        $('#show2').click(function () {
            alert($('#gradeSelect').val());
        });
    });
    sel();//demo3的函数的调用
    $(function () { //demo3的弹窗
        $('#show3').click(function () {
            alert($('[name="semesterId"]').val());
        });
    });
</script>
</html>