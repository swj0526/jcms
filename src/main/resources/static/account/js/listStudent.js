layui.use(['table', 'layer', 'jquery', 'form'], function () {
    var table = layui.table;
    var layer = layui.layer;
    var $ = layui.jquery;
    var form = layui.form;
    var id;
    //渲染数据表格
    var tableIns = table.render({
        elem: '#test'//渲染目标
        , url: '/account/student/list'
        , id: 'userTableReload'
        , cols: [[
            {
                field: 'studentName',
                title: '学生姓名',
                templet: '<div><a href="student/information" class="layui-table-link">{{d.studentName}}</a></div>'
            },
            {field: 'majorName', title: '专业-班级'},
            {field: 'phone', title: '手机号码'},
            {field: 'lockDemo', title: '是否激活账号', templet: '#checkboxTpl', unresize: true},
            {fixed: 'right', title: '操作', toolbar: '#barDemo'}
        ]]
        , page: true
        //解析table 组件规定的数据结构
        , parseData: function (res) { //res 即为原始返回的数据
            /*   console.log(res);*/
            return {
                "code": "0",
                "count": res.pager.dataTotal,
                data: res.result
            }
        }
    });
    //监听工具条

    table.on('tool(test)', function (obj) {
        var data = obj.data;
        id = data.id;
        if (obj.event === 'reset') {
            var resetPop = layer.open({
                type: 1,
                title: "重置密码",
                content: "<div style='text-align: center;padding-top: 10px;'>该账号的密码重置为123456?</div>",
                area: ['300px', '150px'], //设置宽高
                btn: ['确定重置密码', '取消'],
                btnAlign: "c",
                yes: function () {
                    $.post("/account/reset", {id: id,type:1}, function (result) {
                        if (result.success) {
                            layer.close(resetPop);
                        }
                    });
                }
            });
        }else if(obj.event === 'setRole') {
            var resetPop = layer.open({
                type: 1,
                title: "设置角色",
                content: "",
                area: ['400px', '250px'], //设置宽高
                btn: ['确定', '取消'],
                btnAlign: "c",
                yes: function () {
                    $.post("", {id: id}, function (result) {
                        if (result.success) {
                            layer.close(resetPop);
                        }
                    });
                }
            });
        }
    });


    //监听锁定操作
    form.on('checkbox(lockDemo)', function (obj) {
        // layer.tips(this.value + ' ' + this.name + '：'+ obj.elem.checked, obj.othis);
        var id = this.value;
        if (obj.elem.checked) {
            $.post('/account/user/activate', {id: id}, function (result) {
                if (result.success == true) {
                    layer.msg("账号已激活,初始密码为123456,请提醒用户重新进行密码更改!");
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