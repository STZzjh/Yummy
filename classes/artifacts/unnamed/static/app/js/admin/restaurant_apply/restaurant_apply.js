/**
 * 管理初始化
 */
var RestaurantApply = {
    id: "RestaurantApplyTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};
/**
 * 初始化表格的列
 */
RestaurantApply.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: '登录编号', field: 'loginNo', visible: true, align: 'center', valign: 'middle'},
        {title: '位置X', field: 'positionX', visible: true, align: 'center', valign: 'middle'},
        {title: '位置Y', field: 'positionY', visible: true, align: 'center', valign: 'middle'},
        {title: '名称', field: 'name', visible: true, align: 'center', valign: 'middle'},
        {title: '头像', field: 'headImg', visible: true, align: 'center', valign: 'middle',formatter:RestaurantApply.headImgFormatter},
        {title: '分类', field: 'typeId', visible: true, align: 'center', valign: 'middle'},
        {title: '分类', field: 'typeName', visible: true, align: 'center', valign: 'middle'},
        {title: '地址', field: 'address', visible: true, align: 'center', valign: 'middle'},
        {title: '状态', field: 'status', visible: true, align: 'center', valign: 'middle',formatter:RestaurantApply.statusFormatter},
    ];
};

/**
 * 格式化图片
 */
RestaurantApply.headImgFormatter = function(value){
    return '<img src="'+value+'" width="100" height="100" />';
}
/**
 * 格式化类型
 */
RestaurantApply.statusFormatter = function(value){
    var kv = {1:"等待审批",2:"通过",3:"拒绝"};
    return kv[value]?kv[value]:"";
}

/**
 * 检查是否选中
 */
RestaurantApply.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        BBQ.info("请先选中表格中的某一记录！");
        return false;
    }else{
        RestaurantApply.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加
 */
RestaurantApply.openAddRestaurantApply = function () {
    var index = layer.open({
        type: 2,
        title: '添加',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: BBQ.ctxPath + '/admin/restaurant_apply/restaurant_apply_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看详情
 */
RestaurantApply.openRestaurantApplyDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: BBQ.ctxPath + '/admin/restaurant_apply/restaurant_apply_edit?id=' + RestaurantApply.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除
 */
RestaurantApply.delete = function () {
    if (this.check()) {
        $.post(BBQ.ctxPath + "/admin/restaurant_apply/delete",{id:this.seItem.id}, function (data) {
            BBQ.success("删除成功!");
            RestaurantApply.table.refresh();
        });
    }
};

/**
 * 查询列表
 */
RestaurantApply.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    RestaurantApply.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = RestaurantApply.initColumn();
    var table = new BSTable(RestaurantApply.id, "/admin/restaurant_apply/list", defaultColunms);
    table.setPaginationType("server");
    RestaurantApply.table = table.init();
});
