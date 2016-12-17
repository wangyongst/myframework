/**
 * Created by wangy on 2016-12-02.
 */
$(function () {
    makeAlert($("#mainAlert"));

    $("#chakan").click(
        function () {
            $.ajax({
                type: "POST",
                cache: "false",
                url: "xitong/get/laoren/" + select() + ".do",
                dataType: "json",
                error: function () {//请求失败时调用函数。
                    showAlert($("#alertA"), "danger");
                },
                success: function (result) {
                    if (result.status == 1) {
                        gotojsp("menu/jiankang/qushi/shuju.do?&laorenid=" + result.data.laorenid);
                    } else {
                        showAlert($("#alertA"), "warning", result.message);
                    }
                }
            });
        });
});