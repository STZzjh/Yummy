/**
 * 管理初始化
 */
var OrderGoods = {
    id: "OrderGoodsTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};
/**
 * 初始化表格的列
 */
OrderGoods.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: '餐馆', field: 'restaurantName', visible: true, align: 'center', valign: 'middle'},
        {title: '餐厅收入', field: 'restaurantIn', visible: true, align: 'center', valign: 'middle'},
    ];
};

/**
 * 格式化类型
 */
OrderGoods.statusFormatter = function(value){
    var kv = {1:"提交订单",2:"支付完成",3:"已发货",4:"确认收货",5:"退订",6:"取消",7:"自动取消"};
    return kv[value]?kv[value]:"";
}

/**
 * 检查是否选中
 */
OrderGoods.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        BBQ.info("请先选中表格中的某一记录！");
        return false;
    }else{
        OrderGoods.seItem = selected[0];
        return true;
    }
};
/**
 * 查询列表
 */
OrderGoods.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    OrderGoods.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = OrderGoods.initColumn();
    var table = new BSTable(OrderGoods.id, "/admin/order_goods_ct/list", defaultColunms);
    table.setPaginationType("server");
    OrderGoods.table = table.init();
});
