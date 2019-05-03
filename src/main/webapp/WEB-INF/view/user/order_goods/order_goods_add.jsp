<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>订单表新增 - ${seo.mainName}</title>
    <jsp:include page="../../common/link.jsp"/>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="ibox float-e-margins">
    <div class="ibox-content">
        <div class="form-horizontal">

            <div class="row">

                <input type="hidden" id="setting" data-speed="${setting.Speed}">
                <input type="hidden" id="restaurant" data-x="${restaurant.positionX}" data-y="${restaurant.positionY}">
                <input type="hidden" id="restaurantId" value="${restaurant.id}">
                <input type="hidden" id="goodsId" value="${goods.id}">
                <form:input id="restaurantName" readonly="true" name="餐馆" value="${restaurant.name}"  underline="true" />
                <form:input id="goodsName" name="菜品" readonly="true" value="${goods.name}" underline="true" />
                <form:input id="price" name="价格" readonly="true" value="${goods.currPrice}" underline="true"/>
                <form:select id="userAddressId" name="送餐地址" underline="true">
                    <c:forEach var="obj" items="${userAddressList}">
                        <option data-x="${obj.positionX}" data-y="${obj.positionY}" value="${obj.id}">${obj.name}</option>
                    </c:forEach>
                </form:select>
                <form:time id="subscribeTime" name="送餐时间"/>
            </div>

            <div class="row btn-group-m-t">
                <div class="col-sm-10">
                    <form:button btnCss="info" name="提交" id="ensure" icon="fa-check" onclick="OrderGoodsInfoDlg.addSubmit()"/>
                    <form:button btnCss="danger" name="取消" id="cancel" icon="fa-eraser" onclick="OrderGoodsInfoDlg.close()"/>
                </div>
            </div>
        </div>

    </div>
</div>
<jsp:include page="../../common/script.jsp"/>
<script src="/static/app/js/user/order_goods/order_goods_info.js?v=0.16"></script>
</body>
</html>