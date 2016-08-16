<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div>

	<aside id="content" class="col-md-3 col-sm-12 noPaddL">
		<h1>
			<a href="#nav" class="open">Menu</a>PageSlide Responsive Demo
		</h1>
		<div class="col-md-12 noPaddRL">

			<ul id="nav" class="nav nav-list leftNav">
				<li><a class="leftNavHeader" href="#">My Account</a></li>
				<li><a href="/secure/home/customerhome" >Orders</a></li>

				<li><a href="javascript:void(0)" onClick="loadFavAnalyst(${customer.id})">Favorite Analyst</a></li>


				<li><a class="leftNavHeader" href="#">Profile</a></li>
				<li><a href="#">Edit Profile</a></li>
				<li><a href="#">Change Password</a></li>
			</ul>
		</div>
	</aside>
	<article id="body" class="col-md-9 noPaddRL">
		<div style="display: table;" class="contentWraper noBorder">
			<h4 class="title">My Orders</h4>
			<div id="myOrdData" class="myOrdData">
				<c:forEach items="${purchases}" var="purchase">
					<div class="col-md-12 marginB20">
						<div class="marginB20 paddT15 paddTB10 borderB clearfix">
							<div class=" col-md-6">
								<span>Order ID :</span><span class="paddRL">${purchase.txnid}</span>
							</div>
							<div class=" col-md-6">
								<span class="paddRL">Purchased on :</span><span>${purchase.purchsedate}</span>
							</div>
						</div>
					</div>
					<div class="col-md-12 marginB20">
						<c:forEach items="${purchase.reports}" var="report">
							<div class="col-md-8 noPaddRL border">
								<div class="orderId ">
									<p>Research Title :</p>${report.reportTitle}</div>
								<div class="orderId ">
									<p>Category :</p>${report.getDiscriminatorValue()}</div>
								<div class="orderId ">
									<p>Price :</p>${report.price}</div>
								<div class="orderId">
									<p>Published on :</p>
									<fmt:formatDate value="${report.publishingDate}"
										pattern="MM-dd-yyyy" />
								</div>
							</div>
							<div class="col-md-4 noPaddRL border marginB20">
								<div class="orderId clearfix">
									<h4>Author</h4>
								</div>
								<div class="col-sm-12">
									<p class="authorPic col-md-6"><img class="img-circle" src="/uploads/profilepics/${report.getReportStatuses().get(0).getUser().getProfilePicName()}" /></p>
									<p class="col-md-6 boldTxt">${report.getReportStatuses().get(0).getUser().getFirstName()}
										${report.getReportStatuses().get(0).getUser().getLastName()}</p>
									<p class="col-md-6">
										Short List &nbsp; &nbsp;<input name="shortlist" 
										value="${report.reportId};${report.getReportStatuses().get(0).getUser().getId()};${purchase.customer.id}" type="checkbox"
											class="marginB5">
									</p>
								</div>
								<div>

									<div class="col-sm-12">
										<a href = "javascript:void(0)" Onclick="showBio(${report.getReportStatuses().get(0).getUser().getId()})">Read Bio</a>
									</div>
									<div class="col-sm-12 marginB5">
										Rate Him <select name="ratehim">
											<option value="${report.reportId};${report.getReportStatuses().get(0).getUser().getId()};${purchase.customer.id};1">1</option>
											<option value="${report.reportId};${report.getReportStatuses().get(0).getUser().getId()};${purchase.customer.id};2">2</option>
											<option value="${report.reportId};${report.getReportStatuses().get(0).getUser().getId()};${purchase.customer.id};3">3</option>
											<option value="${report.reportId};${report.getReportStatuses().get(0).getUser().getId()};${purchase.customer.id};4">4</option>
											<option value="${report.reportId};${report.getReportStatuses().get(0).getUser().getId()};${purchase.customer.id};5">5</option>
										</select>
									</div>
									<div class="col-sm-12 marginB20">
											<a href = "javascript:void(0)" Onclick="writereview(${report.getReportStatuses().get(0).getUser().getId()},${purchase.customer.id},${report.reportId})" 
											>Write Review</a>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</c:forEach>
			</div>

			
		</div>
	</article>
</div>

<div class="popup_box" id="light">

</div>
<div class="popup_box" id="light1">	<!-- OUR PopupBox DIV-->
	
    <p id="paddT20" class="paddT20">Pop up forms are the smart way to present your site. These forms are similar to other forms except, these forms appears abruptly on exact center of screen and requests user to take immediate action over them.

Here, In this example, we explained how to create popup form like Login and Contact form to fulfill below requirements:</p>
    <div style=" margin-top:10px;"><button type="submit" class="btn btn-primary pull-right marginL10 cancel ">Cancel</button></div>
	<a href = "javascript:void(0)" onclick = "document.getElementById('light1').style.display='none';document.getElementById('fade').style.display='none'" class="closeBT"><img src="images/icon_close.png" border="0" alt="close"/></a>	
</div>

 <script src = "${pageContext.request.contextPath}/js/JqueryBase.min.js"></script>  	  
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>


<script>

/* function loadPage() {
	$.ajax({
        async : true,
        type : "GET",
        url : "http://localhost:8080/secure/home/customerhome",
        success : function(html) {
        	$("#content").html(html);
        },    
        error : function(xhr, ajaxOptions, thrownError) {
            //alert(xhr.status);
            //alert(thrownError);
        }
    });

}  */


////public/author/bio?authorId=${analyst.id}
function showBio(id) {
	$.ajax({
        async : true,
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

function writereview(authorId,customerId,reportId) {
	$.ajax({
        async : true,
        type : "GET",
        url : "/secure/customer/customerreview",
        data:'authorId='+authorId+'&customerId='+customerId+'&reportId='+reportId,
        success : function(html) {
        	$("#light").html(html);
        },    
        error : function(xhr, ajaxOptions, thrownError) {
            //alert(xhr.status);
            //alert(thrownError);
        }
    });
	document.getElementById('light').style.display='block';
}

function loadFavAnalyst(id) {
	$.ajax({
        async : true,
        type : "POST",
        url : "http://localhost:8080/secure/customer/loadFavList",
        data:'customerId='+id,
        success : function(html) {
        	$("#body").html(html);
        },    
        error : function(xhr, ajaxOptions, thrownError) {
            //alert(xhr.status);
            //alert(thrownError);
        }
    });

}

$(document).ready(function() {
	
	$('input[type="checkbox"][name="shortlist"]').change(function () {
	    if (this.checked) {
	    	   var value = $(this).val().split(";");
	    	   var reportId = (value[0]).trim();
	    	   var authorId = (value[1]).trim();
	    	   var custmerId = (value[2]).trim();
	           var url = "/secure/customer/authorshortlist"; 
	           $.ajax({
	               type: "POST",
	               url: url,
	               data: 'reportId='+reportId+'&authorId='+authorId+'&custmerId='+custmerId,      //POST variable name value
	               success: function(msg){
	                    if(msg =='success'){
	                        //alert('success');
	                    } 
	                    else{
	                        alert('Fail');
	                    }
	               }
	           }); 
	    }
	});
	
	$('select[name="ratehim"]').change(function () {
	    	   var value = $(this).val().split(";");
	    	   var reportId = (value[0]).trim();
	    	   var authorId = (value[1]).trim();
	    	   var custmerId = (value[2]).trim();
	    	   var rating = (value[3]).trim();
	           var url = "/secure/customer/rateauthor"; 
	           $.ajax({
	               type: "POST",
	               url: url,
	               data: 'reportId='+reportId+'&authorId='+authorId+'&custmerId='+custmerId+'&rating='+rating,      //POST variable name value
	               success: function(msg){
	                    if(msg =='success'){
	                        //alert('success');
	                    } 
	                    else{
	                        alert('Fail');
	                    }
	               }
	           }); 
	});
});	
</script>