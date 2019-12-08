layui.use(['element','jquery','table'], function(){
    var table = layui.table;
    var element = layui.element;
    var $ = layui.jquery;
    let studentId = $("#baseId").val();
    /**
     * 缴费基本信息
     */
    table.render({
        elem: '#test',
        url:"/money/list?studentId="+studentId
            , parseData: function (res) { //res 即为原始返回的数据
                /*   console.log(res);*/
                return {
                    "code": "0",
                    "count": res.pager.dataTotal,
                    data: res.result
                }
            }
        ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
        ,cols: [[
            {field:'typeName', title: '缴费类型'}
            ,{field:'paymentMethodName',  title: '缴费方式'}
            ,{field:'payAmount',  title: '金额'}
            ,{field:'payDate', title: '缴费日期', } //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
            ,{field:'instalment', title: '是否分期'}
            ,{field:'discountAmount', title: '优惠金额'}
            ,{field:'classify', title: '费用有效期'}

        ]]
    });
    /**
     * 积分基本信息
     */
    table.render({
        elem: '#information',
        data: [{
            "theClass": "影视一班",
            "reason": "打架斗殴",
            "score": "加分",
            "totalScore": "5",
            "time": "2019-10-1",
        }]
            , parseData: function (res) { //res 即为原始返回的数据
                /*   console.log(res);*/
                return {
                    "code": "0",
                    "count": res.pager.dataTotal,
                    data: res.result
                }
            }
        ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
        ,cols: [[
            {field:'theClass', title: '班级'}
            ,{field:'reason',  title: '事由'}
            ,{field:'score',  title: '加减'}
            ,{field:'score',  title: '分数'}
            ,{field:'recordTime',  title: '时间'}
        ]]
    });
    /**
     * 请假基本信息
     */
    table.render({
        elem: '#leaveInformation',
        data: [{
            "createTime": "",
            "leaveTime": "",
            "content": "",
            "state": "",

        }]
            , parseData: function (res) { //res 即为原始返回的数据
                /*   console.log(res);*/
                return {
                    "code": "0",
                    "count": res.pager.dataTotal,
                    data: res.result
                }
            }
        ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
        ,cols: [[
            {field:'createTime', title: '申请日期'}
            ,{field:'leaveTime',  title: '请假日期'}
            ,{field:'content',  title: '请假事由'}
            ,{field:'state',  title: '状态'}

        ]]
    });
    /**
     * 作业信息
     */
    table.render({
        elem: '#workInformation',
        data: [{
            "time": "2019-10-1-21.15",
            "workContent": "画画",
        }]
            , parseData: function (res) { //res 即为原始返回的数据
                /*   console.log(res);*/
                return {
                    "code": "0",
                    "count": res.pager.dataTotal,
                    data: res.result
                }
            }
        ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
        ,cols: [[
            {field:'time', title: '上传时间'}
            ,{field:'workContent',  title: '内容'}
        ]]
    });

});