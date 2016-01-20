<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: PNLORF
  Date: 2016/1/4
  Time: 13:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>插入信息</title>
</head>
<body>

<form action="testConversionServiceConverter" method="post">
    <!--lastName-email-gender-department.id
    例如：GG-gg@163.com-0-105
    -->
    Employee: <input type="text" name="employee">
    <input type="submit" value="Submit">
</form>
<br><br>
<!--
    1.Why 使用form标签呢？
    可以更快速的开发出表单页面，而且可以更方便的进行表单值的回显
    2.注意：
    可以通过ModelAttribute属性指定绑定的模型属性，
    若没有指定该属性，则默认从request域对象中读取command的表单bean，如果该属性值也不存在，则会发生错误。
-->

<form:form action="${pageContext.request.contextPath}/emp" method="post" modelAttribute="employee">

    <form:errors path="*"></form:errors>
<br>
    <c:if test="${employee.id == null}">
        <!--path属性对应html表单标签的name属性值-->
        LastName:<form:input path="lastName"/>
        <form:errors path="lastName"></form:errors>
    </c:if>
    <c:if test="${employee.id != null}">
        <form:hidden path="id"/>
        <%--对于_method不能使用form:hidden标签，因为ModelAttribute对应的bean中没有_method这个属性--%>
        <input type="hidden" value="PUT" name="_method">
    </c:if>
    <br>
    Email:<form:input path="email"/>
    <form:errors path="email"></form:errors>
    <br>
    <%
        Map<String, String> genders = new HashMap<String, String>();
        genders.put("0", "Female");
        genders.put("1", "Male");
        request.setAttribute("genders", genders);
    %>
    Gender:
    <br>
    <form:radiobuttons path="gender" items="${genders}" delimiter="<br>"/>
    <br>
    Department: <form:select path="department.id" items="${departments}" itemLabel="departmentName" itemValue="id">
</form:select>
    <br>
    <!--
    1.数据类型转换
    2.数据类型格式化
    3.数据校验问题
        1)如何校验？注解？
            ①.使用JSR303验证标准
            ②.加入hibernate validator验证框架的jar包
            ③.在SpringMVC配置文件中添加<mvc:annotation-driven/>
            ④.需要在bean的属性上添加对应的注解
            ⑤.在目标方法bean类型的前面添加@valid注解
        2)验证出错转向到哪一个页面？
            注意：需验证的Bean对象和其绑定的结果对象或错误对象是成对出现的，他们之间不允许出现其他的入参
        3)错误消息？如何显示，如何把错误消息进行国际化？
    -->
    Birth: <form:input path="birth"/>
    <form:errors path="birth"></form:errors>

    <br>
    Salary:<form:input path="salary"/>
    <br>
    <input type="submit" value="Submit">
</form:form>
</body>
</html>
