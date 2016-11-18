<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   
        <form:form id="myform" name="myform" method="POST" class="form-horizontal alignHCenter " action="${pageContext.request.contextPath}/secure/customer/customerreview" command="form" modelAttribute="favlist">
			
		
		<h3>Your Ratging</h3>
    <form:textarea path="review"  placeholder="Write Your Rating" style="width:100%; height:170px;" required="required"></form:textarea>
    <form:errors path="review"/>
    <div style=" margin-top:10px;"> <button type="submit" class="btn btn-primary pull-right marginL10">Submit</button> 
    <button type="submit" class="btn btn-primary pull-right marginL10 cancel ">Cancel</button></div>
	<a href = "javascript:void(0)" 
	onclick = "document.getElementById('light').style.display='none'" 
	class="closeBT"><img src="images/icon_close.png" border="0" alt="close"/></a>	
		<input type="hidden" name="id.authorid" value="${favlist.id.authorid }"/>
		<input type="hidden" name="id.customerid" value="${favlist.id.customerid }"/>
		<input type="hidden" name="id.reportid" value="${favlist.id.reportid}"/>
        </form:form>
        
        <script>
 $(document).ready(function() {
    $('#myform').submit(function(e) {
        e.preventDefault();
        data = $('#myform').serialize();
        $.ajax({
            url: '/secure/customer/customerreview',
            type: 'POST',
            data: data,
            success: function(response) {
                if (response == 'success') {
                	document.getElementById('light').style.display='none'
                } else {
                	document.getElementById('light').style.display='block'
                }; 
            }
        }); 
        
    });
});
</script>