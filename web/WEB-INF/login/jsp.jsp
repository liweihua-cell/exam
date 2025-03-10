<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/main" method="post">
    用户名：<input type="text" name="username" value="<%=request.getAttribute("username")%>"><br/>
    密　码：<input type="password" name="password" value="<%=request.getAttribute("password")%>"><br/>
    <input type="submit" value="登录">
</form>
</body>
</html>