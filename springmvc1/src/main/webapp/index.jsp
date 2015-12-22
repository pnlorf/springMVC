<html>
<body>
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
