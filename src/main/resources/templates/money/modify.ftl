<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/layui/css/layui.css"/>
    <script type="text/javascript" src="/layui/layui.js"></script>
    <script type="text/javascript" src="/money/js/modify.js"></script>
    <script type="text/javascript" src="/all.js"></script>

</head>
<body>
<div id="addpage">
    <fieldset id="add2" class="layui-elem-field layuimini-search">
        <legend>缴费信息填写</legend>
        <div style="margin: 10px 10px 10px 10px;margin-left:25%">
            <form class="layui-form layui-form-pane" lay-filter="dataForm1" id="dataFor">
                <input style="display: none" type="text" id="id" name="id" value=${bill.id} autocomplete="off"
                       class="layui-input">
                <div class="layui-form-item">
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">用户姓名</label>
                            <div class="layui-input-inline">
                                <input required type="text" id="name" required lay-verify="required" name="name"
                                       value=${bill.name} autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">用户学年</label>
                            <div  class="layui-inline " style="width: 115px;margin-right: 0px;margin-bottom: 0px;">
                                <select name="list3" lay-verify="required" class="decSelect"
                                        url="/dictionary/list/payTerm/options" value=${bill.semesterId}>
                                    <option value="">请选择</option>
                                </select>
                            </div>
                            <button type="button" class="layui-btn" id="ss"
                                    style="padding-left: 10px;padding-right: 10px;width: 70px;">设置
                            </button>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-inline" style="margin-bottom: 0px">
                            <label class="layui-form-label">缴费类型</label>
                            <div class="layui-inline" style="width: 115px;margin-right: 0px;margin-bottom: 0px;">
                                <select name="list1" lay-verify="required" class="decSelect"
                                        url="/dictionary/list/payType/options" value=${bill.typeId}>
                                    <option value="">请选择</option>
                                </select>
                            </div>
                            <button type="button" class="layui-btn" id="ss"
                                    style="padding-left: 10px;padding-right: 10px;width: 70px;">设置
                            </button>
                        </div>
                        <div class="layui-inline" style="margin-left: 10px;margin-right: 0px;margin-bottom: 0px;">
                            <label class="layui-form-label">缴费方式</label>
                            <div class="layui-inline " style="width: 115px;margin-right: 0px;margin-bottom: 0px;">
                                <select name="list2" lay-verify="required" class="decSelect"
                                        url="/dictionary/list/payWay/options" value=${bill.paymentMethodId}>
                                    <option value="">请选择</option>
                                </select>
                            </div>
                            <button type="button" class="layui-btn" id="aaaaaawww"
                                    style="padding-left: 10px;padding-right: 10px;width: 70px;">设置
                            </button>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">总金额</label>
                            <div class="layui-input-inline">
                                <input type="text" name="totalAmount" value=${bill.totalAmount?c} autocomplete="off"
                                       required lay-verify="required" class="layui-input">
                            </div>
                        </div>

                        <div class="layui-inline" style="margin-right: 0px;margin-bottom: 0px;">
                            <label class="layui-form-label">是否分期</label>
                            <div class="layui-inline" style="width: 190px;margin-right: 0px;margin-bottom: 0px;">
                                <select lay-verify="" name="hasInstalment" id="hasInstalment">
                                    <option value="true">是</option>
                                    <option value="false">否</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">缴费日期</label>
                            <div class="layui-input-inline">
                                <input class="layui-input" name="payDate" value=${bill.payDate} id="test1" required
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
                            <label class="layui-form-label">金额</label>
                            <div class="layui-input-inline">
                                <input type="text" name="payAmount" value=#{bill.payAmount} autocomplete="off" required
                                       lay-verify="required" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">总计</label>
                            <div class="layui-input-inline">
                                <input type="text" name="factAmount" value=${bill.factAmount?c} autocomplete="off"
                                       required lay-verify="required" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">开始时间</label>
                            <div class="layui-input-inline">
                                <input class="layui-input" required lay-verify="required" name="startTime"
                                       value=${bill.startTime} id="test2" type="text"
                                >
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">结束时间</label>
                            <div class="layui-input-inline">
                                <input class="layui-input" required lay-verify="required" name="endTime"
                                       value=${bill.endTime}  id="test3" type="text"
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
                <button type="button" class="layui-btn" lay-submit id="update"
                        style="padding-left: 10px;padding-right: 10px;width: 70px;margin-left: 275px">提交
                </button>
            </form>

        </div>
    </fieldset>
</div>
</body>
<script>
    sel();
</script>
</html>