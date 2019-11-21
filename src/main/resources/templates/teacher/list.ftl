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
    <script src="/teacher/js/list.js"></script>
</head>
<body>
<#--添加-->
<div id="add" style="display: none">
        <div style="margin: 10px 10px 10px 10px">
            <form class="layui-form layui-form-pane" lay-filter="dataForm"  id="dataFrm">
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">姓名</label>
                        <div class="layui-input-inline">
                            <input type="text" name="name" autocomplete="off" class="layui-input" id="name">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">手机号</label>
                        <div class="layui-input-inline">
                            <input type="text" name="phone" autocomplete="off" class="layui-input" id="phone">
                        </div>
                    </div>
                    <#--<div class="layui-inline">
                        <label class="layui-form-label">状态</label>
                        <div class="layui-input-inline">
                            <select name="modules" lay-search="" lay-verify="required">
                                <option value="">所有状态</option>
                                <option value="1">在职</option>
                                <option value="2">离职</option>
                            </select>
                        </div>
                    </div>-->
                    <div class="layui-inline">
                        <label class="layui-form-label">性别</label>
                        <div class="layui-input-inline">
                            <select name="gender" lay-verify="" id="gender">
                                <option value="">选择性别</option>
                                <option value="男">男</option>
                                <option value="女">女</option>
                            </select>
                        </div>
                    </div>
                </div>
                <button type="button" class="layui-btn" id="addTeacher">提交</button>
            </form>
        </div>
</div>
<#--修改-->
<div id="modify1" style="display: none">
        <div style="margin: 10px 10px 10px 10px">
            <form class="layui-form layui-form-pane" lay-filter="dataForm" id="dataFrm">
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">姓名</label>
                        <div class="layui-input-inline">
                            <input type="text" name="name" autocomplete="off" class="layui-input" id="name">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">手机号</label>
                        <div class="layui-input-inline">
                            <input type="text" name="phone" autocomplete="off" class="layui-input" id="phone">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">状态</label>
                        <div class="layui-input-inline">
                            <select name="modules" lay-search="" lay-verify="required">
                                <option value="">所有状态</option>
                                <option value="1">在职</option>
                                <option value="2">离职</option>
                            </select>
                        </div>
                    </div>
                </div>
                <button type="button" class="layui-btn" id="modifyTeacher">提交</button>
            </form>
        </div>
</div>

<div style="display: none" id="importForm" >
    <blockquote class="layui-elem-quote layui-quote-nm">请下载excel文件按照文件格式填写内容后上传</blockquote>
    <div class="layui-upload">
        <button type="button" class="layui-btn layui-btn-normal" id="testList">选择多文件</button>
        <button type="button" class="layui-btn" id="testListAction">开始上传</button>
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
    </div>
</div>
<#--添加弹窗-->
<div class="layuimini-container">
    <div class="layuimini-main">
        <fieldset class="layui-elem-field layuimini-search">
            <div style="margin: 10px 10px 10px 10px">
                <form class="layui-form layui-form-pane" action="">
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">关键词</label>
                            <div class="layui-input-inline">
                                <input type="text" name="username" autocomplete="off" class="layui-input"
                                       placeholder="例：1990/张三">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <select name="state" lay-verify="">
                                <option value="">选择状态</option>
                                <option value="010">在任</option>
                                <option value="021">离职</option>
                            </select>
                        </div>
                        <div class="layui-inline">
                            <a class="layui-btn" lay-submit="" lay-filter="data-search-btn">查询</a>
                        </div>
                        <div class="layui-btn-group">
                            <button type="button" class="layui-btn" id="add1">添加</button>
                            <button type="button"class="layui-btn layui-btn-warm"  id="import">导入</button>
                            <button type="button"class="layui-btn layui-btn-warm" >导出</button>
                        </div>
                    </div>
                </form>
            </div>
        </fieldset>
        <#--数据表格-->
        <table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter"></table>
        <script type="text/html" id="currentTableBar">
            <a class="layui-btn layui-btn-normal layui-btn-xs data-count-edit" lay-event="edit">修改</a>
        </script>
    </div>
</div>


</body>
</html>
