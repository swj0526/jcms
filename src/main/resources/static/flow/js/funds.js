layui.use('table', function () {
    var table = layui.table;

    table.render({
        elem: '#test'
        , title: '用户数据表'
        , cols: [[
            {field: 'id', title: '序号', fixed: 'left', align: 'center', sort: true}
            , {field: 'name', title: '姓名', align: 'center'}
            , {field: 'grade', title: '年级', align: 'center'}
            , {field: 'cause', title: '申请事由', align: 'center'}
            , {field: 'money', title: '申请金额', align: 'center'}
            , {field: 'apply', title: '申请日期', align: 'center'}
            , {field: 'start', title: '开始日期', align: 'center'}
            , {field: 'state', title: '状态', align: 'center',templet: function(d) {
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
            , {fixed: 'right', title: '操作', toolbar: '#barDemo', align: 'center',width:300}
        ]]
        , data: [{
            "id": "10001",
            "name": "张三",
            "grade": "三年级",
            "money": "3000",
            "apply": "2016-10-14",
            "start": "2016-10-15",
            "state": "1",
            "cause": "有事asdasdasdasfasfasdgdfsdf12"
        }, {
            "id": "10001",
            "name": "张三",
            "grade": "三年级",
            "money": "1000",
            "apply": "2016-10-14",
            "start": "2016-10-15",
            "state": "2",
            "cause": "有事"
        }, {
            "id": "10001",
            "name": "张三",
            "grade": "三年级",
            "money": "300",
            "apply": "2016-10-14",
            "start": "2016-10-15",
            "state": "3",
            "cause": "有事"
        }, {
            "id": "10001",
            "name": "张三",
            "grade": "三年级",
            "money": "1000",
            "apply": "2016-10-14",
            "start": "2016-10-15",
            "state": "3",
            "cause": "有事"
        }, {
            "id": "10001",
            "name": "张三",
            "grade": "三年级",
            "money": "2000",
            "apply": "2016-10-14",
            "start": "2016-10-15",
            "state": "3",
            "cause": "有事"
        }, {
            "id": "10001",
            "name": "张三",
            "grade": "三年级",
            "money": "10000",
            "apply": "2016-10-14",
            "start": "2016-10-15",
            "state": "3",
            "cause": "有事"
        }, {
            "id": "10001",
            "name": "张三",
            "grade": "三年级",
            "money": "3000",
            "apply": "2016-10-14",
            "start": "2016-10-15",
            "state": "3",
            "cause": "有事"
        }, {
            "id": "10001",
            "name": "张三",
            "grade": "三年级",
            "money": "2000",
            "apply": "2016-10-14",
            "start": "2016-10-15",
            "state": "3",
            "cause": "有事"
        }]
        , page: true
    });
    var form = layui.form;
    var layer = layui.layer;
    var mainIndex;
    $ = layui.jquery;

    $("#add").on('click', function () {
        mainIndex=layer.open({
            type: 1,
            title: "学生录入",
            btn:['提交'],
            skin: "myclass", // 自定样式
            area: ["1330px", "500px"],
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
            mainIndex=layer.open({
                type: 1,
                title: "经费申请",
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
            mainIndex=layer.open({
                type: 1,
                title: "请假申请",
                btn:['提交'],
                skin: "myclass", // 自定样式
                area: ["1330px", "500px"],
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
    //常规用法
    laydate.render({
        elem: '#test1'
    });

    //日期范围
    laydate.render({
        elem: '#test6',
        range: true
    });
    laydate.render({
        elem: '#test5'
        , type: 'datetime'
    });
    laydate.render({
        elem: '#test7'
        , type: 'datetime'
    });
});