$(document).ready(function(){
	$(document).on('click', '.sncButton', function(){
		getValueUsingClass();
		callAjaxForDivId("loginForm", "resp",getValueUsingClass());
		
	}); 
});

function getValueUsingClass(){
	/* declare an checkbox array */
	var chkArray = [];
	var reportsArrObj = [];
	
	var reportsObj={};
	
	/* look for all checkboes that have a class 'chk' attached to it and check if it was checked */
	$(".chk:checked").each(function() {
		reportsObj = {};
		reportsObj.reportId=$(this).attr("rep-id");
		reportsObj.reviwer=$(".rev-"+$(this).attr("id")).val();
		reportsObj.publisher=$(".pub-"+$(this).attr("id")).val();
		reportsArrObj.push(reportsObj);
		console.log(reportsObj);
	});
	/* check if there is selected checkboxes, by default the length is 1 as it contains one single comma */
	if(reportsArrObj.length > 1){
		console.log("You have selected " + reportsArrObj);	
	}else{
		alert("Please at least one of the checkbox");	
	}
	
	return reportsArrObj;
}


//appendalertmsg();
function loginAjaxCalls(){
 //$("#loginajax").click(function(evt){
 //evt.preventDefault();
 var usrName = document.getElementById('usrName').value;
 var usrPwd = document.getElementById('usrPwd').value;
 var password1=MD5(MD5(usrName.toLowerCase())+MD5(usrPwd));
 var json = { usrName : usrName, usrPwd : password1};

 callAjaxForDivId("loginForm", "resp",json);
 //});
}

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
function callAjaxForDivId(formId,respdiv,json) { 
 try{
 $("#processingImg1").show();
	 $.ajax({
	 url: 'asignReports',
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
		 if(ajaxresp != null && typeof ajaxresp !== typeof undefined && ajaxresp !== false && typeof ajaxresp.statusMsg !== typeof undefined ) {
			 $("#processingImg1").hide();
			 var reslt;
			  if( ajaxresp.statusMsg =="SUCCESS") {
				 /*  reslt = "Login Success";
				  $("#errorMsgDiv").html(reslt); 			
				  setTimeout(function(){$("#popupAlertMsg").modal('show');},10);
				  setTimeout(function(){$("#popupAlertMsg").find('button').trigger('click');},1000);*/	
				  if(ajaxresp.description == "Admin") {
				  window.location.href = "/amegolf/adminDashboard";
			   } else {
				 window.location.href = "/amegolf/employeeDashboard";
			   }
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