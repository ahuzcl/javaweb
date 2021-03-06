package com.cunliang.web;

import com.cunliang.pojo.User;
import com.cunliang.service.UserService;
import com.cunliang.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /*
          1. 获取请求的参数
          2. 检查验证码是否正确
          3. 检查用户名是否可用
                 可用：调用service保存到数据库，跳到注册成功页面 register——success
                 不可用：跳回注册页面
         */

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String repwd = req.getParameter("repwd");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        if ("abcde".equalsIgnoreCase(code)){

            if (userService.existUser(username)){
            //  不可用 true
                System.out.println("用户名"+username+"已存在！");
                req.getRequestDispatcher("pages/user/selfregister.html").forward(req,resp);

            }else {
                //  可用

                userService.registerUser(new User(null,username,password,email));
                req.getRequestDispatcher("pages/user/selfregister_success.html").forward(req,resp);

            }

        }else {

            //注册失败，请求转发，跳转到注册页面
            System.out.println("验证码错误！");
            req.getRequestDispatcher("pages/user/selfregister.html").forward(req,resp);
        }
    }
}
