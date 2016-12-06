<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/jsp/base.jsp"%>
    <script type="text/javascript">

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

<iframe class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main" src="<%=basePath%>user/myhome.do" width="100%"
        frameborder="0" scrolling="no" id="right" onload="this.height=800"></iframe>
<!--/.main-->

</body>

</html>
