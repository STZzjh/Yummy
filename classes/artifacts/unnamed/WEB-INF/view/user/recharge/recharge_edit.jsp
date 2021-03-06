<%@ taglib tagdir="/WEB-INF/tags" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>充值记录编辑 - ${seo.mainName}</title>
    <jsp:include page="../../common/link.jsp"/>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="ibox float-e-margins">
    <div class="ibox-content">
        <div class="form-horizontal">

            <div class="row">
                <div class="col-sm-6 b-r">
                    <input type="hidden" id="id" name="id" value="${item.id}">
                    <form:input id="money" name="金额" value="${item.money}" underline="true"/>
                </div>

                <div class="col-sm-6">
                    <form:select id="bank" name="银行" underline="true">
                        <option value="1" ${item.bank==1?"selected":""}>招商银行</option>
                        <option value="2" ${item.bank==2?"selected":""}>建设银行</option>
                        <option value="3" ${item.bank==3?"selected":""}>交通银行</option>
                        <option value="4" ${item.bank==4?"selected":""}>工商银行</option>
                    </form:select>
                </div>
            </div>

            <div class="row btn-group-m-t">
                <div class="col-sm-10">
                    <form:button btnCss="info" name="提交" id="ensure" icon="fa-check" onclick="RechargeInfoDlg.editSubmit()"/>
                    <form:button btnCss="danger" name="取消" id="cancel" icon="fa-eraser" onclick="RechargeInfoDlg.close()"/>
                </div>
            </div>
        </div>

    </div>
</div>
<jsp:include page="../../common/script.jsp"/>
<script src="/static/app/js/user/recharge/recharge_info.js?v=0.123"></script>
</body>
</html>