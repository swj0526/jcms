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
    <link rel="stylesheet" href="/recruit/css/label.css">
    <script src="/jquery/jquery-3.3.1.min.js"></script>
    <script src="/recruit/js/label.js"></script>

</head>
<body>

<#--新增信息弹出框-->
<div style="display: none" id="recruit">
    <form class="layui-form" action="" lay-filter="dataForm" id="dataFor">
        <div class="layui-form-item">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-inline">
            <input type="text" name="name"  lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
            </div>

            <label class="layui-form-label">性别</label>
            <div class="layui-inline">
                <div class="layui-inline" style="width: 190px">
                    <select name="sex" lay-verify="">
                        <option value=""></option>
                        <option value="0">男</option>
                        <option value="1">女</option>
                    </select>
                </div>
            </div>
        </div>

        <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">出生年月</label>
            <div class="layui-input-inline">
                <input type="text" name="age" id="date" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
            </div>
        </div>

            <label class="layui-form-label">学校</label>
            <div class="layui-input-inline">
                <input type="text" name="title" required  lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">手机号</label>
            <div class="layui-input-inline">
                <input type="text" name="title" required  lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
            </div>
            <label class="layui-form-label">QQ号</label>
            <div class="layui-input-inline">
                <input type="text" name="title" required  lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">微信号</label>
            <div class="layui-input-inline">
                <input type="text" name="title" required  lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
            </div>
            <label class="layui-form-label">家长电话</label>
            <div class="layui-input-inline">
                <input type="text" name="title" required  lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">来源渠道</label>
            <div class="layui-input-inline">
                <div class="layui-inline">
                    <select name="city" lay-verify="">
                        <option value="">来源渠道</option>
                        <option value="010">学校网站</option>
                        <option value="021">自己找上门</option>
                        <option value="0571">qq</option>
                        <option value="0571">微信</option>
                        <option value="0571">介绍</option>
                    </select>
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">意向</label>
                <div class="layui-inline" style="width: 190px">
                    <div id="demo1" class="xm-select-demo" style=" width:190px";></div>
                </div>
            </div>
            <div class="layui-inline">
                <div class="layui-inline" style="width:50px">
                   <button class="layui-btn layui-btn-normal" id="addtab01">添加标签</button>
                </div>
            </div>
            <label class="layui-form-label">录入时间</label>
            <div class="layui-input-inline">
                <input type="text" name="age" id="dat" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">            </div>

        </div>
        <div class="layui-form-item" style="margin-left: 30%">
            <div class="layui-input-inline">
                <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>
<div class="layuimini-container">
    <div class="layuimini-main">
        <fieldset class="layui-elem-field layuimini-search">
            <legend>搜索信息</legend>
            <div style="margin: 10px 10px 10px 10px">
                <form class="layui-form layui-form-pane" action="">
                    <div class="layui-form-item">
                        <div class="layui-inline" style="width: 210px">
                            <label class="layui-form-label" style="width:100px">关键词</label>
                            <div class="layui-input-inline" style="width:100px ">
                                <input type="text" name="username" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">跟进时间</label>
                            <div class="layui-input-inline">
                                <input type="text" name="city" autocomplete="off" class="layui-input" id="a">
                            </div>
                        </div>
                        <div class="layui-inline" style="width: 210px">
                            <label class="layui-form-label" style="width: 100px">性别</label>

                                <div class="layui-inline" style="width: 100px">
                                    <select name="sex" lay-verify="">
                                        <option value="">男</option>
                                        <option value="">女</option>
                                    </select>
                                </div>
                        </div>
                        <div class="layui-inline">
                            <select name="city" lay-verify="">
                                <option value="">来源渠道</option>
                                <option value="010">学校网站</option>
                                <option value="021">自己找上门</option>
                                <option value="0571">qq</option>
                                <option value="0571">微信</option>
                                <option value="0571">介绍</option>
                            </select>
                        </div>
                        <div class="layui-inline">
                            <a class="layui-btn" lay-submit="" lay-filter="data-search-btn">查询</a>
                        </div>
                        <div class="layui-btn-group" >
                            <button class="layui-btn data-add-btn"type="button">添加学生信息</button>
                            <button class="layui-btn layui-btn-danger "type="button" id="download">导出学生信息</button>
                            <button class="layui-btn layui-btn-danger "type="button" id="upload">导入学生信息</button>
                        </div>
                    </div>

                </form>

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
            <a class="layui-btn layui-btn-xs data-count-edit" lay-event="follow">跟进详情</a>
            <a class="layui-btn layui-btn-xs data-count-edit" lay-event="edit">修改</a>
            <a class="layui-btn layui-btn-xs layui-btn-danger data-count-delete" lay-event="delete">删除</a>
        </script>
    </div>
</div>

<div id="download1"style="height: 250px;display: none">
    <p><span style="font-size: 20px;color: red">注意导入时请按照指定的格式模板上传文件,点击下载模板按钮</span></p>
    <button class="layui-btn layui-btn-danger "type="button" >下载模板</button>
    <button class="layui-btn  "type="button" >上传文件</button>
</div>


<script src="../../layui/layui.js" charset="utf-8"></script>
<script src="../../recruit/js/recruit.js"></script>
<script src="/recruit/js/xm.js" type="text/javascript"></script>
<script>
    var demo1 = xmSelect.render({
        el: '#demo1',
        language: 'zn',
        data: [
            {name: '有意向', value: 1},
            {name: '还在考虑', value: 2},
            {name: '完全不考虑', value: 3},
            {name: '不太明确', value: 4},
            {name: '完全没有', value: 5},
        ]
    })
    /* document.getElementById('demo1-getValue').onclick = function(){
        //获取当前多选选中的值
        var selectArr = demo1.getValue();
        document.getElementById('demo1-value').innerHTML = JSON.stringify(selectArr, null, 2);
    }*/
</script>
</body>
</html>
