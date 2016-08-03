<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="row">
  <div class="col-sm-4">Name</div>
  <div class="col-sm-4">${author.firstName} ${author.lastName}</div>
</div>

<div class="row">
  <div class="col-sm-4">Skills</div>
  <div class="col-sm-4">
	  <c:forEach items="${author.keyskills}" var="keyskill">${keyskill.skill}</c:forEach>
  </div>
</div>

<div class="row">
  <div class="col-sm-4">Bio</div>
  <div class="col-sm-4">${author.bio}</div>
</div>