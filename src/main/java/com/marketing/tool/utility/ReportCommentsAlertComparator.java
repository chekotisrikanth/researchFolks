package com.marketing.tool.utility;

import java.util.Comparator;

import com.marketing.tool.domain.ReportCommentsAlert;

public class ReportCommentsAlertComparator implements Comparator<ReportCommentsAlert>{

	@Override
	public int compare(ReportCommentsAlert o1, ReportCommentsAlert o2) {	
	 if(o1.getReportId() == o2.getReportId()){
			 return 0;
	 } else { 
		return -1;
	 } 
	}
	
}
