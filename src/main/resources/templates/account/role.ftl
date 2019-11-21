<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>权限管理</title>
    <link rel="stylesheet" type="text/css" href="/layui/css/layui.css"/>
    <script type="text/javascript" src="/layui/layui.js">
    </script>
    <script type="text/javascript" src="/all.js"></script>
    <script type="text/javascript" src="/account/js/tab.js"></script>
    <script type="text/javascript" src="/account/js/role.js"></script>

</head>
<body>
<!--弹出框新增-->
<div style="display: none" id="add">
    <form class="layui-form" action="" lay-filter="dataForm" id="dataFor">
        <div class="layui-form-item">
            <label class="layui-form-label">角色姓名</label>
            <div class="layui-input-inline">
                <input type="text" name="name"  lay-verify="required"  autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">角色描述</label>
            <div class="layui-input-inline">
                <input type="text" name="describe"  lay-verify="required"  autocomplete="off" class="layui-input">
            </div>
        </div> <div class="layui-form-item">
            <label class="layui-form-label">角色备注</label>
            <div class="layui-input-inline">
                <input type="text" name="remark"  lay-verify="required"  autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item" style="margin-left: 30%">
            <div class="layui-input-inline">
                <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
            </div>
        </div>
    </form>

</div>
<!--弹出框修改-->
<div style="display: none" id="update">
    <form class="layui-form" action="" lay-filter="dataForm1" id="dataFor">
        <div class="layui-form-item">
            <label class="layui-form-label">角色姓名</label>
            <div class="layui-input-inline">
                <input type="text" name="name"  lay-verify="required"  autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">角色描述</label>
            <div class="layui-input-inline">
                <input type="text" name="describe"  lay-verify="required"  autocomplete="off" class="layui-input">
            </div>
        </div> <div class="layui-form-item">
            <label class="layui-form-label">角色备注</label>
            <div class="layui-input-inline">
                <input type="text" name="remark"  lay-verify="required"  autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item" style="margin-left: 30%">
            <div class="layui-input-inline">
                <button class="layui-btn" lay-submit lay-filter="formDemo">确定修改</button>
            </div>
        </div>
    </form>

</div>
<div class="layui-tab layui-tab-card" lay-filter="demo">
    <div class="layui-tab-content">
        <div class="layui-tab-item layui-show">
            <div class="layuimini-container">
                <div class="layuimini-main">
                    <div class="layui-inline">
                        <a class="layui-btn" lay-submit="" lay-filter="data-search-btn" id="roleAdd">添加</a>
                    </div>
                    <table class="layui-hide" id="test" lay-filter="test"></table>

                    <script type="text/html" id="barDemo">
                        <button type="button" class="layui-btn layui-btn-normal layui-btn-xs" lay-event="edit" data-method="confirmTrans">
                            修改
                        </button>
                        <button type="button" class="layui-btn  layui-btn-xs" lay-event="fun" data-method="confirmTrans">
                            设置权限
                        </button>
                        <button type="button" class="layui-btn  layui-btn-danger  layui-btn-xs" lay-event="delete" data-method="confirmTrans">
                            删除
                        </button>
                    </script>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>