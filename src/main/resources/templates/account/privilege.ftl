<!DOCTYPE html>
<html lang="en">
<head>
    <base href="${basePath}">
    <meta charset="UTF-8">
    <title>权限管理</title>
    <link rel="stylesheet" type="text/css" href="/layui/css/layui.css"/>
    <script type="text/javascript" src="/layui/layui.js">
    </script>
    <script type="text/javascript" src="/account/js/privilege.js"></script>
</head>
<body style="position:relative;">
<div id="tree2" class="demo-tree demo-tree-box" style="padding-bottom: 50px;"></div>
<div style="text-align: left; position: fixed;bottom: 0px;background-color: #ffffff;width: 100%;">
    <button type="button" class="layui-btn layui-btn-normal  " data-method="confirmTrans"  >
        确定
    </button>
    <button type="button" class="layui-btn layui-btn-primary  " data-method="confirmTrans" >
        取消
    </button>
</div>
</body>
</html>