<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
        <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script>
        
        $(document).ready(
        function() {

            $('#countryId').change(
            function() {
                
                $.getJSON('loadStates.json', {
                    countryId : $(this).val(),
                    ajax : 'true'
                }, function(data) {
                    
                    var html = '<option value="">----Select State----</option>';
                    var len = data.length;
      
                    for ( var i = 0; i < len; i++) {
                        html += '<option value="' + data[i].stateId + '">' + data[i].stateName + '</option>';
                    }
                    html += '</option>';
   
                    $('#city').html(html);
                });
            });
            
        });
        
    </script>

	<div class="form-group">
            	<div class="col-md-6">
            	<spring:message code="user.country" var="countryLbl"/>
                	<select id="countryId" name="country" class = "form-control" required>	
					  <option value=""> ${countryLbl} </option>
						<c:forEach items="${countryList}" var="country">
							<option   value="${country.countryId}"  >${country.countryName}</option>
						</c:forEach>
					</select>
					<form:errors path="country"/>
                </div>
       </div>	          
	   <div class="form-group">
            	<div class="col-md-6">
                	<spring:message code="user.city" var="cityLbl"/>					
					<select  id="city" name="city" class = "form-control">
                        <option value="">Select State</option> 
                    </select>
					<form:errors path="city"/>
                </div>
    	</div>
		