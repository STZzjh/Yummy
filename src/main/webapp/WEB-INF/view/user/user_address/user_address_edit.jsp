<%@ taglib tagdir="/WEB-INF/tags" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>用户地址编辑 - ${seo.mainName}</title>
    <jsp:include page="../../common/link.jsp"/>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="ibox float-e-margins">
    <div class="ibox-content">
        <div class="form-horizontal">

            <div class="row">
                <div class="col-sm-6 b-r">
                    <input type="hidden" id="id" name="id" value="${item.id}">
                    <form:input id="positionX" name="位置X" value="${item.positionX}" underline="true"/>
                    <form:input id="positionY" name="位置Y" value="${item.positionY}" underline="true"/>
                    <form:input id="name" name="地址" value="${item.name}" underline="true"/>
                </div>

                <div class="col-sm-6">
                    <form:input id="uname" name="联系人" value="${item.uname}" underline="true"/>
                    <form:input id="phone" name="电话" value="${item.phone}" underline="true"/>
                </div>
            </div>

            <div class="row btn-group-m-t">
                <div class="col-sm-10">
                    <form:button btnCss="info" name="提交" id="ensure" icon="fa-check" onclick="UserAddressInfoDlg.editSubmit()"/>
                    <form:button btnCss="danger" name="取消" id="cancel" icon="fa-eraser" onclick="UserAddressInfoDlg.close()"/>
                </div>
            </div>
        </div>

    </div>
</div>
<jsp:include page="../../common/script.jsp"/>
<script src="/static/app/js/user/user_address/user_address_info.js?v=0.123"></script>
</body>
</html>