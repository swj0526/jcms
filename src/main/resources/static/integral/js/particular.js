layui.use(['table', 'jquery', 'laydate', 'form', 'element'], function () {
    var table = layui.table;
    var $ = layui.jquery;
    laydate = layui.laydate;
    form = layui.form,
        table.render({
            elem: '#test'
            , url: '/History/list'
            ,where:{
                id:$("#id").val(),
                name:$("#name").val()
            }
            , cols: [[
                {field: 'id', title: '学号', width: 80, fixed: 'left', unresize: true, sort: true}
                , {field: 'name', title: '姓名'}
                , {field: 'major', title: '班级'}
                , {field: 'recordTime', title: '时间'}
                , {field: 'reason', title: '事由'}
                , {field: 'score', title: '分数' }
            ]]
            , data: [{}]
            , parseData: function (res) { //res 即为原始返回的数据
                console.log(res);
                return {
                    code: '0'
                    , data: res.result
                    , count: res.pager.dataTotal
                }
            },
        });
});