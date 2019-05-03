<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag pageEncoding="UTF-8" %>
<%@ attribute name="id"  rtexprvalue="true" %>
<%@ attribute name="btnCss"  rtexprvalue="true" %>
<%@ attribute name="spaceCss"  rtexprvalue="true" %>
<%@ attribute name="onclick" rtexprvalue="true" %>
<%@ attribute name="icon" rtexprvalue="true" %>
<%@ attribute name="name" rtexprvalue="true" %>
<button type="button" class="btn btn-${btnCss} ${spaceCss}" onclick="${onclick}" id="${id}">
    <i class="fa ${icon}"></i>&nbsp;${name}
</button>