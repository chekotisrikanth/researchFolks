$(document).ready(function(){
	$(document).on('click', '.sncButton', function(){
		var dataArr = getValueUsingClass();
		callAjaxForDivId("loginForm", "resp",dataArr);
		//handleError();
	}); //edit
	
	$(document).on('click', '.edit', function(){
		
		var r = confirm("<H1>Do you want to reassign!...<H1>");
		if (r == true) {
			$(".dis-able").attr("disabled",false);
			$(this).css("display","none"); //chk
			$(this).next().css("display","block");
		}
	});
	
$(document).on('click', '.downreport', function(){
	var reportId=parseInt($(this).attr("rep-id"));
		//window.location = '/downloadReport/'+reportId;
	
	WindowObjectReference = window.open("/downloadReport/"+reportId, "Report_WindowName",
	"menubar=yes,location=yes,resizable=yes,scrollbars=yes,status=yes");
	});

triggerPagenation('/secure/home/admin');
});

function getValueUsingClass(){
	/* declare an checkbox array */
	var chkArray = [];
	var reportsArrObj = [];
	
	var reportsObj={};
	
	/* look for all checkboes that have a class 'chk' attached to it and check if it was checked */
	$(".chk:checked").each(function() {
		reportsObj = {};
		reportsObj.reportId=parseInt($(this).attr("rep-id"));
		reportsObj.reviwerId=parseInt($(".rev-"+$(this).attr("id")).val());
		reportsObj.publisherId=parseInt($(".pub-"+$(this).attr("id")).val());
		reportsArrObj.push(reportsObj);
		console.log(reportsObj);
	});
	/* check if there is selected checkboxes, by default the length is 1 as it contains one single comma */
	if(reportsArrObj.length >= 1){
		console.log("You have selected " + reportsArrObj);	
	}else{
		alert("Please at least one of the checkbox");	
	}
	
	return reportsArrObj;
}

//ajax
function callAjaxForDivId(formId,respdiv,json) { 
 try{
 $("#processingImg1").show();
	 $.ajax({
	 url: '/admin/asignReports',
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
		 $("#processingImg1").hide();
		 if(ajaxresp != null && typeof ajaxresp !== typeof undefined && ajaxresp !== false && typeof ajaxresp.message !== typeof undefined ) {			
			 var reslt;
			  if( ajaxresp.message =="SUCCESS") {
				 /*  reslt = "Login Success";
				  $("#errorMsgDiv").html(reslt); 			
				  setTimeout(function(){$("#popupAlertMsg").modal('show');},10);
				  setTimeout(function(){$("#popupAlertMsg").find('button').trigger('click');},1000);*/	
				 // handleError();
				 window.location.href = "/secure/home/admin/0/10";
			
			  }else{
				    appendalertmsg();
				 //  reslt = "Please Enter Valid UserName and Password";
				   reslt="Error Occured Please Try Again Message :"+ajaxresp.message ;
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
