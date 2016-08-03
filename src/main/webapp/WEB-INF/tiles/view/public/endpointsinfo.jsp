<%@ page language="java"
    contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<div class="container">
  <h1>Report Matter Endpoints</h1>
  <table class="table table-striped">
  <c:forEach items="${handlerMethods}" var="entry">
    <tbody>
      <tr>
        <td><c:if test="${not empty entry.key.patternsCondition.patterns}">
               <c:forEach items="${entry.key.patternsCondition.patterns}" var="pattern"> 
                        <a href="${pattern}" > ${pattern}</a>
               </c:forEach> 
          </c:if>
        </td>
        <td>${entry.value}</td>
      </tr>
   </c:forEach>    
    </tbody>
  </table>
</div>
     
     
     