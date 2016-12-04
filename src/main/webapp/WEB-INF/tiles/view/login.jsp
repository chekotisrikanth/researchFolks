 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
  <header class="loginheader"></header>
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
    <div id="registerdetails" class="registerdetails">
		<div class="regdetails">
			<div class="reganalyst">
				<div class="imganalyst"><img src="${pageContext.request.contextPath}/images/login/Analyst.png"></div>
				<div class="analystheading"><label class="labelanalyst">Analyst</label></div>
				<div class="analystext"><p>Publish and start selling Research Reports</p>
				<form><input type="checkbox" id="reganalyst" value=""></form>
				</div>
			</div>
			<div class="regcustomer">
			   <div class="imganalyst"><img src="${pageContext.request.contextPath}/images/login/Customer.png"></div>
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
    <footer class="loginfooter"></footer>
</body>
</html>

<script>
	$( function() {
		$( "#registerdetails" ).dialog({
			modal:true,
			autoOpen:false,
			draggable:false,
			resizable:false,
			height:400,
			width:600,
			
		});
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