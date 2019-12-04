<!DOCTYPE html>
<html lang="en">
<head>
    <#include "../common/common.ftl"/>
</head>
<body>
<!--查询开始-->
<div style="padding: 5px;">
    <form class="layui-form layui-form-pane" action="" lay-filter="example">
        <div class="layui-form-item">
            <label class="layui-form-label">姓名<span class="star">*</span></label>
            <div class="layui-input-inline">
                <input type="text" name="name" required  lay-verify="required" autocomplete="off"
                        class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">爱好<span class="star">*</span></label>
            <div class="layui-input-inline">
                <select name="interest" lay-filter="aihao" required  lay-verify="required">
                    <option value="">请选择爱好</option>
                    <option value="0">写作</option>
                    <option value="1" >阅读</option>
                    <option value="2">游戏</option>
                    <option value="3">音乐</option>
                    <option value="4">旅行</option>
                </select>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">日期选择<span class="star">*</span></label>
                <div class="layui-input-block">
                    <input type="text" name="date" id="date" autocomplete="off" class="layui-input" required  lay-verify="required">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">日期范围<span class="star">*</span></label>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input" id="scopeDate" name="scopeDate" required  lay-verify="required">
                </div>
            </div>

        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">备注</label>
            <div class="layui-input-block">
                <textarea placeholder="请输入内容" class="layui-textarea" name="remark"></textarea>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="button" class="layui-btn layui-btn-normal" id="giveBtn">赋值</button>
                <button type="button" class="layui-btn layui-btn-normal" id="getBtn">取值</button>
                <button type="submit" class="layui-btn" lay-submit="" lay-filter="submit">立即提交</button>
            </div>
        </div>
    </form>

</div>

</body>
<script type="text/javascript" src="/common/js/add.js"></script>
</html>