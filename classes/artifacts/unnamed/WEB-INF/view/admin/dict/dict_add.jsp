<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>系统设置新增 - ${seo.mainName}</title>
    <jsp:include page="../../common/link.jsp"/>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="ibox float-e-margins">
    <div class="ibox-content">
        <div class="form-horizontal">

            <div class="row">
                <div class="col-sm-6 b-r">
                    <form:input id="code" name="CODE" underline="true"/>
                    <form:input id="name" name="名称" underline="true"/>
                </div>

                <div class="col-sm-6">
                    <form:input id="value" name="值" underline="true"/>
                </div>
            </div>

            <div class="row btn-group-m-t">
                <div class="col-sm-10">
                    <form:button btnCss="info" name="提交" id="ensure" icon="fa-check" onclick="DictInfoDlg.addSubmit()"/>
                    <form:button btnCss="danger" name="取消" id="cancel" icon="fa-eraser" onclick="DictInfoDlg.close()"/>
                </div>
            </div>
        </div>

    </div>
</div>
<jsp:include page="../../common/script.jsp"/>
<script src="/static/app/js/admin/dict/dict_info.js?v=0.123"></script>
</body>
</html>