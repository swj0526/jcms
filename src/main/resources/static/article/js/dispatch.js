layui.use(['form', 'layedit', 'laydate','upload'], function () {
    var form = layui.form
        ,layer = layui.layer
        ,upload = layui.upload
        ,layedit = layui.layedit
        ,$ = layui.jquery;

    //创建一个编辑器
    var editIndex = layedit.build('LAY_demo_editor');

    //表单取值
    layui.$('#LAY-component-form-getval').on('click', function(){
        var data = form.val('dataForm');
        alert(JSON.stringify(data));
    });
    //监听提交
    form.on('submit(demo1)', function () {
        var data = form.val('dataForm');
        var title=data.title;
        var type=data.type;
        var content=layedit.getContent(editIndex);
        layer.open({
            btnAlign: 'c',
            type: 1,
            title: "发布文章",
            content: '<h1><span>标题:</span>'+title+'</h1><p><span>类型:</span>'+type+'</p><p>内容:</p><p>'+content+'</p>',
            area: ['350px', '400px'],
            btn:['发布','存草稿'],
            yes: function () {
                $.post('/article/add', {
                    title : title,
                    type:type,
                    content:content,
                    state:3
                }, function(result) {
                    alert("成功");
                    layer.closeAll();

                });
                parent_tab("article_teacherList","公告列表","/article/teacherList");
            },
            btn2:function (index,layero) {
                alert("存草稿");
                layer.closeAll();
            }
        });
        return false;
    });
    $("#type1").click(function () {
        layer.open({
            btnAlign: 'c'
            ,type: 2
            ,title:'文章类型'
            ,area: ['720px', '350px']
            ,btn:['确定','取消']
            ,content: 'totype'
        });
    });
    //多文件列表示例
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

layui.use('laydate', function () {
    var laydate = layui.laydate;

    //常规用法
    laydate.render({
        elem: '#test1'
    });
});