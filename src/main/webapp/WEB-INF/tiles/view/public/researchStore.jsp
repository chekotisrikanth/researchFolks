<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang = "en">
        <head>
        <meta charset = "utf-8">
        <meta http-equiv = "X-UA-Compatible" content = "IE = edge">
        <meta name = "viewport" content = "width = device-width, initial-scale = 1">
        <title>Research Floks</title>
		<style>
		div .open{
		 display: block;
		 text-indent: 0px;
		}
		
		table.dataTable thead .sorting { background: url('${pageContext.request.contextPath}/images/sort_both.png') no-repeat center right; }
table.dataTable thead .sorting_asc { background: url('${pageContext.request.contextPath}/images/sort_asc.png') no-repeat center right; }
table.dataTable thead .sorting_desc { background: url('${pageContext.request.contextPath}/images/sort_desc.png') no-repeat center right; }

table.dataTable thead .sorting_asc_disabled { background: url('${pageContext.request.contextPath}/images/sort_asc_disabled.png') no-repeat center right; }
table.dataTable thead .sorting_desc_disabled { background: url('${pageContext.request.contextPath}/images/sort_desc_disabled.png') no-repeat center right; }
		</style>
        <!-- Bootstrap -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-theme.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/customStyles.css">

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->

        <!--[if lt IE 9]>
      <script src = "https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src = "https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
      <![endif]-->

        <script type="text/javascript">
        	try{
        		jQuery.noConflict();	
        	}catch(e) {
        		
        	}
            
        </script>
        </head>

        <body>
<div class="container-fluid">
          <header class="clearfix paddB10 paddTB10">
    <div class="logo col-md-7 col-sm-12"> <a href="#"><img src="images/logo1.jpg" alt="Research Floks"/></a> </div>
    <div class="col-md-4 col-sm-12">
              <div class="col-md-6 col-sm-12 noPaddRL">
        <div class="registrationBT col-md-12 col-sm-12">Registration <span><img src="images/icon-register.png" alt="Registration"/></span></div>
      </div>
              <div class="col-md-6 col-sm-12">
        <div class="loginBT col-md-12 col-sm-12">Login <span><img src="images/icon-login.png" alt="Login"/></span></div>
      </div>
            </div>
  </header>
          <section>
    <nav id="myNavbar" class="navbar navbar-default hompageNavbar" role="navigation"> 
              <!-- Brand and toggle get grouped for better mobile display -->
              <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
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
      </div>
              <!-- /.navbar-collapse --> 
            </nav>
  </section>
   <section>
    <article class="col-md-12 noPaddRL">
              <div class="contentWraper marginB20">
        <form class="form-horizontal alignHCenter ">
                  <div class="form-group">
            <div class="col-md-2 boldTxt text-right"> Research Category</div>
            <div class="col-md-4">
               <select class="form-control search-data resType" name="catagryId">
                <option value="">Select Category</option>
                <option value=1>Company Intellegence</option>
                <option value=2>Industry Intellegence</option>
                <option value=3>Others</option>
              </select>
                    </div>
            <div class="col-md-1 boldTxt text-right">Display No Of Records</div>
            <!-- <div class="col-md-3">
                <select class="form-control search-data"  name="comIntl">
                  <option value="">Select SoryType</option>                
	                <option value=1>Classic Report</option>
	                <option value=2>Report Database</option>
	            </select>
            </div> -->
            <div class="col-md-3">
                    <select class="form-control  recordsPerPage">
                    	<option value=10>10</option>
                        <option value=50>50</option>
                        <option value=100>100</option>
                        <option value=5000>All</option>
                    </select>
                    </div>
          <!--  <div class="col-md-3 industry">
                <select class="form-control search-data" name="comIntl">
                 <option value="">Select SoryType</option>
	                <option value=3>Industry Report</option>
	                <option value=4>Industry Database</option>
              </select>
            </div>
            <div class="col-md-3 others">
              <select class="form-control search-data" name="comIntl">
                <option value="">Select SoryType</option>              
                <option value=4>Research Report</option>
                <option value=5>Research Database</option>
              </select>
            </div> -->  
            <div class="col-md-1 noPaddL">
                <button class="btn btn-primary buttonSmall sncButton pull-left" type=button>Search</button>
            </div>
          </div>
                  <div class="form-group">
            <div class="col-md-2 boldTxt text-right"> Search By Title </div>
            <div class="col-md-3"><input type="text" class="form-control search-data" name="tittle"></div>
            <div class="col-md-2 boldTxt text-right"> Search By Industry </div>
            <div class="col-md-2"> <!-- class="form-control search-data"  -->
              <select  id="example-filterBehavior" class="form-control search-data" name="industry" multiple="multiple">
<!--               	<option value="">Select Industry</option>
 -->                 <c:forEach var="item" items="${industries}">					 
						 <option value="${item.text}">${item.text}</option>
				</c:forEach>
                <!--     <option value="Retail" >Retail</option>
                <option value="Automotive">Automotive</option>  -->
              </select>
                    </div>
            <div class="col-md-2">
                      <button class="btn btn-primary pull-left marginL10" type="submit">Advanced Search</button>
                    </div>
          </div>
                  <div class="row analystSer marginT20">
                  
            <div class="col-md-12">
	            <input type="hidden" id="totalCount" name="totalCount" value="${totalCount}">
	            <div class="tableHeight">
	             </div>
             </div>
                    <div class="col-md-12">
                   <!--   <div class="col-md-4"><span class="pull-left marginB20 marginT20">Display Number of Records</span> 
                    <select class="form-control widthAuto marginL10 pull-left marginB20 marginT20 recordsPerPage">
                    	<option value=1>10</option>
                        <option value=50>50</option>
                        <option value=100>100</option>
                        <option value=5000>All</option>
                    </select>
                    </div> -->
                  	<div class="col-md-4">
                  		<div class = "pagination"/>
						   
		<div class="col-md-4"> <span class="marginB20 marginT20 pull-right">Displaying 10 out of 250</span></div>
                  </div>
          </div>
                </form>
      </div>
            </article>
    <div class="col-md-2"></div>
  </section>
</div>
<footer class="container-fluid">
          <div class="container clearfix">
    <div class="links clearfix">
              <div class="col">
        <h3>Solutions</h3>
        <a href="">Company Information</a> <a href="">Industry Analysis</a> <a href="">Contact Lists</a> <a href="">IPO Central</a> </div>
              <div class="col">
        <h3>Global Search</h3>
        <a href="">Build Custom Lists</a> <a href="">Reports - Company</a> <a href="">Reports - Industry</a> <a href="">Subscriptions</a> </div>
              <div class="col">
        <h3>Support</h3>
        <a href="">Customer Service</a> <a href="">Conctact Us</a> </div>
              <div class="col">
        <h3>Company</h3>
        <a href="">About Us</a> <a href="">Careers</a> <a href="">Why Report Matters</a> </div>
              <div class="col col2"> <a href="callto:18001234567" class="ico call">1800.234.5678</a> <a href="mailto:support@reportmatters.com" class="ico mail">support@reportmatters.com</a> </div>
            </div>
    <div class="copyrights clearfix">
              <div class="share"> <a href="" class="ico icon1">Facebook</a> <a href="" class="ico icon2">Twitter</a> <a href="" class="ico icon3">Linkedin</a> <a href="" class="ico icon4">Youtube</a> </div>
              <div class="copy">
        <div>&copy; Research Floks, 2016. All rights reserved.</div>
        <a href="">Privacy Policy</a> <a href="">Terms &amp; Conditions</a> <a href="">Sitemap</a> <a href="">Feedback</a> </div>
            </div>
  </div>
        </footer>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) --> 
<script src = "${pageContext.request.contextPath}/js/JqueryBase.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed --> 
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script> 
<script src="${pageContext.request.contextPath}/js/jquery.pageslide.min.js"></script>
<!-- multi select -->
<!-- Include the plugin's CSS and JS: -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-multiselect.css" type="text/css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/multiselect/bootstrap-multiselect.js"></script>
<!-- pagination -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/simplePagination.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/simplePagination.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/pagenationutil.js" ></script>
<!-- data tables -->
<script type="text/javascript" src="${pageContext.request.contextPath}/css/datatables/jquery.dataTables.min.css" ></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/datatables/jquery.dataTables.min.js" ></script>

<!-- js -->
<script src="${pageContext.request.contextPath}/js/public/researchStore.js"></script>

<script>
        $(document).ready(function() {
            $(".open, .impatient").pageslide();
            
            $('#example-filterBehavior').multiselect({
		            enableFiltering: true,
		            filterBehavior: 'value'
		   });
            
            
        });
       
    </script> 
<script type="text/javascript">
function hideAll() {	
	 $('.industry').hide();
	 $('.others').hide();
	 $('.company').hide();
}

$(document).ready(function(){
	hideAll();
	$('.resType').on('change',function(){
    if($(this).val()==3){
        $('.industry').hide();
		$('.company').hide();
		$('.others').show();
    } else 	if($(this).val()==1){
        $('.company').show();
		$('.others').hide();
		 $('.industry').hide();
    }else 	if($(this).val()==2){
        $('.industry').show();
		$('.company').hide();
		$('.others').hide();
    } else  {
    	hideAll();
    }
    
});

});
</script>
</body>
</html>