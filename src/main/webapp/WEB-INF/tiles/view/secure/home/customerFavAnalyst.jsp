<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<article id="body" class="col-md-9 noPaddRL"> ShortListed
Authors <c:forEach items="${favAnalyst}" var="analyst">
	<div>
		<a target="_blank"
			href='/secure/customer/authorbio?authorId=${analyst.id}'>
			${analyst.firstName} ${analyst.lastName}</a>
	</div>
</c:forEach> </article>
<article class="col-md-9 noPaddRL"> Search Authoers to
Shortlist <form:form id="myform" action="${pageContext.request.contextPath}/public/authors/searchauthors"
	method="post" commandName="author">


	<div style="display: table;" class="contentWraper noBorder col-sm-12">
		<div class="row paddTB20">
			<div class="row">
				<div class="col-md-1 col-sm-1 "></div>
				<div class="col-md-1 col-sm-6 ">Title</div>
				<div class="col-md-3 col-sm-6">
					<input type="text" name="name" class="form-control">
				</div>
				<div class="col-md-1 col-sm-1 "></div>
				<div class="col-md-2 col-sm-6 ">Years of Experience</div>
				<div class="col-md-3 col-sm-6">
					<select name="exprange" class="form-control">
						<option>1-4</option>
						<option>5-9</option>
						<option>10-14</option>
						<option>15-19</option>
						<option>20-30</option>
					</select>
				</div>
				<div class="col-md-1 col-sm-1 "></div>
			</div>
			<div class="row paddTB10">
				<div class="col-md-1 col-sm-1 "></div>
				<div class="col-md-1 col-sm-6 ">Country</div>
				<div class="col-md-3 col-sm-6">
					<select id="country" name="country" class="form-control">
						<option selected value="any">Any</option>
						<c:forEach items="${countries}" var="country">
							<option value="${country.countryId}">${country.countryName}</option>
						</c:forEach>
					</select>

				</div>
				<div class="col-md-1 col-sm-1 "></div>
				<div class="col-md-2 col-sm-6 ">Skills</div>
				<div class="col-md-3 col-sm-6">
					<select name="skillset" class="form-control allSkills" multiple>
						<c:forEach items="${skills}" var="skill">
							<option value="${skill.skill}">${skill.skill}</option>
						</c:forEach>
					</select>
				</div>
				<div class="col-md-1 col-sm-1 "></div>
			</div>
		</div>
		<div class="form-group">
						<div class="col-md-4"></div>
						<div class="col-md-4">
						
							<button class="btn btn-primary btn-lg sncButton  pull-center "
								type="submit">Search Authors</button>
						</div>
		</div>
		</form:form> 
 </article>
 
 <div id="searchresults" name="searchresults" ></div>
 
 <script>
 $(document).ready(function() {
    $('#myform').submit(function(e) {
        e.preventDefault();
        data = $('#myform').serialize();
        $.ajax({
            url: '/public/authors/searchauthors',
            type: 'POST',
            data: data,
            success: function(response) {
                if (response == 'empty') {
                    alert('Error occured while submiting form');
                } else {
                    $('#searchresults').html(response);
                }; 
            }
        });     
    });
});
</script>