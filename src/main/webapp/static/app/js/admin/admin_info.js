/**
 * 初始化详情对话框
 */
var AdminInfoDlg = {
    adminInfoData : {},
    validateFields: {
        oldpassword: {
            validators: {
                notEmpty: {
                    message: '不能为空'
                }
            }
        },
        newpassword: {
            validators: {
                stringLength: {
                    min: 6,
                    max: 20,
                    message: '密码长度6-20！'
                },
                notEmpty: {
                    message: '不能为空'
                }
            }
        },
        repassword: {
            validators: {
                notEmpty: {
                    message: '不能为空'
                },
                identical: {
                    field: 'newpassword'
                }
            }
        }
    }
};

/**
 * 清除数据
 */
AdminInfoDlg.clearData = function() {
    this.adminInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
AdminInfoDlg.set = function(key, val) {
    this.adminInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
AdminInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
AdminInfoDlg.close = function() {
    parent.layer.close(window.parent.Admin.layerIndex);
}

/**
 * 收集数据
 */
AdminInfoDlg.collectData = function() {
    this
    .set('id')
    .set('intro')
}

/**
 * 验证数据是否为空
 */
AdminInfoDlg.validate = function () {
    $('#passwordForm').data("bootstrapValidator").resetForm();
    $('#passwordForm').bootstrapValidator('validate');
    return $("#passwordForm").data('bootstrapValidator').isValid();
}

/**
 * 提交添加
 */
AdminInfoDlg.passwordSubmit = function() {

    if(!AdminInfoDlg.validate()){
        return;
    }
    var subData = {old:$("#oldpassword").val(),newpwd:$("#newpassword").val()};
    //提交信息
    $.post(BBQ.ctxPath + "/admin/password/update", subData, function(data){
        if(data.code<0){
            BBQ.error(data.msg);
        }else{
            BBQ.success("修改密码成功!");
        }
    });
}

/**
 * 提交修改
 */
AdminInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    $.post(BBQ.ctxPath + "/admin/profile/update", this.adminInfoData , function(data){
        BBQ.success("修改成功!");
    });
}

$(function() {
    BBQ.initValidator("passwordForm", AdminInfoDlg.validateFields);

});
