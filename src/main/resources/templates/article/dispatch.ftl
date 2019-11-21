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
		<form class="layui-form layui-form-pane" action="">
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
		      <input name="like[read]" title="学生" type="checkbox" >
		      <input name="like[game]" title="管理员" type="checkbox">
		    </div>
		  </div>
		  <div class="layui-form-item layui-form-text">
		    <label class="layui-form-label">内容</label>
		    <div class="layui-input-block">
		      <textarea class="layui-textarea layui-hide" name="content" lay-verify="content" id="LAY_demo_editor"></textarea>
		    </div>
		  </div>
			<div class="layui-upload">
				<button class="layui-btn layui-btn-normal" id="testList" type="button">选择多文件</button>
				<button class="layui-btn layui-btn-warm" id="testListAction" type="button">开始上传</button>
				<blockquote class="layui-elem-quote layui-quote-nm">如需要上传(文件，图片)，请先选择(文件，图片)，选择完点击上传，在提交</blockquote>
				<div class="layui-upload-list">
					<table class="layui-table">
						<thead>
						<tr><th>文件名</th>
							<th>大小</th>
							<th>状态</th>
							<th>操作</th>
						</tr></thead>
						<tbody id="demoList"></tbody>
					</table>
				</div>
			</div>
			<br>
			<br>
		  <div class="layui-form-item">
		      <button class="layui-btn" type="submit" lay-filter="demo1" lay-submit="">立即提交</button>
		      <button class="layui-btn layui-btn-primary" type="reset">重置</button>
		  </div>
		</form>
	</body>
</html>
