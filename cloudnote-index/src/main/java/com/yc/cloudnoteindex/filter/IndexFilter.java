package com.yc.cloudnoteindex.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter", urlPatterns = "*.jsp", dispatcherTypes = {})
public class IndexFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("LoginFilter doFilter");

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        String url = request.getRequestURI();

        System.out.println("请求的url：" + url);
        /*登录页面不需要过滤*/

        int idx = url.lastIndexOf("/");
        String endWith = url.substring(idx + 1);


        if (!endWith.equals("log_in.html")) {
            /*不是登录页面  进行拦截处理*/

            System.out.println("不是登录页面，进行拦截处理");

            if (!isLogin(request)) {
                System.out.println("没有登录过或者账号密码错误，跳转到登录界面");
                response.sendRedirect("login.jsp");
            } else {
                System.out.println("已经登录，进行下一步");
                chain.doFilter(req, resp);
            }

        } else {

            System.out.println("是登录页面，不进行拦截处理");
            chain.doFilter(req, resp);
        }





    }

    private boolean isLogin(HttpServletRequest request) {
        return true;
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
