<%--
  Created by IntelliJ IDEA.
  User: 24105
  Date: 2023/9/12
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>login</title>
    <base href="/cs/">
</head>
<body>
<form action="checkLogin" method="post">
    用户名：<input type="text" name="username"/><br/>
    密　码：<input type="password" name="password"/><br/>
    <input type="submit" value="登录">
</form>
</body>
</html>