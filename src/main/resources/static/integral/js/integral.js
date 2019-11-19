layui.use(['form', 'table', 'jquery','layer'], function () {
    var $=layui.jquery,
        form = layui.form,
        table = layui.table;
        layer=layui.layer;
    table.render({
        elem: '#currentTableId',
        data: [{
            "id": "1902001",
            "username": "张三",
            "time":"1990-10-1",
            "theClass": "影视一班",
            "reason": "打架斗殴",
            "score": -5
        }],
        cols: [
            [{
                field: 'id',
                title: 'ID',
                align: 'center'
            }, {
                field: 'username',
                title: '姓名',
                align: 'center'
            },{
                field: 'time',
                title: '时间',
                align: 'center'
            },
                {
                    field: 'theClass',
                    title: '班级',
                    align: 'center'
                },
                {
                    field: 'score',
                    title: '加减分',
                    align: 'center'
                },
                {
                    field: 'reason',
                    title: '事由',
                    align: 'center'
                },

            ]
        ],
        limits: [10, 15, 20, 25, 50, 100],
        limit: 10,
        page: true
    });
$("#add").click(function () {
    layer.open({
        type: 1,
        area:['720px','350px'],
        content:$("#aa"),
        btn:'提交'
    });
})
    $("#points").click(function () {
        layer.open({
            type: 1,
            area:['720px','350px'],
            content:$("#aaa"),
            btn:'提交'
        });
    })



});