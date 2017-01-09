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
    <title>新闻类别管理</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css">

</head>
<body>
<div class="main-frame">
    <jsp:include page="top.jsp"></jsp:include>
    <jsp:include page="left.jsp"></jsp:include>
    <div class="right">
        <div class="admin">
            <h1 class="title">新闻类别管理<a href="main.jsp" class="back-btn">返回主页</a></h1>
            <table class="tab" cellspacing="0">
                <tr>
                    <td style="width: 40px">选择</td>
                    <td class="text-center">序号</td>
                    <td class="text-center">类别名称</td>
                    <td class="text-center">排序权重</td>
                </tr>
                <%
                    ActionBean actionBean = new ActionBean();
                    out.println(actionBean.queryNavAll());
                %>
                <tr>
                    <td colspan="2" style="border-bottom: 0px"><a class="btn" href="addNav.jsp">增加类别</a></td>
                    <td style="border-bottom: 0px"><a class="btn" href="javascript:void(0)" id="update-btn"
                                                      onclick="updateNav()">修改</a></td>
                    <td style="border-bottom: 0px"><a class="btn"
                                                      href="javascript:void(0)"
                                                      id="delete-btn"
                                                      onclick="deleteNav()">删除</a></td>
                    </td>
                </tr>
                </tr>
            </table>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
<div class="win-box" id="win-box">
    <h3 class="win-title">修改新闻类别<span onclick="closeNavWindow(0)">&times;</span></h3>
    <iframe src="url" id="update-win"></iframe>


</div>
<script type="text/javascript">
    function selectedRow() {
        var ms = document.getElementsByName("rad");
        var obj = null;
        for (var i = 0; i < ms.length; i++) {
            if (ms[i].checked) {
                obj = ms[i];
                break;
            }
        }
        if (null == obj) {
            alert("^_^ 请选择一行再操作。");
        }
        return obj;
    }
    function updateNav() {
        var obj = selectedRow();
        if (obj == null) {
            return;
        }

        updateNavWindow("editNav.jsp?nav_id=" + obj.value);


    }
    function deleteNav() {
        var obj = selectedRow();
        if (obj == null) {
            return;
        }
        if (confirm("您确认要删除当前类别吗？")) {
            location = "DeleteNav?nav_id=" + obj.value;
        }
    }
    function updateNavWindow(url) {
        document.getElementById("win-box").style.display="block";
        document.getElementById("update-win").src=url;

    }
    function closeNavWindow(f) {
        document.getElementById("win-box").style.display="none";
        if(f==1){
            location=location;
        }
    }

</script>
</body>
</html>
