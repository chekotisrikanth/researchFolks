$(document).ready(function(){
	
	
	initForPagenation("pagination-pub","pubReports","pubReports");
	initForPagenation("pagination-other","otherReports","otherReports");
	
});
	
function initForPagenation(paginatioDiv,respDiv,task) {
	var resObject = {};
	resObject.callAjax = function () {
		callAjaxForDivId(this);
	}
	
	//alert("ok")
	resObject.resDiv=respDiv;
	resObject.paginatioDiv=paginatioDiv;
	var request = {};
	
	resObject.data=request;
	//load intail ajaxCall
	 resObject.pageNumber=0;
	 resObject.task=task;
	 resObject.maxResults=10;
	 callAjaxForDivId(resObject);
	 //triggerAjaxPagination(resObject);  
	 loadAjaxPagination(resObject);
	 
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
	 url: '/author/home/authorhome/'+object.pageNumber+'/'+object.maxResults+'/'+object.task  ,
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
				
				  if(object.task==="pubReports") {
					  if(object.pageNumber==0){
						  object.totalRec=ajaxresp.pubRepCount;
						  //triggerAjaxPagination(resObject);
					  }
					  object.tittle="Published Reports List";
					  buildResponseDiv(ajaxresp.pulishedReports,object.resDiv,object);
				  } else if(object.task==="otherReports") {
					  if(object.pageNumber==0){
						  object.totalRec=ajaxresp.otherrepCount;
						 // triggerAjaxPagination(resObject);
						  
					  }		
					  object.tittle="On Demond Research Work";
					  buildResponseDiv(ajaxresp.repList,object.resDiv,object);
				  }
					  
					//  triggerAjaxPagination(object); 
				  
				//console.log(ajaxresp);
				
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
function buildResponseDiv(reportsList,div,reqObj) {
	var str='';
	str+='<h4>'+reqObj.tittle+'</h4>';

	str+='<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table-hover table-hover table-bordered tableStyle">';
	str+='	<tbody>';
	str+='		<tr>';
	str+='			<th>Report Title</th>';
	str+='			<th width="15%">Published Date</th>';
	str+='			<th width="15%">Report Type</th>';
	str+='			<th width="15%">Industry</th>';
	str+='			<th width="10%">Update</th>';
	str+='		</tr>';
	$(reportsList).each(function(index,report) {
		str+='		<tr>';
		str+='			<td><a href="#">'+report.reportTitle+'</a></td>';
		str+='			<td>'+report.publishingDate+'</td>';
		str+='			<td>'+report.comIntl+'</td>';
		str+='			<td>'+report.industry+'</td>';
		str+='			<td><a href="#" class="downreport" rep-id="'+report.reportId+'"><img src="images/icon_viewProfile.png" alt="Profile" /></a></td>';
		str+='		</tr>';
	});
//				            <td><a href="#" class="downreport" rep-id="${report.reportId}"><img src="${pageContext.request.contextPath}/images/icon-download.png" alt="Edit"/></a></td>


	str+='	<tbody>';

	str+='</table>';
	
	$("."+div).html(str);
	
}
