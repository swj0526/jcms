layui.use(['jquery','layer','table','laydate'],function () {
    var $=layui.jquery,
        table = layui.table,
        layer=layui.layer,
        laydate=layui.laydate;
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
    table.render({
        elem: '#test',
        data: [{
            "time": "1997-10-1",
            "reason": "打架斗殴",
            "totalScore": -5
        }]
        ,cols: [[
            {field:'time', align: 'center', width:200,title: '时间'}
            ,{field:'reason',align: 'center',width:200 ,title: '事由'}
            ,{field:'totalScore', align: 'center',width:200,title: '分数'}
        ]],
        page: true
    });
    $("#edit").click(function () {
        layer.open({
            type: 1,
            area:['610px','350px'],
            content:$("#table")
        });
    })
    laydate.render({
        elem: '#time'
        ,type: 'datetime'
        ,range: true
    });

})