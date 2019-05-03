/**
 * 初始化详情对话框
 */
var RechargeInfoDlg = {
    rechargeInfoData : {}
};

/**
 * 清除数据
 */
RechargeInfoDlg.clearData = function() {
    this.rechargeInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
RechargeInfoDlg.set = function(key, val) {
    this.rechargeInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
RechargeInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
RechargeInfoDlg.close = function() {
    parent.layer.close(window.parent.Recharge.layerIndex);
}

/**
 * 收集数据
 */
RechargeInfoDlg.collectData = function() {
    this
        .set('id')
        .set('userId')
        .set('userName')
        .set('money')
        .set('bank')
        .set('createTime');
}

/**
 * 提交添加
 */
RechargeInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();


    //提交信息
    $.post(BBQ.ctxPath + "/user/recharge/add", this.rechargeInfoData ,function(data){
        BBQ.success("添加成功!");
        window.parent.Recharge.table.refresh();
        RechargeInfoDlg.close();
    });
}

/**
 * 提交修改
 */
RechargeInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();


    //提交信息
    $.post(BBQ.ctxPath + "/user/recharge/update",this.rechargeInfoData, function(data){
        BBQ.success("修改成功!");
        window.parent.Recharge.table.refresh();
        RechargeInfoDlg.close();
    });
}

$(function() {


});
