var a=new Array();
a=[{
    "id": 1901001,
    "name": "张三",
    "gender": "男",
    "birthday": "1997-8-10",
    "age":18,
    "address":"花果山水帘洞",
    "nativePlace":"山东威海**市**县**镇",
    "contact":"186693989898",
    "bloodType":"O",
    "admissionTime":"1999-9-9",
    "graduationTime":"2999-9-9",
    "state":"在校",
},{
    "id": 1901002,
    "name": "李四",
    "gender": "男",
    "birthday": "1997-8-10",
    "age":18,
    "address":"花果山水帘洞",
    "nativePlace":"山东威海**市**县**镇",
    "contact":"186693989898",
    "bloodType":"O",
    "admissionTime":"1999-9-9",
    "graduationTime":"2999-9-9",
    "state":"在校"

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
                    templet: '<div><a class="info" value={{d.name}} >{{d.name}}</a></div>'
                },
                {
                    field: 'gender',
                    title: '性别',
                    sort: true,
                    align: 'center'
                },
                {
                    field: 'birthday',
                    title: '出生年月',
                    align: 'center'
                },
                {
                    field: 'age',
                    title: '年龄',
                    sort: true,
                    align: 'center'
                },
                {
                    field: 'address',
                    title: '家庭住址',
                    align: 'center'
                },
                {
                    field: 'nativePlace',
                    title: '籍贯',
                    align: 'center'
                },
                {
                    field: 'contact',
                    title: '联系方式',
                    align: 'center'
                },
                {
                    field: 'bloodType',
                    title: '血型',
                    align: 'center'
                },
                {
                    field: 'admissionTime',
                    title: '入学时间',
                    sort: true,
                    align: 'center'
                },
                {
                    field: 'graduationTime',
                    title: '毕业时间',
                    sort: true,
                    align: 'center'
                },
                {
                    field: 'state',
                    title: '在校状态',
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

    // 监听删除操作
    $(".data-delete-btn").on("click", function () {
        var checkStatus = table.checkStatus('currentTableId'),
            data = checkStatus.data;
        layer.alert(JSON.stringify(data));
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
    $(".info").click(function () {
        var name=$(this).attr("value");
        alert(name)
        element.tabAdd('studentName', {
            title: name
            ,content: $("#aaa") //支持传入html
            ,id: '选项卡标题的lay-id属性值'
        });
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
        alert(1)
        layer.open({
            type: 1,
            title:"添加学生信息",
            content: $("#importForm"),
            btn:"提交",
            area:['750px','320px'],
        })
    });
});

