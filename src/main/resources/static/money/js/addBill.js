layui.use(['table', 'jquery', 'laydate', 'form', 'element'], function () {
    var table = layui.table;
    var $ = layui.jquery;
    laydate = layui.laydate;
    form = layui.form,

        //时间选择器
        laydate.render({
            elem: '#test6'
            , range: true
        });

    laydate.render({
        elem: '#payDate'
    });
    laydate.render({
        elem: '#startTime'
    });
    laydate.render({
        elem: '#endTime'
    });
    //学年设置
    $("#semesterIdSetting").click(function () {
        layer.open({
            btnAlign: 'c'
            , type: 2
            ,title:'学年'
            , area: ['720px', '350px']
            ,btn:['确定','取消']
            , content: '/money/tosemester'
        });
    });
    //缴费方式设置
    $("#paymentMethodIdSetting").click(function () {
        layer.open({
            btnAlign: 'c'
            ,title:'缴费方式'
            , type: 2
            , area: ['720px', '350px']
            ,btn:['确定','取消']
            , content: '/money/topaymentMethod'
            ,end:function () {
                sel();
            }
        });
    });
    //缴费类型设置
    $("#typeIdSetting").click(function () {
        layer.open({
            btnAlign: 'c'
            , type: 2
            ,title:'缴费类型'
            , area: ['720px', '350px']
            ,btn:['确定','取消']
            , content: '/money/totype'
            ,end:function () {
                sel();
            }
        });
    });

//获取当前页dom
    var index = parent.layer.getFrameIndex(window.name);


    //var recruit = $("#dataFor").serialize();
    //添加数据
    $("#submitBtn").click(function () {
        var data = $('#dataFor').serialize();
        $.post('/money/add',
            data
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
    //关闭弹窗
    $("#revocationBtn").click(function () {
        parent.layer.close(index);
    })
});