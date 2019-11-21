var a = new Array();
a = [{
    "id": 1,
    "name": "杜海涛",
    "gender": "男",
    "phone": "18555464445",
    "hasQuit": "离职"
}, {
    "id": 2,
    "name": "李世杰",
    "gender": "男",
    "phone": "15333333333",
    "hasQuit": "在职"

}];
layui.use(['form', 'table', 'laydate', 'layer', 'element'], function () {
    var $ = layui.jquery,
        form = layui.form,
        element = layui.element,
        table = layui.table,
        layer = layui.layer,
        laydate = layui.laydate;

    laydate.render({
        elem: '#time',
        range: true
    });
    table.render({
        elem: '#currentTableId',
        url:'/teacher/list',
        data: a,
        cols: [[{field: 'id', title: '学号', city: "", sort: true, align: 'center'}
            , {field: 'name', title: '姓名', align: 'center'}
            , {field: 'gender', title: '性别', align: 'center',}
            , {field: 'phone', title: '电话', align: 'center'}
            , {field: 'hasQuit', title: '是否在职', align: 'center'}
            , {title: '操作', minWidth: 50, toolbar: '#currentTableBar', fixed: "right", align: "center",}
        ]],
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

    function modify(data) {
        layer.open({
            type: 1,
            title: "修改学生信息",
            content: $("#modify1"),
            area: ['1000px', '300px'],
            success: function (index) {
                form.val("dataForm", data)
            }
        });
        $('#modifyTeacher').click(function() {
            var name=$('#name').val();
            var gender=$('#gender').val();
            var hasQuit=$('#hasQuit').val();
            $.post('/teacher/modifyTeacher', {
                name : name,
                gender:gender,
                hasQuit:hasQuit
            }, function(a,b) {
                alert(b.id);
            });
        });
        form.render(); // 动态渲染
    }
    table.on('tool(currentTableFilter)', function (obj) {
        data = obj.data;
            modify(data);
    });

    $("#add1").click(function () {
        layer.open({
            type: 1,
            title: "添加学生信息",
            content: $("#add"),
            area: ['1000px', '300px'],
            success: function (index) {
                //清空表单数据
                $("#dataFrm")[0].reset();
            }
        });
        $('#addTeacher').click(function() {
            var name=$('#name').val();
            var gender=$('#gender').val();
            var phone=$('#phone').val();
            $.post('/teacher/addTeacher', {
                name : name,
                gender:gender,
                phone:phone
            }, function(a,b) {
                alert(b.id);
            });
        });
        form.render(); // 动态渲染
    });
});

