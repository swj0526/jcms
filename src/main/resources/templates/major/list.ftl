<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>班级-专业管理</title>
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="/all.css" media="all">
    <script type="text/javascript" src="/layui/layui.js"></script>
    <script type="text/javascript" src="/major/js/list.js"></script>
    <style>
        .layui-form-label {
            margin-left: 25px;
        }
    </style>
</head>
<body>
<div>
    <#--修改专业-->
    <div style="display: none" id="recruitC">
        <form class="layui-form" action="" id="dataFor">
            <div class="layui-form-item">

                <label class="layui-form-label">专业名称 <span class="star">*</span></label>
                <div class="layui-input-inline">
                    <input type="text" name="nameC" required lay-verify="required" placeholder="" autocomplete="off"
                           class="layui-input">

                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">专业备注<span class="star"></span></label>
                <div class="layui-input-inline">
                    <input type="text" name="remarkC" placeholder="" autocomplete="off"
                           class="layui-input">
                </div>
            </div>

            <div class="layui-form-item" style="margin-left: 30%">
                <div class="layui-input-inline">
                    <button class="layui-btn" lay-submit lay-filter="formDemo" id="addC">立即提交</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>
        </form>

    </div>
    <#--新增专业-->
    <div style="display: none" id="recruit">
        <form class="layui-form" action="" id="dataFor">
            <div class="layui-form-item">

                <label class="layui-form-label">专业名称 <span class="star">*</span></label>
                <div class="layui-input-inline">
                    <input type="text" name="nameA" required lay-verify="required" placeholder="" autocomplete="off"
                           class="layui-input">

                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">专业备注<span class="star"></span></label>
                <div class="layui-input-inline">
                    <input type="text" name="remarkA" placeholder="" autocomplete="off"
                           class="layui-input">
                </div>
            </div>

            <div class="layui-form-item" style="margin-left: 30%">
                <div class="layui-input-inline">
                    <button class="layui-btn" lay-submit lay-filter="formDemo" id="add1">立即提交</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>
        </form>

    </div>
    <!--添加班级-->
    <div style="display: none" id="recruitB">
        <form class="layui-form" action="" id="dataFor">
            <div class="layui-form-item">

                <label class="layui-form-label">班级名称 <span class="star">*</span></label>
                <div class="layui-input-inline">
                    <input type="text" name="nameB" required lay-verify="required" placeholder="" autocomplete="off"
                           class="layui-input">

                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">班级备注<span class="star"></span></label>
                <div class="layui-input-inline">
                    <input type="text" name="remarkB" placeholder="" autocomplete="off"
                           class="layui-input">
                </div>
            </div>

            <div class="layui-form-item" style="margin-left: 30%">
                <div class="layui-input-inline">
                    <button class="layui-btn" lay-submit lay-filter="formDemo" id="addB">立即提交</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>
        </form>

    </div>
    <!--修改班级信息-->
    <div style="display: none" id="recruitD">
        <form class="layui-form" action="" id="dataFor">
            <div class="layui-form-item">

                <label class="layui-form-label">班级名称 <span class="star">*</span></label>
                <div class="layui-input-inline">
                    <input type="text" name="nameD" required lay-verify="required" placeholder="" autocomplete="off"
                           class="layui-input">

                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">班级备注<span class="star"></span></label>
                <div class="layui-input-inline">
                    <input type="text" name="remarkD" placeholder="" autocomplete="off"
                           class="layui-input">
                </div>
            </div>

            <div class="layui-form-item" style="margin-left: 30%">
                <div class="layui-input-inline">
                    <button class="layui-btn" lay-submit lay-filter="formDemo" id="addD">立即提交</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>
        </form>

    </div>
    <fieldset class="layui-elem-field layuimini-search">
        <div style="margin: 10px 10px 10px 10px">
            <form class="layui-form layui-form-pane" action="">
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">关键词</label>
                        <div class="layui-input-inline">
                            <input type="text" name="keywords" autocomplete="off" class="layui-input"
                                   placeholder="例：专业/备注">
                        </div>
                    </div>

                    <button class="layui-btn layui-btn-normal" type="button" id="search">查询</button>
                    <button class="layui-btn data-add-btn" type="button" id="add">添加专业信息</button>

                </div>
            </form>
        </div>
    </fieldset>

    <table class="layui-table">
        <tr style="background-color: #F2F2F2;">
            <th>班级-专业</th>
            <th>备注</th>
            <th>操作</th>
        </tr>
        <#list list as major>
            <#if major.pid != 0>
                <tr>
                    <td>&nbsp;&nbsp;&nbsp;&nbsp;∟${major.name}</td>
                    <td>${major.remark!""}</td>
                    <td><a class="layui-btn layui-btn-xs btnD" id="${major.id}">编辑</a><a
                                class="layui-btn layui-btn-danger layui-btn-xs del" id="${major.id}">删除</a></td>
                </tr>
            <#else >
                <tr>
                    <td>${major.name}</td>
                    <td>${major.remark!""}</td>
                    <td><a class="layui-btn layui-btn-xs btnC" id="${major.id}">编辑</a> <a
                                class="layui-btn layui-btn-normal layui-btn-xs btnB" id="${major.id}">添加班级</a><a
                                class="layui-btn layui-btn-danger layui-btn-xs del" id="${major.id}">删除</a></td>
                </tr>
            </#if>

        </#list>
    </table>
</div>
</body>
</html>