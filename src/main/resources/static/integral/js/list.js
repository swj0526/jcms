layui.use(['jquery','layer','table'],function () {
    var $=layui.jquery,
        table = layui.table;
        layer=layui.layer;
    table.render({
        elem: '#currentTableId',
        data: [{
            "id": "1902001",
            "username": "张三",
            "theClass": "影视一班",
            "totalScore": 95,
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
            },
                {
                    field: 'theClass',
                    title: '班级',
                    align: 'center'
                },
                {
                    field: 'totalScore',
                    title: '剩余积分',
                    align: 'center'
                },
                {
                    title: '操作',
                    minWidth: 50,
                    fixed: "right",
                    align: "center",
                    toolbar: '#currentTableBar'
                }
            ]
        ],
        limits: [10, 15, 20, 25, 50, 100],
        limit: 10,
        page: true
    });
    $("#edit").click(function () {
        layer.open({
            type: 1,
            area:['350px','720px'],
            content:$("#table")
        });
    })
})