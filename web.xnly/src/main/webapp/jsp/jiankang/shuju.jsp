<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>西宁乐缘综合养老管理平台 - ${title}</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/datepicker3.css" rel="stylesheet">
    <link href="css/bootstrap-table.css" rel="stylesheet">
    <link href="css/styles.css" rel="stylesheet">

    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->

    <script src="js/jquery-1.11.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/chart.min.js"></script>
    <script src="js/chart-data.js"></script>
    <script src="js/easypiechart.js"></script>
    <script src="js/easypiechart-data.js"></script>
    <script src="js/bootstrap-datepicker.js"></script>
    <script src="js/bootstrap-table.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#alertA").hide();
            $("#alertB").hide();
            $("#saveData").click(
                    function () {
                        $.ajax({
                            type: "POST",
                            cache: "false",
                            url: "jiankang/caiji/edit.do",
                            data: $('#form').serialize() + "&laorenid=" + $('#laorenid').val() + "&laorennameR=" + $('#laorenname').val() + "&id=" + $('#id').val(),
                            dataType: "json",
                            error: function () {//请求失败时调用函数。
                                $("#alertB div div").attr("class", "alert bg-danger");
                                $("#alertB").show();
                                $("#messageB").text("操作失败，请检查您的输入，如有问题请联系管理员！");
                            },
                            success: function (result) {
                                if (result.status == 1) {
                                    $('#myModal').modal('toggle');
                                    $("#alertB").hide();
                                    $("#alertA").show();
                                    $("#messageA").text(result.message);
                                    $("button[name='refresh']").click();
//debugger;
                                } else {
                                    $("#alertB").show();
                                    $("#messageB").text(result.message);
                                }
                            }
                        });
                    });
            function select() {
                var ids = "";
                $("input[name=toolbar1]").each(function () {
                    if ($(this).context.checked) {
                        var index = $("table input:checkbox").index(this);
                        val = $("table").find("tr").eq(index).find("td").eq(1).text();
                        ids += "," + val;
                    }
                });
                return ids;
            }

            function showModal(caiji, type) {
                $('#idInput').hide();
                $('#idLabel').hide();
                $('#laorenidInput').attr("readonly", "readonly");
                $('#laorennameInput').attr("readonly", "readonly");
                $('#myModal').find('.modal-title').text('管理老人健康数据');
                <c:forEach var="item" items="${formColumns}">
                if (caiji != null) {
                    $("#${item.columnname}Input").val(caiji.${item.columnname});
                } else {
                    $("#${item.columnname}Input").val("");
                }
                $("#${item.columnname}Input").attr("placeholder", "请输入老人的${item.chinese}");
                </c:forEach>
                $('#myModal').modal('toggle');
                $("#alertB").hide();
            }


            $("#xiugai").click(
                    function () {
                        $.ajax({
                            type: "POST",
                            cache: "false",
                            url: "jiankang/caiji/get.do",
                            data: {ids: select(), idType: "caijiid"},
                            dataType: "json",
                            error: function () {//请求失败时调用函数。
                                $("#alertA").show();
                                $("#messageA").text("操作失败，请联系管理员！");
                            },
                            success: function (result) {
                                if (result.status == 1) {
                                    showModal(result.data, 1);
                                } else {
                                    $("#alertA").show();
                                    $("#messageA").text(result.message);
                                }

                            }
                        });
                    });
            $("#shanchu").click(
                    function () {
                        $.ajax({
                            type: "POST",
                            cache: "false",
                            url: "jiankang/caiji/delete.do",
                            data: {ids: select()},
                            dataType: "json",
                            error: function () {//请求失败时调用函数。
                                $("#alertA").show();
                                $("#messageA").text("操作失败，请联系管理员！");
                            },
                            success: function (result) {
                                $("#alertA").show();
                                $("#messageA").text(result.message);
                                $("button[name='refresh']").click();
                            }
                        });
                    });

            $("#closeA").click(
                    function () {
                        $("#alertA").hide();
                    });
            $("#closeB").click(
                    function () {
                        $("#alertB").hide();
                    });

        });
    </script>
</head>

<body style="padding-top:0px">

<div class="row">
    <ol class="breadcrumb">
        <li><a href="user/home.do"><span class="glyphicon glyphicon-home"></span></a></li>
        <li class="active">${title}</li>
    </ol>
</div><!--/.row-->

<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">${tableName}</div>
            <div class="panel-body">

                <div class="row" id="alertA">
                    <div class="col-lg-12">
                        <div class="alert bg-warning" role="alert">
                            <span class="glyphicon glyphicon-warning-sign"></span> <span id="messageA"></span><a
                                id="closeA"
                                class="pull-right"><span
                                class="glyphicon glyphicon-remove"></span></a>
                        </div>
                    </div>
                </div>


                <button type="button" class="btn btn-primary" id="xiugai">修改数据</button>
                <button type="button" class="btn btn-primary" id="shanchu">删除数据</button>

                <table data-toggle="table" data-url="jiankang/allCaijis.do" data-show-refresh="true"
                       data-show-toggle="true" data-show-columns="true" data-search="true"
                       data-select-item-name="toolbar1" data-pagination="true" data-sort-name="${tableColumns}"
                       data-sort-order="desc" id="laorenTable">
                    <thead>
                    <tr>
                        <th data-field="state" data-checkbox="true"></th>
                        <c:forEach var="item" items="${tableColumns}">
                            <th data-field="${item.columnname}" data-sortable="true">${item.chinese}</th>
                        </c:forEach>
                    </tr>
                    </thead>
                </table>


                <!-- Modal -->
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                        aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title" id="myModalLabel"></h4>
                            </div>
                            <div class="modal-body">
                                <form id="form">
                                    <div class="form-group">
                                        <c:forEach var="item" items="${tableColumns}">
                                            <label for="${item.columnname}"
                                                   class="control-label"
                                                   id="${item.columnname}Label">${item.chinese}</label>
                                            <input type="${item.type}" class="form-control"
                                                   id="${item.columnname}Input" name="${item.columnname}">

                                        </c:forEach>
                                    </div>
                                </form>
                            </div>

                            <div class="row" id="alertB">
                                <div class="col-lg-12">
                                    <div class="alert bg-warning" role="alert">
                                        <span class="glyphicon glyphicon-warning-sign"></span> <span
                                            id="messageB"></span><a
                                            id="closeB"
                                            class="pull-right"><span
                                            class="glyphicon glyphicon-remove"></span></a>
                                    </div>
                                </div>
                            </div>

                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                <button type="button" class="btn btn-primary" id="saveData">保存</button>
                            </div>
                        </div>
                    </div>
                </div><!-- Modal -->


            </div>
        </div>
    </div>
</div><!--/.row-->

</body>

</html>
