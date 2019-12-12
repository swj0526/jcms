layui.use(['jquery', 'layer', 'table', 'form', 'laydate'], function () {
    var $ = layui.jquery,
        table = layui.table,
        layer = layui.layer,
        laydate = layui.laydate;
    form = layui.form;
    var index = parent.layer.getFrameIndex(window.name);
    $("#reasonSetting").click(function () {
        layer.open({
            btnAlign: 'c'
            , type: 2
            , area: ['720px', '450px']
            , title: '事由'
            , btn: ['提交', '取消']
            , content: '/integralitem/tolist'
            , end: function () {
                sel();
                $("#score").val('')
                $(".layui-laypage-btn").click();

            }
        });
    })

    $("#revocationBtn").click(function () {
        parent.layer.close(index);
    })
    form.on('select', function (data) {
        $.post('/integralitem/get', {
            id: data.value
        }, function (result) {
            $("#score").val(result.score)
        })
    })

    $("#submitBtn").click(function () {
        var data = $('#addForm').serialize();
        $.post('/history/add',
            data
            , function (result) {
                if (result.success) {
                    parent.layer.close(index);
                } else {
                }
            })
    })
    laydate.render({
        elem: '#recordTime'
        , type: 'datetime'
    });
})