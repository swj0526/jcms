layui.use(['form', 'table', 'jquery'], function () {
    var $ = layui.jquery,
        form = layui.form,
        table = layui.table;
    var currPage = 1;
    var data;
    var res;
    var tableIns = table.render({
        elem: '#roleTable'
        , url: '/account/role/list',
        cols: [
            [
                {
                    field: 'name',
                    title: '角色名称',
                },
                {
                    field: 'remark',
                    title: '角色备注',
                },
                {
                    title: '操作',
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
    /*
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


        });*/
    //头工具栏事件
    table.on('toolbar(roleTable)', function (obj) {
        var checkStatus = table.checkStatus(obj.config.id);
        switch (obj.event) {
            case 'refreshBtn':
                tableIns.reload();
                break;
        }
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
            title: "修改角色信息",
            area: ['400px'], //设置宽高
            content: $("#updatePop"),
            success: function (index) {
                //获取
                form.val("dataForm1", data);
                //清空

                //刷新
                tableIns.reload();

            }
        });
    }

    $('#roleAdd').click(function () {
        addStudents(data);
    });
    //添加弹窗
    var addPop;

    function addStudents(data) {
        addPop = layer.open({
            type: 1,
            title: "新增角色信息",
            area: ['400px'], //设置宽高
            content: $("#addPop"),
            success: function (index) {
                //清空
                $("#dataFor")[0].reset();
                //刷新
                tableIns.reload();
            }
        });
    }

    form.on('submit(addRoleBtn)', function (data) {
        var name = $("[name='addName']").val();
        var remark = $("[name='addRemark']").val();
        $.post("/account/role/add", {
            name: name,
            remark: remark
        }, function (result) {
            if (result.success) {
                layer.close(addPop);
            } else {
                layer.msg(result.msg);
            }
        });
    });
    $('#modifyBtn').click(function () {
        var name = $("[name='name']").val();
        var remark = $("[name='remark']").val();
        $.post("/account/modify", {
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

    table.on('tool(roleTable)', function (obj) {
       var data = obj.data;

        if (obj.event === 'edit') {
            modifyStudents(data);
        } else if (obj.event === 'delete') {
            layer.confirm('真的删除行么', {
                    btn: ['确定', '取消'],
                    yes: function (index, layero) {
                        $.post('/account/delete', {id: data.id}, function (result) {
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
        } else if (obj.event === 'fun') {
            parent_tab("privilege_"+data.id, "权限管理", "/account/toprivilege?roleId=" + data.id);
        }

    });


});
