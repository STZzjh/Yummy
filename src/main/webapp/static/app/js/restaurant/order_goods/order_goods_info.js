/**
 * 初始化详情对话框
 */
var OrderGoodsInfoDlg = {
    orderGoodsInfoData : {}
};

/**
 * 清除数据
 */
OrderGoodsInfoDlg.clearData = function() {
    this.orderGoodsInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
OrderGoodsInfoDlg.set = function(key, val) {
    this.orderGoodsInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
OrderGoodsInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
OrderGoodsInfoDlg.close = function() {
    parent.layer.close(window.parent.OrderGoods.layerIndex);
}

/**
 * 收集数据
 */
OrderGoodsInfoDlg.collectData = function() {
    this
        .set('id')
        .set('orderNo')
        .set('restaurantId')
        .set('restaurantName')
        .set('userId')
        .set('userName')
        .set('goodsId')
        .set('goodsName')
        .set('price')
        .set('userAddressId')
        .set('userAddressName')
        .set('status')
        .set('userIn')
        .set('adminIn')
        .set('restaurantIn')
        .set('subscribeTime')
        .set('createTime');
}

/**
 * 提交添加
 */
OrderGoodsInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    this.orderGoodsInfoData['userName'] = BBQ.selectText('userId');
    this.orderGoodsInfoData['goodsName'] = BBQ.selectText('goodsId');
    this.orderGoodsInfoData['userAddressName'] = BBQ.selectText('userAddressId');

    //提交信息
    $.post(BBQ.ctxPath + "/restaurant/order_goods/add", this.orderGoodsInfoData ,function(data){
        BBQ.success("添加成功!");
        window.parent.OrderGoods.table.refresh();
        OrderGoodsInfoDlg.close();
    });
}

/**
 * 提交修改
 */
OrderGoodsInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    this.orderGoodsInfoData['userName'] = BBQ.selectText('userId');
    this.orderGoodsInfoData['goodsName'] = BBQ.selectText('goodsId');
    this.orderGoodsInfoData['userAddressName'] = BBQ.selectText('userAddressId');

    //提交信息
    $.post(BBQ.ctxPath + "/restaurant/order_goods/update",this.orderGoodsInfoData, function(data){
        BBQ.success("修改成功!");
        window.parent.OrderGoods.table.refresh();
        OrderGoodsInfoDlg.close();
    });
}

$(function() {


});
