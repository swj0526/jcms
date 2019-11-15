<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="../layui/css/layui.css">
		<script type="text/javascript" src="../jquery/jquery-3.3.1.min.js"></script>
		<script type="text/javascript" src="../layui/layui.js"></script>
		<script type="text/javascript" src="../article/js/dispatch.js"></script>
	</head>
	<body>
		<form class="layui-form" action="">
		  <div class="layui-form-item">
		    <label class="layui-form-label">标题</label>
		    <div class="layui-input-block">
		      <input name="title" class="layui-input" type="text" placeholder="请输入标题" autocomplete="off" lay-verify="title">
		    </div>
		  </div>
		  
		  <div class="layui-form-item" >
		    <label class="layui-form-label">接收角色</label>
		    <div class="layui-input-inline" style="width: 300px">
		      <input name="like[write]" title="老师" type="checkbox">
		      <input name="like[read]" title="学生" type="checkbox" checked="">
		      <input name="like[game]" title="管理员" type="checkbox">
		    </div>
			  <div class="layui-inline">
				  <label class="layui-form-label">类型</label>
				  <div class="layui-input-inline">
					  <select name="modules" lay-search="" lay-verify="required">
						  <option value="">请选择类型</option>
						  <option value="1">公告</option>
						  <option value="2">通知</option>
					  </select>
				  </div>
			  </div>

		  </div>
		  
		  <div class="layui-form-item layui-form-text">
		    <label class="layui-form-label">内容</label>
		    <div class="layui-input-block">
		      <textarea class="layui-textarea layui-hide" name="content" lay-verify="content" id="LAY_demo_editor"></textarea>
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <div class="layui-input-block">
		      <button class="layui-btn" type="submit" lay-filter="demo1" lay-submit="">立即提交</button>
		      <button class="layui-btn layui-btn-primary" type="reset">重置</button>
		    </div>
		  </div>
		</form>
	</body>
</html>
