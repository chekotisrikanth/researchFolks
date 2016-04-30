<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
                           <div class="col-md-12">
              <table cellspacing="0" cellpadding="0" border="0" width="100%" class="table table-striped table-hover table-bordered colored-Thead">
              	<tbody>
    
    	<c:if test="${fn:length(authorsList) == 0}">
   				<p>No Authors found</p>
		</c:if>
    		<c:forEach items="${authorsList}" var="author" varStatus="myIndex">
    		
    		 <c:if test="${myIndex.index==1}">
    		 <tr>
			      <th><spring:message code="custm.research.sno"/></th>
			      <th><spring:message code="custm.research.name"/></th>
			      <th><spring:message code="custm.research.country"/></th>
			      <th><spring:message code="custm.research.yoe"/></th>
			      <th><spring:message code="custm.research.viewProfile"/></th>
			      <th><spring:message code="custm.research.shortlist"/></th>
			      <th>&nbsp;</th>
    		</tr>
    		 </c:if>
					 <tr>
					      <td>${myIndex.index}</td>
					      <td>${author.firstName}  ${author.lastName}</td>
					      <td>${author.country}</td>
					      <td>4</td>
					      <td><a href="#"><img alt="Profile" src="/images/icon-view-profile.png"></a></td>
					      <td><a href="#"><img alt="Profile" src="/images/icon-short-list.png"></a></td>
					      <td><input name="analyst" value="${author.id}" type="checkbox"></td>
    			</tr>		
			</c:forEach>
    
  </tbody>
</table>

              </div>
