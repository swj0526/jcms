layui.use(['element', 'layer', 'form', 'jquery', 'laydate','table'], function () {
    var table = layui.table;
    var element = layui.element;
    var layer = layui.layer;
    var form = layui.form;
    var $ = layui.jquery;
    var laydate = layui.laydate;
    //时间
    laydate.render({
        elem: '#searchTime' //指定元素
        ,range: true
    });
    //时间
    laydate.render({
        elem: '#startTime' //指定元素

    });
    //时间
    laydate.render({
        elem: '#endTime' //指定元素

    });

    table.render({
        elem: '#test'
        , title: '用户数据表'
        , url: "/internship/list"
            , parseData: function (res) { //res 即为原始返回的数据
                return {
                    "code": "0",
                    "count": res.pager.dataTotal,
                    data: res.result
                }
            }
            ,id: 'testReload'
        ,cols: [
            [{
                field: 'name',
                title: '姓名',
                event: 'setSign',
                templet: '<div><a style="color: #1E9FFF;cursor:pointer;" class="info" value={{d.id}} >{{d.name}}</a></div>',
                width: 90
            },
                {
                    field: 'sex',
                    title: '性别',
                    align: 'center',
                    width: 90
                },
                {
                    field: 'school',
                    title: '学校'
                },
                {
                    field: 'startDate',
                    title: '开始时间'
                },

                {
                    field: 'endDate',
                    title: '结束时间'
                },
                {
                    title: '操作',
                    templet: '#barDemo',
                    fixed: "right",
                    width: 250
                }
            ]
        ]

        , page: true
    });

    // 搜索操作
    var $ = layui.$, active = {
        reload: function () {
            //执行重载
            table.reload('testReload', {
                page: {
                    curr: 1 //重新从第 1 页开始
                }
                , where: {
                    'keywords': $("#keywords").val(),
                    'searchTime': $("#searchTime").val(),
                    'timeState':$("#timeState").val()
                }
            }, 'data');
        }
    };
    $('.demoTable .layui-btn').on('click', function () {
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';

    });


    var mainIndex;
    //修改弹窗
    function addStudents(data) {
        mainIndex = layer.open({
            type: 1,
            title: "修改信息",
            area: ['720px', '350px'], //设置宽高
            content: $("#addlabel"),
            success:function (index) {
                form.val("dataForm", data);
            },
            end: function () {//修改后刷新当前页
                $(".layui-laypage-btn").click();
            }
        });
    }

    //监听行工具事件
    table.on('tool(test)', function (obj) {
        var data = obj.data;
        let id = data.id;
        //console.log(obj)
        if (obj.event === 'del') {
            layer.confirm('真的删除行么', function (index) {
                obj.del();
                layer.close(index);
                $.post('/internship/delete'+'?id='+id,function (result) {
                    if (result.success==true){
                    layer.msg("删除成功")
                    }
                })
            });
        } else if (obj.event === 'edit') {
            addStudents(data);
        } else if (obj.event === 'setSign') {
            parent_tab("list" + id, "学生详情", "/student/information?id=" + id);
        }

        form.on('submit(addRecruitBtn)', function(data){
            let serialize = $("#data").serialize();
            $.post("/internship/modify" + '?id=' + id,serialize,function (result) {
                layer.close(mainIndex);


            })
        })

    });
});
