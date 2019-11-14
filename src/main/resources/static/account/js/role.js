layui.use(['table', 'transfer', 'layer', 'util', 'jquery', 'form','tree'], function () {
    var table = layui.table;
    var layer = layui.layer;
    var $ = layui.jquery;
    var form = layui.form;
    var transfer = layui.transfer
    var layer = layui.layer
    var util = layui.util;
    var tree = layui.tree;
    //渲染数据表格
    var tableIns = table.render({
        elem: '#test'//渲染目标
        /* , url: '/json/table.json'//数据接口*/
        , id: 'userTableReload'
        , cols: [[
            {field: 'name', title: '角色名称'},
            {field: 'major', title: '角色描述'},
            {field: 'grade', title: '备注'},
            {fixed: 'right', title: '操作', toolbar: '#barDemo'}
        ]]
        , data: [{
            name: "老师",
            major: '教务部',
            grade: '教务老师'
        },{
            name: "学生",
            major: '教务部',
            grade: '教务老师'
        },{
            name: "教务",
            major: '教务部',
            grade: '教务老师'
        },{
            name: "超级管理员",
            major: '教务部',
            grade: '教务老师'
        },{
            name: "校长",
            major: '教务部',
            grade: '教务老师'
        }]
        , page: true
    });
//模拟数据
    var data1 = [
        {"value": "1", "title": "张三"}
        ,{"value": "2", "title": "李四"}
        ,{"value": "3", "title": "王五"}
        ,{"value": "4", "title": "种丹妮"}
        ,{"value": "5", "title": "鲁迅", "disabled": true}
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
                title: '三级2-1-1'
                ,id: 11
                ,field: ''
            },{
                title: '三级2-1-2'
                ,id: 12
                ,field: ''
            }]
        },{
            title: '二级2-2'
            ,id: 6
            ,field: ''
            ,children: [{
                title: '三级2-2-1'
                ,id: 13
                ,field: ''
            },{
                title: '三级2-2-2'
                ,id: 14
                ,field: ''
                ,disabled: true
            }]
        }]
    }]
    //基础效果
    transfer.render({
        title: ['所有用户', '学生'] , //自定义标题
        elem: '#test2'
        ,data: data1
    });
    //开启复选框
    tree.render({
        elem: '#tree2'
        ,data: data2
        ,showCheckbox: true
    });
    transfer.render({
        title: ['所有用户', '老师'] , //自定义标题
        elem: '#test3'
        ,data: data1
    });

});