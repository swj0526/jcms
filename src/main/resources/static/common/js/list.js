layui.use(['form', 'laydate', 'layer', 'table'], function () {
    var form = layui.form
        , layer = layui.layer
        , laydate = layui.laydate
        , table = layui.table;
    var currPage = 1;//定义一个当前页面的全局变量,表格刷新的时候使用
    var res; //当前页所有的数据
    var data; //定义一个全局的data变量,可以获取当前点击的数据
    //日期,如果需要时分秒的话,加上(type: 'datetime')
    laydate.render({
        elem: '#date1'
    });
    //日期时间范围
    laydate.render({
        elem: '#scopeDate'
        , type: 'datetime'
        , range: true
    });
    //表格

    var tableIns = table.render({
        elem: '#infoTable'
        , data: [{
            "id": "10001"
            , "username": "杜甫"
            , "email": "xianxin@layui.com"
            , "sex": "男"
            , "city": "浙江杭州"
            , "sign": "人生恰似一场修行"
            , "experience": "116"
            , "ip": "192.168.0.8"
            , "logins": "108"
            , "joinTime": "2016-10-14"
        }, {
            "id": "10002"
            , "username": "李白"
            , "email": "xianxin@layui.com"
            , "sex": "男"
            , "city": "浙江杭州"
            , "sign": "人生恰似一场修行"
            , "experience": "12"
            , "ip": "192.168.0.8"
            , "logins": "106"
            , "joinTime": "2016-10-14"
            , "LAY_CHECKED": true
        }, {
            "id": "10003"
            , "username": "王勃"
            , "email": "xianxin@layui.com"
            , "sex": "男"
            , "city": "浙江杭州"
            , "sign": "人生恰似一场修行"
            , "experience": "65"
            , "ip": "192.168.0.8"
            , "logins": "106"
            , "joinTime": "2016-10-14"
        }, {
            "id": "10004"
            , "username": "贤心"
            , "email": "xianxin@layui.com"
            , "sex": "男"
            , "city": "浙江杭州"
            , "sign": "人生恰似一场修行"
            , "experience": "666"
            , "ip": "192.168.0.8"
            , "logins": "106"
            , "joinTime": "2016-10-14"
        }, {
            "id": "10005"
            , "username": "贤心"
            , "email": "xianxin@layui.com"
            , "sex": "男"
            , "city": "浙江杭州"
            , "sign": "人生恰似一场修行"
            , "experience": "86"
            , "ip": "192.168.0.8"
            , "logins": "106"
            , "joinTime": "2016-10-14"
        }, {
            "id": "10006"
            , "username": "贤心"
            , "email": "xianxin@layui.com"
            , "sex": "男"
            , "city": "浙江杭州"
            , "sign": "人生恰似一场修行"
            , "experience": "12"
            , "ip": "192.168.0.8"
            , "logins": "106"
            , "joinTime": "2016-10-14"
        }, {
            "id": "10007"
            , "username": "贤心"
            , "email": "xianxin@layui.com"
            , "sex": "男"
            , "city": "浙江杭州"
            , "sign": "人生恰似一场修行"
            , "experience": "16"
            , "ip": "192.168.0.8"
            , "logins": "106"
            , "joinTime": "2016-10-14"
        }, {
            "id": "10008"
            , "username": "贤心"
            , "email": "xianxin@layui.com"
            , "sex": "男"
            , "city": "浙江杭州"
            , "sign": "人生恰似一场修行"
            , "experience": "106"
            , "ip": "192.168.0.8"
            , "logins": "106"
            , "joinTime": "2016-10-14"
        }, {
            "id": "10008"
            , "username": "贤心"
            , "email": "xianxin@layui.com"
            , "sex": "男"
            , "city": "浙江杭州"
            , "sign": "人生恰似一场修行"
            , "experience": "106"
            , "ip": "192.168.0.8"
            , "logins": "106"
            , "joinTime": "2016-10-14"
        }, {
            "id": "10008"
            , "username": "贤心"
            , "email": "xianxin@layui.com"
            , "sex": "男"
            , "city": "浙江杭州"
            , "sign": "人生恰似一场修行"
            , "experience": "106"
            , "ip": "192.168.0.8"
            , "logins": "106"
            , "joinTime": "2016-10-14"
        }, {
            "id": "10008"
            , "username": "贤心"
            , "email": "xianxin@layui.com"
            , "sex": "男"
            , "city": "浙江杭州"
            , "sign": "人生恰似一场修行"
            , "experience": "106"
            , "ip": "192.168.0.8"
            , "logins": "106"
            , "joinTime": "2016-10-14"
        }, {
            "id": "10008"
            , "username": "贤心"
            , "email": "xianxin@layui.com"
            , "sex": "男"
            , "city": "浙江杭州"
            , "sign": "人生恰似一场修行"
            , "experience": "106"
            , "ip": "192.168.0.8"
            , "logins": "106"
            , "joinTime": "2016-10-14"
        }, {
            "id": "10008"
            , "username": "贤心"
            , "email": "xianxin@layui.com"
            , "sex": "男"
            , "city": "浙江杭州"
            , "sign": "人生恰似一场修行"
            , "experience": "106"
            , "ip": "192.168.0.8"
            , "logins": "106"
            , "joinTime": "2016-10-14"
        }, {
            "id": "10008"
            , "username": "贤心"
            , "email": "xianxin@layui.com"
            , "sex": "男"
            , "city": "浙江杭州"
            , "sign": "人生恰似一场修行"
            , "experience": "106"
            , "ip": "192.168.0.8"
            , "logins": "106"
            , "joinTime": "2016-10-14"
        }, {
            "id": "10008"
            , "username": "贤心"
            , "email": "xianxin@layui.com"
            , "sex": "男"
            , "city": "浙江杭州"
            , "sign": "人生恰似一场修行"
            , "experience": "106"
            , "ip": "192.168.0.8"
            , "logins": "106"
            , "joinTime": "2016-10-14"
        }, {
            "id": "10008"
            , "username": "贤心"
            , "email": "xianxin@layui.com"
            , "sex": "男"
            , "city": "浙江杭州"
            , "sign": "人生恰似一场修行"
            , "experience": "106"
            , "ip": "192.168.0.8"
            , "logins": "106"
            , "joinTime": "2016-10-14"
        }, {
            "id": "10008"
            , "username": "贤心"
            , "email": "xianxin@layui.com"
            , "sex": "男"
            , "city": "浙江杭州"
            , "sign": "人生恰似一场修行"
            , "experience": "106"
            , "ip": "192.168.0.8"
            , "logins": "106"
            , "joinTime": "2016-10-14"
        }, {
            "id": "10008"
            , "username": "贤心"
            , "email": "xianxin@layui.com"
            , "sex": "男"
            , "city": "浙江杭州"
            , "sign": "人生恰似一场修行"
            , "experience": "106"
            , "ip": "192.168.0.8"
            , "logins": "106"
            , "joinTime": "2016-10-14"
        }, {
            "id": "10008"
            , "username": "贤心"
            , "email": "xianxin@layui.com"
            , "sex": "男"
            , "city": "浙江杭州"
            , "sign": "人生恰似一场修行"
            , "experience": "106"
            , "ip": "192.168.0.8"
            , "logins": "106"
            , "joinTime": "2016-10-14"
        }]
        , toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
        , defaultToolbar: [{
            title: '刷新表格'
            , layEvent: 'refreshBtn'
            , icon: 'layui-icon-refresh'
        }, {
            title: '添加'
            , layEvent: 'addBtn'
            , icon: 'layui-icon-add-circle'
        }, { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
            title: '导入'
            , layEvent: 'enterBtn'
            , icon: 'layui-icon-form'
        }, { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
            title: '导出'
            , layEvent: 'outBtn'
            , icon: 'layui-icon-file'
        }]
        , title: '用户数据表'
        , cols: [[
            {field: 'username', title: '用户名', width: 120, edit: 'text'}
            , {
                field: 'email', title: '邮箱', width: 150, edit: 'text', templet: function (res) {
                    return '<em>' + res.email + '</em>'
                }
            }
            , {field: 'sex', title: '性别', width: 80, edit: 'text', sort: true}
            , {field: 'city', title: '城市', width: 100}
            , {field: 'sign', title: '签名'}
            , {field: 'experience', title: '积分', width: 80, sort: true}
            , {field: 'ip', title: 'IP', width: 120}
            , {field: 'logins', title: '登入次数', width: 100, sort: true}
            , {field: 'joinTime', title: '加入时间', width: 120}
            , {fixed: 'right', title: '操作', toolbar: '#barDemo', width: 150}
        ]]
        , page: true,
        done: function (rest, curr, count) { //当前页表格的数据设置在这里
            currPage = curr;  //给当前页赋值
            res = rest;
            console.log(currPage);
            console.log(rest);

        }, parseData: function (res) { //res 即为原始返回的数据
            return {
                "code": "0",
                "count": res.pager.dataTotal,
                data: res.result
            }
        },
        id: 'followRender'
    });
    // 监听搜索操作
    form.on('submit(data-search-btn)', function (data) {
        //执行搜索重载
        table.reload('followRender', {
            page: {
                curr: currPage  //刷新当前页
            },
            where: {
                /*  keywords: keywords*/ //搜索条件

            }
        }, 'data');


    });
    //头工具栏事件
    table.on('toolbar(infoTable)', function (obj) {
        var checkStatus = table.checkStatus(obj.config.id);
        switch (obj.event) {
            case 'addBtn':
                window.location.href = "/common/toadd";
                break;
            case 'refreshBtn':
                tableIns.reload();
                break;
            case 'enterBtn':
                layer.alert("导入excel表格");
                break;

            //自定义头工具栏右侧图标 - 提示
            case 'outBtn':
                layer.alert('导出excel表格');
                break;
        }
        ;
    });

    //监听行工具事件
    table.on('tool(infoTable)', function (obj) {
        var data = obj.data;
        //console.log(obj)
        if (obj.event === 'del') {
            layer.confirm('真的删除行么', function (index) {
                obj.del();
                layer.close(index);
            });
        } else if (obj.event === 'edit') {
            layer.prompt({
                formType: 2
                , value: data.email
            }, function (value, index) {
                obj.update({
                    email: value
                });
                layer.close(index);
            });
        }
    });


});