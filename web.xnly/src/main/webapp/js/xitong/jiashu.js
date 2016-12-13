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
                url: "xitong/jiashu/edit.do",
                data: $('#form').serialize() + "&laorenid=" + $('#laorenid').val() + "&laorennameR=" + $('#laorenname').val() + "&id=" + $('#id').val(),
                dataType: "json",
                error: function () {//请求失败时调用函数。
                    showAlert($("#alertB"), "danger");
                },
                success: function (result) {
                    if (result.status == 1) {
                        $('#myModal').modal('toggle');
                        showAlert($("#alertA"), "success",result.message);
                        $("button[name='refresh']").click();
                    } else {
                        showAlert($("#alertB"), "warning",result.message);
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

    function showModal(jiashu, type) {
        showModalData(jiashu);
        $('#idInput').hide();
        $('#idLabel').hide();
        $('#laorenidInput').attr("readonly", "readonly");
        $('#laorennameInput').attr("readonly", "readonly");
        $('#myModal').find('.modal-title').text('管理老人家属信息');
        if (jiashu != null && jiashu.guanxi != null) {
            $("#guanxiSelect").val(jiashu.guanxi);
        }
        $('#myModal').modal('toggle');
        $("#alertB").hide();
    }


    $("#xiugai").click(
        function () {
            $.ajax({
                type: "POST",
                cache: "false",
                url: "xitong/jiashu/get.do",
                data: {ids: select(), idType: "jiashuid"},
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
                url: "xitong/jiashu/delete.do",
                data: {ids: select()},
                dataType: "json",
                error: function () {//请求失败时调用函数。
                    showAlert($("#alertA"), "success",result.message);
                },
                success: function (result) {
                    if (result.status == 1) {
                        showAlert($("#alertA"), "success",result.message);
                        $("button[name='refresh']").click();
                    } else {
                        showAlert($("#alertA"), "warning",result.message);
                    }
                }
            });
        });
});