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
            ,title:'学年'
            , area: ['720px', '350px']
            ,btn:['确定','取消']
            , content: 'tosemester'
        });
    });
    $("#type2").click(function () {
        layer.open({
            btnAlign: 'c'
            ,title:'缴费方式'
            , type: 2
            , area: ['720px', '350px']
            ,btn:['确定','取消']
            , content: 'topaymentMethod'
            ,end:function () {
                sel();
            }
        });
    });
    $("#type1").click(function () {
        layer.open({
            btnAlign: 'c'
            , type: 2
            ,title:'缴费类型'
            , area: ['720px', '350px']
            ,btn:['确定','取消']
            , content: 'totype'
            ,end:function () {
                sel();
            }
        });
    });


    var index = parent.layer.getFrameIndex(window.name);


    //var recruit = $("#dataFor").serialize();
    $("#submit").click(function () {
        var t = $('#dataFor').serialize();
        $.post('/money/add',
            t
            , function (result) {
                if (result.success) {
                    layer.open({
                        btnAlign: 'c'
                        , area: ['100px', '150px']
                        , content: '<p style="text-align: center">添加成功</p>'
                        , btn: ['继续添加', '返回数据表格']
                        , yes: function (index) {
                            location.reload();
                        }
                        , btn2: function () {
                            parent.layer.close(index);

                        }
                    })
                } else {
                    layer.msg(result.msg)
                }


            });
    });
    $("#revocation").click(function () {
        parent.layer.close(index);
    })
});