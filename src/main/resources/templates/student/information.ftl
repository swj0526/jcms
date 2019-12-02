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
    <script src="/student/js/information.js"></script>
</head>
<body>
<div class="layui-tab-content" style="background-color: #ffffff">
    <!-- 第二层tab***************************** -->
    <div class="layui-tab-item layui-show">
        <div class="layui-tab">
            <ul class="layui-tab-title">
                <li class="layui-this">基本信息</li>
                <li>缴费信息</li>
                <li>积分信息</li>
                <li>请假信息</li>
                <li>作业信息</li>
            </ul>
            <div class="layui-tab-content">
                <!-- 基本细腻 ********************************-->
                <div class="layui-tab-item layui-show">
                    <table border="1" width="650" height="680" align="center" cellspacing="0">
                        <caption>学生档案</caption>
                        <tr align="center">
                            <td bgcolor="#ededed">姓名</td>
                            <td>${student.name!''}</td>
                            <td bgcolor="#ededed">年龄</td>
                            <td>18</td>
                            <td bgcolor="#ededed">性别</td>
                            <td>${student.sex!''}</td>
                            <td colspan="2" rowspan="3"><img src="../images/logo.png" width="100px" height="100px"></td>
                        </tr>
                        <tr align="center">
                            <td bgcolor="#ededed">民族</td>
                            <td>汉</td>
                            <td bgcolor="#ededed">手机号</td>
                            <td>${student.studentPhone!''}</td>
                            <td bgcolor="#ededed">在校状态</td>
                            <td>在校</td>
                        </tr>
                        <tr align="center">
                            <td bgcolor="#ededed">父亲手机号</td>
                            <td>${student.fatherName!''}</td>
                            <td bgcolor="#ededed">母亲手机号</td>
                            <td>${student.motherPhone!''}</td>
                            <td bgcolor="#ededed">其他亲属</td>
                            <td>${student.emergencyPhone!''}</td>
                        </tr>
                        <tr align="center">
                            <td bgcolor="#ededed">籍贯</td>
                            <td colspan="7">${student.nativePlace!''}</td>
                        </tr>
                        <tr align="center">
                            <td bgcolor="#ededed">现住址</td>
                            <td colspan="7">${student.address!''}</td>
                        </tr>
                        <tr align="center">
                            <td bgcolor="#ededed">身份证号</td>
                            <td colspan="7">${student.IDCard!''}</td>
                        </tr>
                        <tr align="center">
                            <td bgcolor="#ededed">爱好</td>
                            <td colspan="7">${student.hobby!''}</td>
                        </tr>
                        <tr align="center">
                            <td bgcolor="#ededed">特长</td>
                            <td colspan="7">${student.speciality}</td>
                        </tr>
                        <tr align="center">
                            <td bgcolor="#ededed">老师评价</td>
                            <td colspan="7">${student.comment}</td>
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
                <#--                    请假信息-->
                <div class="layui-tab-item">
                    <table class="layui-hide" id="leaveInformation"></table>

                </div>
                <#--                    作业信息-->
                <div class="layui-tab-item">
                    <table class="layui-hide" id="workInformation"></table>

                </div>

            </div>
        </div>
    </div>
</div>
</body>
</html>
