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
        layer.msg("跳到文章列表");
    });






});