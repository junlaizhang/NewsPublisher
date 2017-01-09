package com.servlet;

import com.entity.Article;
import com.entity.Nav;
import com.impDao.ManagerImpDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by junlai on 2017/1/9.
 */
@WebServlet(name = "DeleteNav")
public class DeleteNav extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nav_id=request.getParameter("nav_id");
        if (!(nav_id == null || "".equals(nav_id))) {
            Nav nav=new Nav();
            nav.setNav_id(nav_id);
            ManagerImpDao managerImpDao = new ManagerImpDao();
            List<Article> list=managerImpDao.queryArticleByNav_id(nav_id);
            if(list.size()<1){
                managerImpDao.deleteNav(nav);
            }

        }
        response.sendRedirect("Admin/navList.jsp");

    }
}
