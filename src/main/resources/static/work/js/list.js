layui.use(['table', 'jquery', 'laydate', 'form', 'element'], function () {
    var table = layui.table;
    var $ = layui.jquery;
    var element = layui.element;
    laydate = layui.laydate;
    form = layui.form,
        table.render({
            elem: '#test'
            /*, url: '/query'
            , id: 'userTableReload'*/
            , defaultToolbar: []
            , title: '用户数据表'
            , cols: [[
                {field: 'name', title: '作业名称'}
                , {field: 'issuer', title: '发布人'}
                , {field: 'major', title: '专业班级'}
                , {field: 'releaseTime', title: '发布日期'}
                , {field: 'endTime', title: '截止时间'}
                , {fixed: 'right', title: '操作', toolbar: '#barDemo',width:230}
            ]]
            , data: [{
                name: "英语作业"
                , issuer: "王丽"
                , major: "影视一班"
                , releaseTime: "2019-11-14"
                , endTime: "2019-11-14"
            }]
            , page: true
        });
    $("#add").click(function () {
        parent_tab("work_add", '发布作业', "/work/add");
    });
    //监听行工具事件
    table.on('tool(test)', function (obj) {
        var data = obj.data;
        //console.log(obj)
        if (obj.event === 'updata') {


        } else if (obj.event === 'edit') {
            layer.tab({
                type: 1,
                area: ['100%', '100%'],
                tab: [{
                    title: '学生作业下载',
                    content: '<iframe src="/work/download" frameborder="0" height="800px" width="100%"></iframe>',
                }]
            });
        }
    });
    var $ = layui.$, active = {
        reload: function () {
            var name = $("#name");
            var gradeId = $("#gradeId");
            //执行重载
            table.reload('userTableReload', {
                where: {
                    'name': name.val(),
                    'grade': gradeId.val()
                }
            }, 'data');
        }
    }
    $('.demoTable .layui-btn').on('click', function () {
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
        return false;
    });
    $('#excel').click(function () {
        window.location.href = "/toExcel";
    });
    laydate.render({
        elem: '#test6'
        , range: true
    });
    laydate.render({
        elem: '#test1'
    });
    laydate.render({
        elem: '#test2'
    });
});