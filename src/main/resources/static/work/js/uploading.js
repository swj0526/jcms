layui.use(['table', 'jquery', 'laydate', 'form', 'element', 'upload'], function () {
    var table = layui.table;
    var $ = layui.jquery;
    var element = layui.element;
    laydate = layui.laydate;
    var upload = layui.upload;
    form = layui.form;


        //选完文件后不自动上传
    upload.render({
        elem: '#test8'
        ,url: '/upload/'
        ,auto: false
        ,accept:'file'
        ,exts:'zip|rar|7z'
        ,bindAction: '#test9'
        ,done: function(res){
            console.log(res)
        }
        ,error: function(){
            //请求异常回调
        }
    });


    table.render({
        elem: '#test'
        /*, url: '/query'
        , id: 'userTableReload'*/
        , defaultToolbar: []
        , title: '用户数据表'
        , cols: [[
            {field: 'workName', title: '作业名称'}
            , {field: 'name', title: '学生姓名'}
            , {field: 'issuer', title: '发布人'}
            , {field: 'date', title: '发布日期', sort: true}
            , {field: 'commitDate', title: '提交时间', sort: true}
            , {field: 'work', title: '作业'}
            , {field: 'score', title: '评分'}
            , {fixed: 'right', title: '操作', toolbar: '#barDemo'}
        ]]
        , data: [{
            workName: "英语作业"
            , name: "张三"
            , issuer: "王丽"
            , date: "2019-11-14"
            , commitDate: "尚未提交"
            , work: ""
            , score: "20"
        }, {
            workName: "英语作业"
            , name: "张三"
            , issuer: "王丽"
            , date: "2019-11-15"
            , commitDate: "2019-11-15"
            , work: ""
            , score: "20"
        }]
        , page: true
    });
    table.on('tool(test)', function (obj) {
        var data = obj.data;
        //console.log(obj)
        if (obj.event === 'edit') {
            layer.open({
                btnAlign: 'c'
                , type: 1
                , area: '500px'
                , btn: ['确定']
                , content: $("#up")
                , yes: function (index, layero) {
                    layer.close(index);
                }
            });
        }else if (obj.event === 'del'){
            layer.confirm('真的删除行么', function(index){

                layer.close(index);
            });
        }
    });
    laydate.render({
        elem: '#test6'
        , range: true
    });
});