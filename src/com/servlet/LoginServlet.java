package com.servlet;

import com.config.Config;
import com.entity.Manager;
import com.impDao.ManagerImpDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by junlai on 2017/1/8.
 */
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String manager_id=request.getParameter("manager_id");
        String manager_pwd=request.getParameter("manager_pwd");
        if(manager_id==null||"".equals(manager_id)||manager_pwd==null||"".equals(manager_pwd)){
                response.sendRedirect("login.jsp？msg=0");
                    return;
        }else {
            Manager manager=new Manager();
            manager.setManager_id(manager_id);
            manager.setManager_pwd(manager_pwd);
            ManagerImpDao managerImpDao=new ManagerImpDao();
            Manager manager1=managerImpDao.queryManagerByIdAndPwd(manager);
            Config config=new Config();
            if(manager1==null){
                response.sendRedirect("login.jsp？msg=2");

            }else{
                HttpSession session= request.getSession();
                session.setAttribute(config.MANAGER_ID,manager1.getManager_id());
                session.setAttribute(config.LOGIN_SUCCESS,config.LOGIN_SUCCESS_VALUE);
                response.sendRedirect("Admin/loading.jsp");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
