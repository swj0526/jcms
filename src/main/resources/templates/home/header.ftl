<div class="layui-header">
    <div class="layui-logo">锦程职校学生管理系统</div>
    <ul class="layui-nav layui-layout-left">
        <li class="layui-nav-item"><a href=""></a></li>
        <li class="layui-nav-item"><a href="">商品管理</a></li>
        <li class="layui-nav-item"><a href="">用户</a></li>
        <li class="layui-nav-item">
            <a href="javascript:;">其它系统</a>
            <dl class="layui-nav-child">
                <dd><a href="">邮件管理</a></dd>
                <dd><a href="">消息管理</a></dd>
                <dd><a href="">授权管理</a></dd>
            </dl>
        </li>
    </ul>
    <ul class="layui-nav layui-layout-right">
        <li class="layui-nav-item" id="remind"><a>最新提醒<span class="layui-badge">9</span></a></li>
        <li class="layui-nav-item">
            <a >
               <#-- <#if Session["name"]?exists>
                &lt;#&ndash; //存在就显示其属性值&ndash;&gt;
                &lt;#&ndash;   //Session["admin"]为取出该session对象&ndash;&gt;
                    ${Session["name"]}
                </#if>admin,欢迎登录!-->
                admin
            </a>
            <dl class="layui-nav-child" >
                <dd><a href="">基本资料</a></dd>
                <dd><a href="">安全设置</a></dd>
            </dl>
        </li>
        <li class="layui-nav-item"><a href="/logout">注销</a></li>
    </ul>
</div>