<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>经费申请</title>
    <link rel="stylesheet" type="text/css" href="../layui/css/layui.css">
    <link rel="stylesheet" href="../flow/css/ystep.css">
    <script type="text/javascript" src="../jquery/jquery.min.js"></script>
    <script type="text/javascript" src="../layui/layui.js"></script>
    <script type="text/javascript" src="../flow/js/funds.js"></script>
    <script type="text/javascript" src=../flow/js/setStep.js></script>
</head>
<body>
<#--条件查询-->
<div class="layui-form-item">
    <fieldset class="layui-elem-field layuimini-search">
        <legend>添加信息</legend>
        <div style="margin: 10px 10px 10px 10px">
    <form class="layui-form layui-form-pane" action="">
        <div class="layui-inline">
            <label class="layui-form-label">关键词</label>
            <div class="layui-input-inline">
                <input name="email" class="layui-input" type="text" autocomplete="off" lay-verify="email">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label" style="width:80px">状态</label>
            <div class="layui-input-inline" style="width:130px">
                <select name="modules" lay-search="" lay-verify="required">
                    <option value="">所有状态</option>
                    <option value="1">待审核</option>
                    <option value="1">已撤销</option>
                    <option value="1">一审通过</option>
                    <option value="1">一审拒绝</option>
                    <option value="1">二审拒绝</option>
                    <option value="1">同意</option>
                </select>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">日期范围</label>
            <div class="layui-input-inline">
                <input class="layui-input" id="test6" type="text" placeholder=" - ">
            </div>
        </div>
        <button class="layui-btn" data-type="reload">查询</button>
        <button id="add" class="layui-btn" data-type="reload" type="button">经费申请</button>

    </form>
        </div>
    </fieldset>
</div>

<#--数据表格-->
<table class="layui-hide" id="test" lay-filter="test"></table>
<br><br>
<#--经费申请详情-->
<div style="display: none" id="updateOrDelete">
    <div >
        <div class="stepCont stepCont1" style="width: 1600px">
            <!-- 菜单导航显示-->
            <div class='ystep-container ystep-lg ystep-blue' ></div>
            <!-- 分页容器-->
            <div class="pageCont">
                <div id="page1" class="stepPage">
                    <table border="1" width="300" height="500" align="center" cellspacing="0">
                        <caption>学生档案</caption>
                        <tr align="center">
                            <td bgcolor="#ededed">姓名</td>
                            <td colspan="7">张三</td>
                        </tr>
                        <tr align="center">
                            <td bgcolor="#ededed">年级</td>
                            <td colspan="7">影视一班</td>
                        </tr>
                        <tr align="center">
                            <td bgcolor="#ededed">申请事由</td>
                            <td colspan="7">团建</td>
                        </tr>
                        <tr align="center">
                            <td bgcolor="#ededed">申请金额</td>
                            <td colspan="7">3000</td>
                        </tr>
                        <tr align="center">
                            <td bgcolor="#ededed">申请日期</td>
                            <td colspan="7">2016-10-15</td>
                        </tr>
                        <tr align="center">
                            <td bgcolor="#ededed">开始日期</td>
                            <td colspan="7">2016-10-18</td>
                        </tr>
                        <tr align="center">
                            <td bgcolor="#ededed">状态</td>
                            <td colspan="7">拒绝</td>
                        </tr>
                        <tr align="center">
                            <td bgcolor="#ededed">拒绝理由</td>
                            <td colspan="7">拒绝</td>
                        </tr>
                    </table>
                </div>
                <div id="page2" class="stepPage">
                    <h1>
                        page2
                    </h1>
                </div>
                <div id="page3" class="stepPage">
                    <h1>
                        page3
                    </h1>
                </div>
            </div>
        </div>
    </div>
</div>

<#--添加经费审批-->
<div style="display: none" id="aaa">
    <fieldset class="layui-elem-field layuimini-search">
        <legend>查询经费申请</legend>
        <div style="margin: 10px 10px 10px 10px">
            <form class="layui-form  layui-form-pane" action="">

                <div class="layui-form-item">
                    <label class="layui-form-label">申请人</label>
                    <div class="layui-input-inline">
                        <input type="text" name="title" required lay-verify="required" placeholder="请输入申请人姓名"
                               autocomplete="off"
                               class="layui-input" id="xname">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">申请事由</label>
                    <div class="layui-input-block">
                        <textarea class="layui-textarea" name="cause" placeholder="请输入申请事由"></textarea>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">申请金额</label>
                    <div class="layui-input-inline">
                        <input type="text" name="title" required lay-verify="required" placeholder="请输入申请金额"
                               autocomplete="off"
                               class="layui-input" id="age">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">申请日期</label>
                    <div class="layui-input-inline">
                        <input class="layui-input" id="test1" type="text" placeholder="yyyy-MM-dd">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">开始日期</label>
                    <div class="layui-input-inline">
                        <input class="layui-input" id="test5" type="text" placeholder="yyyy-MM-dd HH:mm:ss">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">结束日期</label>
                    <div class="layui-input-inline">
                        <input class="layui-input" id="test7" type="text" placeholder="yyyy-MM-dd HH:mm:ss">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit lay-filter="formDemo" id="student">立即提交</button>
                    </div>
                </div>
            </form>
        </div>
    </fieldset>
</div>
<script>
    //JavaScript代码区域
    layui.use('element', function () {
        var element = layui.element;
    });
</script>
<script>
    var step1=new SetStep({
        content:'.stepCont1',
        showBtn:false,
    })
    var step2=new SetStep({
        content:'.stepCont2',
        clickAble:false
    })
    var step3=new SetStep({
        content:'.stepCont3'
    })
</script>
<script id="barDemo" type="text/html">
    <a class="layui-btn layui-btn-xs" lay-event="edit">查看详细</a>
    <a class="layui-btn layui-btn-xs" lay-event="revoke">撤销</a>
    <a class="layui-btn layui-btn-xs" lay-event="again">重新提交</a>
    <a class="layui-btn layui-btn-xs" lay-event="del">删除</a>
</script>

</body>
</html>
