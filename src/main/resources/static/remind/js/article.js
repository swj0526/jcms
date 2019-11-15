//JavaScript代码区域
layui.use(['table', 'layer', 'jquery', 'form'], function () {

    var table = layui.table;
    var layer = layui.layer;
    var $ = layui.jquery;
    var form = layui.form;

    //渲染数据表格
    var tableIns = table.render({
        elem: '#test'//渲染目标
        /* , url: '/json/table.json'//数据接口*/
        , id: 'userTableReload'
        , cols: [[
            {field: 'title', title: '标题'},
            {field: 'explain', title: '摘要'},
            {field:'issuer',title:'发布人'},
            {field:'time',title:'发布时间'},
            {fixed: 'right', title: '操作', toolbar: '#barDemo'}
        ]]
        ,data:[{
            title:"作息时间表",
            explain:'最新的作息时间表',
            issuer:'管理老师',
            time:'2019-11-14'

        }, {
                title:"作息时间表",
                explain:'最新的作息时间表',
                issuer:'管理老师',
                time:'2019-11-14'

            },{
                title:"作息时间表",
                explain:'最新的作息时间表',
                issuer:'管理老师',
                time:'2019-11-14'

            },{
                title:"作息时间表",
                explain:'最新的作息时间表',
                issuer:'管理老师',
                time:'2019-11-14'

            }],
        page:true
    });
    $('#see').click(function () {
        layer.open({
            type: 1
            ,title: false //不显示标题栏
            ,closeBtn: false
            ,area: '800px;'
            ,shade: 0.5
            ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
            ,btn: ['已阅读完','关闭']
            ,btnAlign: 'c'
            ,moveType: 1 //拖拽模式，0或者1
            ,content: '<div style="padding: 50px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;">你知道吗？亲！<br>layer ≠ layui<br><br>layer只是作为Layui的一个弹层模块，由于其用户基数较大，所以常常会有人以为layui是layerui<br><br>layer虽然已被 Layui 收编为内置的弹层模块，但仍然会作为一个独立组件全力维护、升级。<br><br>我们此后的征途是星辰大海 ^_^</div>'
            ,success: function(layero){
                var btn = layero.find('.layui-layer-btn');
                btn.find('.layui-layer-btn0').attr({
                    target: '_blank'
                });
            }
        });
    });






});