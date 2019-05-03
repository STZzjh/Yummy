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
        {title: '地址', field: 'userAddressName', visible: true, align: 'center', valign: 'middle'},
        {title: '状态', field: 'status', visible: true, align: 'center', valign: 'middle',formatter:OrderGoods.statusFormatter},
        {title: '预约时间', field: 'subscribeTime', visible: true, align: 'center', valign: 'middle'},
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
 * 点击添加
 */
OrderGoods.detail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '添加',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: BBQ.ctxPath + '/restaurant/order_time?orderNo=' + this.seItem.orderNo
        });
        this.layerIndex = index;
    }
};



/**
 * 发货
 */
OrderGoods.sendGoods = function () {
    if (this.check()) {

        if(parseInt(this.seItem.status)==1){
            BBQ.info("未支付");
            return;
        }
        if(parseInt(this.seItem.status) != 2){
            BBQ.info("不能进行该操作");
            return;
        }
        $.post(BBQ.ctxPath + "/restaurant/order_time/add",{orderNo:this.seItem.orderNo}, function (data) {
            BBQ.success("发货成功!");
            OrderGoods.table.refresh();
        });
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
    var table = new BSTable(OrderGoods.id, "/restaurant/order_goods/list", defaultColunms);
    table.setPaginationType("server");
    OrderGoods.table = table.init();
});
