<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../layui/css/layui.css"/>
    <script type="text/javascript" src="../layui/layui.js"></script>
    <script type="text/javascript" src="../money/js/money.js"></script>
</head>
<body>
<div style="padding: 15px;">
    <div class="demoTable">
        <fieldset class="layui-elem-field layuimini-search">
            <legend>搜索信息</legend>
            <div style="margin: 10px 10px 10px 10px">
                <form class="layui-form layui-form-pane" action="">
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">关键字</label>
                            <div class="layui-input-inline">
                                <input type="text" name="username" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <select name="city" lay-verify="">
                                <option value="">选择年级</option>
                                <option value="01">一年级</option>
                                <option value="02">二年级</option>
                                <option value="03">三年级</option>
                            </select>
                        </div>
                        <div class="layui-inline">
                            <select name="city" lay-verify="">
                                <option value="">缴费类型</option>
                                <option value="01">学费</option>
                                <option value="02">住宿费</option>
                                <option value="03">学杂费</option>
                            </select>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">日期范围</label>
                            <div class="layui-input-inline">
                                <input class="layui-input" id="test6" type="text" placeholder=" - ">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <a class="layui-btn" lay-submit="" lay-filter="data-search-btn">搜索</a>
                        </div>
                    </div>
                </form>
            </div>
        </fieldset>

    </div>
    <table class="layui-hide" id="test" lay-filter="test"></table>
    <script id="barDemo" type="text/html">
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="edit">修改</a>
    </script>
    <script id="toolbarDemo" type="text/html">
        <div class="layui-btn-container">
            <button class="layui-btn layui-btn-sm" lay-event="add">添加</button>
            <button class="layui-btn layui-btn-sm" lay-event="add">导出</button>
        </div>
    </script>
</div>
<div id="aa" style="display: none">
    <fieldset class="layui-elem-field layuimini-search">
        <legend>信息</legend>
        <div style="margin: 10px 10px 10px 10px">
            <form class="layui-form layui-form-pane" lay-filter="dataForm" id="dataFor">
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">用户姓名</label>
                        <div class="layui-input-inline">
                            <input type="text" name="name" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">用户年级</label>
                        <div class="layui-inline"  style="width: 190px">
                            <select  lay-verify="" name="grade" id="grade">
                                <option value="一年级">一年级</option>
                                <option value="二年级">二年级</option>
                                <option value="三年级">三年级</option>
                            </select>
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">缴费类型</label>
                        <div class="layui-inline" style="width: 115px">
                            <select  lay-verify="" name="type" id="type" >
                                <option value="学费">学费</option>
                                <option value="住宿费">住宿费</option>
                                <option value="学杂费">学杂费</option>
                            </select>
                        </div>
                        <button type="button" class="layui-btn" id="ss">设置</button>

                    </div>

                    <div class="layui-inline">
                        <label class="layui-form-label">缴费方式</label>
                        <div class="layui-inline"  style="width: 190px">
                            <select  lay-verify="" name="paymentMethod" id="paymentMethod">
                                <option value="支付宝">支付宝</option>
                                <option value="银行转账">银行转账</option>
                                <option value="现金">现金</option>
                            </select>
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">金额</label>
                        <div class="layui-input-inline">
                            <input type="text" name="money"  autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">缴费日期</label>
                        <div class="layui-input-inline">
                            <input class="layui-input" name="date" id="test1" type="text" placeholder="yyyy-MM-dd">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">是否分期</label>
                        <div class="layui-input-block">
                            <input name="instalment" type="radio" value="是" title="是">
                            <input name="instalment" type="radio" value="否" title="否" checked>
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">优惠金额</label>
                        <div class="layui-input-inline">
                            <input type="text" name="discount"  autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">费用有效期</label>
                        <div class="layui-input-inline">
                            <input class="layui-input" name="Validity" id="test2" type="text" placeholder="yyyy-MM-dd">
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </fieldset>
</div>
</body>
</html>