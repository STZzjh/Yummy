<%@ taglib tagdir="/WEB-INF/tags" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>${seo.mainName}</title>
    <jsp:include page="../common/link.jsp"/>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="ibox float-e-margins" style="margin-top: 20px;">
    <div class="ibox-content">
        <div class="form-horizontal">

            <div class="row">
                <form:input id="certNo"  name="统一社会信用代码" value="${item.certNo}" underline="true"/>
                <form:input id="positionX"  name="位置X" value="${item.positionX}" underline="true"/>
                <form:input id="positionY"  name="位置Y" value="${item.positionY}" underline="true"/>
                <form:input id="name" name="名称"  value="${item.name}" underline="true"/>
                <form:avatar id="headImg" name="头像" value="${item.headImg}" underline="true"/>
                <form:input id="address" name="地址"  value="${item.address}" underline="true"/>
            </div>

            <div class="row btn-group-m-t">
                <div class="col-sm-9 col-sm-offset-3">
                    <form:button btnCss="info" name="保存" id="ensure" icon="fa-check" onclick="RestaurantInfoDlg.editSubmit()"/>
                </div>
            </div>
        </div>

    </div>
</div>
<jsp:include page="../common/script.jsp"/>
<script src="/static/app/js/restaurant/restaurant_info.js?v=0.3"></script>
</body>
</html>