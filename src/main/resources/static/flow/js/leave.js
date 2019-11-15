layui.use('table', function () {
    var table = layui.table;

    table.render({
        elem: '#test'
        , title: '用户数据表'
        , cols: [[
            {field: 'id', title: '序号', fixed: 'left',align: 'center', sort: true}
            , {field: 'name', title: '姓名',align: 'center'}
            , {field: 'grade', title: '年级',align: 'center'}
            , {field: 'days', title: '请假时长',align: 'center'}
            , {field: 'apply', title: '申请日期',align: 'center'}
            , {field: 'leaveTime', title: '请假日期',align: 'center'}
            , {field: 'cause', title: '请假事由',align: 'center'}
            , {field: 'state', title: '状态',align: 'center'}
            , {fixed: 'right', title: '操作', toolbar: '#barDemo',align: 'center'}
        ]]
        , data: [{
            "id": "10001",
            "name": "张三",
            "grade": "三年级",
            "days": "3天",
            "apply": "2016-10-14",
            "leaveTime": "2016-10-15",
            "state": "拒绝",
            "cause": "有事asdasdasdasfasfasdgdfsdf12"
        }, {
            "id": "10001",
            "name": "张三",
            "grade": "三年级",
            "days": "3天",
            "apply": "2016-10-14",
            "leaveTime": "2016-10-15",
            "state": "拒绝",
            "cause": "有事"
        }, {
            "id": "10001",
            "name": "张三",
            "grade": "三年级",
            "days": "3天",
            "apply": "2016-10-14",
            "leaveTime": "2016-10-15",
            "state": "拒绝",
            "cause": "有事"
        }, {
            "id": "10001",
            "name": "张三",
            "grade": "三年级",
            "days": "3天",
            "apply": "2016-10-14",
            "leaveTime": "2016-10-15",
            "state": "拒绝",
            "cause": "有事"
        }, {
            "id": "10001",
            "name": "张三",
            "grade": "三年级",
            "days": "3天",
            "apply": "2016-10-14",
            "leaveTime": "2016-10-15",
            "state": "同意",
            "cause": "有事"
        }, {
            "id": "10001",
            "name": "张三",
            "grade": "三年级",
            "days": "3天",
            "apply": "2016-10-14",
            "leaveTime": "2016-10-15",
            "state": "拒绝",
            "cause": "有事"
        }, {
            "id": "10001",
            "name": "张三",
            "grade": "三年级",
            "days": "3天",
            "apply": "2016-10-14",
            "leaveTime": "2016-10-15",
            "state": "拒绝",
            "cause": "有事"
        }, {
            "id": "10001",
            "name": "张三",
            "grade": "三年级",
            "days": "3天",
            "apply": "2016-10-14",
            "leaveTime": "2016-10-15",
            "state": "同意",
            "cause": "有事"
        }]
        , page: true
    });

    var form = layui.form;
    var layer = layui.layer;

    $ = layui.jquery;

    $("#add").on('click', function () {
        layer.open({
            type: 1,
            title: "学生录入",
            btn:['提交'],
            skin: "myclass", // 自定样式
            area: ["400px", "650px"],
            content: $("#aaa"),

            success: function (layero, index) {
            },
            yes: function () {
            }
        });

        form.render(); // 动态渲染
    });

    //请求路径
    var url;
    //标记弹出层
    let mainIndex;

    //修改弹窗
    function modify(data) {
        mainIndex = layer.open({
            type: 1,
            title: "查看请假审批详情",
            skin: 'layui-layer-rim', //加上边框
            area: ['400px', '600px'], //设置宽高
            content: $("#updateOrDelete"),
            success: function (index) {
                form.val("dataForm", data);
                url = "/update"
            }
        });
    }

    //监听行单击事件（单击事件为：rowDouble）
    table.on('row(test)', function(obj){
        var data = obj.data;
        layer.alert(JSON.stringify(data), {
            type: 1,
            title: '当前行数据：',
            content: $("#updateOrDelete"),
            success: function (index) {
                form.val("dataForm", data);
            }
        });

        //标注选中样式
        obj.tr.addClass('layui-table-click').siblings().removeClass('layui-table-click');
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