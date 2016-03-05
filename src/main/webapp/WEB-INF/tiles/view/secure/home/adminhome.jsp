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
        
        


</head>
<body>
<form:form method="POST" action="/secure/updateReports.html" commandName="ViewReports" modelAttribute="editreports">
 <section>
<article class="col-md-12 noPaddRL table-responsive">
<table class="table table-striped table-hover table-bordered colored-Thead">
    <th>Report Title</th>
    <th>Publishing Date</th>
    <th>Industry</th>
    <th>Country</th>
    <th>Name</th>
    <th>UserType</th>
    <th>Status</th>
   
    <c:forEach items="${editreports.reports}" var="report">
        <tr>
            <td> <c:out value="${report.reportTitle}"/> </td>
            <td> <c:out value="${report.publishingDate}"/> </td>
            <td> <c:out value="${report.industry}"/> </td>
            <td> <c:out value="${report.country}"/> </td>
            <c:forEach items="${report.reportStatuses}" var="reportStatuses">
	            <td> <c:out value="${reportStatuses.user.firstName}"/> </td>
	            <td> <c:out value="${reportStatuses.userType}"/> </td>
	            <td> <c:out value="${reportStatuses.status}"/> </td>
            </c:forEach>
   <td>  <button id="${report.reportId}" name="reviewer" type="button" value="${report.reportId}">add</button></td>
   
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

<div>
        <input type="submit"/>
    </div>
  </article>
  </section>
</form:form>
<a href="/public/logout.html">Logout</a>
</body>
</html>

