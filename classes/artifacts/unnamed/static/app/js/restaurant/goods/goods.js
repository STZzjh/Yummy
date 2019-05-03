/**
 * 管理初始化
 */
var Goods = {
    id: "GoodsTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};
/**
 * 初始化表格的列
 */
Goods.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: '菜名', field: 'name', visible: true, align: 'center', valign: 'middle'},
        {title: '介绍', field: 'intro', visible: true, align: 'center', valign: 'middle'},
        {title: '图片', field: 'headImg', visible: true, align: 'center', valign: 'middle',formatter:Goods.headImgFormatter},
        {title: '标价', field: 'price', visible: true, align: 'center', valign: 'middle'},
        {title: '实际价格', field: 'currPrice', visible: true, align: 'center', valign: 'middle'},
        {title: '分类', field: 'typeName', visible: true, align: 'center', valign: 'middle'},
        {title: '类型', field: 'clazz', visible: true, align: 'center', valign: 'middle',formatter:Goods.clazzFormatter},
        {title: '菜单时效开始', field: 'startDate', visible: true, align: 'center', valign: 'middle'},
        {title: '菜单时效结束', field: 'endDate', visible: true, align: 'center', valign: 'middle'},
    ];
};

/**
 * 格式化图片
 */
Goods.headImgFormatter = function(value){
    return '<img src="'+BBQ.ctxPath + "/" +value+'" width="100" height="100" />';
}
/**
 * 格式化类型
 */
Goods.clazzFormatter = function(value){
    var kv = {1:"单品",2:"套餐"};
    return kv[value]?kv[value]:"";
}

/**
 * 检查是否选中
 */
Goods.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        BBQ.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Goods.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加
 */
Goods.openAddGoods = function () {
    var index = layer.open({
        type: 2,
        title: '添加',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: BBQ.ctxPath + '/restaurant/goods/goods_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看详情
 */
Goods.openGoodsDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: BBQ.ctxPath + '/restaurant/goods/goods_edit?id=' + Goods.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除
 */
Goods.delete = function () {
    if (this.check()) {
        $.post(BBQ.ctxPath + "/restaurant/goods/delete",{id:this.seItem.id}, function (data) {
            BBQ.success("删除成功!");
            Goods.table.refresh();
        });
    }
};

/**
 * 查询列表
 */
Goods.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Goods.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Goods.initColumn();
    var table = new BSTable(Goods.id, "/restaurant/goods/list", defaultColunms);
    table.setPaginationType("server");
    Goods.table = table.init();
});
