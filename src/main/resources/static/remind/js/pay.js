layui.use(['table', 'layer', 'jquery', 'form', 'laydate'], function () {
    var table = layui.table;
    var layer = layui.layer;
    var $ = layui.jquery;
    var form = layui.form;
    var laydate = layui.laydate;
    //渲染数据表格
    var tableIns = table.render({
        elem: '#test'//渲染目标
       , url: '/money/list/remind'
        , id: 'testReload'
        //解析table 组件规定的数据结构
        , parseData: function (res) { //res 即为原始返回的数据
            /*   console.log(res);*/
            return {
                "code": "0",
                "count": res.pager,
                data: res
            }
        }
        , cols: [[
            {field: 'name', title: '学生姓名/学号'},
            {field: 'majorName', title: '专业-班级'},
            {field: 'startTime', title: '上次缴费时间'},
            {field: 'factAmount', title: '上次缴费金额'},
            {field: 'endTime', title: '学费到期时间'},
           /* {fixed: 'right', title: '操作', toolbar: '#barDemo'}*/
        ]]

        , page: true
    });
    // 搜索操作
    var $ = layui.$, active = {
        reload: function () {
            //执行重载
            table.reload('testReload', {
                page: {
                    curr: 1 //重新从第 1 页开始
                }
                , where: {
                    'keywords': $("#keywords").val(),

                }
            }, 'data');
        }
    };
    $('.demoTable .layui-btn').on('click', function () {
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';

    });
    $('#see').click(function () {
        layer.msg("跳到学生档案页面查看详情");
    });
    laydate.render({
        elem: '#a' //指定元素
        , range: true
    });

});