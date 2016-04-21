<link rel="stylesheet" href="/tree/assets/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/tree/assets/dist/themes/proton/style.css" />
   <link rel="stylesheet" href="/tree/assets/tree.css" />
    <!--[if lt IE 9]><script src="./assets/respond.js"></script><![endif]-->

    <link rel="icon" href="/tree/assets/favicon.ico" type="image/x-icon" />
    <link rel="apple-touch-icon-precomposed" href="/tree/assets/apple-touch-icon-precomposed.png" />
    <script src="/tree/assets/jquery-1.10.2.min.js"></script>
    <script src="/tree/assets/tree.js"></script>
   <!--  <script src="/tree/assets/dist/jstree.min.js"></script> -->
<style>
        .proton-demo{
            max-width: 20%;
            padding: 10px;
            border-radius: 3px;
        }
    </style>



                    
                        <div id="jstree-proton-3" style="margin-top:20px;" class="proton-demo"></div>
                    
                    
               
            


 <script>
    $(function() {
    	
    	$.ajax({
            async : true,
            type : "GET",
            url : "http://localhost:8080/public/loadIndustries.json",
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