package com.marketing.tool.reponse.builder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.util.CollectionUtils;

import com.marketing.tool.domain.ReportForm;
import com.marketing.tool.vo.ReportVo;

public class ReportsSearchResponseBuilder {
	
	
	
	/**
	 * @param reports
	 * @return
	 */
	public static List<ReportVo> buildReports(Collection<ReportForm> reports ) {
		List<ReportVo> rep = null;
		
		if(CollectionUtils.isEmpty(reports)) {
			rep=new ArrayList<>(0);
		} else {
			rep=new ArrayList<>();
			for (ReportForm reportForm : reports) {
				ReportVo vo = new ReportVo();
				vo.setCountry(reportForm.getCountry());
				vo.setReportId(reportForm.getReportId());
				vo.setIndustry(reportForm.getIndustry());
				vo.setReportTitle(reportForm.getReportTitle());
				vo.setUserName(reportForm.getReportStatuses().get(0).getUser().getLastName()+" "+reportForm.getReportStatuses().get(0).getUser().getFirstName() );
				rep.add(vo);
			}
		}
		
		
		return rep;

    }
	
	
}
