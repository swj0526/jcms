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
                        return '已审批';
                    }
                }}
            , {field: 'firstReason', title: '一审是否通过', align: 'center'}
            , {field: 'secondReason', title: '二审是否通过', align: 'center'}
            , {fixed: 'right', title: '操作', toolbar: '#barDemo', align: 'center'}
        ]]
        , data: [{
            "id": "10001",
            "name": "张三",
            "grade": "三年级",
            "money": "3000",
            "apply": "2016-10-14",
            "start": "2016-10-15",
            "state": "1",
            "firstReason": "同意",
            "secondReason": "不同意",
            "cause": "有事asdasdasdasfasfasdgdfsdf12"
        }, {
            "id": "10001",
            "name": "张三",
            "grade": "三年级",
            "money": "1000",
            "apply": "2016-10-14",
            "start": "2016-10-15",
            "state": "2",
            "firstReason": "同意",
            "secondReason": "不同意",
            "cause": "有事"
        }, {
            "id": "10001",
            "name": "张三",
            "grade": "三年级",
            "money": "300",
            "apply": "2016-10-14",
            "start": "2016-10-15",
            "state": "2",
            "firstReason": "同意",
            "secondReason": "不同意",
            "cause": "有事"
        }]
        , page: true
    });
    var table = layui.table;
    var form = layui.form;
    var layer = layui.layer;

    $ = layui.jquery;

    //监听行工具事件
    table.on('tool(test)', function(obj){
        if(obj.event === 'see'){
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
        }else if(obj.event === 'edit'){
            layer.open({
                type: 1,
                title: "请假申请",
                skin: "myclass", // 自定样式
                area: ["100%", "100%"],
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
    laydate.render({
        elem: '#test2'
    });
    //日期范围
    laydate.render({
        elem: '#test6',
        range: true
    });
});