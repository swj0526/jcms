layui.use(['form', 'layedit', 'laydate', 'jquery'], function () {
    var form = layui.form
        , layer = layui.layer
        , layedit = layui.layedit
        , laydate = layui.laydate
        , $ = layui.jquery

    //日期
    laydate.render({
        elem: '#date'

    });
    laydate.render({
        elem: '#date1',

    });
//下拉选赋值;
    var a = $("#Instalment").val();
    var select = 'dd[lay-value=' + a + ']';
    $('#schoolState').siblings("div.layui-form-select").find('dl').find(select).click();
    //提交
    $("#addSubmit").click(function () {
        let serialize = $("#dataFor").serialize();
        let id = $("#addSubmit").val();
        $.post('/student/modify' + '?id=' + id, serialize, function (result) {
            if (result.success == true) {
                layer.msg('成功');
                close_tab("add" + id, "student_list", "学生档案管理", "/student/tolist");

            } else {
                layer.msg("填写必填项")

            }
            location.reload()//刷新当前页


        })


    });


});