var jsondata;
function popupTree() {
    document.getElementById('light').style.display = 'block';
    document.getElementById('fade').style.display = 'block';
}

function unPopup() {
	document.getElementById('light').style.display = 'none';
    document.getElementById('fade').style.display = 'none';
}


function prepareTree(jsondata,destroy) {
	if(destroy) {
		$('#jstree-proton-3').jstree("destroy");
	}
	console.log(JSON.stringify(jsondata));
	$('#jstree-proton-3').jstree({			
        'plugins': ["json_data","wholerow", "checkbox"],
        'core': {
            'data': jsondata,
            'themes': {
                'name': 'proton',
                'responsive': true
            }
        }
    });
}

function getselecteddata() {
	var text=[],nodeIds=[];
	var instance = $('#jstree-proton-3').jstree(true); 
	jsondata = instance.get_json();
	 selectedNodes = instance.get_selected(true);
	for(j=0;j<selectedNodes.length;j++) {
	   console.log(selectedNodes[j].text);
	   text.push(selectedNodes[j].text);
	   nodeIds.push(selectedNodes[j].id);
	}
	$("#selectedIndustires").css("display","block") 
	$("#selectedIndus").val(nodeIds.join(','));
	$("#echoSelection3").html(text.join(', '));
}

function save() {
	getselecteddata();
	unPopup();
}
function cancelPopup() {
	prepareTree(jsondata,true);
    unPopup();
}