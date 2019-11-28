<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../layui/css/layui.css"/>
    <link rel="stylesheet" type="text/css" href="/all.css"/>
    <script type="text/javascript" src="/layui/layui.js"></script>
    <script type="text/javascript" src="/money/js/addBill.js"></script>
    <script type="text/javascript" src="/money/js/money.js"></script>
    <script type="text/javascript" src="/all.js"></script>
    <style>
        body .layer-ext-myskin .layui-layer-content {
            overflow: visible;
        }
    </style>
</head>
<body>
<fieldset id="add2" style="border: 0" ">
    <div style="margin: 10px 10px 10px 10px;margin-left:28%">
        <form class="layui-form layui-form-pane" lay-filter="dataForm1" id="dataFor">
            <div class="layui-form-item">
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">用户姓名<span  class="star">*</span></label>
                        <div class="layui-input-inline">
                            <input type="text" id="name1" required lay-verify="required" name="name" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">用户学年<span  class="star">*</span></label>
                        <div class="layui-inline" style="width: 115px;margin-right: 0px;margin-bottom: 0px;">
                            <select name="semesterId" lay-verify="required" class="decSelect"
                                    url="/dictionary/list/payTerm/options">
                                <option value="">请选择</option>
                            </select>
                        </div>
                        <button type="button" class="layui-btn" id="type3"
                                style="padding-left: 10px;padding-right: 10px;width: 70px;">设置
                        </button>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-inline" style="margin-bottom: 0px">
                        <label class="layui-form-label">缴费类型<span  class="star">*</span></label>
                        <div class="layui-inline" style="width: 115px;margin-right: 0px;margin-bottom: 0px;">
                            <select name="typeId" lay-verify="required" class="decSelect"
                                    url="/dictionary/list/payType/options" >
                                <option value="">请选择</option>
                            </select>
                        </div>
                        <button type="button" class="layui-btn" id="type1"
                                style="padding-left: 10px;padding-right: 10px;width: 70px;">设置
                        </button>
                    </div>
                    <div class="layui-inline" style="margin-left: 10px;margin-right: 0px;margin-bottom: 0px;">
                        <label class="layui-form-label">缴费方式<span  class="star">*</span></label>
                        <div class="layui-inline" style="width: 115px;margin-right: 0px;margin-bottom: 0px;">
                            <select name="paymentMethodId" lay-verify="required" class="decSelect"
                                    url="/dictionary/list/payWay/options" >
                                <option value="">请选择</option>
                            </select>
                        </div>
                        <button type="button" class="layui-btn" id="type2"
                                style="padding-left: 10px;padding-right: 10px;width: 70px;">设置
                        </button>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">总金额<span  class="star">*</span></label>
                        <div class="layui-input-inline">
                            <input type="text" name="totalAmount" required lay-verify="required" autocomplete="off" class="layui-input">
                        </div>
                    </div>

                    <div class="layui-inline" style="margin-right: 0px;margin-bottom: 0px;">
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
                        <label class="layui-form-label ">缴费日期<span  class="star">*</span></label>
                        <div class="layui-input-inline">
                            <input class="layui-input" required lay-verify="required" name="payDate" id="test1" type="text">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">优惠金额</label>
                        <div class="layui-input-inline">
                            <input type="text" name="discountAmount" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">金额<span  class="star">*</span></label>
                        <div class="layui-input-inline">
                            <input type="text" name="payAmount" required lay-verify="required" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">总计<span  class="star">*</span></label>
                        <div class="layui-input-inline">
                            <input type="text" name="factAmount" required lay-verify="required" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">开始时间<span  class="star">*</span></label>
                        <div class="layui-input-inline">
                            <input class="layui-input" name="startTime" required lay-verify="required" id="test2" type="text"
                                   >
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">结束时间<span  class="star">*</span></label>
                        <div class="layui-input-inline">
                            <input class="layui-input" name="endTime" required lay-verify="required" id="test3" type="text"
                                   >
                        </div>
                    </div>
                </div>
                <div class="layui-form-item" style="width: 620px">
                    <div class="layui-form-item layui-form-text">
                        <label class="layui-form-label">备注</label>
                        <div class="layui-input-block">
                            <textarea name="remark" placeholder="请输入内容" class="layui-textarea"></textarea>
                        </div>
                    </div>
                </div>
            </div>
            <div style="text-align: center;width: 650px">
                <button type="button" class="layui-btn" lay-submit id="submit"
                        style="padding-left: 10px;padding-right: 10px;width: 70px;">提交
                </button>
                <button type="button" class="layui-btn layui-btn-primary"id="revocation"
                        style="padding-left: 10px;padding-right: 10px;width: 70px;">取消
                </button>
            </div>

        </form>

    </div>
</fieldset>
</body>
</html>