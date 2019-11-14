layui.use(['table', 'jquery', 'element'], function () {
    var table = layui.table;
    var jquery = layui.jquery;
    var element = layui.element;
    table.render({
        elem: '#test'
        /*, url: '/query'
        , id: 'userTableReload'*/
        /*, toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板*/
        /*, defaultToolbar: ['filter', 'exports', 'print', { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
            title: '提示'
            , layEvent: 'LAYTABLE_TIPS'
            , icon: 'layui-icon-tips'
        }]*/
        , title: '用户数据表'
        ,cols: [[
            {field:'id', title: 'ID', sort: true,width: 150}
            ,{field:'username', title: '用户名' ,width:150} //width 支持：数字、百分比和不填写。你还可以通过 minWidth 参数局部定义当前单元格的最小宽度，layui 2.2.1 新增
            ,{field:'grade', title: '班级',sort:true,width:150}
            ,{field:'work', title: '作业'}
            ,{field:'score', title: '评分', sort: true, align: 'right', width:150}
            , {fixed: 'right', title: '操作', toolbar: '#barDemo',width:150}
        ]]
        ,data:[{
            id:"10001"
            ,username:"张三"
            ,grade: "三年级"
            ,work:"11111111"
            ,score:"20"
        }]
        , page: true
    });
    //监听行工具事件
    table.on('tool(test)', function (obj) {
        var data = obj.data;
        //console.log(obj)
        /*if (obj.event === 'del') {
            var id = data.id;
            layer.confirm('真的删除行么', function (index) {

                $.post('delStudent', {
                    id: id
                }, function (result) {
                    if (result.success) {
                        layer.msg("删除成功")
                        obj.del();
                        layer.close(index);
                    } else {
                        layer.msg("删除失败")
                    }
                })
            });
        } else if (obj.event === 'edit') {
            var name = data.name;
            var sexual = data.sexual;
            var age = data.age;
            var grade = data.grade;
            var chinese = data.chinese;
            var math = data.math;
            var english = data.english;
            //alert(name+sexual+age+grade+chinese+math+english);
            $.post('upData', {
                id: data.id,
                name: data.name,
                sexual: data.sexual,
                age: data.age,
                grade: data.grade,
                chinese: data.Chinese,
                math: data.math,
                english: data.english
            }, function (result) {
                if (result.success) {
                    obj.update({
                        name: name,
                        sexual: sexual,
                        age: age,
                        grade: grade,
                        Chinese: chinese,
                        math: math,
                        english: english,
                    })
                    layer.msg("修改成功")

                } else {
                    layer.msg("修改失败")
                }
            });
        }*/
    });
    var $ = layui.$, active = {
        reload: function () {
            var name = $("#name");
            var gradeId = $("#gradeId");
            //执行重载
            table.reload('userTableReload', {
                where: {
                    'name': name.val(),
                    'grade': gradeId.val()
                }
            }, 'data');
        }
    }
    $('.demoTable .layui-btn').on('click', function () {
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
        return false;
    });
    $('#excel').click(function () {
        window.location.href="/toExcel";
    });
});