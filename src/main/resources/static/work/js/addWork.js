layui.use(['table', 'jquery', 'laydate', 'form', 'element', 'upload'], function () {
    var table = layui.table;
    var $ = layui.jquery;
    var element = layui.element;
    laydate = layui.laydate;
    var upload = layui.upload;
    form = layui.form;
    var attachmentId = 0;//在附件表中附件id

    //获取系统当前时间
    function getNow(s) {
        return s < 10 ? '0' + s : s;
    }

    var myDate = new Date();
    var year = myDate.getFullYear();        //获取当前年
    var month = myDate.getMonth() + 1;   //获取当前月
    var date = myDate.getDate();            //获取当前日
    var h = myDate.getHours();              //获取当前小时数(0-23)
    var m = myDate.getMinutes();          //获取当前分钟数(0-59)
    var s = myDate.getSeconds();
    var now = year + '-' + getNow(month) + "-" + getNow(date) + " " + getNow(h) + ':' + getNow(m) + ":" + getNow(s);

    $('[name="name"]').val(now + "的作业");

    //选完文件后不自动上传
    var currPage = 1;
    laydate.render({
        elem: '#endTime'
    });

    $('#submit').click(function () {
        let serialize = $("#dataFor").serialize();
        $.post('/work/add/homework', serialize+"&attachmentId="+attachmentId, function (result) {
            if (result.success == true) {
                close_tab("work_add", "work_list", "作业列表", "/work/list");
            } else {

            }
        });

    });
    //多文件列表示例
    var demoListView = $('#demoList')
        , uploadListIns = upload.render({
        elem: '#testList'
        , url: '/work/upload/'
        , accept: 'file'
       /* , multiple: false*/
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
                attachmentId=res.result;
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