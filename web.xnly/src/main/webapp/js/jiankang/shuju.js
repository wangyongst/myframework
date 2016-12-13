/**
 * Created by wangy on 2016-12-02.
 */
$(function () {
    makeAlert($("#alertA"));
    makeAlert($("#alertB"));
    
    $("#saveData").click(
        function () {
            $.ajax({
                type: "POST",
                cache: "false",
                url: "jiankang/caiji/edit.do",
                data: $('#form').serialize() + "&laorenid=" + $('#laorenid').val() + "&laorennameR=" + $('#laorenname').val() + "&id=" + $('#id').val(),
                dataType: "json",
                error: function () {//请求失败时调用函数。
                    $("#alertB div div").attr("class", "alert bg-danger");
                    $("#alertB").show();
                    $("#messageB").text("操作失败，请检查您的输入，如有问题请联系管理员！");
                },
                success: function (result) {
                    if (result.status == 1) {
                        $('#myModal').modal('toggle');
                        $("#alertB").hide();
                        $("#alertA").show();
                        $("#messageA").text(result.message);
                        $("button[name='refresh']").click();
//debugger;
                    } else {
                        $("#alertB").show();
                        $("#messageB").text(result.message);
                    }
                }
            });
        });
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

    function showModal(caiji, type) {
        showModalData(caiji);
        $('#idInput').hide();
        $('#idLabel').hide();
        $('#laorenidInput').attr("readonly", "readonly");
        $('#laorennameInput').attr("readonly", "readonly");
        $('#myModal').find('.modal-title').text('管理老人健康数据');
        $('#myModal').modal('toggle');
        $("#alertB").hide();
    }


    $("#xiugai").click(
        function () {
            $.ajax({
                type: "POST",
                cache: "false",
                url: "jiankang/caiji/get.do",
                data: {ids: select(), idType: "caijiid"},
                dataType: "json",
                error: function () {//请求失败时调用函数。
                    showAlert($("#alertA"), "danger");
                },
                success: function (result) {
                    if (result.status == 1) {
                        showModal(result.data, 1);
                    } else {
                        showAlert($("#alertA"), "warning",result.message);
                    }

                }
            });
        });
    $("#shanchu").click(
        function () {
            $.ajax({
                type: "POST",
                cache: "false",
                url: "jiankang/caiji/delete.do",
                data: {ids: select()},
                dataType: "json",
                error: function () {//请求失败时调用函数。
                    showAlert($("#alertA"), "danger");
                },
                success: function (result) {
                    showAlert($("#alertA"), "warning",result.message);
                    $("button[name='refresh']").click();
                }
            });
        });
});