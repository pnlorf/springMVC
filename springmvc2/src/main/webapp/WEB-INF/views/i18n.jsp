<%--
  Created by IntelliJ IDEA.
  User: PNLORF
  Date: 2016/1/21
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <fmt:setLocale value="zh"/>
    <fmt:message key="i18n.password"></fmt:message>
    <br><br>
    <a href="i18n2">I18n2 page</a>

    <br><br>
    <a href="i18n?locale=zh_CN">中文</a>


    <br><br>
    <a href="i18n?locale=en_US">英文</a>



</body>
</html>
