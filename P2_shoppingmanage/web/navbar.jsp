<%--
  Created by IntelliJ IDEA.
  User: wskyt
  Date: 2017/5/2
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>导航条</title>
</head>
<style type="text/css">
    *{
        margin: 0;
        padding: 0;
        font-size: 16px;
    }
    body{
        text-align: center;
    }
    .div1{

        margin: 0 auto;/*指定长宽后才有效*/
        width: 800px;
        height: 100px;
        background-color: #159957;
        background-image: linear-gradient(120deg, #155799, #159957);
    }
    .nav{
        list-style: none;
        height: 50px;
        /*border-bottom: 5px solid #159957;*/
        padding-left: 70px;
    }
    .nav li{
        float: left;
        margin-top: 25px;
    }
    .nav li a{
        background-color: #ccc;
        text-decoration: none;
        display: block;
        height: 25px;
        width: 120px;
        margin-right: 5px;
        text-align: center;
    }
    .nav li a.on, .nav li a:hover{
        color: #fff;
        /*background-position: 0 -30px;*/
    }


</style>
<body>
    <div class="div1">
        <ul class="nav">
            <li><a class="on" href="index.jsp">首页</a></li>
            <li><a href="">我的订单</a></li>
            <li><a href="">购物车</a></li>
            <li><a href="">浏览商品</a></li>
            <li><a href="">查询商品</a></li>
        </ul>
    </div>
</body>
</html>
