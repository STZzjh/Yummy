/**
 * 管理初始化
 */
var Restaurant = {
    id: "RestaurantTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};
/**
 * 初始化表格的列
 */
Restaurant.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: '登录编号', field: 'loginNo', visible: true, align: 'center', valign: 'middle'},
        {title: '统一社会信用代码', field: 'certNo', visible: true, align: 'center', valign: 'middle'},
        {title: '位置X', field: 'positionX', visible: true, align: 'center', valign: 'middle'},
        {title: '位置Y', field: 'poxitionY', visible: true, align: 'center', valign: 'middle'},
        {title: '名称', field: 'name', visible: true, align: 'center', valign: 'middle'},
        {title: '头像', field: 'headImg', visible: true, align: 'center', valign: 'middle',formatter:Restaurant.headImgFormatter},
        {title: '分类', field: 'typeName', visible: true, align: 'center', valign: 'middle'},
        {title: '地址', field: 'address', visible: true, align: 'center', valign: 'middle'},
        {title: '状态', field: 'status', visible: true, align: 'center', valign: 'middle',formatter:Restaurant.statusFormatter},
    ];
};

/**
 * 格式化图片
 */
Restaurant.headImgFormatter = function(value){
    return '<img src="'+value+'" width="100" height="100" />';
}
/**
 * 格式化类型
 */
Restaurant.statusFormatter = function(value){
    var kv = {0:"审批中",1:"正常营业",2:"停业整顿"};
    return kv[value]?kv[value]:"";
}

/**
 * 检查是否选中
 */
Restaurant.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        BBQ.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Restaurant.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加
 */
Restaurant.openAddRestaurant = function () {
    var index = layer.open({
        type: 2,
        title: '餐厅注册',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: BBQ.ctxPath + '/register-rest'
    });
    this.layerIndex = index;
};

/**
 * 打开查看详情
 */
Restaurant.openRestaurantDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: BBQ.ctxPath + '/admin/restaurant/restaurant_edit?id=' + Restaurant.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除
 */
Restaurant.delete = function () {
    if (this.check()) {
        $.post(BBQ.ctxPath + "/admin/restaurant/delete",{id:this.seItem.id}, function (data) {
            BBQ.success("删除成功!");
            Restaurant.table.refresh();
        });
    }
};

/**
 * 查询列表
 */
Restaurant.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Restaurant.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Restaurant.initColumn();
    var table = new BSTable(Restaurant.id, "/admin/restaurant/list", defaultColunms);
    table.setPaginationType("server");
    Restaurant.table = table.init();
});
