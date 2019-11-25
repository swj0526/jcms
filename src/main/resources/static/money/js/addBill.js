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
    var index = parent.layer.getFrameIndex(window.name);
    //var recruit = $("#dataFor").serialize();
    $("#submit").click(function () {
        var t = $('#dataFor').serialize();
        $.post('/money/add',
            t
            , function (result) {
                layer.open({
                    btnAlign: 'c'
                    , area: ['100px', '150px']
                    ,content:'<p style="text-align: center">添加成功</p>'
                    ,btn:['继续添加','取消']
                    ,yes:function (index) {
                        layer.close(index)
                    }
                    ,btn2:function () {
                        parent.layer.close(index);
                    }
                })

            });
    });
});