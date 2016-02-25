<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang = "en">
   
   <head>
      <meta charset = "utf-8">
      <meta http-equiv = "X-UA-Compatible" content = "IE = edge">
      <meta name = "viewport" content = "width = device-width, initial-scale = 1">
      
      <title>Research Floks</title>
      
      <!-- Bootstrap -->
       <!-- Bootstrap -->
       <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-theme.css">
       <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css">
       <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
       <link rel="stylesheet" href="${pageContext.request.contextPath}/css/customStyles.css">
       <link rel="stylesheet" href="${pageContext.request.contextPath}/css/datepicker.min.css">
      
      <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
      <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
      
      <!--[if lt IE 9]>
      <script src = "https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src = "https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
      <![endif]-->
      
      <script type="text/javascript">
            jQuery.noConflict();
        </script>
      
   </head>
   
   <body>
   <div class="container-fluid">
   <header class="clearfix paddT20">
     <div class="logo col-md-8 col-sm-12">
     <a href="#"><img src="${pageContext.request.contextPath}/images/logo.png" alt="Research Floks"/></a>
     </div>
     <div class="customerInfo col-md-4 col-sm-12 paddT20">
     	<div class="col-md-8 col-sm-12">
        	<div class="col-md-4">
            	<a href="#"><img src="${pageContext.request.contextPath}/images/icon-user.png" alt="Customer Img"/></a>
            </div>
            <div class="col-md-8 noPaddRL paddT15">
            <div class="customerName col-md-12 col-sm-12 noPaddRL">Customer Name</div>
            <div class="fontSmall  col-md-12 col-sm-12">Customer Skill</div>
            </div>
        </div>
        <div class="col-md-4 col-sm-12 noPaddRL paddT15 ">
	        <div class="col-md-12 fontSmall marginB5">
            	<span class="iconL"><img src="${pageContext.request.contextPath}/images/icon-alert.png" alt="alerts"/></span> <a href="#">Alerts</a>
            </div>
            <div class="col-md-12 fontSmall">
            	<span class="iconL"><img src="${pageContext.request.contextPath}/images/icon-mesage.png" alt="Message"/></span> <a href="#">Message</a>
            </div>
        </div>
     </div>
     </header>
    <section>
    <nav id="myNavbar" class="navbar navbar-default" role="navigation">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse noPaddRL" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li><a href="#">Home</a></li>
                    <li><a href="#">About Us</a></li>
                    <li><a href="#">Products</a></li>
                    <li><a href="#">Customer Research</a></li>
                    <li><a href="#">Blog</a></li>
                    <li><a href="#">Contact Us</a></li>
                </ul>
            </div><!-- /.navbar-collapse -->
    </nav>
      </section>
     <section>
		<article class="col-md-12 noPaddRL">
        <div class="contentWraper marginB20">
        
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
					<form:input path="firstName" class = "form-control" placeholder="firstNameLbl" required="required" />
					<form:errors path="firstName"/> 
                </div>
                <div class="col-md-2">
                	<spring:message code="user.lastName" var="lastNameLbl"/>
					<form:input path="lastName" class = "form-control" placeholder="lastNameLbl" required="required" />
					<form:errors path="lastName"/></div>
            </div> 
            <div class="form-group">
            	<div class="col-md-6">
                	<spring:message code="userName" var="userNameLbl"/>					
					<form:input path="userName" class = "form-control" placeholder="userNameLbl" required="required" />
					<form:errors path="userName"/>
                </div>                
             </div>
             <div class="form-group">            	
				<div class="col-md-6">
					<spring:message code="user.emailId" var="emailIdLbl"/>					
					<form:input path="emailId" class = "form-control" placeholder="emailIdLbl" required="required" />
					<form:errors path="emailId"/>
				</div>
              </div>
			<div class="form-group">				
				<div class="col-md-3">
					<spring:message code="user.password" var="passwordLal"/>
					<form:password path="password" class ="form-control" placeholder="passwordLal" required="required" />
					<form:errors path="password"/>                	
                </div>
                <div class="col-md-3">
					<spring:message code="user.reTypePwd" var="reTypePwdLal"/>
					<form:password path="reTypePwd" class ="form-control" placeholder="reTypePwdLal" required="required" />
					<form:errors path="reTypePwd"/> 
                </div>
            </div> 
             <div class="form-group">
            	<div class="col-md-6">
            	<spring:message code="user.country" var="countryLbl"/>
                	<select id="country" name="country" class = "form-control" required>	
					  <option value=""> ${countryLbl} </option>
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
					<form:input path="city" class = "form-control" placeholder="cityLbl" required="required" />
					<form:errors path="city"/>
                </div>
              </div>
			   <div class="form-group">
            	<div class="col-md-6">
                	<spring:message code="user.mobileNo" var="mobileNoLbl"/>					
					<form:input path="mobileNo" class = "form-control" placeholder="mobileNoLbl" required="required" />
					<form:errors path="mobileNo"/>
                </div>
              </div>
			  <div class="form-group">
            	<div class="col-md-6">
            		<spring:message code="author.keyskills" var="skillLbl"/>
			         <form:select multiple="true" path="keyskills">
								  <form:option value="" label="${skillLbl}" />
								  <form:options items="${keyskills}" itemValue="id" itemLabel="skill" required="required" />
					</form:select>
			        <form:errors path="keyskills"/>
                </div>
              </div>
			  <div class="form-group">
            	<div class="col-md-6">
					<spring:message code="bio" var="bioLbl"/>					
					<form:textarea path="bio" class = "form-control" placeholder="bioLbl" required="required" />
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
					<button class="btn btn-primary btn-lg sncButton  pull-center" type="submit">Create Account</button>
				</div>
            </div>
            <div class="col-md-4">
             </div>
		</form:form>
	</div>
        </article>
        
      </section>
    </div>  
      <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		 <script src = "${pageContext.request.contextPath}/js/JqueryBase.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
       <script>
        $(document).ready(function() {
            $(".open, .impatient").pageslide();
        });
    </script>
     </div> 
   </body>
</html>