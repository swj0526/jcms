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
            {field: 'name', title: '学生姓名'},
            {field: 'major', title: '所属专业'},
            {field: 'grade', title: '所属班级'},
            {field: 'lastTime', title: '上次缴费时间'},
            {field: 'lastMoney', title: '上次缴费金额'},
            {field: 'expireTime', title: '学费到期时间'},
            {field: 'thisMoney', title: '本次缴费金额'},
            {field: 'parentPhone', title: '父母联系方式'},
            {fixed: 'right', title: '操作', toolbar: '#barDemo'}
        ]]
        , data: [{
            name: "张三",
            major: '影视',
            grade: '影视一班',
            lastTime:'2019-1-1',
            lastMoney:'5000元',
            expireTime:'2019-10-10',
            thisMoney:'5000元',
            parentPhone:'18934219987',
        }]
    });
    $('#see').click(function () {
        //示范一个公告层
        layer.open({
            type: 1
            ,
            title: false //不显示标题栏
            ,
            closeBtn: false
            ,
            area: '1000px;'
            ,
            shade: 0.8
            ,
            id: 'LAY_layuipro' //设定一个id，防止重复弹出
            ,
            btn: ['火速围观', '残忍拒绝']
            ,
            btnAlign: 'c'
            ,
            moveType: 1 //拖拽模式，0或者1
            ,
            content: '<div style="padding: 50px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;">你知道吗？亲！<br>layer ≠ layui<br><br>layer只是作为Layui的一个弹层模块，由于其用户基数较大，所以常常会有人以为layui是layerui<br><br>layer虽然已被 Layui 收编为内置的弹层模块，但仍然会作为一个独立组件全力维护、升级。<br><br>我们此后的征途是星辰大海 ^_^</div>'
            ,
            success: function (layero) {
                var btn = layero.find('.layui-layer-btn');
                btn.find('.layui-layer-btn0').attr({
                    href: ''
                    , target: '_blank'
                });
            }
        });
    });


});