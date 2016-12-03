/**
 * Created by wangy on 2016-12-02.
 */
$(function () {
    $("#saveData").click(
        function () {
            $.ajax({
                type: "POST",
                cache: "false",
                url: "shenghuo/fuwu/edit.do",
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

    function showModal(fuwu, type) {
        showModalData(fuwu);
        $('#idInput').hide();
        $('#idLabel').hide();
        $('#laorenidInput').attr("readonly", "readonly");
        $('#laorennameInput').attr("readonly", "readonly");
        $('#myModal').find('.modal-title').text('管理老人服务需求');
        if (fuwu != null && fuwu.xiangmu != null) {
            $("#xiangmuSelect").val(fuwu.xiangmu);
        }
        if (fuwu != null && fuwu.fuwutype != null) {
            $("#fuwutypeSelect").val(fuwu.fuwutype);
        }
        $('#myModal').modal('toggle');
        $("#alertB").hide();
    }


    $("#xiugai").click(
        function () {
            $.ajax({
                type: "POST",
                cache: "false",
                url: "shenghuo/fuwu/get.do",
                data: {ids: select(), idType: "fuwuid"},
                dataType: "json",
                error: function () {//请求失败时调用函数。
                    $("#alertA").show();
                    $("#messageA").text("操作失败，请联系管理员！");
                },
                success: function (result) {
                    if (result.status == 1) {
                        showModal(result.data, 1);
                    } else {
                        $("#alertA").show();
                        $("#messageA").text(result.message);
                    }

                }
            });
        });
    $("#shanchu").click(
        function () {
            $.ajax({
                type: "POST",
                cache: "false",
                url: "shenghuo/fuwu/delete.do",
                data: {ids: select()},
                dataType: "json",
                error: function () {//请求失败时调用函数。
                    $("#alertA").show();
                    $("#messageA").text("操作失败，请联系管理员！");
                },
                success: function (result) {
                    $("#alertA").show();
                    $("#messageA").text(result.message);
                    $("button[name='refresh']").click();
                }
            });
        });

    $("#closeA").click(
        function () {
            $("#alertA").hide();
        });
    $("#closeB").click(
        function () {
            $("#alertB").hide();
        });

});