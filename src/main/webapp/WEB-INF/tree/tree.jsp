<link rel="stylesheet" href="${pageContext.request.contextPath}/tree/assets/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/tree/assets/dist/themes/proton/style.css" />
   <link rel="stylesheet" href="${pageContext.request.contextPath}/tree/assets/tree.css" />
    <!--[if lt IE 9]><script src="./assets/respond.js"></script><![endif]-->

    <link rel="icon" href="/tree/assets/favicon.ico" type="image/x-icon" />
    <link rel="apple-touch-icon-precomposed" href="/tree/assets/apple-touch-icon-precomposed.png" />
    <script src="${pageContext.request.contextPath}/tree/assets/jquery-1.10.2.min.js"></script>
    <script src="${pageContext.request.contextPath}/tree/assets/tree.js"></script>
   <!--  <script src="/tree/assets/dist/jstree.min.js"></script> -->
<style>
        .proton-demo{
            max-width: 20%;
            padding: 10px;
            border-radius: 3px;
        }
    </style>


 <div class="modal" style="display: none">
        <div class="center">
            <img alt="" src="${pageContext.request.contextPath}/images/loader.gif" />
        </div>
    </div>

                    
                        <div id="jstree-proton-3" style="margin-top:20px;" class="proton-demo"></div>
                    
                    
               
            


 <script>
    $(function() {
    	
    	 $.ajaxSetup({
             global: false,
             type: "GET",
             url: "http://www.telize.com/jsonip",
             beforeSend: function () {
                 $(".modal").show();
             },
             complete: function () {
                 $(".modal").hide();
             }
         });

    	$.ajax({
            async : true,
            type : "GET",
            url : "${pageContext.request.contextPath}/public/loadIndustries.json",
            dataType : "json",    

            success : function(json) {
            	prepareTree(json,false);
            },    

            error : function(xhr, ajaxOptions, thrownError) {
                alert(xhr.status);
                alert(thrownError);
            }
        });
    	
        /* $('#jstree-proton-3').jstree({
            'plugins': ["state","wholerow", "checkbox"],
            'core': {
                'data': [{
                        "text": "Wholerow with checkboxes",
                        "children": [{
                            "text": "initially selected",
                            "state": {
                                "selected": false
                            }
                        }, {
                            "text": "custom icon URL",
                            "icon": "/tree/assets/images/tree_icon.png"
                        }, {
                            "text": "initially open",
                            "state": {
                                "opened": true
                            },
                            "children": ["Another node"]
                        }, {
                            "text": "custom icon class",
                            "icon": "glyphicon glyphicon-leaf"
                        }]
                    },
                    "And wholerow selection"
                ],
                'themes': {
                    'name': 'proton',
                    'responsive': true
                }
            }
        });
 */		
		/* $('#jstree-proton-3').on("changed.jstree", function (e, data) {
  console.log(data.selected);
  var i, j, r = [];
  var snodesids=[];
    for(i = 0, j = data.selected.length; i < j; i++) {
      r.push(data.instance.get_node(data.selected[i]).text);
      snodesids.push(data.instance.get_node(data.selected[i]).id);
    }
    console.log('Selected: ' + r.join(', '));
    console.log('Selected ids: ' + snodesids.join(', '));
    
}); */
    });
    </script>
