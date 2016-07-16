<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang = "en">
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

        <script type="text/javascript">
        	try{
        		//jQuery.noConflict();	
        	}catch(e) {
        		console.log(e);
        	}
            
        </script>
        </head>

        <body>
<div class="container-fluid">
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
         <!--    <div class="col-md-2">
                      <button class="btn btn-primary pull-left marginL10" type="submit">Advanced Search</button>
                    </div> --> 
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
 <script src = "${pageContext.request.contextPath}/js/JqueryBase.min.js"></script>  	  
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) --> 
<!-- Include all compiled plugins (below), or include individual files as needed --> 
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script> 
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
           // $(".open, .impatient").pageslide();
            
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