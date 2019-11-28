layui.use(['table', 'transfer', 'layer', 'util', 'jquery', 'form', 'tree', 'element'], function () {
    var table = layui.table;
    var layer = layui.layer;
    var $ = layui.jquery;
    var form = layui.form;
    var transfer = layui.transfer;
    var layer = layui.layer;
    var util = layui.util;
    var tree = layui.tree;
    var element = layui.element;
    //渲染数据表格
    var tableIns = table.render({
        elem: '#test'//渲染目标
        /* , url: '/json/table.json'//数据接口*/
        , id: 'userTableReload'
        , cols: [[
            {field: 'name', title: '角色名称'},
            {field: 'describe', title: '角色描述'},
            {field: 'remark', title: '备注'},
            {fixed: 'right', title: '操作', toolbar: '#barDemo'}
        ]]
        , data: [{
            name: "超级管理员",
            describe: '权限最大',
            remark: '该角色不可以进行修改或删除'
        }, {
            name: "学生",
            describe: '学生',
            remark: '该角色不可以进行修改或删除'
        }, {
            name: "任课老师",
            describe: '负责具体的讲课内容',
            remark: '无'
        }, {
            name: "教务",
            describe: '对学生进行日常管理',
            remark: '无'
        }, {
            name: "校长",
            describe: '管理者',
            remark: '无'
        }]
        , page: true
    });

    //添加弹窗
    $('#roleAdd').click(function () {
        mainIndex = layer.open({
            type: 1,
            title: "添加新角色",
            // skin: 'layui-layer-rim', //加上边框
            area: ['350px', '300px'], //设置宽高
            content: $("#add"),
            success: function (index) {
                //清空
                $("#dataFor")[0].reset();
                url = "/";

            }
        });
    });
    //监听工具条
    table.on('tool(test)', function (obj) {
        var data = obj.data;
        if (obj.event === 'detail') {
            layer.msg('ID：' + data.id + ' 的查看操作');
        } else if (obj.event === 'delete') {
            layer.confirm('真的删除行么', function (index) {
                obj.del();
                layer.close(index);
            });
        } else if (obj.event === 'edit') {
            //layer.alert('编辑行：<br>'+ JSON.stringify(data))
            layer.open({
                type: 1,
                title: "修改角色",
                // skin: 'layui-layer-rim', //加上边框
                area: ['350px', '300px'], //设置宽高
                content: $("#update"),
                success: function (index) {


                }
            });
        } else if (obj.event === 'fun') {
            /*var dom = $('#account_privilege', parent.document);
            dom.trigger("click");*/
          /*  window.parent.parent.*/

            /*  window.parent.layui.element.tabAdd('demo', {
                  title: '新选项卡', //用于演示
                  content: "123"
                  , id: new Date().getTime() //实际使用一般是规定好的id，这里以时间戳模拟下
              });*/
        }
    });

    $('#affirm').click(function () {
        layer.msg('修改成功!');
    });
    $('#cancel ').click(function () {

    });


});