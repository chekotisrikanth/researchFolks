var CountryNameList = new Array();
var ViewContainer = new Array();
var keySkills = new Array();
var baseUrl = '/secure/master/';

/*AUTOCOMPLETE*/
$.getJSON(baseUrl+'?masterType=0', function(responseJson) {
    $.each(responseJson, function(index, item) {
    	var obj = {
    			//value :item.CountryIsdCode,
    			label : item.skill
    	};
    	keySkills.push(obj);
    });
});



function viewMasterData() {
    var type = jQuery("#masterType").val();
    if (type !== '-1') {
        //showGeneralLoading("Loading Data...");
        jQuery("#editMasterFormContainer").empty();
        $.getJSON(baseUrl + 'getAllMasters?masterType='+type, function(responseJson) {
            
            var aaData = new Array();
            $.each(responseJson, function(index, item) {
                if (item === "no_data") {
                    //hideGeneralLoading();
                    jQuery("#MasterSuccess").html("");
                    jQuery("#MasterError").html("You did not Feed data Earlier");
                    return;
                } else {
                    var innerArray = new Array();
                    innerArray.push(item.id);
                    switch (type) {
                        case "1":
                            innerArray.push(item.skill);
                            break;
                        case "2":
                            innerArray.push(item.countryName);
                            break;
                        case "3":
                            innerArray.push(item.preference);
                            break;
                        case "4":
                            innerArray.push(item.title);
                            break;
                        case "5":
                            innerArray.push(item.type);
                            break;
                        case "6":
                            innerArray.push(item.currencyName);
                            break;
                        case "7":
                        case "8":
                            innerArray.push(item.name);
                            break;
                        case "9":
                            innerArray.push(item.type);
                            break;
                        case "10":
                            innerArray.push(item.time);
                            break;
                        case "11":
                            innerArray.push(item.unit);
                            break;
                        case "12":
                            innerArray.push(item.cycle);
                            break;
                        	default:
                            alert("Error");
                            break;
                    }
                    innerArray.push("<a href='#' style='cursor: pointer;' onclick='editMasterData(\"" + item.id + "\");'><img src='/images/masters/application_form_edit.png'/></a>");
                    innerArray.push("<a href='#' style='cursor: pointer;' onclick='deleteMasterData(\"" + item.id + "\");'><img src='/images/masters/delete.png'/></a>");
                   
                    aaData.push(innerArray);
                    jQuery("#MasterError").html("");
                    jQuery("#MasterSuccess").html("Loaded Successfully");
                }
            });
            $('#dynamic').html('<table cellpadding="0" cellspacing="0" border="0" class="display" id="viewMasterGrid" width="100%" style="font-size: 12px;"></table>');
            switch (type) {
                case "1":
                    $('#viewMasterGrid').dataTable({
                        "aaData": aaData,
                        "aoColumns": [
                            {"sTitle": "id"},
                            {"sTitle": "skill"},
                            {"sTitle": "Edit"},
                            {"sTitle": "Delete"}
                        ]
                    });
                    break;
                case "2":
                    $('#viewMasterGrid').dataTable({
                        "aaData": aaData,
                        "aoColumns": [
                            {"sTitle": "id"},
                            {"sTitle": "Country Name"},
                            {"sTitle": "Edit"},
                            {"sTitle": "Delete"}
                        ]
                    });
                    break;
                case "3":
                    $('#viewMasterGrid').dataTable({
                        "aaData": aaData,
                        "aoColumns": [
                            {"sTitle": "id"},
                            {"sTitle": "Preference"},
                            {"sTitle": "Edit"},
                            {"sTitle": "Delete"}
                        ]
                    });
                    break;
                case "4":
                    $('#viewMasterGrid').dataTable({
                        "aaData": aaData,
                        "aoColumns": [
                            {"sTitle": "id"},
                            {"sTitle": "Company Title"},
                            {"sTitle": "Edit"},
                            {"sTitle": "Delete"}
                        ]
                    });
                    break;
                
                case "5":
                    $('#viewMasterGrid').dataTable({
                        "aaData": aaData,
                        "aoColumns": [
                            {"sTitle": "id"},
                            {"sTitle": "Company Type"},
                            {"sTitle": "Edit"},
                            {"sTitle": "Delete"}
                        ]
                    });
                    break;
                case "6":
                    $('#viewMasterGrid').dataTable({
                        "aaData": aaData,
                        "aoColumns": [
                            {"sTitle": "id"},
                            {"sTitle": "Currency Name"},
                            {"sTitle": "Edit"},
                            {"sTitle": "Delete"}
                        ]
                    });
                    break;
                case "7":
                    $('#viewMasterGrid').dataTable({
                        "aaData": aaData,
                        "aoColumns": [
                            {"sTitle": "id"},
                            {"sTitle": "Industry Name"},
                            {"sTitle": "Edit"},
                            {"sTitle": "Delete"}
                        ]
                    });
                    break;
                case "8":
                    $('#viewMasterGrid').dataTable({
                        "aaData": aaData,
                        "aoColumns": [
                            {"sTitle": "id"},
                            {"sTitle": "Occupation Name"},
                            {"sTitle": "Edit"},
                            {"sTitle": "Delete"}
                        ]
                    });
                    break;
                case "9":
                    $('#viewMasterGrid').dataTable({
                        "aaData": aaData,
                        "aoColumns": [
                            {"sTitle": "id"},
                            {"sTitle": "Research Type"},
                            {"sTitle": "Edit"},
                            {"sTitle": "Delete"}
                        ]
                    });
                    break;
                case "10":
                    $('#viewMasterGrid').dataTable({
                        "aaData": aaData,
                        "aoColumns": [
                            {"sTitle": "id"},
                            {"sTitle": "TURNAROUND TIME"},
                            {"sTitle": "Edit"},
                            {"sTitle": "Delete"}
                        ]
                    });
                    break;
                case "11":
                    $('#viewMasterGrid').dataTable({
                        "aaData": aaData,
                        "aoColumns": [
                            {"sTitle": "id"},
                            {"sTitle": "Unit"},
                            {"sTitle": "Edit"},
                            {"sTitle": "Delete"}
                        ]
                    });
                    break;
                case "12":
                    $('#viewMasterGrid').dataTable({
                        "aaData": aaData,
                        "aoColumns": [
                            {"sTitle": "id"},
                            {"sTitle": "Update Cycle"},
                            {"sTitle": "Edit"},
                            {"sTitle": "Delete"}
                        ]
                    });
                    break;
                    default:
                    alert("Error");
                    break;
            }
            //hideGeneralLoading();
        });
    }
    else {
        alert("Please choose a Master data entity");
    }
}

function addMasterData() {
    var name = jQuery("#masterType").val();
    console.debug("add type :" + name);
    if (name !== '-1') {
        jQuery('#dynamic').empty();
        switch (name) {
        case "1":
            jQuery("#editMasterFormContainer").empty();
            jQuery("#editMasterFormContainer").append("<table>");
            jQuery("#editMasterFormContainer").append("<tr>");
            jQuery("#editMasterFormContainer").append("<td colspan='3'><b>Add Key Skill</b></td>");
            jQuery("#editMasterFormContainer").append("</tr>");
            jQuery("#editMasterFormContainer").append("<tr><td height='5px'/></tr>");
            jQuery("#editMasterFormContainer").append("<tr>");
            jQuery("#editMasterFormContainer").append("<td>Skill Name:</td>");
            jQuery("#editMasterFormContainer").append("<td><input type='text' name='skill'/></td>");
            jQuery("#editMasterFormContainer").append("<td/>");
            jQuery("#editMasterFormContainer").append("</tr>");
            break;
            case "2":
            jQuery("#editMasterFormContainer").empty();
            jQuery("#editMasterFormContainer").append("<table>");
            jQuery("#editMasterFormContainer").append("<tr>");
            jQuery("#editMasterFormContainer").append("<td colspan='3'><b>Add Country Name</b></td>");
            jQuery("#editMasterFormContainer").append("</tr>");
            jQuery("#editMasterFormContainer").append("<tr><td height='5px'/></tr>");
            jQuery("#editMasterFormContainer").append("<tr>");
            jQuery("#editMasterFormContainer").append("<td>country name:</td>");
            jQuery("#editMasterFormContainer").append("<td><input type='text' id='countryName' name='countryName'/></td>");
            jQuery("#editMasterFormContainer").append("<td/>");
            jQuery("#editMasterFormContainer").append("</tr>");
            break;
            case "3":
                jQuery("#editMasterFormContainer").empty();
                jQuery("#editMasterFormContainer").append("<table>");
                jQuery("#editMasterFormContainer").append("<tr>");
                jQuery("#editMasterFormContainer").append("<td colspan='3'><b>Add Analyst Preference </b></td>");
                jQuery("#editMasterFormContainer").append("</tr>");
                jQuery("#editMasterFormContainer").append("<tr><td height='5px'/></tr>");
                jQuery("#editMasterFormContainer").append("<tr>");
                jQuery("#editMasterFormContainer").append("<td>country name:</td>");
                jQuery("#editMasterFormContainer").append("<td><input type='text' id='preference' name='preference'/></td>");
                jQuery("#editMasterFormContainer").append("<td/>");
                jQuery("#editMasterFormContainer").append("</tr>");
                break;
                
            case "4":
                jQuery("#editMasterFormContainer").empty();
                jQuery("#editMasterFormContainer").append("<table>");
                jQuery("#editMasterFormContainer").append("<tr>");
                jQuery("#editMasterFormContainer").append("<td colspan='3'><b>Add Company Title </b></td>");
                jQuery("#editMasterFormContainer").append("</tr>");
                jQuery("#editMasterFormContainer").append("<tr><td height='5px'/></tr>");
                jQuery("#editMasterFormContainer").append("<tr>");
                jQuery("#editMasterFormContainer").append("<td>Company Title:</td>");
                jQuery("#editMasterFormContainer").append("<td><input type='text' id='title' name='title'/></td>");
                jQuery("#editMasterFormContainer").append("<td/>");
                jQuery("#editMasterFormContainer").append("</tr>");
                break;
                
            case "5":
                jQuery("#editMasterFormContainer").empty();
                jQuery("#editMasterFormContainer").append("<table>");
                jQuery("#editMasterFormContainer").append("<tr>");
                jQuery("#editMasterFormContainer").append("<td colspan='3'><b>Add Company Type </b></td>");
                jQuery("#editMasterFormContainer").append("</tr>");
                jQuery("#editMasterFormContainer").append("<tr><td height='5px'/></tr>");
                jQuery("#editMasterFormContainer").append("<tr>");
                jQuery("#editMasterFormContainer").append("<td>country name:</td>");
                jQuery("#editMasterFormContainer").append("<td><input type='text' id='type' name='type'/></td>");
                jQuery("#editMasterFormContainer").append("<td/>");
                jQuery("#editMasterFormContainer").append("</tr>");
                break;
         
                
            case "6":
                jQuery("#editMasterFormContainer").empty();
                jQuery("#editMasterFormContainer").append("<table>");
                jQuery("#editMasterFormContainer").append("<tr>");
                jQuery("#editMasterFormContainer").append("<td colspan='3'><b>Add Currency Name </b></td>");
                jQuery("#editMasterFormContainer").append("</tr>");
                jQuery("#editMasterFormContainer").append("<tr><td height='5px'/></tr>");
                jQuery("#editMasterFormContainer").append("<tr>");
                jQuery("#editMasterFormContainer").append("<td>country name:</td>");
                jQuery("#editMasterFormContainer").append("<td><input type='text' id='currencyName' name='currencyName'/></td>");
                jQuery("#editMasterFormContainer").append("<td/>");
                jQuery("#editMasterFormContainer").append("</tr>");
                break;
         
            case "7":
                jQuery("#editMasterFormContainer").empty();
                jQuery("#editMasterFormContainer").append("<table>");
                jQuery("#editMasterFormContainer").append("<tr>");
                jQuery("#editMasterFormContainer").append("<td colspan='3'><b>Add Industry Name </b></td>");
                jQuery("#editMasterFormContainer").append("</tr>");
                jQuery("#editMasterFormContainer").append("<tr><td height='5px'/></tr>");
                jQuery("#editMasterFormContainer").append("<tr>");
                jQuery("#editMasterFormContainer").append("<td>country name:</td>");
                jQuery("#editMasterFormContainer").append("<td><input type='text' id='name' name='name'/></td>");
                jQuery("#editMasterFormContainer").append("<td/>");
                jQuery("#editMasterFormContainer").append("</tr>");
                break;
         
            case "8":
                jQuery("#editMasterFormContainer").empty();
                jQuery("#editMasterFormContainer").append("<table>");
                jQuery("#editMasterFormContainer").append("<tr>");
                jQuery("#editMasterFormContainer").append("<td colspan='3'><b>Add OCCUPATION </b></td>");
                jQuery("#editMasterFormContainer").append("</tr>");
                jQuery("#editMasterFormContainer").append("<tr><td height='5px'/></tr>");
                jQuery("#editMasterFormContainer").append("<tr>");
                jQuery("#editMasterFormContainer").append("<td>Occupation name:</td>");
                jQuery("#editMasterFormContainer").append("<td><input type='text' id='name' name='name'/></td>");
                jQuery("#editMasterFormContainer").append("<td/>");
                jQuery("#editMasterFormContainer").append("</tr>");
                break;
         
            case "9":
                jQuery("#editMasterFormContainer").empty();
                jQuery("#editMasterFormContainer").append("<table>");
                jQuery("#editMasterFormContainer").append("<tr>");
                jQuery("#editMasterFormContainer").append("<td colspan='3'><b>Add RESEARCH TYPE </b></td>");
                jQuery("#editMasterFormContainer").append("</tr>");
                jQuery("#editMasterFormContainer").append("<tr><td height='5px'/></tr>");
                jQuery("#editMasterFormContainer").append("<tr>");
                jQuery("#editMasterFormContainer").append("<td>country name:</td>");
                jQuery("#editMasterFormContainer").append("<td><input type='text' id='type' name='type'/></td>");
                jQuery("#editMasterFormContainer").append("<td/>");
                jQuery("#editMasterFormContainer").append("</tr>");
                break;
         
            case "10":
                jQuery("#editMasterFormContainer").empty();
                jQuery("#editMasterFormContainer").append("<table>");
                jQuery("#editMasterFormContainer").append("<tr>");
                jQuery("#editMasterFormContainer").append("<td colspan='3'><b>Add TURNAROUND TIME </b></td>");
                jQuery("#editMasterFormContainer").append("</tr>");
                jQuery("#editMasterFormContainer").append("<tr><td height='5px'/></tr>");
                jQuery("#editMasterFormContainer").append("<tr>");
                jQuery("#editMasterFormContainer").append("<td>country name:</td>");
                jQuery("#editMasterFormContainer").append("<td><input type='text' id='time' name='time'/></td>");
                jQuery("#editMasterFormContainer").append("<td/>");
                jQuery("#editMasterFormContainer").append("</tr>");
                break;
         
            case "11":
                jQuery("#editMasterFormContainer").empty();
                jQuery("#editMasterFormContainer").append("<table>");
                jQuery("#editMasterFormContainer").append("<tr>");
                jQuery("#editMasterFormContainer").append("<td colspan='3'><b>Add UNIT </b></td>");
                jQuery("#editMasterFormContainer").append("</tr>");
                jQuery("#editMasterFormContainer").append("<tr><td height='5px'/></tr>");
                jQuery("#editMasterFormContainer").append("<tr>");
                jQuery("#editMasterFormContainer").append("<td>country name:</td>");
                jQuery("#editMasterFormContainer").append("<td><input type='text' id='unit' name='unit'/></td>");
                jQuery("#editMasterFormContainer").append("<td/>");
                jQuery("#editMasterFormContainer").append("</tr>");
                break;
         
            case "12":
                jQuery("#editMasterFormContainer").empty();
                jQuery("#editMasterFormContainer").append("<table>");
                jQuery("#editMasterFormContainer").append("<tr>");
                jQuery("#editMasterFormContainer").append("<td colspan='3'><b>Add UPDATE CYCLE </b></td>");
                jQuery("#editMasterFormContainer").append("</tr>");
                jQuery("#editMasterFormContainer").append("<tr><td height='5px'/></tr>");
                jQuery("#editMasterFormContainer").append("<tr>");
                jQuery("#editMasterFormContainer").append("<td>country name:</td>");
                jQuery("#editMasterFormContainer").append("<td><input type='text' id='cycle' name='cycle'/></td>");
                jQuery("#editMasterFormContainer").append("<td/>");
                jQuery("#editMasterFormContainer").append("</tr>");
                break;
                default:
                alert("Error");
                break;
        }
        
        jQuery("#editMasterFormContainer").append("<tr><td height='5px'/></tr>");
        jQuery("#editMasterFormContainer").append("<tr>");
        jQuery("#editMasterFormContainer").append("<td>&nbsp;&nbsp;<a href='#' id='editSubmit' onclick='addMasterForm();' class='myButton' type='Submit' style='height:14px;color: white!important;'>Add</a></td>");
        jQuery("#editMasterFormContainer").append("</tr>");
        jQuery("#editMasterFormContainer").append("</table>");
    }
    else {
        alert("Please choose a Master data entity");
    }
}

function editMasterData(id) {
    var type = jQuery("#masterType").val();
    $.getJSON(baseUrl+'loadMaster?typeid=' + type + '&id=' + id, function(responseJson) {
        
    	jQuery("#editMasterFormContainer").empty();
        jQuery("#editMasterFormContainer").append("<table>");
        jQuery("#editMasterFormContainer").append("<tr>");
        jQuery("#editMasterFormContainer").append("<td colspan='3'><b>Add Key Skill</b></td>");
        jQuery("#editMasterFormContainer").append("</tr>");
        jQuery("#editMasterFormContainer").append("<tr><td height='5px'/>");
        jQuery("#editMasterFormContainer").append("<td><input type='hidden' value='" + responseJson.id + "' name='id'/></td>");
        jQuery("#editMasterFormContainer").append("</tr>");
        
        //$.each(responseJson, function(index, item) {
            switch (type) {
                case "1":
                	jQuery("#editMasterFormContainer").append("<tr>");
                    jQuery("#editMasterFormContainer").append("<td>Skill Name:</td>");
                    jQuery("#editMasterFormContainer").append("<td><input type='text' value='" + responseJson.skill + "' name='skill'/></td>");
                    jQuery("#editMasterFormContainer").append("<td/>");
                    jQuery("#editMasterFormContainer").append("</tr>");
                    break;

                case "2":
                                    jQuery("#editMasterFormContainer").empty();
                                    jQuery("#editMasterFormContainer").append("<table>");
                                    jQuery("#editMasterFormContainer").append("<tr>");
                                    jQuery("#editMasterFormContainer").append("<td colspan='3'><b>Add Country Name</b></td>");
                                    jQuery("#editMasterFormContainer").append("</tr>");
                                    jQuery("#editMasterFormContainer").append("<tr><td height='5px'/></tr>");
                                    jQuery("#editMasterFormContainer").append("<tr>");
                                    jQuery("#editMasterFormContainer").append("<td>country name:</td>");
                                    jQuery("#editMasterFormContainer").append("<td><input type='text' value='" + responseJson.countryName + "' id='countryName' name='countryName'/></td>");
                                    jQuery("#editMasterFormContainer").append("<td/>");
                                    jQuery("#editMasterFormContainer").append("</tr>");
                                break;

                case "3":
                                jQuery("#editMasterFormContainer").empty();
                                jQuery("#editMasterFormContainer").append("<table>");
                                jQuery("#editMasterFormContainer").append("<tr>");
                                jQuery("#editMasterFormContainer").append("<td colspan='3'><b>Edit Analyst Preference </b></td>");
                                jQuery("#editMasterFormContainer").append("</tr>");
                                jQuery("#editMasterFormContainer").append("<tr><td height='5px'/></tr>");
                                jQuery("#editMasterFormContainer").append("<tr>");
                                jQuery("#editMasterFormContainer").append("<td>country name:</td>");
                                jQuery("#editMasterFormContainer").append("<td><input type='text' value='" + responseJson.preference + "' id='preference' name='preference'/></td>");
                                jQuery("#editMasterFormContainer").append("<td/>");
                                jQuery("#editMasterFormContainer").append("</tr>");
                                break;
                                
                            case "4":
                                jQuery("#editMasterFormContainer").empty();
                                jQuery("#editMasterFormContainer").append("<table>");
                                jQuery("#editMasterFormContainer").append("<tr>");
                                jQuery("#editMasterFormContainer").append("<td colspan='3'><b>Edit Company Title </b></td>");
                                jQuery("#editMasterFormContainer").append("</tr>");
                                jQuery("#editMasterFormContainer").append("<tr><td height='5px'/></tr>");
                                jQuery("#editMasterFormContainer").append("<tr>");
                                jQuery("#editMasterFormContainer").append("<td>Company Title:</td>");
                                jQuery("#editMasterFormContainer").append("<td><input type='text' value='" + responseJson.title + "'  id='title' name='title'/></td>");
                                jQuery("#editMasterFormContainer").append("<td/>");
                                jQuery("#editMasterFormContainer").append("</tr>");
                                break;
                                
                            case "5":
                                jQuery("#editMasterFormContainer").empty();
                                jQuery("#editMasterFormContainer").append("<table>");
                                jQuery("#editMasterFormContainer").append("<tr>");
                                jQuery("#editMasterFormContainer").append("<td colspan='3'><b>Edit Company Type </b></td>");
                                jQuery("#editMasterFormContainer").append("</tr>");
                                jQuery("#editMasterFormContainer").append("<tr><td height='5px'/></tr>");
                                jQuery("#editMasterFormContainer").append("<tr>");
                                jQuery("#editMasterFormContainer").append("<td>country name:</td>");
                                jQuery("#editMasterFormContainer").append("<td><input type='text' value='" + responseJson.type + "'  id='type' name='type'/></td>");
                                jQuery("#editMasterFormContainer").append("<td/>");
                                jQuery("#editMasterFormContainer").append("</tr>");
                                break;
                         
                                
                            case "6":
                                jQuery("#editMasterFormContainer").empty();
                                jQuery("#editMasterFormContainer").append("<table>");
                                jQuery("#editMasterFormContainer").append("<tr>");
                                jQuery("#editMasterFormContainer").append("<td colspan='3'><b>Edit Currency Name </b></td>");
                                jQuery("#editMasterFormContainer").append("</tr>");
                                jQuery("#editMasterFormContainer").append("<tr><td height='5px'/></tr>");
                                jQuery("#editMasterFormContainer").append("<tr>");
                                jQuery("#editMasterFormContainer").append("<td>country name:</td>");
                                jQuery("#editMasterFormContainer").append("<td><input type='text' value='" + responseJson.currencyName + "'  id='currencyName' name='currencyName'/></td>");
                                jQuery("#editMasterFormContainer").append("<td/>");
                                jQuery("#editMasterFormContainer").append("</tr>");
                                break;
                         
                            case "7":
                                jQuery("#editMasterFormContainer").empty();
                                jQuery("#editMasterFormContainer").append("<table>");
                                jQuery("#editMasterFormContainer").append("<tr>");
                                jQuery("#editMasterFormContainer").append("<td colspan='3'><b>Edit Industry Name </b></td>");
                                jQuery("#editMasterFormContainer").append("</tr>");
                                jQuery("#editMasterFormContainer").append("<tr><td height='5px'/></tr>");
                                jQuery("#editMasterFormContainer").append("<tr>");
                                jQuery("#editMasterFormContainer").append("<td>country name:</td>");
                                jQuery("#editMasterFormContainer").append("<td><input type='text' value='" + responseJson.name + "'  id='name' name='name'/></td>");
                                jQuery("#editMasterFormContainer").append("<td/>");
                                jQuery("#editMasterFormContainer").append("</tr>");
                                break;
                         
                            case "8":
                                jQuery("#editMasterFormContainer").empty();
                                jQuery("#editMasterFormContainer").append("<table>");
                                jQuery("#editMasterFormContainer").append("<tr>");
                                jQuery("#editMasterFormContainer").append("<td colspan='3'><b>Edit OCCUPATION Name </b></td>");
                                jQuery("#editMasterFormContainer").append("</tr>");
                                jQuery("#editMasterFormContainer").append("<tr><td height='5px'/></tr>");
                                jQuery("#editMasterFormContainer").append("<tr>");
                                jQuery("#editMasterFormContainer").append("<td>country name:</td>");
                                jQuery("#editMasterFormContainer").append("<td><input type='text' value='" + responseJson.name + "'  id='name' name='name'/></td>");
                                jQuery("#editMasterFormContainer").append("<td/>");
                                jQuery("#editMasterFormContainer").append("</tr>");
                                break;
                         
                            case "9":
                                jQuery("#editMasterFormContainer").empty();
                                jQuery("#editMasterFormContainer").append("<table>");
                                jQuery("#editMasterFormContainer").append("<tr>");
                                jQuery("#editMasterFormContainer").append("<td colspan='3'><b>Edit RESEARCH TYPE </b></td>");
                                jQuery("#editMasterFormContainer").append("</tr>");
                                jQuery("#editMasterFormContainer").append("<tr><td height='5px'/></tr>");
                                jQuery("#editMasterFormContainer").append("<tr>");
                                jQuery("#editMasterFormContainer").append("<td>country name:</td>");
                                jQuery("#editMasterFormContainer").append("<td><input type='text' value='" + responseJson.type + "'  id='type' name='type'/></td>");
                                jQuery("#editMasterFormContainer").append("<td/>");
                                jQuery("#editMasterFormContainer").append("</tr>");
                                break;
                         
                            case "10":
                                jQuery("#editMasterFormContainer").empty();
                                jQuery("#editMasterFormContainer").append("<table>");
                                jQuery("#editMasterFormContainer").append("<tr>");
                                jQuery("#editMasterFormContainer").append("<td colspan='3'><b>Edit TURNAROUND TIME </b></td>");
                                jQuery("#editMasterFormContainer").append("</tr>");
                                jQuery("#editMasterFormContainer").append("<tr><td height='5px'/></tr>");
                                jQuery("#editMasterFormContainer").append("<tr>");
                                jQuery("#editMasterFormContainer").append("<td>country name:</td>");
                                jQuery("#editMasterFormContainer").append("<td><input type='text' value='" + responseJson.time + "'  id='time' name='time'/></td>");
                                jQuery("#editMasterFormContainer").append("<td/>");
                                jQuery("#editMasterFormContainer").append("</tr>");
                                break;
                         
                            case "11":
                                jQuery("#editMasterFormContainer").empty();
                                jQuery("#editMasterFormContainer").append("<table>");
                                jQuery("#editMasterFormContainer").append("<tr>");
                                jQuery("#editMasterFormContainer").append("<td colspan='3'><b>Edit UNIT </b></td>");
                                jQuery("#editMasterFormContainer").append("</tr>");
                                jQuery("#editMasterFormContainer").append("<tr><td height='5px'/></tr>");
                                jQuery("#editMasterFormContainer").append("<tr>");
                                jQuery("#editMasterFormContainer").append("<td>country name:</td>");
                                jQuery("#editMasterFormContainer").append("<td><input type='text' value='" + responseJson.unit + "' id='unit' name='unit'/></td>");
                                jQuery("#editMasterFormContainer").append("<td/>");
                                jQuery("#editMasterFormContainer").append("</tr>");
                                break;
                         
                            case "12":
                                jQuery("#editMasterFormContainer").empty();
                                jQuery("#editMasterFormContainer").append("<table>");
                                jQuery("#editMasterFormContainer").append("<tr>");
                                jQuery("#editMasterFormContainer").append("<td colspan='3'><b>Edit UPDATE CYCLE </b></td>");
                                jQuery("#editMasterFormContainer").append("</tr>");
                                jQuery("#editMasterFormContainer").append("<tr><td height='5px'/></tr>");
                                jQuery("#editMasterFormContainer").append("<tr>");
                                jQuery("#editMasterFormContainer").append("<td>country name:</td>");
                                jQuery("#editMasterFormContainer").append("<td><input type='text' value='" + responseJson.cycle + "' id='cycle' name='cycle'/></td>");
                                jQuery("#editMasterFormContainer").append("<td/>");
                                jQuery("#editMasterFormContainer").append("</tr>");
                                break;
                         
                default:
                    alert("Error");
                    break;
            }
            jQuery("#editMasterFormContainer").append("<tr><td height='5px'/></tr>");
            jQuery("#editMasterFormContainer").append("<tr>");
            jQuery("#editMasterFormContainer").append("<td>&nbsp;&nbsp;<a href='#' id='editSubmit' onclick='updateMasterForm(" + responseJson.id + ");' class='myButton' type='Submit' style='height:14px;color: white!important;'>Update</a></td>");
            jQuery("#editMasterFormContainer").append("</tr>");
            jQuery("#editMasterFormContainer").append("</table>");
        //});
    });
}

function updateMasterForm(id) {
    //inlude these in ur dynmaic form masterType, Masterformaction, Value1*, Value2*
    var name = jQuery("#masterType").val();
    jQuery("#masterType").val(name);
    
    var url = baseUrl+"saveMaster?typeid="+name+"&id="+id;
    $.ajax({
        type: "POST",
        url: url,
        data: $("#editMasterForm").serialize(),
        success: function(data)
        {
            ////userSessionCheck(data);
            $("#MasterSuccess").html(data);
            $("#MasterError").html("");
            viewMasterData();
            //hideGeneralLoading();
        },
        error: function(data) {
            //userSessionCheck(data);
            $("#MasterError").html("Server Call Failed" + data);
            $("#MasterSuccess").html("");
        }
    });
    return false;
}

function addMasterForm() {
    //inlude these in ur dynmaic form masterType, Masterformaction, Value1*, Value2*
	var name = jQuery("#masterType").val();
	var value = jQuery("#Value11").val();
	/*if(value == null || value == ""){
		alert("Please Enter Value");
		jQuery("#Value11").focus();
	}else {*/
    //showGeneralLoading("Saving Master Data...");
    jQuery("#Masterformaction").val("addMaster");
    jQuery("#masterType").val(jQuery("#masterType").val());
    jQuery("#ID1").val("0");
    var url = baseUrl+"saveMaster?typeid="+name;
   
    $.ajax({
        type: "POST",
        url: url,
        data: $("#editMasterForm").serialize(),
        success: function(data)
        {
            ////userSessionCheck(data);
            $("#MasterSuccess").html(data);
            $("#MasterError").html("");
            viewMasterData();
            //hideGeneralLoading();
        },
        error: function(data) {
            ////userSessionCheck(data);
            $("#MasterError").html("Server Call Failed" + data);
            $("#MasterSuccess").html("");
        }
    });
	//}
    return false;
}


function deleteMasterData(id) {
	if(confirm("Comfirm to Delete.Press OK")){
    //showGeneralLoading("Deleting Master Data...");
    var type = jQuery("#masterType").val();
    //jQuery("#Masterformaction").val("delMaster");
    //jQuery("#masterType").val(jQuery("#masterType").val());
    //jQuery("#ID1").val(id);
    //alert(id);
    var url = baseUrl+"deleteMaster?id="+id+'&typeid='+type;

    $.ajax({
        type: "POST",
        url: url,
        //data: $("#editMasterForm").serialize(),
        success: function(data)
        {
           // //userSessionCheck(data);
            $("#MasterSuccess").html(data);
            $("#MasterError").html("");
            viewMasterData();
            //hideGeneralLoading();
        },
        error: function(data) {
            ////userSessionCheck(data);
            $("#MasterError").html("Server Call Failed" + data);
            $("#MasterSuccess").html("");
        }
    });
	}
    return false;
}


function loadCountryData(){
	$(document).ready(function() {
	$("#CountryName1").autocomplete({
	    source: CountryNameList,
	    select: function(event, ui) {
	        $("#CountryName1").val(ui.item.label);
	    },
	    change: function( event, ui ) {
	        if (!ui.item) {
	        	alert("No Country Available");
	        	 $("#CountryName1").val("");
	        }
	    },
	    open: function() {
	        $(this).removeClass("ui-corner-all").addClass("ui-corner-top");
	    },
	    close: function() {
	        $(this).removeClass("ui-corner-top").addClass("ui-corner-all");
	    },
	    minLength: 3
	});
	});
}

/*function masterTypeSelectionChange(){
	jQuery("#editMasterFormContainer").empty();
	$('#viewMasterGrid').dataTable().remove();
	 $('#viewMasterGrid').dataTable( {
		    "bFilter": false,
		    "bDestroy": true
		  } );
}*/