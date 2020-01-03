layui.use(['table', 'layer', 'jquery', 'form'], function () {
    var table = layui.table;
    var layer = layui.layer;
    var $ = layui.jquery;
    var form = layui.form;
    var selectRole = "";
    var id;
    var currPage = 1;
    var data;
    var res;
    //渲染数据表格
    var tableIns = table.render({
        elem: '#test1'//渲染目标
        , url: '/account/teacher/list'//数据接口
        , id: 'userTableReload1'
        , cols: [[
            {field: 'teacherName', title: '职工姓名'},
            {field: 'phone', title: '电话号码'},
            {field: 'roleNames', title: '角色'},
            {field: 'lockDemo1', title: '是否激活账号', templet: '#checkboxTpl1', unresize: true},
            {fixed: 'right', title: '操作', toolbar: '#barDemo1', width: 174}
        ]]
        , page: true,
        //解析table 组件规定的数据结构
        done: function (rest, curr, count) {
            currPage = curr;
            res = rest;
            console.log(currPage);
            console.log(rest);

        },
        parseData: function (res) { //res 即为原始返回的数据
            /*   console.log(res);*/
            return {
                "code": "0",
                "count": res.pager.dataTotal,
                data: res.result
            }
        }
    });
    // 监听搜索操作
    form.on('submit(data-search-btn)', function (data) {
        var keywords = $('[name="keywords"]').val();
        var lock1 = $('[name="lock1"]').val();
        //执行搜索重载
        table.reload('userTableReload1', {
            page: {
                curr: currPage
            },
            where: {
                keywords: keywords,
                enable: lock1
            }
        }, 'data');


    });
    //监听工具条
    table.on('tool(test1)', function (obj) {
        var data = obj.data;
        if (obj.event === 'reset1') {
            var resetPop = layer.open({
                type: 1,
                title: "重置密码",
                content: "<div style='text-align: center;padding-top: 10px;'>该账号的密码重置为abcd123?</div>",
                area: ['300px', '150px'], //设置宽高
                btn: ['确定重置密码', '取消'],
                btnAlign: "c",
                yes: function () {
                    $.post("/account/reset", {id: data.id, type: 2}, function (result) {
                        if (result.success) {
                            layer.close(resetPop);
                        }
                    });
                }
            });
        } else if (obj.event === 'reset2') {
            var roleId = data.id;
            layer.open({
                type: 2,
                title: "设置角色",
                area: ['720px', '300px'], //设置宽高
                content: '/account/tosetrole?id=' + roleId
            });
        }
    });
    //监听锁定操作
    form.on('checkbox(lockDemo1)', function (obj) {
        // layer.tips(this.value + ' ' + this.name + '：'+ obj.elem.checked, obj.othis);
        var id = this.value;
        if (obj.elem.checked) {
            $.post('/account/user/activate', {id: id}, function (result) {
                if (result.success == true) {
                    layer.msg("账号已激活,初始密码为abcd123,请提醒用户重新进行密码更改!");
                } else {
                    layer.msg("激活失败!");
                }
            });
        } else {
            $.post('/account/user/cancel', {id: id}, function (result) {
                if (result.success == true) {
                    layer.msg("账号已锁定!");
                } else {
                    layer.msg("锁定失败!");
                }
            });
        }

    });
});