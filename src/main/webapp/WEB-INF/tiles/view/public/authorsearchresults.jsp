<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<article id="body" class="col-md-9 noPaddRL">
Authors
 <c:forEach items="${authors}" var="analyst">
 
     <div class="row paddTB20">
			<div class="col-md-12 marginB20">
				<div class="col-md-2 noPaddRL border marginB20">
					<div class="col-sm-12">
						<p class="col-sm-12 text-center paddT20">
							<img alt="Profile Pic" src="images/icon-author.png">
						</p>
						<p class="col-sm-12 boldTxt text-center">${analyst.firstName} ${analyst.lastName}</p>
						<p class="col-sm-12 ext-center">${analyst.country}</p>
					</div>
				</div>
				<div class="col-md-10 noPaddRL border">
					<div class="col-sm-12 paddT15 clearfix ">
						<h4 class="borderB">Research Skills</h4>
						<p class="boldTxt">Company Analyst, Industry Analyst,
							Competitive Intelligence</p>
					</div>
					<div style="display: table"
						class=" paddT15 paddTB10 border clearfix col-sm-12">
						<div class=" col-md-6">
							<span>years of Exp :</span><span class="paddRL">${analyst.id} years</span>
						</div>
						<div class=" col-md-6">
							<a target="_blank" href='/public/author/bio?authorId=${analyst.id}'>Read Bio</a>
						</div>
					</div>

					<div style="display: table"
						class=" paddT15 paddTB10 border clearfix col-sm-12">
						<div class=" col-md-6">
							<a class="btn btn-primary" href="#">Engagement History</a>
						</div>
						<div class=" col-md-6">
							<a class="btn btn-primary" href="/public/customresearch?authorId=${analyst.id}">Request New Research</a>
						</div>
					</div>
				</div>
			</div>
	</div>
  </c:forEach>
</article>
