/**
 * Created by BHWL on 2016-12-05.
 */

function showAlert(alert,level,message) {//请求失败时调用函数。
    if(level == 'danger') {
        $(alert).find("div div").attr("class", "alert bg-danger");
        $(alert).find("div div span").eq(0).attr("class", "glyphicon glyphicon-exclamation-sign");
        $(alert).find("div div span").eq(1).text("操作失败，请检查您的输入，如有问题请联系管理员,Email:331527770@qq.com！");
    }else if(level == 'warning'){
        $(alert).find("div div").attr("class", "alert bg-warning");
        $(alert).find("div div span").eq(0).attr("class", "glyphicon glyphicon-warning-sign");
        $(alert).find("div div span").eq(1).text(message);
    }else if(level == 'success'){
        $(alert).find("div div").attr("class", "alert bg-success");
        $(alert).find("div div span").eq(0).attr("class", "glyphicon glyphicon-check");
        $(alert).find("div div span").eq(1).text(message);
    }else{
        $(alert).find("div div").attr("class", "alert bg-primary");
        $(alert).find("div div span").eq(0).attr("class", "glyphicon glyphicon-info-sign");
        $(alert).find("div div span").eq(1).text(message);
    }
    $(alert).show();
}

function hideAlert(alert) {
    $(alert).parent().parent().parent().hide();
};

function makeAlert(alert) {
    $(alert).html("<div><div><span></span><span></span><a><span></span></a></div></div>");
    $(alert).find("div").attr("class", "col-lg-12");
    $(alert).find("div div").attr("role", "alert");
    $(alert).find("div div a").attr("class", "pull-right");
    $(alert).find("div div a").attr("style", "cursor:pointer");
    $(alert).find("div div a span").attr("class", "glyphicon glyphicon-remove");
};

function makeModalForm(modal, type, columnname, chinese) {
    $(modal).find("div div div").eq(1).find("form div").append("<label for='" + columnname + "'class='control-label'id='" + columnname + "Label'>" + chinese + "</label>");
    $(modal).find("div div div").eq(1).find("form div").append("<input type='" + type + "' class='form-control' id='" + columnname + "Input' name='" + columnname + "'>");
};

function makeModal(modal,formId,alertId,saveId) {
    $(modal).attr("class", "modal fade");
    $(modal).attr("tabindex", "-1");
    $(modal).attr("role", "dialog");
    $(modal).attr("aria-labelledby", "ModalLabelEditByYong");
    $(modal).append("<div><div><div></div><div></div><div></div><div></div></div></div>");
    $(modal).find("div").eq(0).attr("class", "modal-dialog");
    $(modal).find("div").eq(0).attr("role", "document");
    $(modal).find("div div").attr("class", "modal-content");
    $(modal).find("div div div").eq(0).attr("class", "modal-header");
    $(modal).find("div div div").eq(1).attr("class", "modal-body");
    $(modal).find("div div div").eq(2).attr("id", alertId);
    $(modal).find("div div div").eq(3).attr("class", "modal-footer");



    $(modal).find(".modal-header").append("<button><span></span></button>");
    $(modal).find(".modal-header").find("button").attr("type","button");
    $(modal).find(".modal-header").find("button").attr("class","close");
    $(modal).find(".modal-header").find("button").attr("data-dismiss","modal");
    $(modal).find(".modal-header").find("button").attr("aria-label","Close");
    $(modal).find(".modal-header").find("button span").attr("aria-hidden","true");
    $(modal).find(".modal-header").find("button span").text("X");
    $(modal).find(".modal-header").append("<h4></h4>");
    $(modal).find(".modal-header").find("h4").attr("class","modal-title");

    $(modal).find(".modal-body").append("<form><div></div></form>");
    $(modal).find(".modal-body").find("form").attr("id",formId);
    $(modal).find(".modal-body").find("form div").attr("class","form-group");

    $("#"+alertId).attr("class", "row");
    $("#"+alertId).attr("hidden", true);

    $(modal).find(".modal-footer").append("<button></button><button></button>");
    $(modal).find(".modal-footer").find("button").eq(0).attr("type","button");
    $(modal).find(".modal-footer").find("button").eq(1).attr("type","button");
    $(modal).find(".modal-footer").find("button").eq(0).attr("class","btn btn-default");
    $(modal).find(".modal-footer").find("button").eq(1).attr("class","btn btn-primary");
    $(modal).find(".modal-footer").find("button").eq(0).attr("data-dismiss","modal");
    $(modal).find(".modal-footer").find("button").eq(1).attr("id",saveId);
    $(modal).find(".modal-footer").find("button").eq(0).text("关闭");
    $(modal).find(".modal-footer").find("button").eq(1).text("保存");

    makeMyModal();
};