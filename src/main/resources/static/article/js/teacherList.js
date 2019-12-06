layui.use(['table','laydate'], function () {
    var currPage = 1;
    var data;
    var res;
    var $ = layui.jquery,
        form = layui.form,
        element = layui.element,
        table = layui.table,
        layer = layui.layer,
        laydate = layui.laydate,
        upload = layui.upload;


    table.render({
        elem: '#test',
        title: '用户数据表',
        url: '/article/articleList',
        cols: [[
            {field: 'id', title: '序号', align: 'center'}
            , {field: 'title', title: '标题', align: 'center'}
            , {field: 'receiverRoleIds', title: '角色', align: 'center'}
            , {field: 'operatorId', title: '发布人', align: 'center'}
            , {field: 'createTime', title: '发布时间', align: 'center'}
            , {field: 'typeId', title: '类型', align: 'center'}
            , {field: 'readCount', title: '查看人数', align: 'center', event: 'readCount',templet: '#sexTpl'}
            , {field: 'state', title: '状态', align: 'center', templet: function (d) {
                    if (d.state == 1) {
                        return '草稿';
                    }
                    if (d.state == 2) {
                        return '已撤销';
                    }
                    if (d.state == 3) {
                        return '已提交';
                    }
                }
            }
            , {fixed: 'right', title: '操作', toolbar: '#barDemo', align: 'center'}
        ]],
        page: true,
        done: function (rest, curr, count) {
            currPage = curr;
            res =rest;

            /*console.log(currPage);
            console.log(rest);*/

        },
        parseData:function (res) {
            console.log(res);
            return{
                "code":"0",
                "count":res.pager.dataTotal,
                data:res.result,
            }
        },
        id: 'testReload'
    });
    //日期范围
    laydate.render({
        elem: '#time',
        range: '~'
    });
    //表格重载
    $("#query").click(function () {
        table.reload('testReload', {
            page: {
                curr: 1 //重新从第 1 页开始
            }
            ,where: {
                keyword: $("#keyword").val(),
                typeId:$("#typeId").val(),
                state:$("#state").val(),
                time:$("#time").val()
            }
        }, 'data');
    });

    table.on('tool(test)', function (obj) {
        var data = obj.data;
        //console.log(obj)
        if (obj.event === 'del') {
            layer.confirm('真的删除行么', function (index) {
                obj.del();
                $.post('/article/delete', {id: data.id}, function (result) {
                    if (result.success) {
                        layer.msg("删除成功!");
                        layer.close(index);
                        tableIns.reload();
                        if (res.data.length-1 == 0) {
                            window.location.reload();//默认刷新第一页
                        }
                    } else {
                        layer.msg(result.msg);
                    }
                });
            });
        } else if (obj.event === 'edit') {
            mainIndex = layer.open({
                btnA: 'c',
                type: 2,
                title: "文章详情",
                btn: ['编辑'],
                skin: "myclass", // 自定样式
                area: ["100%", "100%"],
                content: 'details',
                yes: function(index, layero){

                }
            });
            form.render(); // 动态渲染
        } else if (obj.event === 'revoke') {
            layer.confirm('真的撤销吗', function (index) {
                obj.del();
                $.post('/article/articleModify', {id: data.id,state:2}, function (result) {
                    if (result.success) {
                        layer.msg("撤销成功");
                        layer.close(index);
                        tableIns.reload();
                        if (res.data.length-1 == 0) {
                            window.location.reload();//默认刷新第一页
                        }
                    } else {
                        layer.msg(result.msg);lign
                    }
                });
            });
        } else if (obj.event === 'again') {
            mainIndex = layer.open({
                btnAlign: 'c',
                type: 2,
                title: "文章详情",
                btn: ['已阅读'],
                skin: "myclass", // 自定样式
                area: ["100%", "100%"],
                content: 'details',
            });
            form.render(); // 动态渲染
        }else if (obj.event === 'readCount') {
            layer.open({
                type: 1,
                title: "查看人数",
                skin: "myclass", // 自定样式
                area: ["1000px", "500px"],
                content: $("#aaa"),

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
/*
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
*/

