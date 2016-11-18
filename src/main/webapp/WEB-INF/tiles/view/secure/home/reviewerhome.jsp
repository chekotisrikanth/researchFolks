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

        
        
<script type="text/javascript">
            jQuery.noConflict();
        </script>
      

</head>
<body>
   <div class="container-fluid">

      <form:form method="POST" action="${pageContext.request.contextPath}/secure/updateReports.html" commandName="ViewReports" modelAttribute="editreports">
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
			            <td> <c:out value="${report.countryObj.countryName}"/> </td>
			            <c:forEach items="${report.reportStatuses}" var="reportStatuses">
				            <td> <c:out value="${reportStatuses.user.firstName}"/> </td>
				            <td> <c:out value="${reportStatuses.userType}"/> </td>
				            <td> <c:out value="${reportStatuses.status}"/> </td>
				            <td class="col-md-1"><a href="#" class="downreport" rep-id="${report.reportId}"><img src="${pageContext.request.contextPath}/images/icon-download.png" alt="Edit"/></a>
				            	<a href="#" class="uploadDoc"><img src="${pageContext.request.contextPath}/images/icon-upload.png" alt="Edit"/></a>
				           		<input type='file'  class="fileUp file-${report.reportId}" name ="report" style="display:none;" />
				            </td>
				             <td>
					             <a href="#" class="cmnt cmnt-${report.reportId}" rep-id="${report.reportId}" ><img src="${pageContext.request.contextPath}/images/comment.png" alt="Edit"/>
					      			<c:if test='${report.haveComments eq "Y"}'> 			      			
									 	<span class="badge btn btn-primary">${report.comntCnt}</span>;							
									</c:if>
								</a>
							</td>
			      		 <td> 
    						<select  name="reviewrsSelect" class = "form-control dis-able rev-${report.reportId}">
    						<c:choose>
    							<c:when test="${reportStatuses.statusId == 3}">
    								<option value="1" >Publisher</option> 
			                 		 <option value="2" selected>Report Comments</option> 
    							</c:when>
    							<c:when test="${reportStatuses.statusId == 4 || reportStatuses.statusId == 5}">
    							 
			                 	 <option value="2" >Report Comments</option>
			                 	  <option value="1" selected>Publisher</option>
    							</c:when>
    							<c:otherwise>
    								
			                 	 <option value="2">Report Comments</option>
			                 	 <option value="1">Publisher</option> 
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
      
      <script src="${pageContext.request.contextPath}/js/utils/chatHistory.js"></script>
      
      <script type="text/javascript" src="${pageContext.request.contextPath}/js/common/popuputil.js" ></script>
       
      
       <script>
       
    </script>
     
   </body>
         <div id="displayAlertMsg" ></div>
   
</html>

