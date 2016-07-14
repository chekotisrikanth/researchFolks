package com.marketing.tool.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.marketing.tool.domain.EditReports;
import com.marketing.tool.domain.ReportForm;
import com.marketing.tool.reponse.builder.ReportsSearchResponseBuilder;
import com.marketing.tool.repository.ReportSearchRepository;
import com.marketing.tool.service.ResearchReportsService;
import com.marketing.tool.utility.ReportSearchFilter;
import com.marketing.tool.utility.ReportStatusEnum;
import com.marketing.tool.vo.ReportVo;
import com.marketing.tool.vo.SearchCriteria;
@Service
public class ResearchReportsServiceImpl implements ResearchReportsService {

	@Autowired
	private ReportSearchRepository reportSearchRepository;
	
	

	@Override
	public EditReports getPublishedReportsFromSearchCriteria(SearchCriteria searchCriteria,int pageNumber,int results) {
		 PageRequest page = new PageRequest(pageNumber, results);
		
		
		 if( StringUtils.hasText(searchCriteria.getComIntl())) { 
			 if(Integer.parseInt(searchCriteria.getComIntl()) == 2) {
				 page = new PageRequest(pageNumber, results,new Sort(Sort.Direction.DESC, "comIntl"));
 
			 } else {
				 page = new PageRequest(pageNumber, results,new Sort(Sort.Direction.ASC, "comIntl"));

			 }
		 }
		searchCriteria.setStatusId(ReportStatusEnum.PUBLISHED.getValue());
		Page<ReportForm> form = reportSearchRepository.findAll(ReportSearchFilter.findByCriteriaForindustry(searchCriteria),page);
		EditReports editreports = new EditReports();
        editreports.setReportsList(ReportsSearchResponseBuilder.buildReports(form.getContent(),null,false));
        editreports.setTotalPages(form.getTotalPages());
        //sort if requried
      /* List<ReportVo> vo = editreports.getReportsList();
       if(!CollectionUtils.isEmpty(vo) && StringUtils.hasText(searchCriteria.getComIntl())) {
    	   List<ReportVo> sortingOne= new ArrayList<ReportVo> ();
    	   List<ReportVo> rest= new ArrayList<ReportVo> ();
    	   for (ReportVo reportVo : vo) {
    		   if(reportVo.getComIntl().equals(Integer.parseInt(searchCriteria.getComIntl()))) {
    			   sortingOne.add(reportVo);
    		   }else {
    			   rest.add(reportVo);
    		   }
           }
    	   if(!CollectionUtils.isEmpty(sortingOne)) {    		   
        	   editreports.setReportsList(sortingOne);
        	   editreports.getReportsList().addAll(rest);
    	   }
    	   
       }*/
       
       //sortig end
       
		return editreports;
	}
	
}
