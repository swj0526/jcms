//tab选项卡
var all_tab = function (id, title, src) {
    layui.use(['element', 'jquery'], function () {
        var element = layui.element;
        var $ = layui.jquery;
        //id:点击左边的导航栏,获取导航中的a标签的id
        //title:选项卡的名字
        //src:controller里的映射地址

        if ($("[lay-id=" + id + "]").length == 0) {//选判断是否存在该选项卡
            element.tabAdd('demo', {
                title: title,
                content: '<iframe src=' + src + ' frameborder="0"  height="100%" width="100%"></iframe>',
                id: id//实际使用一般是规定好的id，这里以时间戳模拟下
            });
        }
        element.tabChange('demo', id); //切换到tab选项卡

        //Hash地址的定位
        var layid = location.hash.replace(/^#test=/, '');
        element.tabChange('test', layid);
        element.on('tab(test)', function (elem) {
            location.hash = 'test=' + $(this).attr('lay-id');
        });
    });
}
//select下拉选
var sel = function () {
    //JavaScript代码区域
    layui.use(['table', 'layer', 'jquery', 'form'], function () {
        var table = layui.table;
        var layer = layui.layer;
        var $ = layui.jquery;
        var form = layui.form;
        //传入的字典的类型
        var type = $('#decSelect').attr('type');
        var url = $('#decSelect').attr('url');

        //重新渲染表单
        function renderForm() {
            layui.use('form', function () {
                var form = layui.form; //高版本建议把括号去掉，有的低版本，需要加()
                form.render();
            });
        }

        $.post(url,{type:type}, function (result) {
            $.each(result, function (key, value) {
                $("#decSelect").append("<option value=" + value.id + ">" + value.name + "</option>");
            });
            renderForm(); //表单重新渲染，要不然添加完显示不出来新的option
        });
    });
}
/*  上面的代码要需要下面指定的格式,传入type,跟url,id指定decSelect
    <form class="layui-form" action="">
    <div class="layui-form-item proSelect">
    <label class="layui-form-label">产品类别</label>
    <div class="layui-input-block editWidth">
    <select name="list" lay-verify="required" id="decSelect" type= url="">
    <option value="">请选择</option>

    </select>
    </div>
    </div>

    </form>
*/
