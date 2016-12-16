/**
 * Created by wangy on 2016-12-02.
 */
$(function () {

    makeModal($("#postUserModal"), "postUserForm", "postUserAlert", "postUserSave", "1");
    makeModal($("#putUserModal"), "putUserForm", "putUserAlert", "putUserSave", "2");

    makePostUserModal($("#postUserModal"));
    makePutUserModal($("#putUserModal"));


    makeAlert($("#postUserAlert"));
    makeAlert($("#putUserAlert"));
    makeAlert($("#mainAlert"));

    $("#postUserSave").click(function () {
        $.ajax({
            type: "POST",
            cache: "false",
            url: "xitong/post/user.do",
            data: $('#postUserForm').serialize(),
            dataType: "json",
            error: function () {//请求失败时调用函数。
                showAlert($("#postUserAlert"), "danger");
            },
            success: function (result) {
                if (result.status == 1) {
                    $('#postUserModal').modal('toggle');
                    showAlert($("#mainAlert"), "success", result.message);
                    $("button[name='refresh']").click();
                } else {
                    showAlert($("#postUserAlert"), "warning", result.message);
                }
            }
        });
    });

    $("#putUserSave").click(function () {
        $.ajax({
            type: "POST",
            cache: "false",
            url: "xitong/post/user.do?_method=PUT",
            data: $('#putUserForm').serialize(),
            dataType: "json",
            error: function () {//请求失败时调用函数。
                showAlert($("#putUserAlert"), "danger");
            },
            success: function (result) {
                if (result.status == 1) {
                    $('#putUserModal').modal('toggle');
                    showAlert($("#mainAlert"), "success", result.message);
                    $("button[name='refresh']").click();
                } else {
                    showAlert($("#putUserAlert"), "warning", result.message);
                }
            }
        });
    });

    function showPostUserModal() {
        showPostUserModalData();
        $('#postidInput').hide();
        $('#postidLabel').hide();
        $('#postUserModal').find('.modal-title').text('注册用户信息');
        $('#postUserModal').modal('toggle');
        $("#postUserAlert").hide();
    }


    function showPutUserModal(user) {
        showPutUserModalData(user);
        $('#putidInput').attr("readonly", "readonly");
        $('#putUserModal').find('.modal-title').text('修改用户信息');
        $("#putroleSelect").val(user.role);
        $('#putUserModal').modal('toggle');
        $("#putUserAlert").hide();
    }


    $("#zhuce").click(function () {
        showPostUserModal();
    });

    $("#xiugai").click(function () {
        $.ajax({
            type: "GET",
            cache: "false",
            url: "xitong/get/user.do",
            data: {ids: select()},
            dataType: "json",
            error: function () {//请求失败时调用函数。
                showAlert($("#mainAlert"), "danger");
            },
            success: function (result) {
                if (result.status == 1) {
                    showPutUserModal(result.data);
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
            url: "xitong/delete/user.do?_method=DELETE",
            data: {ids: select()},
            dataType: "json",
            error: function () {//请求失败时调用函数。
                showAlert($("#mainAlert"), "danger");
            },
            success: function (result) {
                showAlert($("#mainAlert"), "success", result.message);
                $("button[name='refresh']").click();
            }
        });
    });
});