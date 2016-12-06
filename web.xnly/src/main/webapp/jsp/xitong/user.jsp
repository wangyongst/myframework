<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/jsp/base.jsp"%>
    <script src="js/xitong/user.js"></script>
    <script type="text/javascript">
        function showModalData(user) {
            <c:forEach var="item" items="${formColumns}">
            if (user != null) {
                $("#${item.columnname}Input").val(user.${item.columnname});
            } else {
                $("#${item.columnname}Input").val("");
            }
            $("#${item.columnname}Input").attr("placeholder", "请输入用户的${item.chinese}");
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


                <table data-toggle="table" data-url="xitong/allUsers.do" data-show-refresh="true"
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
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                        aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title" id="myModalLabel"></h4>
                            </div>
                            <div class="modal-body">
                                <form id="userForm">
                                    <div class="form-group">
                                        <c:forEach var="item" items="${formColumns}">
                                            <label for="${item.columnname}"
                                                   class="control-label"
                                                   id="${item.columnname}Label">${item.chinese}</label>
                                            <c:choose>
                                                <c:when test="${item.type == 'select'}">
                                                    <c:choose>
                                                        <c:when test="${item.columnname == 'role'}">
                                                            <select class="form-control" name="${item.columnname}" id="${item.columnname}Select">
                                                                <c:forEach var="itemb" items="${role}">
                                                                    <label>
                                                                        <option>${itemb.name}</option>
                                                                    </label>
                                                                </c:forEach>
                                                            </select>
                                                        </c:when>
                                                    </c:choose>
                                                </c:when>
                                                <c:otherwise>
                                                    <input type="${item.type}" class="form-control" id="${item.columnname}Input" name="${item.columnname}"/>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                    </div>
                                </form>
                            </div>

                            <div id="alertB" hidden></div>

                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                <button type="button" class="btn btn-primary" id="saveData">保存</button>
                            </div>
                        </div>
                    </div>
                </div><!-- Modal -->


            </div>
        </div>
    </div>
</div><!--/.row-->

</body>

</html>
