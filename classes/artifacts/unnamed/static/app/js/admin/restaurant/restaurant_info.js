/**
 * 初始化详情对话框
 */
var RestaurantInfoDlg = {
    restaurantInfoData : {}
};

/**
 * 清除数据
 */
RestaurantInfoDlg.clearData = function() {
    this.restaurantInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
RestaurantInfoDlg.set = function(key, val) {
    this.restaurantInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
RestaurantInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
RestaurantInfoDlg.close = function() {
    parent.layer.close(window.parent.Restaurant.layerIndex);
}

/**
 * 收集数据
 */
RestaurantInfoDlg.collectData = function() {
    this
        .set('id')
        .set('loginNo')
        .set('password')
        .set('certNo')
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
RestaurantInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    this.restaurantInfoData['typeName'] = BBQ.selectText("typeId");

    //提交信息
    $.post(BBQ.ctxPath + "/register-rest", this.restaurantInfoData ,function(data){
        if (data.code == 1) {
            BBQ.success(data.msg);
            RestaurantInfoDlg.close();
        }else{
            BBQ.error(data.msg);
        }

    });
}

/**
 * 提交修改
 */
RestaurantInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    $.post(BBQ.ctxPath + "/admin/restaurant/update",this.restaurantInfoData, function(data){
        BBQ.success("修改成功!");
        window.parent.Restaurant.table.refresh();
        RestaurantInfoDlg.close();
    });
}

$(function() {

    // 初始化头像上传
    var avatarUp = new $WebUpload("headImg");
    avatarUp.setUploadBarId("progressBar");
    avatarUp.init();
});
