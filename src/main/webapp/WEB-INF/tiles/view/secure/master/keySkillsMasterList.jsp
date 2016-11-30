<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src = "${pageContext.request.contextPath}/js/JqueryBase.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/master/master.css" type="text/css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/datatables/jquery.dataTables.min.css" type="text/css"/>
<script type="text/javascript" src="/makerm/js/cb/fiscalyear.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/masters.js"></script>

<!-- Grid Scripts -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/master/demo_page.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/master/jquery.dataTables.css" type="text/css" />
<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/js/datatables/jquery.dataTables.js"></script>
<!-- Grid Scripts -->

<table id="keyskills" class="display" width="100%" cellspacing="0">
        <thead>
            <tr>
                <th>First name</th>
                <th>Last name</th>
                <th>Position</th>
                <th>Office</th>
                <th>Start date</th>
                <th>Salary</th>
            </tr>
        </thead>
        <tfoot>
            <tr>
                <th>First name</th>
                <th>Last name</th>
                <th>Position</th>
                <th>Office</th>
                <th>Start date</th>
                <th>Salary</th>
            </tr>
        </tfoot>
    </table>
    
  <script type="text/javascript">
  $(document).ready(function() {
	  var id = jQuery("#masterType").val();
	    $('#keyskills').DataTable( {
	        "processing": true,
	        "serverSide": true,
	        "ajax": "/secure/master/getAllMasters?masterType=0"
	    } );
	} );
 </script>
  
  
  
  
  
  
  
  
  
  
  
  
  
<!--

//-->
</script>  