layui.use(['table', 'transfer', 'layer', 'util', 'jquery', 'form', 'tree'], function () {
    var table = layui.table;
    var layer = layui.layer;
    var $ = layui.jquery;
    var form = layui.form;
    var transfer = layui.transfer;
    var layer = layui.layer;
    var util = layui.util;
    var tree = layui.tree;
    var data2 = [{
        title: '权限管理'
        , id: 1
        , field: 'name1'
        , checked: true
        , spread: true
        , children: [{
            title: '角色管理'
            , id: 3
            , field: 'name11'
            , children: [{
                title: '添加角色'
                , id: 23
                , field: ''
                , children: [{
                    title: '修改'
                    , id: 24
                    , field: ''
                    , children: [{
                        title: '删除'
                        , id: 30
                        , field: ''
                    }, {
                        title: '查看'
                        , id: 31
                        , field: ''
                    }]
                }]
            }, {
                title: '用户管理'
                , id: 7
                , field: ''
                , children: [{
                    title: '新增用户'
                    , id: 15
                    , field: ''
                }]
            }, {
                title: '流程管理'
                , id: 8
                , field: ''
                , children: [{
                    title: '请假流程'
                    , id: 32
                    , field: ''
                }]
            }]
        }, {
            title: '经费申请流程'
            , id: 4
            , spread: true
            , children: [{
                title: '申请'
                , id: 9
                , field: ''
                , disabled: true
            }, {
                title: '拒绝'
                , id: 10
                , field: ''
            }]
        }, {
            title: '档案管理'
            , id: 20
            , field: ''
            , children: [{
                title: '招生管理'
                , id: 21
                , field: ''
            }, {
                title: '学生档案管理'
                , id: 22
                , field: ''
            }]
        }]
    }, {
        title: '发文管理'
        , id: 2
        , field: ''
        , spread: true
        , children: [{
            title: '查看文章'
            , id: 5
            , field: ''
            , spread: true
            , children: [{
                title: '发文管理'
                , id: 11
                , field: ''
            }, {
                title: '查看文章'
                , id: 12
                , field: ''
            }]

        }]
    }]
//开启复选框
    tree.render({
        elem: '#tree2'
        , data: data2
        , showCheckbox: true
    });
});