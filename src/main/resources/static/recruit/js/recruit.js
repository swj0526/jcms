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
    laydate.render({
        elem: '#dat' //指定元素

    });

    $("#addtab01").click(function () {
        addtab();
    });

    var tableIns = table.render({
        elem: '#currentTableId'
        , data: [{
            "name": "杜甫"
            , "sex": "女"
            , "age": "1994/11/20"
            , "city": "威海"
        }, {

            "name": "李白"
            , "sex": "女"
            , "email": "xianxin@layui.com"
            , "age": "1994/11/20"
            , "city": "威海"

            , "LAY_CHECKED": true
        }, {

            "name": "王勃"
            , "email": "xianxin@layui.com"
            , "sex": "男"
            , "age": "1994/11/20"
            , "city": "威海"
        }, {

            "name": "贤心"
            , "email": "xianxin@layui.com"
            , "sex": "男"
            , "age": "1994/11/20"
            , "city": "威海"
        }, {

            "name": "贤心"
            , "email": "xianxin@layui.com"
            , "sex": "男"
            , "age": "1994/11/20"
            , "city": "威海"
        }, {

            "name": "贤心"
            , "email": "xianxin@layui.com"
            , "sex": "男"
            , "age": "1994/11/20"
            , "city": "威海"
        }, {

            "name": "贤心"
            , "email": "xianxin@layui.com"
            , "sex": "男"
            , "age": "1994/11/20"
            , "city": "威海"
        }, {

            "name": "贤心"
            , "email": "xianxin@layui.com"
            , "sex": "男"
            , "age": "1994/11/20"
            , "city": "威海"
        }],
        cols: [
            [{
                field: 'name',
                title: '姓名',

                width: 80
            },
                {
                    field: 'sex',
                    title: '性别',
                    sort: true,
                    align: 'center',
                    width:80

                },
                {
                    field: '',
                    title: '意向',
                    sort: true,
                    align: 'center',
                    width:80

                },


                {
                    field: 'age',
                    title: '出生年月',
                    align: 'center'
                },
                {
                    field: 'city',
                    title: '学校',
                    sort: true,
                    align: 'center'
                },


                {
                    field: 'score',
                    title: '手机号',

                },
                {
                    field: 'classify',
                    title: 'QQ号',

                },
                {
                    field: 'wealth',
                    title: '微信',

                },
                {
                    field: 'wealth',
                    title: '家长联系方式'

                },



                {
                    title: '操作',
                    Width: 80,
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
            title: "修改招生学生信息",
            skin: 'layui-layer-rim', //加上边框
            area: ['800px','600px'], //设置宽高
            content: $("#recruit"),
            success: function (index) {
                //获取
                form.val("dataForm", data);
                url = "";
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
            area: ['800px','600px'], //设置宽高
            content: $("#recruit"),
            success: function (index) {
                //清空
                $("#dataFor")[0].reset();
                url = "/";

            }
        });
    }
    //跟踪详情
    function text() {
        layer.tab({
            type: 1,
            area: ['100%','100%'],
            tab: [{
                title: '杜甫跟进详情',
                content: '<iframe src="/recruit/modifyfollow" frameborder="0" height="550px" width="100%"></iframe>',
            }, {
                title: '',
                content: '内容2'
            }, {
                title: '',
                content: '内容3'
            }]
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
            /* 	success: function(index) {
                    //清空
                    $("#dataFor")[0].reset();
                    url = "";

                } */
        });
    }
//监听删除
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
            text();

        }
    });

    //添加标签
    function addtab() {
        layer.open({
            type: 1,
            title: "自定义标签",
            skin: 'layui-layer-rim', //加上边框
            area: ['900px','500px'], //设置宽高
            content: $("#addlabe"),

        });
    }

});
