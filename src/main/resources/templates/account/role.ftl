<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>权限管理</title>
    <link rel="stylesheet" type="text/css" href="/layui/css/layui.css"/>
    <script type="text/javascript" src="/layui/layui.js">
    </script>
    <script type="text/javascript" src="/account/js/tab.js"></script>
    <script type="text/javascript" src="/account/js/role.js"></script>

</head>
<body>
<div class="layui-tab layui-tab-card" lay-filter="demo">
    <ul class="layui-tab-title">
        <li class="layui-this" lay-id="tab_student">角色列表</li>
        <li lay-id="tab_staff">角色权限管理</li>
    </ul>
    <div class="layui-tab-content">
        <div class="layui-tab-item layui-show">
            <div class="layuimini-container">
                <div class="layuimini-main">
                    <div class="layui-inline">
                        <a class="layui-btn" lay-submit="" lay-filter="data-search-btn">添加</a>
                    </div>
                    <table class="layui-hide" id="test" lay-filter="test"></table>

                    <script type="text/html" id="barDemo">
                        <button type="button" class="layui-btn layui-btn-xs" id="reset" data-method="confirmTrans">
                            修改
                        </button>
                        <button type="button" class="layui-btn layui-btn-xs" id="reset" data-method="confirmTrans">
                            删除
                        </button>
                    </script>
                </div>
            </div>

        </div>
        <div class="layui-tab-item">
           <div id="role1">
               <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;" style="display: inline-block;">
                   <legend>学生角色管理</legend>
               </fieldset>
               <div style="display: inline-block;margin-right: 10% ;height: 400px;float:left;">
                   <div id="test2" class="demo-transfer" ></div>
               </div>
               <div style="display: inline-block;height: 400px;"> <div id="tree2"  class="demo-tree demo-tree-box" ></div></div>
               <div>
                   <button type="button" class="layui-btn">确认修改角色权限</button>
                   <button type="button" class="layui-btn layui-btn-danger">取消</button>
               </div>
           </div>
            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
                <legend>老师角色管理</legend>
            </fieldset>
            <div id="test3" class="demo-transfer" style="display: inline-block;"></div>
        </div>
    </div>
</div>
</body>
</html>