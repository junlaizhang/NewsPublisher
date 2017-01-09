package com.servlet;

import com.entity.Manager;
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
 * Created by junlai on 2017/1/8.
 */
@WebServlet(name = "EditManager")
public class EditManager extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String manager_id = request.getParameter("manager_id");
        String manager_name = request.getParameter("manager_name");
        Manager manager = new Manager();
        manager.setManager_id(manager_id);
        manager.setManager_name(MyFuns.convert2utf8(manager_name));
        if (manager.getManager_id() == null || "".equals(manager.getManager_id()) ||
                manager.getManager_name() == null || "".equals(manager.getManager_name())) {
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.print("请把信息输入完整<a href=\"Admin/managerList.jsp\">返回请重新输入</a>");
            out.flush();
            out.close();
        } else {
            ManagerImpDao managerImpDao = new ManagerImpDao();
            boolean flag = managerImpDao.updateManagerName(manager);
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println(flag ? "修改成功" : "修改失败");
            out.print("请把信息输入完整<a href=\"Admin/managerList.jsp\">返回管理员列表</a>");
            out.flush();
            out.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
