layui.use(['table', 'jquery', 'laydate', 'form', 'element', 'upload'], function () {
    var table = layui.table;
    var $ = layui.jquery;
    var element = layui.element;
    laydate = layui.laydate;
    var upload = layui.upload;
    form = layui.form;

    $(".score").click(function () {
        var a = $(this).attr("id");
        var b = $(this).attr("name");
        layer.open({
            type: 1
            , btn: ["确定", "取消"]
            , content: $("#score")
            , success: function () {
                $("#studentScore").val("");
            }
            , yes: function (index) {

                $.post("/work/modifyscore", {
                    id: a
                    , studentId: b
                    , score: $("#studentScore").val()
                }, function (result) {
                    if (result) {
                        window.location.reload();
                        layer.close(index);
                    }
                })
            }
            , btn2: function (index) {
                layer.close(index);
            }

        });
    })
    $(".estimateContent").click(function () {
        var a = $(this).attr("id");
        var b = $(this).attr("name");
        $.post("/work/modifyestimateContent", {
            id: a
            , studentId: b
            , estimateContent: $("#Content"+b).val()
        }, function (result) {
            if (result) {
                window.location.reload();
                layer.close(index);
            }
        })
    })


});