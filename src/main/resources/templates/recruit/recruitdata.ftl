<!DOCTYPE html>
<html>
<head>
    <base href="${basePath}">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <#include "../common/common.ftl"/>
    <title>饼状图比例分布数据</title>
</head>


<body>
<div>
    <fieldset class="layui-elem-field layuimini-search">
        <legend>搜索渠道统计</legend>
        <form class="layui-form layui-form-pane" action="/recruit/tofollow" lay-filter="dataForm" id="data">
        <div style="margin: 10px 10px 10px 10px">
        <div class="layui-inline">
            <label class="layui-form-label">渠道</label>
            <div class="layui-input-inline">
                <div class="layui-inline" style="width: 190px">
                    <select name="channelId" lay-verify="" class="decSelect"  lay-verify="required"
                            url="/dictionary/list/channel/options" selectedId="${channelId!''}">
                        <option value="">来源渠道</option>
                    </select>
                </div>
            </div>
        </div>
            <div class="layui-inline">
                <label class="layui-form-label">时间</label>
                <div class="layui-input-inline">
                    <input type="text" name="time" autocomplete="off" class="layui-input" id="time">
                </div>
            </div>
        <div class="layui-inline">
            <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
        </div>
        </div>
        </form>
    </fieldset>
    <table class="layui-table" style="margin-top: 0px;">
        <tr style="background-color: #F2F2F2;">
            <th>渠道名称</th>
            <th>人数</th>

        </tr>
        <#list list as follow>
            <tr>
                <td>${follow.channelName!""}</td>
                <td>${follow.num!""}</td>
            </tr>
        </#list>
        <#if list?? && (list?size == 0)>
            <tr>
                <td colspan="3" style="text-align: center">无数据</td>
            </tr>
        </#if>
    </table>
</div>
<div style="display: inline-block">
    <table id='myTable5'>
        <caption>渠道统计</caption>
        <thead>
        <tr>
            <th></th>
            <#list list as follow>
            <th>${follow.channelName!''}</th>

</#list>
        </tr>
        </thead>
        <tbody>
        <tr>
            <#list list as follow>

            <td>${follow.num!''}</td>

            </#list>
        </tr>
        </tbody>
    </table>
</div>

<div style="display: none">
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
<script type="text/javascript" src="js/jsapi.js"></script>
<script type="text/javascript" src="js/corechart.js"></script>
<script type="text/javascript" src="js/jquery.gvChart-1.0.1.min.js"></script>
<script type="text/javascript" src="js/jquery.ba-resize.min.js"></script>

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
    sel();
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
    layui.use(['form', 'table', 'laydate', 'layer', 'element', 'upload'], function () {
        var $ = layui.jquery,
            form = layui.form,

            laydate = layui.laydate;

        laydate.render({
            elem: '#time'
            ,range: true

        });
    });
</script>



</body>

</html>
