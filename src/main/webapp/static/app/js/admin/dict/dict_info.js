/**
 * 初始化详情对话框
 */
var DictInfoDlg = {
    dictInfoData : {}
};

/**
 * 清除数据
 */
DictInfoDlg.clearData = function() {
    this.dictInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
DictInfoDlg.set = function(key, val) {
    this.dictInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
DictInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
DictInfoDlg.close = function() {
    parent.layer.close(window.parent.Dict.layerIndex);
}

/**
 * 收集数据
 */
DictInfoDlg.collectData = function() {
    this
        .set('id')
        .set('code')
        .set('name')
        .set('value');
}

/**
 * 提交添加
 */
DictInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    $.post(BBQ.ctxPath + "/admin/dict/add", this.dictInfoData ,function(data){
        BBQ.success("添加成功!");
        window.parent.Dict.table.refresh();
        DictInfoDlg.close();
    });
}

/**
 * 提交修改
 */
DictInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    $.post(BBQ.ctxPath + "/admin/dict/update",this.dictInfoData, function(data){
        BBQ.success("修改成功!");
        window.parent.Dict.table.refresh();
        DictInfoDlg.close();
    });
}

$(function() {

});
