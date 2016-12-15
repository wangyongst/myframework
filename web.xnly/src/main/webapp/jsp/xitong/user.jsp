<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/jsp/base.jsp" %>
    <script src="js/xitong/user.js"></script>
    <script type="text/javascript">
        function showMyModalData(user) {
            <c:forEach var="item" items="${formColumns}">
            if (user != null) {
                $("#${item.columnname}Input").val(user.${item.columnname});
            } else {
                $("#${item.columnname}Input").val("");
            }
            $("#${item.columnname}Input").attr("placeholder", "请输入用户的${item.chinese}");
            </c:forEach>
        }

        function makeMyModal(modal) {
            <c:forEach var="item" items="${formColumns}">
            makeModalForm(modal, "${item.type}", null, "${item.columnname}", "${item.chinese}");
            </c:forEach>
        }

    </script>
</head>

<body style="padding-top:0px">
<div class="row">
    <ol class="breadcrumb">
        <li><a href="user/home.do"><span class="glyphicon glyphicon-home"></span></a></li>
        <li class="active">${title}</li>
    </ol>
</div><!--/.row-->

<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">${tableName}</div>
            <div class="panel-body">

                <div id="alertA" hidden></div>


                <button type="button" class="btn btn-primary" id="zhuce">注册用户</button>
                <button type="button" class="btn btn-primary" id="xiugai">修改用户</button>
                <button type="button" class="btn btn-primary" id="shanchu">删除用户</button>


                <table data-toggle="table" data-url="xitong/list/users.do" data-show-refresh="true"
                       data-show-toggle="true" data-show-columns="true" data-search="true"
                       data-select-item-name="toolbar1" data-pagination="true" data-sort-name="id"
                       data-sort-order="desc">
                    <thead>
                    <tr>
                        <th data-field="state" data-checkbox="true"></th>
                        <c:forEach var="item" items="${tableColumns}">
                            <th data-field="${item.columnname}" data-sortable="true">${item.chinese}</th>
                        </c:forEach>
                    </tr>
                    </thead>
                </table>


                <!-- Modal -->
                <div id="myModal"></div><!-- Modal -->

            </div>
        </div>
    </div>
</div><!--/.row-->

</body>

</html>
