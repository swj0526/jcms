layui.use(['table', 'transfer', 'layer', 'util', 'jquery', 'form','tree'], function () {
    var table = layui.table;
    var layer = layui.layer;
    var $ = layui.jquery;
    var form = layui.form;
    var transfer = layui.transfer;
    var layer = layui.layer;
    var util = layui.util;
    var tree = layui.tree;
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
        },{
            name: "学生",
            describe: '学生',
            remark: '该角色不可以进行修改或删除'
        },{
            name: "任课老师",
            describe: '负责具体的讲课内容',
            remark: '无'
        },{
            name: "教务",
            describe: '对学生进行日常管理',
            remark: '无'
        },{
            name: "校长",
            describe: '管理者',
            remark: '无'
        }]
        , page: true
    });
//模拟数据
    var data1 = [
        {"value": "1", "title": "张三"}
        ,{"value": "2", "title": "李四"}
        ,{"value": "3", "title": "王五"}
        ,{"value": "4", "title": "种丹妮"}
        ,{"value": "6", "title": "巴金"}
        ,{"value": "7", "title": "冰心"}
        ,{"value": "8", "title": "矛盾"}
        ,{"value": "9", "title": "贤心"}
    ]
   var data2 = [{
        title: '权限管理'
        ,id: 1
        ,field: 'name1'
        ,checked: true
        ,spread: true
        ,children: [{
            title: '角色管理'
            ,id: 3
            ,field: 'name11'
            ,children: [{
                title: '添加角色'
                ,id: 23
                ,field: ''
                ,children: [{
                    title: '修改'
                    ,id: 24
                    ,field: ''
                    ,children: [{
                        title: '删除'
                        ,id: 30
                        ,field: ''
                    },{
                        title: '查看'
                        ,id: 31
                        ,field: ''
                    }]
                }]
            },{
                title: '用户管理'
                ,id: 7
                ,field: ''
                ,children: [{
                    title: '新增用户'
                    ,id: 15
                    ,field: ''
                }]
            },{
                title: '流程管理'
                ,id: 8
                ,field: ''
                ,children: [{
                    title: '请假流程'
                    ,id: 32
                    ,field: ''
                }]
            }]
        },{
            title: '经费申请流程'
            ,id: 4
            ,spread: true
            ,children: [{
                title: '申请'
                ,id: 9
                ,field: ''
                ,disabled: true
            },{
                title: '拒绝'
                ,id: 10
                ,field: ''
            }]
        },{
            title: '档案管理'
            ,id: 20
            ,field: ''
            ,children: [{
                title: '招生管理'
                ,id: 21
                ,field: ''
            },{
                title: '学生档案管理'
                ,id: 22
                ,field: ''
            }]
        }]
    },{
        title: '发文管理'
        ,id: 2
        ,field: ''
        ,spread: true
        ,children: [{
            title: '查看文章'
            ,id: 5
            ,field: ''
            ,spread: true
            ,children: [{
                title: '发文管理'
                ,id: 11
                ,field: ''
            },{
                title: '查看文章'
                ,id: 12
                ,field: ''
            }]

        }]
    }]
    //基础效果
    transfer.render({
        title: ['所有用户', '教师'] , //自定义标题
        elem: '#test2'
        ,data: data1
        ,showSearch: true
    });
    //开启复选框
    tree.render({
        elem: '#tree2'
        ,data: data2
        ,showCheckbox: true
    });
    //添加弹窗
   $('#roleAdd').click(function () {
       mainIndex = layer.open({
           type: 1,
           title: "添加新角色",
           // skin: 'layui-layer-rim', //加上边框
           area: ['350px','300px'], //设置宽高
           content: $("#add"),
           success: function (index) {
               //清空
               $("#dataFor")[0].reset();
               url = "/";

           }
       });
   });
    //监听工具条
    table.on('tool(test)', function(obj){
        var data = obj.data;
        if(obj.event === 'detail'){
            layer.msg('ID：'+ data.id + ' 的查看操作');
        } else if(obj.event === 'delete'){
            layer.confirm('真的删除行么', function(index){
                obj.del();
                layer.close(index);
            });
        } else if(obj.event === 'edit'){
            //layer.alert('编辑行：<br>'+ JSON.stringify(data))
            mainIndex = layer.open({
                type: 1,
                title: "修改角色",
                // skin: 'layui-layer-rim', //加上边框
                area: ['350px','300px'], //设置宽高
                content: $("#update"),
                success: function (index) {
                    form.val("dataForm1", data);
                    //清空
                    $("#dataFor")[0].reset();
                    url = "/";

                }
            });
        }
    });

   $('#affirm').click(function () {
       layer.msg('修改成功!');
   });
    $('#cancel ').click(function () {

    });













});