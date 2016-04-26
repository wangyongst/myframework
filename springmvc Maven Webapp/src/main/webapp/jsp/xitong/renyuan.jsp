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
            $(document).on("click", "ul.nav li.parent > a > span.icon", function () {
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
</head>

<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#sidebar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="user/home.do"><span>sss</span>sss</a>
            <ul class="user-menu">
                <li class="dropdown pull-right">
                    <a href="user/home.do" class="dropdown-toggle" data-toggle="dropdown"><span
                            class="glyphicon glyphicon-user"></span> ${user.name} <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="${profile.url}"><span class="glyphicon glyphicon-user"></span>${profile.name}  </a>
                        </li>
                        <li><a href="${settings.url}"><span class="glyphicon glyphicon-cog"></span> ${settings.name}</a>
                        </li>
                        <li><a href="${logout.url}"><span class="glyphicon glyphicon-log-out"></span> ${logout.name}</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div><!-- /.container-fluid -->
</nav>

<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
    <form role="search">
        <div class="form-group">
            <input type="text" class="form-control" placeholder="Search">
        </div>
    </form>
    <ul class="nav menu">
        <li class="active"><a href="user/home.do"><span class="glyphicon glyphicon-dashboard"></span> 我的首页</a></li>
        <li class="parent ">
            <c:forEach var="item" items="${parent}">
                <c:if test="${item.parent == 0}">
                    <a href="user/home.do">
                        <span class="glyphicon glyphicon-list"></span> ${item.name}<span data-toggle="collapse"
                                                                                         href="#sub-item-${item.id}"
                                                                                         class="icon pull-right"><em
                            class="glyphicon glyphicon-s glyphicon-plus"></em></span>
                    </a>
                    <ul class="children collapse" id="sub-item-${item.id}">
                        <c:forEach var="it" items="${children}">
                            <c:if test="${it.parent == item.id}">
                                <li>
                                    <a class="" href="${it.url}">
                                        <span class="glyphicon glyphicon-share-alt"></span> ${it.name}
                                    </a>
                                </li>
                            </c:if>
                        </c:forEach>
                    </ul>
                </c:if>
            </c:forEach>
        </li>
        <li role="presentation" class="divider"></li>
    </ul>
</div><!--/.sidebar-->

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="user/home.do"><span class="glyphicon glyphicon-home"></span></a></li>
            <li class="active">${title}</li>
        </ol>
    </div><!--/.row-->

    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">${title}</h1>
        </div>
    </div><!--/.row-->

    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">${tableName}</div>
                <div class="panel-body">
                    <table data-toggle="table" data-url="xitong/allRenyuans.do" data-show-refresh="true"
                           data-show-toggle="true" data-show-columns="true" data-search="true"
                           data-select-item-name="toolbar1" data-pagination="true" data-sort-name="name"
                           data-sort-order="desc">
                        <thead>
                        <tr>
                            <th data-field="state" data-checkbox="true"></th>
                            <c:forEach var="item" items="${tableColumns}">
                                <c:if test="${item.columnName == 'id'}">
                                    <th data-field="id" data-sortable="true">ID</th>
                                </c:if>
                                <c:if test="${item.columnName != 'id'}">
                                    <th data-field="${item.columnName}" data-sortable="true">${item.chinese}</th>
                                </c:if>
                            </c:forEach>
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </div>
    </div><!--/.row-->
</div>    <!--/.main-->
</body>

</html>
