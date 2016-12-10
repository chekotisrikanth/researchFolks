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
                    <li class="navmenu"><a href="#">Customer Research</a></li>
                    <li class="navmenu"><a href="#">Research Store</a></li>
                    <li class="navmenu"><a href="#">About Us</a></li>
                    <li class="navmenu"><a href="#">Subscribe</a></li>
                    <li class="navmenu"><a href="#">Blog</a></li>
                    <li class="navmenu"><a href="#">Contact</a></li>
                   <sec:authorize access="isAnonymous()">
                    <li class="navmenu"><a href="#">Login/Register</a></li>
					 </sec:authorize> 
					  <sec:authorize access="isAuthenticated()">
					    <li class="navmenu"><a href="#">Logout</a></li>
					   </sec:authorize> 
                </ul>
			  </div>
           </div>  
    </nav>
    </header>
  <!-- end header -->
  <div class="modal-dialog">
        <div class="loginmodal-container">
            <h1>Login to Your Account</h1><br>
           <form action="<c:url value='/j_spring_security_check' />" method='POST'>
            <input type="text" name="emailId" placeholder="Username">
            <input type="password" name="password" placeholder="Password">
            <input type="submit" name="login" class="login loginmodal-submit" value="Login">
          </form>

          <div class="login-help">
            <div class="newuser" ><a id="newUser" href="#" >New User?</a></div> 
              <div class="forgotpass"><a href="#">Forgot Password</a></div>
          </div>
        
          <div class="staysignin">
            <div class="signin"><form> Stay Sign In <input type="checkbox" name="vehicle" value="Bike"></form></div>   
          </div>  
        </div>
   </div>
    <div id="registerdetails" class="registerdetails" style="display:none;">
		<div class="regdetails">
			<div class="reganalyst">
				<div class="imganalyst"><img src="${pageContext.request.contextPath}/images/login/Analyst.png"></div>
				<div class="analystheading"><label class="labelanalyst">Analyst</label></div>
				<div class="analystext"><p>Publish and start selling Research Reports</p>
				<form><input type="checkbox" id="reganalyst" value=""></form>
				</div>
			</div>
			<div class="regcustomer">
			   <div class="imganalyst"><img src="${pageContext.request.contextPath}/images/login/customer.png"></div>
				<div class="analystheading"><label class="labelcustomer">Customer</label></div>
				<div class="analystext"><p>Explore and Buy Research Reports</p>
					<form><input type="checkbox" id="regcustomer" value=""></form> 
				</div>
			</div>
	   </div> 
	    <div class="registersubmit">
            <input type="button" value="Submit" id="submitBtn" class="submitbtn">
        </div>
    </div> 
    
    <footer class="loginfooter">
    <div class="logorights">Copyright © ResearchFolks.com 2016 All rights reserved</div>
    <div class="footericon">
        <span data-social="facebook"><a href="#"><img src="${pageContext.request.contextPath}/images/login/footerfb.png"></a></span>
        <span data-social="twitter"><a href="#"><img src="${pageContext.request.contextPath}/images/login/footerftwitter.png"></a></span>
        <span data-social="linkedin"><a href="#"><img src="${pageContext.request.contextPath}/images/login/footerlinkedin.png"></a></span>
    </div>
    </footer>
</body>
</html>

<script>
	$( function() {
		$( "#registerdetails" ).dialog({
    width: 'auto', // overcomes width:'auto' and maxWidth bug
    maxWidth: 600,
    height: 'auto',
    modal: true,
    fluid: true, //new option
    resizable: false,
			autoOpen:false
			
});


// on window resize run function
$(window).resize(function () {
    fluidDialog();
});

// catch dialog if opened within a viewport smaller than the dialog width
$(document).on("dialogopen", ".ui-dialog", function (event, ui) {
    fluidDialog();
});

function fluidDialog() {
    var $visible = $(".ui-dialog:visible");
    // each open dialog
    $visible.each(function () {
        var $this = $(this);
        var dialog = $this.find(".ui-dialog-content").data("ui-dialog");
        // if fluid option == true
        if (dialog.options.fluid) {
            var wWidth = $(window).width();
            // check window width against dialog width
            if (wWidth < (parseInt(dialog.options.maxWidth) + 50))  {
                // keep dialog from filling entire screen
                $this.css("max-width", "90%");
            } else {
                // fix maxWidth bug
                $this.css("max-width", dialog.options.maxWidth + "px");
            }
            //reposition dialog
            dialog.option("position", dialog.options.position);
        }
    });

}
		$('#newUser').click(function(){
			$( "#registerdetails" ).dialog('open');
			$(".ui-dialog-titlebar").hide();
		});
		$('#regcustomer').onchange=(function(){
			$( "#reganalyst" ).disabled = true;
		});
		$('#submitBtn').click(function(){
			if ($('#regcustomer').is(":checked"))
			{
				window.location.href='${pageContext.request.contextPath}/public/customer_create.html'
			}else if ($('#reganalyst').is(":checked"))
			{
				window.location.href='${pageContext.request.contextPath}/public/author_create.html'
			}
		});
					
	} );
</script>
