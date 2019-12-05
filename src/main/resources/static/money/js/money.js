layui.use(['table', 'jquery', 'laydate', 'form', 'element'], function () {
    var table = layui.table;
    var $ = layui.jquery;
    laydate = layui.laydate;
    form = layui.form,
        table.render({
            elem: '#test'
            , url: '/money/list'
            , id: 'userTableReload'
            , cols: [[
                {field: 'id', title: '学号', width: 80, fixed: 'left', unresize: true, sort: true}
                , {field: 'name', title: '姓名', width: 90}
                , {field: 'semesterName', title: '学年', width: 60}
                , {field: 'typeName', title: '缴费类型', width: 90}
                , {field: 'paymentMethodName', title: '缴费方式', width: 90}
                , {field: 'totalAmount', title: '总金额', width: 90}
                , {field: 'instalment', title: '是否分期'}
                , {field: 'payDate', title: '缴费日期'}
                , {field: 'discountAmount', title: '优惠金额'}
                , {field: 'payAmount', title: '金额'}
                , {field: 'factAmount', title: '总计'}
                , {field: 'startTime', title: '开始时间'}
                , {field: 'endTime', title: '结束时间'}
                , {field: 'invoice', title: '收据',toolbar: '#invoice'}
                , {field: 'remark', title: '备注', event: 'remark'}
                , {fixed: 'right', title: '操作', toolbar: '#barDemo', width: 150}
            ]]
            , data: [{}]
            , page: true
            , parseData: function (res) { //res 即为原始返回的数据
                console.log(res);
                return {
                    code: '0'
                    , data: res.result
                    , count: res.pager.dataTotal
                }
            },
        });
    $("#addPayBillBtn").click(function () {
        layer.open({
            btnAlign: 'c',
            type: 2,
            title: '添加缴费信息',
            skin: 'layer-ext-myskin',
            area: ['100%', '100%'],
            btn: [],
            content: '/money/toaddBillPage',
        });
    });
    //监听行工具事件
    table.on('tool(test)', function (obj) {
        var data = obj.data;
        //console.log(obj)
        if (obj.event === 'modifyBtn') {
            layer.open({
                btnAlign: 'c'
                , type: 2
                , btn: ['确定', '返回']
                , area: ['100%', '100%']
                , title: '修改缴费信息'
                , btn: []
                , content: '/money/tomodify?id=' + data.id + ''
                , end: function () {//修改后刷新当前页
                    $(".layui-laypage-btn").click();

                }
            });
        } else if (obj.event === 'invoiceBtn') {
            layer.open({
                btnAlign: 'c'
                , type: 1
                , area: ['700px', '700px']
                , btn: ['确定']
                , content: '<img src="/money/img/1.png" style="width: 100%;height: 100%">'
            })
        } else if (obj.event === 'remarkBtn') {
            layer.open({
                btnAlign: 'c'
                , type: 1
                , area: ['700px', '700px']
                , btn: ['确定']
                , content: '<div>' + data.remark + '</div>'
            })
        }
    });
    laydate.render({
        elem: '#date'
        , range: true
    });
    $("#listBtn").click(function () {//查询按钮点击事件
        table.reload('userTableReload', {//table.render里面的id的值
            where: { //设定异步数据接口的额外参数，任意设
                keyword: $("#keyword").val(),
                typeId: $("#typeId").val(),
                time: $("#date").val()
            }
            , page: {
                curr: 1 //重新从第 1 页开始
            }
        });
    })
    $('#excelBtn').click(function () {
        window.location.href = "/money/toExcel";
    });
});
