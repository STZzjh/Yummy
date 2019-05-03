<%@ taglib tagdir="/WEB-INF/tags" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>订单表编辑 - ${seo.mainName}</title>
    <jsp:include page="../../common/link.jsp"/>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="ibox float-e-margins">
    <div class="ibox-content">
        <div class="form-horizontal">

            <div class="row">
                <div class="col-sm-6 b-r">
                    <input type="hidden" id="id" name="id" value="${item.id}">
                    <form:input id="orderNo" name="订单号" value="${item.orderNo}" underline="true"/>
                    <form:select id="restaurantId" name="餐馆" underline="true">
                        <c:forEach var="obj" items="${restaurantList}">
                            <option value="${obj.id}" ${item.restaurantId== obj.id?"selected":""}>${obj.name}</option>
                        </c:forEach>
                    </form:select>
                    <form:select id="goodsId" name="菜品" underline="true">
                        <c:forEach var="obj" items="${goodsList}">
                            <option value="${obj.id}" ${item.goodsId== obj.id?"selected":""}>${obj.name}</option>
                        </c:forEach>
                    </form:select>
                    <form:input id="price" name="价格" value="${item.price}" underline="true"/>
                    <form:select id="userAddressId" name="" underline="true">
                        <c:forEach var="obj" items="${userAddressList}">
                            <option value="${obj.id}" ${item.userAddressId== obj.id?"selected":""}>${obj.name}</option>
                        </c:forEach>
                    </form:select>
                </div>

                <div class="col-sm-6">
                    <form:select id="status" name="状态" underline="true">
                        <option value="1" ${item.status==1?"selected":""}>提交订单</option>
                        <option value="2" ${item.status==2?"selected":""}>支付完成</option>
                        <option value="3" ${item.status==3?"selected":""}>已发货</option>
                        <option value="4" ${item.status==4?"selected":""}>确认收货</option>
                        <option value="5" ${item.status==5?"selected":""}>退订</option>
                        <option value="6" ${item.status==6?"selected":""}>取消</option>
                        <option value="7" ${item.status==7?"selected":""}>自动取消</option>
                    </form:select>
                    <form:input id="userIn" name="用户收入" value="${item.userIn}" underline="true"/>
                    <form:input id="adminIn" name="平台收入" value="${item.adminIn}" underline="true"/>
                    <form:input id="restaurantIn" name="餐厅收入" value="${item.restaurantIn}" underline="true"/>
                    <form:input id="subscribeTime" name="预约时间" value="${item.subscribeTime}" underline="true"/>
                </div>
            </div>

            <div class="row btn-group-m-t">
                <div class="col-sm-10">
                    <form:button btnCss="info" name="提交" id="ensure" icon="fa-check" onclick="OrderGoodsInfoDlg.editSubmit()"/>
                    <form:button btnCss="danger" name="取消" id="cancel" icon="fa-eraser" onclick="OrderGoodsInfoDlg.close()"/>
                </div>
            </div>
        </div>

    </div>
</div>
<jsp:include page="../../common/script.jsp"/>
<script src="/static/app/js/user/order_goods/order_goods_info.js?v=0.123"></script>
</body>
</html>