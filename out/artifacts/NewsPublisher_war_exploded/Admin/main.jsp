<%@ page import="com.action.bean.ActionBean" %><%--
  Created by IntelliJ IDEA.
  User: junlai
  Date: 2017/1/7
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员信息列表</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css">

</head>
<body>
<div class="main-frame">
    <jsp:include page="top.jsp"></jsp:include>
    <jsp:include page="left.jsp"></jsp:include>
    <div class="right">
        <div class="admin">
            <h1 class="title">后台主页</h1>
            <div class="welcome">
                欢迎使用Marshal新闻发布系统
            </div>

        </div>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
