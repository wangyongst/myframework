<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
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
    <script>

        function reinitIframe() {
            var iframe = document.getElementById("right");
            try {
                var bHeight = iframe.contentWindow.document.body.scrollHeight;
                var dHeight = iframe.contentWindow.document.documentElement.scrollHeight;
                var height = Math.max(bHeight, dHeight);
                iframe.height = height;
                console.log(height);
            } catch (ex) {
            }
        }
        ;

        window.setInterval("reinitIframe()", 200);

        function getRight(url) {
            var iframe = document.getElementById("right").src = url;
        }
        ;

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

</head>

<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#sidebar-collapse">
                <span class="sr-only"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="user/home.do"><span>XININGLEYUAN.COM&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>西宁乐缘综合养老管理平台&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;后台管理中心</a>
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
                <a data-toggle="collapse" href="#sub-item-${item.id}">
                    <span class="glyphicon glyphicon-list"></span> ${item.name}<span data-toggle="collapse"
                                                                                     href="#sub-item-${item.id}"
                                                                                     class="icon pull-right"><em
                        class="glyphicon glyphicon-s glyphicon-plus"></em></span>
                </a>
                <ul class="children collapse" id="sub-item-${item.id}">
                    <c:forEach var="it" items="${children}">
                        <c:if test="${it.parent == item.id}">
                            <li>
                                <a class="" href="javascript:void(0);" onclick="getRight('${it.url}');">
                                    <span class="glyphicon glyphicon-share-alt"></span> ${it.name}
                                </a>
                            </li>
                        </c:if>
                    </c:forEach>
                </ul>
            </c:forEach>
        </li>
        <li role="presentation" class="divider"></li>
    </ul>
</div><!--/.sidebar-->

<iframe class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main" src="./jsp/default_home.jsp" width="100%"
        frameborder="0" scrolling="no" id="right" onload="this.height=800"></iframe>
<!--/.main-->


"↵
<thead>↵
<tr>
    <th class="bs-checkbox " style="width: 36px; ">
        <div class="th-inner "><input name="btSelectAll" type="checkbox"></div>
        <div class="fht-cell"></div>
    </th>
    <th style="">
        <div class="th-inner sortable">ID</div>
        <div class="fht-cell"></div>
    </th>
    <th style="">
        <div class="th-inner sortable">老人姓名</div>
        <div class="fht-cell"></div>
    </th>
    <th style="">
        <div class="th-inner sortable">高压(mmHg)</div>
        <div class="fht-cell"></div>
    </th>
    <th style="">
        <div class="th-inner sortable">低压(mmHg)</div>
        <div class="fht-cell"></div>
    </th>
    <th style="">
        <div class="th-inner sortable">血糖(mmol/L)</div>
        <div class="fht-cell"></div>
    </th>
    <th style="">
        <div class="th-inner sortable">脉博(次/分钟)</div>
        <div class="fht-cell"></div>
    </th>
    <th style="">
        <div class="th-inner sortable">血氧(%)</div>
        <div class="fht-cell"></div>
    </th>
    <th style="">
        <div class="th-inner sortable">体重(KG)</div>
        <div class="fht-cell"></div>
    </th>
    <th style="">
        <div class="th-inner sortable">身高(CM)</div>
        <div class="fht-cell"></div>
    </th>
    <th style="">
        <div class="th-inner sortable">BMI</div>
        <div class="fht-cell"></div>
    </th>
    <th style="">
        <div class="th-inner sortable">呼吸（次/分钟）</div>
        <div class="fht-cell"></div>
    </th>
    <th style="">
        <div class="th-inner sortable">测量时间</div>
        <div class="fht-cell"></div>
    </th>
    <th style="">
        <div class="th-inner sortable">创建人姓名</div>
        <div class="fht-cell"></div>
    </th>
    <th style="">
        <div class="th-inner sortable">创建时间</div>
        <div class="fht-cell"></div>
    </th>
</tr>
↵
</thead>


</body>

</html>
