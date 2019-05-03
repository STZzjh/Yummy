/**
 * 初始化详情对话框
 */
var OrderTimeInfoDlg = {
    orderTimeInfoData : {}
};

/**
 * 清除数据
 */
OrderTimeInfoDlg.clearData = function() {
    this.orderTimeInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
OrderTimeInfoDlg.set = function(key, val) {
    this.orderTimeInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
OrderTimeInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
OrderTimeInfoDlg.close = function() {
    parent.layer.close(window.parent.OrderTime.layerIndex);
}

/**
 * 收集数据
 */
OrderTimeInfoDlg.collectData = function() {
    this
        .set('id')
        .set('orderNo')
        .set('status')
        .set('statusTime')
        .set('createTime');
}

/**
 * 提交添加
 */
OrderTimeInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();


    //提交信息
    $.post(BBQ.ctxPath + "/user/order_time/add", this.orderTimeInfoData ,function(data){
        BBQ.success("添加成功!");
        window.parent.OrderTime.table.refresh();
        OrderTimeInfoDlg.close();
    });
}

/**
 * 提交修改
 */
OrderTimeInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();


    //提交信息
    $.post(BBQ.ctxPath + "/user/order_time/update",this.orderTimeInfoData, function(data){
        BBQ.success("修改成功!");
        window.parent.OrderTime.table.refresh();
        OrderTimeInfoDlg.close();
    });
}

$(function() {


});
