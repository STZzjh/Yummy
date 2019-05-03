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
        {title: '餐馆', field: 'restaurantName', visible: true, align: 'center', valign: 'middle'},
        {title: '菜品', field: 'goodsName', visible: true, align: 'center', valign: 'middle'},
        {title: '价格', field: 'price', visible: true, align: 'center', valign: 'middle'},
        {title: '地址', field: 'userAddressName', visible: true, align: 'center', valign: 'middle'},
        {title: '状态', field: 'status', visible: true, align: 'center', valign: 'middle',formatter:OrderGoods.statusFormatter},
        {title: '预约时间', field: 'subscribeTime', visible: true, align: 'center', valign: 'middle'},
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
 * 打开查看详情
 */
OrderGoods.openOrderGoodsDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: BBQ.ctxPath + '/user/order_time?orderNo=' + OrderGoods.seItem.orderNo
        });
        this.layerIndex = index;
    }
};

OrderGoods.pay = function () {
    if (this.check()) {

        if(parseInt(this.seItem.status) != 1){
            BBQ.info("不能进行该操作");
            return;
        }
        $.post(BBQ.ctxPath + "/user/order_time/pay",{orderNo:this.seItem.orderNo}, function (data) {
            BBQ.success("收货成功!");
            OrderGoods.table.refresh();
        });
    }

}
OrderGoods.shouhuo = function () {
    if (this.check()) {
        if(parseInt(this.seItem.status)==1){
            BBQ.info("未发货");
            return;
        }
        if(parseInt(this.seItem.status) != 3){
            BBQ.info("不能进行该操作");
            return;
        }
        $.post(BBQ.ctxPath + "/user/order_time/add",{orderNo:this.seItem.orderNo}, function (data) {
            BBQ.success("收货成功!");
            OrderGoods.table.refresh();
        });
    }
};
/**
 * 退订
 */
OrderGoods.tuiding = function () {
    if (this.check()) {
    var number = parseInt(this.seItem.status);
    if(number != 2 && number != 3){
        BBQ.info("不能进行该操作");
        return;
    }

        $.post(BBQ.ctxPath + "/user/order_time/update",{orderNo:this.seItem.orderNo}, function (data) {
            BBQ.success("删除成功!");
            OrderGoods.table.refresh();
        });
    }
};

OrderGoods.quxiao = function () {
    if (this.check()) {
        var number = parseInt(this.seItem.status);
        if(number != 1){
            BBQ.info("不能进行该操作");
            return;
        }

        $.post(BBQ.ctxPath + "/user/order_time/delete",{orderNo:this.seItem.orderNo}, function (data) {
            BBQ.success("取消成功!");
            OrderGoods.table.refresh();
        });
    }
}

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
    var table = new BSTable(OrderGoods.id, "/user/order_goods/list", defaultColunms);
    table.setPaginationType("server");
    OrderGoods.table = table.init();
});
