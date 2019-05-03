<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ tag pageEncoding="UTF-8" %>
<%@ attribute name="id"  rtexprvalue="true" %>
<%@ attribute name="name"  rtexprvalue="true" %>
<%@ attribute name="style" rtexprvalue="true" %>
<%@ attribute name="type" rtexprvalue="true" %>
<div class="form-group">
    <label>${name}</label>
    <input class="form-control" id="${id}Start" name="${id}" type="${not empty type?type:'text'}"
    <c:if test="${not empty style}">
           style="${style}"
    </c:if> /> ~
    <input class="form-control" id="${id}End" name="${id}" type="${not empty type?type:'text'}"
            <c:if test="${not empty style}">
                style="${style}"
            </c:if> />
</div>

<script>
$(document).ready(function () {
    laydate.render({
        elem: '#${id}Start'
    });
    laydate.render({
        elem: '#${id}End'
    });
});
</script>