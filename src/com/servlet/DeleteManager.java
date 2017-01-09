package com.servlet;

import com.entity.Manager;
import com.impDao.ManagerImpDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by junlai on 2017/1/8.
 */
public class DeleteManager extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String manager_id = request.getParameter("manager_id");
        if (!(manager_id == null || "".equals(manager_id))) {
            Manager manager = new Manager();
            manager.setManager_id(manager_id);
            ManagerImpDao managerImpDao = new ManagerImpDao();
            managerImpDao.deleteManager(manager);
        }
        response.sendRedirect("Admin/managerList.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print(this.getClass());
        out.flush();
        out.close();
    }
}
