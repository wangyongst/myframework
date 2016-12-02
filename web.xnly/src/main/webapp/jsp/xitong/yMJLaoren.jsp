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
    <script>
        !function ($) {
            $(document).on("click", "ul.nav li.parent > a", function () {
                $(this).find('em:first').toggleClass("glyphicon-minus");
            });
            $(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
        }(window.jQuery);

        $(window).on('resize', function () {
            if ($(window).width() > 768) $('#sidebar-collapse').collapse('show')
        })
        $(window).on('resize', function () {
            if ($(window).width() <= 767) $('#sidebar-collapse').collapse('hide')
        })
    </script>
    <script type="text/javascript">
        $(function () {
            $("#alertA").hide();
            $("#alertB").hide();
            $("#saveData").click(
                    function () {
                        $.ajax({
                            type: "POST",
                            cache: "false",
                            url: "xitong/laoren/yMJEdit.do",
                            data: $('#laorenForm').serialize() + "&id=" + $('#idInput').val(),
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

            $("#saveJiashuData").click(
                    function () {
                        $.ajax({
                            type: "POST",
                            cache: "false",
                            url: "xitong/jiashu/edit.do",
                            data: $('#jiashuForm').serialize() + "&laorenid=" + $('#JSlaorenid').val() + "&laorennameR=" + $('#JSlaorenname').val(),
                            dataType: "json",
                            error: function () {//请求失败时调用函数。
                                $("#alertC div div").attr("class", "alert bg-danger");
                                $("#alertC").show();
                                $("#messageC").text("操作失败，请检查您的输入，如有问题请联系管理员！");
                            },
                            success: function (result) {
                                if (result.status == 1) {
                                    $('#jiashuModal').modal('toggle');
                                    $("#alertC").hide();
                                    $("#alertA").show();
                                    $("#messageA").text(result.message);
                                    $("button[name='refresh']").click();
                                    //debugger;
                                } else {
                                    $("#alertC").show();
                                    $("#messageC").text(result.message);
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

            function showModal(laoren, type) {
                $('#idLabel').hide();
                $('#idInput').hide();
                $('#idLabel').hide();
                $('#idInput').hide();
                $("#bingshiCheckbox input[name=bingshi]").each(function () { //遍历table里的全部checkbox
                    $(this).prop("checked", false);
                })
                if (type == 1) {
                    $('#idLabel').show();
                    $('#idInput').show();
                    $('#idInput').attr("readonly", "readonly");
                    $('#myModal').find('.modal-title').text('修改信息');
                } else {

                    $('#myModal').find('.modal-title').text('注册用户信息');
                }
                <c:forEach var="item" items="${formColumns}">
                if (laoren != null) {
                    $("#${item.columnname}Input").val(laoren.${item.columnname});
                } else {
                    $("#${item.columnname}Input").val("");
                }
                $("#${item.columnname}Input").attr("placeholder", "请输入老人的${item.chinese}");
                </c:forEach>
                if(laoren != null && laoren.bingshi !=null){
                    var bin = laoren.bingshi.split(",");
                    for(var x in bin){
                        $("#bingshiCheckbox input[name=bingshi]").each(function(){ //遍历table里的全部checkbox
                            if($(this).val() == bin[x]) { //如果被选中
                                $(this).prop("checked", true);
                            }
                        });
                    }
                }
                $('#myModal').modal('toggle');
                $("#alertB").hide();
            }

            function showJiashuModal(jiashu, type) {
                $('#JSidInput').hide();
                $('#JSidLabel').hide();
                $('#JSlaorenidInput').attr("readonly", "readonly");
                $('#JSlaorennameInput').attr("readonly", "readonly");
                $('#jiashuModal').find('.modal-title').text('添加老人家属信息');
                <c:forEach var="item" items="${jiashuColumns}">
                if (jiashu != null) {
                    $("#JS${item.columnname}Input").val(jiashu.${item.columnname});
                } else {
                    $("#JS${item.columnname}Input").val("");
                }
                $("#JS${item.columnname}Input").attr("placeholder", "请输入老人家属的${item.chinese}");
                </c:forEach>
                $('#jiashuModal').modal('toggle');
                $("#alertC").hide();
            }

            $("#zhuce").click(
                    function () {
                        showModal(null, 0);
                    });

            $("#jiashu").click(
                    function () {
                        $.ajax({
                            type: "POST",
                            cache: "false",
                            url: "xitong/jiashu/get.do",
                            data: {ids: select(), idType: "laorenid"},
                            dataType: "json",
                            error: function () {//请求失败时调用函数。
                                $("#alertA").show();
                                $("#messageA").text("操作失败，请联系管理员！");
                            },
                            success: function (result) {
                                if (result.status == 1) {
                                    showJiashuModal(result.data, 1);
                                } else {
                                    $("#alertA").show();
                                    $("#messageA").text(result.message);
                                }

                            }
                        });
                    });

            $("#xiugai").click(
                    function () {
                        $.ajax({
                            type: "POST",
                            cache: "false",
                            url: "xitong/laoren/get.do",
                            data: {ids: select()},
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
                            url: "xitong/laoren/delete.do",
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

            $("#change").click(
                    function () {
                        $.ajax({
                            type: "POST",
                            cache: "false",
                            url: "xitong/laoren/change.do",
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

            $("#closeC").click(
                    function () {
                        $("#alertC").hide();
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


                <button type="button" class="btn btn-primary" id="zhuce">注册老人信息</button>
                <button type="button" class="btn btn-primary" id="xiugai">修改老人信息</button>
                <button type="button" class="btn btn-primary" id="shanchu">删除老人信息</button>
                <button type="button" class="btn btn-primary" id="jiashu">添加老人家属</button>
                <%--<button type="button" class="btn btn-primary" id="change">移出低收入老人组</button>--%>


                <table data-toggle="table" data-url="xitong/yMJLaorens.do" data-show-refresh="true"
                       data-show-toggle="true" data-show-columns="true" data-search="true"
                       data-select-item-name="toolbar1" data-pagination="true" data-sort-name="${tableColumns}"
                       data-sort-order="desc" id="userTable">
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
                                <form id="laorenForm">
                                    <div class="form-group">
                                        <c:forEach var="item" items="${formColumns}">
                                            <label for="${item.columnname}"
                                                   class="control-label"
                                                   id="${item.columnname}Label">${item.chinese}</label>
                                            <c:choose>
                                                <c:when test="${item.type == 'checkbox'}">
                                                    <c:choose>
                                                        <c:when test="${item.columnname == 'bingshi'}">
                                                            <div class="checkbox" id="${item.columnname}Checkbox">
                                                                <c:forEach var="itemb" items="${bingshi}">
                                                                    <label>
                                                                        <input name="${item.columnname}" type="checkbox" value="${itemb.name}">${itemb.name}
                                                                    </label>
                                                                </c:forEach>
                                                            </div>
                                                        </c:when>
                                                    </c:choose>
                                                </c:when>
                                                <c:otherwise>
                                                    <input type="${item.type}" class="form-control" id="${item.columnname}Input" name="${item.columnname}"/>
                                                </c:otherwise>
                                            </c:choose>
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


                <!-- Modal -->
                <div class="modal fade" id="jiashuModal" tabindex="2" role="dialog" aria-labelledby="jiashuModalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                        aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title" id="jiashuModalLabel"></h4>
                            </div>
                            <div class="modal-body">
                                <form id="jiashuForm">
                                    <div class="form-group">
                                        <c:forEach var="item" items="${jiashuColumns}">
                                            <label for="${item.columnname}"
                                                   class="control-label"
                                                   id="JS${item.columnname}Label">${item.chinese}</label>
                                            <input type="${item.type}" class="form-control"
                                                   id="JS${item.columnname}Input" name="${item.columnname}"/>
                                        </c:forEach>
                                    </div>
                                </form>
                            </div>

                            <div class="row" id="alertC">
                                <div class="col-lg-12">
                                    <div class="alert bg-warning" role="alert">
                                        <span class="glyphicon glyphicon-warning-sign"></span> <span
                                            id="messageC"></span><a
                                            id="closeC"
                                            class="pull-right"><span
                                            class="glyphicon glyphicon-remove"></span></a>
                                    </div>
                                </div>
                            </div>

                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                <button type="button" class="btn btn-primary" id="saveJiashuData">保存</button>
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
