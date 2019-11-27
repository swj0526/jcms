layui.use(['form', 'table', 'laydate'], function () {
    var $ = layui.jquery,
        form = layui.form,
        table = layui.table;
    layer= layui.layer;


    $('#add').click(function () {
     var    mainIndex = layer.open({
            type: 1,
            title: "添加专业信息",
            // skin: 'layui-layer-rim', //加上边框
            area: ['400px'], //设置宽高
            content: $("#recruit"),
            success: function (index) {
                //清空
                $("#dataFor")[0].reset();


            }
        });
    });
    $('#add1').click(function () {
        var name = $("[name='nameA']").val();
        var remark = $("[name='remarkA']").val();
        $.post("/major/add/major", {
            name: name,
            remark: remark
        }, function (result) {
            if (result.success) {
                layer.close(mainIndex);
            } else {

            }
        });
    });
    $('.btnB').click(function () {

       var  mainIndex = layer.open({
            type: 1,
            title: "添加班级信息",
            // skin: 'layui-layer-rim', //加上边框
            area: ['400px'], //设置宽高
            content: $("#recruitB"),
            success: function (index) {
                //清空
                $("#dataFor")[0].reset();


            }
        });
    });
    $('.btnC').click(function () {

        var  mainIndex = layer.open({
            type: 1,
            title: "修改专业信息",
            // skin: 'layui-layer-rim', //加上边框
            area: ['400px'], //设置宽高
            content: $("#recruitC"),
            success: function (index) {
                //清空
                $("#dataFor")[0].reset();


            }
        });
    });
    $('#addC').click(function () {
        alert("修改专业");
        var name = $("[name='nameC']").val();
        var remark = $("[name='remarkC']").val();
        $.post("/major/modify", {
            name: name,
            remark: remark,
            id:1
        }, function (result) {
            if (result.success) {
                layer.close(mainIndex);
            } else {

            }
        });
    });
    $('#addB').click(function () {
        var name = $("[name='nameB']").val();
        var remark = $("[name='remarkB']").val();
        var pid = 1;
        $.post("/major/add/class", {
            name: name,
            remark: remark,
            pid:pid
        }, function (result) {
            if (result.success) {
                layer.close(mainIndex);
            } else {

            }
        });
    });
    $('.del').click(function () {
        layer.confirm('真的删除行么', {
                btn: ['确定', '取消'],
                yes: function (index, layero) {
                    $.post('/dictionary/delete', {id: data.id}, function (result) {
                        if (result.success) {
                            layer.msg("删除成功!");
                            layer.close(index);

                        } else {
                            layer.msg(result.msg);
                        }
                    });

                }, no: function (index) {
                    layer.close(index);
                }
            }
        );
    });

});
