<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/jsp/base.jsp" %>

    <script type="text/javascript">

        $(function () {
            makeAlert($("#mainAlert"));

            $("#watch").click(function () {
                $.ajax({
                    type: "POST",
                    cache: "false",
                    url: "video/get/video/" + $("#password").val() + ".do",
                    data: {url: $("#url").val()},
                    dataType: "json",
                    error: function () {//请求失败时调用函数。
                        showAlert($("#postUserAlert"), "danger");
                    },
                    success: function (result) {
                        if (result.status == 1) {
                            $("#videoIfame").prop("src", result.data);
                        } else {
                            showAlert($("#mainAlert"), "warning", result.message);
                        }
                    }
                });
            });
        });


        function reinitIframe() {
            var iframe = document.getElementById("right");
            try {
                var bHeight = iframe.contentWindow.document.body.scrollHeight;
                var dHeight = iframe.contentWindow.document.documentElement.scrollHeight;
                var height = Math.max(bHeight, dHeight);
                iframe.height = height;
            } catch (ex) {
            }
        }

        window.setInterval("reinitIframe()", 200);

        !function ($) {
            $(document).on("click", "ul.nav li.parent > a", function () {
                $(this).find('em:first').toggleClass("glyphicon-minus");
            });
            $(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
        }(window.jQuery);

        $(window).on('resize', function () {
            if ($(window).width() > 768) $('#sidebar-collapse').collapse('show')
        });
        $(window).on('resize', function () {
            if ($(window).width() <= 767) $('#sidebar-collapse').collapse('hide')
        })

    </script>
</head>

<body>

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">输入要观看的VIP视频地址（现已支持各大视频网站）</div>
                <div class="panel-body">
                    <div class="col-md-6">
                        <form role="form">
                            <div class="form-group">
                                <label>视频地址（请先从您要观看的视频网络获取地址）</label>
                                <input class="form-control" id="url" name="url" placeholder="如：http://www.iqiyi.com/v_19rra0fgdw.html?fc=8b62d5327a54411b#vfrm=19-9-0-1">
                                <label>观看密码</label>
                                <input type="password" class="form-control" id="password" name="password" placeholder="请联系331527770@qq.com获取密码">
                            </div>
                            <div class="form-group">
                                <button type="button" class="btn btn-primary" id="watch">确定搜索观看</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div><!-- /.col-->
    </div><!-- /.row -->

    <div class="row">
        <div class="col-lg-12">
            <div id="mainAlert" hidden></div>
        </div>
    </div>

    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">视频播放器自动采用高清、超清画质，如网速不够请等待，视频播放器可全屏观看。</div>
                <div class="panel-body">
                    <div class="col-md-6">
                        <div>
                            <iframe src="http://jx.71ki.com/?url=http://v.youku.com/v_show/id_XMTg3MjIxNTc4OA==.html?f=28841819&amp;spm=a2hmv.20024595.yk-slide-236952.5~5~5~5!2~A&amp;from=y1.3-movie-index-11791-24595.236952.1-1"
                                    width="100%" frameborder="0" scrolling="no" onload="this.height=500" id="videoIfame"></iframe>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div><!-- /.row -->

</div><!--/.main-->
</body>
</html>
