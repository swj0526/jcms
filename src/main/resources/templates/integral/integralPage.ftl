<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="/layui/css/public.css" media="all">
    <script src="/layui/layui.js"></script>
    <script src="/integral/js/integral.js"></script>
</head>
<body>
<div class="layuimini-container">

    <div class="layuimini-main">
        <button type="button" class="layui-btn layui-btn-normal" style="position: relative;left:80%" id="add">加分</button>
        <button type="button" class="layui-btn layui-btn-normal" style="position: relative;left:80%" id="points">减分</button>
        <table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter" ></table>
    </div>
</div>
<#--*******************id=aa 弹窗************************************-->
<div id="aa" style="display: none">
    <fieldset class="layui-elem-field layuimini-search">
        <div style="margin: 10px 10px 10px 10px">
            <form class="layui-form layui-form-pane" lay-filter="dataForm">
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">选择事由</label>
                        <div class="layui-inline" style="width: 100px">
                            <select name="city" lay-verify="">
                                <option value="">事由选择</option>
                                <option value="-5">打架斗殴</option>
                                <option value="-5">抽烟喝酒</option>
                                <option value="-10">烫发染发</option>
                            </select>
                        </div>
                        <div class="layui-inline" style="width: 110px">
                            <button class="layui-btn" id="Setup">设置</button>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">学生姓名</label>
                            <div class="layui-input-inline">
                                <input type="text" name="username" autocomplete="off" class="layui-input"
                                       placeholder="例：张三">
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </fieldset>
</div>
<#--***********points点击弹窗****************-->
<div id="aaa" style="display: none">
    <fieldset class="layui-elem-field layuimini-search">

        <div style="margin: 10px 10px 10px 10px">
            <form class="layui-form layui-form-pane" lay-filter="dataForm">
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">选择事由</label>
                        <div class="layui-inline" style="width: 100px">
                            <select name="city" lay-verify="" >
                                <option value="">品学兼优</option>
                                <option value="+10">乐于助人</option>
                                <option value="+10">勤奋好学</option>
                                <option value="+10">成绩上升</option>
                            </select>
                        </div>
                        <div class="layui-inline" style="width: 110px">
                            <button class="layui-btn" id="Setup">设置</button>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">学生姓名</label>
                            <div class="layui-input-inline">
                                <input type="text" name="username" autocomplete="off" class="layui-input"
                                       placeholder="例：张三">
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </fieldset>
</div>
<#--*************modify点击弹窗*********-->
<#--<div id="modifyLayer" style="display: none">-->
<#--    <fieldset class="layui-elem-field layuimini-search">-->
<#--        <legend>添加信息</legend>-->
<#--        <div style="margin: 10px 10px 10px 10px">-->
<#--            <form class="layui-form layui-form-pane" lay-filter="dataForm">-->
<#--                <div class="layui-form-item">-->
<#--                    <div class="layui-inline">-->
<#--                        <label class="layui-form-label">选择事由</label>-->
<#--                        <div class="layui-inline" style="width: 100px">-->
<#--                            <select name="city" lay-verify="" >-->
<#--                                <option value="">品学兼优</option>-->
<#--                                <option value="010">乐于助人</option>-->
<#--                                <option value="021">勤奋好学</option>-->
<#--                                <option value="0571">成绩上升</option>-->
<#--                            </select>-->
<#--                        </div>-->
<#--                        <div class="layui-inline" style="width: 110px">-->
<#--                            <button class="layui-btn" id="Setup">设置</button>-->
<#--                        </div>-->
<#--                    </div>-->
<#--                    <div class="layui-inline">-->
<#--                        <label class="layui-form-label">学生学号</label>-->
<#--                        <div class="layui-input-inline">-->
<#--                            <input type="text" name="name" autocomplete="off" class="layui-input">-->
<#--                        </div>-->
<#--                    </div>-->
<#--                    <div class="layui-inline">-->
<#--                        <label class="layui-form-label">学生姓名</label>-->
<#--                        <div class="layui-input-inline">-->
<#--                            <input type="text" name="name" autocomplete="off" class="layui-input">-->
<#--                        </div>-->
<#--                    </div>-->
<#--                    <div class="layui-inline">-->
<#--                        <label class="layui-form-label">班级</label>-->
<#--                        <div class="layui-input-inline">-->
<#--                            <input type="text" name="name" autocomplete="off" class="layui-input">-->
<#--                        </div>-->
<#--                    </div>-->

<#--                </div>-->
<#--            </form>-->
<#--        </div>-->
<#--    </fieldset>-->
<#--</div>-->
</body>
</html>
