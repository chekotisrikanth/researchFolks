 var commentsObj =[];
var getProperty = function (propertyName) {
    return commentsObj[propertyName];
};

$(document).ready(function() {
            $(".open, .impatient").pageslide();
            $(document).on('click', '.cmnt', function(){
        		//alert('ok');
            	appendalertmsg1($(this).attr('rep-id'));
            	$("#popupAlertMsg").modal('show');
            	
        	}); 
            $(document).on('click', '.uploadDoc', function(){
            	$(this).next().trigger('click');
        	}); 
            $(document).on('click', '.sncButton', function(){
        		var myFormData = getValueUsingClass();
        		//callAjaxForDivId("loginForm", "resp",dataArr);
        		for (var key in myFormData) {
        		    console.log(key, myFormData[key]);
        		    
        		}
        		callAjax(myFormData);
        	});
            $(document).on('click', '.modalHide', function(){
            	var reportId = $(this).attr("rep-id");
            	var textVal = $("#errorMsgDiv").val();
            	console.log(reportId+"==="+textVal);
            	commentsObj[reportId]=textVal ;            	
            	console.log("Rep==="+commentsObj.length);
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

			
 

 function appendalertmsg1(repotId){
 	//console.log(repotId);
 	var str='';
 	
 	str+='<div class="modal fade alerttop" id="popupAlertMsg" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true" style="z-index:99999">';
 	str+='<div class="modal-dialog  ">';
 	str+='<div class="modal-content alertstyle">';
 	str+='<div class="modal-body alignmenttext">';
 	str+='<div>	<textarea  id="errorMsgDiv" class="col-md-12"></textarea></div>';
 	str+='</div>';
 	str+='<div class="modal-footer pad_0 bt">';
 	str+='<div class="row">';
 	str+='<div class="col-md-3 col-md-offset-5 col-xs-4 col-xs-offset-3 col-sm-3 col-sm-offset-5 .mtop-5">';
 	str+='<button type="button" class="btn btn-primary btn-xs modalHide" rep-id='+repotId+' >Save Comment</button>';
 	str+='</div>';
 	str+='</div>';
 	str+='</div>';
 	str+='</div>';
 	str+='</div>';
 	str+='</div>';
 	
 	$("#displayAlertMsg").html(str);
 	 $("#errorMsgDiv").val(getProperty(repotId));
 	
 	//data-dismiss="modal"
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
			reportsObj.append('reports['+index+'].assignee',$(".rev-"+reportId).val());
			var comment = getProperty(reportId);
			
			 if(typeof comment !== typeof undefined && comment !== false ) {
				 reportsObj.append('reports['+index+'].comment',comment);
			 }
			 

			
			//reportsObj.append('reports['+index+'].reportFile',$(".file-"+reportId).val());
			reportsObj.append('reports['+index+'].reportFile',$(".file-"+reportId)[0].files[0]);
			 
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
$("#processingImg1").show();
	 $.ajax({
		  url:'/reviwer/asignReports',
			data: formData,
	        type: "POST",
          processData: false,
			contentType: false,			
	 success: function(ajaxresp) {
		 //alert(ajaxresp.name);
		 //console.log(ajaxresp); 
		 if(ajaxresp != null && typeof ajaxresp !== typeof undefined && ajaxresp !== false && typeof ajaxresp.message !== typeof undefined ) {
			 $("#processingImg1").hide();
			 var reslt;
			  if( ajaxresp.message =="SUCCESS") {				
			   window.location.href = "/secure/home/reviewer/0/10";
			  }else{
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
		handleError();
	 }
	 });
}catch(e) {
		 handleError();
	 }
}
