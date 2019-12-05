layui.use(['form', 'table', 'jquery'], function () {
    var $ = layui.jquery,
        form = layui.form,
        table = layui.table;
    var currPage = 1;
    var data;
    var res;
    var tableIns = table.render({
        elem: '#followTable'
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
        ], toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
        , defaultToolbar: [{
            title: '刷新表格'
            , layEvent: 'refreshBtn'
            , icon: 'layui-icon-refresh'
        }, {
            title: '添加'
            , layEvent: 'addBtn'
            , icon: 'layui-icon-add-circle'
        }],
        page: true,
        done: function (rest, curr, count) {
            currPage = curr;
            res = rest;
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
    //头工具栏事件
    table.on('toolbar(followTable)', function (obj) {
        var checkStatus = table.checkStatus(obj.config.id);
        switch (obj.event) {
            case 'addBtn':
                mainIndex = layer.open({
                    type: 1,
                    title: "添加渠道信息",
                    area: ['400px'], //设置宽高
                    content: $("#addPopups"),
                    success: function (index) {
                        //清空
                        $("#dataFor")[0].reset();
                        //刷新
                        tableIns.reload();

                    }
                });
                break;
            case 'refreshBtn':
                tableIns.reload();
                break;
        }
        ;
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
            content: $("#modifyPopups"),
            success: function (index) {
                //获取
                form.val("dataForm", data);


            }
        });
    }

    $('#addFollowBtn').click(function () {
        var name = $("[name='addName']").val();
        var remark = $("[name='addRemark']").val();
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
    $('#modifyFollowBtn').click(function () {
        var name = $("[name='modifyName']").val();
        var remark = $("[name='modifyRemark']").val();
        $.post("/dictionary/modify", {
            name: name,
            remark: remark,
            id: data.id
        }, function (result) {
            if (result.success) {
                layer.close(mainIndex);
                //刷新
                tableIns.reload();
            } else {

            }
        });
    });

    table.on('tool(followTable)', function (obj) {
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
                                if (res.data.length - 1 == 0) {
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
