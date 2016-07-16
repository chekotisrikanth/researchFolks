 var commentsObj =[];
var getProperty = function (propertyName) {
    return commentsObj[propertyName];
};

$(document).ready(function() {
            $(".open, .impatient").pageslide();
          /*  $(document).on('click', '.cmnt', function(){
        		//alert('ok');
            	//all ajax to get the comments for the report
            	var repId = $(this).attr('rep-id');
            	callAjaxPost("/comments/getComments/"+repId,"chatHistory");
            	appendalertmsg1(repId);
            	$("#popupAlertMsg").modal('show');
            	
        	});*/ 
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
            triggerPagenation('/secure/home/reviewer');
            });

			
 
 
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
			reportsObj.append('reports['+index+'].assignee',$(".rev-"+reportId).val());
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
			
			//reportsObj.append('reports['+index+'].reportFile',$(".file-"+reportId).val());
			//reportsObj.append('reports['+index+'].reportFile',$(".file-"+reportId)[0].files[0]);
			 
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
			   window.location.href = "/secure/home/reviewer/0/10";
			 } else {
			  appendalertmsg();			
			  reslt="Error Occured Please Try Again Message :"+ajaxresp.message ;
			  $("#errorMsgDiv").html(reslt);				
			  $("#popupAlertMsg").modal('show');
			}
		  } else {
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
}/*
function callAjaxPost(url,respDiv) {
	try{
	$("#processingImg1").show();
		 $.ajax({
			  url:url,
		        type: "POST",
		        dataType: 'json', 
		    	beforeSend: function(xhr) {
		    	 	 xhr.setRequestHeader("Accept", "application/json");
		    	 	 xhr.setRequestHeader("Content-Type", "application/json");
		    	}	,	
		 success: function(ajaxresp) {
			 //alert(ajaxresp.name);
			 //console.log(ajaxresp); 
			 $("#processingImg1").hide();
			 if(ajaxresp != null && typeof ajaxresp !== typeof undefined && ajaxresp !== false  ) {
				 //modal-body
				 buildChatHistory(ajaxresp,respDiv);
			  } else {
					console.log("no ");

				 //handleError();
			}	
	     },
		 error: function(request,error) {
			//handleError();
		 }
		 });
	}catch(e) {
			console.log(e);
			// handleError();
		 }
	}
function  buildChatHistory(ajaxresp,divClass) {
	 $("#processingImg1").hide();

	var str='';
	str+='<p class="col-md-12 bg-info text-danger"> <span class="col-md-4"></span> <span class="col-md-6">Comments History</span> </p>';

	$(ajaxresp.reports).each(function(index,object) {
		
		str+='<p class="col-md-12 bg-primary">';
		str+=' <span class="col-md-6">Date : '+object.date+'</span>';
		str+=' <span class="col-md-6">User : '+object.userName+'</span>';        
       str+='</p>';     
       
       str+='<p class="bg-success">'+object.comment;
		str+='</p>';
		if(object.filePath != null && object.filePath.length>2) {
			str+='<a href="#" class="downreportCmnt" rep-id="'+object.cmntId+'" ><img src="/images/icon-download.png" alt="Attachments"/></a>';
		}
		
		

//cmntId
      
     
	});
	$("."+divClass).html(str);
	
}
*/
/*function  buildChatHistory(ajaxresp,divClass) {
	
	var str='';
	str+='<p class="col-md-12 bg-info text-danger"> <span class="col-md-4"></span> <span class="col-md-6">Comments History</span> </p>';

	$(ajaxresp.reports).each(function(index,object) {
		
		str+='<p class="col-md-12 bg-primary">';
		str+=' <span class="col-md-6">Date : '+object.date+'</span>';
		str+=' <span class="col-md-6">User : '+object.userName+'</span>';        
        str+='</p>';     
        
        str+='<p class="bg-success">'+object.comment;
		str+='</p>';

       
      
	});
	$("."+divClass).html(str);
	
}*/