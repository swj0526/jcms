layui.use(['form', 'laydate', 'layer', 'table'], function () {
    var form = layui.form
        , layer = layui.layer
        , laydate = layui.laydate
        , table = layui.table;
    //日期,如果需要时分秒的话,加上(type: 'datetime')
    laydate.render({
        elem: '#date1'
    });
    //日期时间范围
    laydate.render({
        elem: '#scopeDate'
        , type: 'datetime'
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
    layui.$('#LAY-component-form-setval').on('click', function () {
        form.val('example', {
            "name": "贤心" // "name": "value"
            , "interest": 1
            , "date": '2019-12-12'
            , "scopeDate": '2019-12-21 00:00:00 - 2020-01-16 00:00:00'
            , "remark": '我爱layui'
        });

    });

    //表单取值
    layui.$('#LAY-component-form-getval').on('click', function () {
        var data = form.val('example');
        alert(JSON.stringify(data));
    });

});