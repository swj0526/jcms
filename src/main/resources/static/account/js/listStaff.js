layui.use(['table', 'layer', 'jquery', 'form'], function () {
    var table = layui.table;
    var layer = layui.layer;
    var $ = layui.jquery;
    var form = layui.form;
    var selectRole = "";
    //渲染数据表格
    var tableIns = table.render({
        elem: '#test1'//渲染目标
        /* , url: '/json/table.json'//数据接口*/
        , id: 'userTableReload1'
        , cols: [[
            {field: 'name', title: '职工姓名'},
            {field: 'department', title: '所属部门'},
            {field: 'postName', title: '岗位名称'},
            {field: 'phone', title: '电话号码'},
            {
                field: 'role',
                title: '角色'
            },
            {field: 'lockDemo1', title: '是否激活账号', templet: '#checkboxTpl1', unresize: true},
            {fixed: 'right', title: '操作', toolbar: '#barDemo1',width:174}
        ]]
        , data: [{
            name: "王老师",
            department: '教务部',
            postName: '教务老师',
            role: '教师,管理员',
            phone: '18653525596'
        }, {
            name: "王老师",
            department: '教务部',
            postName: '教务老师',
            role: ' 教师,管理员',
            phone: '18653525596'
        }, {
            name: "王老师",
            department: '教务部',
            postName: '教务老师',
            role: ' 教师,管理员 ',
            phone: '18653525596'
        }, {
            name: "王老师",
            department: '教务部',
            postName: '教务老师',
            role: '教师,管理员',
            phone: '18653525596'
        }, {
            name: "王老师",
            department: '教务部',
            postName: '教务老师',
            role: '教师,管理员',
            phone: '18653525596'
        }, {
            name: "王老师",
            department: '教务部',
            postName: '教务老师',
            role: '教师,管理员',
            phone: '18653525596'
        }, {
            name: "王老师",
            department: '教务部',
            postName: '教务老师',
            role: '教师,管理员',
            phone: '18653525596'
        }, {
            name: "王老师",
            department: '教务部',
            postName: '教务老师',
            role: '教师,管理员',
            phone: '18653525596'
        }, {
            name: "王老师",
            department: '教务部',
            postName: '教务老师',
            role: '教师,管理员',
            phone: '18653525596'
        }, {
            name: "王老师",
            department: '教务部',
            postName: '教务老师',
            role: '教师,管理员',
            phone: '18653525596'
        }, {
            name: "王老师",
            department: '教务部',
            postName: '教务老师',
            role: '教师,管理员',
            phone: '18653525596'
        }, {
            name: "王老师",
            department: '教务部',
            postName: '教务老师',
            role: '教师,管理员',
            phone: '18653525596'
        }, {
            name: "王老师",
            department: '教务部',
            postName: '教务老师',
            role: '教师,管理员',
            phone: '18653525596'
        }, {
            name: "王老师",
            department: '教务部',
            postName: '教务老师',
            role: '教师,管理员',
            phone: '18653525596'
        }, {
            name: "王老师",
            department: '教务部',
            postName: '教务老师',
            role: '教师,管理员',
            phone: '18653525596'
        }, {
            name: "王老师",
            department: '教务部',
            postName: '教务老师',
            role: '教师,管理员',
            phone: '18653525596'
        }, {
            name: "王老师",
            department: '教务部',
            postName: '教务老师',
            role: '教师,管理员',
            phone: '18653525596'
        }]
        , page: true
    });
    //监听工具条
    table.on('tool(test1)', function (obj) {
        var data = obj.data;
        if (obj.event === 'reset1') {
            layer.open({
                type: 1,
                title: "重置密码",
                content: "<div style='text-align: center;padding-top: 10px;'>该账号的密码重置为abcd?</div>",
                area: ['300px', '150px'], //设置宽高
                btn: ['确定重置密码', '取消'],
                btnAlign: "c"
            });
        } else if (obj.event === 'reset2') {
            layer.open({
                type: 1,
                title: "设置角色",
                area: ['720px', '350px'], //设置宽高
                content: $("#roleDemo"),
                btn: ['确定', '取消'],
                success: function (index) {

                },
                yes: function (index) {

                    layer.close(index);
                },
                btn2: function () {
                    alert('取消');
                }
            });
        }
    });
    var demo1 = xmSelect.render({
        el: '.demo1',
        language: 'zn',
        data: [
            {name: '校长', value: 1},
            {name: '管理老师', value: 2},
            {name: '教务', value: 3},
        ]
    });

    //监听锁定操作
    form.on('checkbox(lockDemo1)', function (obj) {
        // layer.tips(this.value + ' ' + this.name + '：'+ obj.elem.checked, obj.othis);
        if (obj.elem.checked) {
            layer.msg("账号已激活,初始密码为abcd,请提醒用户重新进行密码更改!");
        } else {
            layer.msg("账号已锁定!");
        }

    });
});