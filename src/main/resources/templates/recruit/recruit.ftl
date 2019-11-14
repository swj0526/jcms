<!DOCTYPE html>
<html>
<head>
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
    <div class="layuimini-main">

        <fieldset class="layui-elem-field layuimini-search">
            <legend>搜索信息</legend>
            <div style="margin: 10px 10px 10px 10px">
                <form class="layui-form layui-form-pane" action="">
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">学生姓名</label>
                            <div class="layui-input-inline">
                                <input type="text" name="username" autocomplete="off" class="layui-input">
                            </div>
                        </div>

                        <div class="layui-inline">
                            <label class="layui-form-label">跟进时间</label>
                            <div class="layui-input-inline">
                                <input type="text" name="city" autocomplete="off" class="layui-input" id="a">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">性别</label>
                            <input type="radio" name="sex" value="nan" title="男">
                            <input type="radio" name="sex" value="nv" title="女" checked>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">意向</label>
                            <input type="radio" name="intention" value="nan" title="有">
                            <input type="radio" name="intention" value="nv" title="无" checked>
                        </div>
                        <div class="layui-inline">
                            <a class="layui-btn" lay-submit="" lay-filter="data-search-btn">搜索</a>
                        </div>
                    </div>
                </form>
            </div>
        </fieldset>

        <div class="layui-btn-group">
            <button class="layui-btn data-add-btn">添加学生信息</button>
            <button class="layui-btn layui-btn-danger data-delete-btn">导出学生信息</button>
        </div>
        <table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter"></table>
        <script type="text/html" id="currentTableBar">
            <a class="layui-btn layui-btn-xs data-count-edit" lay-event="edit">修改</a>
            <a class="layui-btn layui-btn-xs layui-btn-danger data-count-delete" lay-event="delete">删除</a>
        </script>
    </div>
</div>
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
            url: '../api/table.json',
            cols: [
                [{
                    field: 'username',
                    title: '姓名',
                    align: 'center'
                },
                    {
                        field: 'sex',
                        title: '性别',
                        sort: true,
                        align: 'center'
                    },
                    {
                        field: 'city',
                        title: '出生年月',
                        align: 'center'
                    },
                    {
                        field: 'sex',
                        title: '学校',
                        sort: true,
                        align: 'center'
                    },
                    {
                        field: 'sign',
                        title: '跟进情况',
                        align: 'center'
                    },
                    {
                        field: 'experience',
                        title: '跟进时间',
                        align: 'center'
                    },
                    {
                        field: 'score',
                        title: '手机号',
                        align: 'center'
                    },
                    {
                        field: 'classify',
                        title: 'QQ号',
                        align: 'center'
                    },
                    {
                        field: 'wealth',
                        title: '微信',
                        align: 'center'
                    },
                    {
                        field: 'wealth',
                        title: '家长联系方式',
                        align: 'center'
                    },
                    {
                        field: 'wealth',
                        title: '意向',
                        align: 'center'
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

        table.on('tool(currentTableFilter)', function(obj) {
            var data = obj.data;
            if (obj.event === 'edit') {
                layer.alert('编辑行：<br>' + JSON.stringify(data))
            } else if (obj.event === 'delete') {
                layer.confirm('真的删除行么', function(index) {
                    obj.del();
                    layer.close(index);
                });
            }
        });

    });
</script>
<script>

</script>

</body>
</html>
