layui.use(['form', 'jquery'], function () {
    var form = layui.form,
        $ = layui.jquery,
        layer = layui.layer;


    // 登录过期的时候，跳出ifram框架
    if (top.location != self.location) top.location = self.location;

    // 粒子线条背景
    $(document).ready(function () {
        $('.layui-container').particleground({
            dotColor: '#5cbdaa',
            lineColor: '#5cbdaa'
        });
    });

    // 进行登录操作
    form.on('submit(login)', function (data) {
        data = data.field;
        if (data.username == '') {
            layer.msg('手机号不能为空');
            return false;
        }
        if (data.password == '') {
            layer.msg('密码不能为空');
            return false;
        }
        if (data.captcha == '') {
            layer.msg('验证码不能为空');
            return false;
        }
        $.post("/checklogin", {phone: data.username, password: data.password}, function (result) {
            if (result.success) {
                layer.msg('登录成功', function () {
                    window.location.href = '/home/main';
                });
            } else {
                layer.msg(result.msg);

            }
        });
        return false;
    });
});
	