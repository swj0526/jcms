<!DOCTYPE html>
<html lang="en">
<head>
    <base href="${basePath}">
    <meta charset="UTF-8">
    <title>Title</title>
    <#include "../common/common.ftl"/>
</head>
<body>
<div id="addpage" >
    <fieldset id="add2" style="border: 0">
        <div style="margin: 10px 10px 10px 10px;margin-left:25%">
            <form class="layui-form layui-form-pane" lay-filter="dataForm1" id="dataFor">
                <input style="display: none" type="text" id="id" name="id" value=${bill.id} autocomplete="off"
                       class="layui-input">
                <div class="layui-form-item">
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">用户姓名<span  class="star">*</span></label>
                            <div class="layui-input-inline">
                                <input required type="text" id="name" required lay-verify="required" name="name"
                                       value=${bill.name} autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">用户学年<span  class="star">*</span></label>
                            <div  class="layui-inline " style="width: 115px;margin-right: 0px;margin-bottom: 0px;">
                                <select name="semesterId" lay-verify="required" class="decSelect"
                                        url="/dictionary/list/payTerm/options" selectedId="${bill.semesterId}"  >
                                    <option value="">请选择</option>

                                </select>
                            </div>
                            <button type="button" class="layui-btn" id="semesterIdSetting"
                                    style="padding-left: 10px;padding-right: 10px;width: 70px;">设置
                            </button>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-inline" style="margin-bottom: 0px">
                            <label class="layui-form-label">缴费类型<span  class="star">*</span></label>
                            <div class="layui-inline" style="width: 115px;margin-right: 0px;margin-bottom: 0px;">
                                <select name="typeId" lay-verify="required" class="decSelect"
                                        url="/dictionary/list/payType/options"   selectedId="${bill.typeId}">
                                    <option value="">请选择</option>
                                </select>
                            </div>
                            <button type="button" class="layui-btn" id="typeIdSetting"
                                    style="padding-left: 10px;padding-right: 10px;width: 70px;">设置
                            </button>
                        </div>
                        <div class="layui-inline" style="margin-left: 10px;margin-right: 0px;margin-bottom: 0px;">
                            <label class="layui-form-label">缴费方式<span  class="star">*</span></label>
                            <div class="layui-inline " style="width: 115px;margin-right: 0px;margin-bottom: 0px;">
                                <select name="paymentMethodId" lay-verify="required" class="decSelect"
                                        url="/dictionary/list/payWay/options"  selectedId="${bill.paymentMethodId}"  >
                                    <option value="">请选择</option>
                                </select>
                            </div>
                            <button type="button" class="layui-btn" id="paymentMethodIdSetting"
                                    style="padding-left: 10px;padding-right: 10px;width: 70px;">设置
                            </button>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">总金额<span  class="star">*</span></label>
                            <div class="layui-input-inline">
                                <input type="text" name="totalAmount" value=${bill.totalAmount?c} autocomplete="off"
                                       required lay-verify="required" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline" style="margin-right: 0px;margin-bottom: 0px;">
                            <input style="display:  none" value="${bill.hasInstalment?c}" id="Instalment">
                            <label class="layui-form-label">是否分期<span  class="star">*</span></label>
                            <div class="layui-inline" style="width: 190px;margin-right: 0px;margin-bottom: 0px;">
                                <select lay-verify="" name="hasInstalment" id="hasInstalment">
                                    <option value="false">否</option>
                                    <option value="true">是</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">缴费日期<span  class="star">*</span></label>
                            <div class="layui-input-inline">
                                <input class="layui-input" name="payDate" value="${bill.payDate}" id="payDate" required
                                       lay-verify="required" type="text">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">优惠金额</label>
                            <div class="layui-input-inline">
                                <input type="text" name="discountAmount"
                                       value=${bill.discountAmount?c} autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">金额<span  class="star">*</span></label>
                            <div class="layui-input-inline">
                                <input type="text" name="payAmount" value=#{bill.payAmount} autocomplete="off" required
                                       lay-verify="required" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">总计<span  class="star">*</span></label>
                            <div class="layui-input-inline">
                                <input type="text" name="factAmount" value=${bill.factAmount?c} autocomplete="off"
                                       required lay-verify="required" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">开始时间<span  class="star">*</span></label>
                            <div class="layui-input-inline">
                                <input class="layui-input" required lay-verify="required" name="startTime"
                                       value="${bill.startTime}" id="startTime" type="text"
                                >
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">结束时间<span  class="star">*</span></label>
                            <div class="layui-input-inline">
                                <input class="layui-input" required lay-verify="required" name="endTime"
                                       value="${bill.endTime}"  id="endTime" type="text"
                                >
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item" style="width: 620px">
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">备注</label>
                            <div class="layui-input-block">
                                <textarea name="remark" placeholder="请输入内容"
                                          class="layui-textarea">${bill.remark}</textarea>
                            </div>
                        </div>
                    </div>
                </div>
                <div style="text-align: center;width: 650px">
                    <button type="button" class="layui-btn" lay-submit id="submitBtn"
                            style="padding-left: 10px;padding-right: 10px;width: 70px;">提交
                    </button>
                    <button type="button" class="layui-btn layui-btn-primary"id="revocationBtn"
                            style="padding-left: 10px;padding-right: 10px;width: 70px;">取消
                    </button>
                </div>
            </form>

        </div>
    </fieldset>
</div>
</body>
<script type="text/javascript" src="/money/js/modify.js"></script>
</html>