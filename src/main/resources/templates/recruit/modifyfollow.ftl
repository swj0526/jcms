<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<link rel="stylesheet" href="/layui/css/layui.css" media="all">
		<script src="/layui/layui.js" charset="utf-8"></script>
	</head>
	<body>
		<div class="layui-row layui-col-space10">
			<div class="layui-col-md6">
				<div>
				<table class="layui-hide" id="demo"></table>
				<script>
					layui.use('table', function(){
  var table = layui.table;
  
  //展示已知数据
  table.render({
    elem: '#demo'
    ,cols: [[ //标题栏
      {field: 'id', title: '跟进时间', width: 100, sort: true}
      ,{field: 'username', title: '跟进状态', width: 120}
      ,{field: 'email', title: '跟进渠道', width: 80}
      ,{field: 'sign', title: '备注', minWidth: 100}



    ]]
    ,data: [{
      "id": "10001"
      ,"username": "第一阶段"
      ,"email": "xianxin@layui.com"
      ,"sex": "男"
      ,"city": "浙江杭州"
      ,"sign": "人生恰似一场修行"
      ,"experience": "116"
      ,"ip": "192.168.0.8"
      ,"logins": "108"
      ,"joinTime": "2016-10-14"
    }, {
      "id": "10002"
      ,"username": "第二阶段"
      ,"email": "xianxin@layui.com"
      ,"sex": "男"
      ,"city": "浙江杭州"
      ,"sign": "人生恰似一场修行"
      ,"experience": "12"
      ,"ip": "192.168.0.8"
      ,"logins": "106"
      ,"joinTime": "2016-10-14"
      ,"LAY_CHECKED": true
    }]
    //,skin: 'line' //表格风格
    ,even: true
    //,page: true //是否显示分页
    //,limits: [5, 7, 10]
    //,limit: 5 //每页默认显示的数量
  });
});
</script></div>
			</div>
			<div class="layui-col-md6">
				<div style="border:red solid 0.0625rem;width:50%;padding:3.125rem; background: rgb(242,242,242);">
					<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
						<legend>添加跟进记录</legend>
					</fieldset>
				
				<form class="layui-form" action="">
					<div class="layui-form-item">
						<label class="layui-form-label">跟进时间</label>
						<div class="layui-input-inline">
							<input type="text" name="title" required lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">跟进状态</label>
						<div class="layui-input-inline">
							<input type="password" name="password" required lay-verify="required" placeholder="请输入" autocomplete="off"
							 class="layui-input">
						</div>
						
					</div>
				<#--	<div class="layui-form-item">
						<label class="layui-form-label">来源渠道</label>
						<div class="layui-input-inline">
							<select name="city" lay-verify="required">
								<option value=""></option>
								<option value="0">北京</option>
								<option value="1">上海</option>
								<option value="2">广州</option>
								<option value="3">深圳</option>
								<option value="4">杭州</option>
							</select>
						</div>
					</div>-->
					<div class="layui-form-item">
						<label class="layui-form-label">备注</label>
						<div class="layui-input-inline">
							<input type="password" name="password" required lay-verify="required" placeholder="请输入" autocomplete="off"
								   class="layui-input">
						</div>

					</div>
					
					
					
					<div class="layui-form-item">
						<div class="layui-input-block">
							<button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
							<button type="reset" class="layui-btn layui-btn-primary">重置</button>
						</div>
					</div>
				</form>
				</div>

				<script>
					//Demo
					layui.use('form', function() {
						var form = layui.form;

						//监听提交
						form.on('submit(formDemo)', function(data) {
							layer.msg(JSON.stringify(data.field));
							return false;
						});
					});
				</script>
			</div>
		</div>
	</body>
</html>
