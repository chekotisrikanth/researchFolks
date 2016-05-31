<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
      <div id="total_count" total-cnt="${editreports.totalPages}"></div>
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
			    
			    <th>Publisher</th>
			    <th>Reviewer</th>
			    <th></th>
    
   
			     <c:forEach items="${editreports.reports}" var="report" varStatus="indexLoop">
			        <tr>
			            <td> <c:out value="${report.reportTitle}"/> </td>
			            <td> <c:out value="${report.publishingDate}"/> </td>
			            <td> <c:out value="${report.industry}"/> </td>
			            <td> <c:out value="${report.country}"/> </td>
			            <c:forEach items="${report.reportStatuses}" var="reportStatuses">
				            <td> <c:out value="${reportStatuses.user.firstName}"/> </td>
				            <td> <c:out value="${reportStatuses.userType}"/> </td>
				            <td> <c:out value="${reportStatuses.status}"/> </td>
				            <td><a href="#" class="downreport" rep-id="${report.reportId}"><img src="${pageContext.request.contextPath}/images/icon-download.png" alt="Edit"/></a></td>
				            <td>
				            <c:if test="${empty report.publisherId}">
					            <select id="pubSelect" name="pubSelect" class = "form-control dis-able pub-${indexLoop.index} }" >
							</c:if>
							
							<c:if test="${not empty report.publisherId}">
					            <select id="pubSelect" name="pubSelect" class = "form-control dis-able pub-${indexLoop.index} }" disabled="disabled">
							</c:if>	
			                  		 <option value="">Select Publisher</option> 
					                    <c:forEach items="${publishersJson}" var="publisher">
						                   	<c:choose>
						                 		<c:when test="${report.publisherId == publisher.id}">
						                 			<option   value="${publisher.id}"  selected>${publisher.firstName}</option>
						                 		</c:when>
						                 		<c:otherwise>
						                 			<option   value="${publisher.id}"  >${publisher.firstName}${reportForm.publisherId}</option>
						                 		</c:otherwise>
						                 	</c:choose>
					          				 
					          			 </c:forEach>
			                	 </select> 
			            	  <!--    <a href="#"><img src="${pageContext.request.contextPath}/images/icon-reasign.png" alt="Re Asign"/></a> -->				         		
			         		</td>
			         		 <td>
		         		 	<c:if test="${empty report.reporterId}">
						    	<select id="reviewrsSelect" name="reviewrsSelect" class = "form-control dis-able rev-${indexLoop.index}">
							</c:if>
							
							<c:if test="${not empty report.reporterId}">
						    	<select id="reviewrsSelect" name="reviewrsSelect" class = "form-control dis-able rev-${indexLoop.index}" disabled="disabled">
							</c:if>		        
		            	  <!--   <select id="reviewrsSelect" name="reviewrsSelect" class = "form-control dis-able rev-${indexLoop.index}"> -->
	                  		 <option value="">Select Reviewer</option> 
			                    <c:forEach items="${reviewersJson}" var="reviewer">
			                    	<c:choose>
			                    		<c:when test="${report.reporterId == reviewer.id}">
			                    			<option   value="${reviewer.id}"  selected>${reviewer.firstName}</option>
			                    		</c:when>
			                    		<c:otherwise>
			                    			<option   value="${reviewer.id}"  >${reviewer.firstName}</option>
			                    		</c:otherwise>
			                    	</c:choose>
			          				 
			          			 </c:forEach>
	                	 </select>
		            	 <!--  <a href="#"><img src="${pageContext.request.contextPath}/images/icon-reasign.png" alt="Re Asign"/>	</a>  -->	         		
		            	
			         </td>
			       </c:forEach>
					 <c:if test="${(empty report.reporterId) || (empty report.publisherId)  }">
					   <td>  <input type="checkbox" class="chk" value="true" rep-id="${report.reportId}" id="${indexLoop.index}"/></td>
					</c:if>
					 <c:if test="${(not empty report.reporterId) || (not empty report.publisherId)  }">
					  
					  <!--  <td>  <input type="checkbox" class="chk" value="true" rep-id="${report.reportId}" id="${indexLoop.index}"/></td>  -->
						<td><a href="#" class="edit  edit-${report.reportId}" rep-id="${report.reportId}" alt="Edit" ><img src="${pageContext.request.contextPath}/images/PersmissionsActiveIcon.png" alt="Edit"/></a>
						<input type="checkbox" class="chk" value="true" rep-id="${report.reportId}" id="${indexLoop.index}" style="display:none;"/>
						</td>
					</c:if>
  				
   
     <%-- <div>
        <form:label path="reportStatuses.user.accountType"><spring:message code="admin.accountType"/></form:label>
         <form:select path="reportStatuses.user.accountType">
					  <form:option value="" label="--- Select ---" />
					  <form:options items="${accountTypes}" />
		</form:select>
        <form:errors path="reportStatuses.user.accountType"/>
    </div>
    
    <div>
        <form:label path="reviewer"><spring:message code="user.reviewer"/></form:label>
         <form:select path="reviewer">
					  <form:option value="" label="--- Select ---" />
					  <form:options items="${reviewers}" />
		</form:select>
        <form:errors path="reviewer"/>
    </div>
    
    <div>
        <form:label path="publisher"><spring:message code="user.publisher"/></form:label>
         <form:select path="publisher">
					  <form:option value="" label="--- Select ---" />
					  <form:options items="${publishers}" />
		</form:select>
        <form:errors path="publisher"/>
    </div>
     --%>    
     
     </tr>    
    </c:forEach>
</table>
<div id="dialog-confirm"></div>
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

  
        </article>
        
      </section>
      </form:form>
      </div> 
      <div id="displayAlertMsg"></div>
      <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
     <script src = "${pageContext.request.contextPath}/js/JqueryBase.min.js"></script>
      
      <!-- Include all compiled plugins (below), or include individual files as needed -->
   <%--    <script src="${pageContext.request.contextPath}/js/bootstrap-datepicker.js"></script> --%>
      <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
      <script src="${pageContext.request.contextPath}/js/jquery.pageslide.min.js"></script>
      <!-- pagenation start -->
      <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/simplePagination.css"/>
      <script type="text/javascript" src="${pageContext.request.contextPath}/js/simplePagination.js" ></script>
      <script type="text/javascript" src="${pageContext.request.contextPath}/js/common/pagenationutil.js" ></script>
      <!-- pagenation end -->
      <script src="${pageContext.request.contextPath}/js/admin/ajaxcalls.js"></script>
      <script type="text/javascript" src="${pageContext.request.contextPath}/js/common/popuputil.js" ></script>
<!-- 
       <script>
        $(document).ready(function() {
            $(".open, .impatient").pageslide();
        });
       
        console.log(${reviewersJson})
    </script> -->
     

