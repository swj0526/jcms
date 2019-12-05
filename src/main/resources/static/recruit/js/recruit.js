layui.use(['form', 'table', 'laydate', "jquery"], function () {
    var $ = layui.jquery,
        form = layui.form,
        table = layui.table,
        laydate = layui.laydate;
    //修改弹窗
    var res;
    var mainIndex;
    //时间
    laydate.render({
        elem: '#createTime' //指定元素

    });
    laydate.render({
        elem: '#date' //指定元素

    });
    laydate.render({
        elem: '#dat' //指定元素
    });
//渲染表格
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
                templet: '<div><a href="" class="layui-table-link">{{d.name}}</a></div>',
                width: 90
            },
                {
                    field: 'sex',
                    title: '性别',
                    align: 'center',
                    width: 90
                },
                {
                    field: 'labelNames',
                    title: '意向',
                    align: 'center',

                },

                {
                    field: 'school',
                    title: '学校'

                },
                {
                    field: 'channelName',
                    title: '渠道名称'


                },

                {
                    field: 'studentPhone',
                    title: '手机号'


                },

                {
                    title: '操作',
                    templet: '#currentTableBar',
                    fixed: "right",
                    width: 250
                }
            ]
        ],
        page: true
    });

//下拉选赋值;
    var a=$("#Instalment").val();
    var select = 'dd[lay-value=' + a + ']';
    $('#select1').siblings("div.layui-form-select").find('dl').find(select).click();


    // 搜索操作
    var $ = layui.$, active = {
        reload: function () {
            var demoReload = $('#demoReload');
            var sex = $("#sex");
            var createTime = $("#a");
            let listLabel = new Array();
            let labels = selectcheckbox.getValue().valueOf();//获取复选框的值
            $.each(labels, function (k, v) {
                $.each(v, function (k1, v1) {
                    if (k1 == "id") {
                        listLabel.push(v1);
                    }
                });
            });
            let label = listLabel.join(",");

            //执行重载
            table.reload('testReload', {
                page: {
                    curr: 1 //重新从第 1 页开始
                }
                , where: {
                    'keywords': demoReload.val(),
                    'labelIds': label,
                    'sex': sex.val(),
                    'createTime':createTime.val(),
                    'channelId':$("#channelId").val(),

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

            area: ['100%', '100%'], //设置宽高
            content: '/recruit/toadd',
        });
    }

    //监听添加招生提交
    form.on('submit(addRecruitBtn)', function(data){
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
            } else  if (result.error==false) {
                layer.msg("学生电话,母亲电话有重复");

            }
        })
    });
    });
    //修改招生信息
    $("#modifySubmit").click(function () {
        var seList = new Array();
        let selectArr = modifydiv.getValue().valueOf();
        $.each(selectArr, function (k, v) {
            $.each(v, function (k1, v1) {
                if (k1 == "id") {
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
    //标签弹窗
    var index;
    $("#label").click(function () {
       index= layer.open({
            type: 1,
            title: "添加标签",

            area: ['400px'], //设置宽高
            content: $("#addlabel"),

        });
    });
    //监听提交
    form.on('submit(addlabelbtn)', function(data){
        //添加标签
        $("#addlabelbtn").click(function () {
            var label = $("#data").serialize();
            $.post('/dictionary/add/label',label,function () {
                layer.close(index);
            })
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
//下拉复选赋值
    var selectcheckbox = xmSelect.render({
        el: '#selectcheckbox',
        language: 'zn',
        filterable: true,
        searchTips: '搜索标签',
        tips: '请选择意向',
        height: '500px',
        code:0,
        prop: {
            name: 'name',
            value: 'id',
        },
        model: {
            label: {
                type: 'block',
                block: {
                    //最大显示数量, 0:不限制
                    showCount: 1,
                    //是否显示删除图标
                    showIcon: true,
                }
            }
        },

    })
    axios({
        method: 'get',
        url: '/dictionary/list/label',
    }).then(response => {
        var res = response.data;
        selectcheckbox.update({
            data: res,
        })
    });
});


