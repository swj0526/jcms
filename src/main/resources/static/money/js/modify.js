layui.use(['table', 'jquery', 'laydate', 'form', 'element'], function () {
    var table = layui.table;
    var $ = layui.jquery;
    laydate = layui.laydate;
    form = layui.form

    var index = parent.layer.getFrameIndex(window.name);
    //是否分期赋值
    var a = $("#Instalment").val();
    var select = 'dd[lay-value=' + a + ']';
    $('#hasInstalment').siblings("div.layui-form-select").find('dl').find(select).click();
//修改数据
    $("#submitBtn").click(function () {
        var data = $('#dataFor').serialize();
        $.post('/money/modify',
            data
            , function (result) {
                if (result.success) {
                    parent.layer.close(index);
                } else {
                    layer.msg(result.msg)
                }
            });
    })
    //时间选择器
    laydate.render({
        elem: '#endTime'
    });
    laydate.render({
        elem: '#payDate'
    });
    laydate.render({
        elem: '#startTime'
    });
    //学年设置
    $("#semesterIdSetting").click(function () {
        layer.open({
            btnAlign: 'c'
            , type: 2
            , title: '学年'
            , area: ['720px', '350px']
            , btn: ['确定', '取消']
            , content: 'tosemester'
            , end: function () {
                location.reload();
            }
        });
    });
    //缴费方式设置
    $("#paymentMethodIdSetting").click(function () {
        layer.open({
            btnAlign: 'c'
            , title: '缴费方式'
            , type: 2
            , area: ['720px', '350px']
            , btn: ['确定', '取消']
            , content: 'topaymentMethod'
            , end: function () {
                location.reload();
            }
        });
    });
    //缴费类型设置
    $("#typeIdSetting").click(function () {
        layer.open({
            btnAlign: 'c'
            , title: '缴费类型'
            , type: 2
            , area: ['720px', '350px']
            , btn: ['确定', '取消']
            , content: 'totype'
            , end: function () {
                location.reload();
            }
        });
    });
    //关闭弹窗
    $("#revocationBtn").click(function () {
        parent.layer.close(index);
    })

});
