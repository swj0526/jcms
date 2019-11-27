layui.use(['form', 'table', 'laydate','layer', 'element'], function () {
    var mainIndex;
    var currPage = 1;
    var data;
    var res;
    var $ = layui.jquery,
        form = layui.form,
        element = layui.element,
        table = layui.table,
        layer = layui.layer,
        laydate = layui.laydate;

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
        page: true,
        done: function (rest, curr, count) {
            currPage = curr;
            res =rest;

            /*console.log(currPage);
            console.log(rest);*/

        },
        parseData:function (res) {
            console.log(res);
            return{
                "code":"0",
                "count":res.pager.dataTotal,
                data:res.result,
            }
        },
        id: 'testReload'
    });
    $("#query").click(function () {
        table.reload('testReload', {
            page: {
                curr: 1 //重新从第 1 页开始
            }
            ,where: {
                name: $("#name2").val(),
                hasQuit:$("#hasQuit2").val()
            }
        }, 'data');
    });

    //监听表格复选框选择
    table.on('checkbox(currentTableFilter)', function (obj) {
        console.log(obj)
    });

    function modify(data) {
        mainIndex=layer.open({
            type: 1,
            title: "修改老师信息",
            content: $("#modify1"),
            area: ['350px', '400px'],
            success: function () {
                form.val("dataForm1", data);
            }
        });
        $('#modifyTeacher').click(function() {
            var id=$('#id1').val();
            var name=$('#name1').val();
            var phone=$('#phone1').val();
            var hasQuit=$('#hasQuit1').val();
            if (phone.length<=11&&phone.length>=11){
                $.post('/teacher/modify', {
                    id:id,
                    name : name,
                    phone:phone,
                    hasQuit:hasQuit
                }, function(result) {
                    if (result.success==true){
                        alert("成功");
                        layer.close(mainIndex);
                    }else {
                    }
                });
            }else {
            }

        });
        form.render(); // 动态渲染
    }
    table.on('tool(currentTableFilter)', function (obj) {
        data = obj.data;
        if (obj.event === 'edit') {
            modify(data);
        } else if(obj.event === 'del'){
            layer.confirm('真的删除行么', function(index){
                obj.del();
                $.post('/teacher/delete', {id: data.id}, function (result) {
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
                layer.close(index);
            });
        }
    });

    $("#add1").click(function () {
        mainIndex=layer.open({
            type: 1,
            title: "添加老师信息",
            content: $("#add"),
            area: ['350px', '400px'],
            success: function () {
                //清空表单数据
                $("#dataFrm")[0].reset();
            }
        });
        $('#addTeacher').click(function() {
            var name=$('#name').val();
            var gender=$('#gender').val();
            var phone=$('#phone').val();
            if (phone.length<=11&&phone.length>=11){
                $.post('/teacher/add', {
                    name : name,
                    gender:gender,
                    phone:phone,
                    hasQuit:true
                }, function(result) {
                    if (result.success==true){
                        alert("成功");
                        layer.close(mainIndex);
                    }else {
                        alert(result.msg);
                    }
                });
            }

        });

    });
    //导出点击事件
    $('#excel').click(function () {
        window.location.href="/teacher/doExcel";
    });
});

