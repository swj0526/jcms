<!DOCTYPE html>
<html lang="en">
<head>
    <#include "../common/common.ftl"/>
    <style>
        .layui-form-label {
            margin-left: 25px;
        }
    </style>
</head>
<body>
<div>
    <#--修改专业-->
    <div style="display: none" id="modifyMajorPopups">
        <form class="layui-form" action="" id="dataFor">
            <div class="layui-form-item">

                <label class="layui-form-label">专业名称 <span class="star">*</span></label>
                <div class="layui-input-inline">
                    <input type="text" name="nameMajorM" required lay-verify="required" placeholder="" autocomplete="off"
                           class="layui-input">

                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">专业备注<span class="star"></span></label>
                <div class="layui-input-inline">
                    <input type="text" name="remarkMajorM" placeholder="" autocomplete="off"
                           class="layui-input">
                </div>
            </div>

            <div class="layui-form-item" style="margin-left: 30%">
                <div class="layui-input-inline">
                    <button class="layui-btn" lay-submit lay-filter="formDemo" id="modifyMajorBtn">立即提交</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>
        </form>

    </div>
    <#--新增专业-->
    <div style="display: none" id="addMajorPopups">
        <form class="layui-form" action="" id="dataFor">
            <div class="layui-form-item">

                <label class="layui-form-label">专业名称 <span class="star">*</span></label>
                <div class="layui-input-inline">
                    <input type="text" name="majorName" required lay-verify="required" placeholder="" autocomplete="off"
                           class="layui-input">

                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">专业备注<span class="star"></span></label>
                <div class="layui-input-inline">
                    <input type="text" name="majorRemark" placeholder="" autocomplete="off"
                           class="layui-input">
                </div>
            </div>

            <div class="layui-form-item" style="margin-left: 30%">
                <div class="layui-input-inline">
                    <button class="layui-btn" lay-submit lay-filter="formDemo" id="addMajorBtn">立即提交</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>
        </form>

    </div>
    <!--添加班级-->
    <div style="display: none" id="addGradePopups">
        <form class="layui-form" action="" id="dataFor">
            <div class="layui-form-item">

                <label class="layui-form-label">班级名称 <span class="star">*</span></label>
                <div class="layui-input-inline">
                    <input type="text" name="nameGrade" required lay-verify="required" placeholder="" autocomplete="off"
                           class="layui-input">

                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">班级备注<span class="star"></span></label>
                <div class="layui-input-inline">
                    <input type="text" name="remarkGrade" placeholder="" autocomplete="off"
                           class="layui-input">
                </div>
            </div>

            <div class="layui-form-item" style="margin-left: 30%">
                <div class="layui-input-inline">
                    <button class="layui-btn" lay-submit lay-filter="formDemo" id="addGradeBtn">立即提交</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>
        </form>

    </div>
    <!--修改班级信息-->
    <div style="display: none" id="modifyGradePopups">
        <form class="layui-form" action="" id="dataFor">
            <div class="layui-form-item">

                <label class="layui-form-label">班级名称 <span class="star">*</span></label>
                <div class="layui-input-inline">
                    <input type="text" name="nameGradeM" required lay-verify="required" placeholder="" autocomplete="off"
                           class="layui-input">

                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">班级备注<span class="star"></span></label>
                <div class="layui-input-inline">
                    <input type="text" name="remarkGradeM" placeholder="" autocomplete="off"
                           class="layui-input">
                </div>
            </div>

            <div class="layui-form-item" style="margin-left: 30%">
                <div class="layui-input-inline">
                    <button class="layui-btn" lay-submit lay-filter="formDemo" id="modifyGradeBtn">立即提交</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>
        </form>
    </div>


    <fieldset class="layui-elem-field" style="padding: 5px;">

        <form class="layui-form layui-form-pane" action="/major/tolist" method="post">
            <div class="layui-form-item">

                <label class="layui-form-label">关键词</label>
                <div class="layui-input-inline">
                    <input type="text" name="keywords" autocomplete="off" class="layui-input"
                           placeholder="专业/备注" value="${keywords!""}">
                </div>


                <button class="layui-btn" type="submit" id="search">查询</button>
                <#--  <button class="layui-btn data-add-btn" type="button" id="add">添加专业信息</button>-->

            </div>
        </form>

    </fieldset>
    <div style="height:50px;background-color: #F2F2F2;border: 1px solid #E6E6E6;line-height: 50px;padding-left: 20px; ">
        <div style="display: inline-block;border: 1px solid #cccccc;height: 25px;width: 25px;margin: 5px;line-height: 25px;" id="refreshBtn" >
           <a>
               <i class="layui-icon layui-icon-refresh" style="display: inline-block;height: 25px;width: 25px;line-height: 25px;text-align: center"></i>
           </a>
        </div>
        <div style="display: inline-block;border: 1px solid #cccccc;height: 25px;width: 25px;margin:5px;line-height: 25px;"  id="addBtn">
            <a>
                <i class="layui-icon layui-icon-add-circle" style="display: inline-block;height: 25px;width: 25px;line-height: 25px;text-align: center"></i>
            </a>
        </div>
    </div>
    <table class="layui-table"  style="margin-top: 0px;">
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
                    <td><a class="layui-btn layui-btn-xs exitGrade" id="${major.id}">编辑</a><a
                                class="layui-btn layui-btn-danger layui-btn-xs del" id="${major.id}">删除</a></td>
                </tr>
            <#else >
                <tr>
                    <td>${major.name}</td>
                    <td>${major.remark!""}</td>
                    <td><a class="layui-btn layui-btn-xs exitMajor" id="${major.id}">编辑</a> <a
                                class="layui-btn layui-btn-normal layui-btn-xs addGrade" id="${major.id}">添加班级</a><a
                                class="layui-btn layui-btn-danger layui-btn-xs del" id="${major.id}">删除</a></td>
                </tr>
            </#if>
        </#list>
        <#if list?? && (list?size == 0)>
            <tr>
                <td  colspan="3" style="text-align: center">暂无数据</td>
            </tr>
        </#if>
    </table>
</div>
</body>
<script type="text/javascript" src="/major/js/list.js"></script>
</html>