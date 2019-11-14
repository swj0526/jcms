layui.use('element', function () {
    var $ = layui.jquery, element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块
    //Hash地址的定位
    var layid = location.hash.replace(/^#demo=/, '');
    element.tabChange('demo', layid);
   /* var id = $(this).attr('id');
    element.tabChange('demo', id);*/
    /* if (id == "tab_student") {
         element.tabChange('demo', id);
     } else if (id == "tab_staff") {
         element.tabChange('demo', id);
     }*/


    /* $('.site-demo-active').on('click', function(){
          var othis = $(this), type = othis.data('type');
          active[type] ? active[type].call(this, othis) : '';
      });*/


});