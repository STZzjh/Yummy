<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>餐馆新增 - ${seo.mainName}</title>
    <jsp:include page="../../common/link.jsp"/>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="ibox float-e-margins">
    <div class="ibox-content">
        <div class="form-horizontal">

            <div class="row">
                <div class="col-sm-6 b-r">
                    <form:input id="certNo" name="统一社会信用代码" underline="true"/>
                    <form:input id="positionX" name="位置X" underline="true"/>
                    <form:input id="positionY" name="位置Y" underline="true"/>
                    <form:input id="name" name="名称" underline="true"/>
                </div>

                <div class="col-sm-6">
                    <form:avatar id="headImg" name="头像" underline="true"/>
                    <form:select id="typeId" name="分类" underline="true">
                        <c:forEach items="${restTypeList}" var="restType">
                            <option value="${restType.id}">${restType.name}</option>
                        </c:forEach>
                    </form:select>
                    <form:input id="address" name="地址" underline="true"/>
                </div>
            </div>

            <div class="row btn-group-m-t">
                <div class="col-sm-10">
                    <form:button btnCss="info" name="提交" id="ensure" icon="fa-check" onclick="RestaurantInfoDlg.addSubmit()"/>
                    <form:button btnCss="danger" name="取消" id="cancel" icon="fa-eraser" onclick="RestaurantInfoDlg.close()"/>
                </div>
            </div>
        </div>

    </div>
</div>
<jsp:include page="../../common/script.jsp"/>
<script src="/static/app/js/admin/restaurant/restaurant_info.js?v=0.44"></script>
</body>
</html>