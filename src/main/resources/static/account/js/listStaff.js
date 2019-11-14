layui.use(['table', 'layer', 'jquery', 'form'], function () {
    var table = layui.table;
    var layer = layui.layer;
    var $ = layui.jquery;
    var form = layui.form;

    //渲染数据表格
    var tableIns = table.render({
        elem: '#test1'//渲染目标
        /* , url: '/json/table.json'//数据接口*/
        , id: 'userTableReload1'
        , cols: [[
            {field: 'name', title: '职工姓名'},
            {field: 'major', title: '所属部门'},
            {field: 'grade', title: '岗位名称'},
            {field: 'role', title: '角色'},
            {field: 'lockDemo', title: '是否激活账号',templet: '#checkboxTpl', unresize: true},
            {fixed: 'right', title: '操作', toolbar: '#barDemo'}
        ]]
        , data: [{
            name: "王老师",
            major: '教务部',
            grade: '教务老师',
           role:'教务'
        },{
            name: "李校长",
            major: '教务部',
            grade: '校长',
            role:'校长'
        },{
            name: "李校长",
            major: '教务部',
            grade: '校长',
            role:'校长'
        },{
            name: "李校长",
            major: '教务部',
            grade: '校长',
            role:'校长'
        },{
            name: "李校长",
            major: '教务部',
            grade: '校长',
            role:'校长'
        },{
            name: "李校长",
            major: '教务部',
            grade: '校长',
            role:'校长'
        },{
            name: "李校长",
            major: '教务部',
            grade: '校长',
            role:'校长'
        },{
            name: "李校长",
            major: '教务部',
            grade: '校长',
            role:'校长'
        }]
        ,page:true
    });
    $('#reset1').click(function () {
       layer.msg("该账号的密码重置为abcd?", {
           time: false, //20s后自动关闭
           btn: ['确定','取消重置']
       });
    });
    //监听锁定操作
    form.on('checkbox(lockDemo1)', function(obj){
       // layer.tips(this.value + ' ' + this.name + '：'+ obj.elem.checked, obj.othis);
       if( obj.elem.checked ){
           layer.msg("账号已激活,初始密码为abcd,请提醒用户重新进行密码更改!");
       }else{
           layer.msg("账号已锁定!");
       }

    });

});