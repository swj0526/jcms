//tab选项卡
var all_tab =function(id,title,src){
    layui.use(['element','jquery'], function () {
        var  element = layui.element;
        var $ = layui.jquery;
        //id:点击左边的导航栏,获取导航中的a标签的id
        //title:选项卡的名字
        //src:controller里的映射地址

            if($("[lay-id=" + id + "]").length==0){//选判断是否存在该选项卡
                element.tabAdd('demo', {
                    title: title,
                    content: '<iframe src='+src+' frameborder="0"  height="100%" width="100%"></iframe>',
                    id:id//实际使用一般是规定好的id，这里以时间戳模拟下
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

