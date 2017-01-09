<%--
  Created by IntelliJ IDEA.
  User: junlai
  Date: 2017/1/8
  Time: 20:05
  To change this template use File | Settings | File Templates
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.config.Config" %>
<%
    String msg = request.getParameter("msg") == null ? "" : ("2".equals(request.getParameter("msg")) ? "错误的用户名或者密码" : ("0".equals(request.getParameter("msg")) ? "信息填写不完整" : ""));
    Config config1=new Config();
    if(session.getAttribute(config1.MANAGER_ID)!=null && !"".equals(session.getAttribute(config1.MANAGER_ID).toString())){
        response.sendRedirect("Admin/main.jsp");
    }
%>
<html>
<head>
    <title>登录Marshal新闻发布系统后台</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="login-Title">Marshal新闻发布系统后台
    <small>登录</small>
</div>
<div class="login-main">
    <div class="login-box">
        <div class="box">
            <h2>用户登录</h2>
            <form action="LoginServlet" id="frm" method="post">
                <p><label>账号：</label><input type="text" name="manager_id" id="manager_id"></p>
                <p><label>密码：</label><input type="password" name="manager_pwd" id="manager_pwd"></p>
                <p><a class="btn" href="javascript:void(0)" onclick="postForm()">登录</a></p>
                <p><span id="msg" class="msg"><%=msg%></span></p>
            </form>
        </div>
    </div>
</div>
<jsp:include page="Admin/footer.jsp"></jsp:include>
<script type="text/javascript">
    function postForm() {
        var manager_id = document.getElementById("manager_id").value;
        var manager_pwd = document.getElementById("manager_pwd").value;
        document.getElementById("msg").innerHTML = "";
        if (manager_id == "" || manager_pwd == "") {
            document.getElementById("msg").innerHTML = "请输入用户名或者密码";
            return;

        } else {
            document.getElementById("frm").submit();
        }
    }
</script>
</body>
</html>
