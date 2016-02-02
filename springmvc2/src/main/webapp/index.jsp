<html>
<script type="text/javascript" src="scripts/jquery-2.1.4.min.js"></script>
<script type="text/javascript">
    $(function () {
        $("#testJson").click(function () {
            var url = this.href;
            var args = {};
            $.post(url, args, function (data) {
                for (var i = 0; i < data.length; i++) {
                    var id = data[i].id;
                    var lastName = data[i].lastName;
                    alert(id + "==" + lastName)
                }
            });
            return false;
        });
    })
</script>
<body>
<h2>Hello World!</h2>

<form action="testFileUpload" method="post" enctype="multipart/form-data">
    File: <input type="file" name="file">
    Desc: <input type="text" name="desc">
    <input type="submit" value="Submit">
</form>

<br><br>
<a href="emps">List All Employees</a>

<br><br>
<a href="testJson" id="testJson">Test Json</a>

<br>
<form action="testHttpMessageConverter" method="post" enctype="multipart/form-data">
    File: <input type="file" name="file">
    Desc: <input type="text" name="desc">
    <input type="submit" value="Submit">
</form>

<br>
<br>
<a href="testResponseEntity">Test ResponseEntity</a>

<!--
    关于国际化：
        1.在页面上能够根据浏览器语言设置的情况对文本(不是北荣)，时间，数值进行本地化处理
        2.可以在bean中获取国际化资源文件Local对应的消息
        3.可以通过超链接切换Locale而不再依赖于浏览器的语言设置情况
    解决：
        1.使用JSTL的fmt标签
        2.在bean中注入ResourceBundleMessageSource的实例，使用其对应的getMessage方法即可
        3.配置LocalResolver和LocaleChangeInterceptor
-->

<br><br>
<a href="i18n">I18n page</a>

<br><br>
<a href="testExceptionHandlerExceptionResolver?i=10">Test ExceptionHandlerExceptionResolver</a>
</body>
</html>
