<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   
        <form:form method="POST" class="form-horizontal alignHCenter " action="/secure/customer/customerreview" command="form" modelAttribute="favlist">
		<div class="form-group">            	
				 <div class="col-md-6">
				    <form:label path="">Review</form:label>
					<form:input path="review" class = "form-control" required="required" />
					<form:errors path="review"/>
				 </div>
		</div>
		<input type="hidden" name="id.authorid" value="${favlist.id.authorid }"/>
		<input type="hidden" name="id.customerid" value="${favlist.id.customerid }"/>
		<input type="hidden" name="id.reportid" value="${favlist.id.reportid}"/>
		<div class="col-md-4">
                <button class="btn btn-primary btn-lg sncButton  pull-center" type="submit">Submit Review</button>
         </div>
        </form:form>