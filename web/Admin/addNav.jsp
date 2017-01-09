<%--
  Created by IntelliJ IDEA.
  User: junlai
  Date: 2017/1/6
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>添加新闻类别</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css">
</head>

<body>
<div class="main-frame">
    <jsp:include page="top.jsp"></jsp:include>
    <jsp:include page="left.jsp"></jsp:include>
    <div class="right">
        <div class="admin">
            <h1 class="title">添加新闻类别<a href="navList.jsp" class="back-btn">返回</a></h1>
            <form action="<%=path%>/InsertNav" id="frm" method="post">
                <table>
                    <tr>
                        <td>新闻类别：</td>
                        <td><input id="nav_name" name="nav_name" autocomplete="off" maxlength="50" type="text"></td>
                        <td id="err_nav_name"></td>
                    </tr>
                    <tr>
                        <td>排序权重：</td>
                        <td><input id="nav_weight" name="nav_weight" autocomplete="off" maxlength="10" type="text">
                        </td>
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
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
<script type="text/javascript">
    function startPost() {
        var nav_name=document.getElementById("nav_name").value;
        var nav_weight=document.getElementById("nav_weight").value;
        if(nav_name==""){
            document.getElementById("err_nav_name").innerHTML="<span class='err'>请输入类别名称</span>";
            return;
        }
        if(nav_weight==""){
            document.getElementById("err_nav_weight").innerHTML="<span class='err'>请输入类别排序权重，值越小越靠前</span>";
            return;
        }
        if(isNaN(parseInt(nav_weight))){
            document.getElementById("err_nav_weight").innerHTML="<span class='err'>类别排序必须是数字，值越小越靠前</span>";
            return;
        }
        document.getElementById("frm").submit();

    }


</script>
</body>
</html>

