<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>jQuery饼状图比例分布数据显示代码</title>

<script src="/jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="js/jsapi.js"></script>
<script type="text/javascript" src="js/corechart.js"></script>
<script type="text/javascript" src="js/jquery.gvChart-1.0.1.min.js"></script>
<script type="text/javascript" src="js/jquery.ba-resize.min.js"></script>

<script type="text/javascript">
gvChartInit();
$(document).ready(function(){
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
$(document).ready(function(){
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
	<div style="width:600px;margin:0 auto;">
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

	   <table id='myTable1'>
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


</body>
</html>
