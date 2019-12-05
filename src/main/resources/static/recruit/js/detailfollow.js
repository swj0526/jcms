
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
    var url;
    //添加弹出框
    $("#addfollowbtn").click(function () {
        index = layer.open({
            type: 1,
            title: "添加跟进信息",
            skin: 'layui-layer-rim', //加上边框
            area: ['720px', '350'], //设置宽高
            content: $("#openfollowtable"),
            success: function () {
                url = '/details/add'
            }
        });
    });
//删除
    $(".delete").click(function () {
        var id = $(this).val();
        $.post('/details/deleteFollow',{id:id},function (result) {
            location.reload();
        })


    });
    //修改
    $(".update").click(function () {
        addselect();

        var id = $(this).val();
        index = layer.open({
            type: 1,
            title: "修改跟进信息",
            skin: 'layui-layer-rim', //加上边框
            area: ['720px', '350'], //设置宽高
            content: $("#upfollow"),
        });
        $.post();
    });


    //监听提交
    $("#submitbut").click(function () {

        var seList = new Array();
        var selectArr = add.getValue().valueOf();//获取复选框的值
        $.each(selectArr, function (k, v) {
            $.each(v, function (k1, v1) {
                if (k1 == "value") {
                    seList.push(v1);
                }
            });
        });
        let label = seList.join(",");
        var labe = ("," + label + ",");
        var recruitDetail = $("#formdata").serialize();
        var studentId = $("#submitbut").val();
        $.post(url, recruitDetail + "&studentId=" + studentId + "&labelIds=" + labe, function (result) {
            layer.close(index);
            location.reload();
        })
    });

});

var add = xmSelect.render({
    el: '#add',
    language: 'zn',
    data: [
        {name: '有意向', value: 7},
        {name: '还在考虑', value: 8},
        {name: '完全不考虑', value: 9},

    ]
})

var modify = xmSelect.render({
    el: '#modify',
    language: 'zn',
    filterable: true,
    searchTips: '搜索标签',
    tips: '选择意向',
    height: '500px',
    autoRow: true,
    code:0,
    prop: {
        name: 'name',
        value: 'id',
    },

})
axios({
    method: 'get',
    url: '/dictionary/list/label',
}).then(response => {
    var res = response.data;
    modify.update({
        data: res,
    })
});


