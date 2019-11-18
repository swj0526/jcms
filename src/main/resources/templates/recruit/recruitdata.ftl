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
	layui.use('table', function(){
		var table = layui.table;

		//展示已知数据
		table.render({
			elem: '#demo'
			,cols: [[ //标题栏
				{field: 'id', title: '个人', width: 180, sort: true}
				,{field: 'username', title: '学校', width: 180}
				,{field: 'email', title: '网络', width: 180}
				,{field: 'sign', title: '介绍', width: 180}
				,{field: 'sex', title: '城市', width: 180}
				,{field: 'city', title: '其他渠道', width: 180}

			]]
			,data: [{
				"id": "某某某"
				,"username": "杜甫"
				,"email": "xianxin@layui.com"
				,"sex": "男"
				,"city": "浙江杭州"
				,"sign": "人生恰似一场修行"
				,"experience": "116"
				,"ip": "192.168.0.8"
				,"logins": "108"
				,"joinTime": "2016-10-14"
			}, {
				"id": "某某某"
				,"username": "李白"
				,"email": "xianxin@layui.com"
				,"sex": "男"
				,"city": "浙江杭州"
				,"sign": "人生恰似一场修行"
				,"experience": "12"
				,"ip": "192.168.0.8"
				,"logins": "106"
				,"joinTime": "2016-10-14"
				,"LAY_CHECKED": true
			}, {
				"id": "某某某"
				,"username": "王勃"
				,"email": "xianxin@layui.com"
				,"sex": "男"
				,"city": "浙江杭州"
				,"sign": "人生恰似一场修行"
				,"experience": "65"
				,"ip": "192.168.0.8"
				,"logins": "106"
				,"joinTime": "2016-10-14"
			}]
			//,skin: 'line' //表格风格
			,even: true
			//,page: true //是否显示分页
			//,limits: [5, 7, 10]
			//,limit: 5 //每页默认显示的数量
		});
	});
</script>


</body>

</html>
