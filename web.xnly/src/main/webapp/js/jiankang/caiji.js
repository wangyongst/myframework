/**
 * Created by wangy on 2016-12-02.
 */
$(function () {

    makeModal($("#postCaijiModal"), "postCaiji", "1");

    makeModalColumns($("#postCaijiModal"), "caiji", "postCaiji", "请输入采集老人的");

    makeAlert($("#postCaijiAlert"));
    makeAlert($("#mainAlert"));

    $("#postCaijiSave").click(function () {
        $.ajax({
            type: "POST",
            cache: "false",
            url: "jiankang/post/caiji.do?",
            data: $('#postCaijiForm').serialize(),
            dataType: "json",
            error: function () {//请求失败时调用函数。
                showAlert($("#postCaijiAlert"), "danger");
            },
            success: function (result) {
                if (result.status == 1) {
                    $('#postCaijiModal').modal('toggle');
                    showAlert($("#mainAlert"), "success", result.message);
                    $("button[name='refresh']").click();
                } else {
                    showAlert($("#postCaijiAlert"), "warning", result.message);
                }
            }
        });
    });

    function showPostCaijiModal(laoren) {
        $('#postCaijiidInput').hide();
        $('#postCaijiidLabel').hide();
        $('#postCaijiModal').find("input[class=form-control]").val("");
        $('#postCaijilaorenidInput').attr("readonly", "readonly");
        $('#postCaijilaorennameInput').attr("readonly", "readonly");
        $('#postCaijilaorenidInput').val(laoren.id);
        $('#postCaijilaorennameInput').val(laoren.name);
        $('#postCaijiModal').find('.modal-title').text('采集老人健康数据');
        $('#postCaijiModal').modal('toggle');
    }


    $("#caiji").click(function () {
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
                    showPostCaijiModal(result.data);
                } else {
                    showAlert($("#mainAlert"), "warning", result.message);
                }
            }
        });
    });
});