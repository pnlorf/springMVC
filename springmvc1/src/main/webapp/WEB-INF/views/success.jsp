<%--
  Created by IntelliJ IDEA.
  User: PNLORF
  Date: 2015/12/22
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@page isELIgnored="false" %>--%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h4>Success Page</h4>

time: ${requestScope.time}
<br>
time: ${requestScope.get("time")}

<br>
time: <%=request.getAttribute("time")%>

<br>

<br>
time: ${time}

<br><br>
names:${requestScope.names}
</body>
</html>
