<%--
  Created by IntelliJ IDEA.
  User: wskyt
  Date: 2017/4/27
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="navbar.jsp"%>
<%
  String path = request.getContextPath();
  String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
    <base href="<%=basepath%>">
    <title>首页</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
  </head>
  <style>

  </style>
  <body>
  <jsp:useBean id="loginBean" class="pojo.Login" scope="session" />
    <ul class="user">
      <li>
        <%
          String str = null;
          str = loginBean.getUsername();
          if (str.equals("userNull") || str == null){
              HttpSession s = request.getSession(true);
              s.invalidate();
        %>
        <div style="margin-top: 100px">
          <a href="jsp/login/login.jsp">登录</a>or<a href="jsp/login/register.jsp">注册</a>
        </div>
        <%
            return;
          }
        %>
        <dl>
          <dt>
            <a>欢迎您，<b><font color="red"><%= str%></font></b></a>
            <a><font color="#cdc9c9">退出</font></a>
          </dt>
        </dl>
      </li>
    </ul>

  </body>
</html>
