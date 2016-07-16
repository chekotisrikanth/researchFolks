 var commentsObj =[];
var getProperty = function (propertyName) {
    return commentsObj[propertyName];
};

$(document).ready(function() {
            $(document).on('click', '.cmnt', function(){
        		//alert('ok');
            	//all ajax to get the comments for the report
            	var repId = $(this).attr('rep-id');
            	callAjaxPost("/comments/getComments/"+repId,"chatHistory");
            	appendalertmsg1(repId);
            	$("#popupAlertMsg").modal('show');
            	
        	}); 
          
            
            //downreportCmnt
            $(document).on('click', '.downreportCmnt', function(){
            	var reportId=parseInt($(this).attr("rep-id"));
            		//window.location = '/downloadReport/'+reportId;
            	
            	WindowObjectReference = window.open("/downloadReport/COMMENTS/"+reportId, "Report_WindowName",
            	"menubar=yes,location=yes,resizable=yes,scrollbars=yes,status=yes");
            	});
            $(document).on('click', '.submitComment', function(){
            	console.log('ok');
            	var reportId=parseInt($(this).attr("rep-id"));
            		//window.location = '/downloadReport/'+reportId;
            	
            	$(".chk").each(function(index) {
            		if(parseInt($(this).attr("rep-id")) == reportId) {
            			$(this).prop('checked', true);
            			$(".modalHide").trigger("click");

            			try{
            				$(".sncButton").trigger("click");
            			}catch(e) {
            				console.log(e);
            			}
            			
            			
                    	

                    	//return;
            		}            		
            	})
            });
            	
            triggerPagenation('/secure/home/reviewer');
            });

			
 

 function appendalertmsg1(repotId){
 	//console.log(repotId);
 	var str='';

 	str+='<div class="modal fade alerttop row" id="popupAlertMsg" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true" style="z-index:99999">';
 	str+='<div class="modal-dialog  ">';
 	str+='<div class="modal-content alertstyle">';
 	str+='<div class="chatHistory container-fluid"></div>';
 	str+='<div class="modal-body alignmenttext">';
 	str+='<div>	<textarea  id="errorMsgDiv" class="col-md-12"></textarea></div>';
 	str+='</div>';
 	str+='<div class="modal-footer pad_0 bt">';
 	
 	str+='<div class="row">';

 	str+='<div class="col-md-3 col-md-offset-5 col-xs-4 col-xs-offset-3 col-sm-3 col-sm-offset-5 .mtop-5">';

 	str+='</div>';
 	str+='</div>';
 	str+='<div class="row">';
 	str+='<div class="col-md-12"><div class="col-md-3">AttachMent :</div><div class="col-md-4"><input type="file"  class="fileUp file-'+repotId+'" name ="report"  /></div></div>';
 	str+='</div>';
 	str+='<div class="col-md-3"><button type="button" class="btn btn-primary btn-xs modalHide" rep-id='+repotId+' >Save Comment</button></div>';
 	str+='<div class="col-md-3"><button type="button" class="btn btn-primary btn-xs submitComment" rep-id='+repotId+' >Save & Submit </button></div>';
 	str+='<div class="col-md-3"><button type="button" class="btn btn-primary btn-xs modalHide" > Close </button></div>';


 	str+='</div>';
 	


 	str+='</div>';
 	str+='</div>';
 	str+='</div>';
 	$("#displayAlertMsg").html(str);
 	 $("#errorMsgDiv").val(getProperty(repotId));
 	
 	//data-dismiss="modal"
 }
 
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
				$("#processingImg1").hide();

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
        if(object.comment != null) {
        	str+='<p class="bg-success">'+object.comment;
     		str+='</p>';
        }
        
       
		if(object.filePath != null && object.filePath.length>2) {
			str+='<p><a href="#" class="downreportCmnt" rep-id="'+object.cmntId+'" ><img src="/images/icon-download.png" alt="Attachments"/></a><p>';
		}
		
		

//cmntId
       
      
	});
	$("."+divClass).html(str);
	
}