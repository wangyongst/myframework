<table id="laorenTable" data-toggle="table" data-url="xitong/allLaorens.do" data-show-refresh="true" data-show-toggle="true" data-show-columns="true" data-search="true" data-select-item-name="toolbar1" data-pagination="true"
       data-sort-name="true" data-sort-order="desc">
    <thead>
    <tr>
        <th data-field="state" data-checkbox="true"></th>
        <th data-field="id" data-sortable="true">ID</th>
        <th data-field="laorenid" data-sortable="true">老人ID</th>
        <th data-field="laorenname" data-sortable="true">老人姓名</th>
        <th data-field="gaoya" data-sortable="true">高压(mmHg)</th>
        <th data-field="diya" data-sortable="true">低压(mmHg)</th>
        <th data-field="xuetang" data-sortable="true">血糖(mmol/L)</th>
        <th data-field="maibo" data-sortable="true">脉博(次/分钟)</th>
        <th data-field="xueyang" data-sortable="true">血氧(%)</th>
        <th data-field="tizhong" data-sortable="true">体重(KG)</th>
        <th data-field="shengao" data-sortable="true">身高(CM)</th>
        <th data-field="huxi" data-sortable="true">呼吸（次/分钟）</th>
        <th data-field="time" data-sortable="true">测量时间</th>
    </tr>
    </thead>
</table>


<table data-toggle="table" data-url="xitong/otherLaorens.do" data-show-refresh="true"
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

