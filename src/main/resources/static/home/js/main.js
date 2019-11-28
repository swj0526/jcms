layui.use(['element', 'jquery', 'layer'], function () {
    var $ = layui.jquery, element = layui.element, layer = layui.layer;

   var tab = function(){
       $(".add").click(function () {
           //获取被点击的元素id,来取得准确的元素
           var id = $(this).attr('id');
           var title = $(this).text();
           if (id == "remind_pay") { //提醒-缴费提醒
               var src = "/remind/topay";
               all_tab(id, "缴费提醒", src);
           } else if (id == "remind_article") { //提醒-文章提醒
               var src = "/remind/toarticle";
               all_tab(id, "公告提醒", src);
           } else if (id == "account_list") { //账号-账号列表
               var src = "/account/tolist";
               all_tab(id, title, src);
           } else if (id == "account_role") { //账号-权限管理
               var src = "/account/torole";
               all_tab(id, title, src);
           } else if (id == "account_modPassword") {
               var src = "/account/tomodpassword";
               all_tab(id, title, src);
           } else if (id == "recruit_recruit") {
               var src = "/recruit/torecruit";
               all_tab(id, title, src);
           } else if (id == "recruit_follow") {
               var src = "/follow/to";
               all_tab(id, title, src);
           } else if (id == "student_list") {
               var src = "/student/tolist";
               all_tab(id, title, src);
           } else if (id == "flow_leave") {
               var src = "/flow/leave";
               all_tab(id, title, src);
           } else if (id == "flow_funds") {
               var src = "/flow/funds";
               all_tab(id, title, src);
           } else if (id == "flow_fundsApprover") {
               var src = "/flow/fundsApprover";
               all_tab(id, title, src);
           } else if (id == "flow_leaveApprover") {
               var src = "/flow/leaveApprover";
               all_tab(id, title, src);
           } else if (id == "article_dispatch") {
               var src = "/article/dispatch";
               all_tab(id, title, src);
           } else if (id == "article_list") {
               var src = "/article/list";
               all_tab(id, title, src);
           } else if (id == "work_upload") {
               var src = "/work/upload";
               all_tab(id, title, src);
           } else if (id == "work_list") {
               var src = "/work/list";
               all_tab(id, title, src);
           } else if (id == "money_list") {
               var src = "/money/tolist";
               all_tab(id, title, src);
           } else if (id == "remind_annunciate") {
               var src = "/remind/toAnnunciate";
               all_tab(id, title, src);
           } else if (id == "recruit_data") {
               var src = "/recruit/data";
               all_tab(id, title, src);
           } else if (id == "integral_list") {
               var src = "/integral/list";
               all_tab(id, title, src);
           } else if (id == "integral_add") {
               var src = "/integral/add";
               all_tab(id, title, src);
           } else if (id == "major_list") {
               var src = "/major/tolist";
               all_tab(id, title, src);
           } else if (id == "teacher_list") {
               var src = "/teacher/tolist";
               all_tab(id, title, src);
           } else if (id == "recruit_try") {
               var src = "/internship/to";
               all_tab(id, title, src);
           }else if (id == "account_privilege") {
               var src = "account_toprivilege";
               all_tab(id, title, src);
           }
       });
   }
    tab();
    $('.site-demo-active').on('click', function () {
        var othis = $(this),
            type = othis.data('type');
        //active[type] ? active[type].call(this, othis) : '';
    });

    $('#remind').click(function () {
        //配置一个透明的询问框
        layer.msg('缴费提醒3条<br/>文章提醒6条', {
            time: false, //20s后自动关闭
            btn: ['忽略', '公告提醒', '缴费提醒']
        });
    });
    $('.layui-layer-btn1').click(function () {
        var id = $(this).attr('id');

    });
});

