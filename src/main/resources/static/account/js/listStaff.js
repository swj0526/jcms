layui.use(['table', 'layer', 'jquery', 'form'], function () {
    var table = layui.table;
    var layer = layui.layer;
    var $ = layui.jquery;
    var form = layui.form;
    var  selectRole ="";
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
            {field: 'role', title: '角色'},
            {field: 'lockDemo1', title: '是否激活账号',templet: '#checkboxTpl1', unresize: true},
            {fixed: 'right', title: '操作', toolbar: '#barDemo1'}
        ]]
        , data: [{
            name: "王老师",
            department: '教务部',
            postName: '教务老师',
            role:' ',
            phone:'18653525596'
        },{
            name: "王老师",
            department: '教务部',
            postName: '教务老师',
            role:' <div id="demo2" class="xm-select-demo"></div> ',
            phone:'18653525596'
        },{
            name: "王老师",
            department: '教务部',
            postName: '教务老师',
            role:' <div id="demo3" class="xm-select-demo"></div> ',
            phone:'18653525596'
        },{
            name: "王老师",
            department: '教务部',
            postName: '教务老师',
            role:' <div id="demo4" class="xm-select-demo"></div> ',
            phone:'18653525596'
        }]
        ,page:true
    });
    //监听工具条
    table.on('tool(test1)', function(obj){
        var data = obj.data;
        if(obj.event === 'reset1'){
            layer.msg("该账号的密码重置为abcd?", {
                time: false, //20s后自动关闭
                btn: ['确定重置密码','取消']
            });
        }/*else if(obj.event === 'reset2'){
            layer.open({
                type: 1
                ,title: false //不显示标题栏
                ,closeBtn: false
                ,area: '800px;'
                ,shade: 0.5
                ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
                ,btn: ['确认设置','取消']
                ,btnAlign: 'c'
                ,moveType: 1 //拖拽模式，0或者1
                ,content: '<div style="padding: 50px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;">'+selectRole+'</div>'
                ,success: function(layero){
                    var btn = layero.find('.layui-layer-btn');
                    btn.find('.layui-layer-btn0').attr({
                        target: '_blank'
                    });
                }
            });
        }*/
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
    var demo1 = xmSelect.render({
        el: '#demo1',
        language: 'zn',
        data: [
            {name: '张三', value: 1},
            {name: '李四', value: 2},
            {name: '王五', value: 3},
        ]
    })

    document.getElementById('demo1-getValue').onclick = function(){
        //获取当前多选选中的值
        var selectArr = demo1.getValue();
        document.getElementById('demo1-value').innerHTML = JSON.stringify(selectArr, null, 2);
    }
});