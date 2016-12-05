/**
 * Created by wangy on 2016-12-02.
 */
$(function () {
    
    makeAlert($("#alertA"));
    makeAlert($("#alertB"));

    makeModal($("#myModal"),"form","alertB","saveData");
    makeMyModal($("#myModal"));

    $("#saveData").click(
        function () {
            $.ajax({
                type: "POST",
                cache: "false",
                url: "jiankang/caiji/edit.do",
                data: $('#form').serialize() + "&laorenid=" + $('#laorenid').val() + "&laorennameR=" + $('#laorenname').val(),
                dataType: "json",
                error: function () {//请求失败时调用函数。
                    showAlert($("#alertB"), "danger");
                },
                success: function (result) {
                    if (result.status == 1) {
                        $('#myModal').modal('toggle');
                        $("#alertB").hide();
                        showAlert($("#alertA"), "success", result.message);
                        $("button[name='refresh']").click();
                    } else {
                        showAlert($("#alertB"), "warning", result.message);
                    }
                }
            });
        });   

    function showModal(caiji, type) {
        showMyModalData(caiji,"请输入老人的");
        $('#idInput').hide();
        $('#idLabel').hide();
        $('#laorenidInput').attr("readonly", "readonly");
        $('#laorennameInput').attr("readonly", "readonly");
        $('#myModal').find('.modal-title').text('采集老人健康数据');
        $('#myModal').modal('toggle');
        $("#alertB").hide();
    }


    $("#caiji").click(
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
                        showModal(result.data, 1);
                    } else {
                        showAlert($("#alertA"), "warning", result.message);
                    }
                }
            });
        });
});