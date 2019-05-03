/**
 * 初始化详情对话框
 */
var UserInfoDlg = {
    userInfoData : {},
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
UserInfoDlg.clearData = function() {
    this.userInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
UserInfoDlg.set = function(key, val) {
    this.userInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
UserInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
UserInfoDlg.close = function() {
    parent.layer.close(window.parent.User.layerIndex);
}

/**
 * 收集数据
 */
UserInfoDlg.collectData = function() {
    this
    .set('id')
    .set('number')
    .set('password')
    .set('name')
    .set('sex')
    .set('headImg')
    .set('intro')
    .set('address')
    .set('phone')
    .set('email')
}


/**
 * 验证数据是否为空
 */
UserInfoDlg.validate = function () {
    $('#passwordForm').data("bootstrapValidator").resetForm();
    $('#passwordForm').bootstrapValidator('validate');
    return $("#passwordForm").data('bootstrapValidator').isValid();
}

/**
 * 提交添加
 */
UserInfoDlg.passwordSubmit = function() {

    this.clearData();
    this.collectData();

    if(!this.validate()){
        return;
    }
    var subData = {old:$("#oldpassword").val(),newpwd:$("#newpassword").val()};
    //提交信息
    $.post(BBQ.ctxPath + "/user/password/update",subData, function(data){
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
UserInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    $.post(BBQ.ctxPath + "/user/profile/update",this.userInfoData, function(data){
        BBQ.success("修改成功!");
    });
}

UserInfoDlg.delete = function() {

    BBQ.confirm("真的要注销吗？",function () {
        //提交信息
        $.post(BBQ.ctxPath + "/user/delete",this.userInfoData, function(data){
            BBQ.success("注销成功!");
        });
    })


}

$(function() {
    // 初始化头像上传
    var avatarUp = new $WebUpload("headImg");
    avatarUp.setUploadBarId("progressBar");
    avatarUp.init();

    BBQ.initValidator("passwordForm", UserInfoDlg.validateFields);
});
