layui.use(['form', 'table', 'laydate', 'layer', 'element', 'upload'], function () {
    var currPage = 1;
    var data;
    var res;
    var $ = layui.jquery,
        form = layui.form,
        element = layui.element,
        table = layui.table,
        layer = layui.layer,
        laydate = layui.laydate,
        upload = layui.upload;

    var tableIns =   table.render({
        elem: '#currentTableId',
        url: '/teacher/list',
        cols: [[
            {field: 'name', title: '姓名', align: 'center'}
            , {field: 'gender', title: '性别', align: 'center',}
            , {field: 'phone', title: '电话', align: 'center'}
            , {
                field: 'hasQuit', title: '是否在职', align: 'center', templet: function (d) {
                    if (d.hasQuit == true) {
                        return '在职';
                    }
                    if (d.hasQuit == false) {
                        return '离职';
                    }
                }
            }
            , {title: '操作', minWidth: 50, toolbar: '#currentTableBar', fixed: "right", align: "center",}
        ]], toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
        , defaultToolbar: [{
            title: '刷新表格'
            , layEvent: 'refreshBtn'
            , icon: 'layui-icon-refresh'
        }],
        page: true,
        done: function (rest, curr, count) {
            currPage = curr;
            res = rest;

            /*console.log(currPage);
            console.log(rest);*/

        },
        parseData: function (res) {
            console.log(res);
            return {
                "code": "0",
                "count": res.pager.dataTotal,
                data: res.result,
            }
        },
        id: 'testReload'
    });
    //头工具栏事件
    table.on('toolbar(currentTableId)', function (obj) {
        var checkStatus = table.checkStatus(obj.config.id);
        switch (obj.event) {
            case 'refreshBtn':
                tableIns.reload();
                break;

        }
    });
    //表格重载
    $("#query").click(function () {
        table.reload('testReload', {
            page: {
                curr: 1 //重新从第 1 页开始
            }
            , where: {
                keyword: $("#queryName").val(),
                hasQuit: $("#queryHasQuit").val()
            }
        }, 'data');
    });

    //监听表格复选框选择
    table.on('checkbox(currentTableId)', function (obj) {
        console.log(obj)
    });

//修改老师
    function modify(data) {
        var mainIndex;
        mainIndex = layer.open({
            type: 1,
            title: "修改老师信息",
            content: $("#modify1"),
            area: ['380px', '330px'],
            success: function () {
                form.val("dataForm1", data);
                $("#hasQuit1").find("option[value='" + data.hasQuit + "']").prop("selected", true);
                form.render();  //必须要加

            }
        });
        $('#modifyTeacher').click(function () {
            var id = $('#id1').val();
            var modifyName = $('#name1').val();
            var modifyPhone = $('#phone1').val();
            var modifyHasQuit = $('#hasQuit1').val();
            if (modifyPhone.length <= 11 && modifyPhone.length >= 11) {
                $.post('/teacher/modify', {
                    id: id,
                    name: modifyName,
                    phone: modifyPhone,
                    hasQuit: modifyHasQuit
                }, function (result) {
                    if (result.success == true) {
                        layer.close(mainIndex);
                        tableIns.reload();
                    } else {
                        layer.msg(result.msg);
                    }
                });
            } else {
                layer.msg("手机号码格式不正确!");
            }

        });
        $('#cancelModify').click(function () {
            layer.close(mainIndex);		//关闭窗口
        });
    }

    //删除
    table.on('tool(currentTableId)', function (obj) {
        data = obj.data;
        if (obj.event === 'edit') {
            modify(data);
        } else if (obj.event === 'del') {
            layer.confirm('真的删除行么', function (index) {
                obj.del();
                $.post('/teacher/delete', {id: data.id}, function (result) {
                    if (result.success) {
                        layer.msg("删除成功!");
                        layer.close(index);
                        tableIns.reload();
                        if (res.data.length - 1 == 0) {
                            window.location.reload();//默认刷新第一页
                        }
                    } else {
                        layer.msg(result.msg);
                    }
                });
            });
        }
    });
//添加老师

    $("#add1").click(function () {
        var index;
        index = layer.open({
            type: 1,
            title: "添加老师信息",
            content: $("#addMsgbox"),
            area: ['380px', '330px'],
            success: function () {
                //清空表单数据
                $("#dataFrm")[0].reset();
            }
        });
        $('#addTeacher').click(function () {
            var addName = $('#addName').val();
            var addGender = $('#addGender').val();
            var addPhone = $('#addPhone').val();
            if (addPhone.length <= 11 && addPhone.length >= 11) {
                $.post('/teacher/add', {
                    name: addName,
                    gender: addGender,
                    phone: addPhone,
                    hasQuit: true
                }, function (result) {
                    if (result.success == true) {
                        layer.close(index);
                    } else {
                        layer.msg(result.msg);
                    }
                });
            }
        });
        $('#cancelAdd').click(function () {
            layer.close(index);		//关闭窗口
        });

    });
    //导出点击事件
    $('#excel').click(function () {
        window.location.href = "/teacher/exportExcel";
    });

    //导入
    $("#import").click(function () {
        var mainIndex;
        mainIndex = layer.open({
            type: 1,
            title: "批量导入老师信息",
            content: $("#importForm"),
            area: ['800px', '400px'],
            success: function () {
                //清空表单数据
                $("#dataFrm")[0].reset();
            }
        });

        //下载模板
        $('#template').click(function () {
            window.location.href = "/teacher/exportTemplate";
        });

        //多文件列表示例
        var demoListView = $('#demoList')
            , uploadListIns = upload.render({
            elem: '#testList'
            , url: '/upload/'
            , accept: 'xls'
         /*   , multiple: true*/
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

});

