/**
 * 初始化详情对话框
 */
var RestTypeInfoDlg = {
    restTypeInfoData : {}
};

/**
 * 清除数据
 */
RestTypeInfoDlg.clearData = function() {
    this.restTypeInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
RestTypeInfoDlg.set = function(key, val) {
    this.restTypeInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
RestTypeInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
RestTypeInfoDlg.close = function() {
    parent.layer.close(window.parent.RestType.layerIndex);
}

/**
 * 收集数据
 */
RestTypeInfoDlg.collectData = function() {
    this
        .set('id')
        .set('name')
        .set('intro');
}

/**
 * 提交添加
 */
RestTypeInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    $.post(BBQ.ctxPath + "/admin/rest_type/add", this.restTypeInfoData ,function(data){
        BBQ.success("添加成功!");
        window.parent.RestType.table.refresh();
        RestTypeInfoDlg.close();
    });
}

/**
 * 提交修改
 */
RestTypeInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    $.post(BBQ.ctxPath + "/admin/rest_type/update",this.restTypeInfoData, function(data){
        BBQ.success("修改成功!");
        window.parent.RestType.table.refresh();
        RestTypeInfoDlg.close();
    });
}

$(function() {

});
