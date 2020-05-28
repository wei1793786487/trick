$("#islogin").click(function () {
    layer.open({
        title: "用户小帮手",
        type: 1,
        offset: ['500px', '500px'],
        offset: 'rt' //具体配置参考：offset参数项
            ,
        content: '请问你想要做什么呢?',
        btn: ['修改密码', '安全退出'],
        btnAlign: 'c' //按钮居中
            ,
        shade: 0 //不显示遮罩
            ,
        yes: function () {
            location.href="password.html"
        },
        btn2: function () {
            logout().then(res => {
                if (res.code === 200) {
                    layer.msg('退出登录成功', {
                        time: 1000
                    }, function () {
                        location.reload();
                    });
                } else {
                    layer.msg(res.message, {
                        time: 1000,
                        icon: 2
                    })
                }
            })
            layer.closeAll();

        }

    });
})

var username = readCookie("username");

if (username != "") {
    $("#islogin").css("display", "block")
    $("#uname").html(username)
} else {
    $("#nologin").css("display", "block")
}