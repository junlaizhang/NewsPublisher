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
    <title>添加管理员</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css">
</head>

<body>
<div class="main-frame">
    <jsp:include page="top.jsp"></jsp:include>
    <jsp:include page="left.jsp"></jsp:include>
    <div class="right">
        <div class="admin">
            <h1 class="title">添加管理员<a href="managerList.jsp" class="back-btn">返回</a></h1>
            <form action="<%=path%>/InsertManager" id="frm" method="post">
                <table>
                    <tr>
                        <td>登录账号：</td>
                        <td><input id="manager_id" name="manager_id" autocomplete="off" maxlength="10" type="text"></td>
                        <td id="err_manager_id"></td>
                    </tr>
                    <tr>
                        <td>真实姓名：</td>
                        <td><input id="manager_name" name="manager_name" autocomplete="off" maxlength="20" type="text">
                        </td>
                        <td id="err_manager_name"></td>
                    </tr>
                    <tr>
                        <td>登录密码：</td>
                        <td><input id="manager_pwd" name="manager_pwd" autocomplete="off" maxlength="50"
                                   type="password"></td>
                        <td id="err_manager_pwd"></td>
                    </tr>
                    <tr>
                        <td>确认密码：</td>
                        <td><input id="re_manager_pwd" name="re_manager_pwd" autocomplete="off" maxlength="50"
                                   type="password">
                        </td>
                        <td id="err_re_manager_pwd"></td>
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
            function valiInput(id, msg, n) {

                var val = document.getElementById(id).value;
                if (val == "" || val.length < n) {
                    document.getElementById("err_" + id).innerHTML = "<span class='err'>" + msg + "</span>";
                    return false;
                } else {
                    document.getElementById("err_" + id).innerHTML = "<span class='success'>验证通过</span>";
                    return true;
                }
            }
            function valiPwd() {
                if (document.getElementById("manager_pwd").value != document.getElementById("re_manager_pwd").value) {
                    document.getElementById("err_re_manager_pwd").innerHTML = "<span class='err'>两次密码输入的不一样</span>";
                    return false;
                }
                return true;

            }

            function startPost() {
                var ipts = ["manager_id", "manager_name", "manager_pwd", "re_manager_pwd"];
                var lens = [3, 2, 6, 6];
                var msg = ["请输入登录账号，至少3位", "请输入真实姓名，至少2位", "请输入登录密码，至少6位", "请输入确认密码，至少6位"];
                var flag = true;
                for (var i = 0; i < ipts.length; i++) {
                    flag = valiInput(ipts[i], msg[i], lens[i]) && flag;
                }
                flag = valiPwd() && flag;
                if (!flag)return;
                document.getElementById("frm").submit();

            }


        </script>
</body>
</html>
