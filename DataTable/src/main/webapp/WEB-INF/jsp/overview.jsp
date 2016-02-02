<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>DataTable</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
    <meta name="keywords" content=""/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery.dataTables.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/dataTables.bootstrap.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/dataTables.tableTools.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/mh_css.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/ace.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/ace-rtl.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/ace-skins.min.css"/>

    <script src="${pageContext.request.contextPath}/resources/js/jquery-2.0.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery.dataTables.bootstrap.js"></script>
    <%--<script src="${pageContext.request.contextPath}/resources/js/jquery.dataTables.min.js"></script>--%>
    <script src="${pageContext.request.contextPath}/resources/js/jquery.dataTables1.10.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/ace-extra.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/ace-elements.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/ace.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/typeahead-bs2.min.js"></script>
</head>
<%--<script type="text/javascript">
    $.ajax({
        async: false,
        cache: false,
        type: 'POST',
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        url: "${ctx}/tag/getProvinceList",//请求的action路径
        error: function () {//请求失败处理函数
            alert('请求失败');
        },
        success: function (data) {
            if (data != "" && data != undefined && data != null) {
                var htmlString = "<option value=''" + ">" + "请选择" + "</option>";
                var provinceMap = data['provinceMap'];
                for (var province in provinceMap) {
                    htmlString += ' <option  value =' + province + '>' + provinceMap[province] + '</option>';
                }
                $("#province").empty().append(htmlString);
            }
        }
    });

</script>--%>
<body>
<div class="container">
    <%-- <h2 class="mh_title">按地区统计</h2>
     <div class="select">
         <select name="province" id="province">
         </select>
         <input type="hidden" name="tagLevel" id="tagLevel" value="1">
         <input type="hidden" name="tagId" id="tagId" value="">
         <button class="btn btn-sm btn-primary" id="provinceButton">确定</button>
     </div>
     <div class="mh_text">
         <p id="info" hidden>地区：浙江 &nbsp; 用户总数：1234 &nbsp; 标签用户总数：321</p>
     </div>--%>
    <div class="mh_devider"></div>
    <h2 class="mh_title" style="font-size: 24px; font-weight: bold">省市街道列表</h2>
    <input type="hidden" name="selectId" id="selectId" value="">
    <input type="hidden" name="selectInfo" id="selectInfo" value="province">
    <div class="mh_tag">
        <div class="mh_tag1">
            <table class="table table-striped table-bordered table-hover center" id="first_tag">
                <thead>
                <tr>
                    <th>省Id</th>
                    <th>省</th>
                </tr>
                </thead>
                <tbody></tbody>
            </table>
        </div>
        <div class="mh_tag1">
            <table class="table table-striped table-bordered table-hover center" id="second_tag">
                <thead>
                <tr>
                    <th>市Id</th>
                    <th>市</th>
                </tr>
                </thead>
                <tbody></tbody>
            </table>
        </div>
        <div class="mh_tag1">
            <table class="table table-striped table-bordered table-hover center" id="third_tag">
                <thead>
                <tr>
                    <th>街道Id</th>
                    <th>街道</th>
                </tr>
                </thead>
                <tbody></tbody>
            </table>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    var url = "${ctx}/springMVC/dataTable/getAddressInfo";
    //dataTable列表
    $(function () {

        var templateTable = {
            "sDom": "<'table_top'>r<'row-fluid'<'row-fluid footer'>>",
            "sPaginationType": "bootstrap",
            "oLanguage": {
//                "sLengthMenu": "每页显示_MENU_条",
//                "sEmptyTable": "Overriding value ...",
                "sEmptyTable": "没有数据",
//                "sInfo": "共_PAGES_页",
//                "sInfoFiltered": ""
            },
            "bSort": false,
            "bProcessing": true, // 是否显示取数据时的那个等待提示
            "bServerSide": true,//这个用来指明是通过服务端来取数据
            "fnServerParams": function (aoData) {
                var a = $("#select_search").val()
                aoData.push({"name": "search_type", "value": a});
                var selectId = $("#selectId").val();
                aoData.push({"name": "selectId", "value": selectId});
                var selectInfo = $("#selectInfo").val();
                aoData.push({"name": "selectInfo", "value": selectInfo});
            },
            "sAjaxSource": url,//这个是请求的地址
            "aoColumns": [
                {
                    "mDataProp": "id",
                    "sClass": "center",
                    "bSortable": false,
                    "mRender": function (dataOne, data, full) {
                        if (!!dataOne) {
                            if (dataOne.length > 30) {
                                return dataOne.substr(0, 30);
                            } else {
                                return dataOne;
                            }
                        }
                    },
                    "sWidth": "50%"
                },
                {
                    "mDataProp": "name",
                    "sClass": "center",
                    "sWidth": "50%",
                    "bSortable": false,
                    "mRender": function (dataOne, data, full) {
                        if (!!dataOne) {
                            if (dataOne.length > 30) {
                                return dataOne.substr(0, 30);
                            } else {
                                return dataOne;
                            }
                        }
                    }
                }
            ],
//            "aoColumnDefs":[
//                {aTargets:[2], bVisible:false}
//            ],
            "fnServerData": function (url, aoData, fnCallback) {
                $.ajax({
                    url: url,//这个就是请求地址对应sAjaxSource
                    data: aoData,//这个是把datatable的一些基本数据传给后台,比如起始位置,每页显示的行数
                    type: 'post',
                    dataType: 'json',
                    async: false,
                    success: function (result) {
                        fnCallback(result);//把返回的数据传给这个方法就可以了,datatable会自动绑定数据的
                    },
                    error: function (msg) {
                    }
                });
            },
            "fnRowCallback": function (nRow, aData, iDisplayIndex, iDisplayIndexFull) {
                nRow.setAttribute("id", aData.id);
                nRow.setAttribute("style", "");
            }
        };
        var dataTable = $('#first_tag').dataTable(templateTable);
        var dataTable2 = null;
        var dataTable3 = null;

        $('#first_tag tbody').on('click', 'tr', function () {
            var tagId = this.id;
            if (tagId == "") {
                return false;
            }
            var tds = $("td[style='background-color: rgb(136, 212, 149);']");
            tds.each(function () {
                this.style.backgroundColor = "";
            });

            var cells = this.cells;
            for (var i = 0; i < cells.length; i++) {
                cells[i].style.backgroundColor = "#88D495";
            }
            $("#selectInfo").val('city');
            $("#selectId").val(tagId);
            if (dataTable2 == null) {
                dataTable2 = $("#second_tag").dataTable(templateTable);
            } else {
                dataTable2.api().ajax.reload();
            }
            if (dataTable3 != null) {
                $("#third_tag tbody").empty();
            }
        });

        $('#second_tag tbody').on('click', 'tr', function () {
            var tagId = this.id;
            if (tagId == "") {
                return false;
            }
            var tds = $("td[style='background-color: rgb(136, 212, 148);']");
            tds.each(function () {
                this.style.backgroundColor = "";
            });

            var cells = this.cells;
            for (var i = 0; i < cells.length; i++) {
                cells[i].style.backgroundColor = "#88D494";
            }
            $("#selectInfo").val('district');
            $("#selectId").val(tagId);
            if (dataTable3 == null) {
                dataTable3 = $("#third_tag").dataTable(templateTable);
            } else {
                dataTable3.api().ajax.reload();
            }
        });
    });
</script>