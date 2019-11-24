layui.use(['form', 'table', 'laydate'], function () {
    var $ = layui.jquery,
        form = layui.form,
        table = layui.table,
        laydate = layui.laydate;

    laydate.render({
        elem: '#a' //指定元素
        , range: true
    });
    laydate.render({
        elem: '#date' //指定元素

    });
    laydate.render({
        elem: '#dat' //指定元素

    });


    var tableIns = table.render({
        elem: '#followTableId'
        ,url: '/dictionary/list/channel' ,
        cols: [
            [
                {
                    field: 'name',
                    title: '渠道名称',
                },
                {
                    field: 'remark',
                    title: '渠道备注',
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
        page: true,
        parseData: function (res) { //res 即为原始返回的数据
            /*   console.log(res);*/
            return {
                "code": "0",
                "count": res.count,
                data: res.data
            }
        }
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
var url;
    function modifyStudents(data) {
        mainIndex = layer.open({
            type: 1,
            title: "修改渠道信息",
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
            title: "添加渠道信息",
            // skin: 'layui-layer-rim', //加上边框
            area: ['500px'], //设置宽高
            content: $("#recruit"),
            success: function (index) {
                //清空
                $("#dataFor")[0].reset();
            }
        });
    }

    $('#add').click(function () {
        var name =$("[name='name']").val();
        var remark =$("[name='remark']").val();
        $.post('/dictionary/add',{
            name:name,
            remark:remark,
            type:2
        },function (result) {
            if(result.success()){
                $('#recruit').css("display","none");
            }
        });
    });

    //查看跟踪信息
    function recruit() {
        layer.open({
            type: 1,
            title: "跟进情况",
            // skin: 'layui-layer-rim', //加上边框
            area: ['800px'], //设置宽高
            content: $("#updateOrDelete"),
            success: function (index) {
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
