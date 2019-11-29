layui.use(['jquery', 'layer', 'table', 'laydate'], function () {
    var $ = layui.jquery,
        table = layui.table,
        layer = layui.layer,
        laydate = layui.laydate;
    $("#type3").click(function () {
        layer.open({
            btnAlign: 'c'
            ,type: 2
            ,area:['720px','400px']
            ,title:'添加缴费类型'
            , btn: ['提交','取消']
            , content: '/integral/item/tolist?'
        });
    })
})