layui.use('element', function () {
    var $ = layui.jquery, element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块
    //Hash地址的定位
    var layid = location.hash.replace(/^#demo=/, '');
    element.tabChange('demo', layid);
});