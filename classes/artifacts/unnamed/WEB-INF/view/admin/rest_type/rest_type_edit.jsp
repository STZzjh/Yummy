<%@ taglib tagdir="/WEB-INF/tags" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>餐厅类型编辑 - ${seo.mainName}</title>
    <jsp:include page="../../common/link.jsp"/>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="ibox float-e-margins">
    <div class="ibox-content">
        <div class="form-horizontal">

            <div class="row">
                <div class="col-sm-6 b-r">
                    <input type="hidden" id="id" name="id" value="${item.id}">
                    <form:input id="name" name="分类名称" value="${item.name}" underline="true"/>
                </div>

                <div class="col-sm-6">
                    <form:input id="intro" name="简介" value="${item.intro}" underline="true"/>
                </div>
            </div>

            <div class="row btn-group-m-t">
                <div class="col-sm-10">
                    <form:button btnCss="info" name="提交" id="ensure" icon="fa-check" onclick="RestTypeInfoDlg.editSubmit()"/>
                    <form:button btnCss="danger" name="取消" id="cancel" icon="fa-eraser" onclick="RestTypeInfoDlg.close()"/>
                </div>
            </div>
        </div>

    </div>
</div>
<jsp:include page="../../common/script.jsp"/>
<script src="/static/app/js/admin/rest_type/rest_type_info.js?v=0.123"></script>
</body>
</html>