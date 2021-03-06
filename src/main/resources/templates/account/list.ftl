<!DOCTYPE html>
<html lang="en">
<head>
    <#include "../common/common.ftl"/>
    <title>账号管理</title>
    <style>
        .layui-layer-btn {
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
            <fieldset class="layui-elem-field" style="padding: 5px;">
                <form class="layui-form layui-form-pane" action="">
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">关键词</label>
                            <div class="layui-input-inline">
                                <input type="text" name="keywords" autocomplete="off" class="layui-input"
                                       placeholder="姓名/手机号码">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">专业-班级</label>
                            <div class="layui-input-inline">
                                <div class="layui-inline">
                                    <select name="majorId" lay-verify="" id="gradeSelect" required
                                            lay-verify="required"
                                            url="/major/list/select">
                                        <option value="">请选择</option>
                                    </select>
                                </div>
                            </div>
                        </div>

                        <div class="layui-inline">
                            <label class="layui-form-label">是否被激活</label>
                            <div class="layui-input-inline">
                                <select name="enable" lay-verify="" required
                                        lay-verify="required">
                                    <option value=""></option>
                                    <option value="true">激活</option>
                                    <option value="false">锁定</option>
                                </select>
                            </div>
                            <div class="layui-inline">
                                <a class="layui-btn" lay-submit="" lay-filter="data-search-btn">查询</a>
                            </div>
                        </div>
                    </div>
                </form>

            </fieldset>
            <table class="layui-hide" id="test" lay-filter="test"></table>
            <script type="text/html" id="checkboxTpl">
                <!-- 这里的 checked 的状态只是演示 -->
                <input type="checkbox" name="lock" value="{{d.id}}" title="激活" lay-filter="lockDemo" {{ d.enable==
                       true ? "checked" : "" }}>
            </script>
            <script type="text/html" id="barDemo">
                <button type="button" class="layui-btn layui-btn-normal layui-btn-xs" lay-event="reset"
                        data-method="confirmTrans">
                    重置密码
                </button>
            </script>
        </div>

        <div class="layui-tab-item">
            <div class="layuimini-container">
                <div class="layuimini-main">
                    <fieldset class="layui-elem-field layuimini-search">
                        <#-- <legend>搜索信息</legend>-->
                        <div style="margin: 10px 10px 10px 10px">
                            <form class="layui-form layui-form-pane" action="">
                                <div class="layui-form-item">
                                    <div class="layui-inline">
                                        <label class="layui-form-label">关键词</label>
                                        <div class="layui-input-inline">
                                            <input type="text" name="keys1" autocomplete="off" class="layui-input"
                                                   placeholder="姓名/手机号">
                                        </div>
                                    </div>
                                    <#--<div class="layui-inline">
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
                                    </div>-->
                                    <div class="layui-inline">
                                        <label class="layui-form-label">是否被激活</label>
                                        <div class="layui-input-inline">
                                            <select name="lock1" lay-verify="">
                                                <option value=""></option>
                                                <option value="true">激活</option>
                                                <option value="false">锁定</option>
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

                    <table class="layui-hide" id="test1" lay-filter="test1"
                           style="overflow:Scroll;overflow-x:hidden;"></table>
                    <script type="text/html" id="checkboxTpl1">
                        <!-- 这里的 checked 的状态只是演示 -->
                        <input type="checkbox" name="lock1" value="{{d.id}}" title="激活" lay-filter="lockDemo1" {{
                               d.enable==
                               true ? "checked" : "" }}>
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
<script type="text/javascript" src="/account/js/tab.js"></script>
<script type="text/javascript" src="/account/js/listStudent.js">
</script>
<script type="text/javascript" src="/account/js/listStaff.js">
</script>
<script type="text/javascript">
    sel_garade();
</script>
</body>
</html>