<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1><spring:message code="user.list"/></h1>
<ul>
    <%--@elvariable id="users" type="java.util.List"--%>
    <c:forEach items="${customerUsers}" var="customer">
        <li>
            <c:out value="${customer}"/>
        </li>
    </c:forEach>
</ul>

<a href="<spring:url value="/public/customer_create.html" />"><spring:message code="customer.create"/></a>
