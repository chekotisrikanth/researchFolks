<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<link rel="stylesheet" href="/css/master/master.css" type="text/css"/>
<!-- <script type="text/javascript" src="/makerm/js/cb/fiscalyear.js"></script> -->
<script type="text/javascript"
		src="//code.jquery.com/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="/js/master/masters.js"></script>

<!-- Grid Scripts -->
<link rel="stylesheet" href="/css/master/jquery.dataTables.css" type="text/css" />
<script type="text/javascript" language="javascript" src="/js/master/jquery.dataTables.js"></script>
<!-- Grid Scripts -->

<title>RM Maker - Masters</title>
<div class="toggle-box" align="left" id="accordionMastersReport" style="width: 92%; margin-left: 1%; margin-top: 0.5%;">
    <h3 class="toggle-title-full" style="font-size: 15px; font-family: Josefin; font-weight: bolder;">
        <img src = "/images/masters/anchor.png"/>
        Master Data&nbsp;<div id="MDError" style="font-weight: bolder; font-family: Josefin; font-size: 14px; color: orange; display: none;"></div>
    </h3>
    <div class="toggle-content-full">
        <table>
            <tr>
                <td style="font-size: 13px;"><b>Select Datatype</b></td>
                <td width="20px"/>
                <td style="font-size: 13px;"><b>View / Add / Edit / Delete Master Data</b></td>
            </tr>
            <tr><td height="10px"/></tr>
            <tr>
                <td>
                    <select id="masterType" name="masterType" style="width: 250px; font-size: 12px;" onchange="viewMasterData()">
                        <option value="-1">Choose...</option>
                        <option value="1">KEYSKILLS</option>
                        <option value="2">COUNTRIES</option>
                        <option value="3">ANALYST PREFERANCE</option>
                        <option value="4">COMPANY TITLE</option>
                        <option value="5">COMPANY TYPE</option>
                        <option value="6">CURRENCIES</option>
                        <option value="7">INDUSTRIES</option>
                        <option value="8">OCCUPATIONS</option>
                        <option value="9">RESEARCH TYPES</option>
                        <option value="10">TURN AROUND TIMES</option>
                        <option value="11">UNITS</option>
                        <option value="12">UPDATE CYCLES</option>
                    </select>
                </td>
                <td width="20px"/>
                <td>
                    <a href="#" onclick="viewMasterData();" style="cursor: pointer; text-decoration: none; font-size: 12px;">
                        <img style="vertical-align: bottom;" src="/images/masters/application_form.png"/> View
                    </a>&nbsp;&nbsp;
                    <a href="#" onclick="addMasterData();" style="cursor: pointer; text-decoration: none; font-size: 12px;">
                        <img style="vertical-align: bottom;" src="/images/masters/application_form_add.png"/> Add
                    </a>
                </td>
            </tr>
            <tr>
                <td height="30px">
                    <span id="MasterSuccess" name="MasterSuccess" style="color: green;font-size: 11px;"></span>
                    <span id="MasterError" name="MasterError" style="color: red;font-size: 11px;"></span>
                </td>
            </tr>
            <tr>
                <td/>
                <td width="20px"/>
                <td>
                    <div id="dynamic"></div>
                </td>
            </tr>
            <tr><td height="10px"/></tr>
            <tr>
                <td/>
                <td width="20px"/>
                <td>
                    <form:form id="editMasterForm" name ="editMasterForm" commandName="newmaster"  action="/secure/master/editMaster" method="POST" style="font-size: 13px;">
                        <div id="editMasterFormContainer" name ="editMasterFormContainer">
                        </div>
                    </form:form>
                </td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>