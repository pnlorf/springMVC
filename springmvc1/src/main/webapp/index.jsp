<html>
<body>

<!--
    模拟修改操作
        1.原始数据为：1，Tom，123456， tom@163.com, 12
        2.密码不能被修改。
        3.表单回显，模拟操作直接在表单填写对应的属性值
-->
<form action="springmvc/testModelAttribute" method="post">
    <input type="hidden" name="id" value="1">
    username: <input type="text" name="username" value="Tom">
    <br>
    email:<input type="text" name="email" value="tom@163.com">
    <br>
    age:<input type="text" name="age" value="25">
    <br>
    <input type="submit" value="Submit">
</form>
<br><br>
<a href="springmvc/testSessionAttributes">Test SessionAttributes</a>
<br><br>
<a href="springmvc/testMap">Test Map</a>
<br><br>
<a href="springmvc/testModelAndView">Test ModelAndView</a>
<br><br>
<a href="springmvc/testServletAPI">Test Servlet API</a>
<br><br>
<form action="springmvc/testPojo" method="post">
    username: <input type="text" name="username">
    <br>
    password:<input type="password" name="password">
    <br>
    email: <input type="text" name="email">
    <br>
    age: <input type="text" name="age">
    <br>
    city: <input type="text" name="address.city">
    <br>
    province: <input type="text" name="address.province">
    <br>
    <input type="submit" value="Submit">
</form>
<br><br>
<a href="springmvc/testCookieValue">Test CookieValue</a>
<br><br>
<a href="springmvc/testRequestHeader">Test RequestHeader</a>
<br><br>
<a href="springmvc/testRequestParam?username=liping&age=11">Test RequestParam</a>

<br><br>
<form action="springmvc/testRest/1" method="post">
    <input type="hidden" name="_method" value="PUT"/>
    <input type="submit" value="Test Rest PUT">
</form>
<br><br>
<form action="springmvc/testRest/1" method="post">
    <input type="hidden" name="_method" value="DELETE"/>
    <input type="submit" value="Test Rest DELETE">
</form>
<br><br>
<form action="springmvc/testRest" method="post">
    <input type="submit" value="Test Rest POST">
</form>
<br><br>
<a href="springmvc/testRest/1">Test Rest Get</a>
<br><br>
<a href="springmvc/testPathVariable/11">Test PathVariable</a>
<br><br>
<a href="springmvc/testAntPath/ant/abc">Test Ant Path</a>
<br>
<a href="springmvc/testParamsAndHeaders?username=liping&age=11">testParamsAndHeaders</a>
<br>
<br>
<form method="post" action="springmvc/testMethod">
    <input type="submit" value="submit"/>
</form>
<br>
<a href="springmvc/testMethod">Test Method</a>
<br>
<a href="springmvc/testRequestMapping">Test RequestMapping</a>
<br>
<a href="helloworld">Hello World!</a>
</body>
</html>