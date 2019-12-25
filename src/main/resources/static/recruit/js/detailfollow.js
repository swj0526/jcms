
layui.use(['element', 'layer', 'form', 'jquery', 'laydate'], function () {
    var element = layui.element;
    var layer = layui.layer;
    var form = layui.form;
    var $ = layui.jquery;
    var laydate = layui.laydate;
    laydate.render({//时间
        elem: '#date', //指定元素
        value: new Date()

    });
    var index;

    //添加弹出框
    $("#addfollowbtn").click(function () {
        index = layer.open({
            type: 1,
            title: "添加跟进信息",
            skin: 'layui-layer-rim', //加上边框
            area: ['720px', '350'], //设置宽高
            content: $("#openfollowtable"),

        });
    });

//删除
    $(".delete").click(function () {
        var id = $(this).val();
        $.post('/detail/deletefollow',{id:id},function (result) {
            location.reload();
        })


    });
    //修改
    $(".update").click(function () {
        var id = $(this).val();
        index = layer.open({
            type: 2,
            title: "修改跟进信息",
            skin: 'layui-layer-rim', //加上边框
            area: ['720px', '350px'], //设置宽高
            content:"/detail/tomodify?id="+id,
        });

    });

    //监听提交
    $("#submitbut").click(function () {
        var seList = new Array();
        var selectArr = addDetail.getValue().valueOf();//获取复选框的值
        $.each(selectArr, function (k, v) {
            $.each(v, function (k1, v1) {
                if (k1 == "id") {
                    seList.push(v1);
                }
            });
        });
        let label = seList.join(",");
        let labe = ("," + label + ",");
        let  recruitDetail = $("#formdata").serialize();
        let studentId = $("#submitbut").val();
        $.post('/detail/add', recruitDetail + "&studentId=" + studentId + "&labelIds=" + labe, function (result) {
            layer.close(index);
            location.reload();
        })
    });
    //监听修改

        $("#modifySubmit").click(function () {
            var seList = new Array();
            var selectArr = modifydiv.getValue().valueOf();//获取复选框的值
            $.each(selectArr, function (k, v) {
                $.each(v, function (k1, v1) {
                    if (k1 == "id") {
                        seList.push(v1);
                    }
                });
            });
            let label = seList.join(",");
            let labels = ("," + label + ",");
            let  recruitDetail = $("#modifyForm").serialize();
            let id = $("#modifySubmit").val();
            $.post('/detail/modify', recruitDetail + "&id=" + id + "&labelIds=" + labels, function (result) {
               parent.location.reload();
            })


    })

});



