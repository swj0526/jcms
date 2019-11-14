<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>账户列表管理</title>
    <link rel="stylesheet" type="text/css" href="/layui/css/layui.css"/>
    <script type="text/javascript" src="/layui/layui.js">
    </script>
   <#-- <script type="text/javascript" src="/account/js/listStaff.js">
    </script>-->
</head>
<body>
<div class="layuimini-container">
    <div class="layuimini-main">
        <fieldset class="layui-elem-field layuimini-search">
            <legend>搜索信息</legend>
            <div style="margin: 10px 10px 10px 10px">

            </div>
        </fieldset>

        <table class="layui-hide" id="test1" lay-filter="test1"></table>
        <script type="text/html" id="checkboxTpl1">
            <!-- 这里的 checked 的状态只是演示 -->
            <input type="checkbox" name="lock1" value="{{d.id}}" title="激活" lay-filter="lockDemo1" {{ d.id == 10006 ? 'checked' : '' }}>
        </script>
        <script type="text/html" id="barDemo1">
            <button type="button" class="layui-btn layui-btn-xs" id="reset1"  data-method="confirmTrans">重置密码</button>

        </script>
    </div>
</div>
</body>
</html> 