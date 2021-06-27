//根据用户id显示笔记本列表
    function loginjudge() {
        //获取userId
        var userName=getCookie("userName");
        //判断是否获取到有效的userId
        if(userName==null){
            //转发回登录页面
            window.location.href="log_in.html";
        }else {
            alert("欢迎"+username+"登录！");
        }
    };

    function click(){
    delCookie("userName");
    window.location.href="log_in.html";
    };

