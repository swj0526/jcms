layui.use(['form', 'laydate', 'layer', 'table'], function () {
    var form = layui.form
        , layer = layui.layer
        , laydate = layui.laydate
        , table = layui.table;
    //日期,如果需要时分秒的话,加上(type: 'datetime')
    laydate.render({
        elem: '#date'
    });
    //日期时间范围
    laydate.render({
        elem: '#scopeDate'
        , range: true
    });

    //监听提交
    form.on('submit(submit)', function (data) {
        layer.alert(JSON.stringify(data.field), {
            title: '最终的提交信息'
        })
        return false;
    });

    //表单赋值
    layui.$('#giveBtn').on('click', function () {
        form.val('example', {
            "name": "贤心" // "name": "value"
            , "interest": 1
            , "date": '2019-12-12'
            , "scopeDate": '2019-12-21  - 2020-01-16'
            , "remark": '我爱layui'
        });

    });

    //表单取值
    layui.$('#getBtn').on('click', function () {
        var data = form.val('example');
        alert(JSON.stringify(data));
    });

});