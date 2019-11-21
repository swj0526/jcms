var a=new Array();
a=[{
    "id": 1,
    "name": "杜海涛",
    "phone": "18555464445"
},{
    "id": 2,
    "name": "李世杰",
    "phone": "男",
}]
layui.use(['form', 'table', 'laydate', 'layer','element'], function () {
    var $ = layui.jquery,
        form = layui.form,
        element=layui.element,
        table = layui.table,
        layer = layui.layer,
        laydate = layui.laydate;

    laydate.render({
        elem: '#time',
        range: true
    });
    table.render({
        elem: '#currentTableId',
        data: a,
        cols: [
            [{
                field: 'id',
                title: '学号',
                city: "",
                sort: true,
                align: 'center'
            }, {
                field: 'name',
                title: '姓名',
                align: 'center',
            },
                {
                    field: 'phone',
                    title: '性别',
                    align: 'center'
                },
                {
                    title: '操作',
                    minWidth: 50,
                    toolbar: '#currentTableBar',
                    fixed: "right",
                    align: "center",

                }
            ]
        ],
        limits: [10, 15, 20, 25, 50, 100],
        limit: 10,
        page: true
    });

    // 监听搜索操作
    form.on('submit(data-search-btn)', function (data) {
        var result = JSON.stringify(data.field);
        layer.alert(result, {
            title: '最终的搜索信息'
        });

        //执行搜索重载
        table.reload('currentTableId', {
            page: {
                curr: 1
            },
            where: {
                searchParams: result
            }
        }, 'data');

        return false;
    });

    // 监听添加操作
    $(".data-add-btn").on("click", function () {
        layer.msg('添加数据');
    });


    //监听表格复选框选择
    table.on('checkbox(currentTableFilter)', function (obj) {
        console.log(obj)
    });
    function modify(data){
        layer.open({
            type: 1,
            title:"修改学生信息",
            content: $("#aaa"),
            btn:"提交",
            area:['750px','320px'],
            success:function (index) {
                form.val("dataForm",data)
            }
        })
    }
    table.on('tool(currentTableFilter)', function (obj) {
        data = obj.data;
        if (obj.event === 'edit') {
            modify(data);
        } else if (obj.event === 'delete') {
            layer.confirm('真的删除行么', function (index) {
                obj.del();
                layer.close(index);
            });
        }
    });

    $("#add").click(function () {
        layer.open({
            type: 1,
            title:"添加学生信息",
            content: $("#aaa"),
            btn:"提交",
            area:['750px','320px'],
            success:function (index) {
                //清空表单数据
                $("#dataFrm")[0].reset();
            }
        })
    });
    $("#import").click(function () {
        layer.open({
            type: 1,
            title:"添加学生信息",
            content: $("#importForm"),
            btn:"提交",
            area:['750px','320px'],
        })
    });
});

