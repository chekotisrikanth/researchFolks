<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html lang = "en">
   <style>
   .top-margin { margin-top:20px; }
   
   </style>
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
   
   <div class="">
    <aside class="col-md-3 col-sm-12 noPaddL" id="content">
        <h1><a class="open" href="#nav">Menu</a>PageSlide Responsive Demo</h1>
                <div class="col-md-12 noPaddRL">
            
            <ul class="nav nav-list leftNav" id="nav">
                <li><a href="/author/home/authorhome" class="leftNavHeader">Reports <span class="iconL"><img src="${pageContext.request.contextPath}/images/icon-chart.png" alt="chart"/></span></a></li>
                <li><a href="#">Stake</a></li>
                <li><a href="#">Sales</a></li>
                <li class="marginB20"><a href="#">Uploads</a></li>
           
                <li><a href="#" class="leftNavHeader">Profile <span><img src="${pageContext.request.contextPath}/images/icon-profie.png" alt="profile"/></span></a></li>
                <li><a href="#">Edit profile</a></li>
                <li class="marginB20"><a href="#">Change Password</a></li>
               
                <li><a href="#" class="leftNavHeader">On Demond Jobs <span>icon</span></a></li>
                <li><a href="#">Find Work</a></li>
                <li><a href="#">Saved Jobs</a></li>
                <li><a href="#">Invitation</a></li>
            </ul>
            </div>
        </aside>
    <article class="col-md-9 noPaddRL">
     
        <div class="">
        <div class="row">
        <div class="col-md-12">
        <div class="example-container clearfix">
          <div class="example-chart">
            <div id="bar-chart-example"></div>
            </div>
        </div>
		</div>
      <!--    <div class="col-md-6">
        <div class="example-container clearfix">
          <div class="example-chart">
            <div id="bar-chart-sold"></div>
            </div>
        </div>
		</div>-->
        </div>
         <div class="row top-margin">
        <div class="col-md-12 paddT15 repSummary">
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
<div class="col-md-2 pull-right">
        <button class="btn btn-block btn-custom btn-info m_top20  sncButton " type="button"><img id="processingImg1" style="display:none;height:25px;width:25px;margin-right:5px" src="${pageContext.request.contextPath}/images/ajax-loader.gif"/>Submit</button>
  </div>
        </div>
       </div>
        
      </article>
    </div>
    <script src = "${pageContext.request.contextPath}/js/JqueryBase.min.js"></script>      
           <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
      
<%-- <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/charts/chartsStyles.css"/>
	<script src="${pageContext.request.contextPath}/js/charts/material-charts.js"></script>
		<script src="${pageContext.request.contextPath}/js/charts/example.js"></script> --%>
		<script src="${pageContext.request.contextPath}/js/charts/highcharts.js"></script>
		<script src="${pageContext.request.contextPath}/js/charts/highcharsload.js"></script>
	
	<!-- pagination -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/simplePagination.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/simplePagination.js" ></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/pagenationutil.js" ></script>
	
	<script src="${pageContext.request.contextPath}/js/author/home.js"></script>
	      <script type="text/javascript" src="${pageContext.request.contextPath}/js/common/popuputil.js" ></script>
	
		<script src="${pageContext.request.contextPath}/js/utils/chatHistory.js"></script>
	
	
   </body>
     <div id="displayAlertMsg" ></div>
</html>