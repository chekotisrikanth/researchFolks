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
							<a href = "javascript:void(0)" Onclick="showBio(${analyst.id})" >Read Bio</a>
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

<div class="popup_box" id="light1">	<!-- OUR PopupBox DIV-->
	
    <p id="paddT20" class="paddT20"></p>
    <div style=" margin-top:10px;"><button type="submit" class="btn btn-primary pull-right marginL10 cancel ">Cancel</button></div>
	<a href = "javascript:void(0)" onclick = "document.getElementById('light1').style.display='none';document.getElementById('fade').style.display='none'" class="closeBT"><img src="images/icon_close.png" border="0" alt="close"/></a>	
</div>

   
<script>
function showBio(id) {
	$.ajax({
        type : "GET",
        url : "/public/author/bio",
        data:'authorId='+id,
        success : function(html) {
        	$("#paddT20").html(html);
        },    
        error : function(xhr, ajaxOptions, thrownError) {
            //alert(xhr.status);
            //alert(thrownError);
        }
    });
	document.getElementById('light1').style.display='block';
}
</script>
