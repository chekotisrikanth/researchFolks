<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
 		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-theme.css">
       <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css">
       <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/customStyles.css">
<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
        <script src="http://code.jquery.com/jquery-latest.min.js"></script>
 <script type="text/javascript">
    $(function() {

        // Start indexing at the size of the current list
        var index = ${fn:length(editreports.reports[0].reportStatuses)};
        //var reviewers[] = '${reviewers}';
        // Add a new Employee
        //$("#add").off("click").on("click", function() {
        	$('button[name="reviewer"]').off("click").on("click", function() {
            $(this).before(function() {
            	var value=$(this).attr("value");
            	//alert(value)
            	var reportId = '<input type="hidden" name="viewReportsList[0].reportId" value="'+value+'"/>';
            	//alert(reportId);
            	var newDropdown = '<select name="viewReportsList[0].reviewerIds[0]">'; 
            	//var accountType ='<input type="hidden" name="reports[0].reportUserProfiles[0].userProfile.type" value="REVIEWER"/>';
            	//'<select name=' + value + '>';    //document.createElement('select');
            	var list = ${reviewersJson};
        		$.each(list, function( index, value ) {
        			//alert( index + ": " + value.emailId );
        			newDropdown += '<option value="'+value.emailId+'">'+value.firstName+'</option>';
        		});
        		newDropdown += reportId;
        		
                
                //alert(${fn:length(reviewers)});
                //alert('${reviewers.get(0).getEmailId()}');	
                //for(i=0;i<reviewers.lenght;i++) {
	                //newDropdown += '<option value="'+reviewers[i].getEmailId()+'">'+'{reviewers.get(i).getEmailId()}'+'</option>';
                	
                	/* newDropdownOption = document.createElement("option");
	                newDropdownOption.value = reviewers[i].getEmailId();
	                newDropdownOption.text = reviewers[i].getEmailId();
	                newDropdown.add(newDropdownOption); */
	             //}  
                newDropdown += '</select>';
                //alert(newDropdown);
                var html = '<td id="editreports' + index + '.wrapper" class="hidden"></td>';                    
                //html += '<td>accountype<input type="text" id="reports[0].reportStatuses' + index + '.user.accountType" name="reports[0].reportStatuses[' + index + '].user.accountType" /></td>';
                html += '<td>'+newDropdown+'</td>';
                //html += '<td>emailid<input type="text" id="reports[0].reportStatuses' + index + '.user.emailId" name="reports[0].reportStatuses[' + index + '].user.emailId" /><td>';
                //html += '<input type="hidden" id="editreports' + index + '.remove" name="editreports[' + index + '].remove" value="0" />';
                //html += '<a href="#" class="editreports.remove" data-index="' + index + '">remove</a>';                    
                html += "</div>";
                return html;
            });
            $("#editreports" + index + "\\.wrapper").show();
            index++;
            return false;
        });
        
     // Remove an Employee
        $("a.editreports\\.remove").off("click").on("click", function() {
            var index2remove = $(this).data("index");
            $("#editreports" + index2remove + "\\.wrapper").hide();
            $("#editreports" + index2remove + "\\.remove").val("1");
            return false;
        });

    });

   </script>     
        
        
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
      <form:form method="POST" action="/secure/updateReports.html" commandName="ViewReports" modelAttribute="editreports">
      <section>
        <article class="col-md-12 noPaddRL table-responsive">
        
       		<table class="table table-striped table-hover table-bordered colored-Thead">
			    <th>Report Title</th>
			    <th>Published Date</th>
			   
			    <th>Industry</th>
			    <th>Country</th>
			    <th>Author</th>
			    <th>UserType</th>
			    
			    <th>Status</th>
			    <th>Edit</th>
			      <th>Comments</th>
			   		<th>Assign To</th>
    					<th></th>
   
			     <c:forEach items="${editreports.reports}" var="report" varStatus="indexLoop">
			        <tr >
			            <td> <c:out value="${report.reportTitle}"/> </td>
			            <td> <c:out value="${report.publishingDate}"/> </td>
			            <td> <c:out value="${report.industry}"/> </td>
			            <td> <c:out value="${report.country}"/> </td>
			            <c:forEach items="${report.reportStatuses}" var="reportStatuses">
				            <td> <c:out value="${reportStatuses.user.firstName}"/> </td>
				            <td> <c:out value="${reportStatuses.userType}"/> </td>
				            <td> <c:out value="${reportStatuses.status}"/> </td>
				            <td><a href="#" class="downreport" rep-id="${report.reportId}"><img src="${pageContext.request.contextPath}/images/icon-download.png" alt="Edit"/></a>
				            	<a href="#" class="uploadDoc"><img src="${pageContext.request.contextPath}/images/icon-upload.png" alt="Edit"/></a>
				           		<input type='file'  class="fileUp file-${report.reportId}" name ="report" style="display:none;" />
				            </td>
				             <td><a href="#" class="cmnt cmnt-${report.reportId}" rep-id="${report.reportId}" ><img src="${pageContext.request.contextPath}/images/icon-upload.png" alt="Edit"/></a>
			      		 <td> 
    						<select  name="reviewrsSelect" class = "form-control dis-able rev-${report.reportId}">
    						<c:choose>
    							<c:when test="${reportStatuses.statusId == 3}">
    								<option value="1" >Publisher</option> 
			                 		 <option value="2" selected>Author</option> 
    							</c:when>
    							<c:when test="${reportStatuses.statusId == 4 || reportStatuses.statusId == 5}">
    							 <option value="1" selected>Publisher</option> 
			                 	 <option value="2" >Author</option>
    							</c:when>
    							<c:otherwise>
    								<option value="1">Publisher</option> 
			                 	 <option value="2">Author</option>
    							</c:otherwise>
    						</c:choose>
	                  		  
	                	 	</select>
	               		 </td> 
	               		 <c:if test="${reportStatuses.statusId != 4 && reportStatuses.statusId != 5}">
								<td>  <input type="checkbox" class="chk" value="true" rep-id="${report.reportId}"/></td>
							</c:if>
	               		 
			      		 </c:forEach>
    				 </tr>    
    				</c:forEach>
				</td>	
				
    			<%--  <td>  <textarea class="comments"  rep-id="${report.reportId}" id="${indexLoop.index}"/></td>	 --%>
</table>
<div class="col-md-2 pull-right">
        <button class="btn btn-block btn-custom btn-info m_top20  sncButton " type="button"><img id="processingImg1" style="display:none;height:25px;width:25px;margin-right:5px" src="${pageContext.request.contextPath}/images/ajax-loader.gif"/>Submit</button>
  </div>
<div class="col-md-12">
	<!-- <ul class = "pagination pagination-sm noMarginTB" style="padding-left:40%;">
	   <li><a href = "#">&laquo;</a></li>
	   <li class = "active"><a href = "#">1</a></li>
	   <li class = "disabled"><a href = "#">2</a></li>
	   <li><a href = "#">3</a></li>
	   <li><a href = "#">4</a></li>
	   <li><a href = "#">5</a></li>
	   <li><a href = "#">&raquo;</a></li>
	</ul> -->
	<div id="paginateDiv"></div>
</div>
  <div id="total_count" total-cnt="${editreports.totalPages}"></div>
        </article>
        
      </section>
      </form:form>
      </div> 
      <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
     <script src = "${pageContext.request.contextPath}/js/JqueryBase.min.js"></script>
      
      <!-- Include all compiled plugins (below), or include individual files as needed -->
      <script src="${pageContext.request.contextPath}/js/bootstrap-datepicker.js"></script>
      <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
      <script src="${pageContext.request.contextPath}/js/jquery.pageslide.min.js"></script>
      <!-- pagenation start -->
      <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/simplePagination.css"/>
      <script type="text/javascript" src="${pageContext.request.contextPath}/js/simplePagination.js" ></script>
      <script type="text/javascript" src="${pageContext.request.contextPath}/js/common/pagenationutil.js" ></script>
      <!-- pagenation end -->
      <script src="${pageContext.request.contextPath}/js/reviwer/reviwerAjaxCalls.js"></script>
      <script type="text/javascript" src="${pageContext.request.contextPath}/js/common/popuputil.js" ></script>
       
      
       <script>
       
    </script>
     
   </body>
         <div id="displayAlertMsg" class="col-md-6"></div>
   
</html>

