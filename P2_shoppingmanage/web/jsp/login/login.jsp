<%--
  Created by IntelliJ IDEA.
  User: wskyt
  Date: 2017/5/2
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/navbar.jsp"%>
<%@ page import="java.net.URLDecoder" %>
<%@ page import="com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+ request.getServerName() + ":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>登录</title>
</head>
<body>
    <%
        request.setCharacterEncoding("UTF-8");
        String username = "";
        String password = "";
        Cookie[] cookies = null;
        cookies = request.getCookies();
        if (cookies != null && cookies.length > 0){
                for (Cookie c : cookies){
                    if ("username".equals(c.getName())){
                        username = URLDecoder.decode(c.getValue(),"UTF-8");
                    }
                    if ("password".equals(c.getName())){
                        password = URLDecoder.decode(c.getValue(),"UTF-8");
                    }
                }
        }
    %>
    <div align="center" style="margin-top: 100px">
        <form action="<%=path%>/control/HandleLogin" method="post">
            <table border="0" cellpadding="15" cellspacing="1">
                <tr>
                    <td colpan="2">
                        <input name="username" value="<%=username%>" placeholder="username">
                    </td>
                    <td colpan="2">
                        <input type="password" name="password" value="<%=password%>" placeholder="password">
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="checkbox" name="isCookie" value="isCookie" checked="checked">记住用户
                    </td>
                    <td>
                        <input type="submit" vaule="登录">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
