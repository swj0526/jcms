<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../../layui/css/layui.css" media="all">
    <link rel="stylesheet" href="../../layui/css/public.css" media="all">


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
                    <div id="demo1" class="xm-select-demo" style=" width: 18.75rem";></div>
                    <select name="sex" lay-verify="">
                        <option value=""></option>
                        <option value="0">有</option>
                        <option value="1">无</option>
                    </select>
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
                        <div class="layui-inline">
                            <label class="layui-form-label">关键词</label>
                            <div class="layui-input-inline">
                                <input type="text" name="username" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">跟进时间</label>
                            <div class="layui-input-inline">
                                <input type="text" name="city" autocomplete="off" class="layui-input" id="a">
                            </div>
                        </div>

                        <div class="layui-inline">
                            <label class="layui-form-label">性别</label>
                            <div class="layui-input-inline">
                                <div class="layui-inline">
                                    <select name="sex" lay-verify="">
                                        <option value="">男</option>
                                        <option value="">女</option>

                                    </select>
                                </div>
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
                    </div>
                </form>


                <div id="demo1" class="xm-select-demo"></div>
                <button class="btn" id="demo1-getValue">获取选中值</button>
                <pre id="demo1-value"></pre>


                <div class="layui-btn-group" style="position: relative;left: 75%">
                    <button class="layui-btn data-add-btn">添加学生信息</button>
                    <button class="layui-btn layui-btn-danger data-delete-btn">导出学生信息</button>
                    <button class="layui-btn layui-btn-danger data-delete-btn">导入学生信息</button>
                </div>
            </div>
        </fieldset>

        <!-- 表格 -->
        <table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter"></table>
        <script type="text/html" id="currentTableBar">
            <a class="layui-btn layui-btn-xs data-count-edit" lay-event="follow">跟进详情</a>
            <a class="layui-btn layui-btn-xs data-count-edit" lay-event="edit">修改</a>
            <a class="layui-btn layui-btn-xs layui-btn-danger data-count-delete" lay-event="delete">删除</a>
        </script>
    </div>
</div>

<script src="../../layui/layui.js" charset="utf-8"></script>
<script src="../../recruit/js/recruit.js"></script>
<script src="/recruit/js/xm.js" type="text/javascript"></script>
<script>
    var demo1 = xmSelect.render({
        el: '#demo1',
        language: 'zn',
        data: [
            {name: '张三', value: 1},
            {name: '李四', value: 2},
            {name: '王五', value: 3},
        ]
    })

     document.getElementById('demo1-getValue').onclick = function(){
        //获取当前多选选中的值
        var selectArr = demo1.getValue();
        document.getElementById('demo1-value').innerHTML = JSON.stringify(selectArr, null, 2);
    }
</script>
</body>
</html>
