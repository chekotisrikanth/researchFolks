<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<form:form method="POST" class="form-horizontal alignHCenter " action="/public/author_create.html" commandName="form" modelAttribute="form">
			<div class="form-group">
					<div class="col-md-12"  >
						<span> Author Login Form</span>
					</div>                
			</div>
        	<div class="form-group">
        		<div class="col-md-1 col-sm-1 col-xs-6">
					<!--<spring:message code="user.title" var="title"/> -->
			       <form:select path="title" class = "form-control" >
					  <!--<form:option value="" label="${title}" /> -->
					  <form:options items="${titles}" />
					</form:select>
			        <form:errors path="title"/>	
				</div>
            	<div class="col-md-3">
                	<spring:message code="user.firstName" var="firstNameLbl"/> 
					<form:input path="firstName" class = "form-control" placeholder="${firstNameLbl}" required="required" />
					<form:errors path="firstName"/> 
                </div>
                <div class="col-md-2">
                	<spring:message code="user.lastName" var="lastNameLbl"/>
					<form:input path="lastName" class = "form-control" placeholder="${lastNameLbl}" required="required" />
					<form:errors path="lastName"/></div>
            </div> 
            <div class="form-group">
            	<div class="col-md-6">
                	<spring:message code="userName" var="userNameLbl"/>					
					<form:input path="userName" class = "form-control" placeholder="${userNameLbl}" required="required" />
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
					<form:password path="password" class ="form-control" placeholder="${passwordLal}" required="required" />
					<form:errors path="password"/>                	
                </div>
                <div class="col-md-3">
                	<span class="errorCls"></span>
					<spring:message code="user.reTypePwd" var="reTypePwdLal" />
					<form:password path="reTypePwd" class ="form-control" placeholder="${reTypePwdLal}" required="required" />
					<form:errors path="reTypePwd"/> 
                </div>
            </div> 
            <div class="form-group">
        		<div class="col-md-6">
			       <form:select path="experience" class ="form-control" required="required" >
			           <form:option value="" label="select experience" /> 
			         <c:forEach var="i" begin="5" end="25">
			            <form:option value="${i}" label="${i}" />
			         </c:forEach>
					</form:select>
			        <form:errors path="experience"/>	
				</div>
			</div>	
                  <%@ include file=".././countrystate.jsp" %>
                <div class="form-group">
            	<div class="col-md-6">
            	<span class="errorCls"></span>
                	<spring:message code="user.mobileNo" var="mobileNoLbl"/>					
					<form:input path="mobileNo" class = "form-control" placeholder="${mobileNoLbl}" required="required" />
					<form:errors path="mobileNo"/>
                </div>
              </div>
			  <div class="form-group">
            	<div class="col-md-2">
            		<spring:message code="author.keyskills" var="skillLbl"/>
            		<select   class = "form-control allSkills" multiple >	
					  <option disabled> ${skillLbl} </option>
						<c:forEach items="${keyskills}" var="skill">
							<option   value="${skill.id}"  >${skill.skill}</option>
						</c:forEach>
					</select>
			        <!-- <form:select multiple="true" path="keyskills" class ="form-control allSkills">
								  <form:option value="" label="${skillLbl}" />
								  <form:options items="${keyskills}" itemValue="id" itemLabel="skill" required="required" />
					</form:select> -->
                </div>
                 <div class="col-md-1">
                 	<div class="row">
                		<button class="btn btn-primary form-control   addSkill " type="button">Add</button>
                	</div>
                	
                	<div class="row top-space">
                		<button class="btn btn-primary form-control   addSkill " type="button">Remove</button>
                	</div>
                	
                </div>
				<div class="col-md-2">
                	<select   class = "form-control selSkills" name="keyskills" required multiple>	
					 
					</select>
                </div>
              </div>
			  <div class="form-group">
            	<div class="col-md-6">
					<spring:message code="bio" var="bioLbl"/>					
					<form:textarea path="bio" class = "form-control" placeholder="${bioLbl}" required="required" />
					<form:errors path="bio"/>                	
                </div>
               
              </div>
               <div class="form-group">
            	<div class="col-md-6">
					<div class="col-md-1 noPaddL">
						<input type="checkbox"  value="true" class ="form-control pull-left" name="agreedTc" required/>
					</div>
					<div class="col-md-5 noPaddL">
						Agree terms & conditions
					</div>
                </div>                
              </div>
			<div class="form-group">
				<div class="col-md-4">
				 </div>
				<div class="col-md-4">
					<button class="btn btn-primary btn-lg sncButton  pull-center " type="submit" onclick="validateFields();">Create Account</button>
				</div>
            </div>
            <div class="col-md-4">
             </div>
		</form:form>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		 <script src = "${pageContext.request.contextPath}/js/JqueryBase.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
       <script>
        $(document).ready(function() {
            //$(".open, .impatient").pageslide();
            $(document).on('click', '.addSkill', function(){
				//alert('k');
				//add skil
				var sourceList = "allSkills";
				var destList = "selSkills";
				if($(this).text() === "Remove") {
					console.log("remove");
					sourceList = "selSkills";
					destList = "allSkills";					
				} 				
				$("."+sourceList+" > option").each(function(index,object) {
					console.log($(object).prop('selected'));
					if($(object).prop('selected')) {						
						$("."+destList).append(object);
						//$(object).remove();
					}
				});
				
				
				
				
			});
        });
        
        function validateFields()
        {
        	$(".errorCls").html("");
        	var flag = false;
        	var pwd = $("#password").val();
        	var reTypePwd = $("#reTypePwd").val();
        	var mobilePattern = /^\d{10}$/;
            var mobileNo = $("#mobileNo").val();
        	if (pwd != reTypePwd) { 
        		$("#reTypePwd").parent().find(".errorCls").html("Your password and Retype password do not match.");
        		flag =true;
        		
        		}
        	else if(!mobilePattern.test(mobileNo)) {
		        $("#mobileNo").parent().find(".errorCls").html("Mobile number must be 10 digits");
		        flag =true;
		        	
		        }
        	if(flag == true)
        	 return false; 
        }
    </script>
    