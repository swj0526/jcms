<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>饼状图比例分布数据</title>

    <script src="/jquery/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="js/jsapi.js"></script>
    <script type="text/javascript" src="js/corechart.js"></script>
    <script type="text/javascript" src="js/jquery.gvChart-1.0.1.min.js"></script>
    <script type="text/javascript" src="js/jquery.ba-resize.min.js"></script>
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <script type="text/javascript" src="/layui/layui.js"></script>

    <script type="text/javascript">
        gvChartInit();
        $(document).ready(function () {
            $('#myTable5').gvChart({
                chartType: 'PieChart',
                gvSettings: {
                    vAxis: {title: 'No of players'},
                    hAxis: {title: 'Month'},
                    width: 700,
                    height: 550
                }
            });
        });
    </script>

    <script type="text/javascript">
        gvChartInit();
        $(document).ready(function () {
            $('#myTable1').gvChart({
                chartType: 'PieChart',
                gvSettings: {
                    vAxis: {title: 'No of players'},
                    hAxis: {title: 'Month'},
                    width: 700,
                    height: 550
                }
            });
        });
    </script>

</head>


<body>
<div>
    <fieldset class="layui-elem-field layuimini-search">
        <legend>搜索渠道统计</legend>
        <div style="margin: 10px 10px 10px 10px">
        <div class="layui-inline">
            <label class="layui-form-label">关键字</label>
            <div class="layui-input-inline">
                <input type="text" name="username" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <a class="layui-btn  layui-btn-primary" lay-submit="" lay-filter="data-search-btn">查询</a>
        </div>
        </div>
    </fieldset>
    <table class="layui-hide" id="demo"></table>
</div>
<div style="display: inline-block">
    <table id='myTable5'>
        <caption>渠道统计</caption>
        <thead>
        <tr>
            <th></th>
            <th>个人渠道</th>
            <th>学校</th>
            <th>网络渠道</th>
            <th>介绍</th>
            <th>山东</th>
            <th>其他渠道</th>

        </tr>
        </thead>
        <tbody>
        <tr>
            <th>1000</th>
            <td>500</td>
            <td>300</td>
            <td>150</td>
            <td>180</td>
            <td>120</td>
            <td>180</td>
        </tr>
        </tbody>
    </table>
</div>

<div style="display: inline-block">
    <table id='myTable1' style="display: inline-block">
        <caption>学生性别</caption>
        <thead>
        <tr>
            <th></th>
            <th>男</th>
            <th>女</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <th>1000</th>
            <td>450</td>
            <td>550</td>
        </tr>
        </tbody>
    </table>
</div>

<script>
    layui.use('table', function () {
        var table = layui.table;

        //展示已知数据
        table.render({
            elem: '#demo'
            , cols: [[ //标题栏
                {field: 'id', title: '个人渠道', width: 180, sort: true}
                , {field: 'username', title: '学校渠道', width: 180}
                , {field: 'email', title: '网络渠道', width: 180}
                , {field: 'sign', title: '介绍渠道', width: 180}
                , {field: 'sex', title: '城市渠道', width: 180}
                , {field: 'city', title: '其他渠道', width: 180}
                , {field: 'city', title: '男', width: 180}
                , {field: 'city', title: '女', width: 180}

            ]]
            , data: [{
                "id": "100"
                , "username": "200"
                , "email": "300"
                , "sex": "400"
                , "city": "500"
                , "sign": "600"
                , "experience": "116"
                , "ip": "192.168.0.8"
                , "logins": "108"
                , "joinTime": "2016-10-14"
            },]
            //,skin: 'line' //表格风格
            , even: true
            //,page: true //是否显示分页
            //,limits: [5, 7, 10]
            //,limit: 5 //每页默认显示的数量
        });
    });
</script>


</body>

</html>
