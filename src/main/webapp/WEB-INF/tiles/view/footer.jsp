<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="${pageContext.request.contextPath}/css/jquery/jquery-ui.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   	 <script src="${pageContext.request.contextPath}/tree/assets/jquery-1.10.2.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery/jquery-ui.min.js"></script>
</head>
<body>
  <footer class="loginfooter">
    <div class="logorights">Copyright © ResearchFolks.com 2016 All rights reserved</div>
    <div class="footericon">
        <span data-social="facebook"><a href="#"><img src="${pageContext.request.contextPath}/images/login/footerfb.png"></a></span>
        <span data-social="twitter"><a href="#"><img src="${pageContext.request.contextPath}/images/login/footerftwitter.png"></a></span>
        <span data-social="linkedin"><a href="#"><img src="${pageContext.request.contextPath}/images/login/footerlinkedin.png"></a></span>
    </div>
    </footer>
</body>
</html>

<script>
	$( function() {
		$( "#registerdetails" ).dialog({
    width: 'auto', // overcomes width:'auto' and maxWidth bug
    maxWidth: 600,
    height: 'auto',
    modal: true,
    fluid: true, //new option
    resizable: false,
			autoOpen:false
			
});


// on window resize run function
$(window).resize(function () {
    fluidDialog();
});

// catch dialog if opened within a viewport smaller than the dialog width
$(document).on("dialogopen", ".ui-dialog", function (event, ui) {
    fluidDialog();
});

function fluidDialog() {
    var $visible = $(".ui-dialog:visible");
    // each open dialog
    $visible.each(function () {
        var $this = $(this);
        var dialog = $this.find(".ui-dialog-content").data("ui-dialog");
        // if fluid option == true
        if (dialog.options.fluid) {
            var wWidth = $(window).width();
            // check window width against dialog width
            if (wWidth < (parseInt(dialog.options.maxWidth) + 50))  {
                // keep dialog from filling entire screen
                $this.css("max-width", "90%");
            } else {
                // fix maxWidth bug
                $this.css("max-width", dialog.options.maxWidth + "px");
            }
            //reposition dialog
            dialog.option("position", dialog.options.position);
        }
    });

}
		$('#newUser').click(function(){
			$( "#registerdetails" ).dialog('open');
			$(".ui-dialog-titlebar").hide();
		});
		$('#submitBtn').click(function(){
			$( "#registerdetails" ).dialog('close');
		});
					
	} );
</script>