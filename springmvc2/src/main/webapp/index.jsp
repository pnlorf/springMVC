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

<br><br>
<a href="emps">List All Employees</a>

<br><br>
<a href="testJson" id="testJson">Test Json</a>
</body>
</html>
