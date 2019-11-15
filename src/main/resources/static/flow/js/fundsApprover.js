layui.use('table', function(){
    var table = layui.table;

    table.render({
        elem: '#test'

        ,toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
        ,defaultToolbar: [ { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
            title: '提示'
            ,layEvent: 'LAYTABLE_TIPS'
            ,icon: 'layui-icon-tips'
        }]
        ,title: '用户数据表'
        ,cols: [[
            {type: 'checkbox', fixed: 'left',align: 'center'}
            ,{field:'id', title:'序号', fixed: 'left',align: 'center', sort: true}
            ,{field:'name', title:'姓名',align: 'center'}
            ,{field:'grade', title:'年级',align: 'center'}
            ,{field:'cause', title:'申请事由',align: 'center'}
            ,{field:'money', title:'申请金额',align: 'center'}
            ,{field:'apply', title:'申请日期',align: 'center'}
            ,{field: 'start', title: '开始日期',align: 'center'}
            ,{field: 'state', title: '状态',align: 'center'}
            , {fixed: 'right', title: '操作', toolbar: '#barDemo',align: 'center'}
        ]]
        , data: [{
            "id": "10001",
            "name": "张三",
            "grade": "三年级",
            "money": "3000",
            "apply": "2016-10-14",
            "start": "2016-10-15",
            "state": "yi",
            "cause": "有事asdasdasdasfasfasdgdfsdf12"
        }, {
            "id": "10001",
            "name": "张三",
            "grade": "三年级",
            "money": "1000",
            "apply": "2016-10-14",
            "start": "2016-10-15",
            "state": "拒绝",
            "cause": "有事"
        }, {
            "id": "10001",
            "name": "张三",
            "grade": "三年级",
            "money": "300",
            "apply": "2016-10-14",
            "start": "2016-10-15",
            "state": "拒绝",
            "cause": "有事"
        }, {
            "id": "10001",
            "name": "张三",
            "grade": "三年级",
            "money": "1000",
            "apply": "2016-10-14",
            "start": "2016-10-15",
            "state": "拒绝",
            "cause": "有事"
        }, {
            "id": "10001",
            "name": "张三",
            "grade": "三年级",
            "money": "2000",
            "apply": "2016-10-14",
            "start": "2016-10-15",
            "state": "同意",
            "cause": "有事"
        }, {
            "id": "10001",
            "name": "张三",
            "grade": "三年级",
            "money": "10000",
            "apply": "2016-10-14",
            "start": "2016-10-15",
            "state": "拒绝",
            "cause": "有事"
        }, {
            "id": "10001",
            "name": "张三",
            "grade": "三年级",
            "money": "3000",
            "apply": "2016-10-14",
            "start": "2016-10-15",
            "state": "拒绝",
            "cause": "有事"
        }, {
            "id": "10001",
            "name": "张三",
            "grade": "三年级",
            "money": "2000",
            "apply": "2016-10-14",
            "start": "2016-10-15",
            "state": "同意",
            "cause": "有事"
        }]
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

    //请求路径
    var url;
    //标记弹出层
    let mainIndex;

    //修改弹窗
    function modify(data) {
        mainIndex = layer.open({
            type: 1,
            title: "查看请假审批详情",
            skin: 'layui-layer-rim', //加上边框
            area: ['400px', '600px'], //设置宽高
            content: $("#updateOrDelete"),
            success: function (index) {
                form.val("dataForm", data);
                url = "/update"
            }
        });
    }

    /*  //监听行工具事件，数据弹窗
      table.on('tool(test)', function (obj) {
          var data = obj.data;//获得当前行数据
              modify(data);
      });*/
    table.on('tool(test)', function (obj) {
        var data = obj.data;//获得当前行数据
        //console.log(obj)  obj.event获取lay-event 对应的值
        if (obj.event === 'del') {
            layer.confirm('真的删除行么', function (index) {
                obj.del();
                layer.close(index);//向服务端发送删除指令
                //删除事件
                $.post("/delete", {id: data.id,studentId:data.id}, function () {
                });
            });
        } else if (obj.event === 'edit') {//编辑
            modify(data);
        }
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
    //日期范围
    laydate.render({
        elem: '#test6',
        range: true
    });
});