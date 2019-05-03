<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ tag pageEncoding="UTF-8" %>
<%@ attribute name="id"  rtexprvalue="true" %>
<%@ attribute name="name"  rtexprvalue="true" %>
<%@ attribute name="value"  rtexprvalue="true" type="java.util.Date" %>
<%@ attribute name="readonly"  rtexprvalue="true" %>
<%@ attribute name="style" rtexprvalue="true" %>
<%@ attribute name="type" rtexprvalue="true" %>
<%@ attribute name="disabled" rtexprvalue="true" %>
<%@ attribute name="underline" rtexprvalue="true" %>
<%@ attribute name="required" rtexprvalue="false" %>
<div class="form-group">
    <label class="col-sm-3 control-label">
        ${name}
        <c:if test="${not empty required}">
            <span style="color:red;">*</span>
        </c:if>
    </label>
    <div class="col-sm-8">
        <input class="form-control" id="${id}" name="${id}" value="<fmt:formatDate value="${value}" type="date"/>" type="${not empty type?type:'text'}"
        <c:if test="${not empty readonly}">
               readonly="${readonly}"
        </c:if>
        <c:if test="${not empty style}">
               style="${style}"
        </c:if>
        <c:if test="${not empty disabled}">
               disabled="${disabled}"
        </c:if>
        >

    </div>
</div>
<c:if test="${not empty underline}">
    <div class="hr-line-dashed"></div>
</c:if>
<script>
    $(document).ready(function () {
        laydate.render({
            elem: '#${id}'
            ,type: 'datetime'
        });
    });
</script>