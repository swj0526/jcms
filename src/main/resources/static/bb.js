layui.use(['element', 'jquery', 'layer'], function () {
    var $ = layui.jquery, element = layui.element, layer = layui.layer;
    //id:点击左边的导航栏,获取导航中的a标签的id
    //title:选项卡的名字
    //src:controller里的映射地址
    function dynamicTab(id,title,src) {
        if($("[lay-id=" + id + "]").length==0){//选判断是否存在该选项卡
            element.tabAdd('demo', {
                title: title, //提醒-缴费提醒
                content: '<iframe src='+src+' frameborder="0"   height="800px" width="100%"></iframe>',
                id:id//实际使用一般是规定好的id，这里以时间戳模拟下
            });
        }
        element.tabChange('demo', id); //切换到tab选项卡
    }
});