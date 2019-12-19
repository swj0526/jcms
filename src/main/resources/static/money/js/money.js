layui.use(['table', 'jquery', 'laydate', 'form', 'element', 'upload'], function () {
    var table = layui.table;
    var $ = layui.jquery;
    laydate = layui.laydate;
    form = layui.form,
        upload = layui.upload;
    table.render({
        elem: '#test'
        , url: '/money/list'
        , id: 'userTableReload'
        , cols: [[
            //{field: 'id', title: '学号', width: 80, fixed: 'left', unresize: true, sort: true}
            {field: 'name', title: '姓名', width: 150}
            , {field: 'semesterName', title: '学年', width: 60}
            , {field: 'typeName', title: '缴费类型', width: 90}
            , {field: 'paymentMethodName', title: '缴费方式', width: 90}
            , {field: 'totalAmount', title: '总金额', width: 90}
            , {field: 'instalment', title: '是否分期'}
            , {field: 'payDate', title: '缴费日期'}
            , {field: 'discountAmount', title: '优惠金额'}
            , {field: 'payAmount', title: '金额'}
            , {field: 'factAmount', title: '总计'}
            , {field: 'startTime', title: '开始时间'}
            , {field: 'endTime', title: '结束时间'}
            , {field: 'invoice', title: '收据', toolbar: '#invoice'}
            , {field: 'remark', title: '备注', event: 'remark'}
            , {fixed: 'right', title: '操作', toolbar: '#barDemo', width: 150}
        ]]
        , data: [{}]
        , page: true
        , parseData: function (res) { //res 即为原始返回的数据
            console.log(res);
            return {
                code: '0'
                , data: res.result
                , count: res.pager.dataTotal
            }
        },
    });
    $("#addPayBillBtn").click(function () {
        layer.open({
            btnAlign: 'c',
            type: 2,
            title: '添加缴费信息',
            skin: 'layer-ext-myskin',
            area: ['100%', '100%'],
            btn: [],
            content: '/money/toaddBillPage',
        });
    });
    //监听行工具事件
    table.on('tool(test)', function (obj) {
        var data = obj.data;
        //console.log(obj)
        if (obj.event === 'modifyBtn') {
            layer.open({
                btnAlign: 'c'
                , type: 2
                , btn: ['确定', '返回']
                , area: ['100%', '100%']
                , title: '修改缴费信息'
                , btn: []
                , content: '/money/tomodify?id=' + data.id + ''
                , end: function () {//修改后刷新当前页
                    $(".layui-laypage-btn").click();

                }
            });
        } else if (obj.event === 'invoiceBtn') {
            var url;
            $.post('/attachment/listimg', {
                likeId:data.id,
                studentId:data.studentId
            }, function (result) {

                $.each(result,function (key,value) {
                     var a='<img src="'+value.url+'" style="width: 100%;height: 100%">'
                    url=url+a;

                })
                layer.open({
                    btnAlign: 'c'
                    , type: 1
                    , area: ['700px', '700px']
                    , btn: ['确定']
                    , content: '<img src="D:/workbase/jcms/target/classes/upload/img/1576636136450QT8.jpg" style="width: 100%;height: 100%">'
                })


            })

        } else if (obj.event === 'remarkBtn') {
            layer.open({
                btnAlign: 'c'
                , type: 1
                , area: ['700px', '700px']
                , btn: ['确定']
                , content: '<div>' + data.remark + '</div>'
            })
        } else if (obj.event === 'UploadBtn') {
            layer.open({
                btnAlign: 'c'
                , type: 1
                , area: ['720px', '350px']
                , btn: ['确定']
                , content: $("#UploadBtn")
                , success: function () {
                    likeId = data.id;
                    studentId = data.studentId;
                    $('#demo2').html("");
                }
            })
        }
    });
    var likeId;
    var studentId;
    laydate.render({
        elem: '#date'
        , range: true
    });
    $("#listBtn").click(function () {//查询按钮点击事件
        table.reload('userTableReload', {//table.render里面的id的值
            where: { //设定异步数据接口的额外参数，任意设
                keyword: $("#keyword").val(),
                typeId: $("#typeId").val(),
                time: $("#date").val()
            }
            , page: {
                curr: 1 //重新从第 1 页开始
            }
        });
    })
    $('#excelBtn').click(function () {
        window.location.href = "/money/toExcel";
    });
    var demoListView = $('#demoList')
        , uploadListIns = upload.render({
        elem: '#testList'
        , url: '/money/upload'
        , accept: 'file'
        , exts: 'jpg'
        , multiple: true
        , auto: false
        , bindAction: '#testListAction'
        , before: function (obj) {
            this.data = {'linkId': likeId, 'studentId': studentId};//关键代码
        }
        , choose: function (obj) {
            var files = this.files = obj.pushFile(); //将每次选择的文件追加到文件队列
            //读取本地文件
            obj.preview(function (index, file, result) {
                var tr = $(['<tr id="upload-' + index + '">'
                    , '<td>' + file.name + '</td>'
                    , '<td><img src="' + result + '" alt="' + file.name + '" class="layui-upload-img" style="height: 66px;width:100px;"></td>'
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
