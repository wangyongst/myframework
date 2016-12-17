/**
 * Created by wangy on 2016-12-02.
 */
$(function () {
    makeModal($("#putCaijiModal"), "putCaiji", "1");

    makeModalColumns($("#putCaijiModal"), "caiji", "putCaiji", "请输入采集老人的");

    makeAlert($("#putCaijiAlert"));
    makeAlert($("#mainAlert"));

    $("#putCaijiSave").click(
        function () {
            $.ajax({
                type: "POST",
                cache: "false",
                url: "jiankang/put/caiji.do?_method=PUT",
                data: $('#putCaijiForm').serialize(),
                dataType: "json",
                error: function () {//请求失败时调用函数。
                    showAlert($("#putCaijiAlert"), "danger");
                },
                success: function (result) {
                    if (result.status == 1) {
                        $('#putCaijiModal').modal('toggle');
                        showAlert($("#mainAlert"), "success", result.message);
                        $("button[name='refresh']").click();
                    } else {
                        showAlert($("#putCaijiAlert"), "warning", result.message);
                    }
                }
            });
        });

    function showPutCaijiModal(laoren) {
        $('#putCaijiidInput').hide();
        $('#putCaijiidLabel').hide();
        $('#putCaijiModal').find("input[class=form-control]").val("");
        $('#putCaijilaorenidInput').attr("readonly", "readonly");
        $('#putCaijilaorennameInput').attr("readonly", "readonly");
        $('#putCaijilaorenidInput').val(laoren.id);
        $('#putCaijilaorennameInput').val(laoren.name);
        $('#putCaijiModal').find('.modal-title').text('采集老人健康数据');
        $('#putCaijiModal').modal('toggle');
    }

    $("#xiugai").click(function () {
        $.ajax({
            type: "GET",
            cache: "false",
            url: "xitong/get/caiji/" + select() + ".do",
            dataType: "json",
            error: function () {//请求失败时调用函数。
                showAlert($("#mainAlert"), "danger");
            },
            success: function (result) {
                if (result.status == 1) {
                    showPutCaijiModal(result.data);
                } else {
                    showAlert($("#mainAlert"), "warning", result.message);
                }
            }
        });
    });

    $("#shanchu").click(function () {
        $.ajax({
            type: "POST",
            cache: "false",
            url: "jiankang/delete/caiji/" + select() + ".do?_method=DELETE",
            dataType: "json",
            error: function () {//请求失败时调用函数。
                showAlert($("#mainAlert"), "danger");
            },
            success: function (result) {
                if (result.status == 1) {
                    showAlert($("#mainAlert"), "success", result.message);
                    $("button[name='refresh']").click();
                } else {
                    showAlert($("#mainAlert"), "warning", result.message);
                }
            }
        });
    });
});