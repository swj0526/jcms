layui.use(['form', 'table', 'laydate'], function () {
    var $ = layui.jquery,
        form = layui.form,
        table = layui.table;


    $('#add').click(function () {
        mainIndex = layer.open({
            type: 1,
            title: "添加渠道信息",
            // skin: 'layui-layer-rim', //加上边框
            area: ['400px'], //设置宽高
            content: $("#recruit"),
            success: function (index) {
                //清空
                $("#dataFor")[0].reset();
                //刷新
                tableIns.reload();

            }
        });
    });
    $('#add1').click(function () {
        var name = $("[name='nameA']").val();
        var remark = $("[name='remarkA']").val();
        $.post("/dictionary/add/channel", {
            name: name,
            remark: remark
        }, function (result) {
            if (result.success) {
                layer.close(mainIndex);
            } else {

            }
        });
    });


});
