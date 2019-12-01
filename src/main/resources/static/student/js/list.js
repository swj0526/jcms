
layui.use(['form', 'table', 'laydate', 'layer','element','upload'], function () {
    var $ = layui.jquery,
        form = layui.form,
        element=layui.element,
        table = layui.table,
    layer = layui.layer,
        upload=layui.upload,
    laydate = layui.laydate;

    laydate.render({
        elem: '#time',

    });
    table.render({
        elem: '#currentTableId',
       url:"/student/list"
         ,id: 'testReload'
        , parseData: function (res) { //res 即为原始返回的数据
        /*   console.log(res);*/
        return {
            "code": "0",
            "count": res.pager.dataTotal,
            data: res.result
        }
    },
        cols: [
            [{
                field: 'id',
                title: '学号',
                city: "",
                sort: true,
                align: 'center'
            }, {
                    field: 'name',
                    title: '姓名',
                    align: 'center',
                event: 'setSign',
                templet: '<div><a style="color: #1E9FFF;cursor:pointer;" class="info" value={{d.id}} >{{d.name}}</a></div>'
                },
                {
                    field: 'sex',
                    title: '性别',
                    sort: true,
                    align: 'center'
                },
                {
                    field: 'birthday',
                    title: '出生年月',
                    align: 'center'
                },
                {
                    field: 'age',
                    title: '年龄',
                    sort: true,
                    align: 'center'
                },

                {
                    field: 'studentPhone',
                    title: '联系方式',
                    align: 'center'
                },

                {
                    field: 'admissionData',
                    title: '入学时间',
                    sort: true,
                    align: 'center'
                },
                {
                    field: 'graduationTime',
                    title: '毕业时间',
                    sort: true,
                    align: 'center'
                },
                {
                    field: 'stateName',
                    title: '在校状态',
                    align: 'center',
                   /* templet: function(d) {
                        return d.stateName == '1' ? '入学' : '未入学';
                    }*/
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
    var $ = layui.$, active = {
        reload: function(){
            var demoReload = $('#demoReload');

            //执行重载
            table.reload('testReload', {
                page: {
                    curr: 1 //重新从第 1 页开始
                }
                ,where: {
                        id: demoReload.val()

                }
            }, 'data');
        }
    };

    $('.demoTable .layui-btn').on('click', function(){
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });

    // 监听添加操作
    $(".data-add-btn").on("click", function () {


    });

    // 监听删除操作
    $(".data-delete-btn").on("click", function () {
        var checkStatus = table.checkStatus('currentTableId'),
            data = checkStatus.data;
        layer.alert(JSON.stringify(data));
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

    //监听表格事件
    table.on('tool(currentTableFilter)', function (obj) {
         data = obj.data;
        var id = data.id;
        if (obj.event === 'edit') {//修改
            alert(id);
            parent_tab("add"+id,"学生档案管理","/student/tostudent?id="+id);

        } else if (obj.event === 'delete') {
            layer.confirm('真的删除行么', function (index) {
                obj.del();
                layer.close(index);
            });
        }else if (obj.event === 'list'){

            parent_tab("list"+id,"学生详情","/student/information?id="+id);
        }else if (obj.event === 'setSign'){

            parent_tab("list"+id,"学生详情","/student/information?id="+id);
          
           /* layer.open({
                type:2,
                content:'/student/information?id='+id,
                area:["100%","100%"],
                title:name
            })*/
        }
    });

    $("#add").click(function () {
       var id = $("#add").val();
        parent_tab("add","学生详情","/student/tostudent");
    });
    $("#import").click(function () {
        layer.open({
            type: 1,
            title:"导入excel表格",
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

