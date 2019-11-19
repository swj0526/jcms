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
    $("#ss").click(function () {
        layer.open({
            btnAlign: 'c'
            , type: 2
            , area: ['500px', '650px']
            , btn: ['确定']
            , content: 'kkk'
        });
    });
});