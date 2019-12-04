layui.use(['form', 'table', 'laydate'], function () {
    var $ = layui.jquery,
        form = layui.form,
        table = layui.table,
        laydate = layui.laydate;
    var currPage = 1;
    laydate.render({
        elem: '#a' //指定元素
        , range: true
    });
    laydate.render({
        elem: '#date' //指定元素
    });
    laydate.render({
        elem: '#dat' //指定元素
    });

    var data;
    var res;
    var tableIns = table.render({
        elem: '#followTableId'
        , url: '/dictionary/list/channel',
        cols: [
            [
                {
                    field: 'name',
                    title: '渠道名称',
                },
                {
                    field: 'remark',
                    title: '渠道备注',
                },
                {
                    title: '操作',
                    minWidth: 50,
                    templet: '#currentTableBar',
                    fixed: "right",
                    align: "center",
                }
            ]
        ],
        page: true,
        done: function (rest, curr, count) {
            currPage = curr;
            res =rest;
            console.log(currPage);
            console.log(rest);

        },
        parseData: function (res) { //res 即为原始返回的数据
            /*   console.log(res);*/
            return {
                "code": "0",
                "count": res.pager.dataTotal,
                 data: res.result
            }
        },
        id: 'followRender'
    });

    // 监听搜索操作
    form.on('submit(data-search-btn)', function (data) {
        var keywords = $('[name="keywords"]').val();


        //执行搜索重载
        table.reload('followRender', {
            page: {
                curr: currPage
            },
            where: {
                keywords: keywords

            }
        }, 'data');


    });

    // 监听添加操作
    $(".data-add-btn").on("click", function () {
        addStudents();
    });

    // 监听删除操作
    $(".data-delete-btn").on("click", function () {
        var checkStatus = table.checkStatus('currentTableId'),
            data = checkStatus.data;
        layer.alert(JSON.stringify(data));
    });

    //修改弹窗
    var mainIndex;
    function modifyStudents(data) {
        mainIndex = layer.open({
            type: 1,
            title: "修改渠道信息",
            area: ['400px'], //设置宽高
            content: $("#modify"),
            success: function (index) {
                //获取
                form.val("dataForm", data);



            }
        });
    }

    //添加弹窗
    function addStudents() {
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
    }

    $('#add1').click(function () {
        var name = $("[name='nameA']").val();
        var remark = $("[name='remarkA']").val();
        $.post("/dictionary/add/channel", {
            name: name,
            remark: remark
        }, function (result) {
            if (result.success) {
                layer.close(mainIndex);
            }else{

            }
        });
    });
    $('#addM').click(function () {
        var name = $("[name='name']").val();
        var remark = $("[name='remark']").val();
        $.post("/dictionary/modify", {
            name: name,
            remark: remark,
            id: data.id
        }, function (result) {
            if (result.success) {
                layer.close(mainIndex);
                //刷新
                tableIns.reload();
            }else{

            }
        });
    });

    //查看跟踪信息
    function recruit() {
        layer.open({
            type: 1,
            title: "跟进情况",
            // skin: 'layui-layer-rim', //加上边框
            area: ['800px'], //设置宽高
            content: $("#updateOrDelete"),
            success: function (index) {
                //清空
                $("#dataFor")[0].reset();
                url = "";

            }
        });
    }

    table.on('tool(currentTableFilter)', function (obj) {
        data = obj.data;
        if (obj.event === 'edit') {
            modifyStudents(data);


        } else if (obj.event === 'delete') {
            layer.confirm('真的删除行么', {
                    btn: ['确定', '取消'],
                    yes: function (index, layero) {
                        $.post('/dictionary/delete/channel', {id: data.id}, function (result) {
                            if (result.success) {
                                layer.msg("删除成功!");
                                layer.close(index);
                                tableIns.reload();
                                if (res.data.length-1 == 0) {
                                    window.location.reload();//默认刷新第一页
                                }
                            } else {
                                layer.msg(result.msg);
                            }
                        });

                    }, no: function (index) {
                        layer.close(index);
                    }
                }
            );
        }

    });


});
