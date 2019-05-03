/**
 * 初始化详情对话框
 */
var GoodsInfoDlg = {
    goodsInfoData : {}
};

/**
 * 清除数据
 */
GoodsInfoDlg.clearData = function() {
    this.goodsInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
GoodsInfoDlg.set = function(key, val) {
    this.goodsInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
GoodsInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
GoodsInfoDlg.close = function() {
    parent.layer.close(window.parent.Goods.layerIndex);
}

/**
 * 收集数据
 */
GoodsInfoDlg.collectData = function() {
    this
        .set('id')
        .set('name')
        .set('restaurantId')
        .set('restaurantName')
        .set('intro')
        .set('headImg')
        .set('price')
        .set('currPrice')
        .set('typeId')
        .set('typeName')
        .set('clazz')
        .set('startDate')
        .set('endDate');
}

/**
 * 提交添加
 */
GoodsInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    this.goodsInfoData['typeName'] = BBQ.selectText('typeId');

    //提交信息
    $.post(BBQ.ctxPath + "/restaurant/goods/add", this.goodsInfoData ,function(data){
        BBQ.success("添加成功!");
        window.parent.Goods.table.refresh();
        GoodsInfoDlg.close();
    });
}

/**
 * 提交修改
 */
GoodsInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    this.goodsInfoData['typeName'] = BBQ.selectText('typeId');

    //提交信息
    $.post(BBQ.ctxPath + "/restaurant/goods/update",this.goodsInfoData, function(data){
        BBQ.success("修改成功!");
        window.parent.Goods.table.refresh();
        GoodsInfoDlg.close();
    });
}

$(function() {

    var avatarUp = new $WebUpload("headImg");
    avatarUp.setUploadBarId("progressBar");
    avatarUp.init();

});
