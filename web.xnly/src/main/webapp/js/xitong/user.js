/**
 * Created by wangy on 2016-12-02.
 */
$(function () {
    $("#alertA").hide();
    $("#alertB").hide();
    $("#saveData").click(
        function () {
            $.ajax({
                type: "POST",
                cache: "false",
                url: "xitong/user/edit.do",
                data: $('#userForm').serialize() + "&id=" + $('#idInput').val(),
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

    function showModal(user, type) {
        showModalData(user);
        $('#idInput').hide();
        $('#idLabel').hide();
        if (type == 1) {
            $('#idLabel').show();
            $('#idInput').show();
            $('#idInput').attr("readonly", "readonly");
            $('#myModal').find('.modal-title').text('修改用户信息');
        } else {
            $('#myModal').find('.modal-title').text('注册用户信息');
        }
        if (user != null && user.role != null) {
            $("#roleSelect").val(user.role);
        }
        $('#myModal').modal('toggle');
        $("#alertB").hide();
    }


    $("#zhuce").click(
        function () {
            showModal(null, 0);
        });
    $("#xiugai").click(
        function () {
            $.ajax({
                type: "POST",
                cache: "false",
                url: "xitong/user/get.do",
                data: {ids: select()},
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
                url: "xitong/user/delete.do",
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