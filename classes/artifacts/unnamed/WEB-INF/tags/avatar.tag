<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag pageEncoding="UTF-8" %>
<%@ attribute name="id"  rtexprvalue="true" %>
<%@ attribute name="name"  rtexprvalue="true" %>
<%@ attribute name="value" rtexprvalue="true" %>
<%@ attribute name="underline" rtexprvalue="true" %>
<div class="form-group">
    <label class="col-sm-3 control-label head-scu-label">${name}</label>
    <div class="col-sm-4">
        <div id="${id}PreId">
            <div>
                <img width="100px" height="100px"
                <c:if test="${empty value}">
                  src="/static/app/images/girl.gif">
                </c:if>
                <c:if test="${not empty value}">
                    src="/${value}"  >
                </c:if>
            </div>
        </div>
    </div>
    <div class="col-sm-4">
        <div class="head-scu-btn upload-btn" id="${id}BtnId">
            <i class="fa fa-upload"></i>&nbsp;上传
        </div>
    </div>
    <input type="hidden" id="${id}" name="${id}" value="${value}"/>
</div>
<c:if test="${not empty underline}">
    <div class="hr-line-dashed"></div>
</c:if>