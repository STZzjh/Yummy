/**
 * 管理初始化
 */
var GoodsType = {
    id: "GoodsTypeTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};
/**
 * 初始化表格的列
 */
GoodsType.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: '名称', field: 'name', visible: true, align: 'center', valign: 'middle'},
        {title: '简介', field: 'intro', visible: true, align: 'center', valign: 'middle'},
    ];
};


/**
 * 检查是否选中
 */
GoodsType.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        BBQ.info("请先选中表格中的某一记录！");
        return false;
    }else{
        GoodsType.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加
 */
GoodsType.openAddGoodsType = function () {
    var index = layer.open({
        type: 2,
        title: '添加',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: BBQ.ctxPath + '/admin/goods_type/goods_type_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看详情
 */
GoodsType.openGoodsTypeDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: BBQ.ctxPath + '/admin/goods_type/goods_type_edit?id=' + GoodsType.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除
 */
GoodsType.delete = function () {
    if (this.check()) {
        $.post(BBQ.ctxPath + "/admin/goods_type/delete",{id:this.seItem.id}, function (data) {
            BBQ.success("删除成功!");
            GoodsType.table.refresh();
        });
    }
};

/**
 * 查询列表
 */
GoodsType.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    GoodsType.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = GoodsType.initColumn();
    var table = new BSTable(GoodsType.id, "/admin/goods_type/list", defaultColunms);
    table.setPaginationType("server");
    GoodsType.table = table.init();
});
