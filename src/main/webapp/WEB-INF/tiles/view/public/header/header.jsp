<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Login Page</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
	<link href="${pageContext.request.contextPath}/css/jquery/jquery-ui.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/tree/assets/jquery-1.10.2.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery/jquery-ui.min.js"></script>

</head>
<body>
   <!-- start header -->
  <header>
    <div class="business content visible-desktop hidden-tablet " style="width: 100%; top: 0px;">
        <div class=" clearfix">
            <div class="info-container">
                <span class="item email">
                    <span class="icon icon-Mail"><a href="#"><img src="${pageContext.request.contextPath}/images/login/mailicon.png"></a></span>
                    <span class="email-content">sales@researchfolks.com</span>
                </span>
            </div>
            <div class="social icon">
                <span data-social="facebook"><a href="#"><img src="${pageContext.request.contextPath}/images/login/facebook.png"></a></span>
                <span data-social="twitter"><a href="#"><img src="${pageContext.request.contextPath}/images/login/twitter.png"></a></span>
                <span data-social="linkedin"><a href="#"><img src="${pageContext.request.contextPath}/images/login/linkedin.png"></a></span>
            </div>
        </div>
    </div>
   
    <nav class="navbar navbar-default navbar-static-top">
          <div class="container-fluid">
           <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
          <a class="navbar-brand" href="index.html"><img src="${pageContext.request.contextPath}/images/login/ResearchFolks-color-WEB.png" width="250" height="53"/></a> </div>
           
            <div class="navbar-collapse collapse ">
                <ul class="nav navbar-nav">
                    <li class="navmenu"><a href="#">Home</a></li>
                    <li class="navmenu"><a href="${pageContext.request.contextPath}/public/customresearch">Customer Research</a></li>
                    <li class="navmenu"><a href="${pageContext.request.contextPath}/freefolk/getPublishedReports">Research Store</a></li>
                    <li class="navmenu"><a href="#">About Us</a></li>
                    <li class="navmenu"><a href="#">Subscribe</a></li>
                    <li class="navmenu"><a href="#">Blog</a></li>
                    <li class="navmenu"><a href="#">Contact</a></li>
                   <sec:authorize access="isAnonymous()">
                    <li class="navmenu"><a href="${pageContext.request.contextPath}/public/login.html">Login/Register</a></li>
					 </sec:authorize> 
					  <sec:authorize access="isAuthenticated()">
					    <li class="navmenu"><a href="${pageContext.request.contextPath}/public/logout.html">Logout</a></li>
					   </sec:authorize> 
                </ul>
			  </div>
           </div>  
    </nav>
    </header>
    </body>
    </html>