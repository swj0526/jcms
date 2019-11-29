<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>发布文章</title>
		<link rel="stylesheet" type="text/css" href="../layui/css/layui.css">
		<link rel="stylesheet" href="/all.css" media="all">
		<script type="text/javascript" src="../jquery/jquery-3.3.1.min.js"></script>
		<script type="text/javascript" src="../layui/layui.js"></script>
		<script type="text/javascript" src="../article/js/dispatch.js"></script>
		<script type="text/javascript" src="/all.js"></script>
	</head>
	<body>
		<form class="layui-form layui-form-pane" action="" lay-filter="dataForm">
		  <div class="layui-form-item">
		    <label class="layui-form-label">标题<span class="star">*</span></label>
		    <div class="layui-input-block">
		      <input name="title" class="layui-input" type="text" required lay-verify="required" placeholder="请输入标题" autocomplete="off" lay-verify="title">
		    </div>
		  </div>
		  <div class="layui-form-item" >
		    <label class="layui-form-label">接收角色<span class="star">*</span></label>
		    <div class="layui-input-inline" style="width: 300px">
		      <input name="like[老师]" title="老师" type="checkbox">
		      <input name="like[学生]" title="学生" type="checkbox">
		      <input name="like[管理员]" title="管理员" type="checkbox">
		    </div>
				  <div class="layui-inline" style="margin-bottom: 0px">
					  <label class="layui-form-label">文章类型<span class="star">*</span></label>
					  <div class="layui-inline" style="width: 115px;margin-right: 0px;margin-bottom: 0px;">
						  <select name="type" lay-verify="required" class="decSelect"
								  url="/dictionary/list/payType/options" id="type">
							  <option value="">请选择</option>
							  <option value="111">1111</option>
						  </select>
					  </div>
					  <button type="button" class="layui-btn" id="type1"
							  style="padding-left: 10px;padding-right: 10px;width: 70px;">设置
					  </button>
				  </div>
		  </div>
		  <div class="layui-form-item layui-form-text">
		    <label class="layui-form-label">内容</label>
		    <div class="layui-input-block">
		      <textarea class="layui-textarea " name="content" lay-verify="content" id="LAY_demo_editor"></textarea>
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

		<div id="modify1" style="display: none">
			<div style="margin: 10px 10px 10px 10px">
					<div class="layui-form-item">
						<div class="layui-form-item">
							<label class="layui-form-label">姓名<span class="star">*</span></label>
							<div class="layui-input-inline">
								<input type="text" name="title" required lay-verify="required" placeholder="" autocomplete="off"
									   class="layui-input" id="title">
							</div>
						</div>
						<div class="layui-form-item">
							<label class="layui-form-label">手机号<span class="star">*</span></label>
							<div class="layui-input-inline">
								<input name="phone" class="layui-input" type="tel" autocomplete="off"
									   lay-verify="required|phone" id="phone1">
							</div>
						</div>
					</div>
			</div>
		</div>
	</body>
</html>
