function handleError() {
	$("#processingImg1").hide();
	appendalertmsg();
	 var reslt;
	 reslt = "Error Occured,Please Try Agian"
	 $("#errorMsgDiv").html(reslt);
	//$('#popupAlertMsg').modal('show');
	 setTimeout(function(){$("#popupAlertMsg").modal('show');},1000);
	// setTimeout(function(){$("#popupAlertMsg").find('button').trigger('click');},3000);
}

function appendalertmsg(){
	
	var str='';
	
	str+='<div class="modal fade alerttop" id="popupAlertMsg" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true" style="z-index:99999">';
	str+='<div class="modal-dialog  ">';
	str+='<div class="modal-content alertstyle">';
	str+='<div class="modal-body alignmenttext">';
	str+='<div>	<div  id="errorMsgDiv" class="col-md-12 text-center"></div></div>';
	str+='</div>';
	str+='<div class="modal-footer pad_0 bt">';
	str+='<div class="row">';
	str+='<div class="col-md-3 col-md-offset-5 col-xs-4 col-xs-offset-3 col-sm-3 col-sm-offset-5 .mtop-5">';
	str+='<button type="button" class="btn btn-primary btn-xs" data-dismiss="modal">close</button>';
	str+='</div>';
	str+='</div>';
	str+='</div>';
	str+='</div>';
	str+='</div>';
	str+='</div>';
	$("#displayAlertMsg").html('');
	$("#displayAlertMsg").html(str);
}
