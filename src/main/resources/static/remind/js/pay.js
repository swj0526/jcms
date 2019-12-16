layui.use(['table', 'layer', 'jquery', 'form', 'laydate'], function () {
    var table = layui.table;
    var layer = layui.layer;
    var $ = layui.jquery;
    var form = layui.form;
    var laydate = layui.laydate;
    //渲染数据表格
    var tableIns = table.render({
        elem: '#test'//渲染目标
        /* , url: '/json/table.json'//数据接口*/
        , id: 'userTableReload'
        //解析table 组件规定的数据结构
        , parseData: function (res) { //res 即为原始返回的数据
            /*   console.log(res);*/
            return {
                "code": "0",
                "count": res.pager.dataTotal,
                data: res.result
            }
        }
        , cols: [[
            {field: 'name', title: '学生姓名/学号'},
            {field: 'grade', title: '专业-班级'},
            {field: 'lastTime', title: '上次缴费时间'},
            {field: 'lastMoney', title: '上次缴费金额'},
            {field: 'expireTime', title: '学费到期时间'},
            {fixed: 'right', title: '操作', toolbar: '#barDemo'}
        ]]
        , data: [{
            stuID: "201932094",
            name: "张三",
            major: '影视',
            grade: '影视一班',
            lastTime: '2019-1-1',
            lastMoney: '5000元',
            expireTime: '2019-10-10',

            parentPhone: '18934219987',
        }, {
            stuID: "201932094",
            name: "张三",
            major: '影视',
            grade: '影视一班',
            lastTime: '2019-1-1',
            lastMoney: '5000元',
            expireTime: '2019-10-10',

            parentPhone: '18934219987',
        }, {
            stuID: "201932094",
            name: "张三",
            major: '影视',
            grade: '影视一班',
            lastTime: '2019-1-1',
            lastMoney: '5000元',
            expireTime: '2019-10-10',

            parentPhone: '18934219987',
        }, {
            stuID: "201932094",
            name: "张三",
            major: '影视',
            grade: '影视一班',
            lastTime: '2019-1-1',
            lastMoney: '5000元',
            expireTime: '2019-10-10',

            parentPhone: '18934219987',
        }, {
            stuID: "201932094",
            name: "张三",
            major: '影视',
            grade: '影视一班',
            lastTime: '2019-1-1',
            lastMoney: '5000元',
            expireTime: '2019-10-10',

            parentPhone: '18934219987',
        }, {
            stuID: "201932094",
            name: "张三",
            major: '影视',
            grade: '影视一班',
            lastTime: '2019-1-1',
            lastMoney: '5000元',
            expireTime: '2019-10-10',

            parentPhone: '18934219987',
        }, {
            stuID: "201932094",
            name: "张三",
            major: '影视',
            grade: '影视一班',
            lastTime: '2019-1-1',
            lastMoney: '5000元',
            expireTime: '2019-10-10',

            parentPhone: '18934219987',
        }, {
            stuID: "201932094",
            name: "张三",
            major: '影视',
            grade: '影视一班',
            lastTime: '2019-1-1',
            lastMoney: '5000元',
            expireTime: '2019-10-10',

            parentPhone: '18934219987',
        }]
        , page: true
    });
    $('#see').click(function () {
        layer.msg("跳到学生档案页面查看详情");
    });
    laydate.render({
        elem: '#a' //指定元素
        , range: true
    });

});