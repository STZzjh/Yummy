/**
 * 管理初始化
 */
var Recharge = {
    id: "RechargeTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};
/**
 * 初始化表格的列
 */
Recharge.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: '金额', field: 'money', visible: true, align: 'center', valign: 'middle'},
        {title: '银行', field: 'bank', visible: true, align: 'center', valign: 'middle',formatter:Recharge.bankFormatter},
        {title: '', field: 'createTime', visible: true, align: 'center', valign: 'middle'},
    ];
};

/**
 * 格式化类型
 */
Recharge.bankFormatter = function(value){
    var kv = {1:"招商银行",2:"建设银行",3:"交通银行",4:"工商银行"};
    return kv[value]?kv[value]:"";
}

/**
 * 检查是否选中
 */
Recharge.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        BBQ.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Recharge.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加
 */
Recharge.openAddRecharge = function () {
    var index = layer.open({
        type: 2,
        title: '添加',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: BBQ.ctxPath + '/user/recharge/recharge_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看详情
 */
Recharge.openRechargeDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: BBQ.ctxPath + '/user/recharge/recharge_edit?id=' + Recharge.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除
 */
Recharge.delete = function () {
    if (this.check()) {
        $.post(BBQ.ctxPath + "/user/recharge/delete",{id:this.seItem.id}, function (data) {
            BBQ.success("删除成功!");
            Recharge.table.refresh();
        });
    }
};

/**
 * 查询列表
 */
Recharge.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Recharge.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Recharge.initColumn();
    var table = new BSTable(Recharge.id, "/user/recharge/list", defaultColunms);
    table.setPaginationType("server");
    Recharge.table = table.init();
});
