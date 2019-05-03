/**
 * 初始化详情对话框
 */
var GoodsTypeInfoDlg = {
    goodsTypeInfoData : {}
};

/**
 * 清除数据
 */
GoodsTypeInfoDlg.clearData = function() {
    this.goodsTypeInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
GoodsTypeInfoDlg.set = function(key, val) {
    this.goodsTypeInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
GoodsTypeInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
GoodsTypeInfoDlg.close = function() {
    parent.layer.close(window.parent.GoodsType.layerIndex);
}

/**
 * 收集数据
 */
GoodsTypeInfoDlg.collectData = function() {
    this
        .set('id')
        .set('name')
        .set('intro');
}

/**
 * 提交添加
 */
GoodsTypeInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    $.post(BBQ.ctxPath + "/admin/goods_type/add", this.goodsTypeInfoData ,function(data){
        BBQ.success("添加成功!");
        window.parent.GoodsType.table.refresh();
        GoodsTypeInfoDlg.close();
    });
}

/**
 * 提交修改
 */
GoodsTypeInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    $.post(BBQ.ctxPath + "/admin/goods_type/update",this.goodsTypeInfoData, function(data){
        BBQ.success("修改成功!");
        window.parent.GoodsType.table.refresh();
        GoodsTypeInfoDlg.close();
    });
}

$(function() {

});
