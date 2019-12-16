layui.use(['table', 'jquery', 'laydate', 'form', 'element'], function () {
    var table = layui.table;
    var $ = layui.jquery;
    var element = layui.element;
    laydate = layui.laydate;
    form = layui.form;
    var currPage = 1;
    var data;
    var tableIns = table.render({
            elem: '#workTable'
            , url: '/work/list/homework'
            , id: 'reloadList'
            , cols: [[
                {field: 'name', title: '作业名称'}
                , {field: 'teacherName', title: '发布人'}
                , {field: 'majorName', title: '专业班级'}
                , {field: 'createTime', title: '发布日期'}
                , {field: 'endTime', title: '截止日期'}
                , {field: 'content', title: '内容', width: 100}
                , {fixed: 'right', title: '操作', toolbar: '#barDemo', width: 230}
            ]], toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
            , defaultToolbar: [{
                title: '刷新表格'
                , layEvent: 'refreshBtn'
                , icon: 'layui-icon-refresh'
            }, {
                title: '添加'
                , layEvent: 'addBtn'
                , icon: 'layui-icon-add-circle'
            }]
            , page:
                true,
            done:

                function (rest, curr, count) {
                    currPage = curr;
                    res = rest;
                    data = rest;
                    /* console.log(currPage);
                     console.log(rest);*/

                }

            ,
            parseData: function (res) { //res 即为原始返回的数据
                /*   console.log(res);*/
                return {
                    "code": "0",
                    "count": res.pager.dataTotal,
                    data: res.result
                }
            }
        })
    ;
//头工具栏事件
    table.on('toolbar(workTable)', function (obj) {
        var checkStatus = table.checkStatus(obj.config.id);
        switch (obj.event) {
            case 'addBtn':
                parent_tab("work_add", '发布作业', "/work/toadd");
                break;
            case 'refreshBtn':
                tableIns.reload();
                break;

        }
        ;
    });

    //监听行工具事件
    table.on('tool(workTable)', function (obj) {
        data = obj.data;
        //console.log(obj)
        if (obj.event === 'modify') {
            var id = data.id;
            parent_tab("work_modify" + id, '修改作业', "/work/get/homework?id=" + id + "&type=1");
        } else if (obj.event === 'downloadWork') {
            layer.tab({
                type: 1,
                area: ['100%', '100%'],
                tab: [{
                    title: '学生作业下载',
                    content: '<iframe src="/work/download" frameborder="0" height="800px" width="100%"></iframe>',
                }]
            });
        } else if (obj.event === 'details') {
            var id = data.id;
            parent_tab("work_details" + id, '查看作业详情', "/work/get/homework?id=" + id + "&type=2");
        }
    });
    var $ = layui.$, active = {
        reload: function () {
            //执行搜索重载
            table.reload('reloadList', {
                page: {
                    curr: currPage
                },
                where: {
                    "keywords": $('[name="keywords"]').val(),
                    "majorId": $('#gradeSelect').val(),
                    "scopeTime": $('[name="scopeTime"]').val()
                }
            }, 'data');
        }
    }
    laydate.render({
        elem: '#scopeTime'
        , range: true
    });

    $('.demoTable .layui-btn').on('click', function () {
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';

    });


});