layui.use(['form', 'table', 'jquery','layer'], function () {
    var $ = layui.jquery,
        form = layui.form,
        table = layui.table,
        layer = layui.layer;
    var mainIndex;
    $('#refreshBtn').click(function () {
        location.reload();
    });
    $('#addBtn').click(function () {
        mainIndex = layer.open({
            type: 1,
            title: "添加专业信息",
            // skin: 'layui-layer-rim', //加上边框
            area: ['400px'], //设置宽高
            content: $("#addMajorPopups"),
            success: function (index) {
                //清空
                $("#dataFor")[0].reset();
            }, end: function () {
                location.reload();
            }
        });

    });
    $('#addMajorBtn').click(function () {
        var name = $("[name='majorName']").val();
        var remark = $("[name='majorRemark']").val();
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
    $('.addGrade').click(function () {
        id = $(this).attr("id");
        mainIndex = layer.open({
            type: 1,
            title: "添加班级信息",
            // skin: 'layui-layer-rim', //加上边框
            area: ['400px'], //设置宽高
            content: $("#addGradePopups"),
            success: function (index) {
                //清空
                $("#dataFor")[0].reset();


            }, end: function () {
                location.reload();
            }
        });
    });
    $('.exitMajor').click(function () {
        id = $(this).attr("id");
        mainIndex = layer.open({
            type: 1,
            title: "修改专业信息",
            // skin: 'layui-layer-rim', //加上边框
            area: ['400px'], //设置宽高
            content: $("#modifyMajorPopups"),
            success: function (index) {
                //清空
                $("#dataFor")[0].reset();
                $.post("/major/get", {id: id}, function (result) {
                    $('[name="nameMajorM"]').val(result.name);
                    $('[name="remarkMajorM"]').val(result.remark);
                });

            }, end: function () {
                location.reload();
            }
        });
    });
    $('#modifyMajorBtn').click(function () {
        var name = $("[name='nameMajorM']").val();
        var remark = $("[name='remarkMajorM']").val();
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
    $('.exitGrade').click(function () {
        id = $(this).attr("id");
        mainIndex = layer.open({
            type: 1,
            title: "修改班级信息",
            // skin: 'layui-layer-rim', //加上边框
            area: ['400px'], //设置宽高
            content: $("#modifyGradePopups"),
            success: function (index) {
                //清空
                $("#dataFor")[0].reset();
                $.post("/major/get", {id: id}, function (result) {
                    $('[name="nameGradeM"]').val(result.name);
                    $('[name="remarkGradeM"]').val(result.remark);
                });

            }, end: function () {
                location.reload();
            }
        });
    });
    $('#modifyGradeBtn').click(function () {
        var name = $("[name='nameGradeM']").val();
        var remark = $("[name='nameGradeM']").val();
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
    $('#addGradeBtn').click(function () {
        var name = $("[name='nameGrade']").val();
        var remark = $("[name='remarkGrade']").val();
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
});
