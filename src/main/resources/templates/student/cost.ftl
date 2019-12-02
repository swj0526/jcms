<!DOCTYPE html>
<html>
<head>
    <base href="${basePath}">
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="layui/css/layui.css" media="all">
    <link rel="stylesheet" href="layui/css/public.css" media="all">
    <script src="layui/layui.js"></script>
</head>
<body>
<div class="layuimini-container">
    <table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter"></table>
    <script type="text/html" id="currentTableBar">
        <a class="layui-btn layui-btn-xs data-count-edit" lay-event="edit">查看</a>
    </script>
</div>
<div id="xiaoxixi" style="display: none;">
    <div style="width: 100%; height: 100%; text-align: center;">
        <div id="1">
            <span>2019-10-1 张三 抽烟 -3分</span>
        </div>
        <div id="">
            <span>2019-10-2 张三 助人为乐 +3分</span>
        </div>
    </div>
</div>

<script src="../lib/layui-v2.5.4/layui.js" charset="utf-8"></script>
<script>
    layui.use(['form', 'table', 'laydate'], function() {
        var $ = layui.jquery,
            form = layui.form,
            table = layui.table;
        laydate = layui.laydate;

        laydate.render({
            elem: '#a',
            range: true
        });

        table.render({
            elem: '#currentTableId',
            data: [{
                "id": 1901001,
                "username": "张三",
                "sex": "男",
                "xuefen": 95,
                "time": '2019-10-1'

            }],
            cols: [[
                {field:'id', title:'ID', fixed: 'left', unresize: true, sort: true}
                ,{field:'name', title:'姓名'  }
                ,{field:'grade', title:'年级'  }
                ,{field:'type', title:'缴费类型'}
                ,{field:'paymentMethod', title:'缴费方式'}
                ,{field:'money', title:'金额' }
                ,{field:'date', title:'缴费日期'}
                ,{field:'instalment', title:'是否一次性缴费'}
                ,{field:'discount', title:'优惠金额'}
                ,{field:'Validity', title:'费用有效期'}
                ,{fixed: 'right', title:'操作', toolbar: '#barDemo'}
            ]],
            limits: [10, 15, 20, 25, 50, 100],
            limit: 10,
            page: true
        });

        // 监听搜索操作
        form.on('submit(data-search-btn)', function(data) {
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
        $(".data-add-btn").on("click", function() {
            layer.msg('添加数据');
        });

        // 监听删除操作
        $(".data-delete-btn").on("click", function() {
            var checkStatus = table.checkStatus('currentTableId'),
                data = checkStatus.data;
            layer.alert(JSON.stringify(data));
        });

        //监听表格复选框选择
        table.on('checkbox(currentTableFilter)', function(obj) {
            console.log(obj)
        });

        function addStudents() {
            mainIndex = layer.open({
                type: 1,
                title: "历史记录",
                // skin: 'layui-layer-rim', //加上边框
                area: ['400px', '500px'], //设置宽高
                content: $("#xiaoxixi"),
                /*  success: function(index) {
                  //清空
                  $("#dataFor")[0].reset();
                  url = "";

                 } */
            });
        }

        table.on('tool(currentTableFilter)', function(obj) {
            var data = obj.data;
            if (obj.event === 'edit') {
                addStudents();
            }
        });

    });
</script>
<script>

</script>

</body>
</html>
