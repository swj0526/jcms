layui.use('table', function(){
    var table = layui.table;

    table.render({
        elem: '#test'
        ,url:'/test/table/demo1.json'
        ,toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
        ,defaultToolbar: ['filter', 'exports', 'print', { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
            title: '提示'
            ,layEvent: 'LAYTABLE_TIPS'
            ,icon: 'layui-icon-tips'
        }]
        ,title: '用户数据表'
        ,cols: [[
            {type: 'checkbox', fixed: 'left'}
            ,{field:'id', title:'ID', width:80, fixed: 'left', unresize: true, sort: true}
            ,{field:'name', title:'姓名',  edit: 'text'}
            ,{field:'grade', title:'班级',  edit: 'text'}
            ,{field:'type', title:'缴费类型',  edit: 'text'}
            ,{field:'money', title:'学费金额',  edit: 'text'}
            ,{field:'data', title:'缴费日期',  edit: 'text'}
            ,{field:'paymentMethod', title:'缴费方式'}
            ,{field:'Installments', title:'是否一次性缴费',  edit: 'text'}
            ,{field:'discount', title:'优惠金额',  edit: 'text'}
            ,{field:'Validity', title:'费用有效期',  edit: 'text'}
            ,{fixed: 'right', title:'操作', toolbar: '#barDemo',}
        ]]
        ,page: true
    });

    //头工具栏事件
    table.on('toolbar(test)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id);
        switch(obj.event){
            case 'add':
                layer.open({
                    title: '在线调试'
                    ,btnAlign: 'c'
                    ,btn:['按钮一']
                    ,content:'from'
                });
        };
    });

    //监听行工具事件
    table.on('tool(test)', function(obj){
        var data = obj.data;
        //console.log(obj)
        if(obj.event === 'del'){
            layer.confirm('真的删除行么', function(index){
                obj.del();
                layer.close(index);
            });
        } else if(obj.event === 'edit'){
            layer.prompt({
                formType: 2
                ,value: data.email
            }, function(value, index){
                obj.update({
                    email: value
                });
                layer.close(index);
            });
        }
    });
});