layui.use(['form', 'table', 'jquery', 'layer', 'laydate'], function () {
    var $ = layui.jquery,
        form = layui.form,
        table = layui.table,
        layer = layui.layer,
        laydate = layui.laydate;
    table.render({
        elem: '#currentTableId',
        url: '/history/list',
        id: 'userTableReload',
        cols: [[
            {field: 'studentId', title: 'ID'}
            , {field: 'name', title: '姓名'}
            , {field: 'majorName', title: '班级'}
            , {
                field: 'recordTime', title: '时间', templet: function (d) {
                    return dateToStr(d.recordTime);
                }
            }
            , {field: 'score', title: '加减分'}
            , {field: 'reasonName', title: '事由'}
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
//添加
    $("#addBtn").click(function () {
        layer.open({
            type: 2,
            btnAlign: 'c',
            area: ['60%', '550px'],
            content: '/history/toaddPage',
            btn: [],
            shade: 0
            , end: function () {
                $(".layui-laypage-btn").click();
            }
        });
    })

    /*$("#points").click(function () {
        layer.open({
            type: 2,
            area: ['60%', '550px'],
            content: '/History/tosubtractpage',
            btn: [],
            shade: 0
        });
    })*/
    //查询
    $("#listBtn").click(function () {//查询按钮点击事件
        table.reload('userTableReload', {//table.render里面的id的值
            where: { //设定异步数据接口的额外参数，任意设
                keyword: $("#keyword").val(),
                recordTime: $("#time").val(),
                major: $("#gradeSelect").val()
            }
            , page: {
                curr: 1 //重新从第 1 页开始
            }
        });
    })
    laydate.render({
        elem: '#time'
        , type: 'datetime'
        , range: true
    });
    $('#excelBtn').click(function () {
        window.location.href = "/money/toExcel";
    });

});
function dateToStr(date) {
    var time = new Date(date);
    var y = time.getFullYear();
    var M = time.getMonth() + 1;
    M = M < 10 ? ("0" + M) : M;
    var d = time.getDate();
    d = d < 10 ? ("0" + d) : d;
    var h = time.getHours();
    h = h < 10 ? ("0" + h) : h;
    var m = time.getMinutes();
    m = m < 10 ? ("0" + m) : m;
    var s = time.getSeconds();
    s = s < 10 ? ("0" + s) : s;
    var str = y + "-" + M + "-" + d + " " + h + ":" + m + ":" + s;
    console.log(str);
    return str;
}