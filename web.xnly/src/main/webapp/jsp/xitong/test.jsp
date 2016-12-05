<div id="myModal" class="modal fade in" tabindex="-1" role="dialog" aria-labelledby="ModalLabelEditByYong" aria-hidden="false" style="display: block;">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true"></span></button>
                <h4 class="modal-title">采集老人健康数据</h4></div>
            <div class="modal-body">
                <form id="form">
                    <div class="row" id="alertB" hidden="hidden" style="display: none;"><label for="id" class="control-label" id="idLabel" style="display: none;">ID</label><input type="number" class="form-control" id="idInput" name="id"
                                                                                                                                                                                   placeholder="请输入老人的ID" style="display: none;"><label
                            for="laorenid" class="control-label" id="laorenidLabel">老人ID</label><input type="number" class="form-control" id="laorenidInput" name="laorenid" placeholder="请输入老人的老人ID" readonly="readonly"><label
                            for="laorenname" class="control-label" id="laorennameLabel">老人姓名</label><input type="text" class="form-control" id="laorennameInput" name="laorenname" placeholder="请输入老人的老人姓名" readonly="readonly"><label
                            for="gaoya" class="control-label" id="gaoyaLabel">高压(mmHg)</label><input type="number" class="form-control" id="gaoyaInput" name="gaoya" placeholder="请输入老人的高压(mmHg)"><label for="diya" class="control-label"
                                                                                                                                                                                                         id="diyaLabel">低压(mmHg)</label><input
                            type="number" class="form-control" id="diyaInput" name="diya" placeholder="请输入老人的低压(mmHg)"><label for="xuetang" class="control-label" id="xuetangLabel">血糖(mmol/L)</label><input type="number" class="form-control"
                                                                                                                                                                                                             id="xuetangInput" name="xuetang"
                                                                                                                                                                                                             placeholder="请输入老人的血糖(mmol/L)"><label
                            for="maibo" class="control-label" id="maiboLabel">脉博(次/分钟)</label><input type="number" class="form-control" id="maiboInput" name="maibo" placeholder="请输入老人的脉博(次/分钟)"><label for="xueyang" class="control-label"
                                                                                                                                                                                                         id="xueyangLabel">血氧(%)</label><input
                            type="number" class="form-control" id="xueyangInput" name="xueyang" placeholder="请输入老人的血氧(%)"><label for="tizhong" class="control-label" id="tizhongLabel">体重(KG)</label><input type="number" class="form-control"
                                                                                                                                                                                                            id="tizhongInput" name="tizhong"
                                                                                                                                                                                                            placeholder="请输入老人的体重(KG)"><label
                            for="shengao" class="control-label" id="shengaoLabel">身高(CM)</label><input type="number" class="form-control" id="shengaoInput" name="shengao" placeholder="请输入老人的身高(CM)"><label for="huxi" class="control-label"
                                                                                                                                                                                                             id="huxiLabel">呼吸（次/分钟）</label><input
                            type="number" class="form-control" id="huxiInput" name="huxi" placeholder="请输入老人的呼吸（次/分钟）"><label for="time" class="control-label" id="timeLabel">测量时间</label><input type="datetime-local" class="form-control"
                                                                                                                                                                                                 id="timeInput" name="time"
                                                                                                                                                                                                 placeholder="请输入老人的测量时间"></div>
                </form>
            </div>
            <div class="modal-content">
                <button type="button" class="btn btn-default" data-dismiss="modal"></button>
                <button type="button" class="btn btn-primary" id="saveData"></button>
            </div>
            <div class="modal-content"></div>
        </div>
    </div>
</div>