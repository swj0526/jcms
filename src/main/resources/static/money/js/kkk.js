layui.use(['table', 'jquery', 'laydate', 'form', 'element'], function () {
    var table = layui.table;
    var $ = layui.jquery;
    laydate = layui.laydate;
    form = layui.form,
        table.render({
            elem: '#test'
            /*,url:'/test/table/demo1.json'*/
            , toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
            , defaultToolbar: []
            , title: '用户数据表'
            , cols: [[
                {field: 'id', title: 'ID', width: 80, fixed: 'left', unresize: true, sort: true}
                , {field: 'type', title: '缴费类型'}
                , {fixed: 'right', title: '操作', toolbar: '#barDemo', width: 130}
            ]]
            , page: true
            , data: [{
                id: 1
                , type: '学费'
            }, {
                id: 2
                , type: '学费'
            }, {
                id: 3
                , type: '学费'
            }, {
                id: 4
                , type: '学费'
            }, {
                id: 5
                , type: '学费'
            }, {
                id: 6
                , type: '学费'
            }, {
                id: 7
                , type: '学费'
            }, {
                id: 8
                , type: '学费'
            }, {
                id: 9
                , type: '学费'
            }, {
                id: 10
                , type: '学费'
            }, {
                id: 11
                , type: '学费'
            }]
        });

    //头工具栏事件
    table.on('toolbar(test)', function (obj) {
        var checkStatus = table.checkStatus(obj.config.id);
        //添加
        switch (obj.event) {
            case 'add':
                layer.open({
                    btnAlign: 'c'
                    , type: 1
                    , btn: ['提交']
                    , content: $("#ll")
                    , yes: function (index, layero) {
                        layer.close(index);
                    }
                    , success: function (index) {
                        $("#dataFor")[0].reset();
                    }
                });
        }
        ;
    });

    //监听行工具事件
    table.on('tool(test)', function (obj) {
        var data = obj.data;
        //console.log(obj)
        if (obj.event === 'edit') {
            layer.open({
                btnAlign: 'c'
                , type: 1
                , btn: ['提交']
                , content: $("#up")
                , yes: function (index, layero) {
                    layer.close(index);
                }
                , success: function (index) {
                    form.val("dataForm1", data);
                }
            });
        } else if (obj.event === 'del') {
            layer.confirm('真的删除行么', function (index) {
                obj.del();
                layer.close(index);
            });
        }
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