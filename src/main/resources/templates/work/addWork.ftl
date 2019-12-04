<!DOCTYPE html>
<html lang="en">
<head>
    <base href="${basePath}">
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" type="text/css" href="/static/common/css/all.css"/>
    <script type="text/javascript" src="/layui/layui.js"></script>
    <script type="text/javascript" src="/static/common/js/all.js"></script>
    <script type="text/javascript" src="/work/js/addWork.js"></script>
</head>
<body>

<form class="layui-form layui-form-pane" id="dataFor">
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">作业名称<span class="star">*</span></label>
            <div class="layui-input-inline">
                <input type="text" name="name"  lay-verify="required" autocomplete="off" class="layui-input" placeholder="请输入作业名称">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">专业班级<span class="star">*</span></label>

            <div class="layui-input-inline">
                <div class="layui-inline">
                    <select name="majorId" lay-verify="required" id="gradeSelect"
                            url="/major/list/select">
                        <option value="">请选择</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">截止时间<span class="star">*</span></label>
            <div class="layui-input-inline">
                <input class="layui-input"   lay-verify="required"  name="endTime"  id="test2" type="text" placeholder="请选择截止时间">
            </div>
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">作业内容<span class="star">*</span></label>
        <div class="layui-input-block">
            <textarea name="content" placeholder="请输入内容" class="layui-textarea"  lay-verify="required"></textarea>
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">备注</label>
        <div class="layui-input-block">
            <textarea name="remark" placeholder="请输入备注" class="layui-textarea"></textarea>
        </div>
    </div>
    <div class="layui-upload" id="up" style="text-align: center">
        <div style="text-align: left">
            <button class="layui-btn layui-btn-normal" id="testList" type="button">选择多文件</button>
            <button class="layui-btn layui-btn-warm" id="testListAction" type="button">开始上传</button>
        </div>
        <div class="layui-upload-list">
            <table class="layui-table">
                <thead>
                <tr>
                    <th>文件名</th>
                    <th>大小</th>
                    <th>状态</th>
                    <th>状态</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody id="demoList"></tbody>
            </table>
        </div>
        <div class="layui-progress layui-progress-big" lay-filter="demo" lay-showPercent="yes"
             style="margin-top: 20px">
            <div class="layui-progress-bar layui-bg-red" lay-percent="0%"></div>
        </div>
    </div>
    <div style="margin-top: 10px;">
        <button lay-submit="" type="button" class="layui-btn" id="submit">提交
        </button>
    </div>
</form>


</body>
<script>
    sel_garade();
</script>
</html>