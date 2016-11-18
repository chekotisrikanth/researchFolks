<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		<form:form method="POST"  class="form-horizontal alignHCenter" action="${pageContext.request.contextPath}/publish/industryReportForm_create.html" commandName="form" modelAttribute="form" enctype="multipart/form-data">
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
			
			    <div class="form-group ${status.error ?'has-error':''} ">
              <form:label path="" class="col-md-2 control-label text-right">Taxonomy / Industries Tree</form:label>
                                        <div class="col-md-10">
                							<div style='cursor: pointer; cursor: hand; display: inline-block;' onclick="popupTree();" id="overlayContainer">
                                    			<img class="img-responsive" id="main_image" src="${pageContext.request.contextPath}/tree/assets/images/tree.png"></img>
                                    			<img class="img-responsive" id="overlay_image" src="${pageContext.request.contextPath}/tree/assets/images/hand.png"></img>
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
					<select class = "form-control cit" name="comIntl" required="required">
					<option value="">Select Intelligence</option>
						<option value=1 ${form.comIntl eq 1 ?'selected':''}>Industry Report</option> 
						<option value=2 ${form.comIntl eq 2 ?'selected':''}>Industry Database</option>                                                                               
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
				<form:textarea class="form-control" path="overview" max-char="1500" rows="3" cols="30" required="required"/>
				<!--<form:errors path="overview"/>-->
				<span class="text-info"></span>
			</div>
		</div>
	  </spring:bind>
		 <spring:bind path="tableOfContents">
	       <div class="form-group ${status.error ?'has-error':''} ">
			<form:label class="col-md-3 control-label text-right" path="tableOfContents"><spring:message code="reportForm.tableOfContents"/></form:label>                          
			<div class="col-md-9">
				<form:textarea class="form-control" path="tableOfContents" max-char="1500" rows="3" cols="30" required="required"/>
				<!--<form:errors path="tableOfContents"/>-->
				<span class="text-info"></span>
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
     <script src="${pageContext.request.contextPath}/tree/assets/dist/jstree.min.js"></script>
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
        	$("textarea").keyup(function(){
          	   $(this).next().html("Characters left: " + ($(this).attr("max-char") - $(this).val().length));
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

 