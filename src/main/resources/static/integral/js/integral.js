layui.use(['form', 'table', 'jquery', 'layer', 'laydate'], function () {
    var $ = layui.jquery,
        form = layui.form,
        table = layui.table,
        layer = layui.layer,
        laydate = layui.laydate;
    table.render({
        elem: '#currentTableId',
        url:'/History/historylist',
        id:'userTableReload',
        cols: [[
            {field: 'id', title: 'ID' }
            , {field: 'name', title: '姓名' }
            , {field: 'major', title: '班级' }
            , {field: 'recordTime', title: '时间' }
            , {field: 'score', title: '加减分' }
            , {field: 'reason', title: '事由' }
            , {field: 'remark', title: '备注'}
        ]],
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

    $("#add").click(function () {
        layer.open({
            type: 2,
            btnAlign:'c',
            area: ['60%', '550px'],
            content: '/History/toaddPage',
            btn: [],
            shade: 0
        });
    })

    $("#points").click(function () {
        layer.open({
            type: 2,
            area: ['60%', '550px'],
            content: '/History/tosubtractpage',
            btn: [],
            shade: 0
        });
    })
    $("#query").click(function () {//查询按钮点击事件
        table.reload('userTableReload', {//table.render里面的id的值
            where: { //设定异步数据接口的额外参数，任意设
                keyword: $("#keyword").val(),
                recordTime:$("#time").val(),
                major:$("#major").val()
            }
            , page: {
                curr: 1 //重新从第 1 页开始
            }
        });
    })
    laydate.render({
        elem: '#time'
        ,type: 'datetime'
        ,range: true
    });
});