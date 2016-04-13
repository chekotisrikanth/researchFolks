function triggerPagenation(url) {
	
	var maxResults = 10;
	var totalRec = parseInt($("#total_count").attr("total-cnt"));
	$("#paginateDiv").pagination({
		 items: totalRec,
		 itemsOnPage: maxResults,
		 cssStyle: 'light-theme',
		 onPageClick: function(pageNumber) {
		 var currentPageNo = $(".page-link").val();
		 var num;
		 num=(pageNumber-1);
		 /*if(type=="admin"){}else{
			 num = num*10;	 
		 }*/
		 //num = num*10;
		 //var pageIndx = num*10;
		/* if(json.temp == "fromSearch")
		 {
			 viewQuoteDetailsAjaxcall(type,num);
		 }
		 else
		 {
		    viewTodayQuoteDetails(type,num);
		 }*/
		 	//window.location='/secure/home/admin/'+num+'/'+maxResults;
		 window.location=url+'/'+num+'/'+maxResults;
		 }
		 });
	
}


function triggerAjaxPagination(resObject) {
	
	var maxResults = $(".recordsPerPage").val();
	
	console.log(maxResults+"====>"+resObject.totalRec);
	//try{
		//$(".pagination").pagination('destroy');	
	//}catch(e) {
	//	console.log(e);
	//}
	
	 
	$(".pagination").pagination({
		 items: resObject.totalRec,
		 itemsOnPage: maxResults,
		 cssStyle: 'light-theme',
		 onPageClick: function(pageNumber) {
		 var currentPageNo = $(".page-link").val();
		 var num;
		 num=(pageNumber-1);
		 /*if(type=="admin"){}else{
			 num = num*10;	 
		 }*/
		 //num = num*10;
		 //var pageIndx = num*10;
		/* if(json.temp == "fromSearch")
		 {
			 viewQuoteDetailsAjaxcall(type,num);
		 }
		 else
		 {
		    viewTodayQuoteDetails(type,num);
		 }*/
		 	//window.location='/secure/home/admin/'+num+'/'+maxResults;
		 resObject.pageNumber=num;
		 resObject.maxResults=maxResults;
		 resObject.callAjax();
		 }
		 });
	
}


