layui.use(['table', 'jquery', 'laydate', 'form', 'element'], function () {
    var table = layui.table;
    var $ = layui.jquery;
    laydate = layui.laydate;
    form = layui.form,
    laydate.render({
        elem: '#test6'
        , range: true
    });
    laydate.render({
        elem: '#test1'
    });
    laydate.render({
        elem: '#test2'
    });
    laydate.render({
        elem: '#test3'
    });
    $("#type3").click(function () {
        layer.open({
            btnAlign: 'c'
            , type: 2
            , area: ['500px', '650px']
            , btn: ['确定']
            , content: 'kkk'
        });
    });
    $("#type2").click(function () {
        layer.open({
            btnAlign: 'c'
            , type: 2
            , area: ['500px', '650px']
            , btn: ['确定']
            , content: 'kkk'
        });
    });
    $("#type1").click(function () {
        layer.open({
            btnAlign: 'c'
            , type: 2
            , area: ['500px', '650px']
            , btn: ['确定']
            , content: 'kkk'
        });
    });
});