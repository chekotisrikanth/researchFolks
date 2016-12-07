$(document).ready(function(){
	
	
	initForPagenation();
	$(document).on("click",".sncButton",function() {
		try{
			var dataObject = getJsonOnject();
			var flag = $.isEmptyObject(dataObject);
			console.log(flag);
			console.log(dataObject);
			if(!flag) {
				var reqObject = {};
				reqObject.callAjax = function () {
					callAjaxForDivId(this);
				}
				reqObject.resDiv="tableHeight";
				reqObject.data=dataObject;
				reqObject.task="newPage";
				reqObject.pageNumber=0;
				reqObject.maxResults=$(".recordsPerPage").val();
				callAjaxForDivId(reqObject);
				  triggerAjaxPagination(reqObject);  

			} else {
				initForPagenation();
			}
			
		}catch(e) {
			console.log(e);
		}
		
		
	});
	
});
	
function initForPagenation() {
	var resObject = {};
	resObject.callAjax = function () {
		callAjaxForDivId(this);
	}
	//alert("ok")
	resObject.resDiv="tableHeight";
	var request = {};
	request.catagryId=0;
	request.tittle="";
	resObject.data=request;
	//load intail ajaxCall
	 resObject.pageNumber=0;
	 resObject.task="oldPage";
	 resObject.maxResults=$(".recordsPerPage").val();
	 var totalRecCnt = parseInt($("#totalCount").val());
	 resObject.totalRec=totalRecCnt;
	callAjaxForDivId(resObject);
	triggerAjaxPagination(resObject);  

	//enable pagination
}

function getJsonOnject(){
	
	var reportsObj={};
	$(".search-data").each(function(index,object) {
		var val= $(this).val();
		 if(val != null && typeof val !== typeof undefined && val !== false && val != "") {
			 reportsObj[$(this).attr("name")]=val;
		 }
	});
	return reportsObj;
}

//ajax
function callAjaxForDivId(object) {
	
	console.log(object)
 try{
 //$("#processingImg1").show();
	 $.ajax({
	 url: '/freefolk/getPublishedReports/'+object.pageNumber+'/'+object.maxResults,
	 data: JSON.stringify(object.data),
	 type: "POST",
	 dataType: 'json', 
	 beforeSend: function(xhr) {
	 xhr.setRequestHeader("Accept", "application/json");
	 xhr.setRequestHeader("Content-Type", "application/json");
	 },
	 success: function(ajaxresp) {
		 //alert(ajaxresp.name);
		 //console.log(ajaxresp); 
		// $("#processingImg1").hide();
		 if(ajaxresp != null && typeof ajaxresp !== typeof undefined && ajaxresp !== false) {			
			 console.log(ajaxresp);
			  if(ajaxresp) {
				  if(ajaxresp.length<=0){
					  handleError();
				  }
				  if(object.pageNumber==0){
					  if(object.task==="newPage") {
						  object.totalRec=ajaxresp.totalPages;
					  }
					  triggerAjaxPagination(object); 
				  }
				//console.log(ajaxresp);
				buildResponseDiv(ajaxresp,object.resDiv);
			  }else{
				    appendalertmsg();
				 //  reslt = "Please Enter Valid UserName and Password";
				   reslt="Error Occured Please Try Again Message :"+ajaxresp ;
				  $("#errorMsgDiv").html(reslt);				
				  $("#popupAlertMsg").modal('show');
				 // setTimeout(function(){$("#popupAlertMsg").find('button').trigger('click');},1000); 
			  }
		  } else {
			 handleError();
		}	
      },
	 error: function(request,error) { 	
		handleError();
	 }
	 });
 }catch(e) {
	 console.log(e);
		 handleError();
	 }
}


/*function buildResponseDiv(ajaxresp,div) {
	var str='';
	str+='<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table table-striped table-bordered table-responsive tableStyle">';
	str+='	<tbody>';
	str+='		<tr>';
	str+='			<th>Company Title</th>';
	str+='			<th width="15%">Author</th>';
	str+='			<th width="15%">Industry</th>';
	str+='			<th width="15%">Country</th>';
	str+='			<th width="10%">View Report</th>';
	str+='		</tr>';
	$(ajaxresp.reports).each(function(index,report) {
		str+='		<tr>';
		str+='			<td><a href="#">'+report.reportTitle+'</a></td>';
		$(report.reportStatuses).each(function(index,reportStatuses) {
			//.user.firstName
			str+='			<td>'+reportStatuses.user.firstName+'</td>';
		});
		
		
		str+='			<td>'+report.industry+'</td>';
		str+='			<td>'+report.country+'</td>';
		str+='			<td><a href="#" class="downreport" rep-id="'+report.reportId+'"><img src="images/icon_viewProfile.png" alt="Profile" /></a></td>';
		str+='		</tr>';
	});
//				            <td><a href="#" class="downreport" rep-id="${report.reportId}"><img src="${pageContext.request.contextPath}/images/icon-download.png" alt="Edit"/></a></td>


	str+='	<tbody>';

	str+='</table>';
	
	$("."+div).html(str);
	
}*/


function buildResponseDiv(ajaxresp,div) {
	var str='';
	str+='<table width="100%" id="myTable" border="0" cellspacing="0" cellpadding="0" class="table table-striped table-bordered table-responsive tableStyle data display datatable">';
	str+='	<thead>';
	str+='		<tr>';
	str+='			<th>Company Title</th>';
	str+='			<th width="15%">Author</th>';
	str+='			<th width="15%">Industry</th>';
	str+='			<th width="15%">Country</th>';
	str+='			<th width="10%">Company Intelligence </th>';
	str+='			<th width="10%">View Report</th>';
	
	str+='		</tr>';
	str+='	</thead>';
	str+='	<tbody>';
	$(ajaxresp.reportsList).each(function(index,report) {
		str+='		<tr>';
		str+='			<td><a href="#">'+report.reportTitle+'</a></td>';
		str+='			<td>'+report.userName+'</td>';
		str+='			<td>'+report.industry+'</td>';
		str+='			<td>'+report.country+'</td>';
		str+='			<td>'+report.comIntlString+'</td>';
		str+='			<td><a href="/public/getReport/'+report.reportId+'" class="downreport" rep-id="'+report.reportId+'"><img src='+contextPath+'/images/icon_viewProfile.png alt="view report" /></a></td>';
		str+='		</tr>';
	});
//				            <td><a href="#" class="downreport" rep-id="${report.reportId}"><img src="${pageContext.request.contextPath}/images/icon-download.png" alt="Edit"/></a></td>


	str+='	<tbody>';

	str+='</table>';
	
	$("."+div).html(str);
$('#myTable').DataTable({
		"bPaginate": false,
	    "bLengthChange": false
}
	    );
    

}
