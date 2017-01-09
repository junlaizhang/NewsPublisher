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

/**
 * Created by junlai on 2017/1/9.
 */
@WebServlet(name = "EditNav")
public class EditNav extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nav_name = request.getParameter("nav_name");
        String nav_weight_str = request.getParameter("nav_weight");
        String nav_id = request.getParameter("nav_id");

        if (nav_id == null || nav_name == null || nav_weight_str == null) {
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.print("请将信息输入完整。<a href=\"navList.jsp\">返回请重新操作</a>");
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
            out.print("输入错误");
            out.flush();
            out.close();
            return;
        }
        Nav nav = new Nav();
        nav.setNav_id(nav_id);
        nav.setNav_name(MyFuns.convert2utf8(nav_name));
        nav.setNav_weight(nav_weight);
        ManagerImpDao managerImpDao = new ManagerImpDao();
        Boolean flag = managerImpDao.updateNav(nav);

        if (!flag) {
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.print("类别错误");
            out.flush();
            out.close();
        } else {
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.print("<script>parent.closeNavWindow(1);</script>");
            out.flush();
            out.close();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
