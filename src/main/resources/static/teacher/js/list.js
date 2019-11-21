var a=new Array();
a=[{
    "id": 1,
    "name": "杜海涛",
    "phone": "18555464445",
    "state":"在任 "
},{
    "id": 2,
    "name": "李世杰",
    "phone": "男",
    "state":"离职 "
}]
layui.use(['form', 'table', 'laydate', 'layer','element'], function () {
    var $ = layui.jquery,
        form = layui.form,
        element=layui.element,
        table = layui.table,
        layer = layui.layer,
        laydate = layui.laydate;

    laydate.render({
        elem: '#time',
        range: true
    });
    table.render({
        elem: '#currentTableId',
        data: a,
        cols: [
            [{
                field: 'id',
                title: 'Id',
                sort: true,
                align: 'center'
            }, {
                field: 'name',
                title: '姓名',
                align: 'center',
            },
                {
                    field: 'phone',
                    title: '性别',
                    align: 'center'
                },
                {
                    field: 'state',
                    title: '状态',
                    align: 'center'
                },
                {
                    title: '操作',
                    minWidth: 50,
                    toolbar: '#currentTableBar',
                    fixed: "right",
                    align: "center",

                }
            ]
        ],
        limits: [10, 15, 20, 25, 50, 100],
        limit: 10,
        page: true
    });

    // 监听搜索操作
    form.on('submit(data-search-btn)', function (data) {
        var result = JSON.stringify(data.field);
        layer.alert(result, {
            title: '最终的搜索信息'
        });

        //执行搜索重载
        table.reload('currentTableId', {
            page: {
                curr: 1
            },
            where: {
                searchParams: result
            }
        }, 'data');

        return false;
    });

    // 监听添加操作
    $(".data-add-btn").on("click", function () {
        layer.msg('添加数据');
    });


    //监听表格复选框选择
    table.on('checkbox(currentTableFilter)', function (obj) {
        console.log(obj)
    });
    function modify(data){
        layer.open({
            type: 1,
            title:"修改学生信息",
            content: $("#aaa"),
            btn:"提交",
            area:['750px','320px'],
            success:function (index) {
                form.val("dataForm",data)
            }
        })
    }
    table.on('tool(currentTableFilter)', function (obj) {
        data = obj.data;
        if (obj.event === 'edit') {
            modify(data);
        } else if (obj.event === 'delete') {
            layer.confirm('真的删除行么', function (index) {
                obj.del();
                layer.close(index);
            });
        }
    });

    $("#add").click(function () {
        layer.open({
            type: 1,
            title:"添加学生信息",
            content: $("#aaa"),
            btn:"提交",
            area:['750px','320px'],
            success:function (index) {
                //清空表单数据
                $("#dataFrm")[0].reset();
            }
        })
    });
    $("#import").click(function () {
        layer.open({
            type: 1,
            title:"添加学生信息",
            content: $("#importForm"),
            btn:"提交",
            area:['750px','320px'],
        })
    });
    var demoListView = $('#demoList')
        ,uploadListIns = upload.render({
        elem: '#testList'
        ,url: '/upload/'
        ,accept: 'file'
        ,multiple: true
        ,auto: false
        ,bindAction: '#testListAction'
        ,choose: function(obj){
            var files = this.files = obj.pushFile(); //将每次选择的文件追加到文件队列
            //读取本地文件
            obj.preview(function(index, file, result){
                var tr = $(['<tr id="upload-'+ index +'">'
                    ,'<td>'+ file.name +'</td>'
                    ,'<td>'+ (file.size/1014).toFixed(1) +'kb</td>'
                    ,'<td>等待上传</td>'
                    ,'<td>'
                    ,'<button class="layui-btn layui-btn-xs demo-reload layui-hide">重传</button>'
                    ,'<button class="layui-btn layui-btn-xs layui-btn-danger demo-delete">删除</button>'
                    ,'</td>'
                    ,'</tr>'].join(''));

                //单个重传
                tr.find('.demo-reload').on('click', function(){
                    obj.upload(index, file);
                });

                //删除
                tr.find('.demo-delete').on('click', function(){
                    delete files[index]; //删除对应的文件
                    tr.remove();
                    uploadListIns.config.elem.next()[0].value = ''; //清空 input file 值，以免删除后出现同名文件不可选
                });

                demoListView.append(tr);
            });
        }
        ,done: function(res, index, upload){
            if(res.code == 0){ //上传成功
                var tr = demoListView.find('tr#upload-'+ index)
                    ,tds = tr.children();
                tds.eq(2).html('<span style="color: #5FB878;">上传成功</span>');
                tds.eq(3).html(''); //清空操作
                return delete this.files[index]; //删除文件队列已经上传成功的文件
            }
            this.error(index, upload);
        }
        ,error: function(index, upload){
            var tr = demoListView.find('tr#upload-'+ index)
                ,tds = tr.children();
            tds.eq(2).html('<span style="color: #FF5722;">上传失败</span>');
            tds.eq(3).find('.demo-reload').removeClass('layui-hide'); //显示重传
        }
    });
});

