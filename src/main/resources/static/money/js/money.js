layui.use(['table', 'jquery', 'laydate', 'form', 'element'], function () {
    var table = layui.table;
    var $ = layui.jquery;
    laydate = layui.laydate;
    form = layui.form,
        table.render({
            elem: '#test'
            /*,url:'/test/table/demo1.json'*/
            , toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
            , defaultToolbar: []
            , title: '用户数据表'
            , cols: [[
                {field: 'id', title: 'ID', width: 80, fixed: 'left', unresize: true, sort: true}
                , {field: 'name', title: '姓名'}
                , {field: 'grade', title: '年级'}
                , {field: 'type', title: '缴费类型'}
                , {field: 'paymentMethod', title: '缴费方式'}
                , {field: 'money', title: '金额'}
                , {field: 'date', title: '缴费日期'}
                , {field: 'instalment', title: '是否一次性缴费'}
                , {field: 'discount', title: '优惠金额'}
                , {field: 'Validity', title: '费用有效期'}
                , {fixed: 'right', title: '操作', toolbar: '#barDemo'}
            ]]
            , page: true
            , data: [{
                id: "10001"
                , name: '张三'
                , grade: '一年级'
                , type: '学费'
                , money: "3000"
                , date: "2019-11-14"
                , paymentMethod: "支付宝"
                , instalment: "是"
                , discount: "0"
                , Validity: "2020-11-14"
            }]
        });
    $("#add").click(function () {
        layer.open({
            btnAlign: 'c'
            , type: 1
            , skin: 'layer-ext-myskin'
            , btn: ['提交']
            , area: ['720px', '350px']
            , content: $("#aa")
            , yes: function (index, layero) {
                layer.close(index);
            }
            , success: function (index) {
                $("#dataFor")[0].reset();
            }
        });
    });
    $("#export").click(function () {

    })
    //监听行工具事件
    table.on('tool(test)', function (obj) {
        var data = obj.data;
        //console.log(obj)
        if (obj.event === 'edit') {
            layer.open({
                btnAlign: 'c'
                , type: 1
                , btn: ['提交']
                , content: $("#aa")
                , yes: function (index, layero) {
                    layer.close(index);
                }
                , success: function (index) {
                    form.val("dataForm", data);
                }
            });
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
    $("#ss").click(function () {
        layer.open({
            btnAlign: 'c'
            , type: 2
            , area: ['500px', '650px']
            , btn: ['确定']
            , content: 'kkk'
        });
    });
});