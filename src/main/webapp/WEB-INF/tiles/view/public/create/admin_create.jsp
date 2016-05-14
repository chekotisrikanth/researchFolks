<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div>
<h1><spring:message code="admin.create"/></h1>
<form:form method="POST" action="/public/admin_create.html" commandName="form" modelAttribute="form">
    <form:errors path="" element="div"/>
    <div>
        <form:label path="title"><spring:message code="user.title"/></form:label>
       <form:select path="title">
					  <form:option value="" label="--- Select ---" />
					  <form:options items="${titles}" />
		</form:select>
        <form:errors path="title"/>
    </div>
    <div>
        <form:label path="password"><spring:message code="user.password"/></form:label>
        <form:input path="password"/>
        <form:errors path="password"/>
    </div>
    <div>
        <form:label path="firstName"><spring:message code="user.firstName"/></form:label>
        <form:input path="firstName"/>
        <form:errors path="firstName"/>
    </div>
    <div>
        <form:label path="lastName"><spring:message code="user.lastName"/></form:label>
        <form:input path="lastName"/>
        <form:errors path="lastName"/>
    </div>
    <div>
        <form:label path="mobileNo"><spring:message code="user.mobileNo"/></form:label>
        <form:input path="mobileNo"/>
        <form:errors path="mobileNo"/>
    </div>
    <div>
        <form:label path="emailId"><spring:message code="user.emailId"/></form:label>
        <form:input path="emailId"/>
        <form:errors path="emailId"/>
    </div>
    <div>
        <form:label path="designation"><spring:message code="admin.designation"/></form:label>
        <form:input path="designation"/>
        <form:errors path="designation"/>
    </div>
    <div>
        <form:label path="accountType"><spring:message code="admin.accountType"/></form:label>
         <form:select path="accountType">
					  <form:option value="" label="--- Select ---" />
					  <form:options items="${accountTypes}" />
		</form:select>
        <form:errors path="accountType"/>
    </div>
    <div>
        <input type="submit"/>
    </div>
</form:form>
</div>