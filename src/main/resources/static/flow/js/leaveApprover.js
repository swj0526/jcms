layui.use('table', function () {
    var table = layui.table;
    var form = layui.form;
    var layer = layui.layer;
    $ = layui.jquery;
    //监听行工具事件
    table.on('tool(test)', function(obj){
        var data = obj.data;
        mainIndex = layer.open({
            type: 1,
            title: "查看请假审批详情",
            skin: 'layui-layer-rim', //加上边框
            area: ['310px', '700px'], //设置宽高
            content: $("#updateOrDelete"),
            success: function (index) {
                form.val("dataForm", data);
                url = "/update"
            }
        });
    });
});
//日期方法
layui.use('laydate', function () {
    var laydate = layui.laydate;
    //常规用法
    laydate.render({
        elem: '#test1'
    });
    laydate.render({
        elem: '#test2'
    });
    //日期范围
    laydate.render({
        elem: '#test6',
        range: true
    });
});
