<div class="layui-header">
    <div class="layui-logo">锦程职校学生管理系统</div>
    <ul class="layui-nav layui-layout-right">
        <li class="layui-nav-item" style="width: 130px;">
            <a href="javascript:;">消息提醒<span class="layui-badge">9</span></a>
            <dl class="layui-nav-child" >
                <dd><a class="add" id="remind_pay">缴费提醒<span class="layui-badge">6</span></a></dd>
                <dd><a class="add" id="remind_article">公告提醒<span class="layui-badge">3</span></a></dd>
            </dl>
        </li>
        <li class="layui-nav-item">
            <a >
               <#-- <#if Session["name"]?exists>
                &lt;#&ndash; //存在就显示其属性值&ndash;&gt;
                &lt;#&ndash;   //Session["admin"]为取出该session对象&ndash;&gt;
                    ${Session["name"]}
                </#if>admin,欢迎登录!-->
                admin,欢迎登录!
            </a>
            <dl class="layui-nav-child" >
                <dd><a class="add" id="account_modPassword">修改密码</a></dd>
                <dd><a href="/loginout">注销</a></dd>
            </dl>
        </li>

    </ul>
</div>