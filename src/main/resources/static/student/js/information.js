layui.use(['element','jquery','table'], function(){
    var table = layui.table;
    var element = layui.element;
    var $ = layui.jquery;
    table.render({
        elem: '#test',
        data: [{
            "username": "定金",
            "sex": "微信",
            "city": "100",
            "sign": "2019-10-1",
            "experience": "否",
            "logins": 0,
            "classify": "2019-10-1",
            "score": 57
        }]
        ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
        ,cols: [[
            {field:'username', title: '缴费类型'}
            ,{field:'sex',  title: '缴费方式'}
            ,{field:'city',  title: '金额'}
            ,{field:'sign', title: '缴费日期', } //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
            ,{field:'experience', title: '是否一次性缴费'}
            ,{field:'score', title: '优惠金额'}
            ,{field:'classify', title: '费用有效期'}

        ]]
    });
    table.render({
        elem: '#information',
        data: [{
            "theClass": "影视一班",
            "reason": "打架斗殴",
            "score": "加分",
            "totalScore": "5",
            "time": "2019-10-1",
        }]
        ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
        ,cols: [[
            {field:'theClass', title: '班级'}
            ,{field:'reason',  title: '事由'}
            ,{field:'score',  title: '加减'}
            ,{field:'totalScore',  title: '分数'}
            ,{field:'time',  title: '时间'}
        ]]
    });

});