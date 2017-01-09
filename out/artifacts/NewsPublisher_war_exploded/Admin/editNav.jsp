<%@ page import="com.action.bean.ActionBean" %>
<%@ page import="com.entity.Nav" %><%--
  Created by IntelliJ IDEA.
  User: junlai
  Date: 2017/1/8
  Time: 00:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String nav_id = request.getParameter("nav_id");
    if (nav_id == null || "".equals(nav_id)) {
        response.sendRedirect("navList.jsp");
        return;
    }
    ActionBean actionBean = new ActionBean();
    Nav nav = actionBean.queryNavById(nav_id);
    if (nav == null) {
        response.sendRedirect("navList.jsp");
        return;
    }

%>
<html>
<head>
    <title>修改新闻类别</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<form action="<%=path%>/EditNav" id="frm" method="post">
    <input type="hidden" value="<%=nav.getNav_id()%>" name="nav_id"/>
    <table>
        <tr>
            <td>新闻类别：</td>
            <td><input id="nav_name" name="nav_name" autocomplete="off" maxlength="50"
                       type="text" value="<%=nav.getNav_name()%>"/></td>
            <td id="err_nav_name"></td>
        </tr>
        <tr>
            <td>排序权重：</td>
            <td><input id="nav_weight" name="nav_weight" autocomplete="off" maxlength="10" type="text"
                       value="<%=nav.getNav_weight()%>"/></td>
            <td id="err_nav_weight"></td>
        </tr>

        <tr>
            <td></td>
            <td>
                <a class="btn" onclick="startPost();" href="javascript:void(0)">保存</a>
            </td>
        </tr>
    </table>
</form>
<script type="text/javascript" src="../js/nav.js"></script>
</body>
</html>

