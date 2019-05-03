<%@ taglib tagdir="/WEB-INF/tags" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>餐馆编辑 - ${seo.mainName}</title>
    <jsp:include page="../../common/link.jsp"/>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="ibox float-e-margins">
    <div class="ibox-content">
        <div class="form-horizontal">

            <div class="row">
                <div class="col-sm-6 b-r">
                    <input type="hidden" id="id" name="id" value="${item.id}">
                    <form:input id="loginNo" name="登录编号" value="${item.loginNo}" underline="true"/>
                    <form:input id="password" name="密码" value="${item.password}" underline="true"/>
                    <form:input id="certNo" name="统一社会信用代码" value="${item.certNo}" underline="true"/>
                    <form:input id="positionX" name="位置X" value="${item.positionX}" underline="true"/>
                    <form:input id="positionY" name="位置Y" value="${item.positionY}" underline="true"/>
                </div>

                <div class="col-sm-6">
                    <form:input id="name" name="名称" value="${item.name}" underline="true"/>
                    <form:avatar id="headImg" name="头像" value="${item.headImg}" underline="true"/>
                    <form:select id="typeId" name="分类" underline="true">
                        <c:forEach var="obj" items="${goodsTypeList}">
                            <option value="${obj.id}" ${item.typeId== obj.id?"selected":""}>${obj.name}</option>
                        </c:forEach>
                    </form:select>
                    <form:input id="address" name="地址" value="${item.address}" underline="true"/>
                    <form:select id="status" name="状态" underline="true">
                        <option value="0" ${item.status==0?"selected":""}>审批中</option>
                        <option value="1" ${item.status==1?"selected":""}>正常营业</option>
                        <option value="2" ${item.status==2?"selected":""}>停业整顿</option>
                    </form:select>
                </div>
            </div>

            <div class="row btn-group-m-t">
                <div class="col-sm-10">
                    <form:button btnCss="info" name="提交" id="ensure" icon="fa-check" onclick="RestaurantInfoDlg.editSubmit()"/>
                    <form:button btnCss="danger" name="取消" id="cancel" icon="fa-eraser" onclick="RestaurantInfoDlg.close()"/>
                </div>
            </div>
        </div>

    </div>
</div>
<jsp:include page="../../common/script.jsp"/>
<script src="/static/app/js/restaurant/restaurant_info.js?v=0.123"></script>
</body>
</html>