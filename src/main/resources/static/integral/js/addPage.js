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
        $.post('/History/add',
            data
            , function (result) {
                if (result.success) {
                    parent.layer.close(index);
                } else {
                }
            })
    })
    laydate.render({
        elem: '#time'
        , type: 'datetime'
    });
})
var sel = function () {
    //JavaScript代码区域
    layui.use(['table', 'layer', 'jquery', 'form'], function () {
        var table = layui.table;
        var layer = layui.layer;
        var $ = layui.jquery;
        var form = layui.form;
        //传入的字典的地址

        $(".decSelect").each(function () {
            var url = $(this).attr('url');
            var dom = $(this);
            var selectedId = $(this).attr('selectedId');

            //重新渲染表单
            function renderForm() {
                layui.use('form', function () {
                    var form = layui.form; //高版本建议把括号去掉，有的低版本，需要加()
                    form.render();
                });
            }

            dom.empty();
            dom.append("<option value=''>请选择</option>");
            $.post(url, function (result) {
                $.each(result, function (key, value) {
                    if (value.optionValue == selectedId) {
                        dom.append("<option value=" + value.id + " selected>" + value.reason + "</option>");
                    } else {
                        dom.append("<option value=" + value.id + ">" + value.reason + "</option>");
                    }

                });
                renderForm(); //表单重新渲染，要不然添加完显示不出来新的option
            });
        });
    })
}