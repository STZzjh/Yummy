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
        {title: '订单号', field: 'orderNo', visible: true, align: 'center', valign: 'middle'},
        {title: '用户', field: 'userName', visible: true, align: 'center', valign: 'middle'},
        {title: '菜品', field: 'goodsName', visible: true, align: 'center', valign: 'middle'},
        {title: '价格', field: 'price', visible: true, align: 'center', valign: 'middle'},
        {title: '状态', field: 'status', visible: true, align: 'center', valign: 'middle',formatter:OrderGoods.statusFormatter},
        {title: '创建时间', field: 'createTime', visible: true, align: 'center', valign: 'middle'},
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
    queryData['timeStart'] = $("#timeStart").val();
    queryData['timeEnd'] = $("#timeEnd").val();
    queryData['moneyStart'] = $("#moneyStart").val();
    queryData['moneyEnd'] = $("#moneyEnd").val();
    queryData['userName'] = $("#userName").val();
    OrderGoods.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = OrderGoods.initColumn();
    var table = new BSTable(OrderGoods.id, "/restaurant/order_goods_td/list", defaultColunms);
    table.setPaginationType("server");
    OrderGoods.table = table.init();
});
