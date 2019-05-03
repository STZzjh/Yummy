<%@ taglib tagdir="/WEB-INF/tags" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <input type="hidden" id="id" name="id" value="${item.id}">
                <form:info id="certNo" left="3" name="统一社会信用代码" value="${item.certNo}" underline="true"/>
                <form:info id="positionX" left="3" name="位置X" value="${item.positionX}" underline="true"/>
                <form:info id="positionY" left="3" name="位置Y" value="${item.positionY}" underline="true"/>
                <form:info id="name" name="名称" left="3" value="${item.name}" underline="true"/>
                <form:image id="headImg" name="头像" value="${item.headImg}" underline="true"/>
                <form:info id="typeName" name="分类" left="3" value="${item.typeName}" underline="true"/>
                <form:info id="address" name="地址" left="3" value="${item.address}" underline="true"/>
                <form:select id="status" name="状态" underline="true">
                    <option value="0" ${item.status==0?"selected":""}>审批中</option>
                    <option value="1" ${item.status==1?"selected":""}>正常营业</option>
                    <option value="2" ${item.status==2?"selected":""}>停业整顿</option>
                </form:select>
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
<script src="/static/app/js/admin/restaurant/restaurant_info.js?v=0.123"></script>
</body>
</html>