<!DOCTYPE html>
<html>
	<head>
		<title>发布文章</title>
		<#include "../common/common.ftl"/>

	</head>
	<body>
    <#--添加文章-->
		<form class="layui-form layui-form-pane" action="" lay-filter="dataForm">
		  <div class="layui-form-item">
		    <label class="layui-form-label">标题<span class="star">*</span></label>
		    <div class="layui-input-block">
		      <input name="title" class="layui-input" type="text" required lay-verify="required" placeholder="请输入标题" autocomplete="off" lay-verify="title">
		    </div>
		  </div>
		  <div class="layui-form-item" >
			  <label class="layui-form-label">接收人<span class="star">*</span></label>
			  <div class="layui-inline">
				  <div id="demo2" class="xm-select-demo" required lay-verify="required" style=" width:200px";></div>
			  </div>
				  <div class="layui-inline" style="margin-bottom: 0px">
					  <label class="layui-form-label">文章类型<span class="star">*</span></label>
					  <div class="layui-inline" style="width: 115px;margin-right: 0px;margin-bottom: 0px;">
						  <select name="typeId" lay-verify="required" class="decSelect"
								  url="/dictionary/list/dispatch/options"  >
							  <option value="">请选择</option>
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
						<tr>
							<th>文件名</th>
							<th>大小</th>
							<th>状态</th>
							<th>操作</th>
						</tr>
						</thead>
						<tbody id="demoList"></tbody>
					</table>
				</div>
			</div>
			<br>
			<br>
		  <div class="layui-form-item">
		      <button class="layui-btn" type="submit" lay-filter="demo1" lay-submit="">立即提交</button>
			  <button class="layui-btn" type="button" id="browse" >预览</button>
			  <button class="layui-btn layui-btn-primary" type="reset">重置</button>
		  </div>
		</form>
	<script type="text/javascript" src="/article/js/dispatch.js"></script>
	<script type="text/javascript" src="/article/js/xm.js"></script>
	<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
	<script>
		var demo2 = xmSelect.render({
			el: '#demo2',
			language: 'zn',
			filterable: true,
			searchTips: '搜索标签',
			tips: '请选择接收人',
			height: '500px',
			code:0,
			prop: {
				name: 'name',
				value: 'id',
			},

		});
		axios({
			method: 'get',
			url: '/dictionary/list/label',
		}).then(response => {
			var res = response.data;
			demo2.update({
				data: res,

			})
		});
	</script>

	</body>
</html>
