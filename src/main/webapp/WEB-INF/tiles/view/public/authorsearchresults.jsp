<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<article id="body" class="col-md-9 noPaddRL">
Authors
 <c:forEach items="${authors}" var="analyst">
     <div><a target="_blank" href='/secure/customer/authorbio?authorId=${analyst.id}'> ${analyst.firstName} ${analyst.lastName}</a></div>
  </c:forEach>
</article>
