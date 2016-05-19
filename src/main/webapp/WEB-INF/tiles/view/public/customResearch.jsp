<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<link rel="stylesheet" href="/css/bootstrap-theme.css">
       <link rel="stylesheet" href="/css/bootstrap.css">
       <link rel="stylesheet" href="/css/customStyles.css">
       <link rel="stylesheet" href="/css/datepicker.min.css">
       <style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
<form:form method="POST" class="form-horizontal alignHCenter " action="/public/customresearch" commandpath="form" modelAttribute="form">
     
        <form:errors path="*" cssClass="errorblock" element="div" />
        	<div class="form-group">
            
            	<div class="col-md-2 boldTxt text-right">
                	<spring:message code="custm.research.researchType"/>
                </div>
                <div class="col-md-10">
                	<form:select id="researchType" path="researchType" class="form-control resType">
                    	<option selected value="company">Company Analysis</option>
                        <option value="industry">Industry Analysis</option>
                        <option value="others">Others</option>
                    </form:select>
                </div>
                <form:errors path="researchType"/>
            </div>
            <div class="form-group comapany">
            
            	<div class="col-md-2 boldTxt text-right">
            	<spring:message code="custm.research.companyTittle"/>
                </div>
                <div class="col-md-5"><form:input required="required"  id="companyTile" path="companyTile" type="text" class="form-control"/></div>
                <div class="col-md-1 boldTxt text-right">
                	<spring:message code="custm.research.webLink"/>
                </div>
                <div class="col-md-4"><form:input required="required" id="webLink" path="webLink" type="text" class="form-control"/></div>
                </div>
            <div class="form-group industry">
            
            	<div class="col-md-2 boldTxt text-right">
                	<spring:message code="custm.research.induTittle"/>
                </div>
                <div class="col-md-10">
                	<form:input required="required" id="industryTitle" path="industryTitle" type="text" class="form-control"/></div>
                
            </div>
            <%-- <div class="form-group others" style="display: none;">
            
            	<div class="col-md-2 boldTxt text-right">
                	<spring:message code="custm.research.nameyourResearch"/>
                </div>
                <div class="col-md-10">
                	<form:input required="required" id="" path="" type="text" class="form-control"/></div>
                
            </div>
             --%>
             <div class="form-group">
            
            	<div class="col-md-2 boldTxt text-right">
                	<spring:message code="custm.research.desp"/>
                </div>
                <div class="col-md-10">
                	<form:textarea required="required" id="description" path="description" class="form-control"></form:textarea>
                </div>
                
            </div>
             <div class="form-group">
            
            	<div class="col-md-2 boldTxt text-right">
                	<spring:message code="custm.research.requiredSkillSet"/>
                </div>
                <div class="col-md-10">
                	<div class="col-md-5 noPaddRL">
                	<select  class="form-control allSkills" multiple>
                    	<c:forEach items="${skills}" var="skill">
							<option   value="${skill.id}"  >${skill.skill}</option>
						</c:forEach>
                    </select></div>
                    <div class="col-md-1 paddT15">
                    	<a id="addSkill" class="alignHCenter " href="#" onClick="selectskill('Add')"><img alt="right arrow" src="/images/right-arrow2.png"></a>
                        <a id="addSkill" class="alignHCenter " href="#" onClick="selectskill('Remove')"><img alt="left arrow" src="/images/left-arrow-2.png"></a>
        			</div>
                    <div class="col-md-6 noPaddRL">
                    	<select id="reqSkillSet" path="reqSkillSet" class="form-control reqSkillSet" multiple="">
                    	</select>
                    </div>
                </div>
                
            </div>
            <div class="form-group">
            
            	<div class="col-md-2 boldTxt text-right">
                	<spring:message code="custm.research.paymentPractice"/>
                </div>
                <div class="col-md-2">
                	<form:select id="paymentType" path="paymentType" class="form-control">
                    <option>Hourly</option>
                    <option>Fixed Rate</option>
                    </form:select>
                </div>
                <div class="col-md-1">
                	<form:input required="required" path="paymentAmnt" type="text" placeholder="$000" class="form-control"/>
                </div>
                
            </div>
            
            <div class="form-group">
            
            	<div class="col-md-2 boldTxt text-right">
                	<spring:message code="custm.research.turnaroundTime"/>
                </div>
                <div class="col-md-10">
                	<form:select id="turnArndTime" path="turnArndTime" class="form-control">
                    	<option>One Day</option>
                        <option>Two Days</option>
                        <option>Three Days</option>
                        <option>Less than a week</option>
                    </form:select>
                </div>
                
            </div>
            
            <div class="form-group">
            
            	<div class="col-md-2 boldTxt text-right">
                	<spring:message code="custm.research.analystPreference"/>
                </div>
                <div class="col-md-10">
                	<select id="analystPrefe"  class="form-control analystPrefe">
                    	<option selected value="anyOne">Any one can apply</option>
                        <option value="onlyInvited">Only the one who i Invited</option>
                    </select>
                </div>
                
            </div>
            
            <div id="analysttableheading" style="display:none" class="row analystSer">
                     <div class="col-md-12"><h4 class="customeTiltels">Analyst Search</h4>
             </div>
             <div class="col-md-12">
                 <div class="form-group">
                	<div class="col-md-2 boldTxt text-right">
                        Country
                    </div>
                    <div class="col-md-2">
                    <select id="country" name="" class="form-control">
                        <option  selected value="any"  >Any</option>
                    	<c:forEach items="${countries}" var="country">
							<option   value="${country.countryId}"  >${country.countryName}</option>
						</c:forEach>
                    </select>
                    </div>
                    <div class="col-md-2 boldTxt text-right">
                        Years of Exp
                    </div>
                    <div class="col-md-2">
                    <select class="form-control">
						<option  selected value="any"  >Any</option>
                    	<option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                    </select>
                    </div>
                    <div class="col-md-4"> 
                    <input onClick="fillAnalystTable()" type="button" class="btn btn-primary buttonSmall sncButton pull-left">Search</input></div>
                </div>
             </div>
                     
            </div>
            <div id="analysttable">
            </div>
            <div class="form-group">
            <div class="col-md-12">
                         <button  type="submit" class="btn btn-primary btn-lg sncButton pull-right">Submit</button>
                    </div>
            </div>
            <%-- <jsp:include page="customResearchAuthorTable.jsp"></jsp:include> --%>
</form:form>      

<script src = "${pageContext.request.contextPath}/js/JqueryBase.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
		
<script type="text/javascript">

	$('#addSkill').click(function(){	
	//alert('k');
	//add skil
	var sourceList = "allSkills";
	var destList = "reqSkillSet";
	if($(this).text() === "Remove") {
		console.log("remove");
		sourceList = "reqSkillSet";
		destList = "allSkills";					
	} 				
	$("."+sourceList+" > option").each(function(index,object) {
		console.log($(object).prop('selected'));
		if($(object).prop('selected')) {						
			$("."+destList).append(object);
			//$(object).remove();
		}
	});
});	
	
	function selectskill(action) {
		var sourceList = "allSkills";
		var destList = "reqSkillSet";
		if(action === "Remove") {
			console.log("remove");
			sourceList = "reqSkillSet";
			destList = "allSkills";					
		} 				
		$("."+sourceList+" > option").each(function(index,object) {
			//console.log($(object).prop('selected'));
			if($(object).prop('selected')) {						
				$("."+destList).append(object);
				//$(object).remove();
			}
		});
	}

$('#searchByCntryAndYOE').click(function(){
	fillAnalystTable();
});

function fillAnalystTable() {
	var country = $('#country').val();
	var yoe = $('#yoe').val();
	var skills = $('#reqSkillSet').val();
	
	if(country=='undefined') {
		country = null;
	}
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
        url : "http://localhost:8080/public/loadauthors?country="+country+"&skills="+skills,
        success : function(html) {
        	$("#analysttable").html(html);
        },    

        error : function(xhr, ajaxOptions, thrownError) {
            //alert(xhr.status);
            //alert(thrownError);
        }
    });

}

$("#analystPrefe").change(function () {
    var selected = this.value;
    console.log(selected);
    if(selected==='onlyInvited') {
    	console.log(selected);
    	fillAnalystTable();
    	$("#analysttable").show();
    	$("#analysttableheading").show();
    }else {
    	$("#analysttable").hide();
    	$("#analysttableheading").hide();
    }
});



</script>