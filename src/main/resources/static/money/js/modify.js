layui.use(['table', 'jquery', 'laydate', 'form', 'element'], function () {
    var table = layui.table;
    var $ = layui.jquery;
    laydate = layui.laydate;
    form = layui.form

    var index = parent.layer.getFrameIndex(window.name);

    var a=$("#Instalment").val();
    var select = 'dd[lay-value=' + a + ']';
    $('#hasInstalment').siblings("div.layui-form-select").find('dl').find(select).click();

    $("#update").click(function () {
        var t = $('#dataFor').serialize();
        $.post('/money/modify',
            t
            , function (result) {
            if (result.success){
                parent.layer.close(index);
            }else {

            }

                /*layer.open({
                    btnAlign: 'c'
                    , area: ['100px', '150px']
                    , content: '<p style="text-align: center">修改成功</p>'
                    , btn: ['确定']
                    , yes: function () {

                    }
                })*/

            });
    })
    laydate.render({
        elem: '#test3'
    });
    laydate.render({
        elem: '#test1'
    });
    laydate.render({
        elem: '#test2'
    });
    $("#type3").click(function () {
        layer.open({
            btnAlign: 'c'
            , type: 2
            , area: ['720px', '350px']
            , btn: ['确定']
            , content: 'tosemester'
        });
    });
    $("#type2").click(function () {
        layer.open({
            btnAlign: 'c'
            ,title:'方式'
            , type: 2
            , area: ['720px', '350px']
            , btn: ['确定']
            , content: 'topaymentMethod'
        });
    });
    $("#type1").click(function () {
        layer.open({
            btnAlign: 'c'
            , type: 2
            , area: ['720px', '350px']
            , btn: ['确定']
            , content: 'totype'
        });
    });


});
