<div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
        <ul class="layui-nav layui-nav-tree layui-inline" lay-filter="demo" style="margin-right: 10px;"  lay-shrink="all">
            <li class="layui-nav-item">
                <a href="javascript:;">账号管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:;"  class="add" id="account_list">账号管理</a></dd>
                    <dd><a href="javascript:;" class="add" id="account_role">角色权限管理</a></dd>
                 <#--   <dd><a href="javascript:;" class="add" id="account_modPassword">修改密码</a></dd>-->

                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;">信息管理</a>
                <dl class="layui-nav-child">
                    <dd><a  class="add" id="student_list">学生档案管理</a></dd>
                    <dd><a  class="add" id="major_list">专业-班级管理</a></dd>
                    <dd><a  class="add" id="teacher_list">教职工档案管理</a></dd>
                    <dd><a class="add" id="recruit_recruit">招生信息管理</a></dd>
                    <dd><a class="add" id="recruit_follow">来源渠道管理</a></dd>
                    <dd><a class="add" id="recruit_data">渠道统计</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;">流程管理</a>
                <dl class="layui-nav-child">
                   <#-- <dd><a href="/flow/approver"  class="add" id="flow_approver">流程列表</a></dd>-->
                    <dd><a  class="add" id="flow_leave">请假流程管理</a></dd>
                    <dd><a  class="add" id="flow_funds">经费申请流程管理</a></dd>

                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;">审批管理</a>
                <dl class="layui-nav-child">
                    <#-- <dd><a href="/flow/approver"  class="add" id="flow_approver">流程列表</a></dd>-->

                    <dd><a class="add" id="flow_leaveApprover">请假审批</a></dd>
                    <dd><a class="add" id="flow_fundsApprover">经费审批</a></dd>

                </dl>
            </li>
            <li class="layui-nav-item">
                <a class="add" id="money_list">缴费管理</a>
                <#--<dl class="layui-nav-child">


                </dl>-->
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;">发文管理</a>
                <dl class="layui-nav-child">
                    <dd><a  class="add" id="article_dispatch">发布公告</a></dd>
                    <dd><a   class="add" id="article_list">公告列表</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item">
                <a >提醒管理</a>
                <dl class="layui-nav-child">
                    <dd><a class="add" id="remind_pay">缴费提醒</a></dd>
                    <dd><a class="add" id="remind_article">公告提醒</a></dd>
                   <#-- <dd><a class="add" >公告提醒</a></dd>-->

                    <#-- <dd><a class="add" id="remind_broadcast">首页循环播报设置</a></dd>-->
                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;">作业管理</a>
                <dl class="layui-nav-child">
                    <dd><a class="add" id="work_upload">上传作业</a></dd>
                    <dd><a   class="add" id="work_list">作业列表</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;">积分管理</a>
                <dl class="layui-nav-child">
                    <dd><a  class="add" id="integral_list">查看积分</a></dd>
                    <dd><a  class="add" id="integral_add">修改积分</a></dd>
                </dl>
            </li>

        </ul>
    </div>
</div>
