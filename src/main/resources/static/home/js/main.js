layui.use(['element', 'jquery','layer'], function () {
    var $ = layui.jquery, element = layui.element, layer = layui.layer;
    //Tab的切换功能，切换事件监听等，需要依赖element模块
    //默认生成首页的页面
    element.tabAdd('demo', {
        title: "首页", //新增学生信息
        content: '<iframe src="/home/context" frameborder="0" height="550px" width="100%"></iframe>',
        id: 'first-tab' //实际使用一般是规定好的id，这里以时间戳模拟下
    });
    //点击左边的按钮,然后判断是否新增tab还是需要定位一个tab
    $(".add").click(function () {
        //获取被点击的元素id,来取得准确的元素
        var id = $(this).attr('id');
        //判断是否需要新增还是定位
        if ($("[lay-id=" + id + "]").length > 0) { //存在
            //存在的话,要给这个元素动态的追加属性data-type="tabChange"
            // $(this).attr('data-type', 'tabChange');
            //切换到指定Tab项
            element.tabChange('demo', id); //切换到：用户管理
        } else { //新增
            //$(this).attr('data-type', 'tabAdd');
            //根据id判断嵌入什么页面
            if (id == "remind_pay") {
                element.tabAdd('demo', {
                    title: $(this).text(), //提醒-缴费提醒
                    content: '<iframe src="/remind/toPay" frameborder="0" height="550px" width="100%"></iframe>',
                    id: id //实际使用一般是规定好的id，这里以时间戳模拟下
                });
                //$(this).attr('data-type', 'tabChange');
                element.tabChange('demo', id);
            } else if (id == "remind_article") {
                element.tabAdd('demo', {
                    title: $(this).text(), //提醒-文章提醒
                    content: '<iframe src="/remind/toArticle" frameborder="0" height="700px" width="100%"></iframe>',
                    id: id //实际使用一般是规定好的id，这里以时间戳模拟下
                });
                //$(this).attr('data-type', 'tabChange');
                //切换到指定Tab项
                element.tabChange('demo', id);
            } else if (id == "account_list") {
                element.tabAdd('demo', {
                    title: $(this).text(), //账号-账号列表
                    content: '<iframe src="/account/toList" frameborder="0" height="700px" width="100%"></iframe>',
                    id: id //实际使用一般是规定好的id，这里以时间戳模拟下
                });
                //$(this).attr('data-type', 'tabChange');
                //切换到指定Tab项
                element.tabChange('demo', id);
            }else if (id == "account_role") {
                element.tabAdd('demo', {
                    title: $(this).text(), //账号-角色管理
                    content: '<iframe src="/account/toRole" frameborder="0" height="700px" width="100%"></iframe>',
                    id: id //实际使用一般是规定好的id，这里以时间戳模拟下
                });
                //$(this).attr('data-type', 'tabChange');
                //切换到指定Tab项
                element.tabChange('demo', id);
            }else if (id == "account_modPassword") {
                element.tabAdd('demo', {
                    title: $(this).text(), //账号-修改密码
                    content: '<iframe src="/account/toModPassword" frameborder="0" height="700px" width="100%"></iframe>',
                    id: id //实际使用一般是规定好的id，这里以时间戳模拟下
                });
                //$(this).attr('data-type', 'tabChange');
                //切换到指定Tab项
                element.tabChange('demo', id);
            }else if (id == "recruit_recruit") {
                element.tabAdd('demo', {
                    title: $(this).text(), //档案管理-招生信息管理
                    content: '<iframe src="/recruit//torecruit" frameborder="0" height="700px" width="100%"></iframe>',
                    id: id //实际使用一般是规定好的id，这里以时间戳模拟下
                });
                //$(this).attr('data-type', 'tabChange');
                //切换到指定Tab项
                element.tabChange('demo', id);
            }else if (id == "recruit_follow") {
                element.tabAdd('demo', {
                    title: $(this).text(), //档案管理-招生跟进管理
                    content: '<iframe src="/recruit//tofollow" frameborder="0" height="700px" width="100%"></iframe>',
                    id: id //实际使用一般是规定好的id，这里以时间戳模拟下
                });
                //$(this).attr('data-type', 'tabChange');
                //切换到指定Tab项
                element.tabChange('demo', id);
            }else if (id == "student_list") {
                element.tabAdd('demo', {
                    title: $(this).text(), //档案管理-招生跟进管理
                    content: '<iframe src="/student/tolist" frameborder="0" height="700px" width="100%"></iframe>',
                    id: id //实际使用一般是规定好的id，这里以时间戳模拟下
                });
                //$(this).attr('data-type', 'tabChange');
                //切换到指定Tab项
                element.tabChange('demo', id);
            }else if (id == "flow_leave") {
                element.tabAdd('demo', {
                    title: $(this).text(), //档案管理-招生跟进管理
                    content: '<iframe src="/flow/leave" frameborder="0" height="700px" width="100%"></iframe>',
                    id: id //实际使用一般是规定好的id，这里以时间戳模拟下
                });
                //$(this).attr('data-type', 'tabChange');
                //切换到指定Tab项
                element.tabChange('demo', id);
            }else if (id == "flow_funds") {
                element.tabAdd('demo', {
                    title: $(this).text(), //档案管理-招生跟进管理
                    content: '<iframe src="/flow/funds" frameborder="0" height="700px" width="100%"></iframe>',
                    id: id //实际使用一般是规定好的id，这里以时间戳模拟下
                });
                //$(this).attr('data-type', 'tabChange');
                //切换到指定Tab项
                element.tabChange('demo', id);
            }else if (id == "flow_fundsApprover") {
                element.tabAdd('demo', {
                    title: $(this).text(), //档案管理-招生跟进管理
                    content: '<iframe src="/flow/fundsApprover" frameborder="0" height="700px" width="100%"></iframe>',
                    id: id //实际使用一般是规定好的id，这里以时间戳模拟下
                });
                //$(this).attr('data-type', 'tabChange');
                //切换到指定Tab项
                element.tabChange('demo', id);
            }else if (id == "flow_leaveApprover") {
                element.tabAdd('demo', {
                    title: $(this).text(), //档案管理-招生跟进管理
                    content: '<iframe src="/flow/leaveApprover" frameborder="0" height="700px" width="100%"></iframe>',
                    id: id //实际使用一般是规定好的id，这里以时间戳模拟下
                });
                //$(this).attr('data-type', 'tabChange');
                //切换到指定Tab项
                element.tabChange('demo', id);
            }else if (id == "article_dispatch") {
                element.tabAdd('demo', {
                    title: $(this).text(), //发文管理-发布文章
                    content: '<iframe src="/article/dispatch" frameborder="0" height="700px" width="100%"></iframe>',
                    id: id //实际使用一般是规定好的id，这里以时间戳模拟下
                });
                //$(this).attr('data-type', 'tabChange');
                //切换到指定Tab项
                element.tabChange('demo', id);
            }else if (id == "article_list") {
                element.tabAdd('demo', {
                    title: $(this).text(), //发文管理-查询文章
                    content: '<iframe src="/article/list" frameborder="0" height="700px" width="100%"></iframe>',
                    id: id //实际使用一般是规定好的id，这里以时间戳模拟下
                });
                //$(this).attr('data-type', 'tabChange');
                //切换到指定Tab项
                element.tabChange('demo', id);
            }else if (id == "work_upload") {
                element.tabAdd('demo', {
                    title: $(this).text(), //发文管理-查询文章
                    content: '<iframe src="/work/upload" frameborder="0" height="700px" width="100%"></iframe>',
                    id: id //实际使用一般是规定好的id，这里以时间戳模拟下
                });
                //$(this).attr('data-type', 'tabChange');
                //切换到指定Tab项
                element.tabChange('demo', id);
            }else if (id == "work_list") {
                element.tabAdd('demo', {
                    title: $(this).text(), //发文管理-查询文章
                    content: '<iframe src="/work/list" frameborder="0" height="700px" width="100%"></iframe>',
                    id: id //实际使用一般是规定好的id，这里以时间戳模拟下
                });
                //$(this).attr('data-type', 'tabChange');
                //切换到指定Tab项
                element.tabChange('demo', id);
            }

        }
    });
    $('.site-demo-active').on('click', function () {
        var othis = $(this),
            type = othis.data('type');
        //active[type] ? active[type].call(this, othis) : '';
    });
    //Hash地址的定位
    var layid = location.hash.replace(/^#test=/, '');
    element.tabChange('test', layid);
    element.on('tab(test)', function (elem) {
        location.hash = 'test=' + $(this).attr('lay-id');
    });
    $('#remind').click(function () {
        //配置一个透明的询问框
        layer.msg('您有9条提醒信息<br/>缴费提醒3条<br/>文章提醒6条', {
            time: false, //20s后自动关闭
            btn: ['忽略','发文提醒', '缴费提醒']
        });
    });
});
$(function () {
    $('.txt-scroll').txtscroll({
        'speed': 50
    });
});