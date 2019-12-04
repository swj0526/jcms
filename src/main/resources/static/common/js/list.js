layui.use(['form', 'layedit', 'laydate'], function(){
    var form = layui.form
        ,layer = layui.layer
        ,layedit = layui.layedit
        ,laydate = layui.laydate;

    //日期,如果需要时分秒的话,加上(type: 'datetime')
    laydate.render({
        elem: '#date1'
    });
    //日期时间范围
    laydate.render({
        elem: '#scopeDate'
        ,type: 'datetime'
        ,range: true
    });




});