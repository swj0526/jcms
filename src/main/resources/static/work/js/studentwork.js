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
                {field: 'name', title: '学生姓名',width: 200}
                ,{field: 'grade', title: '年级',width: 200}
                ,{field: 'name', title: '提交时间',width: 200}
                , {field: 'picture', title: '作业',event:'img',sore:true,templet:function (d) {
                        return '<div><img src="'+d.brand_img_url+'" alt="" width="50px" height="50px"></div>';
                    }}
                ,{field: 'name', title: '评分',width: 200}
                , {fixed: 'right', title: '下载', toolbar: '#barDemo', width: 200}
            ]]
            , page: true
            , data: [{
                 name: '张三'
                , picture: 'img/1.png'
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
    table.on('tool(test)', function (obj) {
        var data = obj.data;
        //console.log(obj)
        if (obj.event === 'img') {
            layer.open({
                type: 1,
                skin: 'layui-layer-rim', //加上边框
                area: ['80%', '80%'], //宽高
                shadeClose: true, //开启遮罩关闭
                content: '<div style="text-align:center"><img src="' + data.brand_img_url + '" /></div>'
            });

        }else if (obj.event === 'del'){
            layer.confirm('确定要删除上传的作业么？', function(index){

                layer.close(index);
            });
        }
    });
});
