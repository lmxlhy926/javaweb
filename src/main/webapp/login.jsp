<%--
  Created by IntelliJ IDEA.
  User: 78472
  Date: 2022/3/22
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
<form action="http://localhost:8080/javaweb_war_exploded/login" method="get">
    用户名：<input type="text" name="username"/> <br>
    密 码：<input type="password" name="password"/> <br>
    <input type="submit" />
</form>
</body>
</html>
