/**
 * 管理初始化
 */
var RestType = {
    id: "RestTypeTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};
/**
 * 初始化表格的列
 */
RestType.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: '分类名称', field: 'name', visible: true, align: 'center', valign: 'middle'},
        {title: '简介', field: 'intro', visible: true, align: 'center', valign: 'middle'},
    ];
};


/**
 * 检查是否选中
 */
RestType.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        BBQ.info("请先选中表格中的某一记录！");
        return false;
    }else{
        RestType.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加
 */
RestType.openAddRestType = function () {
    var index = layer.open({
        type: 2,
        title: '添加',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: BBQ.ctxPath + '/admin/rest_type/rest_type_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看详情
 */
RestType.openRestTypeDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: BBQ.ctxPath + '/admin/rest_type/rest_type_edit?id=' + RestType.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除
 */
RestType.delete = function () {
    if (this.check()) {
        $.post(BBQ.ctxPath + "/admin/rest_type/delete",{id:this.seItem.id}, function (data) {
            BBQ.success("删除成功!");
            RestType.table.refresh();
        });
    }
};

/**
 * 查询列表
 */
RestType.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    RestType.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = RestType.initColumn();
    var table = new BSTable(RestType.id, "/admin/rest_type/list", defaultColunms);
    table.setPaginationType("server");
    RestType.table = table.init();
});
