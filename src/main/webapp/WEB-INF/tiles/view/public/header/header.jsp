<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
 
  	  <script src = "${pageContext.request.contextPath}/js/JqueryBase.min.js"></script>
      <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
      <script src="${pageContext.request.contextPath}/js/jquery.pageslide.min.js"></script>
      <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-theme.css">
       <link rel="stylesheet" href="${pageContext.request.contextPath}/tree/assets/bootstrap/css/bootstrap-theme.min.css">
       <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/customStyles.css">
 <div class="container">       
<head>
      <meta charset = "utf-8">
      <meta http-equiv = "X-UA-Compatible" content = "IE = edge">
      <meta name = "viewport" content = "width = device-width, initial-scale = 1">
      
      <title>Research Floks</title>
      
      <!-- Bootstrap -->
       <link rel="stylesheet" href="${pageContext.request.contextPath}/css/datepicker.min.css">
      
      <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
      <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
      
      <!--[if lt IE 9]>
      <script src = "https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src = "https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
      <![endif]-->
      
      <script type="text/javascript">
            jQuery.noConflict();
        </script>
      
   </head>
   
   <body>
   <div class="row">
   <header class="clearfix paddB10 paddTB10">
     <div class="logo col-md-8 col-sm-12">
     <a href="#"><img src="${pageContext.request.contextPath}/images/logo.png" alt="Research Floks"/></a>
     </div>
     <div class="col-md-4 col-sm-12">
     <sec:authorize access="isAnonymous()">
     	<div class="col-md-6 col-sm-12 noPaddRL">
        <div class="registrationBT col-md-12 col-sm-12">Registration <span>
        <a href="${pageContext.request.contextPath}/public/login.html?referrer=loginlink">
        <img src="${pageContext.request.contextPath}/images/icon-register.png" alt="Registration"/>
        </a>
        </span></div>
        </div>
        <div class="col-md-6 col-sm-12">
        <a href="${pageContext.request.contextPath}/public/login.html?referrer=loginlink">
        <div class="loginBT col-md-12 col-sm-12">Login  <span><img src="${pageContext.request.contextPath}/images/icon-login.png" alt="Login"/></span>
        
        </div>
        </a>
        </div>
       </sec:authorize> 
       <sec:authorize access="isAuthenticated()">
       <a href="<c:url value="${pageContext.request.contextPath}/public/logout.html" />">
        <div class="col-md-6 col-sm-12">
        <div class="logoutBT col-md-12 col-sm-12">Logout  <span><img src="${pageContext.request.contextPath}/images/icon-logout.png" alt="Logout"/></span></div>
        </div>
       </a> 
       </sec:authorize> 
     </div>
     </header>
	  <nav id="myNavbar" class="navbar navbar-default hompageNavbar" role="navigation">
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
                  <li><a href="${pageContext.request.contextPath}/home">Home</a></li>
                  <li><a href="#">How It Works</a></li>
                  <li><a href="${pageContext.request.contextPath}/freefolk/getPublishedReports">Research Store</a></li>
                  <li><a href="${pageContext.request.contextPath}/public/customresearch">Custom Research</a></li>
                  <li><a href="#">Blog</a></li>
                  <li><a href="#">Contact Us</a></li>
                </ul>
            </div><!-- /.navbar-collapse -->
    </nav>
</div>
</div>
<%-- <sec:authorize access="isAnonymous()">
    <form method="POST" action="<c:url value='j_spring_security_check'/>">
        Username: <input name="j_username" type="text" value="${SPRING_SECURITY_LAST_USERNAME}" /> 
        Password: <input name="j_password" type="password" /> 
        <input type="submit" value="Sign in" />
    </form>
    <a href="${pageContext.request.contextPath}/public/login.html?referrer=loginlink">Login</a>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
    <a href="<c:url value="/public/logout.html" />">Logout</a>
</sec:authorize> --%>

