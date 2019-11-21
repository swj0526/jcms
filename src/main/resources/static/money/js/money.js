layui.use(['table', 'jquery', 'laydate', 'form', 'element'], function () {
    var table = layui.table;
    var $ = layui.jquery;
    laydate = layui.laydate;
    form = layui.form,
        table.render({
            elem: '#test'
            /*,url:'/test/table/demo1.json'*/
            , defaultToolbar: []
            , title: '用户数据表'
            , cols: [[
                {field: 'id', title: '学号', width: 80, fixed: 'left', unresize: true, sort: true}
                , {field: 'name', title: '姓名'}
                , {field: 'semester', title: '学年'}
                , {field: 'Type', title: '缴费类型'}
                , {field: 'paymentMethod', title: '缴费方式'}
                , {field: 'totalAmount', title: '总金额'}
                , {field: 'hasInstalment', title: '是否分期'}
                , {field: 'payDate', title: '缴费日期'}
                , {field: 'discountAmount', title: '优惠金额'}
                , {field: 'payAmount', title: '金额'}
                , {field: 'factAmount', title: '总计'}
                , {field: 'startTime', title: '开始时间'}
                , {field: 'endTime', title: '结束时间'}
                , {
                    field: 'invoice',
                    title: '收据',
                    event:'invoice',
                    templet: '<div><img src="{{d.invoice}}" style="height: 50px;width: 50px" ></div>'
                }
                , {field: 'remark', title: '备注',event:'remark'}
                , {fixed: 'right', title: '操作', toolbar: '#barDemo',width: 150}
            ]]
            , page: true
            , data: [{
                id: "10001"
                , name: '张三'
                , semester: '20年'
                , Type: '住宿费'
                ,totalAmount:'3000'
                , payAmount: "3000"
                , payDate: "2019-11-13"
                , paymentMethod: "现金"
                , hasInstalment: "是"
                , discountAmount: "0"
                ,factAmount:'3000'
                , startTime: "2019-11-14"
                ,endTime:'2020-11-14'
                , invoice: '../work/img/1.png'
                , remark: '备注少时诵诗书所所所撒所所所所所所所所所所所所所所所所'
            }]
        });
    $("#add").click(function () {
        layer.tab({
            type: 1,
            area: ['100%', '100%'],
            tab: [{
                title: '添加缴费',
                content: '<iframe src="/money/add" frameborder="0" height="800px" width="100%"></iframe>',
            }]
        });
    });
    $("#export").click(function () {
    })
    //监听行工具事件
    table.on('tool(test)', function (obj) {
        var data = obj.data;
        //console.log(obj)
        if (obj.event === 'edit') {
            layer.tab({
                btnAlign: 'c'
                , type: 1
                , area: ['100%', '100%']
                , btn: ['提交']
                , success: function (index) {
                    form.val("dataForm1", data);
                }
                , tab: [{
                    title: '修改信息'
                    , content: $("#addpage").html()

                }]
            });
        }else if(obj.event==='invoice'){
            layer.open({
                btnAlign: 'c'
                , type: 1
                , area: ['700px', '700px']
                , btn: ['确定']
                ,content:'<img src="'+data.invoice+'" style="width: 100%;height: 100%">'
            })
        }else if(obj.event==='remark'){
            layer.open({
                btnAlign: 'c'
                , type: 1
                , area: ['700px', '700px']
                , btn: ['确定']
                ,content:'<div>'+data.remark+'</div>'
            })
        }
    });
    laydate.render({
        elem: '#test6'
        , range: true
    });
    laydate.render({
        elem: '#test1'
    });
    laydate.render({
        elem: '#test2'
    });
});