/**
 * Created by wangy on 2016-12-02.
 */

!function ($) {
    $(document).on("click", "ul.nav li.parent > a", function () {
        $(this).find('em:first').toggleClass("glyphicon-minus");
    });
    $(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
}(window.jQuery);

$(window).on('resize', function () {
    if ($(window).width() > 768) $('#sidebar-collapse').collapse('show')
})
$(window).on('resize', function () {
    if ($(window).width() <= 767) $('#sidebar-collapse').collapse('hide')
})

$(function () {
    makeAlert($("#alertA"));
    makeAlert($("#alertB"));
    
    $("#saveData").click(
        function () {
            $.ajax({
                type: "POST",
                cache: "false",
                url: "xitong/laoren/edit.do",
                data: $('#laorenForm').serialize() + "&id=" + $('#idInput').val(),
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

    $("#saveJiashuData").click(
        function () {
            $.ajax({
                type: "POST",
                cache: "false",
                url: "xitong/jiashu/edit.do",
                data: $('#jiashuForm').serialize() + "&laorenid=" + $('#JSlaorenid').val() + "&laorennameR=" + $('#JSlaorenname').val(),
                dataType: "json",
                error: function () {//请求失败时调用函数。
                    $("#alertC div div").attr("class", "alert bg-danger");
                    $("#alertC").show();
                    $("#messageC").text("操作失败，请检查您的输入，如有问题请联系管理员！");
                },
                success: function (result) {
                    if (result.status == 1) {
                        $('#jiashuModal').modal('toggle');
                        $("#alertC").hide();
                        $("#alertA").show();
                        $("#messageA").text(result.message);
                        $("button[name='refresh']").click();
                        //debugger;
                    } else {
                        $("#alertC").show();
                        $("#messageC").text(result.message);
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

    $("#zhuce").click(
        function () {
            showModal(null, 0);
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
                    $("#alertA").show();
                    $("#messageA").text("操作失败，请联系管理员！");
                },
                success: function (result) {
                    if (result.status == 1) {
                        showJiashuModal(result.data, 1);
                    } else {
                        $("#alertA").show();
                        $("#messageA").text(result.message);
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
                url: "xitong/laoren/delete.do",
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

    $("#change").click(
        function () {
            $.ajax({
                type: "POST",
                cache: "false",
                url: "xitong/laoren/change.do",
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
});

function showModal(laoren, type) {
    showModalData(laoren);
    $('#idLabel').hide();
    $('#idInput').hide();
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
    $("#alertB").hide();
}


function showJiashuModal(jiashu, type) {
    showJiashuModalData(jiashu);
    $('#JSidInput').hide();
    $('#JSidLabel').hide();
    $('#JSlaorenidInput').attr("readonly", "readonly");
    $('#JSlaorennameInput').attr("readonly", "readonly");
    $('#jiashuModal').find('.modal-title').text('添加老人家属信息');
    $('#jiashuModal').modal('toggle');
    $("#alertC").hide();
}