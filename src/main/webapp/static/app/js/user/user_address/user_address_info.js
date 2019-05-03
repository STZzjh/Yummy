/**
 * 初始化详情对话框
 */
var UserAddressInfoDlg = {
    userAddressInfoData : {}
};

/**
 * 清除数据
 */
UserAddressInfoDlg.clearData = function() {
    this.userAddressInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
UserAddressInfoDlg.set = function(key, val) {
    this.userAddressInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
UserAddressInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
UserAddressInfoDlg.close = function() {
    parent.layer.close(window.parent.UserAddress.layerIndex);
}

/**
 * 收集数据
 */
UserAddressInfoDlg.collectData = function() {
    this
        .set('id')
        .set('positionX')
        .set('positionY')
        .set('name')
        .set('userId')
        .set('uname')
        .set('phone')
        .set('userName')
        .set('createTime');
}

/**
 * 提交添加
 */
UserAddressInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();


    //提交信息
    $.post(BBQ.ctxPath + "/user/user_address/add", this.userAddressInfoData ,function(data){
        BBQ.success("添加成功!");
        window.parent.UserAddress.table.refresh();
        UserAddressInfoDlg.close();
    });
}

/**
 * 提交修改
 */
UserAddressInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();


    //提交信息
    $.post(BBQ.ctxPath + "/user/user_address/update",this.userAddressInfoData, function(data){
        BBQ.success("修改成功!");
        window.parent.UserAddress.table.refresh();
        UserAddressInfoDlg.close();
    });
}

$(function() {


});
