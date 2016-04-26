<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false"%>
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
    <title>Forms</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/datepicker3.css" rel="stylesheet">
    <link href="css/styles.css" rel="stylesheet">


    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
    <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#alert").hide();
            $("#login").click(
                    function () {
                        var name = $('input[name="email"]').val();
                        var pass = $('input[name="password"]').val();
                        //alert(name+pass)
                        // 提交到后台进行验证
                        $.ajax({
                            type: "GET",
                            cache: "false",
                            url: "user/login.do",
                            data: "username=" + name + "&password=" + pass,//发送到服务器的数据
                            dataType: "json",
                            //async : false,
                            error: function () {//请求失败时调用函数。
                                //$("#msg").html("请求失败!");
                            },
                            success: function (result) {
                                if (result.status == 1 || result.status == 2) {
                                    $("#alert").show();
                                    $("#message").text(result.message);
                                } else {
                                    window.location.href = "user/home.do";
                                }
                            }
                        });
                        return false;
                    })
            $("#closeA").click(
                    function () {
                        $("#alert").hide();
                    });
        });

    </script>

</head>

<body>

<div class="row" id="alert">
    <div class="col-lg-12">
        <div class="alert bg-warning" role="alert">
            <span class="glyphicon glyphicon-warning-sign"></span> <span id="message"></span><a id="closeA"
                                                                                                class="pull-right"><span
                class="glyphicon glyphicon-remove"></span></a>
        </div>
    </div>
</div>

<div class="row">
    <div class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4">
        <div class="login-panel panel panel-default">
            <div class="panel-heading">欢迎登录本系统，请输入您的用户名及密码！</div>
            <div class="panel-body">
                <form role="form">
                    <fieldset>
                        <div class="form-group">
                            <input class="form-control" placeholder="用户名" name="email" type="text" autofocus="true">
                        </div>
                        <div class="form-group">
                            <input class="form-control" placeholder="密码" name="password" type="password" value="">
                        </div>
                        <div class="checkbox">
                            <label>
                                <input name="remember" type="checkbox" value="Remember Me">Remember Me
                            </label>
                        </div>
                        <a id="login" class="btn btn-primary">登录</a>
                    </fieldset>
                </form>
            </div>
        </div>
    </div><!-- /.col-->
</div><!-- /.row -->


<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/chart.min.js"></script>
<script src="js/chart-data.js"></script>
<script src="js/easypiechart.js"></script>
<script src="js/easypiechart-data.js"></script>
<script src="js/bootstrap-datepicker.js"></script>
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
</body>

</html>
