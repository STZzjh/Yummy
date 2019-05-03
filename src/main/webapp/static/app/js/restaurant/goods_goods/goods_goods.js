/**
 * 管理初始化
 */
var GoodsGoods = {
    id: "GoodsGoodsTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};
/**
 * 初始化表格的列
 */
GoodsGoods.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: '套餐ID', field: 'goodsId', visible: true, align: 'center', valign: 'middle'},
        {title: '套餐栏目', field: 'subgoodsId', visible: true, align: 'center', valign: 'middle'},
        {title: '套餐栏目', field: 'subgoodsName', visible: true, align: 'center', valign: 'middle'},
    ];
};


/**
 * 检查是否选中
 */
GoodsGoods.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        BBQ.info("请先选中表格中的某一记录！");
        return false;
    }else{
        GoodsGoods.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加
 */
GoodsGoods.openAddGoodsGoods = function () {
    var index = layer.open({
        type: 2,
        title: '添加',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: BBQ.ctxPath + '/restaurant/goods_goods/goods_goods_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看详情
 */
GoodsGoods.openGoodsGoodsDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: BBQ.ctxPath + '/restaurant/goods_goods/goods_goods_edit?id=' + GoodsGoods.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除
 */
GoodsGoods.delete = function () {
    if (this.check()) {
        $.post(BBQ.ctxPath + "/restaurant/goods_goods/delete",{id:this.seItem.id}, function (data) {
            BBQ.success("删除成功!");
            GoodsGoods.table.refresh();
        });
    }
};

/**
 * 查询列表
 */
GoodsGoods.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    GoodsGoods.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = GoodsGoods.initColumn();
    var table = new BSTable(GoodsGoods.id, "/restaurant/goods_goods/list", defaultColunms);
    table.setPaginationType("server");
    GoodsGoods.table = table.init();
});
