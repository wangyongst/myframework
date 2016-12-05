/**
 * Created by wangy on 2016-12-02.
 */
$(function () {
    makeAlert($("#alertA"));
  
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

    $("#chakan").click(
        function () {
            $.ajax({
                type: "POST",
                cache: "false",
                url: "jiankang/caiji/get.do",
                data: {ids: select(), idType: "laorenid"},
                dataType: "json",
                error: function () {//请求失败时调用函数。
                    $("#alertA").show();
                    $("#messageA").text("操作失败，请联系管理员！");
                },
                success: function (result) {
                    if (result.status == 1) {
                        gotojsp("jiankang/qushi/shuju.do?&laorenid=" + result.data.laorenid);
                    } else {
                        $("#alertA").show();
                        $("#messageA").text(result.message);
                    }
                }
            });
        });

    $("#closeA").click(
        function () {
            $("#alertA").hide();
        });


});