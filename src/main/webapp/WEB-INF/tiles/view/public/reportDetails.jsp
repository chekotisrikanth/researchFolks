<%@ page language="java"
    contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<article class="col-md-12 noPaddRL">
              <div class="contentWraper marginB20">
        <div class="row">
                  <div class="col-md-8">
            <div class="col-md-6 col-sm-12"> <span class="companyTitle noPaddL">${viewreport.report.reportTitle}</span>
                      <table width="90%" cellspacing="0" cellpadding="0" border="0" class="uniTableStyle">
                <tbody>
                          <tr>
                    <td>Title</td>
                    <td>${viewreport.report.reportTitle}</td>
                  </tr>
                          <tr>
                    <td>Author</td>
                    <td>${viewreport.reportAuthor.firstName}  ${viewreport.reportAuthor.lastName}</td>
                  </tr>
                          <tr>
                    <td>Publishing Datae is </td>
                    <td><fmt:formatDate value="${viewreport.report.publishingDate}" pattern="MM-dd-yyyy" /></td>
                  </tr>
                          <tr>
                    <td class="bigFont" colspan="2">${viewreport.report.price}</td>
                  </tr>
                        </tbody>
              </table>
                      <div class="col-md-12 marginB20">
                <a href="/secure/purchase/purchasereport.html?reportid=${viewreport.report.reportId}" class="btn btn-warning">Buy this Research</a>
              </div>
                    </div>
            <div class="col-md-6 col-sm-12"> <span class="descripTitle">Description of the Research</span>
                      <p>${viewreport.report.overview}</p>
                    </div>
            <div>&nbsp;</div>
            <div class="row">
              <div class="col-md-12">
                <ul class="nav nav-pills tabs">
                          <li class="active"><a data-toggle="pill" href="#toc">TOC</a></li>
                          <li><a data-toggle="pill" href="#synopsys">Synopsys</a></li>
                          <li><a data-toggle="pill" href="#reviews">Reviews</a></li>
                </ul>
                        
                        <div class="tab-content">
							  <div id="toc" class="tab-pane fade in active">
							    <p>${viewreport.report.tableOfContents}</p>
							  </div>
							  <div id="synopsys" class="tab-pane fade">
							    <p>${viewreport.report.overview}</p>
							  </div>
							  <div id="reviews" class="tab-pane fade">
							    <p>${customerreviews}</p>
							  </div>
						</div>
              </div>
                      <div class="col-md-12 border widthMinus">
                
              </div>
                    </div>
            <div>&nbsp;</div>
            <div class="col-md-12 borderB">
                      <h4>About Author</h4>
                    </div>
            <div class="authorContent col-md-12 marginT20 "> <a class="pull-left" href="#"> <img class="author-ava" src="http://tokokoodemo.us/raakbookoo/wp-content/themes/raakbookoo/img/avatar.png" alt="Author"> </a>
                      <p class="author-des">
                         <strong>${viewreport.reportAuthor.firstName}  ${viewreport.reportAuthor.lastName}
                          
                          </strong>${viewreport.reportAuthor.bio} </p>
                      <a target="_blank" href='/public/author/bio?authorId=${viewreport.reportAuthor.id}' class="readMore pull-right">Read More...</a> </div>
          </div>
                  <div class="col-md-4 latestPublications">
			            <h3>Latest Publishings</h3>
			            <c:forEach var="report" items="${viewreport.latestPublishings}">
			            <div class="latestPublGroup">
			                      <h4 class="title">${report.reportTitle}</h4>
			                      <p>$ ${report.price}</p>
			                      <p>Publishing Date: <fmt:formatDate value="${report.publishingDate}" pattern="MM-dd-yyyy" /></p>
			                      <div class="discrip">${report.overview}</div>
			                      <a href="/public/getReport/${report.reportId}" class="readMore">Read More...</a> 
			             </div>
			            </c:forEach> 
            
          		</div>
                </div>
      </div>
            </article>