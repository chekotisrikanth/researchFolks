<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
 admin header
<div id="content">
    <c:if test="${user != null}">
      from  admin header name <c:out value="${user.firstName}"/>
    </c:if>
</div>