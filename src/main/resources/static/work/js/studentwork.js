layui.use(['table', 'jquery', 'laydate', 'form', 'element'], function () {
    var table = layui.table;
    var $ = layui.jquery;
    laydate = layui.laydate;
    form = layui.form,
        table.render({
            elem: '#test'
            /*,url:'/test/table/demo1.json'*/
            , title: '用户数据表'
            , cols: [[
                {field: 'name', title: '学生姓名'}
                , {field: 'work', title: '作业'}
                , {fixed: 'right', title: '下载', toolbar: '#barDemo', width: 80}
            ]]
            , page: true
            , data: [{
                 name: '张三'
                , work: '111.zip'
            },{
                name: '张三'
                , work: '111.zip'
            },{
                name: '张三'
                , work: '111.zip'
            },{
                name: '张三'
                , work: '111.zip'
            },{
                name: '张三'
                , work: '111.zip'
            },{
                name: '张三'
                , work: '111.zip'
            },{
                name: '张三'
                , work: '111.zip'
            },{
                name: '张三'
                , work: '111.zip'
            },{
                name: '张三'
                , work: '111.zip'
            },{
                name: '张三'
                , work: '111.zip'
            }]
        });
});