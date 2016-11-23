<%--
  User: Ranga Reddy
  Date: 09/05/2015
  Time: 6:52 PM
  --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Key Skills List</title>
    <!-- Bootstrap CSS -->
    <%-- <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"> --%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <style type="text/css">
        .myrow-container {
            margin: 20px;
        }
    </style>
</head>
<body class=".container-fluid">
<div class="container myrow-container">
    <div class="panel panel-success">
        <div class="panel-heading">
            <h3 class="panel-title">
                <div align="left"><b>KeySkills List</b> </div>
                <div align="right"><a href="${pageContext.request.contextPath}/secure/master/createMaster?typeid=${typeid}">Add New KeySkill</a></div>
            </h3>
        </div>
        <div class="panel-body">
            <c:if test="${empty masterList}">
                There are no KeySkills
            </c:if>
            <c:if test="${not empty masterList}">   
            
                <form action="searchEmployee">
                    <div class="row">
                      <div class="col-md-6"><div class="col-md-6">Search KeySkill:</div><div class="col-md-6"> <input type="text" name="searchName" id="searchName"> </div></div>
                      <div class="col-md-4"><input class="btn btn-success" type='submit' value='Search'/></div>
                    </div>
                </form>             
                                
                <table class="table table-hover table-bordered">
                    <thead style="background-color: #bce8f1;">
                    <tr>
                        <th>Name</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${masterList}" var="keySkill">
                        <tr>
                            <th><c:out value="${keySkill.skill}"/></th>
                            <th><a href="${pageContext.request.contextPath}/secure/master/editMaster?typeid=${typeid}&id=<c:out value='${keySkill.id}'/>">Edit</a></th>
                            <th><a href="${pageContext.request.contextPath}/secure/master/deleteMaster?typeid=${typeid}&id=<c:out value='${keySkill.id}'/>">Delete</a></th>                          
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>    
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    
    <%-- <script src="<c:url value="/resources/js/jquery-2.1.3.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
     --%>

</body>
</html>