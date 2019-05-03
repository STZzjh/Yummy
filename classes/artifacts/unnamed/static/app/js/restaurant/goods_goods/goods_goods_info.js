/**
 * 初始化详情对话框
 */
var GoodsGoodsInfoDlg = {
    goodsGoodsInfoData : {}
};

/**
 * 清除数据
 */
GoodsGoodsInfoDlg.clearData = function() {
    this.goodsGoodsInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
GoodsGoodsInfoDlg.set = function(key, val) {
    this.goodsGoodsInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
GoodsGoodsInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
GoodsGoodsInfoDlg.close = function() {
    parent.layer.close(window.parent.GoodsGoods.layerIndex);
}

/**
 * 收集数据
 */
GoodsGoodsInfoDlg.collectData = function() {
    this
        .set('id')
        .set('goodsId')
        .set('subgoodsId')
        .set('subgoodsName');
}

/**
 * 提交添加
 */
GoodsGoodsInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    $.post(BBQ.ctxPath + "/restaurant/goods_goods/add", this.goodsGoodsInfoData ,function(data){
        BBQ.success("添加成功!");
        window.parent.GoodsGoods.table.refresh();
        GoodsGoodsInfoDlg.close();
    });
}

/**
 * 提交修改
 */
GoodsGoodsInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    $.post(BBQ.ctxPath + "/restaurant/goods_goods/update",this.goodsGoodsInfoData, function(data){
        BBQ.success("修改成功!");
        window.parent.GoodsGoods.table.refresh();
        GoodsGoodsInfoDlg.close();
    });
}

$(function() {

});
