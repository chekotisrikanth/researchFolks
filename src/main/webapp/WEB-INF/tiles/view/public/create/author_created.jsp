<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<body>
<h1><spring:message code="user.list"/></h1>
<ul>
    <%--@elvariable id="users" type="java.util.List"--%>
    <c:forEach items="${authorUsers}" var="author">
        <li>
            <c:out value="${author}"/>
        </li>
    </c:forEach>
</ul>

<a href="<spring:url value="/public/author_create.html" />"><spring:message code="author.create"/></a>
</body>
</html>