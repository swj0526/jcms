layui.use('table', function () {
    var table = layui.table;

    table.render({
        elem: '#test',
        title: '用户数据表',
        cols: [[
             {field: 'id', title: '序号',align: 'center'}
            , {field: 'title', title: '标题',align: 'center'}
            , {field: 'role', title: '角色',align: 'center'}
            , {field: 'typeName', title: '公告类型',align: 'center'}
            , {field: 'publisher', title: '发布人',align: 'center'}
            , {field: 'joinTime', title: '发布时间',align: 'center'}
            , {fixed: 'right', title: '操作', toolbar: '#barDemo',align: 'center'}
            ]],
        data: [{
            "id": "10001",
            "title": "Hi",
            "role": "学生",
            "publisher": "杜甫",
            "joinTime": "2016-10-14",

        }, {
            "id": "10002",
            "title": "Hi",
            "role": "学生",
            "publisher": "杜甫",
            "joinTime": "2016-10-14",

        }, {
            "id": "10003",
            "title": "Hi",
            "role": "学生",
            "publisher": "杜甫",
            "articleype": "通知",
            "joinTime": "2016-10-14"
        }, {
            "id": "10004",
            "title": "Hi",
            "role": "学生",
            "publisher": "杜甫",
            "joinTime": "2016-10-14"
        }, {
            "id": "10005",
            "title": "Hi",
            "role": "学生",
            "publisher": "杜甫",
            "joinTime": "2016-10-14"
        }, {
            "id": "10006",
            "title": "Hi",
            "role": "学生",
            "publisher": "杜甫",
            "joinTime": "2016-10-14"
        }, {
            "id": "10007",
            "title": "Hi",
            "role": "学生",
            "publisher": "贤心",
            "joinTime": "2016-10-14"
        }, {
            "id": "10008",
            "title": "Hi",
            "role": "学生",
            "publisher": "贤心",
            "joinTime": "2016-10-14"
        }],
         page: true
    });
    var form = layui.form;
    var layer = layui.layer;
    $ = layui.jquery;
    //详情页
    table.on('tool(test)', function(obj){
        var data = obj.data;
        //console.log(obj)
        layer.open({
            btnAlign: 'c'
            ,type: 2
            ,title:'文章详情'
            ,area: ["100%", "100%"]
            ,btn:['已阅读']
            ,content: 'details'
        });
        form.render(); // 动态渲染
    });
    $("#info").on('click', function () {
        layer.open({
            type: 1,
            title: "查看人数",
            skin: "myclass", // 自定样式
            area: ["1000px", "500px"],
            content: $("#aaa"),

            success: function (layero, index) {
            },
            yes: function () {
            }
        });

        form.render(); // 动态渲染
    });


});
//日期方法
layui.use('laydate', function () {
    var laydate = layui.laydate;
    //常规用法
    laydate.render({
        elem: '#test1'
    });
    //日期范围
    laydate.render({
        elem: '#test6',
        range: true
    });
});

