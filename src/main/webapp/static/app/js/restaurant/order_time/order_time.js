/**
 * 管理初始化
 */
var OrderTime = {
    id: "OrderTimeTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};
/**
 * 初始化表格的列
 */
OrderTime.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: '订单号', field: 'orderNo', visible: true, align: 'center', valign: 'middle'},
        {title: '状态', field: 'status', visible: true, align: 'center', valign: 'middle',formatter:OrderTime.statusFormatter},
        {title: '状态时间', field: 'statusTime', visible: true, align: 'center', valign: 'middle'},
    ];
};

/**
 * 格式化类型
 */
OrderTime.statusFormatter = function(value){
    var kv = {1:"提交订单",2:"支付完成",3:"已发货",4:"确认收货",5:"退订",6:"取消",7:"自动取消"};
    return kv[value]?kv[value]:"";
}

/**
 * 检查是否选中
 */
OrderTime.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        BBQ.info("请先选中表格中的某一记录！");
        return false;
    }else{
        OrderTime.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加
 */
OrderTime.openAddOrderTime = function () {
    var index = layer.open({
        type: 2,
        title: '添加',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: BBQ.ctxPath + '/restaurant/order_time/order_time_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看详情
 */
OrderTime.openOrderTimeDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: BBQ.ctxPath + '/restaurant/order_time/order_time_edit?id=' + OrderTime.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除
 */
OrderTime.delete = function () {
    if (this.check()) {
        $.post(BBQ.ctxPath + "/restaurant/order_time/delete",{id:this.seItem.id}, function (data) {
            BBQ.success("删除成功!");
            OrderTime.table.refresh();
        });
    }
};

/**
 * 查询列表
 */
OrderTime.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    OrderTime.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = OrderTime.initColumn();
    var table = new BSTable(OrderTime.id, "/restaurant/order_time/list?orderNo="+$("#orderNo").val(), defaultColunms);
    table.setPaginationType("server");
    OrderTime.table = table.init();
});
