layui.use('table', function () {
    var table = layui.table;

    table.render({
        elem: '#test',
        defaultToolbar: [ { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
            title: '提示',
            layEvent: 'LAYTABLE_TIPS',
            icon: 'layui-icon-tips'
        }],
        title: '用户数据表',
        cols: [[{type: 'checkbox',fixed: 'left'}
            , {field: 'id', title: '序号',align: 'center'}
            , {field: 'title', title: '标题',align: 'center'}
            , {field: 'role', title: '角色',align: 'center'}
            , {field: 'publisher', title: '发布人',align: 'center'}
            , {field: 'articleype', title: '类型',align: 'center'}
            , {field: 'joinTime', title: '发布时间',align: 'center'}
            , {field: 'see', title: '查看人数',align: 'center'}
            , {fixed: 'right', title: '操作', toolbar: '#barDemo',align: 'center'}
            ]],
        data: [{
            "id": "10001",
            "title": "Hi",
            "role": "学生",
            "publisher": "杜甫",
            "articleype": "公告",
            "joinTime": "2016-10-14",
            "see": "10/50"

        }, {
            "id": "10002",
            "title": "Hi",
            "role": "学生",
            "publisher": "杜甫",
            "articleype": "公告",
            "joinTime": "2016-10-14",
            "see": "10/50"

        }, {
            "id": "10003",
            "title": "Hi",
            "role": "学生",
            "publisher": "杜甫",
            "articleype": "通知",
            "joinTime": "2016-10-14",
            "see": "10/50"
        }, {
            "id": "10004",
            "title": "Hi",
            "role": "学生",
            "publisher": "杜甫",
            "articleype": "公告",
            "joinTime": "2016-10-14",
            "see": "10/50"
        }, {
            "id": "10005",
            "title": "Hi",
            "role": "学生",
            "publisher": "杜甫",
            "articleype": "公告",
            "joinTime": "2016-10-14",
            "see": "10/50"
        }, {
            "id": "10006",
            "title": "Hi",
            "role": "学生",
            "publisher": "杜甫",
            "articleype": "通知",
            "joinTime": "2016-10-14",
            "see": "10/50"
        }, {
            "id": "10007",
            "title": "Hi",
            "role": "学生",
            "publisher": "贤心",
            "articleype": "公告",
            "joinTime": "2016-10-14",
            "see": "10/50"
        }, {
            "id": "10008",
            "title": "Hi",
            "role": "学生",
            "publisher": "贤心",
            "articleype": "通知",
            "joinTime": "2016-10-14",
            "see": "10/50"
        }],
    });
    var form = layui.form;
    var layer = layui.layer;
    $ = layui.jquery;
    //监听行单击事件（单击事件为：rowDouble）
    table.on('row(test)', function(obj){
        var data = obj.data;
        layer.alert(JSON.stringify(data), {
            type: 1,
            title: '请假审批详情：',
            content: $("#updateOrDelete"),
            success: function (index) {
                form.val("dataForm", data);
            }
        });
        //标注选中样式
        obj.tr.addClass('layui-table-click').siblings().removeClass('layui-table-click');
    });


});
//日期方法
layui.use('laydate', function () {
    var laydate = layui.laydate;
    //常规用法
    laydate.render({
        elem: '#test1'
    });
});
layui.use('laydate', function () {
    var laydate = layui.laydate;

    //日期范围
    laydate.render({
        elem: '#test6',
        range: true
    });

});
