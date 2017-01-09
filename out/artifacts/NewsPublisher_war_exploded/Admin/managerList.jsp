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
            <h1 class="title">管理员信息列表<a href="main.jsp" class="back-btn">返回主页</a></h1>
            <table class="tab" cellspacing="0">
                <tr>
                    <td style="width: 40px" >选择</td>
                    <td class="text-center">序号</td>
                    <td class="text-center">登录账号</td>
                    <td class="text-center">真实姓名</td>

                </tr>
                <%
                    ActionBean actionBean = new ActionBean();
                    out.println(actionBean.queryManagerAll());
                %>
                <tr>
                    <td colspan="2" style="border-bottom: 0px"><a class="btn" href="addManager.jsp">增加管理员</a></td>
                    <td style="border-bottom: 0px"><a class="btn" href="javascript:void(0)" id="update-btn"
                                                      onclick="updateManager()">修改</a></td>
                    <td style="border-bottom: 0px"><a class="btn"
                                                      href="javascript:void(0)"
                                                      id="delete-btn"
                                                      onclick="deleteManager()">删除</a></td>
                    </td>
                </tr>
                </tr>
            </table>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
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
    function updateManager() {
        var obj = selectedRow();
        if (obj == null)return;
        location = "editManager.jsp?manager_id=" + obj.value;
    }
    function deleteManager() {
        var obj = selectedRow();
        if (obj == null)return;
        if (confirm("您确认要删除当前用户吗？")) {
            location = "DeleteManager?manager_id=" + obj.value;
        }
    }

</script>
</body>
</html>
