layui.use('table', function () {
    var table = layui.table;
    var form = layui.form;
    var layer = layui.layer;
    $ = layui.jquery;
    //监听行工具事件

    table.on('tool(test)', function(obj){
        if(obj.event === 'see'){
            layer.open({
                type: 1,
                title: "请假申请",
                skin: "myclass", // 自定样式
                area: ["100%", "100%"],
                content: $("#updateOrDelete"),
                success: function (layero, index) {
                },
                yes: function () {
                }
            });
            form.render(); // 动态渲染
        }else if(obj.event === 'edit'){
            layer.open({
                type: 1,
                title: "请假申请",
                skin: "myclass", // 自定样式
                area: ["100%", "100%"],
                content: $("#aaa"),
                success: function (layero, index) {
                },
                yes: function () {
                }
            });
            form.render(); // 动态渲染
        }
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
