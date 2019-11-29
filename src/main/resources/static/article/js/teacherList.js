layui.use('table', function () {
    var table = layui.table;

    table.render({
        elem: '#test',
        title: '用户数据表',
        url:'/article/list',
        cols: [[
            {field: 'id', title: '序号',align: 'center'}
            , {field: 'title', title: '标题',align: 'center'}
            , {field: 'role', title: '角色',align: 'center'}
            , {field: 'publisher', title: '发布人',align: 'center'}
            , {field: 'joinTime', title: '发布时间',align: 'center'}
            , {field: 'type', title: '类型',align: 'center'}
            , {field: 'see', title: '查看人数',align: 'center'}
            , {field: 'state', title: '状态',align: 'center',templet: function(d) {
                    if (d.state == 1){
                        return '草稿';
                    }
                    if (d.state == 2){
                        return '已撤销';
                    }
                    if (d.state == 3){
                        return '已提交';
                    }
                }}
            , {fixed: 'right', title: '操作', toolbar: '#barDemo',align: 'center'}
        ]],

        page: true
    });
    var form = layui.form;
    var layer = layui.layer;
    $ = layui.jquery;

    table.on('tool(test)', function(obj){
        var data = obj.data;
        //console.log(obj)
        if(obj.event === 'del'){
            layer.confirm('真的删除行么', function(index){
                obj.del();
                layer.close(index);
            });
        }else if(obj.event === 'edit'){
            mainIndex=layer.open({
                btnAlign: 'c',
                type: 2,
                title: "发布公告",
                skin: "myclass", // 自定样式
                area: ["100%", "100%"],
                content: 'dispatch',
                success: function () {
                    form.val("dataForm", data);
                }
            });
            form.render(); // 动态渲染
        }else if(obj.event === 'revoke'){
            layer.confirm('真的撤销吗', function(index){
                obj.del();
                layer.close(index);
            });
        }else if(obj.event === 'again'){
            mainIndex=layer.open({
                btnAlign: 'c',
                type: 2,
                title: "文章详情",
                btn:['已阅读'],
                skin: "myclass", // 自定样式
                area: ["100%", "100%"],
                content: 'details',
            });
            form.render(); // 动态渲染
        }
    });
    $("#info").on('click', function () {
        layer.open({
            type: 1,
            title: "查看人数",
            skin: "myclass", // 自定样式
            area: ["1000px", "500px"],
            content: $("#aaa"),

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

