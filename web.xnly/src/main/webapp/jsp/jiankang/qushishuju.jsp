<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>西宁乐缘综合养老管理平台 - ${title}</title>
    <script src="js/myJS.js"></script>

    <script src="js/jiankang/qushishuju.js"></script>
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


                <button type="button" class="btn btn-primary" id="xueya">血压趋势</button>
                <button type="button" class="btn btn-primary" id="xueyang">血氧趋势</button>
                <button type="button" class="btn btn-primary" id="maibo">脉博趋势</button>
                <button type="button" class="btn btn-primary" id="tizhaong">体重趋势</button>
                <button type="button" class="btn btn-primary" id="xuetang">血糖趋势</button>
                <button type="button" class="btn btn-primary" id="shenggao">身高趋势</button>
                <button type="button" class="btn btn-primary" id="bmi">BMI趋势</button>
                <button type="button" class="btn btn-primary" id="huxi">呼吸趋势</button>

                <table data-toggle="table" data-url="jiankang/allCaijis.do?laorenid=${laorenid}"
                       data-show-refresh="true"
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
            </div>
        </div>
    </div>
</div><!--/.row-->

<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading" id="linechartitle"></div>
            <div class="panel-body">
                <div class="canvas-wrapper">
                    <canvas class="main-chart" id="line-chart" height="200" width="600"></canvas>
                </div>
            </div>
        </div>
    </div>
</div><!--/.row-->

</body>

</html>
