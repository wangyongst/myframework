/**
 * Created by wangy on 2016-12-02.
 */
$(function () {
    makeAlert($("#mainAlert"));

    $("#chakan").click(
        function () {
            $.ajax({
                type: "GET",
                cache: "false",
                url: "xitong/get/laoren/" + select() + ".do",
                dataType: "json",
                error: function () {//请求失败时调用函数。
                    showAlert($("#mainAlert"), "danger");
                },
                success: function (result) {
                    if (result.status == 1) {
                       window.location.href = "menu/jiankang/caiji/3/"+result.data.id+".do";
                    } else {
                        showAlert($("#mainAlert"), "warning", result.message);
                    }
                }
            });
        });
});