/**
 * 管理初始化
 */
var UserAddress = {
    id: "UserAddressTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};
/**
 * 初始化表格的列
 */
UserAddress.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: '位置X', field: 'positionX', visible: true, align: 'center', valign: 'middle'},
        {title: '位置Y', field: 'positionY', visible: true, align: 'center', valign: 'middle'},
        {title: '地址', field: 'name', visible: true, align: 'center', valign: 'middle'},
        {title: '联系人', field: 'uname', visible: true, align: 'center', valign: 'middle'},
        {title: '电话', field: 'phone', visible: true, align: 'center', valign: 'middle'},
        {title: '创建时间', field: 'createTime', visible: true, align: 'center', valign: 'middle'},
    ];
};


/**
 * 检查是否选中
 */
UserAddress.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        BBQ.info("请先选中表格中的某一记录！");
        return false;
    }else{
        UserAddress.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加
 */
UserAddress.openAddUserAddress = function () {
    var index = layer.open({
        type: 2,
        title: '添加',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: BBQ.ctxPath + '/user/user_address/user_address_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看详情
 */
UserAddress.openUserAddressDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: BBQ.ctxPath + '/user/user_address/user_address_edit?id=' + UserAddress.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除
 */
UserAddress.delete = function () {
    if (this.check()) {
        $.post(BBQ.ctxPath + "/user/user_address/delete",{id:this.seItem.id}, function (data) {
            BBQ.success("删除成功!");
            UserAddress.table.refresh();
        });
    }
};

/**
 * 查询列表
 */
UserAddress.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    UserAddress.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = UserAddress.initColumn();
    var table = new BSTable(UserAddress.id, "/user/user_address/list", defaultColunms);
    table.setPaginationType("server");
    UserAddress.table = table.init();
});
