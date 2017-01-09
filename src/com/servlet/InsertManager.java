package com.servlet;

import com.entity.Manager;
import com.impDao.ManagerImpDao;
import com.tools.MyFuns;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by junlai on 2017/1/6.
 */
public class InsertManager extends javax.servlet.http.HttpServlet {

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String manager_id = request.getParameter("manager_id");
        String manager_name = request.getParameter("manager_name");
        String manager_pwd = request.getParameter("manager_pwd");
        System.out.print(manager_name);
        Manager manager = new Manager();
        manager.setManager_id(MyFuns.convert2utf8(manager_id));
        manager.setManager_name(MyFuns.convert2utf8(manager_name));
        manager.setManager_pwd(manager_pwd);
        if (manager.getManager_id() == null || "".equals(manager.getManager_id()) ||
                manager.getManager_name() == null || "".equals(manager.getManager_name()) ||
                manager.getManager_pwd() == null || "".equals(manager.getManager_pwd())) {
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.print("请把信息输入完整<a href=\"addManager.jsp\">返回请重新输入</a>");
        } else {
            ManagerImpDao managerImpDao = new ManagerImpDao();
            if (managerImpDao.queryManagerById(manager.getManager_id()) != null) {
                response.setCharacterEncoding("utf-8");
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.print("用户名已经存在了<a href=\"addManager.jsp\">返回请重新输入</a>");

            } else {
                boolean flag = managerImpDao.insertManager(manager);
                System.out.print(flag);
                response.sendRedirect("Admin/managerList.jsp");


            }

        }


    }


    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }


}
