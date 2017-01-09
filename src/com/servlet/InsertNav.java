package com.servlet;

import com.entity.Nav;
import com.impDao.ManagerImpDao;
import com.tools.MyFuns;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

/**
 * Created by junlai on 2017/1/9.
 */
@WebServlet(name = "InsertNav")
public class InsertNav extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nav_name = request.getParameter("nav_name");
        String nav_weight_str = request.getParameter("nav_weight");
        if (nav_name == null || nav_weight_str == null) {
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.print("请将信息输入完整。<a href=\"addNav.jsp\">返回请继续输入</a>");
            out.flush();
            out.close();
            return;
        }
        int nav_weight = 0;
        try {
            nav_weight = Integer.parseInt(nav_weight_str);
        } catch (Exception e) {
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.print("输入错误。<a href=\"addNav.jsp\">请重新输入</a>");
            out.flush();
            out.close();
            return;
        }
        String nav_id = UUID.randomUUID().toString();
        Nav nav = new Nav();
        nav.setNav_id(nav_id);
        nav.setNav_name(MyFuns.convert2utf8(nav_name));
        nav.setNav_weight(nav_weight);
        ManagerImpDao managerImpDao = new ManagerImpDao();
        Boolean flag = managerImpDao.insertNav(nav);

        if (!flag) {
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.print("增加类别错误。<a href=\"addNav.jsp\">请重新输入</a>");
            out.flush();
            out.close();
        } else {
            response.sendRedirect("Admin/navList.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
