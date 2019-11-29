layui.use(['table', 'jquery', 'laydate', 'form', 'element'], function () {
    var table = layui.table;
    var $ = layui.jquery;
    laydate = layui.laydate;
    form = layui.form,
        table.render({
            elem: '#test'
            ,url:'/dictionary/list/payType/options'
            , toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
            , defaultToolbar: []
            , title: '用户数据表'
            , cols: [[
                {field: 'name', title: '名称'}
                ,{field: 'remark', title: '备注'}
                , {fixed: 'right', title: '操作', toolbar: '#barDemo', width: 130}
            ]]
            ,parseData:function(res){ //res 即为原始返回的数据
                console.log(res);
                return{
                    code:'0'
                    ,data:res
                }
            },
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
                    ,title:'添加缴费类型'
                    , btn: ['提交','取消']
                    , content: $("#ll")
                    , yes: function (index, layero) {
                        $.post('/dictionary/add/payType',{
                            name:$("#addname").val(),
                            remark:$("#addremark").val()

                        },function (res) {
                            location.reload();
                            layer.close(index);
                        })
                    }
                    ,success:function () {
                        $('#addfrom')[0].reset();
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
                ,title:'修改缴费类型'
                , btn: ['提交','取消']
                , content: $("#up")
                , yes: function (index, layero) {
                    $.post('/dictionary/modify',{
                        id:data.id,
                        name:$("#upname").val(),
                        remark:$("#upremark").val()
                    },function (res) {
                        location.reload();
                        layer.close(index);
                    })
                }
                , success: function (index) {
                    form.val("dataForm1", data);
                }
            });
        } else if (obj.event === 'del') {
            layer.confirm('真的删除行么', function (index) {
                $.post('/dictionary/delete',{
                    id:data.id,
                },function (res) {
                    obj.del();
                    layer.close(index);
                })
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