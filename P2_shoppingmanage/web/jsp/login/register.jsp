<%--
  Created by IntelliJ IDEA.
  User: wskyt
  Date: 2017/5/2
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/navbar.jsp"%>
<%
    String path =  request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>注册</title>
</head>
<body>
    <jsp:useBean id="userBean" class="pojo.User" scope="request"/>
    <% request.setCharacterEncoding("utf-8");%>
    <div align="center" style="margin-top: 100px">
        <form action="<%=path%>/control/HandleRegister" method="post">
            <table border="1" cellspacing="1" cellpadding="10">
                <tr>
                    <td>用户姓名：<input name="username" placeholder="*必填"></td>
                    <td>用户密码：<input type="password" name="password" placeholder="*必填"></td>
                </tr>
                <tr>
                    <td>重复密码：<input type="password" name="password2" placeholder="*必填"></td>
                    <td>联系电话：<input type="tel" name="telephone" placeholder="*选填"></td>
                </tr>
                <tr>
                    <td>邮寄地址：<input type="text" name="address" placeholder="*选填"></td>
                    <td>真实姓名：<input type="text" name="realname" placeholder="*选填"></td>
                </tr>
                <tr>
                    <td>状态：<font color="red"><jsp:getProperty name="userBean" property="backNews"/></font></td>
                    <td><input type="submit" name="submit" value="确定"></td>
                </tr>
            </table>
        </form>
    </div>


</body>
</html>
