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
	 //var names = instance.get_path('#' + instance.rslt.obj.attr('id'),false); 
	for(j=0;j<selectedNodes.length;j++) {
		var names = instance.get_path(selectedNodes[j],',',false);
		var ids = instance.get_path(selectedNodes[j],',',true);
	   console.log(selectedNodes[j].text);
	   //names+selectedNodes[j].text
	   text =text.concat(names.split(','));
	   nodeIds =nodeIds.concat(ids.split(','));
	   //nodeIds.push(ids);
	}
	var newText =[];
	var newNodeIds=[];
	newText.push(text[0]);
	for (var j = 1; j < text.length; j++){
		var text1=text[j];
		if(newText.indexOf(text1)==-1){
			newText.push(text[j]);
		}
	}
	
	newNodeIds.push(nodeIds[0]);
	for (var j = 1; j < nodeIds.length; j++){
		var id=nodeIds[j];
		if(newNodeIds.indexOf(id)==-1){
			newNodeIds.push(nodeIds[j]);
		}
	}
	
	$("#selectedIndustires").css("display","block") 
	$("#selectedIndus").val(newNodeIds.join(','));
	$("#echoSelection3").html(newText.join(','));
}

function unique(list) {
    var result = [];
    $.each(list, function(i, e) {
        if (jQuery.inArray(e, result) == -1) result.push(e);
    });
    return result;
}

function save() {
	getselecteddata();
	unPopup();
}
function cancelPopup() {
	prepareTree(jsondata,true);
    unPopup();
}