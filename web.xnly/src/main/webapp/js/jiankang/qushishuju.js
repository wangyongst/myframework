/**
 * Created by wangy on 2016-12-02.
 */
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
                    time.push($("table").find("tr").eq(index).find("td").eq(12).text() + "");
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
                    time.push($("table").find("tr").eq(index).find("td").eq(12).text() + "");
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
                    time.push($("table").find("tr").eq(index).find("td").eq(12).text() + "");
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
                    time.push($("table").find("tr").eq(index).find("td").eq(12).text() + "");
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
                    time.push($("table").find("tr").eq(index).find("td").eq(12).text() + "");
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
                    time.push($("table").find("tr").eq(index).find("td").eq(12).text() + "");
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
                    time.push($("table").find("tr").eq(index).find("td").eq(12).text() + "");
                    bmi.push($("table").find("tr").eq(index).find("td").eq(10).text() + "");
                }
            });
            $("#linechartitle").text("趋势图");
            myLineChart("line-chart", create1LineChartData(time, bmi))
        });

    $("#huxi").click(
        function () {
            isSelect();
            var time = new Array();
            var bmi = new Array();
            $("input[name=toolbar1]").each(function () {
                if ($(this).context.checked) {
                    var index = $("table input:checkbox").index(this);
                    time.push($("table").find("tr").eq(index).find("td").eq(12).text() + "");
                    bmi.push($("table").find("tr").eq(index).find("td").eq(11).text() + "");
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