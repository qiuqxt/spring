<%--
  Created by IntelliJ IDEA.
  User: XT
  Date: 2021/5/21
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int res = (int) request.getAttribute("res");
%>
<html>
<head>
    <title>结果页面</title>
</head>
<body>
    result.jsp：注册成功
    <p><%=res%></p>
</body>
</html>
