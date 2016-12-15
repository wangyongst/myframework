/**
 * Created by wangy on 2016-12-02.
 */
$(function () {
    makeAlert($("#alertA"));
    makeAlert($("#alertB"));

    makeModal($("#myModal"), "userForm", "alertB", "saveData", "1");
    makeMyModal($("#myModal"));

    var mothed;
    var url;
    $("#saveData").click(function () {
        $.ajax({
            type: "POST",
            cache: "false",
            url: "xitong/post/user.do",
            data: $('#userForm').serialize(),
            dataType: "json",
            error: function () {//请求失败时调用函数。
                showAlert($("#alertB"), "danger");
            },
            success: function (result) {
                if (result.status == 1) {
                    $('#myModal').modal('toggle');
                    showAlert($("#alertA"), "success", result.message);
                    $("button[name='refresh']").click();
                } else {
                    showAlert($("#alertB"), "warning", result.message);
                }
            }
        });
    });

    function showMyModal(user, type) {
        showMyModalData(user);
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


    $("#zhuce").click(function () {
        showMyModal(null, 0);
    });

    $("#xiugai").click(function () {
        $.ajax({
            type: "GET",
            cache: "false",
            url: "xitong/get/user.do",
            data: {ids: select()},
            dataType: "json",
            error: function () {//请求失败时调用函数。
                showAlert($("#alertA"), "danger");
            },
            success: function (result) {
                if (result.status == 1) {
                    showMyModal(result.data, 1);
                } else {
                    showAlert($("#alertA"), "warning", result.message);
                }

            }
        });
    });

    $("#shanchu").click(function () {
        $.ajax({
            type: "POST",
            cache: "false",
            url: "xitong/delete/user.do?_method=DELETE",
            data: {ids: select()},
            dataType: "json",
            error: function () {//请求失败时调用函数。
                showAlert($("#alertA"), "danger");
            },
            success: function (result) {
                showAlert($("#alertA"), "success", result.message);
                $("button[name='refresh']").click();
            }
        });
    });

});