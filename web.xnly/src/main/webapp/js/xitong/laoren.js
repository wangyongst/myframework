/**
 * Created by wangy on 2016-12-02.
 */


$(function () {
    makeAlert($("#alertA"));

    makeModal($("#myModal"),"laorenForm","alertB","saveData","1");
    makeMyModal($("#myModal"));

    makeModal($("#jiashuModal"),"jiashuForm","alertC","saveJiashuData","2");
    makeJiashuModal($("#jiashuModal"));
    
    $("#saveData").click(
        function () {
            $.ajax({
                type: "POST",
                cache: "false",
                url: "xitong/laoren/edit.do",
                data: $('#laorenForm').serialize() + "&id=" + $('#idInput').val(),
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

    $("#saveJiashuData").click(
        function () {
            $.ajax({
                type: "POST",
                cache: "false",
                url: "xitong/jiashu/edit.do",
                data: $('#jiashuForm').serialize(),
                dataType: "json",
                error: function () {//请求失败时调用函数。
                    showAlert($("#alertC"), "danger");
                },
                success: function (result) {
                    if (result.status == 1) {
                        $('#jiashuModal').modal('toggle');
                        showAlert($("#alertA"), "success",result.message);
                        $("button[name='refresh']").click();
                    } else {
                        showAlert($("#alertC"), "warning",result.message);
                    }
                }
            });
        });

    $("#zhuce").click(
        function () {
            showMyModal(null, 0);
        });

    $("#jiashu").click(
        function () {
            $.ajax({
                type: "POST",
                cache: "false",
                url: "xitong/jiashu/get.do",
                data: {ids: select(), idType: "laorenid"},
                dataType: "json",
                error: function () {//请求失败时调用函数。
                    showAlert($("#alertA"), "danger");
                },
                success: function (result) {
                    if (result.status == 1) {
                        showJiashuModal(result.data, 1);
                    } else {
                        showAlert($("#alertA"), "warning",result.message);
                    }

                }
            });
        });

    $("#xiugai").click(
        function () {
            $.ajax({
                type: "POST",
                cache: "false",
                url: "xitong/laoren/get.do",
                data: {ids: select()},
                dataType: "json",
                error: function () {//请求失败时调用函数。
                    showAlert($("#alertA"), "danger");
                },
                success: function (result) {
                    if (result.status == 1) {
                        showMyModal(result.data, 1);
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
                url: "xitong/laoren/delete.do",
                data: {ids: select()},
                dataType: "json",
                error: function () {//请求失败时调用函数。
                    showAlert($("#alertA"), "danger");
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

    $("#change").click(
        function () {
            $.ajax({
                type: "POST",
                cache: "false",
                url: "xitong/laoren/change.do",
                data: {ids: select()},
                dataType: "json",
                error: function () {//请求失败时调用函数。
                    showAlert($("#alertA"), "danger");
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

function showMyModal(laoren, type) {
    showMyModalData(laoren);
    $('#idLabel').hide();
    $('#idInput').hide();
    $("#bingshiCheckbox input[name=bingshi]").each(function () { //遍历table里的全部checkbox
        $(this).prop("checked", false);
    })
    if (type == 1) {
        $('#idLabel').show();
        $('#idInput').show();
        $('#idInput').attr("readonly", "readonly");
        $('#myModal').find('.modal-title').text('修改信息');
    } else {
        $('#myModal').find('.modal-title').text('注册用户信息');
    }
    if (laoren != null && laoren.bingshi != null) {
        var bin = laoren.bingshi.split(",");
        for (var x in bin) {
            $("#bingshiCheckbox input[name=bingshi]").each(function () { //遍历table里的全部checkbox
                if ($(this).val() == bin[x]) { //如果被选中
                    $(this).prop("checked", true);
                }
            });
        }
    }
    if (laoren != null && laoren.sex != null) {
        $("#sexSelect").val(laoren.sex);
    }
    if (laoren != null && laoren.nation != null) {
        $("#nationSelect").val(laoren.nation);
    }
    $('#myModal').modal('toggle');
}

function showJiashuModal(jiashu, type) {
    showJiashuModalData(jiashu);
    $('#JSidInput').hide();
    $('#JSidLabel').hide();
    $('#JSlaorenidInput').attr("readonly", "readonly");
    $('#JSlaorennameInput').attr("readonly", "readonly");
    $('#jiashuModal').find('.modal-title').text('添加老人家属信息');
    $('#jiashuModal').modal('toggle');
}