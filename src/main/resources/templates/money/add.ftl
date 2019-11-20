<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../layui/css/layui.css"/>
    <script type="text/javascript" src="../layui/layui.js"></script>
    <script type="text/javascript" src="../money/js/111.js"></script>
    <style>
        body .layer-ext-myskin .layui-layer-content {
            overflow: visible;
        }
    </style>
</head>
<body>
    <fieldset class="layui-elem-field layuimini-search">
        <legend>缴费信息填写</legend>
        <div style="margin: 10px 10px 10px 10px;margin-left:25%">
            <form class="layui-form layui-form-pane" lay-filter="dataForm" id="dataFor">
                <div class="layui-form-item">
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">用户姓名</label>
                            <div class="layui-input-inline">
                                <input type="text" name="name" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">用户年级</label>
                            <div class="layui-inline" style="width: 190px">
                                <select lay-verify="" name="grade" id="grade">
                                    <option value="一年级">一年级</option>
                                    <option value="二年级">二年级</option>
                                    <option value="三年级">三年级</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-inline" style="margin-bottom: 0px">
                            <label class="layui-form-label">缴费类型</label>
                            <div class="layui-inline" style="width: 115px;margin-right: 0px;margin-bottom: 0px;">
                                <select lay-verify="" name="type" id="type">
                                    <option value="学费">学费</option>
                                    <option value="住宿费">住宿费</option>
                                    <option value="学杂费">学杂费</option>
                                </select>
                            </div>
                            <button type="button" class="layui-btn" id="ss"
                                    style="padding-left: 10px;padding-right: 10px;width: 70px;">设置
                            </button>
                        </div>
                        <div class="layui-inline" style="margin-left: 10px;margin-right: 0px;margin-bottom: 0px;">
                            <label class="layui-form-label">缴费方式</label>
                            <div class="layui-inline" style="width: 115px;margin-right: 0px;margin-bottom: 0px;">
                                <select lay-verify="" name="paymentMethod" id="paymentMethod">
                                    <option value="支付宝">支付宝</option>
                                    <option value="银行转账">银行转账</option>
                                    <option value="现金">现金</option>
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
                                <input type="text" name="money" autocomplete="off" class="layui-input">
                            </div>
                        </div>

                        <div class="layui-inline">
                            <label class="layui-form-label">是否分期</label>
                            <div class="layui-input-inline">
                                <input name="instalment" type="radio" value="是" title="是">
                                <input name="instalment" type="radio" value="否" title="否" checked>
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">缴费日期</label>
                            <div class="layui-input-inline">
                                <input class="layui-input" name="date" id="test1" type="text" placeholder="yyyy-MM-dd">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">优惠金额</label>
                            <div class="layui-input-inline">
                                <input type="text" name="discount" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">金额</label>
                            <div class="layui-input-inline">
                                <input type="text" name="discount" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">总计</label>
                            <div class="layui-input-inline">
                                <input type="text" name="discount" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">开始时间</label>
                            <div class="layui-input-inline">
                                <input class="layui-input" name="Validity" id="test2" type="text"
                                       placeholder="yyyy-MM-dd">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">结束时间</label>
                            <div class="layui-input-inline">
                                <input class="layui-input" name="Validity" id="test3" type="text"
                                       placeholder="yyyy-MM-dd">
                            </div>
                        </div>
                    </div>
                </div>
            </form>
            <button type="button" class="layui-btn" id="ss"
                    style="padding-left: 10px;padding-right: 10px;width: 70px;margin-left: 275px">提交
            </button>
        </div>
    </fieldset>
</body>
</html>