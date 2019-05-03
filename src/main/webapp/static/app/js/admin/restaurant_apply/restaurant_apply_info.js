/**
 * 初始化详情对话框
 */
var RestaurantApplyInfoDlg = {
    restaurantApplyInfoData : {}
};

/**
 * 清除数据
 */
RestaurantApplyInfoDlg.clearData = function() {
    this.restaurantApplyInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
RestaurantApplyInfoDlg.set = function(key, val) {
    this.restaurantApplyInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
RestaurantApplyInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
RestaurantApplyInfoDlg.close = function() {
    parent.layer.close(window.parent.RestaurantApply.layerIndex);
}

/**
 * 收集数据
 */
RestaurantApplyInfoDlg.collectData = function() {
    this
        .set('id')
        .set('loginNo')
        .set('positionX')
        .set('positionY')
        .set('name')
        .set('headImg')
        .set('typeId')
        .set('typeName')
        .set('address')
        .set('status');
}

/**
 * 提交添加
 */
RestaurantApplyInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    $.post(BBQ.ctxPath + "/admin/restaurant_apply/add", this.restaurantApplyInfoData ,function(data){
        BBQ.success("添加成功!");
        window.parent.RestaurantApply.table.refresh();
        RestaurantApplyInfoDlg.close();
    });
}

/**
 * 提交修改
 */
RestaurantApplyInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    $.post(BBQ.ctxPath + "/admin/restaurant_apply/update",this.restaurantApplyInfoData, function(data){
        BBQ.success("修改成功!");
        window.parent.RestaurantApply.table.refresh();
        RestaurantApplyInfoDlg.close();
    });
}

$(function() {

});
