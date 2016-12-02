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

            function myLineChart(mychartid, mylineChartData) {
                var chart1 = document.getElementById(mychartid).getContext("2d");
                window.myLine = new Chart(chart1).Line(mylineChartData, {
                    responsive: true
                });
            }

            function create2LineChartData(labels, datas1, datas2) {
                var mylineChartData = {
                    labels: labels,
                    datasets: [
                        {
                            fillColor: "rgba(48, 164, 255,0.2)",
                            strokeColor: "rgba(48, 164, 255,1)",
                            pointColor: "rgba(48, 164, 255,1)",
                            pointStrokeColor: "#fff",
                            pointHighlightFill: "#fff",
                            pointHighlightStroke: "rgba(48, 164, 255,1)",
                            data: datas1
                        },
                        {
                            fillColor: "rgba(48, 164, 255, 0.2)",
                            strokeColor: "rgba(48, 164, 255, 1)",
                            pointColor: "rgba(48, 164, 255, 1)",
                            pointStrokeColor: "#fff",
                            pointHighlightFill: "#fff",
                            pointHighlightStroke: "rgba(48, 164, 255, 1)",
                            data: datas2
                        }
                    ]
                }
                return mylineChartData;
            }

            function create1LineChartData(labels, datas) {
                var mylineChartData = {
                    labels: labels,
                    datasets: [
                        {
                            fillColor: "rgba(48, 164, 255,0.2)",
                            strokeColor: "rgba(48, 164, 255,1)",
                            pointColor: "rgba(48, 164, 255,1)",
                            pointStrokeColor: "#fff",
                            pointHighlightFill: "#fff",
                            pointHighlightStroke: "rgba(48, 164, 255,1)",
                            data: datas
                        }
                    ]
                }
                return mylineChartData;
            }

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

            function isSelect() {
                if (select() == "") {
                    $("#alertA").show();
                    $("#messageA").text("请选择两条以上记录，以形成健康趋势图！");
                }
            }

            $("#xueya").click(
                    function () {
                        isSelect();
                        var time = new Array();
                        var gaoya = new Array();
                        var diya = new Array();
                        $("input[name=toolbar1]").each(function () {
                            if ($(this).context.checked) {
                                var index = $("table input:checkbox").index(this);
                                time.push($("table").find("tr").eq(index).find("td").eq(11).text() + "");
                                gaoya.push($("table").find("tr").eq(index).find("td").eq(3).text() + "");
                                diya.push($("table").find("tr").eq(index).find("td").eq(4).text() + "");
                            }
                        });
                        $("#linechartitle").text("血压趋势图");
                        myLineChart("line-chart", create2LineChartData(time, gaoya, diya))
                    });

            $("#xueyang").click(
                    function () {
                        isSelect();
                        var time = new Array();
                        var xueyang = new Array();
                        $("input[name=toolbar1]").each(function () {
                            if ($(this).context.checked) {
                                var index = $("table input:checkbox").index(this);
                                time.push($("table").find("tr").eq(index).find("td").eq(11).text() + "");
                                xueyang.push($("table").find("tr").eq(index).find("td").eq(7).text() + "");
                            }
                        });
                        $("#linechartitle").text("血氧趋势图");
                        myLineChart("line-chart", create1LineChartData(time, xueyang))
                    });

            $("#tizhaong").click(
                    function () {
                        isSelect();
                        var time = new Array();
                        var tizhaong = new Array();
                        $("input[name=toolbar1]").each(function () {
                            if ($(this).context.checked) {
                                var index = $("table input:checkbox").index(this);
                                time.push($("table").find("tr").eq(index).find("td").eq(11).text() + "");
                                tizhaong.push($("table").find("tr").eq(index).find("td").eq(8).text() + "");
                            }
                        });
                        $("#linechartitle").text("体重趋势图");
                        myLineChart("line-chart", create1LineChartData(time, tizhaong))
                    });

            $("#xuetang").click(
                    function () {
                        isSelect();
                        var time = new Array();
                        var xuetang = new Array();
                        $("input[name=toolbar1]").each(function () {
                            if ($(this).context.checked) {
                                var index = $("table input:checkbox").index(this);
                                time.push($("table").find("tr").eq(index).find("td").eq(11).text() + "");
                                xuetang.push($("table").find("tr").eq(index).find("td").eq(5).text() + "");
                            }
                        });
                        $("#linechartitle").text("血糖趋势图");
                        myLineChart("line-chart", create1LineChartData(time, xuetang))
                    });

            $("#maibo").click(
                    function () {
                        isSelect();
                        var time = new Array();
                        var maibo = new Array();
                        $("input[name=toolbar1]").each(function () {
                            if ($(this).context.checked) {
                                var index = $("table input:checkbox").index(this);
                                time.push($("table").find("tr").eq(index).find("td").eq(11).text() + "");
                                maibo.push($("table").find("tr").eq(index).find("td").eq(6).text() + "");
                            }
                        });
                        $("#linechartitle").text("脉博趋势图");
                        myLineChart("line-chart", create1LineChartData(time, maibo))
                    });

            $("#shenggao").click(
                    function () {
                        isSelect();
                        var time = new Array();
                        var shenggao = new Array();
                        $("input[name=toolbar1]").each(function () {
                            if ($(this).context.checked) {
                                var index = $("table input:checkbox").index(this);
                                time.push($("table").find("tr").eq(index).find("td").eq(11).text() + "");
                                shenggao.push($("table").find("tr").eq(index).find("td").eq(9).text() + "");
                            }
                        });
                        $("#linechartitle").text("身高趋势图");
                        myLineChart("line-chart", create1LineChartData(time, shenggao))
                    });

            $("#bmi").click(
                    function () {
                        isSelect();
                        var time = new Array();
                        var bmi = new Array();
                        $("input[name=toolbar1]").each(function () {
                            if ($(this).context.checked) {
                                var index = $("table input:checkbox").index(this);
                                time.push($("table").find("tr").eq(index).find("td").eq(11).text() + "");
                                bmi.push($("table").find("tr").eq(index).find("td").eq(10).text() + "");
                            }
                        });
                        $("#linechartitle").text("趋势图");
                        myLineChart("line-chart", create1LineChartData(time, bmi))
                    });


            $("#closeA").click(
                    function () {
                        $("#alertA").hide();
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

                <div class="row" id="alertA" hidden>
                    <div class="col-lg-12">
                        <div class="alert bg-warning" role="alert">
                            <span class="glyphicon glyphicon-warning-sign"></span> <span id="messageA"></span><a
                                id="closeA"
                                class="pull-right"><span
                                class="glyphicon glyphicon-remove"></span></a>
                        </div>
                    </div>
                </div>


                <button type="button" class="btn btn-primary" id="xueya">血压趋势</button>
                <button type="button" class="btn btn-primary" id="xueyang">血氧趋势</button>
                <button type="button" class="btn btn-primary" id="maibo">脉博趋势</button>
                <button type="button" class="btn btn-primary" id="tizhaong">体重趋势</button>
                <button type="button" class="btn btn-primary" id="xuetang">血糖趋势</button>
                <button type="button" class="btn btn-primary" id="shenggao">身高趋势</button>
                <button type="button" class="btn btn-primary" id="bmi">BMI趋势</button>

                <table data-toggle="table" data-url="jiankang/allCaijis.do?laorenid=${laorenid}"
                       data-show-refresh="true"
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
            </div>
        </div>
    </div>
</div><!--/.row-->

<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading" id="linechartitle"></div>
            <div class="panel-body">
                <div class="canvas-wrapper">
                    <canvas class="main-chart" id="line-chart" height="200" width="600"></canvas>
                </div>
            </div>
        </div>
    </div>
</div><!--/.row-->

</body>

</html>
