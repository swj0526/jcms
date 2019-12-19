<!DOCTYPE html>
<html>
<head>
    <base href="${basePath}">
    <meta charset="utf-8">
    <#include "../common/common.ftl"/>
    <title></title>

    <style type="text/css">
        #u {
            width: 100%;

        }

        #u li {
            border: white solid 0.5px;
            height: 50px;
            display: block;
            vertical-align: middle
        }

        .sd {
            display: table-cell;
            vertical-align: middle;
            height: 50px;

        }
    </style>
</head>
<body>
<div class="layui-row layui-col-space10" style="margin: 0">
    <div class="layui-col-md12">
        <div>
            <div class="layui-btn-group" style="position: relative;left: 90% ">
                <button class="layui-btn data-add-btn" type="button" id="addfollowbtn">添加跟进信息</button>
            </div>
            <div style="padding: 20px; background-color: #F2F2F2;">
                <div class="layui-row layui-col-space15">
                    <div class="layui-col-md6">
                        <div class="layui-card">
                            <div class="layui-card-header"><span>父亲姓名:${student.fatherName!"无数据"}</span></div>
                            <div class="layui-card-header"><span>父亲电话:${student.fatherPhone!"无数据"}</div>
                            <div class="layui-card-header">母亲姓名:${student.motherName!"无数据"}</div>
                            <div class="layui-card-header">母亲电话:${student.motherPhone!"无数据"}</div>
                            <div class="layui-card-body">
                            </div>
                        </div>
                    </div>
                    <div class="layui-col-md6">
                        <div class="layui-card">
                            <div class="layui-card-header">出生年月:${(student.birthDate?string("yyyy-MM-dd"))!'无数据'}</div>
                            <div class="layui-card-header">QQ:${student.qq!'无数据'}</div>
                            <div class="layui-card-header">微信:${student.weChat!'无数据'}</div>
                            <div class="layui-card-body">

                            </div>
                        </div>
                    </div>
                    <div class="layui-col-md12">
                        <div class="layui-card">
                            <form>
                                <div class="layui-card-header">跟进</div>
                                <div class="layui-card-body">
                                    <ul id="u">
                                        <#list detail as st>
                                            <li>
                                                <div class="sd">
                                                    <span>跟进时间:${(st.followTime?string("yyyy-MM-dd"))!'无数据'}</span></div>
                                            </li>
                                            <li>
                                                <div class="sd"><span>意向:${st.listLabelName()!''}</span></div>
                                            </li>

                                            <li>
                                                <div class="sd"><span>备注:${st.remark!''}</span></div>
                                            </li>
                                            <li>
                                                <div>
                                                    <button class="layui-btn data-add-btn update" type="button"
                                                            value=${st.id}>修改</button>
                                                    <button class="layui-btn data-add-btn delete" type="button"
                                                            value=${st.id}>删除</button>
                                                    <hr>
                                                </div>
                                            </li>
                                        </#list>



                                    </ul>
                                </div>

                            </form>
                        </div>
                    </div>
                </div>
            </div>

            <div>

            </div>

        </div>
    </div>
<#--添加-->
    <div style="display: none" id="openfollowtable">
        <form class="layui-form" action="" id="formdata"lay-filter="dataForm">
            <div class="layui-form-item">
                <label class="layui-form-label">跟进时间</label>
                <div class="layui-input-inline">
                    <input type="text" name="followTime" required lay-verify="required" placeholder="请输入"
                           autocomplete="off" class="layui-input" id="date">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">意向</label>
                <div class="layui-inline" style="width: 190px">
                    <div id="addDetail" class="xm-select-demo" style=" width:350px";></div>
                </div>
            </div>
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">备注:</label>
                <div class="layui-input-block"style="width:350px";>
                    <textarea name="remark" placeholder="请输入内容"required lay-verify="required" class="layui-textarea"></textarea>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" type="button" lay-submit lay-filter="formDemo" id="submitbut"
                            value=${id}>立即提交
                    </button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>
        </form>
    </div>
    <script src="/recruit/js/label.js"></script>
    <script src="/recruit/js/xm.js" type="text/javascript"></script>
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
    <script src="/recruit/js/detailfollow.js"></script>
    <script>
        var addDetail = xmSelect.render({
            el: '#addDetail',
            language: 'zn',
            filterable: true,
            searchTips: '搜索标签',
            tips: '选择意向',
            height: '500px',
            autoRow: true,
            code:0,
            prop: {
                name: 'name',
                value: 'id',
            },

        })
        axios({
            method: 'get',
            url: '/dictionary/list/label',
        }).then(response => {
            var res = response.data;
            addDetail.update({
                data: res,
            })
        });

    </script>
</div>
</body>
</html>
