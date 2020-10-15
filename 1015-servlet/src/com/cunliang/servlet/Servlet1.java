package com.cunliang.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        System.out.println("在Servlet1中查看参数" + username);
        //传递给servlet2
        req.setAttribute("key","柜台1的章");
        //请求转发
        RequestDispatcher dispatcher = req.getRequestDispatcher("/servlet2");
        dispatcher.forward(req,resp);


    }
}
