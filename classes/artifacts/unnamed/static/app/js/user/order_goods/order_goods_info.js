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

    //speed
    var speed = $("#setting").attr("data-speed");

    //计算距离
    var a1x = $("#restaurant").attr("data-x");
    var a1y = $("#restaurant").attr("data-y");

    var b1x = $("#userAddressId").find(":selected").attr("data-x");
    var b1y = $("#userAddressId").find(":selected").attr("data-y");

    debugger;
    if (!speed || !a1x || !a1y || !b1x || !b1y) {
        BBQ.info("位置信息不完整，无法完成点餐");
        return;
    }

    var juli = Math.sqrt((a1x-b1x)*(a1x-b1x)+(a1y-b1y)*(a1y-b1y));
    //计算时间
    var value = $("#subscribeTime").val();
    var stime = new Date(Date.parse(value.replace("-", "/")));
    var nowTime = new Date();
    var diff = (stime - nowTime)/60/1000;
    if (diff < 0) {
        BBQ.info("无法送达");
        return;
    }
    //计算是否能够到达
    if(diff * speed < juli){
        BBQ.info("无法送达");
        return;
    }

    this.orderGoodsInfoData['userAddressName'] = BBQ.selectText('userAddressId');

    //提交信息
    $.post(BBQ.ctxPath + "/user/order_goods/add", this.orderGoodsInfoData ,function(data){
        BBQ.success("点餐成功!");
        OrderGoodsInfoDlg.close();
    });
}

/**
 * 提交修改
 */
OrderGoodsInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    this.orderGoodsInfoData['restaurantName'] = BBQ.selectText('restaurantId');
    this.orderGoodsInfoData['goodsName'] = BBQ.selectText('goodsId');
    this.orderGoodsInfoData['userAddressName'] = BBQ.selectText('userAddressId');

    //提交信息
    $.post(BBQ.ctxPath + "/user/order_goods/update",this.orderGoodsInfoData, function(data){
        BBQ.success("修改成功!");
        window.parent.OrderGoods.table.refresh();
        OrderGoodsInfoDlg.close();
    });
}

$(function() {


});
