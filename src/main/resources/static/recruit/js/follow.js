layui.use(['form', 'table', 'laydate'], function () {
    var $ = layui.jquery,
        form = layui.form,
        table = layui.table,
    laydate = layui.laydate;

    laydate.render({
        elem: '#a' //指定元素
        ,range: true
    });
    laydate.render({
        elem: '#date' //指定元素

    });


    var tableIns = table.render({
        elem: '#followTableId'
        , data: [{
            "name": "杜甫"
            , "sex": "女"
            , "time": "1994/11/20"
            , "content": "威海"
            ,"intention":"有"
        }, {

            "name": "李白"
            , "sex": "女"
            , "email": "xianxin@layui.com"
            , "time": "1994/11/20"
            , "content": "威海"
            ,"intention":"有"

            , "LAY_CHECKED": true
        }, {

            "name": "王勃"
            , "email": "xianxin@layui.com"
            , "sex": "男"
            ,"intention":"有"
            , "time": "1994/11/20"
            , "content": "威海"
        }, {

            "name": "贤心"
            , "email": "xianxin@layui.com"
            , "sex": "男"
            , "time": "1994/11/20"
            , "content": "威海"
            ,"intention":"有"
        }, {

            "name": "贤心"
            , "email": "xianxin@layui.com"
            , "sex": "男"
            , "time": "1994/11/20"
            , "content": "威海"
            ,"intention":"有"
        }, {

            "name": "贤心"
            , "email": "xianxin@layui.com"
            , "sex": "男"
            , "time": "1994/11/20"
            , "content": "威海"
            ,"intention":"有"
        }, {

            "name": "贤心"
            , "email": "xianxin@layui.com"
            , "sex": "男"
            , "time": "1994/11/20"
            , "content": "威海"
            ,"intention":"有"
        }, {

            "name": "贤心"
            , "email": "xianxin@layui.com"
            , "sex": "男"
            , "time": "1994/11/20"
            , "content": "威海"
            ,"intention":"有"
        }],
        cols: [
            [


                {
                    field: 'time',
                    title: '时间',
                    align: 'center'
                },

                {
                    field: 'content',
                    title: '内容',

                },
                {
                    field: 'classify',
                    title: '渠道',
                },
                {
                    title: '操作',
                    minWidth: 50,
                    templet: '#currentTableBar',
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
        addStudents();
    });

    // 监听删除操作
    $(".data-delete-btn").on("click", function () {
        var checkStatus = table.checkStatus('currentTableId'),
            data = checkStatus.data;
        layer.alert(JSON.stringify(data));
    });

    //修改弹窗

    function modifyStudents(data) {
        mainIndex = layer.open({
            type: 1,
            title: "添加跟进学生信息",
            skin: 'layui-layer-rim', //加上边框
            area: ['500px'], //设置宽高
            content: $("#recruit"),
            success: function (index) {
                //获取
                form.val("dataForm", data);
                url = "";
                //刷新
                tableIns.reload();

            }
        });
    }

    //添加弹窗
    function addStudents() {
        mainIndex = layer.open({
            type: 1,
            title: "添加跟进学生信息",
            // skin: 'layui-layer-rim', //加上边框
            area: ['500px'], //设置宽高
            content: $("#recruit"),
            success: function (index) {
                //清空
                $("#dataFor")[0].reset();
                url = "/";

            }
        });
    }

    //查看跟踪信息
    function recruit() {
        layer.open({
            type: 1,
            title: "跟进情况",
            // skin: 'layui-layer-rim', //加上边框
            area: ['800px'], //设置宽高
            content: $("#updateOrDelete"),
             	success: function(index) {
                    //清空
                    $("#dataFor")[0].reset();
                    url = "";

                }
        });
    }

    table.on('tool(currentTableFilter)', function (obj) {
        var data = obj.data;
        if (obj.event === 'edit') {
            modifyStudents(data);
        } else if (obj.event === 'delete') {
            layer.confirm('真的删除行么', function (index) {
                obj.del();
                layer.close(index);
            });
        } else if (obj.event === 'follow') {
            recruit()

        }
    });


});
