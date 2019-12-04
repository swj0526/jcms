<!DOCTYPE html>
<html lang="en">
<head>
    <base href="${basePath}">
    <meta charset="UTF-8">
    <title>列表页</title>
    <#include "../common/common.ftl"/>
</head>
<body>

<div style="padding: 5px;">
    <fieldset class="layui-elem-field " style="padding: 5px;">
        <form class="layui-form layui-form-pane" action="">
            <div class="layui-form-item">
                    <label class="layui-form-label">关键词</label>
                    <div class="layui-input-inline">
                        <input type="text" name="keywords" lay-verify="keywords" autocomplete="off"
                               placeholder="根据实际情况提示" class="layui-input">
                    </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">爱好</label>
                <div class="layui-input-inline">
                    <select name="interest" lay-filter="aihao">
                        <option value=""></option>
                        <option value="0">写作</option>
                        <option value="1" selected="">阅读</option>
                        <option value="2">游戏</option>
                        <option value="3">音乐</option>
                        <option value="4">旅行</option>
                    </select>
                </div>
            </div>
        </form>
    </fieldset>


</div>
</body>
<script type="text/javascript" src="/common/js/list.js"></script>
</html>