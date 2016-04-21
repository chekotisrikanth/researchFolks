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
     <%--   <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css"> --%>
       <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
       <link rel="stylesheet" href="${pageContext.request.contextPath}/css/customStyles.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Calendar.css">
       
      <!-- <link rel="stylesheet" href="${pageContext.request.contextPath}/css/datepicker.min.css"> -->
      
      <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
      <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
      
      <!--[if lt IE 9]>
      <script src = "https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src = "https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
      <![endif]-->
      <style type="text/css">
      	.dis-able 			{
			    background-color: #DDD;
			    color: #999;
			}
      </style>
    
      
   </head>
   
   <body>
   <div class="container-fluid">
   <header class="clearfix paddT20">
     <div class="logo col-md-8 col-sm-12">
     <a href="/"><img src="${pageContext.request.contextPath}/images/logo.png" alt="Research Floks"/></a>
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
                    <li><a href="/">Home</a></li>
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
        <!--onsubmit="return validateForm(event)" -->
        <form:form class="form-horizontal alignHCenter" onsubmit="return validateForm(event)" method="POST" action="/publish/cpdpReportForm_create.html" commandName="form" modelAttribute="form"
         enctype="multipart/form-data">
        
       		<spring:bind path="reportTitle">
            <div class="form-group ${status.error ?'has-error':''} ">        	
			<form:label class="col-md-2 control-label text-right" path="reportTitle"><spring:message code="reportForm.reportTitle"/></form:label>	
                <div class="col-md-10">
                	<form:input path="reportTitle" class="form-control" required="required"/>
					<!--<form:errors path="reportTitle"/>-->
                </div>
            </div>
            </spring:bind>
            <spring:bind path="reportType">
            <div class="form-group ${status.error ?'has-error':''} ">
				<form:label class="col-md-2 control-label text-right" path="reportType"><spring:message code="reportForm.reportType"/></form:label>	
	                <div class="col-md-10">
	                	<select class = "form-control form-temp reportType" name="reportType" form-temp="${form.reportType}" required="required">
	                	 <option value="">Select CompanyType</option>  
						 <option value="1">Public</option>
						 <option value="2">Private</option>
						 <option value="3">Non-Profit</option>
						 <option value="4">Government</option>					 
					  </select>
					<!--<form:errors  class="text-warning" path="reportType"/>--> 
	                </div>              
            </div>
			</spring:bind>
            <%-- <div class="form-group ${status.error ?'has-error':''} ">
			 <form:label path="industry" class="col-md-2 control-label text-right"><spring:message code="reportForm.industry"/></form:label>               	
                <div class="col-md-10">
                	<form:textarea class="form-control" path="industry" max-char="1000" rows="5" cols="30" required="required"/>
                	<jsp:include page="../../../../tree/tree.jsp"></jsp:include>
                	<span class="text-info"></span>
					<!--<form:errors path="industry"/>-->
                </div>
             </div>	 --%>	
             <div class="form-group ${status.error ?'has-error':''} ">
              <form:label path="" class="col-md-2 control-label text-right">Taxonomy / Industries Tree</form:label>
                                        <div class="col-md-10">
                							<div style='cursor: pointer; cursor: hand; display: inline-block;' onclick="popupTree();" id="overlayContainer">
                                    			<img class="img-responsive" id="main_image" src="/tree/assets/images/tree.png"></img>
                                    			<img class="img-responsive" id="overlay_image" src="/tree/assets/images/hand.png"></img>
                                			</div> 
                						</div>   
              </div>	
			
			<spring:bind path="industry">
			<div style="display:none" id="selectedIndustires" class="form-group ${status.error ?'has-error':''} ">
				<form:label path="industry" class="col-md-2 control-label text-right"><b>Selected Industries:</b></form:label>
				<div class="col-md-10">
				<span id="echoSelection3"></span>
				<input type="hidden" name="industry" id="selectedIndus"/>
				</div>
			</div>
			</spring:bind>
			
			<div id="light" class="white_content" >
                                    <table width="100%">
                                        <tr>
                                            <td>
                                                Taxonomy / Industries Tree
                                            </td>
                                            <td width="70%" align='right'>
                                                <a href="#" id="CloseTreeButton" onclick="save();" class="myButton" style='color: white!important;'>Save</a>&nbsp;<a href="#" id="CancelTreeButton" onclick="cancelPopup();" class="myButton" style='color: white!important;'>Cancel</a>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td height='10px'></td>
                                        </tr>
                                        <tr>
                                            <td colspan="2">
                                                <%-- <jsp:include page="../../../../tree/dynatree.jsp"></jsp:include> --%>
                                            	<jsp:include page="../../../../tree/tree.jsp"></jsp:include> 
                                            </td>
                                        </tr>
                                    </table>
                                </div>
            <div id="fade" class="black_overlay follow-scroll"></div>
            
            <div class="form-group stockex" style="display:none;">
            	<spring:bind path="stockExchageId">
	             <div class="err-div ${status.error ?'has-error':''}">
					<form:label path="stockExchageId" class="col-md-2 control-label text-right"><spring:message code="reportForm.stockExchange"/></form:label>            	
	                <div class="input-append date col-md-4">
	                    <select class = "form-control form-temp" name="stockExchageId" form-temp="${form.stockExchageId}">
						 <option value="">Select Stock Exchange</option> 
						 <c:forEach var="item" items="${stocksList}">					 
						 <option   value="${item.stockExchangeId}">${item.name}</option>
						</c:forEach>
						</select>
						<!--<form:errors path="stockExchageId"/> -->
	                </div>
	              </div>
                </spring:bind>
              <spring:bind path="ticker">
	             <div class="err-div ${status.error ?'has-error':''}">
					<form:label path="ticker" class="col-md-2 control-label text-right"><spring:message code="reportForm.ticker"/></form:label>	
		                <div class="col-md-4">
							<form:input class="form-control" path="ticker"/>
							<!--<form:errors path="ticker"/>  -->              	
		                </div>
		            </div>
             </spring:bind>
            </div>
            
            <div class="form-group"> 
            <spring:bind path="headcount">
	             <div class="${status.error ?'has-error':''}">
				<form:label path="headcount" class="col-md-2 control-label text-right"><spring:message code="reportForm.headcount"/></form:label>	
                <div class="input-append date col-md-4">
					<form:input class="form-control opt-field" path="headcount" onblur="formatNumber(this)"/>
					<!--<form:errors path="headcount"/>  -->              	
                </div>
                </div>
             </spring:bind>
                <spring:bind path="country">
	             <div class="${status.error ?'has-error':''}">
				<form:label class="col-md-2 control-label text-right" path="country"><spring:message code="reportForm.country"/></form:label>	
                <div class="col-md-4">
                	<select id="country" name="country" class = "form-control form-temp" form-temp="${form.country}" required="required">
                        <option value="">Select Country</option> 
                        <c:forEach items="${countryList}" var="country">
                            <option   value="${country.countryId}"  >${country.countryName}</option>
                        </c:forEach>
                    </select>
				<!--<form:errors path="country"/> -->
                </div>
                </div>
             </spring:bind>
            </div>
            
            <div class="form-group ">
            <spring:bind path="revenue">
	             <div class="${status.error ?'has-error':''}">
				<form:label path="revenue" class="col-md-2 control-label text-right "><spring:message code="reportForm.revenue"/></form:label>	
                <div class="input-append date col-md-4" >
					<form:input class="form-control revenue opt-field" path="revenue" onblur="formatNumber(this)"/>
				<!--	<form:errors path="revenue"/> -->  
				<span class="text-info"></span>             	
                </div>
                </div>
             </spring:bind>
				<spring:bind path="units">
	             <div class="err-div ${status.error ?'has-error':''}">
				 <form:label path="units" class="col-md-2 control-label text-right"><spring:message code="reportForm.units"/></form:label>            	
                <div class="col-md-4">
                 <select class = "form-control form-temp currency dis-able dis-able-supp" name="units" form-temp="${form.units}" >
                 	<option value="">Select Units</option> 
					 <option value="1">Thousands</option>
					 <option value="2">Millions</option>
					 <option value="3">Billions</option>
					 <option value="4">Trillions</option>					 
				  </select>  
				<!--<form:errors path="units"/>-->
                </div>
                </div>
             </spring:bind>
            </div>
            
            <div class="form-group">
	            <spring:bind path="currency">
		             <div class="err-div ${status.error ?'has-error':''}">
					 	<form:label path="currency" class="col-md-2 control-label text-right"><spring:message code="indReportForm.currency"/></form:label>	            	
			                <div class="input-append date col-md-4">
			                  <select class = "form-control form-temp currency dis-able dis-able-supp" name="currency" form-temp="${form.currency}" >
			                  	<option value="">Select Currency</option> 
								 <option value="US$">US$</option>
								 <option value="GBP">GBP</option>
								 <option value="INR">INR</option>
								 <option value="CHF">CHF</option>
								 <option value="CAD">CAD</option>
								 <option value="AU$">AU$</option>
								 <option value="ZAR">ZAR</option>						 
							  </select>  
							<!--<form:errors path="currency"/>-->
			                </div>
			          </div>
	             </spring:bind>
				<spring:bind path="price">
					<div class="${status.error ?'has-error':''}">
						<form:label path="price" class="col-md-2 control-label text-right"><spring:message code="reportForm.price"/></form:label>	
						<div class="col-md-4">
							<form:input class="form-control" path="price" onblur="formatNumber(this)" required="required" />
							<!--	<form:errors path="price"/>     -->           	
						</div> 
					 </div>
				</spring:bind>
	   	    </div>			
            <div class="form-group">            
	            <spring:bind path="publishingDate">
		             <div class="${status.error ?'has-error':''}">
					<form:label class="col-md-2 control-label text-right" path="publishingDate"><spring:message code="reportForm.publishingDate"/></form:label>
					<div class="input-append date col-md-4">
						<div class="input-group date date-input" id='startDate' >
							 <form:input class="form-control form-temp" path="publishingDate" id="publishingDate" form-temp="${form.publishingDate}" required="required"/>					                     
							<span class="input-group-addon ">
								   <span class="glyphicon glyphicon-calendar"></span>
							</span>							
						 </div>
						<!--   <form:errors path="publishingDate"/>-->
					</div>	
					</div>
	             </spring:bind>
	            
				<spring:bind path="updateCycle">
		            <div class="${status.error ?'has-error':''}">
						<form:label class="col-md-2 control-label text-right" path="updateCycle"><spring:message code="reportForm.updateCycle"/></form:label>            	
	                    <div class="col-md-4">
						 <select class = "form-control form-temp" name="updateCycle" form-temp="${form.updateCycle}" required="required">
						   <option value="">Select Cycle</option> 
		                    <option value="Annually" >Annually </option>
							<option value="Half-Yearly" >Half-Yearly</option>
							<option value="Quarterly" >Quarterly</option>
							<option value="Monthly"  >Monthly</option>					
							</select>
		                  </div>
					<!--<form:errors path="updateCycle"/>-->
	           		 </div>
	            </spring:bind>
	   	    </div>
           
			<spring:bind path="comIntl">
	             <div class="form-group ${status.error ?'has-error':''} ">    			
					<form:label class="col-md-2 control-label text-right" path="comIntl"><spring:message code="reportForm.comIntl"/></form:label> 				
					<div class="col-md-4">
					 <select class = "form-control cit" name="comIntl" required="required">
					  <option value="">Select Intelligence</option>
						 <option value="1" ${form.comIntl eq 1 ?'selected':''}>Company Report</option> 
						 <option value="2" ${form.comIntl eq 2 ?'selected':''}>Company Database</option> 				
					  </select>						
					</div>
					<!--<form:errors path="comIntl"/> -->
				</div>
			</spring:bind>	
            <spring:bind path="overview">
	            <div class="form-group ${status.error ?'has-error':''} ">    
					<form:label path="overview" class="col-md-2 control-label text-right"><spring:message code="reportForm.overview"/></form:label>  <div class="col-md-10">
	                	<form:textarea class="form-control" max-char="1500" path="overview" rows="3" cols="30" required="required"/>
	                	<span class="text-info"></span>
						<!--<form:errors path="overview"/> -->
	                </div>
	            </div>
            </spring:bind>
            <spring:bind path="tableOfContents">
	            <div class="form-group ${status.error ?'has-error':''} ">    
					<form:label class="col-md-2 control-label text-right" path="tableOfContents"><spring:message code="reportForm.tableOfContents"/></form:label>            	
	                <div class="col-md-10">
	                	<form:textarea class="form-control" max-char="1500" path="tableOfContents" rows="3" cols="30" required="required"/>
						<!--<form:errors path="tableOfContents"/> -->
						<span class="text-info"></span>
	                </div>
	            </div>
            </spring:bind>
             <div class="form-group">
				<form:label class="col-md-2 control-label text-right" path="reportImg"><spring:message code="reportForm.report"/></form:label>
                <div class="col-md-4">
                	<input type="file" name="reportImg"  required="required"/>
                	
                	 <div class="bg-danger"><form:errors path="reportImg" /> </div>
               </div>
                <div class="col-md-5 note bg-info">Note: Supported Formats are MS WORD,PPT and EXCEL</div>
           
            </div>
            <div class="form-group">
            <label class="col-md-7 control-label text-right">&nbsp;</label>
            	<div class="col-md-5">
                        <button class="btn btn-primary btn-lg sncButton pull-right marginL10" type="submit">Save & Submitt</button> 
                        <!-- <button class="btn btn-primary btn-lg pull-right" type="submit">Save</button> -->
                    </div>
            </div>
            <input type="hidden" name="repTypeId" value="1">
</form:form>
            </div>
        </article>
         <div id="displayAlertMsg"></div>
      </section>
      
      
      
      <!-- jQuery (necessary for Bootstrap's JavaScript plugins) --> 
       <script src = "${pageContext.request.contextPath}/js/CalendarBase.min.js"></script>
       <script src = "${pageContext.request.contextPath}/js/JqueryBase.min.js"></script>
       <script src = "${pageContext.request.contextPath}/js/Calendar.js"></script>
     	<script src="/tree/assets/dist/jstree.min.js"></script>
     <!--   <script src = "https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>-->
      <!-- Include all compiled plugins (below), or include individual files as needed -->
      <script src="${pageContext.request.contextPath}/js/bootstrap-datepicker.js"></script>
      <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
      <script src="${pageContext.request.contextPath}/js/jquery.pageslide.min.js"></script>
      <script type="text/javascript" src="${pageContext.request.contextPath}/js/common/popuputil.js" ></script>
      
       <script>
       function formatNumber (num) {
    	   //console.log(num);
    	  var modified =  num.value.replace(/,/g,"");
    	  console.log(modified);
    	  var formatter = modified.replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1,");
   	   	  return num.value=formatter;
   		}
      
       function appenduploadText (num) {
    	   if($(num).val()==1) {
				//alert('1');
				$('.note').html("Note: Allowed Upload Types Are Either MS Word or PPT");
			} else if($(num).val()==2) {
				$('.note').html("Note: Allowed Upload Types Are MS Excel Only");
			}
   		}
       function hideStockExchange (num) {
    	   if($(num).val()==1) {
				//alert('1');
    		   $('.stockex').show();
			} else {
				$('.stockex').hide();
			}
   		}
	   var validateForm = function(event){    	 
	   	    var helper = validateFormHelper();  
	   	    if(!helper) {
	   	    	return helper;
	   	    } 
	   	  var str='';
	   	  
	   	  $(".opt-field").each(function(index,object) {
	   	
	   		  if($(this).val().length<=1) {
	   			  if(index ==0) {	  	   			
	  	   			str+='<div class="col-md-12  bg-info"><h4>Following Optional Fields Are Not Filled..Still Want to Continue....</h4></div>';	  	   			
	  	   			str+='<div class="col-md-12"/>';	  	   			
	  	   		  }
	   			  var lab = $("label[for='"+$(this).attr('name')+"']").html();	  
	   			str+='<div class="row">';
	   			str+=' <div class="col-md-6 col-md-offset-3 text-success"><h4>'+lab+'</h4></div>';
	   			str+='</div>';
	   		  }
	   		  
	   	  });
	   	  if(str.length>1) {
	   		str+='</div>';
	   		event.preventDefault();
	   		confirmationDialog(str);
	   	  }else {
	   		$("form").submit();
	   	  }  	  
	   	  
    	};
       function validateFormHelper() {
	   	var validateFlag= true;
	   	//stack exchange validation
    	var form = $("form"); 
		var repType = $("[name='reportType']", form).val();
		var stoackId = $("[name='stockExchageId']", form).val();
		var tickerValue = $("[name='ticker']", form).val();
		 
		//currency validation
	   	 if (repType === "1"  ) {
	   		if(stoackId == null || stoackId == "" ) {
	   			var stockExchange = $("[name='stockExchageId']", form);
	   			stockExchange.parentsUntil(".err-div").addClass('has-error');
	   			validateFlag = false;
	   			stockExchange.focus();
	   		} else {
	   			$("[name='stockExchageId']", form).parentsUntil(".err-div").removeClass('has-error');
	   		}
	   		if(tickerValue == null || tickerValue == "" ) {
	   			var ticker = $("[name='ticker']", form);
	   			ticker.parentsUntil(".err-div").addClass('has-error');
	   			validateFlag = false;
	   			ticker.focus();
	   		}else {
	   			$("[name='ticker']", form).parentsUntil(".err-div").removeClass('has-error');
	   		}
	   		
	   	 }
	   	 
	   	var revenue = $("[name='revenue']", form).val();
		var currency = $("[name='currency']", form).val();
		var units = $("[name='units']", form).val();
		//currency validation
    	if (revenue != "" ) {
	   		if(currency == null || currency == "" ) {	 
	   			var currencyObj = $("[name='currency']", form);
	   			currencyObj.parentsUntil(".err-div").addClass('has-error');
	   			validateFlag = false;
	   			currencyObj.focus();
	   		} else {
	   			$("[name='currency']", form).parentsUntil(".err-div").removeClass('has-error');
	   		}
	   		if(units == null || units == "" ) {
	   			var unitsObj = $("[name='units']", form);
	   			unitsObj.parentsUntil(".err-div").addClass('has-error');
	   			validateFlag = false;
	   			unitsObj.focus();
	   		}else {
	   			$("[name='units']", form).parentsUntil(".err-div").removeClass('has-error');
	   		}
	   		
	   	 }
		return validateFlag;
       }
        $(document).ready(function() {
        	$(document).on('click', '.formSubmit', function(){
        		 $("form").attr("onsubmit","");
        		 $("form").submit();
			});
        	/* $(document).on('click', '.sncButton', function(){
        		validateForm(this.event);
			}); */
        	
        	
        	//alert($.browser.mozilla);
        	$('.dis-able-supp').click(function (event) {
        		if( $(".dis-able-supp").hasClass("dis-able")) {
        			 $(".dis-able-supp").attr("disabled",true);
            		 $( ".dis-able-supp" ).removeClass( "dis-able" );
            		 $(".revenue").next().html("Enter Revenue To Choose Currency And Units");
            		 $(".revenue").focus();
        		}
        		
			});
        	//based on revinue enable the text boxes
        	$("textarea").keyup(function(){
         	   $(this).next().html("Characters left: " + ($(this).attr("max-char") - $(this).val().length));
         	 });
        	if( $('.revenue').val().length >=1) {
        		 $(".dis-able-supp").attr("disabled",false);
        		 $( ".dis-able-supp" ).removeClass( "dis-able" );
        	}
        	
        	$(".revenue").on('keyup', function(event) {
        		$( ".dis-able-supp" ).removeClass( "dis-able" );
        		//console.log( $('.revenue').val().length);
        		 if( $('.revenue').val().length >=1) {
        			 
        	      	 $(".dis-able-supp").attr("disabled",false);
        	      } else {
        	          $(".dis-able-supp").attr("disabled",true);
        	       }
        	});
        	
        	//max character setting for textarea
        	//$(".revenue").keypress(function(){
         	//  if( $(this).val().length >=1) {
         	//	 $(".dis-able").attr("disabled",false);
         	//  } else {
         	//	 $(".dis-able").attr("disabled",true);
         	//  }
         	  
         	 //});
        	
        	appenduploadText($(".cit"));
        	//keeping form state
        	$(".form-temp").each(function(index,object) {
        		//console.log($(this).attr('form-temp'));
        		$(this).val($(this).attr('form-temp'));
        	});        	
            $(".open, .impatient").pageslide();
           //Set Corresponding Upload Types
			$(document).on('change', '.cit', function(){
				appenduploadText(this);
 				//$('#all_locations').append('<select name="loc_in_england" id="loc_in_england" class="location" ><option value="blank">Select</option><option value="london">London</option>');    
			});
			if($(".reportType").val() === "1") {
				hideStockExchange($(".reportType"));
			}
			
           //based on type hide divs
			$(document).on('change', '.reportType', function(){
				hideStockExchange(this);
			});			
			// $('#publishingDate').val('');
			 $('#publishingDate').daterangepicker({ 
				 singleDatePicker: true ,
				 showDropdowns: true
			 }, function(start, end, label) {
			       
			 }); //dtpicker
		
    	 }); //ready end
		
    </script>
     </div> 
   </body>
</html>