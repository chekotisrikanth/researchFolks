 var commentsObj =[];
var getProperty = function (propertyName) {
    return commentsObj[propertyName];
}

$(document).ready(function() {
    $(".open, .impatient").pageslide();
   
    
    $(document).on('click', '.sncButton', function(){
		var myFormData = getValueUsingClass();
		//callAjaxForDivId("loginForm", "resp",dataArr);
		
		callAjax(myFormData);
	}); 
    triggerPagenation('/secure/home/publisher');
});

 function getValueUsingClass(){
		/* declare an checkbox array */
		
		var reportsArrObj = [];	
		
		/* look for all checkboes that have a class 'chk' attached to it and check if it was checked */
		$(".chk:checked").each(function() {			
			reportsArrObj.push(parseInt($(this).attr("rep-id")));
			//console.log(reportsObj);
		});
		/* check if there is selected checkboxes, by default the length is 1 as it contains one single comma */
		if(reportsArrObj.length < 1){		
			alert("Please at least one of the checkbox");	
		}
		
		return reportsArrObj;
	}
 //appendalertmsg();
 function appendalertmsg(){
 	
 	var str='';
 	
 	str+='<div class="modal fade alerttop" id="popupAlertMsg" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true" style="z-index:99999">';
 	str+='<div class="modal-dialog  modal-sm">';
 	str+='<div class="modal-content alertstyle">';
 	str+='<div class="modal-body alignmenttext">';
 	str+='<div>	<h5 class="text-center" id="errorMsgDiv"></h5></div>';
 	str+='</div>';
 	str+='<div class="modal-footer pad_0 bt">';
 	str+='<div class="row">';
 	str+='<div class="col-md-3 col-md-offset-5 col-xs-4 col-xs-offset-3 col-sm-3 col-sm-offset-5 .mtop-5">';
 	str+='<button type="button" class="btn btn-primary btn-xs" data-dismiss="modal">Close</button>';
 	str+='</div>';
 	str+='</div>';
 	str+='</div>';
 	str+='</div>';
 	str+='</div>';
 	str+='</div>';
 	
 	$("#displayAlertMsg").html(str)
 }
 //ajax
 function callAjax(json) {
  try{
  $("#processingImg1").show();
 	 $.ajax({
 	 url: '/publisher/asignReports',
 	 data: JSON.stringify(json),
 	 type: "POST",
 	 dataType: 'json', 
 	 beforeSend: function(xhr) {
 	 xhr.setRequestHeader("Accept", "application/json");
 	 xhr.setRequestHeader("Content-Type", "application/json");
 	 },
 	 success: function(ajaxresp) {
 		 //alert(ajaxresp.name);
 		 //console.log(ajaxresp); 
 		 if(ajaxresp != null && typeof ajaxresp !== typeof undefined && ajaxresp !== false && typeof ajaxresp.message !== typeof undefined ) {
 			 $("#processingImg1").hide();
 			 var reslt;
 			  if( ajaxresp.message === "Success") {
 				 /*  reslt = "Login Success";
 				  $("#errorMsgDiv").html(reslt); 			
 				  setTimeout(function(){$("#popupAlertMsg").modal('show');},10);
 				  setTimeout(function(){$("#popupAlertMsg").find('button').trigger('click');},1000);*/	
 				 
 				  window.location.href = "/secure/home/publisher";
 			 
 			  }else{
 				 //  reslt = "Please Enter Valid UserName and Password";
 				   reslt="Please Enter Valid Email & Password";
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
 		 handleError();
 	 }
 }

 function handleError() {
 	$("#processingImg1").hide();
 	 var reslt;
 	 reslt = "Error Occur,Please Try Agian"
 	 $("#errorMsgDiv").html(reslt);
 	//$('#popupAlertMsg').modal('show');
 	 setTimeout(function(){$("#popupAlertMsg").modal('show');},1000);
 	 setTimeout(function(){$("#popupAlertMsg").find('button').trigger('click');},1000);
 }
