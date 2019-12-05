<!DOCTYPE html>
<html lang="en">
<head>
    <base href="${basePath}">
    <meta charset="UTF-8">
    <#include "../common/common.ftl"/>
    <title>添加学生信息</title>
    <link rel="stylesheet" href="/static/common/css/all.css" media="all">

    <style type="text/css">
        /*去除input number的 自动增加数按钮*/
        input::-webkit-outer-spin-button,
        input::-webkit-inner-spin-button {
            -webkit-appearance: none;
        }

        input[type="number"] {
            -moz-appearance: textfield;
        }

    </style>
</head>
<body>
<div id="recruit" style="margin-left: 25%">
<div >
    <form class="layui-form layui-form-pane" lay-filter="addDataForm" id="dataFor" method="post">
        <div class="layui-form-item">
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label"> 姓名<span class="star">*</span></label>
                    <div class="layui-input-inline">
                        <input type="text" name="name" lay-verify="required" placeholder="" autocomplete="off"
                               class="layui-input" value="${student.name!''}">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label"> 年龄<span  class="star">*</span></label>
                    <div class="layui-input-inline">
                        <input type="number" name="age" lay-verify="required" placeholder="" autocomplete="off"
                               class="layui-input" value="${student.age!''}">

                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label"> 民族<span  class="star">*</span></label>
                    <div class="layui-input-inline">
                        <input type="text" name="nation" lay-verify="required" placeholder="" autocomplete="off"
                               class="layui-input" value="${student.nation!''}">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label"> 在校状态<span  class="star">*</span></label>
                    <div class="layui-input-inline">
                        <input type="text" style="display: none" id="Instalment" value=${student.state}>
                        <select name="state" lay-verify="" id="select1">
                            <option value="1">在校</option>
                            <option value="3">毕业</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label"> 籍贯<span  class="star">*</span></label>
                    <div class="layui-input-inline">
                        <input type="text" name="nativePlace" lay-verify="required" placeholder="" autocomplete="off"
                               class="layui-input" value="${student.nativePlace!''}">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label"> 家庭住址<span  class="star">*</span></label>
                    <div class="layui-input-inline">
                        <input type="text" name="address" lay-verify="required" placeholder="" autocomplete="off"
                               class="layui-input" value="${student.address!''}">
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label"> 身份证号<span  class="star">*</span></label>
                    <div class="layui-input-inline">
                        <input type="number" name="IDCard" lay-verify="required" placeholder="" autocomplete="off"
                               class="layui-input" value="${student.IDCard!''}">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label"> 爱好</label>
                    <div class="layui-input-inline">
                        <input type="text" name="hobby"  placeholder="" autocomplete="off"
                               class="layui-input"value= "${student.hobby!''}">
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label"> 特长</label>
                    <div class="layui-input-inline">
                        <input type="text" name="speciality"  placeholder="" autocomplete="off"
                               class="layui-input" value="${student.speciality!''}">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label"> 老师评价</label>
                    <div class="layui-input-inline">
                        <input type="text" name="comment"  placeholder="" autocomplete="off"
                               class="layui-input" value="${student.comment!''}">
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label"> 入学时间<span  class="star">*</span></label>
                    <div class="layui-input-inline">
                        <input type="text" name="admissionData" lay-verify="required" placeholder="" autocomplete="off"
                               class="layui-input" id="date1"value="${(admissionData?string)!''}">

                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label"> 毕业时间</label>
                    <div class="layui-input-inline">
                        <input type="text" name="graduationDate"  placeholder="" autocomplete="off"
                               class="layui-input" id="date" value="">
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label"> 学号<span class="star">*</span></label>
                <div class="layui-input-inline">
                    <input type="number" name="studentNumber" lay-verify="required" placeholder="" autocomplete="off"
                           class="layui-input" value="${student.studentNumber!''}">
                </div>
            </div>    </div>

            <div class="layui-form-item" >
                <div class="layui-input-inline" style="margin-left: 18%">
                    <button class="layui-btn"   lay-submit=""  type="button" id="addSubmit"value="${student.id}">立即提交</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>

        </div>

    </form>
</div>

</div>
<script src="/student/js/list.js"></script>
<script src="/student/js/addstudent.js"></script>

</body>
</html>