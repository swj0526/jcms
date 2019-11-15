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
    <script>
        //注意：选项卡 依赖 element 模块，否则无法进行功能性操作
        layui.use('element', function(){
            var element = layui.element;

            //…
        });

        //注意：选项卡 依赖 element 模块，否则无法进行功能性操作
        layui.use('element', function(){
            var element = layui.element;

            //…
        });

        layui.use('table', function(){
            var table = layui.table;

            table.render({
                elem: '#test',
                data: [{
                    "username": "定金",
                    "sex": "微信",
                    "city": "100",
                    "sign": "2019-10-1",
                    "experience": "否",
                    "logins": 0,
                    "classify": "2019-10-1",
                    "score": 57
                }]
                ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
                ,cols: [[
                    {field:'username', title: '缴费类型'}
                    ,{field:'sex',  title: '缴费方式'}
                    ,{field:'city',  title: '金额'}
                    ,{field:'sign', title: '缴费日期', } //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
                    ,{field:'experience', title: '是否一次性缴费'}
                    ,{field:'score', title: '优惠金额'}
                    ,{field:'classify', title: '费用有效期'}

                ]]
            });
            table.render({
                elem: '#information',
                data: [{
                    "banji": "影视一班",
                    "shiyou": "打架斗殴",
                    "jiajian": "加分",
                    "fenshu": "5",
                    "time": "2019-10-1",
                }]
                ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
                ,cols: [[
                    {field:'banji', title: '班级'}
                    ,{field:'shiyou',  title: '事由'}
                    ,{field:'jiajian',  title: '加减'}
                    ,{field:'fenshu',  title: '分数'}
                    ,{field:'time',  title: '时间'}
                ]]
            });
        });
    </script>
</head>
<body>
<!-- 第一层tab************************* -->
<div class="layui-tab "lay-allowClose="true">
    <ul class="layui-tab-title">
        <li class="layui-this">张三</li>
    </ul>
    <div class="layui-tab-content">
        <!-- 第二层tab***************************** -->
        <div class="layui-tab-item layui-show">
            <div class="layui-tab">
                <ul class="layui-tab-title">
                    <li class="layui-this">基本信息</li>
                    <li>缴费信息</li>
                    <li>积分信息</li>
                </ul>
                <div class="layui-tab-content">
                    <!-- 基本细腻 ********************************-->
                    <div class="layui-tab-item layui-show">
                        <table border="1" width="650" height="680" align="center" cellspacing="0">
                            <caption>学生档案</caption>
                            <tr align="center">
                                <td bgcolor="#ededed">姓名</td>
                                <td>张三</td>
                                <td bgcolor="#ededed">年龄</td>
                                <td>18</td>
                                <td bgcolor="#ededed">性别</td>
                                <td>男</td>
                                <td colspan="2" rowspan="3"><img src="../images/logo.png" width="100px" height="100px"></td>
                            </tr>
                            <tr align="center">
                                <td bgcolor="#ededed">民族</td>
                                <td>汉</td>
                                <td bgcolor="#ededed">手机号</td>
                                <td>18556454545</td>
                                <td bgcolor="#ededed">在校状态</td>
                                <td>在校</td>
                            </tr>
                            <tr align="center">
                                <td bgcolor="#ededed">父亲手机号</td>
                                <td>18666666666</td>
                                <td bgcolor="#ededed">母亲手机号</td>
                                <td>18655555555</td>
                                <td bgcolor="#ededed">其他亲属</td>
                                <td>18555222234</td>
                            </tr>
                            <tr align="center">
                                <td bgcolor="#ededed">籍贯</td>
                                <td colspan="7">山东省威海市**县**镇**小区</td>
                            </tr>
                            <tr align="center">
                                <td bgcolor="#ededed">现住址</td>
                                <td colspan="7">威海</td>
                            </tr>
                            <tr align="center">
                                <td bgcolor="#ededed">身份证号</td>
                                <td colspan="7">222245565656858545</td>
                            </tr>
                            <tr align="center">
                                <td bgcolor="#ededed">爱好</td>
                                <td colspan="7">打游戏，吃饭，睡觉</td>
                            </tr>
                            <tr align="center">
                                <td bgcolor="#ededed">特长</td>
                                <td colspan="7">无</td>
                            </tr>
                            <tr align="center">
                                <td bgcolor="#ededed">老师评价</td>
                                <td colspan="7">这孩子不错</td>
                            </tr>
                        </table>



                    </div>
                    <!-- 缴费信息 ***********************************-->
                    <div class="layui-tab-item">
                        <table class="layui-hide" id="test"></table>

                    </div>
                    <!-- 积分信息 **********************************-->
                    <div class="layui-tab-item">
                        <table class="layui-hide" id="information"></table>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
