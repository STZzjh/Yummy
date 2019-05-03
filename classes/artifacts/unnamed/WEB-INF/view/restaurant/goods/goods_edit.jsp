<%@ taglib tagdir="/WEB-INF/tags" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>菜单编辑 - ${seo.mainName}</title>
    <jsp:include page="../../common/link.jsp"/>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="ibox float-e-margins">
    <div class="ibox-content">
        <div class="form-horizontal">

            <div class="row">
                <div class="col-sm-6 b-r">
                    <input type="hidden" id="id" name="id" value="${item.id}">
                    <form:input id="name" name="菜名" value="${item.name}" underline="true"/>
                    <form:input id="intro" name="介绍" value="${item.intro}" underline="true"/>
                    <form:avatar id="headImg" name="图片" value="${item.headImg}" underline="true"/>
                    <form:input id="price" name="标价" value="${item.price}" underline="true"/>
                </div>

                <div class="col-sm-6">
                    <form:input id="currPrice" name="实际价格" value="${item.currPrice}" underline="true"/>
                    <form:select id="typeId" name="分类" underline="true">
                        <c:forEach var="obj" items="${goodsTypeList}">
                            <option value="${obj.id}" ${item.typeId== obj.id?"selected":""}>${obj.name}</option>
                        </c:forEach>
                    </form:select>
                    <form:select id="clazz" name="类型" underline="true">
                        <option value="1" ${item.clazz==1?"selected":""}>单品</option>
                        <option value="2" ${item.clazz==2?"selected":""}>套餐</option>
                    </form:select>
                    <form:laydate id="startDate" name="菜单时效开始" value="${item.startDate}" underline="true"/>
                    <form:laydate id="endDate" name="菜单时效结束" value="${item.endDate}" underline="true"/>
                </div>
            </div>

            <div class="row btn-group-m-t">
                <div class="col-sm-10">
                    <form:button btnCss="info" name="提交" id="ensure" icon="fa-check" onclick="GoodsInfoDlg.editSubmit()"/>
                    <form:button btnCss="danger" name="取消" id="cancel" icon="fa-eraser" onclick="GoodsInfoDlg.close()"/>
                </div>
            </div>
        </div>

    </div>
</div>
<jsp:include page="../../common/script.jsp"/>
<script src="/static/app/js/restaurant/goods/goods_info.js?v=0.123"></script>
</body>
</html>