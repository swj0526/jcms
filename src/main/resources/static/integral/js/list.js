layui.use(['jquery', 'layer', 'table', 'laydate'], function () {
    var $ = layui.jquery,
        table = layui.table,
        layer = layui.layer,
        laydate = layui.laydate;
    table.render({
        elem: '#currentTableId',
        url: '/integral/list',
        id: 'userTableReload',
        cols: [[{
            field: 'studentId', title: 'ID', align: 'center'
        }
            , {field: 'name', title: '姓名', align: 'center'}
            , {field: 'majorName', title: '班级', align: 'center'}
            , {field: 'totalScore', title: '剩余积分', align: 'center'}
            , {
                title: '操作', minWidth: 50, fixed: "right", align: "center", toolbar: '#barDemo'
            }]],
        page: true
        , parseData: function (res) { //res 即为原始返回的数据
            console.log(res);
            return {
                code: '0'
                , data: res.result
                , count: res.pager.dataTotal
            }
        },
    });
    table.on('tool(test)', function (obj) {
        var data = obj.data;
        //console.log(obj)
        if (obj.event === 'edit') {
            layer.open({
                btnAlign: 'c'
                , type: 2
                , btn: ['确定', '返回']
                , area: ['720px', '350px']
                , title: '查看详情'
                , btn: []
                , content: '/integral/toparticular?id='+data.id
            });

        }
    });
    $("#listBtn").click(function () {//查询按钮点击事件
        table.reload('userTableReload', {//table.render里面的id的值
            where: { //设定异步数据接口的额外参数，任意设
                keyword: $("#keyword").val(),
                start: $("#ScoreA").val(),
                end: $("#ScoreB").val()
            }
            , page: {
                curr: 1 //重新从第 1 页开始
            }
        });
    })

})