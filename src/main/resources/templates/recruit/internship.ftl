<!DOCTYPE html>
<html lang="en">
<head>
    <base href="${basePath}">
    <meta charset="UTF-8">
    <#include "../common/common.ftl"/>
    <title>试学管理信息</title>

</head>
<body>
<div class="layuimini-container">
    <div class="layuimini-main">
        <fieldset class="layui-elem-field layuimini-search">

            <div style="margin: 10px 10px 10px 10px">
                <div class="demoTable">

                    <form class="layui-form layui-form-pane" action="">
                        <div class="layui-inline" style="width: 210px">
                            <label class="layui-form-label" style="width:100px">关键词</label>
                            <div class="layui-input-inline" style="width:100px ">
                                <input type="text" id="keywords" autocomplete="off"  placeholder="姓名"class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">时间范围</label>
                            <div class="layui-input-inline" style="width: 120px;margin-right: 0px">
                                <select name="timeStart" lay-verify="" id="timeState">
                                    <option value="">例:开始/结束</option>
                                    <option value="1">开始时间</option>
                                    <option value="2">结束时间</option>

                                </select>
                            </div>
                            <div class="layui-input-inline">
                                <input type="text" name="searchTime" autocomplete="off" class="layui-input" id="searchTime">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <a class="layui-btn  layui-btn-primary" data-type="reload">查询</a>
                        </div>
                    </form>
                </div>
            </div>
        </fieldset>
    </div>
<#--添加-->
    <div style="display: none;width: 100%"  id="addlabel">
        <form class="layui-form layui-form-pane" action="" lay-filter="dataForm" id="data" style="margin-left: 30%;margin-top: 5%">
            <div class="layui-form-item">
                <label class="layui-form-label">开始时间<span  class="star">*</span> </label>
                <div class="layui-input-inline">
                    <input type="text" name="startDate" required lay-verify="required" placeholder="" autocomplete="off"
                           class="layui-input" id="startTime">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">结束时间<span  class="star">*</span></label>
                <div class="layui-input-inline">
                    <input type="text" name="endDate" placeholder="" autocomplete="off"
                           class="layui-input" id="endTime">
                </div>
            </div>
            <div class="layui-form-item" style="margin-left: 18%">
                <div class="layui-input-inline">
                    <button class="layui-btn" type="button"  lay-submit lay-filter="addRecruitBtn" id="addlabelbtn">立即提交</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>
        </form>


    </div>

</div>
<table class="layui-hide" id="test" lay-filter="test"></table>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    {{# if(d.entranceState!="3"){ }}
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    {{# } }}

</script>
<script src="/recruit/js/internship.js"></script>
</body>
</html>