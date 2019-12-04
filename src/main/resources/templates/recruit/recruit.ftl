<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <#--上传-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="/recruit/css/label.css">
    <link rel="stylesheet" href="/all.css">

    <style type="text/css">
        /*去除input number的 自动增加数按钮*/
        input::-webkit-outer-spin-button,
        input::-webkit-inner-spin-button {
            -webkit-appearance: none;
        }

        input[type="number"] {
            -moz-appearance: textfield;
        }

    </style>
</head>
<body>
<div class="layuimini-container">
    <div class="layuimini-main">
       <fieldset class="layui-elem-field layuimini-search">
            <div style="margin: 10px 10px 10px 10px">
                <div class="demoTable">
                <form class="layui-form layui-form-pane" action="">
                    <div class="layui-inline" style="width: 210px">
                        <label class="layui-form-label" style="width:100px">关键词</label>
                        <div class="layui-input-inline" style="width:100px ">
                            <input type="text" id="demoReload" autocomplete="off"  placeholder="姓名"class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">时间</label>
                        <div class="layui-input-inline" style="width: 100px">
                            <input type="text" name="createTime" autocomplete="off" class="layui-input" id="a">
                        </div>
                    </div>
                    <div class="layui-inline" style="width: 210px">
                        <label class="layui-form-label" style="width: 100px">性别</label>
                        <div class="layui-inline" style="width: 100px">
                            <select name="sex" lay-verify="" id="sex">
                                <option value="">请选择</option>
                                <option value="男">男</option>
                                <option value="女">女</option>
                            </select>
                        </div>
                    </div>
                    <div class="layui-inline" style="width: 210px">
                        <label class="layui-form-label" style="width: 110px">渠道</label>
                        <div class="layui-inline" style="width: 100px">
                            <select name="channelId" lay-verify="" class="decSelect" required lay-verify="required"
                                    url="/dictionary/list/channel/options" id="channelId">
                                <option value="">来源渠道</option>
                            </select>
                        </div>
                    </div>

                    <div class="layui-inline" style="width: 300px">
                        <label class="layui-form-label" style="width: 100px">意向</label>
                        <div class="layui-inline">
                            <div class="layui-inline">
                                <div id="selectcheckbox" class="xm-select-demo" required lay-verify="required" style=" width:200px";></div>
                            </div>
                        </div>
                    </div>
                    <div class="layui-inline">
                        <a class="layui-btn  layui-btn-primary" data-type="reload">查询</a>
                    </div>
                    <div class="layui-btn-group" >
                        <button class="layui-btn data-add-btn"type="button">添加</button>
                        <button class="layui-btn layui-btn-warm "type="button" id="download">导出</button>
                        <button class="layui-btn layui-btn-warm "type="button" id="upload">导入</button>
                    </div>
                </form>

                </div>
            </div>
        </fieldset>
        <#--自定义标签-->
        <div id="addlabe"style="display: none">
            <div id="labelDiv" >
                <div style="margin-bottom: 10px;"><span style="font-size: 20px">输入标签 : </span><input type="text" id="newLabel">
                    <button id="addBut" onclick="submitDiyLabel()">添加</button>
                </div>
                <div id="SelectLabelDiv">
                </div>
            </div>
        </div >
        <!-- 表格 -->
        <table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter"></table>
        <script type="text/html" id="currentTableBar">
            {{# if(d.state=="1"){ }}
            {{# } }}
            {{# if(d.state=="2"){ }}
            {{# } }}
            {{# if(d.state=="3"){ }}
            {{# } }}
            <a class="layui-btn layui-btn-xs data-count-edit" lay-event="follow">跟进详情</a>
            <a class="layui-btn layui-btn-xs data-count-edit  layui-btn-normal" lay-event="edit">修改</a>
            <a class="layui-btn layui-btn-xs layui-btn-danger data-count-delete" lay-event="delete">删除</a>
        </script>
    </div>
</div>
<div id="download1"style="display: none;width:60%;margin: 0 auto">
    <div style="margin-top: 10%">
        <p><span style="font-size: 15px;color: red">注意:请按照指定的格式上传文件,点击下载模板</span></p>
        <button class="layui-btn layui-btn-danger "type="button" >下载模板</button>
    </div>
    <div class="layui-upload"style="margin-top: 10%">

        <div class="layui-upload-list"style="width: 100%;height: 100%">
            <table class="layui-table">
                <thead>
                <tr>
                    <th>文件名</th>
                    <th>大小</th>
                    <th>状态</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody id="demoList"></tbody>
            </table>
        </div>
        <button type="button" class="layui-btn layui-btn-normal" id="testList">选择多文件</button>
        <button type="button" class="layui-btn" id="testListAction">开始上传</button>
    </div>
</div>
<script src="/layui/layui.js" charset="utf-8"></script>
<script src="/jquery/jquery-3.3.1.min.js"></script>
<#--下拉复选-->
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script src="/recruit/js/label.js"></script>
<script src="/recruit/js/xm.js"></script>
<script src="/all.js"></script>
<#--上传-->
<script src="/recruit/js/updata.js"></script>

<script src="/recruit/js/recruit.js"></script>

</body>
<script>
    sel();//动态下拉赋值

</script>
</html>
