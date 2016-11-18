<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   
        <form:form method="POST" class="form-horizontal alignHCenter " action="${pageContext.request.contextPath}/public/customer_create.html" commandName="form" modelAttribute="form">
	       <form:errors />
        
			<div class="form-group">
            	<div class="col-md-12 col-centered" >
                	<span> <spring:message code="customer.create"/> </span>
                </div>                
            </div>
        	<div class="form-group">
				<div class="col-md-1 col-sm-1 col-xs-6">
					<!--<spring:message code="user.title" var="title"/> -->
			       <form:select path="title" class ="form-control">
					  <!--<form:option value="" label="${title}" /> -->
					  <form:options items="${titles}" />
					</form:select>
			        <form:errors path="title"/>	
				</div>
            	<div class="col-md-3">				
					<spring:message code="user.firstName" var="firstNameLbl"/> 
					<form:input path="firstName" class = "form-control" placeholder="${firstNameLbl}" required="required"/>
					<form:errors path="firstName"/>                	
                </div>
                <div class="col-md-2">
					<spring:message code="user.lastName" var="lastNameLbl"/>
					<form:input path="lastName" class = "form-control" placeholder="${lastNameLbl}" required="required"/>
					<form:errors path="lastName"/></div>
            </div>            
			<div class="form-group">
				<div class="col-md-6">
					<spring:message code="userName" var="userNameLbl"/>					
					<form:input path="userName" class = "form-control" placeholder="${userNameLbl}" required="required"/>
					<form:errors path="userName"/>
				</div>                
			</div>
			<div class="form-group">            	
				 <div class="col-md-6">
					<spring:message code="user.emailId" var="emailIdLbl"/>					
					<form:input path="emailId" class = "form-control" placeholder="${emailIdLbl}" required="required" />
					<form:errors path="emailId"/>
				 </div>
			</div>
			<div class="form-group">				
            	<div class="col-md-3">
					<spring:message code="user.password" var="passwordLal"/>
					<form:password path="password" class ="form-control" placeholder="${passwordLal}" required="required"/>
					<form:errors path="password"/>                	
                </div>
                <div class="col-md-3">
                <span class="errorCls"></span>
					<spring:message code="user.reTypePwd" var="reTypePwdLal"/>
					<form:password path="reTypePwd" class ="form-control" placeholder="${reTypePwdLal}" required="required" />
					<form:errors path="reTypePwd"/> 
                </div>
            </div>             
            <div class="form-group">
            	<div class="col-md-6">
            		<spring:message code="user.country" var="countryLbl"/>	
					<select id="country" name="country" class = "form-control" required="required">					
								      
					  <option value="">${countryLbl}</option>
						<c:forEach items="${countryList}" var="country">
							<option   value="${country.countryId}"  >${country.countryName}</option>
						</c:forEach>
					</select>
					<form:errors path="country"/>
                	
                </div>
            </div>
			<div class="form-group">
				<div class="col-md-6">
					<spring:message code="user.city" var="cityLbl"/>					
					<form:input path="city" class = "form-control" placeholder="${cityLbl}" required="required"/>
					<form:errors path="city"/>                	
				</div>
			</div>
			<div class="form-group">            	
                <div class="col-md-6">				
					<spring:message code="customer.occupation" var="occupationLbl" />
					<select id="occupation" name="occupation" class = "form-control" required>																      
						  <option value="">${occupationLbl}</option>
							<c:forEach items="${occupationList}" var="occupation" varStatus="loop">
								<option value="${loop.index}">${occupation}</option>
							</c:forEach>
					</select>
					<form:errors path="occupation"/>                	
				</div>			  
            </div>
			  
              <div class="form-group">
            	<div class="col-md-3">
            	<div class="col-md-1 noPaddL">
                	<input type="checkbox"  value="true" class =" pull-left" name="isAgreedTc" required/>
                </div>
                	<div class="col-md-11 noPaddL">
                	Agree terms & conditions
                </div>
                </div>
                
              </div>
           
            
            <div class="form-group">
            <div class="col-md-4">
              </div>
            <div class="col-md-4">
                <button class="btn btn-primary btn-lg sncButton  pull-center" type="submit" onclick="validateFields();">Create Account</button>
              </div>
            </div>
   </form:form>   
      <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
     <!-- <script src = "https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script> -->
      
      <!-- Include all compiled plugins (below), or include individual files as needed -->
     
      <script src = "${pageContext.request.contextPath}/js/JqueryBase.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
       

       <script>
      
        $(document).ready(function() {
            $(".open, .impatient").pageslide();
        });
        
        function validateFields()
        {
        	$(".errorCls").html("");
        	var flag = false;
        	var pwd = $("#password").val();
        	var reTypePwd = $("#reTypePwd").val();
        	if (pwd != reTypePwd) { 
        		$("#reTypePwd").parent().find(".errorCls").html("Your password and Retype password do not match.");
        		flag =true;
        		return false;
        }
        }
    </script>
