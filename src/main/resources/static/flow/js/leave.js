layui.use('table', function () {
    var table = layui.table;
    table.render({
        elem: '#test'
        , title: '用户数据表'
        , cols: [[
            {field: 'id', title: '序号', fixed: 'left',align: 'center', sort: true}
            , {field: 'name', title: '姓名',align: 'center'}
            , {field: 'grade', title: '年级',align: 'center'}
            , {field: 'apply', title: '申请日期',align: 'center'}
            , {field: 'leaveTime', title: '请假日期',align: 'center'}
            , {field: 'cause', title: '请假事由',align: 'center'}
            , {field: 'state', title: '状态',align: 'center',templet: function(d) {
                if (d.state == "1"){
                    return '待审批';
                }
                if (d.state == "2"){
                    return '已撤销';
                }
                if (d.state == "3"){
                    return '查看详情';
                }
                }}
            , {fixed: 'right', title: '操作', toolbar: '#barDemo',align: 'center',width:300}
        ]]
        , data: [{
            "id": "10001",
            "name": "张三",
            "grade": "三年级",
            "days": "3天",
            "apply": "2016-10-14",
            "leaveTime": "2016-10-15",
            "state": "1",
            "cause": "有事asdasdasdasfasfasdgdfsdf12"
        }, {
            "id": "10001",
            "name": "张三",
            "grade": "三年级",
            "days": "3天",
            "apply": "2016-10-14",
            "leaveTime": "2016-10-15",
            "state": "2",
            "cause": "有事"
        }, {
            "id": "10001",
            "name": "张三",
            "grade": "三年级",
            "days": "3天",
            "apply": "2016-10-14",
            "leaveTime": "2016-10-15",
            "state": "3",
            "cause": "有事"
        }, {
            "id": "10001",
            "name": "张三",
            "grade": "三年级",
            "days": "3天",
            "apply": "2016-10-14",
            "leaveTime": "2016-10-15",
            "state": "3",
            "cause": "有事"
        }, {
            "id": "10001",
            "name": "张三",
            "grade": "三年级",
            "days": "3天",
            "apply": "2016-10-14",
            "leaveTime": "2016-10-15",
            "state": "3",
            "cause": "有事"
        }, {
            "id": "10001",
            "name": "张三",
            "grade": "三年级",
            "days": "3天",
            "apply": "2016-10-14",
            "leaveTime": "2016-10-15",
            "state": "3",
            "cause": "有事"
        }, {
            "id": "10001",
            "name": "张三",
            "grade": "三年级",
            "days": "3天",
            "apply": "2016-10-14",
            "leaveTime": "2016-10-15",
            "state": "3",
            "cause": "有事"
        }]
        , page: true
    });


    var form = layui.form;
    var layer = layui.layer;

    $ = layui.jquery;
    form.on("submit(formDemo)", function (obj) {
        //序列化表单提交数据
        var serialize = $("#dataFor").serialize();
        //发送ajasx请求
        var id = obj.id;
        $.post(url, serialize, function (result) {
            layer.msg("成功");
            //关闭弹出层
            layer.close(mainIndex);
            //刷新数据表格
            tableIns.reload();
        });
    });
    $("#add").on('click', function () {
        layer.open({
            type: 1,
            title: "请假申请",
            btn:['提交'],
            skin: "myclass", // 自定样式
            area: ["1000px", "450px"],
            content: $("#aaa"),

            success: function (layero, index) {
            },
            yes: function () {
            }
        });

        form.render(); // 动态渲染
    });

    table.on('tool(test)', function(obj){
        var data = obj.data;
        //console.log(obj)
        if(obj.event === 'del'){
            layer.confirm('真的删除行么', function(index){
                obj.del();
                layer.close(index);
            });
        }else if(obj.event === 'edit'){
            layer.open({
                type: 1,
                title: "请假申请",
                skin: "myclass", // 自定样式
                area: ["100%", "100%"],
                content: $("#updateOrDelete"),
                success: function (layero, index) {
                },
                yes: function () {
                }
            });
            form.render(); // 动态渲染
        }else if(obj.event === 'revoke'){
            layer.confirm('真的撤销吗', function(index){
                obj.del();
                layer.close(index);
            });
        }else if(obj.event === 'again'){
            layer.open({
                type: 1,
                title: "请假申请",
                btn:['提交'],
                skin: "myclass", // 自定样式
                area: ["1000px", "450px"],
                content: $("#aaa"),
                success: function (layero, index) {
                },
                yes: function () {
                }
            });

            form.render(); // 动态渲染
        }
    });


});
//日期方法
layui.use('laydate', function () {
    var laydate = layui.laydate;

    //日期范围
    laydate.render({
        elem: '#test6',
        range: true
    });
    laydate.render({
        elem: '#test7'
        , type: 'datetime'
    });
    laydate.render({
        elem: '#test5'
        , type: 'datetime'
    });
});

