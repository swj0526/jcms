<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/layui/css/layui.css"/>
    <script type="text/javascript" src="/layui/layui.js"></script>
    <script type="text/javascript" src="/work/js/addWork.js"></script>
</head>
<body>
<fieldset class="layui-elem-field layuimini-search">
    <legend>作业管理</legend>
    <div style="margin: 10px 10px 10px 10px;">
        <form class="layui-form layui-form-pane" lay-filter="dataForm" id="dataFor">
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">作业名称</label>
                    <div class="layui-input-inline">
                        <input type="text" name="workname" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">发布年级</label>
                    <div class="layui-inline" style="width: 190px">
                        <select lay-verify="" name="grade" id="grade">
                            <option value="一年级">一年级</option>
                            <option value="二年级">二年级</option>
                            <option value="三年级">三年级</option>
                        </select>
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">发布日期</label>
                    <div class="layui-input-inline">
                        <input class="layui-input" name="date" id="test1" type="text" placeholder="yyyy-MM-dd">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">截止时间</label>
                    <div class="layui-input-inline">
                        <input class="layui-input" name="Validity" id="test2" type="text" placeholder="yyyy-MM-dd">
                    </div>
                </div>
            </div>
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">作业内容</label>
                <div class="layui-input-block">
                    <textarea name="desc" placeholder="请输入内容" class="layui-textarea"></textarea>
                </div>
            </div>
        </form>
        <div class="layui-upload" id="up" style="text-align: center">
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
            <textarea name="" required lay-verify="required" placeholder="备注" class="layui-textarea"
                      style="height: 100px"></textarea>
            <button class="layui-btn layui-btn-normal" id="testList" type="button">选择多文件</button>

            <button class="layui-btn" id="testListAction" type="button">开始上传</button>
            <div class="layui-progress layui-progress-big" lay-filter="demo" lay-showPercent="yes"
                 style="margin-top: 20px">
                <div class="layui-progress-bar layui-bg-red" lay-percent="0%"></div>
            </div>
        </div>
        <div style="text-align: center">
            <button type="button" class="layui-btn" id="ss"
                    style="padding-left: 10px;padding-right: 10px;width: 70px;">提交
            </button>
        </div>
    </div>
</fieldset>
</body>
</html>