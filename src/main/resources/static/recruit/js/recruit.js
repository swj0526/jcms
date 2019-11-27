layui.use(['form', 'table', 'laydate', "jquery"], function () {
    var $ = layui.jquery,
        form = layui.form,
        table = layui.table,
        laydate = layui.laydate;
    //修改弹窗
    var res;
    var mainIndex;
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

    var tableIns = table.render({
        elem: '#currentTableId'
        , url: '/recruit/list'
        , id: 'testReload'
        //解析table 组件规定的数据结构
        , parseData: function (res) { //res 即为原始返回的数据
            /*   console.log(res);*/
            return {
                "code": "0",
                "count": res.pager.dataTotal,
                data: res.result
            }
        },
        done: function (rest, curr, count) {
            //如果是异步请求数据方式，res即为你接口返回的信息。
            //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
            res = rest;


            console.log(rest);
        },
        cols: [
            [{
                field: 'name',
                title: '姓名',
                templet: '<div><a href="/home/main" class="layui-table-link">{{d.name}}</a></div>',
                width: 90
            },
                {
                    field: 'sex',
                    title: '性别',

                    align: 'center',
                    width: 80
                },
                {
                    field: 'labelIds',
                    title: '意向',
                    align: 'center',
                    width: 80

                },
                {
                    field: 'birthDate',
                    title: '出生年月',
                    align: 'center'
                    , width: 150
                },
                {
                    field: 'school',
                    title: '学校'
                    , width: 150

                },
                {
                    field: 'channelName',
                    title: '渠道名称'
                    , width: 100

                },


                {
                    field: 'studentPhone',
                    title: '手机号'
                    , width: 150


                },
                {
                    field: 'qq',
                    title: 'QQ号'
                    , width: 150
                },
                {
                    field: 'weChat',
                    title: '微信'
                    , width: 150
                },
                {
                    field: 'motherPhone',
                    title: '母亲联系方式'
                    , width: 150
                },
                {
                    field: 'fatherPhone',
                    title: '父亲联系方式'
                    , width: 150
                },
                {
                    title: '操作',
                    Width: 300,
                    templet: '#currentTableBar',
                    fixed: "right",
                }
            ]
        ],
        page: true
    });

    // 搜索操作
    var $ = layui.$, active = {
        reload: function () {
            var demoReload = $('#demoReload');
            var sex = $("#sex");
            var labelIds = $("#labelIds");

            //执行重载
            table.reload('testReload', {
                page: {
                    curr: 1 //重新从第 1 页开始
                }
                , where: {
                    'keywords': demoReload.val(),
                    'keywords': demoReload.val(),
                    'keywords': demoReload.val(),
                    'labelIds': labelIds.val(),
                    'sex': sex.val()
                }
            }, 'data');
        }
    };
    $('.demoTable .layui-btn').on('click', function () {
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';

    });
    //监听导出事件
    $("#download").click(function () {
        window.location.href="/recruit/toExcel?page="+1+"&limit="+99999;
    });
    //监听导入事件
    $("#upload").click(function () {
        layer.open({
            type: 1,
            title: "导入跟进学生信息",
            // skin: 'layui-layer-rim', //加上边框
            area: ['730px', '500px'], //设置宽高
            content: $("#download1"),
        });
    });
    // 监听添加操作
    $(".data-add-btn").on("click", function () {
        addStudents();
    });

    //添加招生信息的弹窗
    function addStudents() {
        mainIndex = layer.open({
            type: 2,
            title: "添加招生信息",
            skin: 'layui-layer-rim', //加上边框
            area: ['100%', '100%'], //设置宽高
            content: '/recruit/toadd',
        });
    }

    //添加招生信息
    $("#addSubmit").click(function () {
        var seList = new Array();
        var selectArr = demo1.getValue().valueOf();//获取复选框的值
        $.each(selectArr, function (k, v) {
            $.each(v, function (k1, v1) {
                if (k1 == "value") {
                    seList.push(v1);
                }
            });
        });
        let label = seList.join(",");
        var labelIds = ("," + label + ",");
        var recruit = $("#dataFor").serialize();
        //发送ajax请求
        $.post('/recruit/add', recruit + "&labelIds=" + labelIds, function (result) {
            //下面就是提交成功后关闭自己
            var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
            if (result.success == true) {
                setTimeout(function () {
                    parent.layer.close(index);//关闭弹出层
                    parent.location.reload();//更新父级页面（提示：如果需要跳转到其它页面见下文）
                });
            } else {

            }
        })
    });
    //修改招生信息
    $("#modifySubmit").click(function () {
        var seList = new Array();
        var selectArr = demo1.getValue().valueOf();
        $.each(selectArr, function (k, v) {
            $.each(v, function (k1, v1) {
                if (k1 == "value") {
                    seList.push(v1);
                }
            });
        });
        let label = seList.join(",");
        var labelIds = ("," + label + ",");
        var recruit = $("#modifyFor").serialize();
        var id = $("#modifySubmit").val();
        //发送ajax请求
        $.post('/recruit/modify' + '?id=' + id, recruit + "&labelIds=" + labelIds, function (result) {
            //下面就是提交成功后关闭自己
            var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
            if (result.success == true) {
                setTimeout(function () {
                    parent.layer.close(index);//关闭弹出层
                    /* parent.location.reload();*///更新父级页面（提示：如果需要跳转到其它页面见下文）
                }, 500);
            }
        })
    });
    //添加标签弹窗
    $("#label").click(function () {
        layer.open({
            type: 1,
            title: "添加标签",
            skin: 'layui-layer-rim', //加上边框
            area: ['400px'], //设置宽高
            content: $("#addlabel"),

        });
    });

//监听行
    table.on('tool(currentTableFilter)', function (obj) {
        var data = obj.data;
        var id = data.id;
        if (obj.event === 'edit') {
            mainIndex = layer.open({
                type: 2,
                title: "修改招生信息",
                area: ['100%', '100%'], //设置宽高
                // //查询数据库当前行内容
                content: '/recruit/tomodify?id=' + id,
                end: function () {//修改后刷新当前页
                    $(".layui-laypage-btn").click();
                }
            });
        } else if (obj.event === 'delete') {
            layer.confirm('是否删除:' + data.name, function (index) {
                obj.del();
                layer.close(index);
                $.post('/recruit/delete', {id: data.id}, function (data) {
                    tableIns.reload();
                    if (res.data.length - 1 == 0) {
                        window.location.reload();
                    }
                })
            });
        } else if (obj.event === 'follow') {
            layer.open({
                type: 2,
                area: ['100%', '100%'],
                title: data.name+"详情",
                content: '/details/todetail?id='+id,
                success:function () {
                }


            });
        }
    });


});
