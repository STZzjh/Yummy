/**
 * 管理初始化
 */
var Dict = {
    id: "DictTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};
/**
 * 初始化表格的列
 */
Dict.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: 'CODE', field: 'code', visible: true, align: 'center', valign: 'middle'},
        {title: '名称', field: 'name', visible: true, align: 'center', valign: 'middle'},
        {title: '值', field: 'value', visible: true, align: 'center', valign: 'middle'},
    ];
};


/**
 * 检查是否选中
 */
Dict.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        BBQ.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Dict.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加
 */
Dict.openAddDict = function () {
    var index = layer.open({
        type: 2,
        title: '添加',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: BBQ.ctxPath + '/admin/dict/dict_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看详情
 */
Dict.openDictDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: BBQ.ctxPath + '/admin/dict/dict_edit?id=' + Dict.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除
 */
Dict.delete = function () {
    if (this.check()) {
        $.post(BBQ.ctxPath + "/admin/dict/delete",{id:this.seItem.id}, function (data) {
            BBQ.success("删除成功!");
            Dict.table.refresh();
        });
    }
};

/**
 * 查询列表
 */
Dict.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Dict.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Dict.initColumn();
    var table = new BSTable(Dict.id, "/admin/dict/list", defaultColunms);
    table.setPaginationType("server");
    Dict.table = table.init();
});
