layui.use(['table', 'jquery', 'laydate','form', 'element'], function () {
    var table = layui.table;
    var $ = layui.jquery;
    var element = layui.element;
    laydate = layui.laydate;
    form = layui.form,
    table.render({
        elem: '#test'
        /*, url: '/query'
        , id: 'userTableReload'*/
        , toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
        , defaultToolbar: []
        , title: '用户数据表'
        ,cols: [[
            {field:'workName', title:'作业名称'  }
            ,{field:'name', title:'学生姓名'  }
            ,{field:'issuer', title:'发布人'  }
            ,{field:'grade', title:'年级'  }
            ,{field:'date', title:'发布日期'}
            ,{field:'commitDate', title:'提交时间'}
            ,{field:'work', title:'作业'}
            ,{field:'work', title:'提交人数'}
            ,{field:'score', title:'评分'}
            ,{fixed: 'right', title:'操作', toolbar: '#barDemo'}
        ]]
        , data: [{
            workName: "英语作业"
            , name: "张三"
            ,issuer:"王丽"
            , grade: "三年级"
            , date: "2019-11-14"
            , commitDate: "2019-11-14"
            , work: "11111111"
            , score: "20"
        }]
        , page: true
    });
    $("#1").click(function () {
        layer.open({
            btnAlign: 'c'
            ,type:1
            ,btn:['提交']
            ,area:['350px','450px']
            ,content:$("#aa")
            ,yes: function(index, layero){
                layer.close(index);
            }
        });
    })
    //监听行工具事件
    table.on('tool(test)', function (obj) {
        var data = obj.data;
        //console.log(obj)
        if (obj.event === 'updata') {


        } else if (obj.event === 'edit') {
            layer.tab({
                type: 1,

                area: ['100%','100%'],
                tab: [{
                    title: '学生作业下载',
                    content:'<iframe src="/work/download" frameborder="0" height="800px" width="100%"></iframe>',
                }, {
                    title: '',
                    content: '内容2'
                }, {
                    title: '',
                    content: '内容3'
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