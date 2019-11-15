layui.use('table', function () {
    var table = layui.table;

    table.render({
        elem: '#test',
        defaultToolbar: [, { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
            title: '提示',
            layEvent: 'LAYTABLE_TIPS',
            icon: 'layui-icon-tips'
        }],
        title: '用户数据表',
        cols: [[{type: 'checkbox',fixed: 'left'}
            , {field: 'id', title: '序号', edit: 'text'}
            , {field: 'title', title: '标题', edit: 'text'}
            , {field: 'role', title: '角色', edit: 'text'}
            , {field: 'publisher', title: '发布人', edit: 'text'}
            , {field: 'articleype', title: '类型', edit: 'text'}
            , {field: 'joinTime', title: '发布时间', edit: 'text'}
            , {field: 'state', title: '状态', edit: 'text'}
            , {fixed: 'right', title: '操作', toolbar: '#barDemo'}
            ]],
        data: [{
            "id": "10001",
            "title": "Hi",
            "role": "学生",
            "publisher": "杜甫",
            "articleype": "公告",
            "state": "已读",
            "joinTime": "2016-10-14"
        }, {
            "id": "10002",
            "title": "Hi",
            "role": "学生",
            "publisher": "杜甫",
            "articleype": "公告",
            "state": "未读",
            "joinTime": "2016-10-14"
        }, {
            "id": "10003",
            "title": "Hi",
            "role": "学生",
            "publisher": "杜甫",
            "articleype": "通知",
            "state": "未读",
            "joinTime": "2016-10-14"
        }, {
            "id": "10004",
            "title": "Hi",
            "role": "学生",
            "publisher": "杜甫",
            "articleype": "公告",
            "state": "未读",
            "joinTime": "2016-10-14"
        }, {
            "id": "10005",
            "title": "Hi",
            "role": "学生",
            "publisher": "杜甫",
            "articleype": "公告",
            "state": "已读",
            "joinTime": "2016-10-14"
        }, {
            "id": "10006",
            "title": "Hi",
            "role": "学生",
            "publisher": "杜甫",
            "articleype": "通知",
            "state": "未读",
            "joinTime": "2016-10-14"
        }, {
            "id": "10007",
            "title": "Hi",
            "role": "学生",
            "publisher": "贤心",
            "articleype": "公告",
            "state": "已读",
            "joinTime": "2016-10-14"
        }, {
            "id": "10008",
            "title": "Hi",
            "role": "学生",
            "publisher": "贤心",
            "articleype": "通知",
            "state": "已读",
            "joinTime": "2016-10-14"
        }],
    });

    var form = layui.form;
    var layer = layui.layer;

    $ = layui.jquery;

    $("#add").on('click', function () {
        layer.open({
            type: 1,
            title: "学生录入",
            skin: "myclass", // 自定样式
            area: ["400px", "600px"],
            content: $("#aaa"),

            success: function (layero, index) {
            },
            yes: function () {
            }
        });

        $('#student').click(function () {
            var xName = $('#xname').val();
            var age = $('#age').val();
            var gradeId = $('#grade').val();
            $.post('/studentAdd', {
                name: xName,
                age: age,
                gradeid: gradeId
            }, function (a, b) {
                alert(b.id);
            });
        });
        form.render(); // 动态渲染
    });
});
//日期方法
layui.use('laydate', function () {
    var laydate = layui.laydate;
    //常规用法
    laydate.render({
        elem: '#test1'
    });
});
layui.use('laydate', function () {
    var laydate = layui.laydate;

    //日期范围
    laydate.render({
        elem: '#test6',
        range: true
    });

});
