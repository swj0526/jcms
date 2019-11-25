/*var a = new Array();
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
}];*/
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
        cols: [[{field: 'id', title: '编号', city: "", sort: true, align: 'center'}
            , {field: 'name', title: '姓名', align: 'center'}
            , {field: 'gender', title: '性别', align: 'center',}
            , {field: 'phone', title: '电话', align: 'center'}
            , {field: 'hasQuit', title: '是否在职', align: 'center',templet: function(d) {
                    if (d.hasQuit == true){
                        return '在职';
                    }
                    if (d.hasQuit == false){
                        return '离职';
                    }

                }}
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
    $('#excel').click(function () {
        window.location.href="/teacher/doExcel";
    });

    function modify(data) {
        layer.open({
            type: 1,
            title: "修改老师信息",
            content: $("#modify1"),
            area: ['350px', '400px'],
            success: function (index) {
                form.val("dataForm1", data);
            }
        });
        $('#modifyTeacher').click(function() {
            var id=$('#id1').val();
            alert(id);
            var name=$('#name1').val();
            var gender=$('#gender1').val();
            var hasQuit=$('#hasQuit1').val();
            $.post('/teacher/modifyTeacher', {
                id:id,
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
            title: "添加老师信息",
            content: $("#add"),
            area: ['350px', '400px'],
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
                phone:phone,
                hasQuit:true
            }, function(a,b) {
                alert(b.id);
            });
        });
        form.render(); // 动态渲染
    });
    $("#import").click(function () {
        layer.open({
            type: 1,
            title: "添加学生信息",
            content: $("#importForm"),
            btn: "提交",
            area: ['750px', '320px'],
        })
    });
});

