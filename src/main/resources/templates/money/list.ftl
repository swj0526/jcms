<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../layui/css/layui.css"/>
    <script type="text/javascript" src="../layui/layui.js"></script>
    <script type="text/javascript" src="../money/js/money.js"></script>
    <style>
        body .layer-ext-myskin .layui-layer-content {
            overflow: visible;
        }
    </style>
</head>
<body>
<div style="padding: 15px;">
    <div class="demoTable">
        <fieldset class="layui-elem-field layuimini-search">
            <legend>缴费查询信息</legend>
            <div style="margin: 10px 10px 10px 10px">
                <form class="layui-form layui-form-pane">
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">关键字</label>
                            <div class="layui-input-inline">
                                <input type="text" name="username" autocomplete="off" class="layui-input" placeholder="例：1990/张三/学号">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">专业-班级</label>
                            <div class="layui-input-inline" lay-verify="required" lay-search="">
                                <select name="major">
                                    <option value="">请选择专业-班级</option>
                                    <optgroup label="影视专业">
                                        <option value="">所有影视专业</option>
                                        <option value="">影视一班</option>
                                    </optgroup>
                                    <optgroup label="美术专业">
                                        <option value="">所有美术专业</option>
                                        <option value="">美术一班</option>
                                    </optgroup>
                                </select>
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">缴费类型</label>
                            <div class="layui-inline">
                                <select name="city" lay-verify="">
                                    <option value="">全部</option>
                                    <option value="01">学费</option>
                                    <option value="02">住宿费</option>
                                    <option value="03">学杂费</option>
                                </select>
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">日期范围</label>
                            <div class="layui-input-inline">
                                <input class="layui-input" id="test6" type="text" placeholder=" - ">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <a class="layui-btn" lay-filter="data-search-btn">查询</a>
                            <button class="layui-btn" type="button" lay-filter="data-search-btn" id="add">添加</button>
                            <button class="layui-btn" type="button" lay-filter="data-search-btn" id="export">导出</button>
                        </div>
                    </div>

                </form>

            </div>
        </fieldset>

    </div>
    <table class="layui-hide" id="test" lay-filter="test"></table>
    <script id="barDemo" type="text/html">
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="edit">修改</a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="up">上传发票</a>
    </script>
    <script id="toolbarDemo" type="text/html">
        <div class="layui-btn-container">

        </div>
    </script>
</div>
<div id="addpage" style="display: none">
    <fieldset id="add2" class="layui-elem-field layuimini-search">
        <legend>缴费信息填写</legend>
        <div style="margin: 10px 10px 10px 10px;margin-left:25%">
            <form class="layui-form layui-form-pane" lay-filter="dataForm1" id="dataFor">
                <div class="layui-form-item">
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">用户姓名</label>
                            <div class="layui-input-inline">
                                <input type="text" id="name" name="name" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">用户学年</label>
                            <div class="layui-inline" style="width: 115px;margin-right: 0px;margin-bottom: 0px;">
                                <select lay-verify="" name="semester" id="grade">
                                    <option value="19年">19年</option>
                                    <option value="20年">20年</option>
                                    <option value="21年">21年</option>
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
                                <select lay-verify="" name="Type" id="type">
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
                                <input type="text" name="totalAmount" autocomplete="off" class="layui-input">
                            </div>
                        </div>

                        <div class="layui-inline">
                            <label class="layui-form-label">是否分期</label>
                            <div class="layui-input-inline">
                                <input name="hasInstalment" type="radio" value="是" title="是">
                                <input name="hasInstalment" type="radio" value="否" title="否" checked>
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">缴费日期</label>
                            <div class="layui-input-inline">
                                <input class="layui-input" name="payDate" id="test1" type="text" placeholder="yyyy-MM-dd">
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
                            <label class="layui-form-label">金额</label>
                            <div class="layui-input-inline">
                                <input type="text" name="payAmount" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">总计</label>
                            <div class="layui-input-inline">
                                <input type="text" name="factAmount" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">开始时间</label>
                            <div class="layui-input-inline">
                                <input class="layui-input" name="startTime" id="test2" type="text"
                                       placeholder="yyyy-MM-dd">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">结束时间</label>
                            <div class="layui-input-inline">
                                <input class="layui-input" name="endTime" id="test3" type="text"
                                       placeholder="yyyy-MM-dd">
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
            </form>
            <button type="button" class="layui-btn" id="ss"
                    style="padding-left: 10px;padding-right: 10px;width: 70px;margin-left: 275px">提交
            </button>
        </div>
    </fieldset>
</div>
</body>
</html>