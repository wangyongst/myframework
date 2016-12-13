/**
 * Created by wangy on 2016-12-02.
 */
$(function () {
    makeAlert($("#alertA"));
  
      $("#chakan").click(
        function () {
            $.ajax({
                type: "POST",
                cache: "false",
                url: "jiankang/caiji/get.do",
                data: {ids: select(), idType: "laorenid"},
                dataType: "json",
                error: function () {//请求失败时调用函数。
                    showAlert($("#alertA"), "danger");
                },
                success: function (result) {
                    if (result.status == 1) {
                        gotojsp("jiankang/qushi/shuju.do?&laorenid=" + result.data.laorenid);
                    } else {
                        showAlert($("#alertA"), "warning", result.message);
                    }
                }
            });
        });
});