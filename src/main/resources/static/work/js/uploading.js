layui.use(['table', 'jquery', 'laydate', 'form', 'element', 'upload'], function () {
    var table = layui.table;
    var $ = layui.jquery;
    var element = layui.element;
    laydate = layui.laydate;
    form = layui.form,
        upload = layui.upload;
    table.render({
        elem: '#test'
        /*, url: '/query'
        , id: 'userTableReload'*/
        , toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
        , defaultToolbar: []
        , title: '用户数据表'
        , cols: [[
             {field: 'workName', title: '作业名称'}
            , {field: 'name', title: '学生姓名'}
            , {field: 'issuer', title: '发布人'}
            , {field: 'date', title: '发布日期'}
            , {field: 'commitWork', title: '提交作业'}
            , {field: 'work', title: '作业'}
            , {field: 'score', title: '评分'}
            , {fixed: 'right', title: '操作', toolbar: '#barDemo'}
        ]]
        , data: [{
            workName: "英语作业"
            , name: "张三"
            , issuer: "王丽"
            , date: "2019-11-14"
            , commitWork: "尚未提交"
            , work: ""
            , score: "20"
        }]
        , page: true
    });
    table.on('tool(test)', function(obj){
        var data = obj.data;
        //console.log(obj)
        if(obj.event === 'edit'){
            layer.open({
                btnAlign: 'c'
                ,type:1
                ,area:'500px'
                ,btn:['提交']
                ,content:$("#up")
                ,yes: function(index, layero){
                    layer.close(index);
                }
                ,success: function(index) {
                    form.val("dataForm",data);
                }
            });
        }
    });
    //多文件列表示例
    var demoListView = $('#demoList')
        , uploadListIns = upload.render({
        elem: '#testList'
        , url: '/upload/'
        , accept: 'file'
        , multiple: true
        , auto: false
        , bindAction: '#testListAction'
        , choose: function (obj) {
            var files = this.files = obj.pushFile(); //将每次选择的文件追加到文件队列
            //读取本地文件
            obj.preview(function (index, file, result) {
                var tr = $(['<tr id="upload-' + index + '">'
                    , '<td>' + file.name + '</td>'
                    , '<td>' + (file.size / 1014).toFixed(1) + 'kb</td>'
                    , '<td>等待上传</td>'
                    , '<td>'
                    , '<button class="layui-btn layui-btn-xs demo-reload layui-hide">重传</button>'
                    , '<button class="layui-btn layui-btn-xs layui-btn-danger demo-delete">删除</button>'
                    , '</td>'
                    , '</tr>'].join(''));
                //单个重传
                tr.find('.demo-reload').on('click', function () {
                    obj.upload(index, file);
                });
                //删除
                tr.find('.demo-delete').on('click', function () {
                    delete files[index]; //删除对应的文件
                    tr.remove();
                    uploadListIns.config.elem.next()[0].value = ''; //清空 input file 值，以免删除后出现同名文件不可选
                });

                demoListView.append(tr);
            });
        }
        , done: function (res, index, upload) {
            if (res.code == 0) { //上传成功
                var tr = demoListView.find('tr#upload-' + index)
                    , tds = tr.children();
                tds.eq(2).html('<span style="color: #5FB878;">上传成功</span>');
                tds.eq(3).html(''); //清空操作
                return delete this.files[index]; //删除文件队列已经上传成功的文件
            }
            this.error(index, upload);
        }
        , error: function (index, upload) {
            var tr = demoListView.find('tr#upload-' + index)
                , tds = tr.children();
            tds.eq(2).html('<span style="color: #FF5722;">上传失败</span>');
            tds.eq(3).find('.demo-reload').removeClass('layui-hide'); //显示重传
        }
    });
});