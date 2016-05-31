      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
      <div class="col-md-8 signInHeader marginT20"><h3>Author / Customer Login</h3></div>
       <article class="col-md-10 col-md-offset-1 noPaddRL noBorder">
       
        <div class="col-md-4 marginB20 marginT20 border paddT20">
        <div class=""><h4>Use your Linkedin or Facebook accounts to Login:</h4></div>
        <div style="height:30px;"></div>
        <div class="facebook"><a href="#">Facebook</a></div>
        <div class="linkedin"><a href="#">Linkedin</a></div>
        </div>
        <div class="col-md-6 col-md-offset-1 marginB20 marginT20 border">
        	<div class="col-md-12 paddT20">
      <form class="form-horizontal" action="<c:url value='/j_spring_security_check' />" method='POST'>
           <div class="form-group">&nbsp;</div>
           	<div class="form-group">
           	
           	
            	<div class="col-md-12">
                	<input type="text" name='emailId' class = "form-control" placeholder="Enter User Name/ Email ID" required/>
                </div>
            </div>
            <div class="form-group">
            	<div class="col-md-12">
                	<input type="password" name='password' class = "form-control" placeholder="Enter Password" required/>
                </div>
            </div>
            <div class="form-group">
            	<div class="col-md-12">
                	
                </div>
            </div>
            <div class="form-group">
            	<div class="col-md-4 col-sm-12 noPaddR"><button class="btn btn-primary widthFull pull-left boldTxt">Sign in </button> </div>
            </div>
            <div class="form-group">
            	<div class="col-md-5 col-sm-12 small"><input type="checkbox" class="form-control widthAuto pull-left"/> <span style="padding-left:10px;">Remember Me</span></div>
                <div class="col-md-7 col-sm-12 small"><span>Forgot Password <a href="#" class="red">Click Here</a></span></div>
            </div>
           </form>
            </div>
        </div>

        </article>
       
