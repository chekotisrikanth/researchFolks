<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<link rel="stylesheet" href="/css/bootstrap-theme.css">
       <link rel="stylesheet" href="/css/bootstrap.css">
       <link rel="stylesheet" href="/css/customStyles.css">
       <link rel="stylesheet" href="/css/datepicker.min.css">
       <style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
<form:form method="POST" class="form-horizontal alignHCenter " action="/secure/purchase/purchasereport.html" commandpath="form" modelAttribute="form">
        <form:errors path="*" cssClass="errorblock" element="div" />
        	 <div class="form-group comapany">
            	<div class="col-md-2 boldTxt text-right">
            	card number
                </div>
                <div class="col-md-5"><form:input  id="companyTile" path=""  type="text" class="form-control"/></div>
                <div class="col-md-1 boldTxt text-right">
                	name
                </div>
                <div class="col-md-4"><form:input id="webLink" path="" type="text" class="form-control"/></div>
            </div>
            <div class="form-group">
				<div class="col-md-4">
				 </div>
				<div class="col-md-4">
					<button class="btn btn-primary btn-lg sncButton  pull-center " type="submit" >Buy Report</button>
				</div>
            </div>
            <div><input type="hidden" name="reportid" value="${reportid}"  /></div>
  </form:form>              