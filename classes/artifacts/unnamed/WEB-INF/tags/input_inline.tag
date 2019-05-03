<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag pageEncoding="UTF-8" %>
<%@ attribute name="id"  rtexprvalue="true" %>
<%@ attribute name="name"  rtexprvalue="true" %>
<%@ attribute name="style" rtexprvalue="true" %>
<%@ attribute name="type" rtexprvalue="true" %>
<div class="form-group">
    <label>
        ${name}
    </label>
    <input class="form-control" id="${id}" name="${id}" value="${value}" type="${not empty type?type:'text'}"
    <c:if test="${not empty style}">
           style="${style}"
    </c:if> />
</div>