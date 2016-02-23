<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
        <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    </head>
    <script>
        
        $(document).ready(
        function() {

            $('#country').change(
            function() {
                
                $.getJSON('loadStates.json', {
                    countryId : $(this).val(),
                    ajax : 'true'
                }, function(data) {
                    
                    var html = '<option value="">----Select State----</option>';
                    var len = data.length;
      
                    for ( var i = 0; i < len; i++) {
                        html += '<option value="' + data[i].stateId + '">' + data[i].stateName + '</option>';
                    }
                    html += '</option>';
   
                    $('#state').html(html);
                });
            });
            
        });
        
    </script>
<body>
<h1><spring:message code="customer.create"/></h1>
<form:form method="POST" action="/public/customer_create.html" commandName="form" modelAttribute="form">
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
        <form:label path="password"><spring:message code="user.password"/></form:label>
        <form:input path="password"/>
        <form:errors path="password"/>
    </div>
    <div>
        
       
        <form:label path="country"><spring:message code="user.country"/></form:label>
         <select id="country" name="country">
                        <option value="">Select Country</option> 
                        <c:forEach items="${countryList}" var="country">
                            <option   value="${country.countryId}"  >${country.countryName}</option>
                        </c:forEach>
                    </select>
             <form:errors path="country"/>        
    </div>
    <div>
        <form:label path="state"><spring:message code="user.state"/></form:label>
         <select  id="state" name="state">
                        <option value="">Select State</option> 
                    </select>
        <form:errors path="state"/>
    </div>
    <div>
        <form:label path="occupation"><spring:message code="customer.occupation"/></form:label>
        <form:input path="occupation"/>
        <form:errors path="occupation"/>
    </div>
    <div>
        <form:label path="isAgreedTC"><spring:message code="customer.isAgreedTC"/></form:label>
        <form:checkbox path="isAgreedTC" />
        <form:errors path="isAgreedTC"/>
    </div>
    
    <div>
        <input type="submit" name="Create Account"/>
    </div>
</form:form>
</body>
</html>
