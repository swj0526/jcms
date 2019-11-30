layui.use(['form', 'table', 'laydate'], function () {
    var $ = layui.jquery,
        form = layui.form,
        table = layui.table;
    layer = layui.layer;
    var mainIndex;

    $('#add').click(function () {
        mainIndex = layer.open({
            type: 1,
            title: "添加专业信息",
            // skin: 'layui-layer-rim', //加上边框
            area: ['400px'], //设置宽高
            content: $("#recruit"),
            success: function (index) {
                //清空
                $("#dataFor")[0].reset();
            }, end: function () {
                location.reload();
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
    var id;//专业的id,班级的pid
    $('.btnB').click(function () {
        id = $(this).attr("id");
        mainIndex = layer.open({
            type: 1,
            title: "添加班级信息",
            // skin: 'layui-layer-rim', //加上边框
            area: ['400px'], //设置宽高
            content: $("#recruitB"),
            success: function (index) {
                //清空
                $("#dataFor")[0].reset();


            }, end: function () {
                location.reload();
            }
        });
    });
    $('.btnC').click(function () {
        id = $(this).attr("id");
        mainIndex = layer.open({
            type: 1,
            title: "修改专业信息",
            // skin: 'layui-layer-rim', //加上边框
            area: ['400px'], //设置宽高
            content: $("#recruitC"),
            success: function (index) {
                //清空
                $("#dataFor")[0].reset();
                $.post("/major/get", {id: id}, function (result) {
                    $('[name="nameC"]').val(result.name);
                    $('[name="remarkC"]').val(result.remark);
                });

            }, end: function () {
                location.reload();
            }
        });
    });
    $('#addC').click(function () {
        var name = $("[name='nameC']").val();
        var remark = $("[name='remarkC']").val();
        $.post("/major/modify", {
            name: name,
            remark: remark,
            id: id
        }, function (result) {
            if (result.success) {
                layer.close(mainIndex);

            } else {

            }
        });

    });
    $('.btnD').click(function () {
        id = $(this).attr("id");
        mainIndex = layer.open({
            type: 1,
            title: "修改班级信息",
            // skin: 'layui-layer-rim', //加上边框
            area: ['400px'], //设置宽高
            content: $("#recruitD"),
            success: function (index) {
                //清空
                $("#dataFor")[0].reset();
                $.post("/major/get", {id: id}, function (result) {
                    $('[name="nameD"]').val(result.name);
                    $('[name="remarkD"]').val(result.remark);
                });

            }, end: function () {
                location.reload();
            }
        });
    });
    $('#addD').click(function () {
        var name = $("[name='nameD']").val();
        var remark = $("[name='remarkD']").val();
        $.post("/major/modify", {
            name: name,
            remark: remark,
            id: id
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
        var pid = id;
        $.post("/major/add/class", {
            name: name,
            remark: remark,
            pid: pid
        }, function (result) {
            if (result.success) {
                layer.close(mainIndex);

            } else {
            }
        });

    });
    $('.del').click(function () {
        id = $(this).attr("id");
        layer.confirm('真的删除行么', {
                btn: ['确定', '取消'],
                yes: function (index, layero) {
                    $.post('/major/delete', {id: id}, function (result) {
                        if (result.success) {
                            layer.msg("删除成功!");
                            layer.close(index);
                            location.reload();
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
   /* $("#search").click(function () {
        var keywords = $('[name="keywords"]').val();
        $.post("/major/tolist", {keywords: keywords}, function (result) {

        });
    });*/
});
