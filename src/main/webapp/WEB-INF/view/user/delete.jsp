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
                感谢您的支持。一经注销不能恢复。
            </div>

            <div class="row btn-group-m-t">
                <div class="col-sm-9 col-sm-offset-3">
                    <form:button btnCss="info" name="确认注销" id="ensure" icon="fa-check" onclick="UserInfoDlg.delete()"/>
                </div>
            </div>
        </div>

    </div>
</div>
<jsp:include page="../common/script.jsp"/>
<script src="/static/app/js/user/user_info.js?v=0.3"></script>
</body>
</html>