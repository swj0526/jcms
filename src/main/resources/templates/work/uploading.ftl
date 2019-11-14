<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../layui/css/layui.css"/>
    <script type="text/javascript" src="../layui/layui.js"></script>
    <script type="text/javascript" src="../work/js/uploading.js"></script>
</head>
<body>
<div class="layui-upload" style="text-align: center">
    <button class="layui-btn layui-btn-normal" id="testList" type="button" >选择上传文件</button>
    <div class="layui-upload-list">
        <table class="layui-table">
            <thead>
            <tr><th>文件名</th>
                <th>大小</th>
                <th>状态</th>
                <th>操作</th>
            </tr></thead>
            <tbody id="demoList"></tbody>
        </table>
    </div>
    <button class="layui-btn" id="testListAction" type="button">开始上传</button>
</div>
</body>
</html>