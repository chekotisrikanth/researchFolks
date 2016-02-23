<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
 
 header
<div id="content">
    <c:if test="${message != null}">
        <c:out value="${message}"/>
    </c:if>
</div>
<sec:authorize access="isAnonymous()">
   <%--  <form method="POST" action="<c:url value='j_spring_security_check'/>">
        Username: <input name="j_username" type="text" value="${SPRING_SECURITY_LAST_USERNAME}" /> 
        Password: <input name="j_password" type="password" /> 
        <input type="submit" value="Sign in" />
    </form> --%>
    <a href="/public/login.html?referrer=loginlink">Login</a>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
    <a href="<c:url value="/public/logout.html" />">Logout</a>
</sec:authorize>
<a href="/">Home</a>