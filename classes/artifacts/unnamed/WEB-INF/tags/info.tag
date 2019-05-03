<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag pageEncoding="UTF-8" %>
<%@ attribute name="id"  rtexprvalue="true" %>
<%@ attribute name="name"  rtexprvalue="true" %>
<%@ attribute name="value"  rtexprvalue="true" %>
<%@ attribute name="left"  rtexprvalue="true" %>
<%@ attribute name="right"  rtexprvalue="true" %>
<%@ attribute name="underline" rtexprvalue="true" %>
<%@ attribute name="required" rtexprvalue="false" %>
<div class="form-group" >
    <label class="col-sm-${not empty left?left:6} control-label">
        ${name} :
        <c:if test="${not empty required}">
            <span style="color:red;">*</span>
        </c:if>
    </label>
    <div class="col-sm-${not empty right?right:6}  control-label" style="text-align: left">
        ${value}
        <jsp:doBody />
    </div>
</div>
<c:if test="${not empty underline}">
    <div class="hr-line-dashed"></div>
</c:if>