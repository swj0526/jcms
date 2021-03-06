layui.use(['table', 'jquery', 'laydate', 'form', 'element', 'upload'], function () {
    var table = layui.table;
    var $ = layui.jquery;
    var element = layui.element;
    laydate = layui.laydate;
    var upload = layui.upload;
    form = layui.form;
        //选完文件后不自动上传
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
        ,progress: function(n){
            var percent = n + '%' //获取进度百分比
            element.progress('demo', percent); //可配合 layui 进度条元素使用
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
            , {field: 'issuer', title: '发布人'}
            , {field: 'releaseTime', title: '发布日期', sort: true}
            , {field: 'submissionTime', title: '提交时间', sort: true}
            , {field: 'file ', title: '作业文件'}
            , {field: 'score ', title: '分数',width:120}
            , {fixed: 'right', title: '操作', toolbar: '#barDemo'}
        ]]
        , data: [{
            workName: "英语作业"
            , issuer: "王丽"
            , releaseTime: "2019-11-14"
            , submissionTime: "尚未提交"
            , content: ""
            , score: "20"
        }, {
            workName: "英语作业"
            , issuer: "王丽"
            , releaseTime: "2019-11-15"
            , submissionTime: "2019-11-15"
            , content: ""
            , score: "20"
        }]
        , page: true
    });
    table.on('tool(test)', function (obj) {
        var data = obj.data;
        //console.log(obj)
        if (obj.event === 'edit') {
            layer.tab({
                type: 1,

                area: ['100%','100%'],
                tab: [{
                    title: '作业管理',
                    content:'<iframe src="/work/uploading" frameborder="0" height="800px" width="100%"></iframe>',
                }]
            });
        }
    });
    laydate.render({
        elem: '#test6'
        , range: true
    });
});