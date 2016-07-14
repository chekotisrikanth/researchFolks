$(document).ready(function(){
	
	  $(document).on('click', '.uploadDoc', function(){
      	$(this).next().trigger('click');
  	}); 
      $(document).on('click', '.sncButton', function(){
  		var myFormData = getValueUsingClass();
  		//callAjaxForDivId("loginForm", "resp",dataArr);
  		
  		callAjax(myFormData);
  	});
      $(document).on('click', '.modalHide', function(){
      	var reportId = $(this).attr("rep-id");
      	var textVal = $("#errorMsgDiv").val();
      	//console.log(reportId+"==="+textVal);
      	commentsObj[reportId]=textVal ;            	
      	//console.log("Rep==="+commentsObj.length);
      	$("#popupAlertMsg").modal('hide');
      	//$(".cmnt-"+$(this).attr("rep-id")).append();
      	//data-dismiss="modal"
  	}); 
      $(document).on('click', '.downreport', function(){
      	var reportId=parseInt($(this).attr("rep-id"));
      		//window.location = '/downloadReport/'+reportId;
      	
      	WindowObjectReference = window.open("/downloadReport/"+reportId, "Report_WindowName",
      	"menubar=yes,location=yes,resizable=yes,scrollbars=yes,status=yes");
      	});
      
	initForPagenation("pagination-pub","pubReports","pubReports");
	initForPagenation("pagination-other","otherReports","otherReports");	
	
	callForAuthorGraphs();
	callSummaryTable();
	
});


function callForAuthorGraphs() {		
	//ajax call for charts
	var reqObje={};
	reqObje.url='/author/home/authorhome/getPublishedRecordsCount/'+2016;
	reqObje.buildResponse=function(ajaxresp) {
	  console.log(ajaxresp);
	  loadPubReportsGraph(ajaxresp.publishedChartsData,2016);
     }
	
	callAjaxForTable(reqObje);
}

function callSummaryTable() {
//ajax call for summaryTable
	
	var reqObj={};
	reqObj.url='/author/home/authorhome/getReportsSummary';
	reqObj.respDiv="repSummary";
	reqObj.tittle="Reports Summary";

	reqObj.buildResponse=function(resp) {
		console.log(resp);
		buildSummaryTable(resp,this);
	 }	
	callAjaxForTable(reqObj);
}

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
//ajax call for to load published reports graph for author
function callAjaxForTable(reqObj) {
	
 try{
 //$("#processingImg1").show();
	 $.ajax({
	 url: reqObj.url,
	 //data: JSON.stringify(object.data),
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
				/*  if(ajaxresp.length<=0){
					  handleError();
				  }else {
					  console.log(ajaxresp.publishedChartsData)

					  console.log(ajaxresp.publishedChartsData[year])
					  loadPubReportsGraph(ajaxresp.publishedChartsData,year);
				  }
				  */
				  reqObj.buildResponse(ajaxresp);
				  
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
	if(reqObj.task==="otherReports") {
		str+='			<th width="10%">Download/Upload</th>';
		str+='			<th width="10%">Comments</th>';
		str+='			<th width="10%">Update</th>';
	}

	str+='		</tr>';
	$(reportsList).each(function(index,report) {
		str+='		<tr>';
		str+='			<td><a href="#">'+report.reportTitle+'</a></td>';
		str+='			<td>'+report.publishingDate+'</td>';
		str+='			<td>'+report.comIntlString+'</td>';
		str+='			<td>'+report.industry+'</td>';
		//str+='			<td><a href="#" class="downreport" rep-id="'+report.reportId+'"><img src="/images/icon_viewProfile.png" alt="Profile" /></a></td>';
		if(reqObj.task==="otherReports") {
			str+=' <td><a href="#" class="downreport" rep-id="'+report.reportId+'"><img src="/images/icon-download.png" alt="Edit"/></a>';
			str+='  <a href="#" class="uploadDoc"><img src="/images/icon-upload.png" alt="Upload"/></a>';
			str+='	<input type="file"  class="fileUp file-'+report.reportId+'" name ="report" style="display:none;" />';
			str+='  </td>';
			str+=' <td><a href="#" class="cmnt cmnt-'+report.reportId+'" rep-id="'+report.reportId+'" ><img src="/images/comment.png" alt="Upload"/>';
			if(report.haveComments=="Y") {
				str+='<span class="badge btn btn-primary">'+report.comntCnt+'</span>';
			}
			
			str+='</a></td>';
			str+=' <td>  <input type="checkbox" class="chk" value="true" rep-id="'+report.reportId+'"/></td>';

		}
		str+='		</tr>';
	});
//				            <td><a href="#" class="downreport" rep-id="${report.reportId}"><img src="${pageContext.request.contextPath}/images/icon-download.png" alt="Edit"/></a></td>


	str+='	<tbody>';

	str+='</table>';
	
	$("."+div).html(str);
	
}


function buildSummaryTable(reportsList,reqObj) {
	var str='';
	str+='<h4>'+reqObj.tittle+'</h4>';

	str+='<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table-hover table-hover table-bordered tableStyle">';
	str+='	<tbody>';
	str+='		<tr>';
	str+='			<th>Report</th>';
	str+='			<th width="15%">Count</th>';
	str+='		</tr>';
	
	for(var i in reportsList) {
		str+='		<tr>';
		str+='			<td>'+i+'</td>';
		str+='			<td>'+reportsList[i]+'</td>';
		str+='		</tr>';	
	}
	str+='	<tbody>';

	str+='</table>';
	
	$("."+reqObj.respDiv).html(str);
	
}
function getValueUsingClass(){
	/* declare an checkbox array */
	var chkArray = [];
	var reportsArrObj = [];
	
	var reportsObj = new FormData();
	var cnt =0;
	/* look for all checkboes that have a class 'chk' attached to it and check if it was checked */
	$(".chk:checked").each(function(index) {
		var reportId = parseInt($(this).attr("rep-id"));
		reportsObj.append('reports['+index+'].reportId',reportId);			
		var comment = getProperty(reportId);
		
		 if(typeof comment !== typeof undefined && comment !== false ) {
			 reportsObj.append('reports['+index+'].comment',comment);
		 }
		 
		 $($(".file-"+reportId)).each(function(index1,object1){
			 if(typeof this.files[0] !== typeof undefined  ) {
				//reportsObj.append('reports['+index+'].reportFile',$(".file-"+reportId).val());
					reportsObj.append('reports['+index+'].reportFile',this.files[0]);
					 
			 }
		 });
		
		
		cnt++;
		
	});
	/* check if there is selected checkboxes, by default the length is 1 as it contains one single comma */
	if(cnt >= 1){
		console.log("You have selected " + reportsObj);	
	}else{
		alert("Please at least one of the checkbox");	
	}
	
	return reportsObj;
}

//ajax
function callAjax(formData) {
try{
//$("#processingImg1").show();
 $.ajax({
	  url:'/reviwer/asignReports',
		data: formData,
        type: "POST", 	        
        processData: false,
        contentType: false,			
    	success: function(ajaxresp) {
    	if(ajaxresp != null && typeof ajaxresp !== typeof undefined && ajaxresp !== false && typeof ajaxresp.message !== typeof undefined ) {
		 $("#processingImg1").hide();
		 var reslt;
		 if( ajaxresp.message =="SUCCESS") {				
		   console.log("refresh");
		   commentsObj = [];
		 } else {
		  appendalertmsg();			
		  reslt="Error Occured Please Try Again Message :"+ajaxresp.message ;
		  $("#errorMsgDiv").html(reslt);				
		  $("#popupAlertMsg").modal('show');
		}
	  } else {
			 $("#processingImg1").hide();

		 handleError();
	}	
 },
 error: function(request,error) { 	
	 console.log("err");
	 handleError();
	
 }
 });
} catch(e) {

console.log(e);

	 handleError();
 }
}