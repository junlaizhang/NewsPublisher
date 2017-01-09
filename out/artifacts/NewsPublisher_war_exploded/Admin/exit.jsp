<%--
  Created by IntelliJ IDEA.
  User: junlai
  Date: 2017/1/9
  Time: 00:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.config.Config" %>
<%
    HttpSession httpSession=request.getSession();
    Config config1=new Config();
    httpSession.removeAttribute(config1.MANAGER_ID);
    httpSession.removeAttribute(config1.LOGIN_SUCCESS);
    response.sendRedirect("login.jsp");
%>

