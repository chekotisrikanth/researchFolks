<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
 publisher header
<div id="content">
    <c:if test="${user != null}">
       publisher skills 
        <c:forEach items="${user.keyskills}" var="skill">
                            ${skill.skill}
                        </c:forEach>
    </c:if>
</div>