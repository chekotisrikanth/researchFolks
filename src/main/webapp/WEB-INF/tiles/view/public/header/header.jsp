<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
 
  	  <script src = "${pageContext.request.contextPath}/js/JqueryBase.min.js"></script>
      <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
      <script src="${pageContext.request.contextPath}/js/jquery.pageslide.min.js"></script>
      <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-theme.css">
       <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css">
       <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/customStyles.css">
<header class="clearfix paddB10 paddTB10">
     <div class="logo col-md-7 col-sm-12">
     <a href="#"><img src="/images/logo1.jpg" alt="Research Floks"/></a>
     </div>
     <div class="col-md-4 col-sm-12">
     	<div class="col-md-6 col-sm-12 noPaddRL">
        <div class="registrationBT col-md-12 col-sm-12">Registration <span><img src="/images/icon-register.png" alt="Registration"/></span></div>
        </div>
        <div class="col-md-6 col-sm-12">
        <div class="loginBT col-md-12 col-sm-12">Login  <span><img src="/images/icon-login.png" alt="Login"/></span></div>
        </div>
     </div>
     </header>
    <section>
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
                  <li><a href="#">Home</a></li>
                  <li><a href="#">How It Works</a></li>
                  <li><a href="#">Research Store</a></li>
                  <li><a href="#">Custom Research</a></li>
                  <li><a href="#">Blog</a></li>
                  <li><a href="#">Contact Us</a></li>
                </ul>
            </div><!-- /.navbar-collapse -->
    </nav>
      </section>

<sec:authorize access="isAnonymous()">
   <%--  <form method="POST" action="<c:url value='j_spring_security_check'/>">
        Username: <input name="j_username" type="text" value="${SPRING_SECURITY_LAST_USERNAME}" /> 
        Password: <input name="j_password" type="password" /> 
        <input type="submit" value="Sign in" />
    </form> --%>
    <a href="/public/login.html?referrer=loginlink">Login</a>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
    <a href="<c:url value="/public/logout.html" />">Logout</a>
</sec:authorize>

