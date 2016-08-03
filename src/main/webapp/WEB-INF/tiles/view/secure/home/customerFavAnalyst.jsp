<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<article id="body" class="col-md-9 noPaddRL">
ShortListed Authors
 <c:forEach items="${favAnalyst}" var="analyst">
     <div><a target="_blank" href='/secure/customer/authorbio?authorId=${analyst.id}'> ${analyst.firstName} ${analyst.lastName}</a></div>
  </c:forEach>
</article>
<article class="col-md-9 noPaddRL">
Search Authoers to Shortlist
	<form:form action="/public/authors/searchauthors" method="post" commandName="author">


        <div style="display:table;" class="contentWraper noBorder col-sm-12">
        <div class="row paddTB20">
       		<div class="row">
            	<div class="col-md-1 col-sm-1 "></div>
                <div class="col-md-1 col-sm-6 ">Title</div>
                <div class="col-md-3 col-sm-6"><input type="text" name="firstName" class="form-control"></div>
                 <div class="col-md-1 col-sm-1 "></div>
                <div class="col-md-2 col-sm-6 ">Years of Experience</div>
                <div class="col-md-3 col-sm-6"><select name="exprange" class="form-control">
                	<option>1-4</option>
                    <option>5-9</option>
                    <option>10-14</option>
                    <option>15-19</option>
                    <option> 20</option>
                </select></div>
                 <div class="col-md-1 col-sm-1 "></div>
            </div>
            <div class="row paddTB10">
            <div class="col-md-1 col-sm-1 "></div>
            	<div class="col-md-1 col-sm-6 ">Country</div>
                <div class="col-md-3 col-sm-6">
                <select id="country" name="country" class="form-control">
                          <option  selected value="any">Any</option>
                    	<c:forEach items="${countries}" var="country">
							<option   value="${country.countryId}"  >${country.countryName}</option>
						</c:forEach>
                    </select>
                
                </div>
                 <div class="col-md-1 col-sm-1 "></div>
                <div class="col-md-2 col-sm-6 ">Skills</div>
                <div class="col-md-3 col-sm-6">
                <select name="skillset" class="form-control allSkills" multiple>
                    	<c:forEach items="${skills}" var="skill">
							<option   value="${skill.skill}"  >${skill.skill}</option>
						</c:forEach>
                 </select>
                </div>
                 <div class="col-md-1 col-sm-1 "></div>
            </div>
         </div>
         <div class="row paddTB20">
         <div class="col-md-12 marginB20">
         <div class="col-md-2 noPaddRL border marginB20">
       <div class="orderId clearfix">
       
       </div>
       <div class="col-sm-12">
       	<p class="col-sm-12 text-center paddT20"><img alt="Profile Pic" src="images/icon-author.png"></p>
       	<p class="col-sm-12 boldTxt text-center">Ram</p>
        <p class="col-sm-12 ext-center">Country Name</p>
        </div>
        <div>
        
       </div>
       </div>
       <div class="col-md-10 noPaddRL border">
       <div class="col-sm-12 paddT15 clearfix ">
       <h4 class="borderB">Research Skills</h4>
       	<p class="boldTxt">Company Analyst, Industry Analyst, Competitive Intelligence</p>
       </div>
       <div style="display:table" class=" paddT15 paddTB10 border clearfix col-sm-12">
       	<div class=" col-md-6"><span>years of Exp :</span><span class="paddRL">6 years</span></div>
        <div class=" col-md-6"><a onclick="document.getElementById('light1').style.display='block';document.getElementById('fade').style.display='block'" href="javascript:void(0)">Read Bio</a></div>
        </div>
        
        <div class="form-group">
				<div class="col-md-4">
				 </div>
				<div class="col-md-4">
					<button class="btn btn-primary btn-lg sncButton  pull-center " type="submit" >Search Authors</button>
				</div>
            </div>
            
        <div style="display:table" class=" paddT15 paddTB10 border clearfix col-sm-12">
       	<div class=" col-md-6"><a class="btn btn-primary" href="#">Engagement History</a></div>
        <div class=" col-md-6"><a class="btn btn-primary" href="#">Request New Research</a></div>
        </div>		
       </div>
       </div>
         </div>
            </div>
      </form:form>  
        </article>