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
        <div style="margin: 10px 10px 10px 10px">
        <div class="layui-inline">
            <label class="layui-form-label">关键字</label>
            <div class="layui-input-inline">
                <input type="text" name="username" autocomplete="off" class="layui-input">
            </div>
        </div>
            <div class="layui-inline">
                <label class="layui-form-label">时间</label>
                <div class="layui-input-inline">
                    <input type="text" name="city" autocomplete="off" class="layui-input" id="t1">
                </div>
            </div>
        <div class="layui-inline">
            <a class="layui-btn  layui-btn-primary" lay-submit="" lay-filter="data-search-btn">查询</a>
        </div>
        </div>
    </fieldset>
    <table class="layui-table" style="margin-top: 0px;">
        <tr style="background-color: #F2F2F2;">
            <th>渠道名称</th>
            <th>人数</th>
            <th>百分比</th>
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

<script type="text/javascript" src="/js/jsapi.js"></script>
<script type="text/javascript" src="/js/corechart.js"></script>
<script type="text/javascript" src="/js/jquery.gvChart-1.0.1.min.js"></script>
<script type="text/javascript" src="/js/jquery.ba-resize.min.js"></script>
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



</body>

</html>
