layui.use('table', function(){
    var table = layui.table;
	

    table.render({
        elem: '#test'
        ,url:'/getListStudent'

        ,toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
        ,defaultToolbar: [ , { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
            title: '提示'
            ,layEvent: 'LAYTABLE_TIPS'
            ,icon: 'layui-icon-tips'
        }]
        ,title: '用户数据表'
        ,cols: [[
            {type: 'checkbox', fixed: 'left'}
            ,{field:'id', title:'学号', width:80, fixed: 'left', unresize: true, sort: true}
            ,{field:'name', title:'姓名', width:100, edit: 'text'}
            ,{field:'age', title:'年级', width:100, edit: 'text'}
			,{field:'age', title:'请假时长', width:100, edit: 'text'}
			,{field:'age', title:'申请日期', width:150, edit: 'text'}
			,{field:'age', title:'请假日期', width:150, edit: 'text'}
			,{field:'age', title:'请假事由', width:300, edit: 'text'}
        ]]
        ,page: true
    });

    var form = layui.form;
    var layer = layui.layer;
    

    $ = layui.jquery;

    $("#add").on('click', function() {
        layer.open({
            type : 1,
            title : "学生录入",
            skin : "myclass", // 自定样式
            area : [ "400px", "600px" ],
            content : $("#aaa"),

            success : function(layero, index) {
            },
            yes : function() {
            }
        });

        $('#student').click(function() {
            var xName=$('#xname').val();
            var age=$('#age').val();
            var gradeId=$('#grade').val();
            $.post('/studentAdd', {
                name : xName,
                age : age,
                gradeid:gradeId
            }, function(a,b) {
                alert(b.id);
            });
        });
        form.render(); // 动态渲染
    });

 
});
//日期方法
layui.use('laydate', function(){
  var laydate = layui.laydate;
  //常规用法
  laydate.render({
    elem: '#test1'
  });
  laydate.render({
    elem: '#test2'
  });
});