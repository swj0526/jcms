<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>账号管理的选项卡</title>
    <link rel="stylesheet" type="text/css" href="/layui/css/layui.css"/>
    <script type="text/javascript" src="/layui/layui.js">
    </script>
    <script type="text/javascript" src="/account/js/xm-select.js"></script>
    <script type="text/javascript" src="/account/js/tab.js"></script>
    <script type="text/javascript" src="/account/js/listStudent.js">
    </script>
    <script type="text/javascript" src="/account/js/listStaff.js">
    </script>
    <style>
        .layui-layer-btn{
            text-align: center;
        }
    </style>
</head>
<body>


<div class="layui-tab layui-tab-card" lay-filter="demo">
    <ul class="layui-tab-title">
        <li class="layui-this" lay-id="tab_student">学生账号管理</li>
        <li lay-id="tab_staff">教职工账号管理</li>
    </ul>
    <div class="layui-tab-content">
        <div class="layui-tab-item layui-show">
            <div class="layuimini-container">
                <div class="layuimini-main">
                    <fieldset class="layui-elem-field layuimini-search">
                        <legend>搜索信息</legend>
                        <div style="margin: 10px 10px 10px 10px">
                            <form class="layui-form layui-form-pane" action="">
                                <div class="layui-form-item">
                                    <div class="layui-inline">
                                        <label class="layui-form-label">关键词</label>
                                        <div class="layui-input-inline">
                                            <input type="text" name="keys" autocomplete="off" class="layui-input"
                                                   placeholder="姓名/手机号码/学号">
                                        </div>
                                    </div>
                                    <div class="layui-inline">
                                        <label class="layui-form-label">专业-班级</label>
                                        <div class="layui-input-inline" lay-verify="required" lay-search="">
                                            <select name="major">
                                                <option value="">请选择专业-班级</option>
                                                <optgroup label="影视专业">
                                                    <option value="">所有影视专业</option>
                                                    <option value="">影视一班</option>
                                                </optgroup>
                                                <optgroup label="美术专业">
                                                    <option value="">所有美术专业</option>
                                                    <option value="">美术一班</option>
                                                </optgroup>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="layui-inline">
                                        <label class="layui-form-label">是否被激活</label>
                                        <div class="layui-input-inline">
                                            <select name="lock1" lay-verify="">
                                                <option value=""></option>
                                                <option value="">激活</option>
                                                <option value="">锁定</option>
                                            </select>
                                        </div>
                                        <div class="layui-inline">
                                            <a class="layui-btn" lay-submit="" lay-filter="data-search-btn">查询</a>
                                        </div>
                                    </div>
                            </form>
                        </div>
                    </fieldset>
                    <table class="layui-hide" id="test" lay-filter="test"></table>
                    <script type="text/html" id="checkboxTpl">
                        <!-- 这里的 checked 的状态只是演示 -->
                        <input type="checkbox" name="lock" value="{{d.id}}" title="激活" lay-filter="lockDemo">
                    </script>
                    <script type="text/html" id="barDemo">
                        <button type="button" class="layui-btn layui-btn-normal layui-btn-xs" lay-event="reset"
                                data-method="confirmTrans">
                            重置密码
                        </button>
                    </script>
                </div>
            </div>

        </div>
        <div id="roleDemo" style="display: none; padding: 20px;">
            <form class="layui-form" action="" style="border: 1px solid #d5d5d5;height: 200px;">
                <div class="layui-input-block" style="margin: 10px;">
                    <input type="checkbox" name="like[write]" title="教师">
                    <input type="checkbox" name="like[read]" title="管理员" checked="">
                    <input type="checkbox" name="like[game]" title="校长">
                </div>
            </form>
        </div>
        <div class="layui-tab-item">
            <div class="layuimini-container">
                <div class="layuimini-main">
                    <fieldset class="layui-elem-field layuimini-search">
                        <legend>搜索信息</legend>
                        <div style="margin: 10px 10px 10px 10px">
                            <form class="layui-form layui-form-pane" action="">
                                <div class="layui-form-item">
                                    <div class="layui-inline">
                                        <label class="layui-form-label">关键词</label>
                                        <div class="layui-input-inline">
                                            <input type="text" name="keys1" autocomplete="off" class="layui-input"
                                                   placeholder="张三/201932094/5000">
                                        </div>
                                    </div>
                                    <div class="layui-inline">
                                        <label class="layui-form-label">角色</label>
                                        <div class="layui-input-inline">
                                            <select name="role1" lay-verify="">
                                                <option value=""></option>
                                                <option value="">校长</option>
                                                <option value="">任课老师</option>
                                                <option value="">教务</option>
                                                <option value=""></option>
                                                <option value="">校长</option>
                                                <option value="">任课老师</option>
                                                <option value="">教务</option>
                                                <option value=""></option>
                                                <option value="">校长</option>
                                                <option value="">任课老师</option>
                                                <option value="">教务</option>
                                                <option value=""></option>
                                                <option value="">校长</option>
                                                <option value="">任课老师</option>
                                                <option value="">教务</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="layui-inline">
                                        <label class="layui-form-label">是否被激活</label>
                                        <div class="layui-input-inline">
                                            <select name="lock1" lay-verify="">
                                                <option value=""></option>
                                                <option value="">激活</option>
                                                <option value="">锁定</option>
                                            </select>
                                        </div>

                                        <div class="layui-inline">
                                            <a class="layui-btn" lay-submit="" lay-filter="data-search-btn">查询</a>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </fieldset>

                    <table class="layui-hide" id="test1" lay-filter="test1"></table>
                    <script type="text/html" id="checkboxTpl1">
                        <!-- 这里的 checked 的状态只是演示 -->
                        <input type="checkbox" name="lock1" value="{{d.id}}" title="激活" lay-filter="lockDemo1" >
                    </script>
                    <#--<script type="text/html" id="roleDemo">
                        <div class="demo1" class="xm-select-demo" ></div>
                    </script>-->
                    <script type="text/html" id="barDemo1">

                        <button type="button" class="layui-btn layui-btn-normal layui-btn-xs" lay-event="reset1"
                                data-method="confirmTrans">
                            重置密码
                        </button>
                        <button type="button" class="layui-btn layui-btn-xs" lay-event="reset2"
                                data-method="confirmTrans">
                            设置角色
                        </button>
                    </script>
                </div>
            </div>
        </div>

    </div>
</div>
</body>
</html>