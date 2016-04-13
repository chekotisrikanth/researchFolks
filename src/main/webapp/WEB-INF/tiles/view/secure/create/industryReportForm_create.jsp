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
       <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-theme.css">
       <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css">
       <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
       <link rel="stylesheet" href="${pageContext.request.contextPath}/css/customStyles.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Calendar.css">
      <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
      <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
     
      <!--[if lt IE 9]>
      <script src = "https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src = "https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
      <![endif]-->
     
    
     
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
    
                <aside class="col-md-3 col-sm-12 noPaddL" id="content">
        <h1><a class="open" href="#nav">Menu</a>PageSlide Responsive Demo</h1>
                <div class="col-md-12 noPaddRL">
            
            <ul class="nav nav-list leftNav" id="nav">
                <li><a href="#" class="leftNavHeader">Reports <span class="iconL"><img src="${pageContext.request.contextPath}/images/icon-chart.png" alt="chart"/></span></a></li>
                <li><a href="#">Stake</a></li>
                <li><a href="#">Sales</a></li>
                <li class="marginB20"><a href="#">Uploads</a></li>
           
                <li><a href="#" class="leftNavHeader">Profile <span><img src="${pageContext.request.contextPath}/images/icon-profie.png" alt="profile"/></span></a></li>
                <li><a href="#">Edit profile</a></li>
                <li class="marginB20"><a href="#">Change Password</a></li>
               
                <li><a href="#" class="leftNavHeader">On Demond Jobs <span>icon</span></a></li>
                <li><a href="#">Find Work</a></li>
                <li><a href="#">Saved Jobs</a></li>
                <li><a href="#">Invitation</a></li>
            </ul>
            </div>
        </aside>
        <article class="col-md-9 noPaddRL">
        <div class="contentWraper">
		<form:form method="POST"  class="form-horizontal alignHCenter" action="/publish/industryReportForm_create.html" commandName="form" modelAttribute="form" enctype="multipart/form-data">
			<form:errors path="" element="div"/>
			<%-- <div class="form-group">
			<form:label class="col-md-3 control-label text-right" path="reportTitle"><spring:message code="indReportForm.reportTitle"/></form:label>	
                <div class="col-md-9">
                	<form:input path="reportTitle" class="form-control"/>
					<form:errors path="reportTitle"/>
                </div>
            </div> --%>
            <spring:bind path="reportTitle">
            <div class="form-group ${status.error ?'has-error':''} ">        	
			<form:label class="col-md-3 control-label text-right" path="reportTitle"><spring:message code="indReportForm.reportTitle"/></form:label>	
                <div class="col-md-9">
                	<form:input path="reportTitle" class="form-control" required="required"/>
					<!--<form:errors path="reportTitle"/>-->
                </div>
            </div>
            </spring:bind>
			<spring:bind path="industry">
	            <div class="form-group ${status.error ?'has-error':''} ">
					<form:label path="industry" class="col-md-3 control-label text-right"><spring:message code="reportForm.industry"/></form:label>                    
					<div class="col-md-9">
						<form:textarea class="form-control" path="industry" rows="5" cols="30" required="required"/>
						<!--<form:errors path="industry"/>-->
					</div>
				</div>
		    </spring:bind>
			<spring:bind path="country">
	            <div class="form-group ${status.error ?'has-error':''} ">
				<form:label class="col-md-3 control-label text-right" path="country"><spring:message code="reportForm.country"/></form:label>               
				<div class="col-md-9">
					<select id="country" name="country" class = "form-control form-temp" form-temp="${form.country}" required="required">
						<option value="">Select Country</option>
						<c:forEach items="${countryList}" var="country">
							<option   value="${country.countryId}"  >${country.countryName}</option>
						</c:forEach>
					</select>
				<!--<form:errors path="country"/>-->                                                               
				</div>
			</div>
		</spring:bind>												   
		<div class="form-group">
			 <spring:bind path="publishingDate">
			             <div class="${status.error ?'has-error':''}">
				<form:label class="col-md-3 control-label text-right" path="publishingDate"><spring:message code="reportForm.publishingDate"/></form:label>
				<div class="input-append date col-md-3">
					<div class="input-group date date-input" id='startDate' >
						<form:input class="form-control" path="publishingDate" id="publishingDate" required="required"/>                                                                                       
						<span class="input-group-addon">
							 <span class="glyphicon glyphicon-calendar"></span>
						</span>					
					</div>
					<!--<form:errors path="publishingDate"/>-->
				</div>  
				</div>
		     </spring:bind>	
		     <spring:bind path="price">
			  <div class="${status.error ?'has-error':''}">									   
				<form:label path="price" class="col-md-2 control-label text-right"><spring:message code="reportForm.price"/></form:label>          
				<div class="col-md-4">
					<form:input class="form-control" path="price" required="required"/>
					<!--<form:errors path="price"/>-->                     
				</div>
				 </div>
		    </spring:bind>
		</div>
		<div class="form-group">
			<spring:bind path="comIntl">
			   <div class="${status.error ?'has-error':''}">
				<form:label class="col-md-3 control-label text-right" path="comIntl"><spring:message code="indReportForm.comIntl"/></form:label>                                                                
				<div class="col-md-4">
					<select class = "form-control cit" name=comIntl required="required">
					<option value="">Select Intelligence</option>
						<option value="3" ${form.comIntl eq 3 ?'selected':''}>Industry Report</option> 
						<option value="4" ${form.comIntl eq 4 ?'selected':''}>Industry Database</option>                                                                               
					  </select>      
					                                                                        
				</div>
			  </div>
			</spring:bind>
			 <spring:bind path="updateCycle">
			  <div class="${status.error ?'has-error':''}">	
				<form:label class="col-md-2 control-label text-right" path="updateCycle"><spring:message code="reportForm.updateCycle"/></form:label>     
					<div class="col-md-3">
					 <select class = "form-control form-temp" name="updateCycle" form-temp="${form.updateCycle}" required="required">
					 <option value="">Select Cycle</option>
	                    <option value="Annually">Annually </option>
						<option value="Half-Yearly">Half-Yearly</option>
						<option value="Quarterly">Quarterly</option>
						<option value="Monthly">Monthly</option>					
						</select>
	                </div>
					<!--<form:errors path="updateCycle"/>-->
				 </div>
			</spring:bind>
	   </div>
		<spring:bind path="overview">
	       <div class="form-group ${status.error ?'has-error':''} ">
			<form:label path="overview" class="col-md-3 control-label text-right"><spring:message code="reportForm.overview"/></form:label> 
			<div class="col-md-9">
				<form:textarea class="form-control" path="overview" rows="3" cols="30" required="required"/>
				<!--<form:errors path="overview"/>-->
			</div>
		</div>
	  </spring:bind>
		 <spring:bind path="tableOfContents">
	       <div class="form-group ${status.error ?'has-error':''} ">
			<form:label class="col-md-3 control-label text-right" path="tableOfContents"><spring:message code="reportForm.tableOfContents"/></form:label>                          
			<div class="col-md-9">
				<form:textarea class="form-control" path="tableOfContents" rows="3" cols="30" required="required"/>
				<!--<form:errors path="tableOfContents"/>-->
			</div>
		</div>
		</spring:bind>										   
		 <div class="form-group">
	          <spring:bind path="reportImg">
	            <div class="${status.error ?'has-error':''}">
			<form:label class="col-md-3 control-label text-right" path="reportImg"><spring:message code="reportForm.report"/></form:label>
			<div class="col-md-4">
				<input type="file" name="reportImg" required="required" />
               <div class="bg-danger"><form:errors path="reportImg" /> </div>
			</div>
			</div>	
			</spring:bind>
			<div class="col-md-5 note bg-info">Note: Supported Formats are MS WORD,PPT and EXCEL</div>
			
			</div>								   
		<div class="form-group">
		<label class="col-md-3 control-label text-right">&nbsp;</label>
			<div class="col-md-9">					
					<button class="btn btn-primary btn-lg sncButton pull-right" type="submit">Save & Submit</button>
				</div>
		</div>
		<input type="hidden" name="repTypeId" value="2">
     </form:form>
            </div>
        </article>
       
      </section>
     
      <!-- jQuery (necessary for Bootstrap's JavaScript plugins) --> 
      <script src = "${pageContext.request.contextPath}/js/JqueryBase.min.js"></script>
       <script src = "${pageContext.request.contextPath}/js/CalendarBase.min.js"></script>       
       <script src = "${pageContext.request.contextPath}/js/Calendar.js"></script>
     
     <!--   <script src = "https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>-->
      <!-- Include all compiled plugins (below), or include individual files as needed -->
      <script src="${pageContext.request.contextPath}/js/bootstrap-datepicker.js"></script>
      <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
      <script src="${pageContext.request.contextPath}/js/jquery.pageslide.min.js"></script>
	  
	  
     
    
       <script>
       
       function appenduploadText (num) {
    	   if($(num).val()==1) {
				//alert('1');
				$('.note').html("Note: Allowed Upload Types Are Either MS Word or PPT");
			} else if($(num).val()==2) {
				$('.note').html("Note: Allowed Upload Types Are MS Excel Only");
			}
   		}
        $(document).ready(function() {
        	$(".form-temp").each(function(index,object) {
        		//console.log($(this).attr('form-temp'));
        		$(this).val($(this).attr('form-temp'));
        	}); 
        	  //jQuery.noConflict();
            $(".open, .impatient").pageslide();
            appenduploadText($(".cit"));
            $(document).on('change', '.cit', function(){
				appenduploadText(this);
 				//$('#all_locations').append('<select name="loc_in_england" id="loc_in_england" class="location" ><option value="blank">Select</option><option value="london">London</option>');    
			});
			$('#publishingDate').daterangepicker(
				    { 
				    	singleDatePicker: true				 
					//format: 'DD-MM-YYYY'
					 
					}, function(start, end, label) {
						console.log(start.toISOString(), end.toISOString(), label);
					  });
        });
    </script>
     </div>
   </body>
</html>

 