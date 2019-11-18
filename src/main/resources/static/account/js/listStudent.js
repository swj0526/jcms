layui.use(['table', 'layer', 'jquery', 'form'], function () {
    var table = layui.table;
    var layer = layui.layer;
    var $ = layui.jquery;
    var form = layui.form;

    //渲染数据表格
    var tableIns = table.render({
        elem: '#test'//渲染目标
        /* , url: '/json/table.json'//数据接口*/
        , id: 'userTableReload'
        , cols: [[
            {field: 'stuID', title: '学号'},
            {field: 'name', title: '学生姓名'},
            {field: 'major', title: '所属专业'},
            {field: 'grade', title: '所属班级'},
            {field: 'phone', title: '手机号码'},
            {field: 'lockDemo', title: '是否激活账号',templet: '#checkboxTpl', unresize: true},
            {fixed: 'right', title: '操作', toolbar: '#barDemo'}
        ]]
        , data: [{
            stuID:"201932094",
            name: "张三",
            major: '影视',
            grade: '影视一班',
           phone:'18653525596'
        },{
            stuID:"201932094",
            name: "张三",
            major: '影视',
            grade: '影视一班',
            phone:'18653525596'
        },{
            stuID:"201932094",
            name: "张三",
            major: '影视',
            grade: '影视一班',
            phone:'18653525596'
        },{
            stuID:"201932094",
            name: "张三",
            major: '影视',
            grade: '影视一班',
            phone:'18653525596'
        },{
            stuID:"201932094",
            name: "张三",
            major: '影视',
            grade: '影视一班',
            phone:'18653525596'
        },{
            stuID:"201932094",
            name: "张三",
            major: '影视',
            grade: '影视一班',
            phone:'18653525596'
        },{
            stuID:"201932094",
            name: "张三",
            major: '影视',
            grade: '影视一班',
            phone:'18653525596'
        },{
            stuID:"201932094",
            name: "张三",
            major: '影视',
            grade: '影视一班',
            phone:'18653525596'
        }]
        ,page:true
    });
    //监听工具条
    table.on('tool(test)', function(obj){
        var data = obj.data;
        if(obj.event === 'reset'){
            layer.open( {
                type:1,
                title:"重置密码",
                content:"<div style='text-align: center;padding-top: 10px;'>该账号的密码重置为123456?</div>",
                area: ['300px','150px'], //设置宽高
                btn: ['确定重置密码', '取消'],
                btnAlign:"c"
            });
        }
    });
    //监听锁定操作
    form.on('checkbox(lockDemo)', function(obj){
       // layer.tips(this.value + ' ' + this.name + '：'+ obj.elem.checked, obj.othis);
       if( obj.elem.checked ){
           layer.msg("账号已激活,初始密码为123456,请提醒用户重新进行密码更改!");
       }else{
           layer.msg("账号已锁定!");
       }

    });

});