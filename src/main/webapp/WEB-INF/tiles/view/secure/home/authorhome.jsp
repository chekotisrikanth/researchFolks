<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html lang = "en">
   
   <head>
      <meta charset = "utf-8">
      <meta http-equiv = "X-UA-Compatible" content = "IE = edge">
      <meta name = "viewport" content = "width = device-width, initial-scale = 1">
      <!--[if IE]>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <![endif]-->
      <title>Research Floks</title>
      
      <!-- Bootstrap -->
       <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-theme.css">
       <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css">
       <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
       <link rel="stylesheet" href="${pageContext.request.contextPath}/css/customStyles.css">
       <link rel="stylesheet" href="${pageContext.request.contextPath}/css/chartsStyles.css">
    
      
      <!-- <script type="text/javascript">
            jQuery.noConflict();
        </script> -->
	
   </head>
   
   <body>
   <div class="container-fluid">
  	<header class="clearfix paddB10 paddTB10">
     <div class="logo col-md-8 col-sm-12">
     <a href="#"><img src="images/logo1.jpg" alt="Research Floks"/></a>
     </div>
     <div class="customerInfo col-md-4 col-sm-12 paddT20">
     	<div class="col-md-8 col-sm-12">
        	<div class="col-md-4">
            	<a href="#"><img src="images/icon-user.png" alt="Customer Img"/></a>
            </div>
            <div class="col-md-8 noPaddRL paddT15">
            <div class="customerName col-md-12 col-sm-12 noPaddRL">Customer Name</div>
            <div class="fontSmall  col-md-12 col-sm-12">Customer Skill</div>
            </div>
        </div>
        <div class="col-md-4 col-sm-12 noPaddRL paddT15 ">
	        <div class="col-md-12 fontSmall marginB5">
            	<span class="iconL"><img src="images/icon-alert.png" alt="alerts"/></span> <a href="#">Alerts</a>
            </div>
            <div class="col-md-12 fontSmall">
            	<span class="iconL"><img src="images/icon-mesage.png" alt="Message"/></span> <a href="#">Message</a>
            </div>
        </div>
     </div>
     </header>
     
    <nav id="myNavbar" class="navbar navbar-default" role="navigation">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse noPaddRL" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                  <li><a href="#">Home</a></li>
                  <li><a href="#">How It Works</a></li>
                  <li><a href="#">Research Store</a></li>
                  <li><a href="#">Custom Research</a></li>
                  <li><a href="#">Blog</a></li>
                  <li><a href="#">Contact Us</a></li>
                </ul>
            </div><!-- /.navbar-collapse -->
    </nav>
    
    <article>
     
      	<aside class="col-md-3 col-sm-12 noPaddL" id="content">
        <h1><a class="open" href="#nav">Menu</a>PageSlide Responsive Demo</h1>
        	<div class="col-md-12 noPaddRL">
             
            <ul class="nav nav-list leftNav" id="nav">
                <li><a href="#" class="leftNavHeader">Reports <span class="iconL"><img src="images/icon-chart.png" alt="chart"/></span></a></li>
                <li><a href="#">Stake</a></li>
                <li><a href="#">Sales</a></li>
                <li class="marginB20"><a href="#">Uploads</a></li>
            
                <li><a href="#" class="leftNavHeader">Profile <span><img src="images/icon-profie.png" alt="profile"/></span></a></li>
                <li><a href="#">Edit profile</a></li>
                <li class="marginB20"><a href="#">Change Password</a></li>
                
                <li><a href="#" class="leftNavHeader">On Demond Jobs <span>icon</span></a></li>
                <li><a href="#">Find Work</a></li>
                <li><a href="#">Saved Jobs</a></li>
                <li><a href="#">Invitation</a></li>
            </ul>
            </div>
        </aside>
        <div class="contentWraper col-md-9">
        <div class="row">
        <div class="col-md-6">
        <div class="example-container clearfix">
          <div class="example-chart">
            <div id="bar-chart-example"></div>
            </div>
        </div>
		</div>
        <div class="col-md-6">
        <div class="example-container clearfix">
          <div class="example-chart">
            <div id="bar-chart-sold"></div>
            </div>
        </div>
		</div>
        </div>
        <div class="row">
        <div class="col-md-12 paddT15 pubReports">
        
        <!--	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table-hover table-hover table-bordered tableStyle">
  <tbody>
     <tr>
      <th>Report Title</th>
      <th>Published Date</th>
      <th>Report Type</th>
      <th>Industry</th>
      <th>Update</th>
    </tr>
   <tr>
      <td>Abcd</td>
      <td>28/02/2016</td>
      <td>Healcth Care</td>
      <td>Mdidcal</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td>Abcd</td>
      <td>28/02/2016</td>
      <td>Healcth Care</td>
      <td>Mdidcal</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td>Abcd</td>
      <td>28/02/2016</td>
      <td>Healcth Care</td>
      <td>Mdidcal</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td>Abcd</td>
      <td>28/02/2016</td>
      <td>Healcth Care</td>
      <td>Mdidcal</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td>Abcd</td>
      <td>28/02/2016</td>
      <td>Healcth Care</td>
      <td>Mdidcal</td>
      <td>&nbsp;</td>
    </tr>  
  </tbody>
</table>-->
</div>
<div class="col-md-4">
   <div class = "pagination-pub"></div>
</div>
<div class="col-md-12 paddT15 otherReports">
     
       <!--     	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table-hover table-hover table-bordered tableStyle">
  <tbody>
    <tr>
      <th>Report Title</th>
      <th>Published Date</th>
      <th>Report Type</th>
      <th>Industry</th>
      <th>Update</th>
    </tr>
    <tr>
      <td>Abcd</td>
      <td>28/02/2016</td>
      <td>Healcth Care</td>
      <td>Mdidcal</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td>Abcd</td>
      <td>28/02/2016</td>
      <td>Healcth Care</td>
      <td>Mdidcal</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td>Abcd</td>
      <td>28/02/2016</td>
      <td>Healcth Care</td>
      <td>Mdidcal</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td>Abcd</td>
      <td>28/02/2016</td>
      <td>Healcth Care</td>
      <td>Mdidcal</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td>Abcd</td>
      <td>28/02/2016</td>
      <td>Healcth Care</td>
      <td>Mdidcal</td>
      <td>&nbsp;</td>
    </tr>
  </tbody>
</table>-->
</div>
<div class="col-md-4">
   <div class ="pagination-other"></div>
</div>
        </div>
       </div>
        
      </article>
    </div>
    <script src = "${pageContext.request.contextPath}/js/JqueryBase.min.js"></script>        
	<script src="${pageContext.request.contextPath}/js/charts/example.js"></script>
	<script src="${pageContext.request.contextPath}/js/charts/material-charts.js"></script>
	
	<!-- pagination -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/simplePagination.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/simplePagination.js" ></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/pagenationutil.js" ></script>
	
	<script src="${pageContext.request.contextPath}/js/author/home.js"></script>
	
		
	
    <footer class="container-fluid">
        <div class="container clearfix">
            <div class="links clearfix">
                <div class="col">
                    <h3>Solutions</h3>
                    <a href="">Company Information</a>
                    <a href="">Industry Analysis</a>
                    <a href="">Contact Lists</a>
                    <a href="">IPO Central</a>
                </div>
                <div class="col">
                    <h3>Global Search</h3>
                    <a href="">Build Custom Lists</a>
                    <a href="">Reports - Company</a>
                    <a href="">Reports - Industry</a>
                    <a href="">Subscriptions</a>
                </div>
                <div class="col">
                    <h3>Support</h3>
                    <a href="">Customer Service</a>
                    <a href="">Conctact Us</a>
                </div>
                <div class="col">
                    <h3>Company</h3>
                    <a href="">About Us</a>
                    <a href="">Careers</a>
                    <a href="">Why Report Matters</a>
                </div>
                <div class="col col2">
                    <a href="callto:18001234567" class="ico call">1800.234.5678</a>
                    <a href="mailto:support@reportmatters.com" class="ico mail">support@reportmatters.com</a>
                </div>
            </div>
            <div class="copyrights clearfix">
                <div class="share">
                    <a href="" class="ico icon1">Facebook</a>
                    <a href="" class="ico icon2">Twitter</a>
                    <a href="" class="ico icon3">Linkedin</a>
                    <a href="" class="ico icon4">Youtube</a>
                </div>
                <div class="copy">
                    <div>&copy; Research Floks, 2016. All rights reserved.</div>
                    <a href="">Privacy Policy</a>
                    <a href="">Terms &amp; Conditions</a>
                    <a href="">Sitemap</a>
                    <a href="">Feedback</a>
                </div>
            </div>
        </div>
    </footer> 
   </body>
</html>