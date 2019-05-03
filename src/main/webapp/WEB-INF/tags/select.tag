<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag pageEncoding="UTF-8" %>
<%@ attribute name="id"  rtexprvalue="true" %>
<%@ attribute name="name"  rtexprvalue="true" %>
<%@ attribute name="options"  rtexprvalue="true" type="java.util.List" %>
<%@ attribute name="value"  rtexprvalue="true" %>
<%@ attribute name="readonly"  rtexprvalue="true" %>
<%@ attribute name="style" rtexprvalue="true" %>
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
        <select class="form-control" id="${id}" name="${id}" value="${value}"
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
            <jsp:doBody />
            <c:if test="${not empty options}">
                <c:forEach items="${options}" var="itemObjet">
                    <option value="${itemObjet.ikey}">${itemObjet.ivalue}</option>
                </c:forEach>
            </c:if>
        </select>

    </div>
</div>
<c:if test="${not empty underline}">
    <div class="hr-line-dashed"></div>
</c:if>